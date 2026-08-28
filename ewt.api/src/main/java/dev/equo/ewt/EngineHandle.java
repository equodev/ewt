package dev.equo.ewt;

import dev.equo.ewt.ffm.StarterBridge;
import dev.equo.ewt.ffm.StarterOpts;
import dev.equo.ewt.ffm.WidgetFactories;
import dev.equo.ewt.ffm.buildWidgetTreeFn;
import dev.equo.ewt.ffm.flutterErrorFn;
import dev.equo.ewt.ffm.postFrameFn;
import dev.equo.ewt.internal.EmbedBridge;

import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;

/**
 * Lifecycle handle for the shared Flutter engine used by the native render test harness.
 *
 * <p>One instance is created per JVM (the ADR mandates a single shared engine); it owns
 * the three FFM upcall segments (build, post-frame, error) allocated in a
 * {@link Arena#ofShared()} that is intentionally never closed — closing it while the C side
 * still holds the segment addresses would corrupt the engine.  This is safe because there is
 * exactly one engine per process (documented in ADR-0009).
 *
 * <h2>Threading contract</h2>
 * <ul>
 *   <li>{@link #run()} blocks the calling thread for the engine lifetime — call it from a
 *       dedicated thread (e.g. {@code Thread.ofPlatform().start(engine::run)}).</li>
 *   <li>{@link #requestRebuild()} and {@link #requestShutdown()} are safe to call from any
 *       thread; they delegate directly to the C-side helpers which hop to the GTK/UI thread
 *       internally via {@code g_main_context_invoke}.</li>
 *   <li>The post-frame and error upcalls are delivered on Dart's UI thread (the Flutter
 *       engine's scheduler thread). {@link PostFrameNotifier} and
 *       {@link FlutterErrorCollector} are designed to accept concurrent writes from that
 *       thread while test threads read concurrently.</li>
 * </ul>
 *
 * <h2>Thread-safety note on requestRebuild</h2>
 * When Java calls {@link #requestRebuild()}, the C side ({@code Starter.cc}) uses
 * {@code g_main_context_invoke} to post the work to the GTK main loop — which IS Flutter's
 * UI thread.  Dart's {@code _onRebuildRequested} therefore executes on the UI thread, making
 * the {@code ValueNotifier.value} mutation thread-safe with no additional synchronisation.
 */
public final class EngineHandle {

    static {
        // Ensure the native libraries (libStarter, libwidgets, libapp) are loaded before
        // any FFM upcall or downcall resolves against symbols in them.  App.java has the
        // same guard for the App.runApp() path; EngineHandle is the parallel entrypoint
        // used by the native render test harness and must not depend on App being loaded.
        NativeLibLoader.load();
    }

    private final Supplier<Widget> rootSupplier;
    private final PostFrameNotifier postFrames;
    private final FlutterErrorCollector errors;
    private final CompletableFuture<Void> firstFrame = new CompletableFuture<>();

    // Shared arena — kept alive for the full process lifetime so the C side can invoke
    // the upcall stubs at any time. Intentionally not closed (see class-level Javadoc).
    private final Arena arena = Arena.ofShared();

    /**
     * Set by the build upcall whenever {@code rootSupplier.get().build()} throws — a
     * caller-visible signal that the last rebuild couldn't produce a widget.  The
     * harness (Phase 5 {@code FlutterRenderTestBase.mountAndCapture}) reads and
     * clears it after each mount so a broken variant fails ITS test without
     * poisoning subsequent variants' state.  Static so all callers of the same
     * process-wide engine see the same handle.
     */
    public static final java.util.concurrent.atomic.AtomicReference<Throwable> lastBuildFailure =
            new java.util.concurrent.atomic.AtomicReference<>();

    /**
     * Creates an {@code EngineHandle}.
     *
     * @param rootSupplier produces the root {@link Widget} on each rebuild; invoked from
     *                     the engine's FFM upcall thread
     * @param postFrames   receives post-frame notifications; must be the same instance
     *                     exposed to test code so tests can call {@code awaitFrameAfter}
     * @param errors       accumulates Flutter framework errors; must be the same instance
     *                     exposed to test code so tests can call {@code errorsBetween}
     */
    public EngineHandle(Supplier<Widget> rootSupplier,
                        PostFrameNotifier postFrames,
                        FlutterErrorCollector errors) {
        this.rootSupplier = rootSupplier;
        this.postFrames   = postFrames;
        this.errors       = errors;
    }

    /**
     * Returns a future that completes with {@code null} the first time any post-frame
     * notification arrives (including the bootstrap frame with {@code frameId=0} and
     * an empty snapshot that engine_hooks.dart unconditionally pushes at first render).
     */
    public CompletableFuture<Void> firstFrameReady() {
        return firstFrame;
    }

    /**
     * Starts the Flutter engine and blocks until it exits.  Must be called from a
     * dedicated platform thread (not the JUnit test thread).
     *
     * <p>Allocates the three FFM upcall segments in {@link #arena}, registers the
     * post-frame and error callbacks via {@link EmbedBridge}, then calls
     * {@code startApp(opts)}.  The rebuild-handler registration is performed by the
     * Dart side in {@code attachEngineHooks} — Java triggers rebuilds via
     * {@link #requestRebuild()}, which calls {@code Starter_requestRebuild()} to post
     * the work back to Dart through the C trampoline.
     */
    public void run() {
        // --- 1. Build-widget-tree upcall ---
        MemorySegment buildFn = buildWidgetTreeFn.allocate(
                (MemorySegment widgetFactories, int regionId) -> {
                    WidgetConstructors.instance.set(
                            WidgetFactories.reinterpret(widgetFactories, arena, ms -> {}));
                    try {
                        Widget w = rootSupplier.get().build();
                        return ((NativeObj) w).getId();
                    } catch (Throwable t) {
                        // A rootSupplier throw would propagate back across the FFM
                        // upcall into Dart, corrupt the isolate, and kill every
                        // subsequent test.  Stash the failure for the harness to
                        // surface, and render an empty SizedBox so the engine keeps
                        // living.  Same fallback pattern as App.installDispatcher's
                        // no-builder path.
                        lastBuildFailure.set(t);
                        return ((NativeObj) dev.equo.ewt.EWT.SizedBox().build()).getId();
                    }
                }, arena);

        // --- 2. Post-frame upcall ---
        // The raw C pointer arrives with size 0; reinterpret with the known byte count
        // (plus one for the null terminator) so getString can read it safely.
        MemorySegment postFn = postFrameFn.allocate(
                (long frameId, MemorySegment snapshotPtr, int snapshotLen) -> {
                    String json = snapshotPtr
                            .reinterpret(snapshotLen + 1L)
                            .getString(0, StandardCharsets.UTF_8);
                    postFrames.onFrame(frameId, json);
                    firstFrame.complete(null);   // idempotent after first call
                }, arena);

        // --- 3. Flutter-error upcall ---
        // kind, message, stack are null-terminated C strings with no explicit length;
        // reinterpret with Long.MAX_VALUE so getString can scan for the terminator.
        MemorySegment errFn = flutterErrorFn.allocate(
                (long frameId, MemorySegment kindPtr, MemorySegment msgPtr, MemorySegment stkPtr) -> {
                    String kind = kindPtr.reinterpret(Long.MAX_VALUE).getString(0);
                    String msg  = msgPtr .reinterpret(Long.MAX_VALUE).getString(0);
                    String stk  = stkPtr .reinterpret(Long.MAX_VALUE).getString(0);
                    errors.onError(new FlutterErrorRecord(frameId, kind, msg, stk));
                }, arena);

        // Register the two Java-destination callbacks in widgets.c so that Dart's
        // callPostFrameCallback / callFlutterErrorCallback trampolines reach Java.
        // The rebuild handler is registered by Dart (attachEngineHooks) via
        // setRebuildHandler — Java is not involved in that direction.
        EmbedBridge.setPostFrameCallback(postFn);
        EmbedBridge.setFlutterErrorCallback(errFn);

        // Boot the engine. StarterOpts carries the build function; the post-frame and
        // error pointers in StarterOpts are unused here (we go via the widgets.c setters
        // instead) so they are set to NULL for the standalone-app path.
        try (Arena optsArena = Arena.ofConfined()) {
            MemorySegment opts = StarterOpts.allocate(optsArena);
            StarterOpts.buildWidgetTree(opts, buildFn);
            StarterOpts.onPostFrame(opts, MemorySegment.NULL);
            StarterOpts.onFlutterError(opts, MemorySegment.NULL);
            int r = StarterBridge.startApp(opts);
            if (r != 0) throw new RuntimeException("startApp returned " + r);
        }
    }

    /**
     * Requests a Flutter rebuild.  Returns immediately; the rebuild runs asynchronously
     * on the GTK/UI thread.  Thread-safe.
     */
    public void requestRebuild() {
        StarterBridge.Starter_requestRebuild();
    }

    /**
     * Signals the engine to shut down cleanly.  Returns immediately; {@link #run()} will
     * unblock after the engine exits.  Thread-safe.
     */
    public void requestShutdown() {
        StarterBridge.Starter_requestShutdown();
    }
}
