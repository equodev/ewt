package dev.equo.ewt;

import dev.equo.ewt.support.TreeSnapshot;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Minimal end-to-end smoke test: mounts a hardcoded {@code Text.text("hello")}
 * through the shared engine and asserts a Text node lands in the snapshot.
 *
 * <p>Extends {@link FlutterRenderTestBase} so it reuses the engine and
 * {@code @EnabledIfSystemProperty} gate that {@link WidgetNativeRenderTest}
 * also uses — one engine per JVM (ADR-0009 invariant), no per-class boot.
 * If this passes but {@code WidgetNativeRenderTest} fails, the plumbing is
 * fine and the failure is a specific widget's problem.
 */
class NativeRenderSmokeTest extends FlutterRenderTestBase {

    @Test
    void textRenders() throws Exception {
        TreeSnapshot snap = mountAndCapture(() -> Text.text("hello").build());
        assertTrue(snap.findFirst("Text").isPresent(),
            () -> "Text not in snapshot: " + snap.summary());
    }
}
