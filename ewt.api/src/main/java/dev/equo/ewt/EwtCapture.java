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

  public EwtCapture(EwtNode root, Map<Integer, Object> callbacks, Object state) {
    this.root = root;
    this.callbacks = callbacks;
    this.state = state;
  }
}
