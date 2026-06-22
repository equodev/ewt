package dev.equo.ewt;

import java.io.IOException;
import java.io.InputStream;
import java.lang.management.ManagementFactory;
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

        if (os.contains("mac")) {
            ensureMacOSMainThread();
        }

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
            // Load order matters: FlutterMacOS and widgets must be in-process before libStarter.dylib
            // so that dyld can resolve its LC_LOAD_DYLIB entries without rpath adjustments.
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

                // FlutterMacOS.framework locates icudtl.dat via NSBundle relative to its binary.
                // Extract it to the expected Resources/ location so the engine finds it.
                String icuResource = libPrefix + "FlutterMacOS.framework/Resources/icudtl.dat";
                Path icuTarget = libDir.resolve("FlutterMacOS.framework")
                    .resolve("Resources").resolve("icudtl.dat");
                if (!Files.exists(icuTarget)) {
                    Files.createDirectories(icuTarget.getParent());
                    try (InputStream in = NativeLibLoader.class.getClassLoader()
                            .getResourceAsStream(icuResource)) {
                        if (in != null) {
                            Files.copy(in, icuTarget, StandardCopyOption.REPLACE_EXISTING);
                        }
                    }
                }
            }
        } catch (IOException | URISyntaxException e) {
            throw new RuntimeException("Failed to extract EWT native libraries", e);
        }
    }

    private static void ensureMacOSMainThread() {
        // -XstartOnFirstThread is consumed by the macOS JVM launcher before the runtime
        // initialises; it never appears in getRuntimeMXBean().getInputArguments(), so we
        // cannot detect it that way. Instead we relaunch once, setting an env var on the
        // child process so it skips this block and runs normally.
        if ("1".equals(System.getenv("_EWT_MACOS_RELAUNCHED"))) return;

        StackTraceElement[] stack = Thread.currentThread().getStackTrace();
        String mainClass = stack[stack.length - 1].getClassName();
        String javaExe = Path.of(System.getProperty("java.home"), "bin", "java").toString();

        List<String> cmd = new ArrayList<>();
        cmd.add(javaExe);
        cmd.add("-XstartOnFirstThread");
        cmd.addAll(ManagementFactory.getRuntimeMXBean().getInputArguments());
        cmd.add("-cp");
        cmd.add(System.getProperty("java.class.path"));
        cmd.add(mainClass);

        ProcessBuilder pb = new ProcessBuilder(cmd);
        pb.inheritIO();
        pb.environment().put("_EWT_MACOS_RELAUNCHED", "1");

        try {
            System.exit(pb.start().waitFor());
        } catch (Exception e) {
            throw new RuntimeException(
                "macOS relaunch with -XstartOnFirstThread failed: " + e.getMessage(), e);
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
