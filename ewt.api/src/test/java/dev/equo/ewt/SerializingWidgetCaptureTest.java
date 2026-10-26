package dev.equo.ewt;

import dev.equo.ewt.web.EwtNode;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SerializingWidgetCaptureTest {

  @Test
  void capturesSubtreeAndRestoresFactories() throws Exception {
    WidgetConstructors before = NativeObj.Base.factories;
    EwtCapture capture = EwtWebCapture.captureSubtree(
        () -> EWT.SizedBox().child(EWT.Text("x")).build());
    EwtNode node = capture.root;
    assertEquals("sizedBoxSizedBox", node.type());
    EwtNode child = (EwtNode) node.params().get("child");
    assertEquals("textText", child.type());
    assertEquals("x", child.params().get("data"));
    assertSame(before, NativeObj.Base.factories, "factories must be restored after capture");
  }

  // A SubStatelessWidget region root must be flattened to its built tree (like SubStatefulWidget),
  // so the browser never sees a subStatelessWidgetSubStatelessWidget node (which has no decoder).
  static class SlwProbe extends SubStatelessWidget {
    @Override
    protected Widget build(BuildContext context) {
      return EWT.Text("hi").build();
    }
  }

  @Test
  void flattensSubStatelessWidgetRoot() throws Exception {
    EwtCapture capture = EwtWebCapture.captureSubtree(() -> new SlwProbe());
    EwtNode node = capture.root;
    assertEquals("textText", node.type(),
        "SubStatelessWidget root must flatten to its built tree, not a Sub node");
    assertEquals("hi", node.params().get("data"));
  }

  // Draggable EwtGraphView — "approach (a)". The node tree, the String
  // positions, AND the onNodeMoved callback must all serialize over the comm
  // path the Evolve integration uses. The callback is a single-arg String
  // Consumer (multi-arg callbacks don't round-trip over comm), registered as a
  // callback id so Dart can report "id,x,y" back to Java.
  @Test
  void capturesDraggableGraphOverComm() throws Exception {
    EwtCapture capture = EwtWebCapture.captureSubtree(() -> EWT.EwtGraphView(List.of(
            EWT.Text("root").build(),
            EWT.Text("a").build(),
            EWT.Text("b").build()))
        .edges("0-1,0-2")
        .positions("10,10;80,80;150,80")
        .onNodeMoved(m -> { })
        .build());
    EwtNode node = capture.root;
    assertEquals("ewtGraphViewEwtGraphView", node.type());
    assertEquals("0-1,0-2", node.params().get("edges"));
    assertEquals("10,10;80,80;150,80", node.params().get("positions"));
    List<?> nodes = (List<?>) node.params().get("nodes");
    assertEquals(3, nodes.size());
    assertEquals("textText", ((EwtNode) nodes.get(0)).type());
    // onNodeMoved registered as a callback id -> the 1-arg String callback is
    // wired for the comm round-trip.
    assertTrue(node.params().get("onNodeMoved") instanceof Integer,
        "onNodeMoved must be wired as a comm callback id");
  }
}
