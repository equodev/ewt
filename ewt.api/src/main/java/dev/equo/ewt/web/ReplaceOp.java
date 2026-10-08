package dev.equo.ewt.web;

import java.util.List;

/**
 * One patch op: put {@code node} in place of the node at {@code path}, subtree included. Emitted
 * where the two trees stop having the same shape (a different type, a param set or gone, a list
 * that grew or shrank), so the resend is bounded to that subtree instead of the whole region.
 * {@code path} elements are String (param key) or Integer (list index); it is never empty, since
 * a root that changed shape is a full snapshot instead.
 *
 * <p>java-11 split: a plain class (not a record) so it compiles at {@code --release 11}.
 */
public final class ReplaceOp {
  private final List<Object> path;
  private final EwtNode node;

  public ReplaceOp(List<Object> path, EwtNode node) {
    this.path = path;
    this.node = node;
  }

  public List<Object> path() { return path; }
  public EwtNode node() { return node; }
}
