package dev.equo.ewt;

import dev.equo.ewt.web.EwtNode;
import java.util.Map;

/** Result of a web capture: the serialized root plus the id -> Runnable registry for wired callbacks. */
public final class EwtCapture {
  public final EwtNode root;
  public final Map<Integer, Object> callbacks;
  /**
   * Non-null when the region root is a SubStatefulWidget; null for stateless roots.
   * Either a {@link SubState} or a {@link SubAnimatedState} instance.
   */
  public final Object state;
  /**
   * SubState/SubAnimatedState instances created by nested SubStatefulWidget children during
   * tree flattening. The caller must register these with EwtWebState so their setState()
   * triggers the same region rebuild as the root state's setState().
   */
  public final java.util.List<Object> nestedStates;

  public EwtCapture(EwtNode root, Map<Integer, Object> callbacks, Object state, java.util.List<Object> nestedStates) {
    this.root = root;
    this.callbacks = callbacks;
    this.state = state;
    this.nestedStates = nestedStates != null ? nestedStates : java.util.List.of();
  }

  /** Backward-compatible constructor for tests that don't exercise nested stateful widgets. */
  public EwtCapture(EwtNode root, Map<Integer, Object> callbacks, Object state) {
    this(root, callbacks, state, java.util.List.of());
  }
}
