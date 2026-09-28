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
    write(sb, root, new java.util.LinkedHashMap<>(), 0);
    return sb.toString();
  }

  private static void write(StringBuilder sb, EwtNode n, java.util.Map<Integer,String> visited, int depth) {
    if (visited.containsKey(n.id())) {
      System.err.println("EwtNodeJson: cycle at id=" + n.id() + " type=" + n.type());
      System.err.println("  path: " + visited.values());
      sb.append("{\"t\":\"__cycle__\",\"id\":").append(n.id()).append(",\"p\":{},\"c\":[]}");
      return;
    }
    if (depth > 300) {
      System.err.println("EwtNodeJson: depth limit reached at id=" + n.id() + " type=" + n.type());
      sb.append("{\"t\":\"__depth_limit__\",\"id\":").append(n.id()).append(",\"p\":{},\"c\":[]}");
      return;
    }
    visited.put(n.id(), n.type());
    sb.append("{\"t\":");
    writeString(sb, n.type());
    sb.append(",\"id\":").append(n.id());
    sb.append(",\"p\":{");
    boolean first = true;
    for (Map.Entry<String, Object> e : n.params().entrySet()) {
      Object val = e.getValue();
      if (val == null) continue; // skip null params (e.g. unresolved node refs)
      // Absent optionals are omitted entirely (same as if the param was not set).
      if (val instanceof java.util.Optional<?> && ((java.util.Optional<?>) val).isEmpty()) continue;
      if (!first) sb.append(',');
      first = false;
      writeString(sb, e.getKey());
      sb.append(':');
      writeValue(sb, val instanceof java.util.Optional<?> ? ((java.util.Optional<?>) val).get() : val, visited, depth + 1);
    }
    sb.append("},\"c\":[");
    List<EwtNode> children = n.children();
    for (int i = 0; i < children.size(); i++) {
      if (i > 0) sb.append(',');
      write(sb, children.get(i), visited, depth + 1);
    }
    sb.append("]}");
    visited.remove(n.id());
  }

  static void writeValue(StringBuilder sb, Object v) {
    writeValue(sb, v, new java.util.LinkedHashMap<>(), 0);
  }

  static void writeValue(StringBuilder sb, Object v, java.util.Map<Integer,String> visited, int depth) {
    if (v instanceof String) writeString(sb, (String) v);
    else if (v instanceof Boolean || v instanceof Integer || v instanceof Double || v instanceof Long) sb.append(v);
    else if (v instanceof EwtNode) write(sb, (EwtNode) v, visited, depth);
    else if (v instanceof java.util.List<?>) {
      java.util.List<?> list = (java.util.List<?>) v;
      sb.append('[');
      for (int i = 0; i < list.size(); i++) {
        if (i > 0) sb.append(',');
        writeValue(sb, list.get(i), visited, depth);
      }
      sb.append(']');
    } else if (v instanceof java.util.Map<?, ?>) {
      java.util.Map<?, ?> map = (java.util.Map<?, ?>) v;
      sb.append('{');
      boolean first = true;
      for (java.util.Map.Entry<?, ?> e : map.entrySet()) {
        if (!first) sb.append(',');
        first = false;
        writeString(sb, String.valueOf(e.getKey()));
        sb.append(':');
        writeValue(sb, e.getValue(), visited, depth);
      }
      sb.append('}');
    } else if (v instanceof java.util.Optional<?>) {
      java.util.Optional<?> opt = (java.util.Optional<?>) v;
      if (opt.isPresent()) writeValue(sb, opt.get(), visited, depth);
      else sb.append("null");
    } else {
      throw new IllegalArgumentException("Unsupported param value type: " + v.getClass());
    }
  }

  static void writeString(StringBuilder sb, String s) {
    sb.append('"');
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      // java-11 split: classic switch (not the arrow form) so it compiles at --release 11.
      switch (c) {
        case '"': sb.append("\\\""); break;
        case '\\': sb.append("\\\\"); break;
        case '\n': sb.append("\\n"); break;
        case '\r': sb.append("\\r"); break;
        case '\t': sb.append("\\t"); break;
        default:
          if (c < 0x20) {
            // Escape all other control characters as a JSON Unicode escape sequence.
            sb.append(String.format("\\u%04X", (int) c));
          } else {
            sb.append(c);
          }
      }
    }
    sb.append('"');
  }
}
