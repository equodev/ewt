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

    record ExtractedPaths(Path assetsDir, Path icuFile, Path aotLib) {}

    static ExtractedPaths load() {
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
            libs = new String[]{"libStarter.dylib"};
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

            // Extract .so / .dll files
            Path nativeDir = jarDir.resolve("native").resolve(osDir);
            List<Path> paths = extractToDir("native/" + osDir + "/", libs, nativeDir);
            for (Path p : paths) {
                System.load(p.toString());
            }

            // Extract flutter_assets/ and icudtl.dat
            Path flutterDataDir = jarDir.resolve("flutter_data").resolve(osDir);
            extractDirFromZip(jarPath, "flutter_data/" + osDir + "/", flutterDataDir);

            return new ExtractedPaths(
                flutterDataDir.resolve("flutter_assets"),
                flutterDataDir.resolve("icudtl.dat"),
                nativeDir.resolve(libs[libs.length - 1])  // libapp.so / Starter.dll / libStarter.dylib
            );
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
