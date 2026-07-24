package dev.equo.ewt.internal;

import java.lang.foreign.*;
import java.lang.invoke.MethodHandle;
import static java.lang.foreign.ValueLayout.*;

/**
 * Hand-written FFM binder for the same-surface attach entry: registers the EWT
 * build callback into the (single, shared) libwidgets, without creating any engine
 * or view. Evolve owns/loads the engine; EWT only attaches via {@code setBuildWidgetTree}.
 */
public final class EmbedBridge {
    private EmbedBridge() {}

    private static final SymbolLookup LOOKUP = SymbolLookup.loaderLookup()
            .or(Linker.nativeLinker().defaultLookup());

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
}
