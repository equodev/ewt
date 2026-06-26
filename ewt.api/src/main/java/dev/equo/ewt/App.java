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
        String ewtHome = System.getenv("EWT_HOME");
        if (ewtHome == null) ewtHome = System.getProperty("ewt.home");

        if (ewtHome != null) {
            Path home = Path.of(ewtHome);
            String os = System.getProperty("os.name").toLowerCase();

            if (os.contains("mac")) {
                var mode = "Release";
                Path frameworks = home.resolve(
                    "widgets/example/build/macos/Build/Products/" + mode +
                    "/widgets_example.app/Contents/Frameworks");
                System.load(frameworks.resolve(
                    "FlutterMacOS.framework/FlutterMacOS").toString());
                System.load(frameworks.resolve(
                    "widgets.framework/widgets").toString());
                System.load(home.resolve(
                    "widgets/example/build/macos/Build/Products/" + mode +
                    "/libStarter.dylib").toString());
            } else if (os.contains("linux")) {
                Path lib = home.resolve(
                    "widgets/example/build/linux/x64/release/bundle/lib");
                System.load(lib.resolve("libflutter_linux_gtk.so").toString());
                System.load(lib.resolve("libwidgets.so").toString());
                System.load(lib.resolve("libStarter.so").toString());
            } else if (os.contains("win")) {
                Path lib = home.resolve(
                    "widgets/example/build/windows/x64/runner/Release");
                System.load(lib.resolve("flutter_windows.dll").toString());
                System.load(lib.resolve("widgets.dll").toString());
                System.load(lib.resolve("Starter.dll").toString());
            } else {
                throw new RuntimeException("Unsupported OS: " + os);
            }
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
