package dev.equo.ewt;

import static org.junit.jupiter.api.Assertions.*;
import java.util.concurrent.Callable;
import org.junit.jupiter.api.Test;
import dev.equo.ewt.web.EwtNodeJson;
import static dev.equo.ewt.EWT.*;

class ThemeAccessorCaptureTest {
  static class ThemedProbe extends SubStatefulWidget {
    @Override protected State<ThemedProbe> createState() { return new S(); }
    static class S extends SubState<ThemedProbe> {
      @Override public Widget build(BuildContext context) {
        // Theme.of(context).colorScheme().inversePrimary() as a Container color.
        Color c = Theme.of(context).colorScheme().inversePrimary();
        return Container().color(c).build();
      }
    }
  }

  @Test
  void themeAccessorChainRecordsNodeChain() throws Exception {
    Callable<Widget> builder = ThemedProbe::new;
    EwtCapture cap = EwtWebCapture.captureSubtree(builder);
    String json = EwtNodeJson.encode(cap.root);
    // The chain themeOf -> themeDataColorScheme -> colorSchemeInversePrimary is present.
    assertTrue(json.contains("colorSchemeInversePrimary"), "inversePrimary accessor recorded");
    assertTrue(json.contains("themeDataColorScheme"), "colorScheme accessor recorded");
    assertTrue(json.contains("themeOf"), "themeOf recorded");
  }
}
