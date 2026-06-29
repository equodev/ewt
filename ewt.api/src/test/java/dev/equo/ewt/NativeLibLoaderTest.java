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
        // Use the same byte length as the bundled resource ("DUMMY_LIB_CONTENT") so the
        // size-based freshness check treats the file as already extracted and skips it.
        // Distinct content lets us verify the file was left untouched.
        String placeholder = "X".repeat("DUMMY_LIB_CONTENT".length());
        Files.writeString(existing, placeholder);

        NativeLibLoader.extractToDir("native/test/", new String[]{"libdummy.so"}, tempDir);

        assertThat(Files.readString(existing)).isEqualTo(placeholder);
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

    @Test
    void invalidateCacheWipesEverythingWhenKeyMismatches() throws IOException {
        Path cacheDir = tempDir.resolve("native/linux-x64");
        Files.createDirectories(cacheDir.resolve("lib"));
        Files.createDirectories(cacheDir.resolve("data"));
        Files.writeString(cacheDir.resolve("lib/libstale.so"), "stale");
        Files.writeString(cacheDir.resolve("data/asset.bin"), "stale");
        Files.writeString(cacheDir.resolve(".jar-key"), "OLD_KEY");

        NativeLibLoader.invalidateCacheIfStale(cacheDir, "NEW_KEY");

        assertThat(cacheDir).doesNotExist();
    }

    @Test
    void invalidateCacheWipesWhenKeyFileMissing() throws IOException {
        Path cacheDir = tempDir.resolve("native/linux-x64");
        Files.createDirectories(cacheDir.resolve("lib"));
        Files.writeString(cacheDir.resolve("lib/libold.so"), "leftover from a previous jar");

        NativeLibLoader.invalidateCacheIfStale(cacheDir, "ANY_KEY");

        assertThat(cacheDir).doesNotExist();
    }

    @Test
    void invalidateCachePreservesContentWhenKeyMatches() throws IOException {
        Path cacheDir = tempDir.resolve("native/linux-x64");
        Files.createDirectories(cacheDir.resolve("lib"));
        Path lib = cacheDir.resolve("lib/libcached.so");
        Files.writeString(lib, "cached-content");
        Files.writeString(cacheDir.resolve(".jar-key"), "MATCHING_KEY");

        NativeLibLoader.invalidateCacheIfStale(cacheDir, "MATCHING_KEY");

        assertThat(lib).exists();
        assertThat(Files.readString(lib)).isEqualTo("cached-content");
    }

    @Test
    void invalidateCacheIsNoopWhenCacheDirAbsent() throws IOException {
        Path cacheDir = tempDir.resolve("does-not-exist");

        NativeLibLoader.invalidateCacheIfStale(cacheDir, "ANY_KEY");

        assertThat(cacheDir).doesNotExist();
    }

    @Test
    void writeCacheKeyCreatesDirAndKeyFile() throws IOException {
        Path cacheDir = tempDir.resolve("native/linux-x64");

        NativeLibLoader.writeCacheKey(cacheDir, "abc123");

        assertThat(cacheDir.resolve(".jar-key")).exists();
        assertThat(Files.readString(cacheDir.resolve(".jar-key"))).isEqualTo("abc123");
    }

    @Test
    void computeJarSha256IsDeterministic() throws IOException {
        Path file = tempDir.resolve("fake.jar");
        Files.writeString(file, "some-bytes");

        String first = NativeLibLoader.computeJarSha256(file);
        String second = NativeLibLoader.computeJarSha256(file);

        assertThat(first).isEqualTo(second);
        assertThat(first).hasSize(64);
    }

    @Test
    void computeJarSha256ChangesWhenContentChanges() throws IOException {
        Path file = tempDir.resolve("fake.jar");
        Files.writeString(file, "version-A");
        String hashA = NativeLibLoader.computeJarSha256(file);

        Files.writeString(file, "version-B");
        String hashB = NativeLibLoader.computeJarSha256(file);

        assertThat(hashA).isNotEqualTo(hashB);
    }
}
