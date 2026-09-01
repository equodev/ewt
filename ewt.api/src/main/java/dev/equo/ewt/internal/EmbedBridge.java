package dev.equo.ewt.internal;

import java.lang.foreign.*;
import java.lang.invoke.MethodHandle;
import static java.lang.foreign.ValueLayout.*;

/**
 * Hand-written FFM binder for the same-surface attach entry: registers the EWT
 * build callback into the (single, shared) libwidgets, without creating any engine
 * or view. Evolve owns/loads the engine; EWT only attaches via {@code setBuildWidgetTree}.
 *
 * <p>Also hosts setters for the post-frame and Flutter-error upcall pointers that
 * {@code EngineHandle} installs at engine-boot time.  These symbols are in widgets.c
 * (the FFI plugin), not in Starter.h, so they are not produced by jextract; they are
 * bound here by hand using the same pattern as {@code setBuildWidgetTree}.
 */
public final class EmbedBridge {
    private EmbedBridge() {}

    private static final SymbolLookup LOOKUP = SymbolLookup.loaderLookup()
            .or(Linker.nativeLinker().defaultLookup());

    // -------------------------------------------------------------------------
    // setBuildWidgetTree
    // -------------------------------------------------------------------------

    // void setBuildWidgetTree(buildWidgetTreeFn fn) — attach mode: register the Java
    // builder into the (single, EWT-owned) libwidgets, without creating any view.
    private static final FunctionDescriptor SET_DESC = FunctionDescriptor.ofVoid(ADDRESS);
    private static final MethodHandle SET = Linker.nativeLinker().downcallHandle(
            LOOKUP.find("setBuildWidgetTree").orElseThrow(
                    () -> new UnsatisfiedLinkError("Native symbol not found: setBuildWidgetTree")),
            SET_DESC);

    /**
     * Installs the ONE native build callback for the whole process. The callback carries the
     * region id — {@code buildWidgetTreeFn} is {@code int(WidgetFactories*, int regionId)} —
     * so a single dispatcher serves every region; per-region routing is by that id (see
     * {@code App.registerBuilder(int, ...)}), not by a per-widget setter. Install once.
     */
    public static void setBuildWidgetTree(MemorySegment buildWidgetTreeFn) {
        try {
            SET.invokeExact(buildWidgetTreeFn);
        } catch (Throwable t) {
            throw new RuntimeException("setBuildWidgetTree failed", t);
        }
    }

    // -------------------------------------------------------------------------
    // setPostFrameCallback
    // -------------------------------------------------------------------------

    // void setPostFrameCallback(postFrameFn fn)
    private static final FunctionDescriptor SET_POST_FRAME_DESC = FunctionDescriptor.ofVoid(ADDRESS);
    private static final MethodHandle SET_POST_FRAME = Linker.nativeLinker().downcallHandle(
            LOOKUP.find("setPostFrameCallback").orElseThrow(
                    () -> new UnsatisfiedLinkError("Native symbol not found: setPostFrameCallback")),
            SET_POST_FRAME_DESC);

    /**
     * Registers a Java upcall segment as the native post-frame callback.
     * After this call, Dart's {@code callPostFrameCallback} trampoline will invoke the
     * segment on every armed frame capture, delivering the element-tree JSON to Java.
     *
     * @param postFrameFn a {@code MemorySegment} returned by
     *     {@code postFrameFn.allocate(fn, arena)} — must stay alive for the engine lifetime.
     */
    public static void setPostFrameCallback(MemorySegment postFrameFn) {
        try {
            SET_POST_FRAME.invokeExact(postFrameFn);
        } catch (Throwable t) {
            throw new RuntimeException("setPostFrameCallback failed", t);
        }
    }

    // -------------------------------------------------------------------------
    // setFlutterErrorCallback
    // -------------------------------------------------------------------------

    // void setFlutterErrorCallback(flutterErrorFn fn)
    private static final FunctionDescriptor SET_FLUTTER_ERROR_DESC = FunctionDescriptor.ofVoid(ADDRESS);
    private static final MethodHandle SET_FLUTTER_ERROR = Linker.nativeLinker().downcallHandle(
            LOOKUP.find("setFlutterErrorCallback").orElseThrow(
                    () -> new UnsatisfiedLinkError("Native symbol not found: setFlutterErrorCallback")),
            SET_FLUTTER_ERROR_DESC);

    /**
     * Registers a Java upcall segment as the native Flutter-error callback.
     * After this call, Dart's {@code callFlutterErrorCallback} trampoline will invoke the
     * segment whenever Flutter's error handler fires.
     *
     * @param flutterErrorFn a {@code MemorySegment} returned by
     *     {@code flutterErrorFn.allocate(fn, arena)} — must stay alive for the engine lifetime.
     */
    public static void setFlutterErrorCallback(MemorySegment flutterErrorFn) {
        try {
            SET_FLUTTER_ERROR.invokeExact(flutterErrorFn);
        } catch (Throwable t) {
            throw new RuntimeException("setFlutterErrorCallback failed", t);
        }
    }
}
