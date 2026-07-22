package dev.equo.ewt;

import dev.equo.ewt.web.EwtNode;
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
}
