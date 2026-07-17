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
    assertEquals("Text", node.type());
    assertEquals("hola", node.params().get("data"));
    assertTrue(node.children().isEmpty());
  }

  @Test
  void recordsSizedBoxWithTextChild() {
    var box = EWT.SizedBox().child(EWT.Text("inner")).width(30.0).build();
    var node = serializing.rootNode(box.getId());
    assertEquals("SizedBox", node.type());
    assertEquals(30.0, node.params().get("width"));
    assertEquals(1, node.children().size());
    assertEquals("Text", node.children().get(0).type());
    assertEquals("inner", node.children().get(0).params().get("data"));
  }
}
