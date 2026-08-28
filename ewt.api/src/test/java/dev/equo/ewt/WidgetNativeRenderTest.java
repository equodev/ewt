package dev.equo.ewt;

import dev.equo.ewt.support.GetterRoundTrip;
import dev.equo.ewt.support.SnapshotNode;
import dev.equo.ewt.support.TreeSnapshot;
import dev.equo.ewt.support.variants.PropExpectation;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.Callable;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Parameterised native render suite: mounts every widget × variant produced by the
 * generator (via {@code WidgetVariantsRegistry}) into a shared Flutter engine and
 * asserts (i) the widget is present in the element tree, (ii) its RenderBox has a
 * positive size, (iii) no captured {@code FlutterError} in the frame window, (iv)
 * for {@code _allSet}/{@code _boundary} variants, the getters round-trip.
 *
 * <p>Gated by {@link org.junit.jupiter.api.Tag @Tag("native")} inherited from
 * {@link FlutterRenderTestBase}; opt in with {@code -DrunNativeTests=1}.
 */
public class WidgetNativeRenderTest extends FlutterRenderTestBase {

    @ParameterizedTest(name = "{0}/{1}")
    @MethodSource("dev.equo.ewt.support.WidgetBuilderCatalog#mountableVariants")
    void rendersVariant(String widgetName,
                        String variantLabel,
                        Callable<Widget> factory,
                        List<PropExpectation> expectations) throws Exception {

        TreeSnapshot snap = mountAndCapture(factory);

        Optional<SnapshotNode> node = snap.findFirst(widgetName);
        assertTrue(node.isPresent(),
            () -> widgetName + " not in tree: " + snap.summary());

        SnapshotNode n = node.get();
        assertTrue(n.hasSize(),
            () -> widgetName + " has no RenderObject size (t=" + n.type() + ")");
        assertTrue(n.width() > 0,
            () -> widgetName + " width=" + n.width() + " (snapshot: " + snap.summary() + ")");
        assertTrue(n.height() > 0,
            () -> widgetName + " height=" + n.height() + " (snapshot: " + snap.summary() + ")");

        if (expectations != null) {
            // Reuse the widget instance built on the engine thread — calling
            // `factory.call()` again from the JUnit thread would fire Java→Dart
            // FFI downcalls with no isolate on this thread (SIGABRT).
            Widget built = lastMountedVariant.get();
            if (built != null) GetterRoundTrip.verify(built, expectations);
        }
    }
}
