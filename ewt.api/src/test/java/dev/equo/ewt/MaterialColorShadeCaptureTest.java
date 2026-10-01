package dev.equo.ewt;

import static org.junit.jupiter.api.Assertions.*;
import java.util.concurrent.Callable;
import org.junit.jupiter.api.Test;
import dev.equo.ewt.web.EwtNodeJson;
import static dev.equo.ewt.EWT.*;

/**
 * Regression for issue #64: MaterialColor shade read-back getters threw
 * UnsupportedOperationException on the comm transport (JVM &lt; 22), because the
 * ColorSwatch emitter skipped the comm/web accessor branch and fell through to the
 * FFM-only read-back SPI. A shade read now records an accessor node like any other
 * value-object getter, so the subtree serializes without FFM.
 */
class MaterialColorShadeCaptureTest {
  static class ShadeProbe extends SubStatefulWidget {
    @Override protected State<ShadeProbe> createState() { return new S(); }
    static class S extends SubState<ShadeProbe> {
      @Override public Widget build(BuildContext context) {
        // The exact shape from the issue: a shade read-back feeds a Container color.
        Color c = Colors.grey().shade600();
        return Container().color(c).build();
      }
    }
  }

  @Test
  void shadeReadBackCapturesWithoutFfm() throws Exception {
    Callable<Widget> builder = ShadeProbe::new;
    EwtCapture cap = EwtWebCapture.captureSubtree(builder);
    String json = EwtNodeJson.encode(cap.root);
    // The shade accessor is recorded as a node chained off the MaterialColor receiver,
    // which itself carries the full swatch so the Dart decoder can resolve .shade600.
    assertTrue(json.contains("materialColorShade600"), "shade600 accessor recorded");
    assertTrue(json.contains("materialColorMaterialColor"), "MaterialColor receiver recorded");
    assertTrue(json.contains("swatch"), "swatch node-map recorded on the MaterialColor node");
  }
}
