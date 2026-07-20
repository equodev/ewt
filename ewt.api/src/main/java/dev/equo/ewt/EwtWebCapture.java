package dev.equo.ewt;

import java.util.concurrent.Callable;

/**
 * Web path: build a subtree through a fresh SerializingWidgetConstructors installed as the active
 * constructors, and return an EwtCapture with its root node and callback registry. Lives outside
 * SerializingWidgetConstructors (which is generated and overwritten by the generator). No native
 * call is made.
 */
public final class EwtWebCapture {

  private EwtWebCapture() {}

  public static EwtCapture captureSubtree(Callable<Widget> builder) throws Exception {
    WidgetConstructors previous = NativeObj.Base.factories;
    SerializingWidgetConstructors serializing = new SerializingWidgetConstructors();
    NativeObj.Base.factories = serializing;
    try {
      Widget root = builder.call().build();
      return new EwtCapture(serializing.rootNode(root.getId()), serializing.callbacks());
    } finally {
      NativeObj.Base.factories = previous;
    }
  }
}
