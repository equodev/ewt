package dev.equo.ewt.web;

import java.util.List;
import java.util.Map;

/**
 * Minimal JSON encoder for an {@link EwtNode} tree. Phase 0 hand-rolls this to avoid pulling a
 * JSON dependency into ewt.api; a later phase may switch to Evolve's DSL-JSON. Supported param
 * value types: String, Integer, Double, Boolean.
 */
public final class EwtNodeJson {

  private EwtNodeJson() {}

  public static String encode(EwtNode root) {
    StringBuilder sb = new StringBuilder();
    write(sb, root);
    return sb.toString();
  }

  private static void write(StringBuilder sb, EwtNode n) {
    sb.append("{\"t\":");
    writeString(sb, n.type());
    sb.append(",\"id\":").append(n.id());
    sb.append(",\"p\":{");
    boolean first = true;
    for (Map.Entry<String, Object> e : n.params().entrySet()) {
      if (!first) sb.append(',');
      first = false;
      writeString(sb, e.getKey());
      sb.append(':');
      writeValue(sb, e.getValue());
    }
    sb.append("},\"c\":[");
    List<EwtNode> children = n.children();
    for (int i = 0; i < children.size(); i++) {
      if (i > 0) sb.append(',');
      write(sb, children.get(i));
    }
    sb.append("]}");
  }

  private static void writeValue(StringBuilder sb, Object v) {
    if (v instanceof String s) writeString(sb, s);
    else if (v instanceof Boolean || v instanceof Integer || v instanceof Double) sb.append(v);
    else throw new IllegalArgumentException("Unsupported param value type: " + v.getClass());
  }

  private static void writeString(StringBuilder sb, String s) {
    sb.append('"');
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      switch (c) {
        case '"' -> sb.append("\\\"");
        case '\\' -> sb.append("\\\\");
        case '\n' -> sb.append("\\n");
        case '\r' -> sb.append("\\r");
        case '\t' -> sb.append("\\t");
        default -> sb.append(c);
      }
    }
    sb.append('"');
  }
}
