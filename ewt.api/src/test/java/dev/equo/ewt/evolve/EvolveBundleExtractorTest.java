package dev.equo.ewt.evolve;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import static org.assertj.core.api.Assertions.assertThat;

class EvolveBundleExtractorTest {

    @TempDir
    Path tempDir;

    private static EvolveBundleExtractor.IoSupplier bytes(String s) {
        return () -> new ByteArrayInputStream(s.getBytes(StandardCharsets.UTF_8));
    }

    private record FakeSource(String key, Map<String, EvolveBundleExtractor.IoSupplier> map)
            implements EvolveBundleExtractor.BundleSource {
        @Override public String cacheKey() { return key; }
        @Override public Map<String, EvolveBundleExtractor.IoSupplier> entries() { return map; }
    }

    @Test
    void extractFrom_copiesEntries_writesKey_returnsRoot(@TempDir Path root) throws Exception {
        var src = new FakeSource("k1", Map.of(
                "linux/x64/release/bundle/lib/libapp.so", bytes("app"),
                "linux/x64/release/bundle/data/flutter_assets/AssetManifest.json", bytes("{}")));

        String base = EvolveBundleExtractor.extractFrom(src, root);

        assertThat(base).isEqualTo(root.toString());
        assertThat(Files.readString(root.resolve("linux/x64/release/bundle/lib/libapp.so"))).isEqualTo("app");
        assertThat(Files.readString(root.resolve("linux/x64/release/bundle/data/flutter_assets/AssetManifest.json"))).isEqualTo("{}");
        assertThat(Files.readString(root.resolve(".jar-key")).trim()).isEqualTo("k1");
    }

    @Test
    void extractFrom_reextracts_whenKeyChanges(@TempDir Path root) throws Exception {
        EvolveBundleExtractor.extractFrom(new FakeSource("k1", Map.of("a", bytes("1"))), root);
        EvolveBundleExtractor.extractFrom(new FakeSource("k2", Map.of("a", bytes("2"))), root);

        assertThat(Files.readString(root.resolve("a"))).isEqualTo("2");
        assertThat(Files.readString(root.resolve(".jar-key")).trim()).isEqualTo("k2");
    }

    @Test
    void isOsgi_falseForPlainClassLoader() throws Exception {
        try (var cl = new java.net.URLClassLoader(new java.net.URL[0])) {
            assertThat(EvolveBundleExtractor.isOsgi(cl)).isFalse();
        }
    }

    private Path makeBundleJar(String appContent) throws IOException {
        Path jar = tempDir.resolve("evolve-bundle.jar");
        try (ZipOutputStream zos = new ZipOutputStream(Files.newOutputStream(jar))) {
            zos.putNextEntry(new ZipEntry("evolve-bundle/linux/x64/release/bundle/lib/libapp.so"));
            zos.write(appContent.getBytes());
            zos.closeEntry();
            zos.putNextEntry(new ZipEntry("evolve-bundle/linux/x64/release/bundle/lib/libwidgets.so"));
            zos.write("WIDGETS".getBytes());
            zos.closeEntry();
            zos.putNextEntry(new ZipEntry("evolve-bundle/linux/x64/release/bundle/data/icudtl.dat"));
            zos.write("ICU".getBytes());
            zos.closeEntry();
        }
        return jar;
    }

    @Test
    void extractsBundleTreeAndReturnsBase() throws IOException {
        Path jar = makeBundleJar("APP_V1");
        Path root = tempDir.resolve("out");

        String base = EvolveBundleExtractor.extractBundle(jar, root);

        assertThat(base).isEqualTo(root.toString());
        assertThat(root.resolve("linux/x64/release/bundle/lib/libapp.so")).exists();
        assertThat(root.resolve("linux/x64/release/bundle/lib/libwidgets.so")).exists();
        assertThat(root.resolve("linux/x64/release/bundle/data/icudtl.dat")).exists();
        assertThat(Files.readString(root.resolve("linux/x64/release/bundle/lib/libapp.so")))
            .isEqualTo("APP_V1");
    }

    @Test
    void reExtractsWhenJarKeyChanges() throws IOException {
        Path root = tempDir.resolve("out");
        EvolveBundleExtractor.extractBundle(makeBundleJar("APP_V1"), root);

        // A different jar (different sha) must wipe and re-extract the new content.
        EvolveBundleExtractor.extractBundle(makeBundleJar("APP_V2"), root);

        assertThat(Files.readString(root.resolve("linux/x64/release/bundle/lib/libapp.so")))
            .isEqualTo("APP_V2");
    }

    private Path makeWebJar(String indexContent) throws IOException {
        Path jar = tempDir.resolve("ewt-evolve-web.jar");
        try (ZipOutputStream zos = new ZipOutputStream(Files.newOutputStream(jar))) {
            zos.putNextEntry(new ZipEntry("web-bundle/index.html"));
            zos.write(indexContent.getBytes());
            zos.closeEntry();
            zos.putNextEntry(new ZipEntry("web-bundle/main.dart.js"));
            zos.write("JS".getBytes());
            zos.closeEntry();
            zos.putNextEntry(new ZipEntry("web-bundle/assets/AssetManifest.json"));
            zos.write("{}".getBytes());
            zos.closeEntry();
        }
        return jar;
    }

    @Test
    void extractsWebBundleTreeAndReturnsServedDir() throws IOException {
        Path jar = makeWebJar("<html>V1</html>");
        Path root = tempDir.resolve("web-out");

        String dir = EvolveBundleExtractor.extractWebBundle(jar, root);

        // The served dir is the root itself (the web-bundle/ prefix is stripped), containing index.html.
        assertThat(dir).isEqualTo(root.toString());
        assertThat(root.resolve("index.html")).exists();
        assertThat(root.resolve("main.dart.js")).exists();
        assertThat(root.resolve("assets/AssetManifest.json")).exists();
        assertThat(Files.readString(root.resolve("index.html"))).isEqualTo("<html>V1</html>");
    }

    @Test
    void reExtractsWebWhenJarKeyChanges() throws IOException {
        Path root = tempDir.resolve("web-out");
        EvolveBundleExtractor.extractWebBundle(makeWebJar("<html>V1</html>"), root);
        EvolveBundleExtractor.extractWebBundle(makeWebJar("<html>V2</html>"), root);

        assertThat(Files.readString(root.resolve("index.html"))).isEqualTo("<html>V2</html>");
    }

    @Test
    void skipsWhenAlreadyExtractedWithSameJar() throws IOException {
        Path jar = makeBundleJar("APP_V1");
        Path root = tempDir.resolve("out");
        EvolveBundleExtractor.extractBundle(jar, root);

        // Tamper a file, re-run with the SAME jar: key matches -> extraction skipped,
        // tampered content preserved (proves the fast path does not re-copy).
        Path app = root.resolve("linux/x64/release/bundle/lib/libapp.so");
        Files.writeString(app, "TAMPERED");
        EvolveBundleExtractor.extractBundle(jar, root);

        assertThat(Files.readString(app)).isEqualTo("TAMPERED");
    }
}
