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
}
