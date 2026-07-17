package dev.equo.ewt;

import dev.equo.ewt.web.EwtNode;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SerializingWidgetCaptureTest {

  @Test
  void capturesSubtreeAndRestoresFactories() throws Exception {
    WidgetConstructors before = NativeObj.Base.factories;
    EwtNode node = SerializingWidgetConstructors.captureSubtree(
        () -> EWT.SizedBox().child(EWT.Text("x")).build());
    assertEquals("SizedBox", node.type());
    assertEquals(1, node.children().size());
    assertEquals("Text", node.children().get(0).type());
    assertEquals("x", node.children().get(0).params().get("data"));
    assertSame(before, NativeObj.Base.factories, "factories must be restored after capture");
  }
}
