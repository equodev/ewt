package org.eclipse.swt.widgets;

import dev.equo.ewt.web.EwtNode;
import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.*;

class EwtWidgetUpdateTest {

  private static EwtNode text(String data) {
    return new EwtNode(1, "textText", Map.of("data", data), List.of());
  }

  @Test
  void firstUpdateIsFull() {
    String json = EwtWidget.encodeUpdate(null, text("hi"));
    assertNotNull(json);
    assertTrue(json.startsWith("{\"kind\":\"full\""), json);
  }

  @Test
  void valueChangeIsPatch() {
    String json = EwtWidget.encodeUpdate(text("old"), text("new"));
    assertNotNull(json);
    assertTrue(json.startsWith("{\"kind\":\"patch\""), json);
    assertTrue(json.contains("\"new\""), json);
  }

  @Test
  void noChangeSendsNothing() {
    assertNull(EwtWidget.encodeUpdate(text("same"), text("same")));
  }

  @Test
  void structuralChangeIsFull() {
    EwtNode prev = new EwtNode(1, "textText", Map.of("data", "x"), List.of());
    EwtNode next = new EwtNode(1, "iconIcon", Map.of(), List.of());
    String json = EwtWidget.encodeUpdate(prev, next);
    assertNotNull(json);
    assertTrue(json.startsWith("{\"kind\":\"full\""), json);
  }
}
