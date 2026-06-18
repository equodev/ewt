package dev.equo.ewt;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class NativeLibLoaderTest {

    @TempDir
    Path tempDir;

    @Test
    void extractsResourceToTargetDir() throws IOException {
        List<Path> extracted = NativeLibLoader.extractToDir(
            "native/test/", new String[]{"libdummy.so"}, tempDir
        );

        assertThat(extracted).hasSize(1);
        assertThat(extracted.get(0)).exists();
        assertThat(extracted.get(0).getFileName().toString()).isEqualTo("libdummy.so");
        assertThat(Files.readString(extracted.get(0))).contains("DUMMY_LIB_CONTENT");
    }

    @Test
    void skipsExtractionWhenFileAlreadyExists() throws IOException {
        Path existing = tempDir.resolve("libdummy.so");
        Files.writeString(existing, "PREEXISTING");

        NativeLibLoader.extractToDir("native/test/", new String[]{"libdummy.so"}, tempDir);

        assertThat(Files.readString(existing)).isEqualTo("PREEXISTING");
    }

    @Test
    void throwsWhenResourceNotFound() {
        assertThatThrownBy(() ->
            NativeLibLoader.extractToDir(
                "native/test/", new String[]{"nonexistent.so"}, tempDir)
        ).isInstanceOf(RuntimeException.class)
         .hasMessageContaining("Resource not found");
    }

    @Test
    void extractsDirFromZip() throws IOException {
        Path zipPath = tempDir.resolve("test.zip");
        try (var zos = new java.util.zip.ZipOutputStream(Files.newOutputStream(zipPath))) {
            zos.putNextEntry(new java.util.zip.ZipEntry("assets/subdir/file.txt"));
            zos.write("hello".getBytes());
            zos.closeEntry();
            zos.putNextEntry(new java.util.zip.ZipEntry("assets/top.txt"));
            zos.write("world".getBytes());
            zos.closeEntry();
        }

        Path outDir = tempDir.resolve("out");
        NativeLibLoader.extractDirFromZip(zipPath, "assets/", outDir);

        assertThat(outDir.resolve("subdir/file.txt")).exists();
        assertThat(Files.readString(outDir.resolve("subdir/file.txt"))).isEqualTo("hello");
        assertThat(outDir.resolve("top.txt")).exists();
        assertThat(Files.readString(outDir.resolve("top.txt"))).isEqualTo("world");
    }

    @Test
    void extractDirFromZipSkipsWhenTargetExists() throws IOException {
        Path zipPath = tempDir.resolve("test.zip");
        try (var zos = new java.util.zip.ZipOutputStream(Files.newOutputStream(zipPath))) {
            zos.putNextEntry(new java.util.zip.ZipEntry("assets/file.txt"));
            zos.write("new".getBytes());
            zos.closeEntry();
        }

        Path outDir = tempDir.resolve("out");
        Files.createDirectories(outDir);
        Files.writeString(outDir.resolve("file.txt"), "original");

        // outDir already exists — must skip entirely
        NativeLibLoader.extractDirFromZip(zipPath, "assets/", outDir);

        assertThat(Files.readString(outDir.resolve("file.txt"))).isEqualTo("original");
    }
}
