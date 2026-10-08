package dev.equo.ewt.web;

import java.util.List;

/**
 * One patch op on a list-valued param of the node at {@code path}: remove {@code remove} elements
 * at {@code at} and put {@code insert} there. Emitted where a list of nodes changed length, so a
 * row filtered out or added travels as that row, not as the table around it. Several splices on
 * one list apply in order, each on the list as the previous one left it.
 *
 * <p>java-11 split: a plain class (not a record) so it compiles at {@code --release 11}.
 */
public final class SpliceOp {
  private final List<Object> path;
  private final String key;
  private final int at;
  private final int remove;
  private final List<EwtNode> insert;

  public SpliceOp(List<Object> path, String key, int at, int remove, List<EwtNode> insert) {
    this.path = path;
    this.key = key;
    this.at = at;
    this.remove = remove;
    this.insert = insert;
  }

  public List<Object> path() { return path; }
  public String key() { return key; }
  public int at() { return at; }
  public int remove() { return remove; }
  public List<EwtNode> insert() { return insert; }
}
