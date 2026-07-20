package dev.equo.ewt.evolve;

import dev.equo.ewt.NativeLibLoader;

import java.io.IOException;
import java.io.InputStream;
import java.net.JarURLConnection;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Enumeration;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Extracts the EWT-owned combined app bundle — packaged as the {@code evolve-bundle/}
 * resource tree in the {@code dev.equo:ewt-evolve} jar — to {@code ~/.equo/ewt},
 * so Evolve's engine and EWT's NativeLibLoader can open real files on disk. Idempotent,
 * invalidated by the shipping jar's SHA-256 (reusing NativeLibLoader's cache helpers).
 * The returned base is the {@code dev.equo.ewt.bundleDir} value, such that
 * {@code <base>/linux/x64/release/bundle/lib/libapp.so} exists.
 */
public final class EvolveBundleExtractor {

    // Resource prefix inside the jar. The tree under it mirrors the property contract, so
    // extraction is a straight copy to <base>/<osSubpath>/bundle/... .
    static final String RESOURCE_PREFIX = "evolve-bundle/";

    // Per-OS subpath under the bundle root, mirroring Evolve's external-bundle constants
    // (LINUX_X64_RELEASE / WIN_X64_RELEASE) so both sides resolve the same tree.
    static String osSubpath() {
        String os = System.getProperty("os.name").toLowerCase();
        if (os.contains("linux")) return "linux/x64/release";
        if (os.contains("win"))   return "windows/x64/runner/Release";
        if (os.contains("mac"))   return "macos/Build/Products/Release/swtflutter.app/Contents";
        throw new IllegalStateException("Unsupported OS: " + os);
    }

    // Cheapest proof the bundle for THIS OS is actually shipped in this jar (vs a lean/base jar).
    // Linux nests the merged snapshot at bundle/lib/libapp.so; Windows ships it as data/app.so
    // (Flutter-Windows shape: no bundle/ wrapper, no "lib" prefix); macOS ships it as the App
    // binary inside App.framework. The probe differs per OS to match osSubpath()'s layout.
    private static final String PROBE_RESOURCE = RESOURCE_PREFIX + osSubpath() + probeRelative();

    private static String probeRelative() {
        String os = System.getProperty("os.name").toLowerCase();
        if (os.contains("mac")) return "/Frameworks/App.framework/App";
        if (os.contains("win")) return "/data/app.so";
        return "/bundle/lib/libapp.so";
    }

    /** A stream that may throw on open. */
    @FunctionalInterface
    interface IoSupplier {
        InputStream open() throws IOException;
    }

    /**
     * Source of the shipped {@code evolve-bundle/} tree. A seam so extraction is unit-testable
     * with a fixed map, without a live OSGi framework. Keys are paths relative to
     * {@code evolve-bundle/}; the cache key changes when the shipped bundle changes.
     */
    interface BundleSource {
        String cacheKey() throws IOException;
        Map<String, IoSupplier> entries() throws IOException;
    }

    /**
     * Copies every entry of {@code src} into {@code equoEwtRoot} (once, cache-keyed by
     * {@code src.cacheKey()} via NativeLibLoader's cache helpers) and returns the root as the
     * bundle base — the {@code dev.equo.ewt.bundleDir} value.
     */
    static String extractFrom(BundleSource src, Path equoEwtRoot) throws IOException {
        String key = src.cacheKey();
        NativeLibLoader.invalidateCacheIfStale(equoEwtRoot, key);
        for (Map.Entry<String, IoSupplier> e : src.entries().entrySet()) {
            Path out = equoEwtRoot.resolve(e.getKey());
            if (!Files.exists(out)) {
                Files.createDirectories(out.getParent());
                try (InputStream in = e.getValue().open()) {
                    Files.copy(in, out, java.nio.file.StandardCopyOption.REPLACE_EXISTING);
                }
            }
        }
        NativeLibLoader.writeCacheKey(equoEwtRoot, key);
        return equoEwtRoot.toString();
    }

    /** True iff {@code cl} is loaded by an OSGi framework (an {@code org.osgi.framework.BundleReference}). */
    static boolean isOsgi(ClassLoader cl) {
        try {
            Class<?> ref = Class.forName("org.osgi.framework.BundleReference");
            return ref.isInstance(cl);
        } catch (ClassNotFoundException notOsgi) {
            return false;
        }
    }

    /** An {@link BundleSource} backed by this class's OSGi {@code Bundle}, reached reflectively. */
    static BundleSource osgiSourceOrNull() {
        ClassLoader cl = EvolveBundleExtractor.class.getClassLoader();
        if (!isOsgi(cl)) {
            return null;
        }
        return new OsgiBundleSource();
    }

    private static final class OsgiBundleSource implements BundleSource {
        private final Object bundle; // org.osgi.framework.Bundle

        OsgiBundleSource() {
            try {
                Class<?> frameworkUtil = Class.forName("org.osgi.framework.FrameworkUtil");
                this.bundle = frameworkUtil.getMethod("getBundle", Class.class)
                        .invoke(null, EvolveBundleExtractor.class);
                if (bundle == null) {
                    throw new IllegalStateException("No OSGi bundle for " + EvolveBundleExtractor.class);
                }
            } catch (ReflectiveOperationException e) {
                throw new RuntimeException("OSGi bundle lookup failed", e);
            }
        }

        @Override
        public String cacheKey() {
            try {
                long lastModified = (long) bundle.getClass().getMethod("getLastModified").invoke(bundle);
                return Long.toString(lastModified);
            } catch (ReflectiveOperationException e) {
                throw new RuntimeException("OSGi getLastModified failed", e);
            }
        }

        @Override
        @SuppressWarnings("unchecked")
        public Map<String, IoSupplier> entries() throws IOException {
            String dir = RESOURCE_PREFIX.substring(0, RESOURCE_PREFIX.length() - 1); // "evolve-bundle"
            Enumeration<URL> found;
            try {
                found = (Enumeration<URL>) bundle.getClass()
                        .getMethod("findEntries", String.class, String.class, boolean.class)
                        .invoke(bundle, dir, "*", true);
            } catch (ReflectiveOperationException e) {
                throw new RuntimeException("OSGi findEntries failed", e);
            }
            Map<String, IoSupplier> out = new LinkedHashMap<>();
            if (found == null) {
                return out;
            }
            while (found.hasMoreElements()) {
                URL url = found.nextElement();
                String path = url.getPath();
                int at = path.indexOf(RESOURCE_PREFIX);
                if (at < 0) {
                    continue;
                }
                String rel = path.substring(at + RESOURCE_PREFIX.length());
                if (rel.isEmpty() || rel.endsWith("/")) {
                    continue; // directory entry
                }
                out.put(rel, url::openStream);
            }
            return out;
        }
    }

    private EvolveBundleExtractor() {}

    /**
     * Extracts {@code ownJar}'s {@code evolve-bundle/} tree into {@code equoEwtRoot} (once,
     * cache-keyed by the jar's SHA-256) and returns {@code equoEwtRoot} as the bundle base.
     */
    public static String extractBundle(Path ownJar, Path equoEwtRoot) throws IOException {
        String key = NativeLibLoader.computeJarSha256(ownJar);
        NativeLibLoader.invalidateCacheIfStale(equoEwtRoot, key);
        NativeLibLoader.extractDirFromZip(ownJar, RESOURCE_PREFIX, equoEwtRoot);
        // App.framework/App is a Mach-O dylib that Flutter opens via dlopen; the zip round-trip
        // drops the executable bit, so FlutterDartProject fails to load it unless we restore it.
        if (System.getProperty("os.name").toLowerCase().contains("mac")) {
            Path appBinary = Path.of(equoEwtRoot.toString(), osSubpath(),
                    "Frameworks", "App.framework", "App");
            if (Files.exists(appBinary)) {
                appBinary.toFile().setExecutable(true, false);
            }
        }
        NativeLibLoader.writeCacheKey(equoEwtRoot, key);
        return equoEwtRoot.toString();
    }

    /**
     * Extracts the shipped bundle to {@code ~/.equo/ewt} and returns the base, or
     * {@code null} when no bundle is on the classpath (the standalone base jar without the
     * bundle resources, or running from a classes dir).
     *
     * <p>Under OSGi (e.g. Eclipse RCP / Equinox), the classloader is a
     * {@code BundleReference} and resources use the {@code bundleresource://} protocol,
     * not {@code jar:}. In that case the OSGi branch is used instead of the flat-classpath
     * path, which is preserved as the fallback.
     */
    public static String extractAndGetBase() {
        BundleSource osgi = osgiSourceOrNull();
        if (osgi != null) {
            try {
                return extractFrom(osgi, defaultEquoEwtRoot());
            } catch (IOException e) {
                throw new RuntimeException("Failed to extract the combined EWT bundle", e);
            }
        }
        Path bundleJar = locateBundleJar();
        if (bundleJar == null || !Files.isRegularFile(bundleJar)) {
            return null;
        }
        try {
            return extractBundle(bundleJar, defaultEquoEwtRoot());
        } catch (IOException e) {
            throw new RuntimeException("Failed to extract the combined EWT bundle", e);
        }
    }

    /**
     * Locates the jar that actually SHIPS the bundle resources by resolving the probe
     * resource's URL ({@code jar:file:/…!/…}) via {@code JarURLConnection}, not from
     * {@code getProtectionDomain()}. This is robust whether the bundle resources sit in the
     * same jar as this class (the self-contained {@code ewt-evolve} jar) or in a separate
     * one. Returns {@code null} when the resource is absent (standalone base jar) or is not
     * inside a jar (e.g. a classes dir during tests).
     */
    static Path locateBundleJar() {
        URL res = EvolveBundleExtractor.class.getClassLoader().getResource(PROBE_RESOURCE);
        if (res == null || !"jar".equals(res.getProtocol())) {
            return null;
        }
        try {
            JarURLConnection conn = (JarURLConnection) res.openConnection();
            return Path.of(conn.getJarFileURL().toURI());
        } catch (Exception e) {
            return null;
        }
    }

    static Path defaultEquoEwtRoot() {
        return Path.of(System.getProperty("user.home"), ".equo", "ewt");
    }
}
