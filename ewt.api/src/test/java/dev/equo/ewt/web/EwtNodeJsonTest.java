package dev.equo.ewt.web;

import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.assertEquals;

class EwtNodeJsonTest {

  @Test
  void encodesLeaf() {
    EwtNode text = new EwtNode(1, "Text", Map.of("data", "hi"), List.of());
    assertEquals("{\"t\":\"Text\",\"id\":1,\"p\":{\"data\":\"hi\"},\"c\":[]}",
        EwtNodeJson.encode(text));
  }

  @Test
  void encodesNestedWithNumbersAndBool() {
    EwtNode child = new EwtNode(2, "Text", Map.of("data", "x"), List.of());
    EwtNode box = new EwtNode(1, "SizedBox",
        Map.of("width", 10.0, "height", 20.0, "visible", true), List.of(child));
    String json = EwtNodeJson.encode(box);
    assertEquals(true, json.startsWith("{\"t\":\"SizedBox\",\"id\":1,"));
    assertEquals(true, json.contains("\"c\":[{\"t\":\"Text\",\"id\":2,"));
    assertEquals(true, json.contains("\"width\":10.0"));
    assertEquals(true, json.contains("\"visible\":true"));
  }
}
