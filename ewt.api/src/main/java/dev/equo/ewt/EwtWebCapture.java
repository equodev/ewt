package dev.equo.ewt;

import dev.equo.ewt.web.EwtNode;
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
      Widget rootWidget = builder.call().build();
      if (rootWidget instanceof SubStatefulWidget sw) {
        // Flatten: run the state's build() in Java (post-construction, fields initialized) and
        // serialize the built tree. The browser never sees a Sub* node.
        SubState<?> state = (SubState<?>) sw.createStateFn();
        state.setWebWidget(sw);
        EwtNode root = flatten(state, serializing);
        return new EwtCapture(root, serializing.callbacks(), state);
      }
      return new EwtCapture(serializing.rootNode(rootWidget.getId()), serializing.callbacks(), null);
    } finally {
      NativeObj.Base.factories = previous;
    }
  }

  /** Re-flatten a retained state under a fresh serializer (new node ids + new callback ids), reusing
   *  the SAME state instance so its fields persist. Used by a region on web-mode setState. */
  public static EwtCapture rebuild(SubState<?> state) {
    WidgetConstructors previous = NativeObj.Base.factories;
    SerializingWidgetConstructors serializing = new SerializingWidgetConstructors();
    NativeObj.Base.factories = serializing;
    try {
      EwtNode root = flatten(state, serializing);
      return new EwtCapture(root, serializing.callbacks(), state);
    } finally {
      NativeObj.Base.factories = previous;
    }
  }

  /** Runs the state's build() under the active serializer and returns the built root node. */
  static EwtNode flatten(SubState<?> state, SerializingWidgetConstructors serializing) {
    Widget built = state.buildFn(stubContext());
    return serializing.rootNode(built.getId());
  }

  /** A no-op BuildContext for web-mode builds (inherited-widget lookups are out of scope). */
  static BuildContext stubContext() {
    return new BuildContext() { public int getId() { return 0; } };
  }
}
