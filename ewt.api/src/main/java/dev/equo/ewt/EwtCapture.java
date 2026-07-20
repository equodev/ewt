package dev.equo.ewt;

import dev.equo.ewt.web.EwtNode;
import java.util.Map;

/** Result of a web capture: the serialized root plus the id -> Runnable registry for wired callbacks. */
public final class EwtCapture {
  public final EwtNode root;
  public final Map<Integer, Object> callbacks;

  public EwtCapture(EwtNode root, Map<Integer, Object> callbacks) {
    this.root = root;
    this.callbacks = callbacks;
  }
}
