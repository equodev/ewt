package dev.equo.ewt;

import dev.equo.ewt.web.EwtNode;

import java.util.concurrent.Callable;

/**
 * Web path: build a subtree through a fresh SerializingWidgetConstructors installed as the active
 * constructors, and return its root node. Lives outside SerializingWidgetConstructors (which is
 * generated and overwritten by the generator). No native call is made.
 */
public final class EwtWebCapture {

  private EwtWebCapture() {}

  public static EwtNode captureSubtree(Callable<Widget> builder) throws Exception {
    WidgetConstructors previous = NativeObj.Base.factories;
    SerializingWidgetConstructors serializing = new SerializingWidgetConstructors();
    NativeObj.Base.factories = serializing;
    try {
      Widget root = builder.call().build();
      return serializing.rootNode(root.getId());
    } finally {
      NativeObj.Base.factories = previous;
    }
  }
}
