package dev.equo.ewt;

import dev.equo.ewt.web.EwtNode;
import java.util.Map;

/** Result of a web capture: the serialized root plus the id -> Runnable registry for wired callbacks. */
public final class EwtCapture {
  public final EwtNode root;
  public final Map<Integer, Object> callbacks;
  /** Non-null when the region root is a SubStatefulWidget; null for stateless roots. */
  public final SubState<?> state;

  public EwtCapture(EwtNode root, Map<Integer, Object> callbacks, SubState<?> state) {
    this.root = root;
    this.callbacks = callbacks;
    this.state = state;
  }
}
