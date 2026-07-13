package dev.equo.ewt.hotreload;

import com.sun.jdi.Bootstrap;
import com.sun.jdi.ReferenceType;
import com.sun.jdi.VirtualMachine;
import com.sun.jdi.connect.AttachingConnector;
import com.sun.jdi.connect.Connector;

import java.io.IOException;
import java.net.Socket;
import java.nio.file.*;
import java.util.*;
import java.util.concurrent.TimeUnit;

public final class Main {

    private static final String JDWP_HOSTNAME = "localhost";
    private static final String JDWP_PORT = "5005";
    private static final String DART_TRIGGER_HOST = "localhost";
    private static final int DART_TRIGGER_PORT = 5006;

    public static void main(String[] args) throws Exception {
        // Accept `-Dkey=value` also as positional args, because Gradle's
        // application-plugin launcher script forwards program args to the JVM
        // as *application* args, not JVM system properties. Promoting them
        // before we read the properties keeps invocation uniform (env var,
        // JVM -D, or positional -D all work).
        for (String a : args) {
            if (a.startsWith("-D")) {
                String kv = a.substring(2);
                int eq = kv.indexOf('=');
                if (eq > 0) System.setProperty(kv.substring(0, eq), kv.substring(eq + 1));
            }
        }

        String sourceDirsProp = System.getProperty("sourceDirs");
        String gradleTask = System.getProperty("gradleCompileTask", ":examples:classes");
        Path projectRoot = Paths.get(System.getProperty("projectRoot", ".")).toAbsolutePath();

        if (sourceDirsProp == null || sourceDirsProp.isBlank()) {
            System.err.println("Usage: -DsourceDirs=<path1,path2,...> -DprojectRoot=<ewt-root>");
            System.exit(2);
        }

        List<Path> sourceDirs = new ArrayList<>();
        for (String s : sourceDirsProp.split(",")) sourceDirs.add(Paths.get(s.trim()).toAbsolutePath());

        System.out.println("[hot-reload] Connecting to JDWP at " + JDWP_HOSTNAME + ":" + JDWP_PORT + " (retrying until ready)...");
        VirtualMachine vm = attachWithRetry();
        System.out.println("[hot-reload] Connected. Watching: " + sourceDirs);

        WatchService watcher = FileSystems.getDefault().newWatchService();
        Map<WatchKey, Path> keyRoots = new HashMap<>();
        for (Path root : sourceDirs) registerRecursive(root, watcher, keyRoots);

        Path classesOutputRoot = projectRoot.resolve("examples/build/classes/java/main");
        Map<Path, Long> classMtimes = snapshotMtimes(classesOutputRoot);

        while (true) {
            WatchKey key = watcher.take();
            // Debounce: coalesce burst events (e.g. IDE saving multiple files at once).
            Thread.sleep(150);
            List<WatchKey> collected = new ArrayList<>();
            collected.add(key);
            WatchKey more;
            while ((more = watcher.poll()) != null) collected.add(more);

            boolean sawJava = false;
            for (WatchKey k : collected) {
                for (WatchEvent<?> ev : k.pollEvents()) {
                    Object ctx = ev.context();
                    if (ctx instanceof Path p && p.toString().endsWith(".java")) sawJava = true;
                }
                k.reset();
            }
            if (!sawJava) continue;

            System.out.println("[hot-reload] Change detected, recompiling...");
            long t0 = System.currentTimeMillis();
            int rc = runGradle(projectRoot, gradleTask);
            long dt = System.currentTimeMillis() - t0;
            if (rc != 0) {
                System.err.println("[hot-reload] Compilation failed (exit " + rc + "), skipping.");
                continue;
            }
            System.out.println("[hot-reload] Recompiled in " + dt + "ms.");

            Map<Path, Long> newMtimes = snapshotMtimes(classesOutputRoot);
            List<Path> changed = new ArrayList<>();
            for (var e : newMtimes.entrySet()) {
                Long prev = classMtimes.get(e.getKey());
                if (prev == null || !prev.equals(e.getValue())) changed.add(e.getKey());
            }
            classMtimes = newMtimes;

            if (changed.isEmpty()) {
                System.out.println("[hot-reload] No .class changes detected.");
                continue;
            }
            System.out.println("[hot-reload] Redefining " + changed.size() + " class(es).");

            Map<ReferenceType, byte[]> toRedefine = new HashMap<>();
            for (Path classFile : changed) {
                String fqcn = classesOutputRoot.relativize(classFile).toString()
                        .replace(java.io.File.separatorChar, '.')
                        .replaceAll("\\.class$", "");
                List<ReferenceType> refs = vm.classesByName(fqcn);
                if (refs.isEmpty()) {
                    System.out.println("[hot-reload] " + fqcn + " not loaded yet in target VM, skipping.");
                    continue;
                }
                byte[] bytes = Files.readAllBytes(classFile);
                for (ReferenceType r : refs) toRedefine.put(r, bytes);
            }

            if (toRedefine.isEmpty()) {
                System.out.println("[hot-reload] Nothing to redefine.");
                continue;
            }

            try {
                vm.redefineClasses(toRedefine);
            } catch (UnsupportedOperationException e) {
                System.err.println("[hot-reload] Redefinition unsupported (structural change?): " + e.getMessage());
                continue;
            } catch (Exception e) {
                System.err.println("[hot-reload] Error while redefining: " + e.getMessage());
                continue;
            }

            triggerDartReassemble();
            System.out.println("[hot-reload] Reload applied.");
        }
    }

    private static VirtualMachine attachWithRetry() throws Exception {
        AttachingConnector conn = Bootstrap.virtualMachineManager().attachingConnectors().stream()
                .filter(c -> c.name().equals("com.sun.jdi.SocketAttach"))
                .findFirst().orElseThrow(() -> new IllegalStateException("No SocketAttach connector"));

        Map<String, Connector.Argument> args = conn.defaultArguments();
        args.get("hostname").setValue(JDWP_HOSTNAME);
        args.get("port").setValue(JDWP_PORT);

        long deadline = System.currentTimeMillis() + 60_000;
        while (true) {
            try {
                return conn.attach(args);
            } catch (Exception e) {
                if (System.currentTimeMillis() > deadline) throw e;
                Thread.sleep(500);
            }
        }
    }

    private static void registerRecursive(Path root, WatchService watcher, Map<WatchKey, Path> keyRoots) throws IOException {
        Files.walkFileTree(root, new SimpleFileVisitor<>() {
            @Override public FileVisitResult preVisitDirectory(Path dir, java.nio.file.attribute.BasicFileAttributes attrs) throws IOException {
                WatchKey k = dir.register(watcher,
                        StandardWatchEventKinds.ENTRY_CREATE,
                        StandardWatchEventKinds.ENTRY_MODIFY,
                        StandardWatchEventKinds.ENTRY_DELETE);
                keyRoots.put(k, dir);
                return FileVisitResult.CONTINUE;
            }
        });
    }

    private static Map<Path, Long> snapshotMtimes(Path root) throws IOException {
        Map<Path, Long> out = new HashMap<>();
        if (!Files.exists(root)) return out;
        Files.walk(root)
                .filter(p -> p.toString().endsWith(".class"))
                .forEach(p -> {
                    try { out.put(p, Files.getLastModifiedTime(p).toMillis()); } catch (IOException ignored) {}
                });
        return out;
    }

    private static int runGradle(Path projectRoot, String task) throws Exception {
        ProcessBuilder pb = new ProcessBuilder("./gradlew", task, "--daemon", "-q")
                .directory(projectRoot.toFile())
                .redirectErrorStream(true)
                .inheritIO();
        pb.environment().put("JAVA_HOME", System.getenv().getOrDefault("JAVA_HOME", System.getProperty("java.home")));
        Process p = pb.start();
        if (!p.waitFor(120, TimeUnit.SECONDS)) {
            p.destroyForcibly();
            return -1;
        }
        return p.exitValue();
    }

    private static void triggerDartReassemble() {
        try (Socket s = new Socket(DART_TRIGGER_HOST, DART_TRIGGER_PORT)) {
            s.getOutputStream().write("reload\n".getBytes());
            s.getOutputStream().flush();
        } catch (IOException e) {
            System.err.println("[hot-reload] Could not connect to Dart at " + DART_TRIGGER_HOST + ":" + DART_TRIGGER_PORT + ": " + e.getMessage());
        }
    }
}
