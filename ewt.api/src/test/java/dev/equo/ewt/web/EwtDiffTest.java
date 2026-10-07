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
  void aNodeListAtRootThatChangedLengthIsASpliceNotStructural() {
    EwtNode a = node(1, "columnColumn", p("children", List.of(node(2, "textText", p()))));
    EwtNode b = node(1, "columnColumn",
        p("children", List.of(node(2, "textText", p()), node(3, "textText", p()))));
    Patch patch = EwtDiff.diff(a, b);
    assertFalse(patch.structural());
    assertEquals(1, patch.splices().size());
  }

  @Test
  void aMixedListThatChangedLengthAtRootIsStructural() {
    EwtNode a = node(1, "row", p("items", List.of(node(2, "textText", p()), "x")));
    EwtNode b = node(1, "row", p("items", List.of(node(2, "textText", p()), "x", "y")));
    assertTrue(EwtDiff.diff(a, b).structural());
  }

  @Test
  void paramKeySetChangeAtRootIsStructural() {
    EwtNode a = node(1, "textText", p("data", "x"));
    EwtNode b = node(1, "textText", p("data", "x", "maxLines", 2));
    assertTrue(EwtDiff.diff(a, b).structural());
  }

  @Test
  void nullToNonNullParamAtRootIsStructural() {
    java.util.Map<String, Object> pa = new java.util.LinkedHashMap<>();
    pa.put("child", null);
    java.util.Map<String, Object> pb = new java.util.LinkedHashMap<>();
    pb.put("child", node(2, "textText", p("data", "x")));
    org.junit.jupiter.api.Assertions.assertTrue(EwtDiff.diff(node(1, "centerCenter", pa), node(1, "centerCenter", pb)).structural());
    // and the reverse
    org.junit.jupiter.api.Assertions.assertTrue(EwtDiff.diff(node(1, "centerCenter", pb), node(1, "centerCenter", pa)).structural());
  }

  @Test
  void nestedTypeChangeReplacesThatNodeOnly() {
    EwtNode a = node(1, "centerCenter", p("child", node(2, "textText", p("data", "x"))));
    EwtNode next = node(2, "iconIcon", p());
    EwtNode b = node(1, "centerCenter", p("child", next));
    Patch patch = EwtDiff.diff(a, b);
    assertFalse(patch.structural());
    assertTrue(patch.ops().isEmpty());
    assertEquals(1, patch.replaces().size());
    assertEquals(List.of("child"), patch.replaces().get(0).path());
    assertSame(next, patch.replaces().get(0).node());
  }

  @Test
  void aRowAddedToAListTravelsAsOneInsert() {
    EwtNode a = node(1, "columnColumn", p("children", List.of(node(2, "textText", p("data", "a")))));
    EwtNode added = node(4, "textText", p("data", "b"));
    EwtNode b = node(1, "columnColumn", p("children", List.of(node(3, "textText", p("data", "a")), added)));
    Patch patch = EwtDiff.diff(a, b);
    assertFalse(patch.structural());
    assertTrue(patch.ops().isEmpty());
    assertTrue(patch.replaces().isEmpty());
    assertEquals(1, patch.splices().size());
    SpliceOp s = patch.splices().get(0);
    assertEquals(List.of(), s.path());
    assertEquals("children", s.key());
    assertEquals(1, s.at());
    assertEquals(0, s.remove());
    assertEquals(List.of(added), s.insert());
  }

  @Test
  void rowsFilteredOutOfAListTravelAsRemovalsAndTheShiftedCallbackIds() {
    // Three rows with a tap callback each; the middle one goes away. The row after it keeps
    // its content but its callback id shifts from 3 to 2 — that is a setParams on it, at its
    // index in the list as the splice leaves it.
    EwtNode a = node(1, "listViewListView", p("children", List.of(
        node(2, "inkWellInkWell", p("onTap", 1, "child", node(3, "textText", p("data", "x")))),
        node(4, "inkWellInkWell", p("onTap", 2, "child", node(5, "textText", p("data", "y")))),
        node(6, "inkWellInkWell", p("onTap", 3, "child", node(7, "textText", p("data", "z")))))));
    EwtNode b = node(1, "listViewListView", p("children", List.of(
        node(2, "inkWellInkWell", p("onTap", 1, "child", node(3, "textText", p("data", "x")))),
        node(4, "inkWellInkWell", p("onTap", 2, "child", node(5, "textText", p("data", "z")))))));
    Patch patch = EwtDiff.diff(a, b);
    assertFalse(patch.structural());
    assertEquals(1, patch.splices().size());
    SpliceOp s = patch.splices().get(0);
    assertEquals(1, s.at());
    assertEquals(1, s.remove());
    assertTrue(s.insert().isEmpty());
    assertTrue(patch.replaces().isEmpty());
    assertEquals(1, patch.ops().size());
    assertEquals(List.of("children", 1), patch.ops().get(0).path());
    assertEquals(Map.of("onTap", 2), patch.ops().get(0).set());
  }

  @Test
  void aListReplacedWholeIsOneSpliceOfEverything() {
    EwtNode a = node(1, "columnColumn", p("children", List.of(node(2, "textText", p("data", "a")), node(3, "textText", p("data", "b")))));
    EwtNode b = node(1, "columnColumn", p("children", List.of(node(2, "iconIcon", p()))));
    Patch patch = EwtDiff.diff(a, b);
    assertEquals(1, patch.splices().size());
    SpliceOp s = patch.splices().get(0);
    assertEquals(0, s.at());
    assertEquals(2, s.remove());
    assertEquals(1, s.insert().size());
    assertTrue(patch.ops().isEmpty());
  }

  @Test
  void aMapParamHoldingNodesIsNotChangedByANewCapture() {
    // A MaterialColor swatch: a map of colour nodes. Nodes are never equal by equals(), so a map
    // compared whole looked changed on every capture and re-sent the swatch of every icon.
    EwtNode a = node(1, "iconIcon", p("color", node(2, "materialColorShade",
        p("receiver", node(3, "materialColor", p("swatch", Map.of("100", node(4, "colorColor", p("value", 1)))))))));
    EwtNode b = node(1, "iconIcon", p("color", node(5, "materialColorShade",
        p("receiver", node(6, "materialColor", p("swatch", Map.of("100", node(7, "colorColor", p("value", 1)))))))));
    assertTrue(EwtDiff.diff(a, b).isEmpty());
  }

  @Test
  void aChangedNodeInsideAMapParamIsOneOpAtTheMapKey() {
    EwtNode a = node(1, "materialColor", p("swatch", Map.of("100", node(2, "colorColor", p("value", 1)))));
    EwtNode b = node(1, "materialColor", p("swatch", Map.of("100", node(3, "colorColor", p("value", 2)))));
    Patch patch = EwtDiff.diff(a, b);
    assertEquals(1, patch.ops().size());
    assertEquals(List.of("swatch", "100"), patch.ops().get(0).path());
    assertEquals(Map.of("value", 2), patch.ops().get(0).set());
  }

  @Test
  void aMapParamWhoseKeysChangedIsReSetWhole() {
    EwtNode a = node(1, "materialColor", p("swatch", Map.of("100", node(2, "colorColor", p("value", 1)))));
    java.util.Map<String, Object> bigger = new LinkedHashMap<>();
    bigger.put("100", node(3, "colorColor", p("value", 1)));
    bigger.put("200", node(4, "colorColor", p("value", 2)));
    EwtNode b = node(1, "materialColor", p("swatch", bigger));
    Patch patch = EwtDiff.diff(a, b);
    assertEquals(1, patch.ops().size());
    assertEquals(List.of(), patch.ops().get(0).path());
    assertSame(bigger, patch.ops().get(0).set().get("swatch"));
  }

  @Test
  void aPrimitiveListThatChangedLengthIsReSetWhole() {
    EwtNode a = node(1, "row", p("tags", List.of("x")));
    EwtNode b = node(1, "row", p("tags", List.of("x", "y")));
    Patch patch = EwtDiff.diff(a, b);
    assertFalse(patch.structural());
    assertEquals(List.of("x", "y"), patch.ops().get(0).set().get("tags"));
  }

  @Test
  void nestedKeySetChangeReplacesThatNode() {
    EwtNode a = node(1, "centerCenter", p("child", node(2, "textText", p("data", "x"))));
    EwtNode b = node(1, "centerCenter", p("child", node(2, "textText", p("data", "x", "maxLines", 2))));
    Patch patch = EwtDiff.diff(a, b);
    assertFalse(patch.structural());
    assertEquals(List.of("child"), patch.replaces().get(0).path());
  }

  @Test
  void replacedSubtreeDoesNotStopTheRestOfTheDiff() {
    // The sibling after the replaced one still gets its changed param (and a shifted callback
    // id, which is just another changed primitive) as a setParams op.
    EwtNode a = node(1, "columnColumn", p("children", List.of(
        node(2, "textText", p("data", "x")),
        node(3, "elevatedButtonElevatedButton", p("onPressed", 1, "child", node(4, "textText", p("data", "go")))))));
    EwtNode b = node(1, "columnColumn", p("children", List.of(
        node(2, "iconIcon", p()),
        node(5, "elevatedButtonElevatedButton", p("onPressed", 2, "child", node(6, "textText", p("data", "go")))))));
    Patch patch = EwtDiff.diff(a, b);
    assertFalse(patch.structural());
    assertEquals(1, patch.replaces().size());
    assertEquals(List.of("children", 0), patch.replaces().get(0).path());
    assertEquals(1, patch.ops().size());
    assertEquals(List.of("children", 1), patch.ops().get(0).path());
    assertEquals(Map.of("onPressed", 2), patch.ops().get(0).set());
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

  @Test
  void multipleChangedPrimitivesInOneNodeMergeIntoOneOp() {
    EwtNode a = node(1, "textText", p("data", "old", "maxLines", 1));
    EwtNode b = node(1, "textText", p("data", "new", "maxLines", 3));
    Patch patch = EwtDiff.diff(a, b);
    assertFalse(patch.structural());
    assertEquals(1, patch.ops().size(), "both changes collapse into one op");
    SetParamsOp op = patch.ops().get(0);
    assertEquals(List.of(), op.path());
    assertEquals(Map.of("data", "new", "maxLines", 3), op.set());
  }

  @Test
  void primitiveListElementChangeIsOneOp() {
    EwtNode a = node(1, "row", p("tags", List.of("x", "y")));
    EwtNode b = node(1, "row", p("tags", List.of("x", "Z")));
    Patch patch = EwtDiff.diff(a, b);
    assertFalse(patch.structural());
    assertEquals(1, patch.ops().size());
    SetParamsOp op = patch.ops().get(0);
    assertEquals(List.of(), op.path()); // at root node level
    assertEquals(List.of("x", "Z"), op.set().get("tags")); // whole list replaced
  }

  @Test
  void threeLevelNestedPathIsCorrect() {
    EwtNode grandchild_a = node(3, "textText", p("data", "old"));
    EwtNode grandchild_b = node(3, "textText", p("data", "new"));
    EwtNode child_a = node(2, "paddingPadding", p("child", grandchild_a));
    EwtNode child_b = node(2, "paddingPadding", p("child", grandchild_b));
    EwtNode a = node(1, "centerCenter", p("child", child_a));
    EwtNode b = node(1, "centerCenter", p("child", child_b));
    Patch patch = EwtDiff.diff(a, b);
    assertFalse(patch.structural());
    assertEquals(1, patch.ops().size());
    assertEquals(List.of("child", "child"), patch.ops().get(0).path());
    assertEquals(Map.of("data", "new"), patch.ops().get(0).set());
  }
}
