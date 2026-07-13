package dev.equo.ewt.evolve;

import dev.equo.ewt.NativeLibLoader;

import java.io.IOException;
import java.net.JarURLConnection;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Extracts the EWT-owned combined app bundle — packaged as the {@code evolve-bundle/}
 * resource tree in the {@code dev.equo:ewt-evolve} jar — to {@code ~/.equo/ewt},
 * so Evolve's engine and EWT's NativeLibLoader can open real files on disk. Idempotent,
 * invalidated by the shipping jar's SHA-256 (reusing NativeLibLoader's cache helpers).
 * The returned base is the {@code dev.equo.ewt.bundleDir} value, such that
 * {@code <base>/linux/x64/release/bundle/lib/libapp.so} exists.
 */
public final class EvolveBundleExtractor {

    // Resource prefix inside the classifier jar. The tree under it mirrors the property
    // contract, so extraction is a straight copy to <base>/linux/x64/release/bundle/... .
    static final String RESOURCE_PREFIX = "evolve-bundle/";

    // Cheapest proof the bundle is actually shipped in this jar (vs a lean/base jar).
    private static final String PROBE_RESOURCE =
            RESOURCE_PREFIX + "linux/x64/release/bundle/lib/libapp.so";

    private EvolveBundleExtractor() {}

    /**
     * Extracts {@code ownJar}'s {@code evolve-bundle/} tree into {@code equoEwtRoot} (once,
     * cache-keyed by the jar's SHA-256) and returns {@code equoEwtRoot} as the bundle base.
     */
    public static String extractBundle(Path ownJar, Path equoEwtRoot) throws IOException {
        String key = NativeLibLoader.computeJarSha256(ownJar);
        NativeLibLoader.invalidateCacheIfStale(equoEwtRoot, key);
        NativeLibLoader.extractDirFromZip(ownJar, RESOURCE_PREFIX, equoEwtRoot);
        NativeLibLoader.writeCacheKey(equoEwtRoot, key);
        return equoEwtRoot.toString();
    }

    /**
     * Extracts the shipped bundle to {@code ~/.equo/ewt} and returns the base, or
     * {@code null} when no bundle is on the classpath (the standalone base jar without the
     * bundle resources, or running from a classes dir).
     */
    public static String extractAndGetBase() {
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
