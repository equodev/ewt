package dev.equo.ewt.evolve;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import static org.assertj.core.api.Assertions.assertThat;

class EvolveBundleExtractorTest {

    @TempDir
    Path tempDir;

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
