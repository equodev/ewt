package org.eclipse.swt.widgets;

import static org.junit.jupiter.api.Assertions.*;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import org.junit.jupiter.api.Test;

/** Tests EwtWidget.resolveCallback (static) without requiring a live Display or native engine. */
class EwtWidgetCallbackTest {

  @Test
  void resolveCallbackParsesIdAndReturnsTheMappedRunnable() {
    boolean[] ran = {false};
    Runnable r = () -> ran[0] = true;

    Runnable resolved = EwtWidget.resolveCallback(Map.of(5, r), "5".getBytes(StandardCharsets.UTF_8));
    assertNotNull(resolved, "id 5 must resolve to the registered Runnable");
    resolved.run();
    assertTrue(ran[0], "resolved Runnable must execute the original lambda");

    assertNull(EwtWidget.resolveCallback(Map.of(5, r), "99".getBytes(StandardCharsets.UTF_8)),
        "unknown id -> null");
    assertNull(EwtWidget.resolveCallback(Map.of(5, r), "x".getBytes(StandardCharsets.UTF_8)),
        "non-numeric -> null");
    assertNull(EwtWidget.resolveCallback(Map.of(5, r), null), "no payload -> null");
  }
}
