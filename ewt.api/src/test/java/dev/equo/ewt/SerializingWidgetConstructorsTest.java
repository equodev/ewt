package dev.equo.ewt;

import dev.equo.ewt.web.EwtNode;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SerializingWidgetConstructorsTest {

  private SerializingWidgetConstructors serializing;

  @BeforeEach
  void installSerializing() {
    serializing = new SerializingWidgetConstructors();
    WidgetConstructorsBase.instance = serializing;
    NativeObj.Base.factories = serializing;
  }

  @AfterEach
  void restore() {
    WidgetConstructors original = new WidgetConstructors();
    WidgetConstructorsBase.instance = original;
    NativeObj.Base.factories = original;
  }

  @Test
  void recordsTextLeaf() {
    var text = EWT.Text("hola").build();
    var node = serializing.rootNode(text.getId());
    // t is the factory name; child(ren) live in params, not the children list.
    assertEquals("textText", node.type());
    assertEquals("hola", node.params().get("data"));
  }

  @Test
  void recordsSizedBoxWithTextChild() {
    var box = EWT.SizedBox().child(EWT.Text("inner")).width(30.0).build();
    var node = serializing.rootNode(box.getId());
    assertEquals("sizedBoxSizedBox", node.type());
    assertEquals(30.0, node.params().get("width"));
    EwtNode child = (EwtNode) node.params().get("child");
    assertEquals("textText", child.type());
    assertEquals("inner", child.params().get("data"));
  }
}
