package dev.equo.ewt.web;

import org.junit.jupiter.api.Test;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.*;

class EwtDiffTest {

  private static EwtNode node(int id, String type, Map<String, Object> p) {
    return new EwtNode(id, type, p, List.of());
  }
  private static Map<String, Object> p(Object... kv) {
    Map<String, Object> m = new LinkedHashMap<>();
    for (int i = 0; i < kv.length; i += 2) m.put((String) kv[i], kv[i + 1]);
    return m;
  }

  @Test
  void identicalTreesProduceEmptyPatch() {
    EwtNode a = node(1, "textText", p("data", "x"));
    EwtNode b = node(1, "textText", p("data", "x"));
    Patch patch = EwtDiff.diff(a, b);
    assertFalse(patch.structural());
    assertTrue(patch.ops().isEmpty());
  }

  @Test
  void singlePrimitiveChangeIsOneRootOp() {
    EwtNode a = node(1, "textText", p("data", "old"));
    EwtNode b = node(1, "textText", p("data", "new"));
    Patch patch = EwtDiff.diff(a, b);
    assertFalse(patch.structural());
    assertEquals(1, patch.ops().size());
    SetParamsOp op = patch.ops().get(0);
    assertEquals(List.of(), op.path());
    assertEquals(Map.of("data", "new"), op.set());
  }

  @Test
  void nestedChildChangeHasDeepPath() {
    EwtNode a = node(1, "centerCenter", p("child", node(2, "textText", p("data", "old"))));
    EwtNode b = node(1, "centerCenter", p("child", node(2, "textText", p("data", "new"))));
    Patch patch = EwtDiff.diff(a, b);
    assertFalse(patch.structural());
    assertEquals(1, patch.ops().size());
    SetParamsOp op = patch.ops().get(0);
    assertEquals(List.of("child"), op.path());
    assertEquals(Map.of("data", "new"), op.set());
  }

  @Test
  void listElementChangeHasIndexInPath() {
    EwtNode a = node(1, "columnColumn", p("children",
        List.of(node(2, "textText", p("data", "a")), node(3, "textText", p("data", "b")))));
    EwtNode b = node(1, "columnColumn", p("children",
        List.of(node(2, "textText", p("data", "a")), node(3, "textText", p("data", "B")))));
    Patch patch = EwtDiff.diff(a, b);
    assertFalse(patch.structural());
    assertEquals(1, patch.ops().size());
    assertEquals(List.of("children", 1), patch.ops().get(0).path());
    assertEquals(Map.of("data", "B"), patch.ops().get(0).set());
  }

  @Test
  void typeChangeIsStructural() {
    assertTrue(EwtDiff.diff(node(1, "textText", p()), node(1, "iconIcon", p())).structural());
  }

  @Test
  void listLengthChangeIsStructural() {
    EwtNode a = node(1, "columnColumn", p("children", List.of(node(2, "textText", p()))));
    EwtNode b = node(1, "columnColumn",
        p("children", List.of(node(2, "textText", p()), node(3, "textText", p()))));
    assertTrue(EwtDiff.diff(a, b).structural());
  }

  @Test
  void paramKeySetChangeIsStructural() {
    EwtNode a = node(1, "textText", p("data", "x"));
    EwtNode b = node(1, "textText", p("data", "x", "maxLines", 2));
    assertTrue(EwtDiff.diff(a, b).structural());
  }

  @Test
  void nullToNonNullParamIsStructural() {
    java.util.Map<String, Object> pa = new java.util.LinkedHashMap<>();
    pa.put("child", null);
    java.util.Map<String, Object> pb = new java.util.LinkedHashMap<>();
    pb.put("child", node(2, "textText", p("data", "x")));
    org.junit.jupiter.api.Assertions.assertTrue(EwtDiff.diff(node(1, "centerCenter", pa), node(1, "centerCenter", pb)).structural());
    // and the reverse
    org.junit.jupiter.api.Assertions.assertTrue(EwtDiff.diff(node(1, "centerCenter", pb), node(1, "centerCenter", pa)).structural());
  }

  @Test
  void unchangedCallbackParamProducesNoOp() {
    // A callback serializes as an int cid; identical structure -> identical cid -> no op.
    EwtNode a = node(1, "elevatedButtonElevatedButton", p("onPressed", 7, "child",
        node(2, "textText", p("data", "old"))));
    EwtNode b = node(1, "elevatedButtonElevatedButton", p("onPressed", 7, "child",
        node(2, "textText", p("data", "new"))));
    Patch patch = EwtDiff.diff(a, b);
    assertFalse(patch.structural());
    assertEquals(1, patch.ops().size());
    assertEquals(List.of("child"), patch.ops().get(0).path()); // only the label, not onPressed
  }
}
