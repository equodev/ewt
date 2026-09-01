package dev.equo.ewt;

import dev.equo.ewt.support.FlutterRenderException;
import dev.equo.ewt.support.TreeSnapshot;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.condition.EnabledIfSystemProperty;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Supplier;

import static dev.equo.ewt.EWT.*;
import static java.util.concurrent.TimeUnit.SECONDS;

/**
 * Shared engine lifecycle for the native render test suite.  One Flutter engine per JVM;
 * subclasses call {@link #mountAndCapture(Callable)} per variant.  The engine boots in
 * {@code @BeforeAll} and shuts down via a JVM shutdown hook; the root widget is swapped via
 * {@link dev.equo.ewt.internal.HotReloadRoot#setUserBuilder(Callable)} without touching
 * the engine.
 *
 * <p>Gated by {@code @Tag("native")}; opt in with {@code -DrunNativeTests=1}.  Local dev
 * runs without native/Flutter/xvfb; CI runs under {@code xvfb-run -a}.
 *
 * <p>Recovery policy (per ADR § 6):
 * <ul>
 *   <li>Builder throw or captured FlutterError: {@link FlutterRenderException} — engine survives.</li>
 *   <li>Per-variant timeout of 5s.  After 3 consecutive timeouts the engine is considered
 *       wedged, remaining variants are marked skipped by throwing, and shutdown fires.</li>
 *   <li>Native crash: JVM dies, CI job fails red, {@code hs_err_pid*.log} uploaded.</li>
 * </ul>
 */
@Tag("native")
@EnabledIfSystemProperty(named = "runNativeTests", matches = ".+")
public abstract class FlutterRenderTestBase {

    protected static EngineHandle engine;
    protected static PostFrameNotifier postFrames;
    protected static FlutterErrorCollector errors;

    private static Thread engineThread;
    private static int consecutiveTimeouts = 0;
    private static final int MAX_CONSECUTIVE_TIMEOUTS = 3;

    private static final AtomicReference<Supplier<Widget>> currentRoot = new AtomicReference<>();

    /**
     * The last variant Widget constructed by {@link #mountAndCapture(Callable)}.
     * Set from the engine thread inside the HotReloadRoot builder (where Dart
     * FFI is safe), read from the JUnit test thread for getter round-trip
     * verification.  Round-trip cannot call the factory a second time from the
     * test thread because Java→Dart FFI downcalls require the isolate on the
     * calling thread, and Flutter Linux runs the isolate on a separate thread —
     * `Cannot invoke native callback outside an isolate` (SIGABRT) otherwise.
     */
    protected static final java.util.concurrent.atomic.AtomicReference<Widget> lastMountedVariant =
        new java.util.concurrent.atomic.AtomicReference<>();

    @BeforeAll
    static synchronized void bootEngine() throws Exception {
        // Idempotent: JUnit 5 fires @BeforeAll for every subclass, but Flutter/GTK
        // cannot be reinitialised in the same JVM once startApp has returned.  Boot
        // once on the first subclass to run, and register the shutdown as a JVM
        // shutdown hook — not @AfterAll — so subsequent subclasses reuse the same
        // engine and the engine outlives the boundary between test classes.
        if (engine != null) return;

        postFrames = new PostFrameNotifier();
        errors = new FlutterErrorCollector();

        // Sterile initial root — a bare SizedBox until the first variant mounts.
        currentRoot.set(() -> SizedBox().build());
        dev.equo.ewt.internal.HotReloadRoot.setUserBuilder(() -> wrapVariant(currentRoot.get().get()));

        // Test-only fallback: if a variant's construction throws (e.g. an
        // over-eager Positioned that doesn't set its required `child`), stash the
        // failure and render an empty SizedBox instead of tearing down the
        // shared engine.  The next call to mountAndCapture surfaces the throwable
        // as an AssertionError against THAT specific variant.
        dev.equo.ewt.internal.HotReloadRoot.setErrorFallback(t -> {
            EngineHandle.lastBuildFailure.set(t);
            return SizedBox().build();
        });

        // The rootSupplier wraps a fresh HotReloadRoot on every call, mirroring App.run().
        // Each variant is nested inside a MaterialApp(home:) so ambient inheriteds
        // (Directionality, MediaQuery, Theme, Navigator) are present — text-based widgets
        // in particular call Directionality.of(context) with a non-null assertion and would
        // otherwise crash with `_TypeError: Null check operator used on a null value`.
        Supplier<Widget> engineRoot = () -> new dev.equo.ewt.internal.HotReloadRoot(
            () -> wrapVariant(currentRoot.get().get()));

        engine = new EngineHandle(engineRoot, postFrames, errors);
        engineThread = new Thread(engine::run, "ewt-engine");
        engineThread.setDaemon(true);
        engineThread.start();

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            try { engine.requestShutdown(); } catch (Throwable ignored) {}
        }, "ewt-engine-shutdown"));

        engine.firstFrameReady().get(30, SECONDS);
    }

    /** Wraps a variant widget in the minimum ambient scaffold Flutter needs to render it. */
    private static Widget wrapVariant(Widget variant) {
        return MaterialApp.materialApp().home(variant).build();
    }

    private static String rootCauseMessage(Throwable t) {
        Throwable c = t;
        while (c.getCause() != null && c.getCause() != c) c = c.getCause();
        return c.getClass().getSimpleName() + ": " + c.getMessage();
    }

    /**
     * Mount [variant] as the root, wait for the post-frame notification, and return the
     * captured snapshot.
     *
     * @throws FlutterRenderException if Flutter reported any error during the frame window.
     * @throws java.util.concurrent.TimeoutException wrapped in RuntimeException if the frame
     *   never arrives within 5 seconds.
     */
    protected static TreeSnapshot mountAndCapture(Callable<Widget> variant) throws Exception {
        long pre = postFrames.lastFrameId();
        EngineHandle.lastBuildFailure.set(null);
        lastMountedVariant.set(null);
        currentRoot.set(() -> {
            try {
                Widget w = variant.call();
                lastMountedVariant.set(w);
                return w;
            } catch (Exception e) { throw new RuntimeException(e); }
        });

        CompletableFuture<PostFrame> ready = postFrames.awaitFrameAfter(pre);
        engine.requestRebuild();

        PostFrame pf;
        try {
            pf = ready.get(5, SECONDS);
            consecutiveTimeouts = 0;
            // Surface build-side failures (e.g. Immutables required-attribute
            // violations from an over-eager variant emission) with the variant's
            // context — otherwise the assertion downstream would say "widget X
            // not in tree" without hinting at the real root cause.
            Throwable buildFail = EngineHandle.lastBuildFailure.getAndSet(null);
            if (buildFail != null) {
                throw new AssertionError("variant builder threw: " + rootCauseMessage(buildFail), buildFail);
            }
        } catch (java.util.concurrent.TimeoutException e) {
            consecutiveTimeouts++;
            if (consecutiveTimeouts >= MAX_CONSECUTIVE_TIMEOUTS) {
                engine.requestShutdown();
                throw new RuntimeException(
                    "engine wedged after " + MAX_CONSECUTIVE_TIMEOUTS + " consecutive timeouts", e);
            }
            throw new RuntimeException("timed out waiting for post-frame (variant " + (consecutiveTimeouts) + "/3)", e);
        }

        List<FlutterErrorRecord> errs = errors.errorsBetween(pre, pf.frameId());
        if (!errs.isEmpty()) throw new FlutterRenderException(errs);

        // Cooldown: swap to a sterile SizedBox and wait one frame before returning so
        // Dart tickers/animations from this variant can dispose before the next mount.
        long cooldownPre = pf.frameId();
        currentRoot.set(() -> SizedBox().build());
        CompletableFuture<PostFrame> cooled = postFrames.awaitFrameAfter(cooldownPre);
        engine.requestRebuild();
        try { cooled.get(2, SECONDS); }
        catch (java.util.concurrent.TimeoutException ignored) { /* best-effort cooldown */ }

        return TreeSnapshot.parse(pf.snapshotJson());
    }
}
