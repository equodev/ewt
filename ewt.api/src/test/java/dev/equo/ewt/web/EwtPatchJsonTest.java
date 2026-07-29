package dev.equo.ewt.web;

import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.assertEquals;

class EwtPatchJsonTest {

  @Test
  void encodesFullEnvelope() {
    EwtNode text = new EwtNode(1, "textText", Map.of("data", "hi"), List.of());
    assertEquals(
        "{\"kind\":\"full\",\"node\":{\"t\":\"textText\",\"id\":1,\"p\":{\"data\":\"hi\"},\"c\":[]}}",
        EwtPatchJson.encodeFull(text));
  }

  @Test
  void encodesPatchWithStringAndIntPath() {
    SetParamsOp op = new SetParamsOp(
        List.of("children", 2), new java.util.LinkedHashMap<>(Map.of("data", "x")));
    assertEquals(
        "{\"kind\":\"patch\",\"ops\":[{\"path\":[\"children\",2],\"set\":{\"data\":\"x\"}}]}",
        EwtPatchJson.encodePatch(Patch.of(List.of(op))));
  }

  @Test
  void encodesEmptyPatch() {
    assertEquals("{\"kind\":\"patch\",\"ops\":[]}",
        EwtPatchJson.encodePatch(Patch.of(List.of())));
  }

  @Test
  void structuralPatchFactoryBuildsStructuralEmptyPatch() {
    Patch p = Patch.structuralPatch();
    org.junit.jupiter.api.Assertions.assertTrue(p.structural());
    org.junit.jupiter.api.Assertions.assertTrue(p.ops().isEmpty());
  }
}
