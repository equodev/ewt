package dev.equo.ewt.web;

import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.*;

class EwtTraceTest {

  private static EwtNode page(String data) {
    return new EwtNode(1, "columnColumn", Map.of("children", List.of(
        new EwtNode(2, "textText", Map.of("data", data), List.of()),
        new EwtNode(3, "iconIcon", Map.of("icon", new EwtNode(4, "iconDataIconData", Map.of("codePoint", 1), List.of())), List.of()))),
        List.of());
  }

  @Test
  void offByDefault() {
    assertFalse(EwtTrace.ENABLED);
  }

  @Test
  void countsEveryNodeIncludingParamsAndMaps() {
    EwtNode swatch = new EwtNode(5, "materialColor",
        Map.of("swatch", Map.of("100", new EwtNode(6, "colorColor", Map.of("value", 1), List.of()))), List.of());
    assertEquals(4, EwtTrace.countNodes(page("x")));
    assertEquals(2, EwtTrace.countNodes(swatch));
  }

  @Test
  void fullSnapshotLine() {
    String json = EwtPatchJson.encodeFull(page("x"));
    String line = EwtTrace.publishLine(7, "setWidget", null, page("x"), json, 2_500_000, 300_000);
    assertEquals("region 7 setWidget: 4 nodes captured in 2.5 ms, encoded in 0.3 ms, full snapshot " + json.length() + " B", line);
  }

  @Test
  void patchLineCountsTheOps() {
    EwtNode prev = page("old"), next = page("new");
    String json = EwtPatchJson.encodePatch(EwtDiff.diff(prev, next));
    String line = EwtTrace.publishLine(7, "setState", prev, next, json, 1_000_000, 100_000);
    assertTrue(line.endsWith("patch " + json.length() + " B (1 sets, 0 replaces, 0 splices)"), line);
  }

  @Test
  void nothingToSendLine() {
    String line = EwtTrace.publishLine(7, "setWidget", page("x"), page("x"), null, 0, 0);
    assertTrue(line.endsWith("nothing to send"), line);
  }
}
