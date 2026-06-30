package dev.equo.ewt;

import dev.equo.ewt.ffm.StarterBridge;
import dev.equo.ewt.ffm.WidgetFactories;
import dev.equo.ewt.ffm.buildWidgetTreeFn;

import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;
import java.util.concurrent.Callable;

public class App {
    static {
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
