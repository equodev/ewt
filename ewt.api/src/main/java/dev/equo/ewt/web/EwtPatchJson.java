package dev.equo.ewt.web;

import java.util.List;
import java.util.Map;

/** Wraps an EwtNode tree or a Patch in the transport envelope. Reuses {@link EwtNodeJson}'s
 *  value/string writers so the wire format stays identical to the node encoder. */
public final class EwtPatchJson {

  private EwtPatchJson() {}

  public static String encodeFull(EwtNode node) {
    return "{\"kind\":\"full\",\"node\":" + EwtNodeJson.encode(node) + "}";
  }

  public static String encodePatch(Patch patch) {
    StringBuilder sb = new StringBuilder();
    sb.append("{\"kind\":\"patch\",\"ops\":[");
    List<SetParamsOp> ops = patch.ops();
    for (int i = 0; i < ops.size(); i++) {
      if (i > 0) sb.append(',');
      writeOp(sb, ops.get(i));
    }
    sb.append("]}");
    return sb.toString();
  }

  private static void writeOp(StringBuilder sb, SetParamsOp op) {
    sb.append("{\"path\":[");
    List<Object> path = op.path();
    for (int i = 0; i < path.size(); i++) {
      if (i > 0) sb.append(',');
      Object step = path.get(i);
      if (step instanceof String s) EwtNodeJson.writeString(sb, s);
      else sb.append(step); // Integer list index
    }
    sb.append("],\"set\":{");
    boolean first = true;
    for (Map.Entry<String, Object> e : op.set().entrySet()) {
      if (!first) sb.append(',');
      first = false;
      EwtNodeJson.writeString(sb, e.getKey());
      sb.append(':');
      EwtNodeJson.writeValue(sb, e.getValue());
    }
    sb.append("}}");
  }
}
