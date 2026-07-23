package dev.equo.ewt;

import dev.equo.ewt.internal.EmbedBridge;
import dev.equo.ewt.ffm.StarterBridge;
import dev.equo.ewt.ffm.WidgetFactories;
import dev.equo.ewt.ffm.buildWidgetTreeFn;

import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;

public class App {
    static {
        // NativeLibLoader picks the right libraries per-OS: the full EWT set for a
        // standalone app, or — in EWT↔Evolve attach mode — ONLY the combined bundle's
        // libwidgets (the copy Evolve's engine runs). See NativeLibLoader.load().
        NativeLibLoader.load();
    }

    private final Callable<Widget> builderFn;

    App(Callable<Widget> widget) {
        this.builderFn = widget;
    }

    static boolean isMac() {
        String osName = System.getProperty("os.name").toLowerCase();
        return osName.contains("mac");
    }

    public static void runApp(Callable<Widget> widgetBuilder) {
        new App(widgetBuilder).run();
    }

    // Per-region builders, keyed by the hosting EwtWidget's id (its SWT widget id,
    // which equals the Dart region's value.id). Multiple EwtWidget regions coexist:
    // each registers its own builder here, and the single native callback dispatches
    // to the right one by regionId. A ConcurrentHashMap because registration (SWT
    // thread) and dispatch (Flutter engine thread) can touch it from different threads.
    private static final Map<Integer, Callable<Widget>> builders = new ConcurrentHashMap<>();

    // The one native build callback, allocated lazily and kept alive for the process.
    // It stays a single upcall; regionId (not a fresh callback per region) is what
    // selects the builder, so registering a new region never overwrites another.
    private static volatile MemorySegment dispatcher;

    /**
     * Attach mode (same-surface): registers the EWT widget builder for one region into
     * the single, EWT-owned libwidgets WITHOUT creating any engine/view. The host engine
     * (Evolve's) runs the Dart side, whose EWT region calls
     * {@code callToBuildWidgetTree(factories, regionId)}; the native callback dispatches
     * to the builder registered here under the same {@code id}. Used by
     * {@code EwtWidget.setWidget}.
     *
     * @param id      the region's id (the hosting EwtWidget's SWT widget id), which
     *                matches the Dart region's {@code value.id}
     * @param builder builds the EWT widget subtree for that region
     */
    public static void registerBuilder(int id, Callable<Widget> builder) {
        builders.put(id, builder);
        installDispatcher();
    }

    /**
     * Drops the builder for a region (called when its {@code EwtWidget} is disposed) so
     * the registry does not accumulate stale entries. The single dispatcher upcall stays
     * installed — it simply has one fewer id to serve.
     */
    public static void unregisterBuilder(int id) {
        builders.remove(id);
    }

    private static synchronized void installDispatcher() {
        if (dispatcher != null) return;
        dispatcher = buildWidgetTreeFn.allocate((MemorySegment widgetFactories, int regionId) -> {
            try {
                WidgetConstructors.instance.set(
                    WidgetFactories.reinterpret(widgetFactories, Arena.ofShared(), ms -> {}));
                Callable<Widget> builder = builders.get(regionId);
                if (builder == null) {
                    // No builder for this id: the region built before setWidget ran, or a
                    // dispose/teardown race (the builder was just unregistered while the Dart
                    // region rebuilt). Render empty instead of throwing — an exception across
                    // the FFM upcall boundary can't be caught by the Dart region and could
                    // abort the process.
                    return ((NativeObj) EWT.SizedBox().build()).getId();
                }
                Widget w = builder.call().build();
                return ((NativeObj) w).getId();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }, Arena.ofShared());
        EmbedBridge.setBuildWidgetTree(dispatcher);
    }

    private void run() {
        Callable<Widget> wrappedBuilder = () -> new dev.equo.ewt.internal.HotReloadRoot(builderFn);
        // Standalone flow: one app, no regions. regionId is unused here (the Dart side
        // calls callToBuildWidgetTree with the default 0).
        MemorySegment ffmFn = buildWidgetTreeFn.allocate((MemorySegment widgetFactories, int regionId)  -> {
            try {
                WidgetConstructors.instance.set(WidgetFactories.reinterpret(widgetFactories, Arena.ofShared(), (ms) -> {}));
                Widget w = wrappedBuilder.call().build();
                return ((NativeObj) w).getId();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }, Arena.ofShared());
        int r = StarterBridge.startApp(ffmFn);
        if (r != 0)
            throw new RuntimeException("Could not startup EWT app, error: " + r);
    }
}
