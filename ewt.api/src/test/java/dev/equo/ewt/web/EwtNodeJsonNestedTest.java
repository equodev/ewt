package dev.equo.ewt.web;

import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.*;

class EwtNodeJsonNestedTest {

  @Test
  void encodesNestedNodeParam() {
    EwtNode color = new EwtNode(2, "colorFromRGBO", Map.of("r", 1, "g", 2, "b", 3), List.of());
    EwtNode style = new EwtNode(1, "textStyleTextStyle", Map.of("color", color), List.of());
    String json = EwtNodeJson.encode(style);
    assertTrue(json.contains("\"color\":{\"t\":\"colorFromRGBO\""), json);
  }

  @Test
  void encodesListParam() {
    EwtNode a = new EwtNode(2, "textText", Map.of("data", "a"), List.of());
    EwtNode b = new EwtNode(3, "textText", Map.of("data", "b"), List.of());
    EwtNode col = new EwtNode(1, "columnColumn", Map.of("children", List.of(a, b)), List.of());
    String json = EwtNodeJson.encode(col);
    assertTrue(json.contains("\"children\":[{\"t\":\"textText\""), json);
    assertTrue(json.contains("\"data\":\"b\""), json);
  }
}
