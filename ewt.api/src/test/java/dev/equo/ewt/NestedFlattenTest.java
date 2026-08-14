package dev.equo.ewt;

import dev.equo.ewt.web.EwtNodeJson;
import org.junit.jupiter.api.Test;

import java.util.List;

import static dev.equo.ewt.EWT.*;
import static org.junit.jupiter.api.Assertions.*;

class NestedFlattenTest {

  static class Inner extends SubStatelessWidget {
    final String label;
    Inner(String label) { this.label = label; }
    @Override protected Widget build(BuildContext ctx) {
      return Text(label).build();
    }
  }

  static class OuterStateless extends SubStatelessWidget {
    @Override protected Widget build(BuildContext ctx) {
      return Column().children(List.of(new Inner("nested"))).build();
    }
  }

  @Test
  void slwNestedInSlwFlattens() throws Exception {
    EwtCapture cap = EwtWebCapture.captureSubtree(() -> new OuterStateless());
    assertEquals("columnColumn", cap.root.type(), "outer root must be the column, not a Sub node");
    String json = EwtNodeJson.encode(cap.root);
    assertFalse(json.contains("subStateless"), "no Sub* placeholder should survive in the JSON");
    assertTrue(json.contains("nested"), "inner text must appear in the flattened tree");
  }

  static class OuterStateful extends SubStatefulWidget {
    @Override protected State<OuterStateful> createState() { return new S(); }
    static class S extends SubState<OuterStateful> {
      @Override public Widget build(BuildContext ctx) {
        return Column().children(List.of(new Inner("from-stateful"))).build();
      }
    }
  }

  @Test
  void slwNestedInSfwFlattens() throws Exception {
    EwtCapture cap = EwtWebCapture.captureSubtree(() -> new OuterStateful());
    assertEquals("columnColumn", cap.root.type(), "outer root must be the column, not a Sub node");
    String json = EwtNodeJson.encode(cap.root);
    assertFalse(json.contains("subStateless"), "no Sub* placeholder should survive in the JSON");
    assertTrue(json.contains("from-stateful"), "inner text must appear in the flattened tree");
    assertTrue(cap.nestedStates.isEmpty(), "a stateless inner widget adds no nested states");
  }

  static class InnerStateful extends SubStatefulWidget {
    final String label;
    InnerStateful(String label) { this.label = label; }
    @Override protected State<InnerStateful> createState() { return new S(); }
    static class S extends SubState<InnerStateful> {
      @Override public Widget build(BuildContext ctx) {
        return Text(widget().label + "-built").build();
      }
    }
  }

  static class OuterWithStatefulChild extends SubStatefulWidget {
    @Override protected State<OuterWithStatefulChild> createState() { return new S(); }
    static class S extends SubState<OuterWithStatefulChild> {
      @Override public Widget build(BuildContext ctx) {
        return Column().children(List.of(new InnerStateful("child"))).build();
      }
    }
  }

  @Test
  void sfwNestedInSfwFlattensAndRegistersNestedState() throws Exception {
    EwtCapture cap = EwtWebCapture.captureSubtree(() -> new OuterWithStatefulChild());
    assertEquals("columnColumn", cap.root.type(), "outer root must be the column");
    String json = EwtNodeJson.encode(cap.root);
    assertFalse(json.contains("subStateful"), "no Sub* placeholder should survive in the JSON");
    assertTrue(json.contains("child-built"), "inner stateful widget's built text must appear");
    assertEquals(1, cap.nestedStates.size(), "one nested SubState expected");
    assertInstanceOf(SubState.class, cap.nestedStates.get(0));
  }
}
