package dev.equo.ewt.web;

import java.util.List;
import java.util.Map;

/**
 * Neutral, transport-agnostic description of one EWT widget node.
 *
 * <p>java-11 split: a plain class (not a record) so it compiles at {@code --release 11}. Value
 * equality is not relied upon anywhere, so no {@code equals}/{@code hashCode} is generated.
 */
public final class EwtNode {
  private final int id;
  private final String type;
  private final Map<String, Object> params;
  private final List<EwtNode> children;

  public EwtNode(int id, String type, Map<String, Object> params, List<EwtNode> children) {
    this.id = id;
    this.type = type;
    this.params = params;
    this.children = children;
  }

  public int id() { return id; }
  public String type() { return type; }
  public Map<String, Object> params() { return params; }
  public List<EwtNode> children() { return children; }
}
