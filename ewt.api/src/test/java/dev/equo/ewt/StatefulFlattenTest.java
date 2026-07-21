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
}
