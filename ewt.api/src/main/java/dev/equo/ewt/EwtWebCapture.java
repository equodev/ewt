package dev.equo.ewt;

import dev.equo.ewt.web.EwtNode;
import java.util.concurrent.Callable;
import java.util.function.Consumer;

/**
 * Web path: build a subtree through a fresh SerializingWidgetConstructors installed as the active
 * constructors, and return an EwtCapture with its root node and callback registry. Lives outside
 * SerializingWidgetConstructors (which is generated and overwritten by the generator). No native
 * call is made.
 */
public final class EwtWebCapture {

  private EwtWebCapture() {}

  public static EwtCapture captureSubtree(Callable<Widget> builder) throws Exception {
    return captureSubtree(builder, null);
  }

  public static EwtCapture captureSubtree(Callable<Widget> builder, Consumer<String> animSink) throws Exception {
    WidgetConstructors previous = NativeObj.Base.factories;
    SerializingWidgetConstructors serializing = new SerializingWidgetConstructors();
    NativeObj.Base.factories = serializing;
    try {
      Widget rootWidget = builder.call().build();
      if (rootWidget instanceof SubStatefulWidget sw) {
        Object stateObj = sw.createStateFn();
        if (stateObj instanceof SubState<?> state) {
          // Flatten: run the state's build() in Java (post-construction, fields initialized) and
          // serialize the built tree. The browser never sees a Sub* node.
          state.setWebWidget(sw);
          // Match Flutter's lifecycle: initState() runs before the first build().
          state.initStateFn();
          EwtNode root = flatten(state, serializing);
          return new EwtCapture(root, serializing.callbacks(), state);
        }
        if (stateObj instanceof SubAnimatedState<?> animState) {
          // Same flattening as SubState but with AnimationController support: initState() creates
          // controllers (recorded as subAnimatedStateAnimationController nodes), then build()
          // references them. The Dart side owns the ticker and drives animation at 60fps; Java
          // sends imperative commands (forward/reverse/etc.) via the anim comm channel.
          // The sink must be set BEFORE initStateFn() so any initial commands (e.g. ctrl.forward()
          // in initState) are not silently dropped.
          animState.setWebWidget(sw);
          if (animSink != null) animState.setWebAnimCommandSink(animSink);
          animState.initStateFn();
          EwtNode root = flattenAnimated(animState, serializing);
          return new EwtCapture(root, serializing.callbacks(), animState);
        }
      }
      if (rootWidget instanceof SubStatelessWidget slw) {
        // Flatten: run build() in Java and serialize the built tree. No retained state (stateless),
        // so no setState/rebuild path — just like SubStatefulWidget, the browser never sees a Sub* node.
        Widget built = slw.buildFn(stubContext());
        return new EwtCapture(serializing.rootNode(built.getId()), serializing.callbacks(), null);
      }
      return new EwtCapture(serializing.rootNode(rootWidget.getId()), serializing.callbacks(), null);
    } finally {
      NativeObj.Base.factories = previous;
      serializing.close();
    }
  }

  /** Re-flatten a retained SubState under a fresh serializer (new node ids + new callback ids), reusing
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
      serializing.close();
    }
  }

  /** Re-flatten a retained SubAnimatedState under a fresh serializer. Controller instances persist
   *  in the state's fields; the Dart side matches by ctrlId and reuses existing AnimationControllers. */
  public static EwtCapture rebuildAnimated(SubAnimatedState<?> state) {
    WidgetConstructors previous = NativeObj.Base.factories;
    SerializingWidgetConstructors serializing = new SerializingWidgetConstructors();
    NativeObj.Base.factories = serializing;
    try {
      EwtNode root = flattenAnimated(state, serializing);
      return new EwtCapture(root, serializing.callbacks(), state);
    } finally {
      NativeObj.Base.factories = previous;
      serializing.close();
    }
  }

  /** Runs a SubState's build() under the active serializer and returns the built root node. */
  static EwtNode flatten(SubState<?> state, SerializingWidgetConstructors serializing) {
    Widget built = state.buildFn(stubContext());
    return serializing.rootNode(built.getId());
  }

  /** Runs a SubAnimatedState's build() under the active serializer and returns the built root node. */
  static EwtNode flattenAnimated(SubAnimatedState<?> state, SerializingWidgetConstructors serializing) {
    Widget built = state.buildFn(stubContext());
    return serializing.rootNode(built.getId());
  }

  /**
   * Builds a Duration using a temporary SerializingWidgetConstructors so the native FFM factory
   * is never called. Safe to use in web-mode callbacks where {@code factories} is uninitialized.
   * Returns {@code d.webMillis} (≥0) or -1 if not computable.
   */
  public static long buildDurationMillis(DurationI d) {
    synchronized (EwtWebCapture.class) {
      WidgetConstructors prev = NativeObj.Base.factories;
      SerializingWidgetConstructors ser = new SerializingWidgetConstructors();
      NativeObj.Base.factories = ser;
      try {
        return d.build().webMillis;
      } finally {
        NativeObj.Base.factories = prev;
        ser.close();
      }
    }
  }

  /** A no-op BuildContext for web-mode builds (inherited-widget lookups are out of scope). */
  static BuildContext stubContext() {
    return new BuildContext() { public int getId() { return 0; } };
  }
}
