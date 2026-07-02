package dev.equo.ewt;

import dev.equo.ewt.ffm.EmbedBridge;
import dev.equo.ewt.ffm.StarterBridge;
import dev.equo.ewt.ffm.WidgetFactories;
import dev.equo.ewt.ffm.buildWidgetTreeFn;

import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;
import java.util.concurrent.Callable;

public class App {
    static {
        // Attach mode (EWT↔Evolve same-surface): Evolve owns and already loaded the
        // Flutter engine (libflutter_linux_gtk + bridge). We load ONLY the combined
        // bundle's libwidgets.so — the SAME copy the engine runs — so its
        // setBuildWidgetTree/callToBuildWidgetTree symbols resolve to one instance and
        // the FFM callback connects. No libStarter (no engine/window spawn here).
        String attachLibwidgets = System.getProperty("ewt.attach.libwidgets");
        if (attachLibwidgets != null) {
            System.load(attachLibwidgets);
        } else {
            NativeLibLoader.load();
        }
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

    /**
     * Attach mode (same-surface): registers the EWT widget builder into the single,
     * EWT-owned libwidgets WITHOUT creating any engine/view. The host engine (Evolve's)
     * runs the Dart side, whose EWT region calls {@code callToBuildWidgetTree}, which
     * invokes this builder. Used by {@code EwtWidget.setWidget}.
     */
    public static void registerBuilder(Callable<Widget> builder) {
        MemorySegment ffmFn = buildWidgetTreeFn.allocate((MemorySegment widgetFactories) -> {
            try {
                WidgetConstructors.instance.set(
                    WidgetFactories.reinterpret(widgetFactories, Arena.ofShared(), ms -> {}));
                Widget w = builder.call().build();
                return ((NativeObj) w).getId();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }, Arena.ofShared());
        EmbedBridge.setBuildWidgetTree(ffmFn);
    }

    private void run() {
        MemorySegment ffmFn = buildWidgetTreeFn.allocate((MemorySegment widgetFactories)  -> {
            try {
                WidgetConstructors.instance.set(WidgetFactories.reinterpret(widgetFactories, Arena.ofShared(), (ms) -> {}));
                Widget w = builderFn.call().build();
                return ((NativeObj) w).getId();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }, Arena.ofShared());
        int r = StarterBridge.startApp(ffmFn);
        if (r != 0)
            throw new RuntimeException("Could not startup EWT app, error: "+r);
    }
}
