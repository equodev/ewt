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
  void encodesReplaceAfterSets() {
    SetParamsOp set = new SetParamsOp(List.of(), new java.util.LinkedHashMap<>(Map.of("spacing", 4)));
    ReplaceOp replace = new ReplaceOp(List.of("children", 0),
        new EwtNode(9, "iconIcon", Map.of(), List.of()));
    assertEquals(
        "{\"kind\":\"patch\",\"ops\":[{\"path\":[],\"set\":{\"spacing\":4}},"
            + "{\"path\":[\"children\",0],\"node\":{\"t\":\"iconIcon\",\"id\":9,\"p\":{},\"c\":[]}}]}",
        EwtPatchJson.encodePatch(Patch.of(List.of(set), List.of(replace))));
  }

  @Test
  void encodesSplicesBeforeSets() {
    SetParamsOp set = new SetParamsOp(List.of("children", 1), new java.util.LinkedHashMap<>(Map.of("onTap", 2)));
    SpliceOp splice = new SpliceOp(List.of(), "children", 1, 1,
        List.of(new EwtNode(9, "iconIcon", Map.of(), List.of())));
    assertEquals(
        "{\"kind\":\"patch\",\"ops\":["
            + "{\"path\":[],\"list\":\"children\",\"at\":1,\"remove\":1,\"insert\":[{\"t\":\"iconIcon\",\"id\":9,\"p\":{},\"c\":[]}]},"
            + "{\"path\":[\"children\",1],\"set\":{\"onTap\":2}}]}",
        EwtPatchJson.encodePatch(Patch.of(List.of(set), List.of(), List.of(splice))));
  }

  @Test
  void encodesLoneReplace() {
    ReplaceOp replace = new ReplaceOp(List.of("child"),
        new EwtNode(9, "iconIcon", Map.of(), List.of()));
    assertEquals(
        "{\"kind\":\"patch\",\"ops\":[{\"path\":[\"child\"],\"node\":{\"t\":\"iconIcon\",\"id\":9,\"p\":{},\"c\":[]}}]}",
        EwtPatchJson.encodePatch(Patch.of(List.of(), List.of(replace))));
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
