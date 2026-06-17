package dev.equo.ewt;

import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;

class NativeLibLoader {

    static void load() {
        String os = System.getProperty("os.name").toLowerCase();
        String osDir;
        String[] libs;

        if (os.contains("linux")) {
            osDir = "linux-x64";
            libs = new String[]{
                "libflutter_linux_gtk.so", "libwidgets.so", "libStarter.so", "libapp.so"
            };
        } else if (os.contains("win")) {
            osDir = "windows-x64";
            libs = new String[]{"flutter_windows.dll", "widgets.dll", "Starter.dll"};
        } else if (os.contains("mac")) {
            // Stub: FlutterMacOS.framework and widgets.framework require directory extraction — see Open Questions.
            osDir = "macos-arm64";
            libs = new String[]{"libStarter.dylib"};
        } else {
            throw new RuntimeException(
                "Embedded native libs not supported on OS: " + os +
                ". Set EWT_HOME to load from a local Flutter build.");
        }

        try {
            URL jarUrl = NativeLibLoader.class.getProtectionDomain()
                .getCodeSource().getLocation();
            Path jarDir = Path.of(jarUrl.toURI()).getParent();
            Path nativeDir = jarDir.resolve("native").resolve(osDir);
            List<Path> paths = extractToDir("native/" + osDir + "/", libs, nativeDir);
            for (Path p : paths) {
                System.load(p.toString());
            }
        } catch (IOException | URISyntaxException e) {
            throw new RuntimeException("Failed to extract EWT native libraries", e);
        }
    }

    static List<Path> extractToDir(String prefix, String[] libNames, Path targetDir)
            throws IOException {
        Files.createDirectories(targetDir);
        List<Path> result = new ArrayList<>();
        for (String name : libNames) {
            Path target = targetDir.resolve(name);
            if (!Files.exists(target)) {
                try (InputStream in = NativeLibLoader.class.getClassLoader()
                        .getResourceAsStream(prefix + name)) {
                    if (in == null) {
                        throw new RuntimeException("Resource not found: " + prefix + name);
                    }
                    Files.copy(in, target, StandardCopyOption.REPLACE_EXISTING);
                }
            }
            result.add(target);
        }
        return result;
    }
}
