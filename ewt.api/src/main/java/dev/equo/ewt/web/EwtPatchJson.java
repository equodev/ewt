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
    // Splices first: the paths of the param sets and the replacements index the lists as the
    // splices leave them. Sets before replacements is only a convention (they never touch the
    // same node) that keeps the small ops first.
    int count = 0;
    for (SpliceOp op : patch.splices()) {
      if (count++ > 0) sb.append(',');
      writeSplice(sb, op);
    }
    for (SetParamsOp op : patch.ops()) {
      if (count++ > 0) sb.append(',');
      writeOp(sb, op);
    }
    for (ReplaceOp op : patch.replaces()) {
      if (count++ > 0) sb.append(',');
      writeReplace(sb, op);
    }
    sb.append("]}");
    return sb.toString();
  }

  private static void writeSplice(StringBuilder sb, SpliceOp op) {
    writePath(sb, op.path());
    sb.append(",\"list\":");
    EwtNodeJson.writeString(sb, op.key());
    sb.append(",\"at\":").append(op.at()).append(",\"remove\":").append(op.remove()).append(",\"insert\":[");
    List<EwtNode> insert = op.insert();
    for (int i = 0; i < insert.size(); i++) {
      if (i > 0) sb.append(',');
      EwtNodeJson.writeValue(sb, insert.get(i));
    }
    sb.append("]}");
  }

  private static void writeReplace(StringBuilder sb, ReplaceOp op) {
    writePath(sb, op.path());
    sb.append(",\"node\":");
    EwtNodeJson.writeValue(sb, op.node());
    sb.append('}');
  }

  private static void writePath(StringBuilder sb, List<Object> path) {
    sb.append("{\"path\":[");
    for (int i = 0; i < path.size(); i++) {
      if (i > 0) sb.append(',');
      Object step = path.get(i);
      if (step instanceof String) EwtNodeJson.writeString(sb, (String) step);
      else sb.append(step); // Integer list index
    }
    sb.append(']');
  }

  private static void writeOp(StringBuilder sb, SetParamsOp op) {
    writePath(sb, op.path());
    sb.append(",\"set\":{");
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
