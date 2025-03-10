package dev.equo.ewt;

import dev.equo.ewt.ffm.StarterBridge;
import dev.equo.ewt.ffm.WidgetFactories;
import dev.equo.ewt.ffm.buildWidgetTreeFn;

import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;
import java.nio.file.Path;
import java.util.concurrent.Callable;

public class App {
    static {
        var mode = "Release";
        String p = "/Users/guillez/ws/ewt";
        System.load(Path.of(p+"/widgets/example/build/macos/Build/Products/"+mode+"/widgets_example.app/Contents/Frameworks/FlutterMacOS.framework/FlutterMacOS").toAbsolutePath().toString());
        System.load(Path.of(p+"/widgets/example/build/macos/Build/Products/"+mode+"/widgets_example.app/Contents/Frameworks/widgets.framework/widgets").toAbsolutePath().toString());
        System.load(Path.of(p+"/widgets/example/build/macos/Build/Products/"+mode+"/libStarter.dylib").toAbsolutePath().toString());
    }

    private final Callable<Widget> builderFn;

    App(Callable<Widget> widget) {
        this.builderFn = widget;
    }

    public static void runApp(Callable<Widget> widgetBuilder) {
        new App(widgetBuilder).run();
    }

    private void run() {
        System.out.println("Before startApp");
        MemorySegment ffmFn = buildWidgetTreeFn.allocate((MemorySegment widgetFactories)  -> {
            try {
                System.out.println("In startApp$buildWidgetTree "+widgetFactories);
//                WidgetConstructors.set(WidgetFactories.reinterpret(widgetFactories, Arena.global(), null));
                WidgetConstructors.instance.set(widgetFactories);
                Widget w = builderFn.call();
                return ((NativeObj) w).getId();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }, Arena.ofAuto());
        int r = StarterBridge.startApp(ffmFn);
        System.out.println("After startApp "+r);
        if (r != 0)
            throw new RuntimeException("Could not startup EWT app, error: "+r);
    }
}
