package dev.equo.ewt.web;

import java.util.List;
import java.util.Map;

/**
 * The one switch for EWT's diagnostic output: {@code -Ddev.equo.ewt.trace=true}. Off by default,
 * read once into a constant, so a call site written as {@code if (EwtTrace.ENABLED) ...} costs
 * nothing in a product. Output goes to {@code System.err}: a product that routes
 * {@code System.out} to a log file turns every line into a synchronous write on the UI thread,
 * which is how a per-node print once became a visible stall.
 *
 * <p>What is traced is one line per publish of a region — the size of the capture and of what
 * went out — not one line per node: that is what tells, in a drag, whether a page is being re-sent
 * and how much of it travels.
 */
public final class EwtTrace {

  public static final boolean ENABLED = Boolean.getBoolean("dev.equo.ewt.trace");

  private EwtTrace() {}

  public static void log(String line) {
    System.err.println("[ewt] " + line);
  }

  /**
   * The line for one publish of a region over comm. {@code json} is what went out: a full
   * snapshot, a patch, or null when nothing changed. Static and SWT-free so it can be tested.
   */
  public static String publishLine(int regionId, String how, EwtNode prev, EwtNode next, String json,
      long captureNanos, long encodeNanos) {
    StringBuilder sb = new StringBuilder();
    sb.append("region ").append(regionId).append(' ').append(how).append(": ")
      .append(countNodes(next)).append(" nodes captured in ").append(millis(captureNanos))
      .append(" ms, encoded in ").append(millis(encodeNanos)).append(" ms, ");
    if (json == null) {
      sb.append("nothing to send");
    } else if (json.startsWith("{\"kind\":\"full\"")) {
      sb.append("full snapshot ").append(json.length()).append(" B");
    } else {
      Patch patch = prev == null ? null : EwtDiff.diff(prev, next);
      sb.append("patch ").append(json.length()).append(" B");
      if (patch != null) {
        sb.append(" (").append(patch.ops().size()).append(" sets, ")
          .append(patch.replaces().size()).append(" replaces, ")
          .append(patch.splices().size()).append(" splices)");
      }
    }
    return sb.toString();
  }

  static int countNodes(EwtNode node) {
    int n = 1;
    for (Object v : node.params().values()) n += countNodesIn(v);
    for (EwtNode c : node.children()) n += countNodes(c);
    return n;
  }

  private static int countNodesIn(Object v) {
    if (v instanceof EwtNode) return countNodes((EwtNode) v);
    int n = 0;
    if (v instanceof List<?>) for (Object e : (List<?>) v) n += countNodesIn(e);
    else if (v instanceof Map<?, ?>) for (Object e : ((Map<?, ?>) v).values()) n += countNodesIn(e);
    return n;
  }

  private static String millis(long nanos) {
    return String.format(java.util.Locale.ROOT, "%.1f", nanos / 1_000_000.0);
  }
}
