package dev.equo.ewt;

import dev.equo.ewt.web.EwtNode;
import java.util.Map;
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
      java.util.List<Object> nestedStates = new java.util.ArrayList<>();
      if (rootWidget instanceof SubStatefulWidget sw) {
        // The root sub-widget is handled here directly; remove it from deferred so
        // resolveDeferred does not try to process it again without setWebWidget.
        serializing.deferredStateful.remove(sw.getId());
        Object stateObj = sw.createStateFn();
        if (stateObj instanceof SubState<?> state) {
          state.setWebWidget(sw);
          state.initStateFn();
          Widget built = state.buildFn(stubContext());
          serializing.resolveDeferred(stubContext(), nestedStates);
          return new EwtCapture(serializing.rootNode(built.getId()), serializing.callbacks(), state, nestedStates);
        }
        if (stateObj instanceof SubAnimatedState<?> animState) {
          animState.setWebWidget(sw);
          if (animSink != null) animState.setWebAnimCommandSink(animSink);
          animState.initStateFn();
          Widget built = animState.buildFn(stubContext());
          serializing.resolveDeferred(stubContext(), nestedStates);
          return new EwtCapture(serializing.rootNode(built.getId()), serializing.callbacks(), animState, nestedStates);
        }
      }
      if (rootWidget instanceof SubStatelessWidget slw) {
        // Same: the root stateless sub-widget is handled here directly.
        serializing.deferredStateless.remove(slw.getId());
        Widget built = slw.buildFn(stubContext());
        serializing.resolveDeferred(stubContext(), nestedStates);
        return new EwtCapture(serializing.rootNode(built.getId()), serializing.callbacks(), null, nestedStates);
      }
      serializing.resolveDeferred(stubContext(), nestedStates);
      return new EwtCapture(serializing.rootNode(rootWidget.getId()), serializing.callbacks(), null, nestedStates);
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
      java.util.List<Object> nestedStates = new java.util.ArrayList<>();
      Widget built = state.buildFn(stubContext());
      serializing.resolveDeferred(stubContext(), nestedStates);
      return new EwtCapture(serializing.rootNode(built.getId()), serializing.callbacks(), state, nestedStates);
    } finally {
      NativeObj.Base.factories = previous;
      serializing.close();
    }
  }

  /** Re-flatten a retained SubAnimatedState under a fresh serializer. Controllers are pre-registered
   *  with their original ids so nextId advances past them before SubStateless placeholder ids are
   *  assigned — preventing collisions that would create EwtNode cycles. The Dart side matches by
   *  ctrlId and reuses existing AnimationControllers without restarting animations. */
  public static EwtCapture rebuildAnimated(SubAnimatedState<?> state) {
    WidgetConstructors previous = NativeObj.Base.factories;
    SerializingWidgetConstructors serializing = new SerializingWidgetConstructors();
    NativeObj.Base.factories = serializing;
    try {
      java.util.List<Object> nestedStates = new java.util.ArrayList<>();
      state.preregisterControllers(serializing);
      Widget built = state.buildFn(stubContext());
      serializing.resolveDeferred(stubContext(), nestedStates);
      return new EwtCapture(serializing.rootNode(built.getId()), serializing.callbacks(), state, nestedStates);
    } finally {
      NativeObj.Base.factories = previous;
      serializing.close();
    }
  }

  /**
   * Builds a Duration using a temporary SerializingWidgetConstructors so the native FFM factory
   * is never called. Safe to use in web-mode callbacks where {@code factories} is uninitialized.
   * Returns the total milliseconds (≥0) or -1 if not computable.
   */
  public static long buildDurationMillis(DurationI d) {
    synchronized (EwtWebCapture.class) {
      WidgetConstructors prev = NativeObj.Base.factories;
      SerializingWidgetConstructors ser = new SerializingWidgetConstructors();
      NativeObj.Base.factories = ser;
      try {
        Duration built = d.build();
        EwtNode node = ser.nodes().get(built.getId());
        if (node == null) return -1;
        Map<String, Object> p = node.params();
        long ms = 0;
        if (p.containsKey("days"))         ms += ((Number) p.get("days")).longValue() * 86400000L;
        if (p.containsKey("hours"))        ms += ((Number) p.get("hours")).longValue() * 3600000L;
        if (p.containsKey("minutes"))      ms += ((Number) p.get("minutes")).longValue() * 60000L;
        if (p.containsKey("seconds"))      ms += ((Number) p.get("seconds")).longValue() * 1000L;
        if (p.containsKey("milliseconds")) ms += ((Number) p.get("milliseconds")).longValue();
        if (p.containsKey("microseconds")) ms += ((Number) p.get("microseconds")).longValue() / 1000L;
        return ms;
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
