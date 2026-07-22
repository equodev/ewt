package dev.equo.ewt;

import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
import java.util.concurrent.Callable;
import org.junit.jupiter.api.Test;
import static dev.equo.ewt.EWT.*;

class StatefulFlattenTest {
  // Minimal stateful widget: build() reads only local state, no Theme.of/widget()/Scaffold.
  static class TestCounter extends SubStatefulWidget {
    @Override protected State<TestCounter> createState() { return new S(); }
    static class S extends SubState<TestCounter> {
      int n = 0;
      @Override public Widget build(BuildContext context) {
        return Center().child(Text("Count: " + n)).build();
      }
      /** Triggers a setState mutation so tests can exercise the web branch. */
      public void bump() { setState(() -> n++); }
    }
  }

  @Test
  void flattenRunsBuildAndYieldsTheBuiltTreeNotASubNode() throws Exception {
    Callable<Widget> builder = TestCounter::new;
    EwtCapture cap = EwtWebCapture.captureSubtree(builder);
    // The published root is the built tree (centerCenter), never a Sub* node.
    assertEquals("centerCenter", cap.root.type());
    assertNotNull(cap.state, "a stateful root retains its State");
    // The state's field is readable and the tree reflects it.
    String json = dev.equo.ewt.web.EwtNodeJson.encode(cap.root);
    assertTrue(json.contains("Count: 0"), "built tree contains the state-derived text");
  }

  @Test
  void rebuildReusesStateSoFieldPersists() throws Exception {
    EwtCapture first = EwtWebCapture.captureSubtree(TestCounter::new);
    TestCounter.S state = (TestCounter.S) first.state;
    state.n = 5; // simulate a mutation
    EwtCapture again = EwtWebCapture.rebuild(state);
    String json = dev.equo.ewt.web.EwtNodeJson.encode(again.root);
    assertTrue(json.contains("Count: 5"), "rebuild re-runs build() on the SAME state");
    assertEquals("centerCenter", again.root.type());
  }

  // A stateful widget carrying a prop read via widget() in build().
  static class TitledCounter extends SubStatefulWidget {
    final String title;
    TitledCounter(String title) { this.title = title; }
    @Override protected State<TitledCounter> createState() { return new S(); }
    static class S extends SubState<TitledCounter> {
      @Override public Widget build(BuildContext context) {
        return Center().child(Text("T:" + widget().title)).build();
      }
    }
  }

  @Test
  void widgetAccessorReturnsTheOwningWidgetOnWeb() throws Exception {
    EwtCapture cap = EwtWebCapture.captureSubtree(() -> new TitledCounter("Home"));
    String json = dev.equo.ewt.web.EwtNodeJson.encode(cap.root);
    assertTrue(json.contains("T:Home"), "build() read widget().title via the web widget()");
  }

  @Test
  void webSetStateRunsFnAndRequestsRebuild() throws Exception {
    // Capture so the state exists and is registered by a fake region hook.
    EwtCapture cap = EwtWebCapture.captureSubtree(TestCounter::new);
    TestCounter.S state = (TestCounter.S) cap.state;
    boolean[] rebuilt = {false};
    EwtWebState.register(state, () -> rebuilt[0] = true);
    try {
      // Force web mode for this call.
      System.setProperty("dev.equo.swt.mode", ""); // unset == web (matches EwtWebTransport.isWebMode)
      state.bump(); // calls setState(() -> n++)
      assertEquals(1, state.n, "setState ran the mutation");
      assertTrue(rebuilt[0], "setState requested a region rebuild");
    } finally {
      EwtWebState.unregister(state);
    }
  }
}
