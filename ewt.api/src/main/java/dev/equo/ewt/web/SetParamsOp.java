package dev.equo.ewt.web;

import java.util.List;
import java.util.Map;

/**
 * One patch op: merge {@code set} (primitive params) into the node at {@code path}.
 * {@code path} elements are String (param key) or Integer (list index).
 *
 * <p>java-11 split: a plain class (not a record) so it compiles at {@code --release 11}.
 */
public final class SetParamsOp {
  private final List<Object> path;
  private final Map<String, Object> set;

  public SetParamsOp(List<Object> path, Map<String, Object> set) {
    this.path = path;
    this.set = set;
  }

  public List<Object> path() { return path; }
  public Map<String, Object> set() { return set; }
}
