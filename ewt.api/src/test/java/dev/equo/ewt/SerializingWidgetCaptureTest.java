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
}
