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
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

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
            osDir = "macos-arm64";
            // Load order matters: FlutterMacOS and widgets must be in-process before Starter.dll
            // so that dyld can resolve libStarter.dylib's LC_LOAD_DYLIB entries without rpath.
            libs = new String[]{
                "FlutterMacOS.framework/FlutterMacOS",
                "widgets.framework/widgets",
                "libStarter.dylib"
            };
        } else {
            throw new RuntimeException(
                "Embedded native libs not supported on OS: " + os +
                ". Set EWT_HOME to load from a local Flutter build.");
        }

        try {
            URL jarUrl = NativeLibLoader.class.getProtectionDomain()
                .getCodeSource().getLocation();
            Path jarPath = Path.of(jarUrl.toURI());
            Path jarDir = jarPath.getParent();

            // Extract libs to native/<osDir>/lib/ — sibling to data/
            String libPrefix = "native/" + osDir + "/lib/";
            Path libDir = jarDir.resolve("native").resolve(osDir).resolve("lib");
            List<Path> extracted = extractToDir(libPrefix, libs, libDir);
            for (Path p : extracted) {
                System.load(p.toString());
            }

            // Extract flutter_assets/ and icudtl.dat (Linux/Windows) or App.framework (macOS)
            // to native/<osDir>/data/. Starter self-locates this dir via dladdr at runtime.
            String dataPrefix = "native/" + osDir + "/data/";
            Path dataDir = jarDir.resolve("native").resolve(osDir).resolve("data");
            extractDirFromZip(jarPath, dataPrefix, dataDir);

            if (os.contains("mac")) {
                // App.framework/App is a Mach-O dylib that Flutter loads via dlopen internally;
                // it must be executable on disk or FlutterDartProject will fail to open it.
                Path appBinary = dataDir.resolve("App.framework").resolve("App");
                if (Files.exists(appBinary)) {
                    appBinary.toFile().setExecutable(true, false);
                }
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
            // name may contain path separators (e.g. "FlutterMacOS.framework/FlutterMacOS")
            Path target = targetDir.resolve(name.replace("/", java.io.File.separator));
            if (!Files.exists(target)) {
                Files.createDirectories(target.getParent());
                try (InputStream in = NativeLibLoader.class.getClassLoader()
                        .getResourceAsStream(prefix + name)) {
                    if (in == null) {
                        throw new RuntimeException("Resource not found: " + prefix + name);
                    }
                    Files.copy(in, target, StandardCopyOption.REPLACE_EXISTING);
                }
                target.toFile().setExecutable(true, false);
            }
            result.add(target);
        }
        return result;
    }

    static void extractDirFromZip(Path zipPath, String prefix, Path targetDir)
            throws IOException {
        if (Files.exists(targetDir)) return;
        Files.createDirectories(targetDir);
        try (ZipInputStream zin = new ZipInputStream(Files.newInputStream(zipPath))) {
            ZipEntry entry;
            while ((entry = zin.getNextEntry()) != null) {
                if (entry.getName().startsWith(prefix) && !entry.isDirectory()) {
                    String rel = entry.getName().substring(prefix.length());
                    Path out = targetDir.resolve(rel);
                    if (!Files.exists(out)) {
                        Files.createDirectories(out.getParent());
                        Files.copy(zin, out, StandardCopyOption.REPLACE_EXISTING);
                    }
                }
                zin.closeEntry();
            }
        }
    }
}
