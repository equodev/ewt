package dev.equo.ewt.web;

import java.util.ArrayList;
import java.util.IdentityHashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * Pure structural diff of two captured EwtNode trees. Where the trees have the same shape it
 * emits param-only setParams ops; where a nested node changed shape (type, param set, null flip)
 * it emits one replace op for that node and goes no deeper; where a list of nodes changed length
 * it aligns the two lists by node signature and emits splices for the runs that differ, so a row
 * filtered out of a table travels as a removal and a row added as that row alone. Only a root
 * that changed shape signals STRUCTURAL (the caller resends a full snapshot). No I/O, no Evolve —
 * unit-testable standalone.
 *
 * <p>Matching is by position (or by signature inside a list that changed length), not by node
 * id: ids are renumbered on every capture. A callback param is an int id in the same numbering,
 * so when a removed row shifts the ids of the nodes after it, those show up as ordinary changed
 * params and travel as setParams ops.
 */
public final class EwtDiff {

  private EwtDiff() {}

  /** Lists longer than this on both sides are replaced whole instead of aligned: the alignment
   *  is quadratic, and a table this size is not what a user action edits one row of. */
  private static final int MAX_ALIGNED = 2000;

  public static Patch diff(EwtNode prev, EwtNode next) {
    if (!sameShape(prev, next)) return Patch.structuralPatch();
    Walk w = new Walk();
    w.walk(prev, next, List.of());
    return Patch.of(w.ops, w.replaces, w.splices);
  }

  /** Whether the two nodes can be patched in place: the same type, the same param keys, and
   *  each param of the same kind. A list of nodes may differ in length (that is a splice); a
   *  list of primitives is re-set whole; a mixed list must match element for element. */
  private static boolean sameShape(EwtNode prev, EwtNode next) {
    if (!prev.type().equals(next.type())) return false;
    Map<String, Object> pp = prev.params(), np = next.params();
    if (!pp.keySet().equals(np.keySet())) return false;
    for (String k : np.keySet()) {
      Object ov = pp.get(k), nv = np.get(k);
      if ((ov == null) != (nv == null)) return false;
      if (ov instanceof EwtNode || nv instanceof EwtNode) {
        if (!(ov instanceof EwtNode && nv instanceof EwtNode)) return false;
      } else if (ov instanceof List<?> || nv instanceof List<?>) {
        if (!(ov instanceof List<?> && nv instanceof List<?>)) return false;
        List<?> ol = (List<?>) ov, nl = (List<?>) nv;
        if (allNodes(ol) && allNodes(nl)) continue;
        if (noNodes(ol) && noNodes(nl)) continue;
        if (ol.size() != nl.size()) return false;
        for (int i = 0; i < nl.size(); i++) {
          if ((ol.get(i) instanceof EwtNode) != (nl.get(i) instanceof EwtNode)) return false;
        }
      }
    }
    return true;
  }

  private static boolean allNodes(List<?> l) {
    for (Object e : l) if (!(e instanceof EwtNode)) return false;
    return true;
  }

  private static boolean noNodes(List<?> l) {
    for (Object e : l) if (e instanceof EwtNode) return false;
    return true;
  }

  private static final class Walk {
    final List<SetParamsOp> ops = new ArrayList<>();
    final List<ReplaceOp> replaces = new ArrayList<>();
    final List<SpliceOp> splices = new ArrayList<>();
    final Map<EwtNode, String> signatures = new IdentityHashMap<>();

    /** Both nodes have the same shape: patch their primitives, descend into child nodes. */
    void walk(EwtNode prev, EwtNode next, List<Object> path) {
      Map<String, Object> pp = prev.params(), np = next.params();
      Map<String, Object> changed = new LinkedHashMap<>();
      for (String k : np.keySet()) {
        Object ov = pp.get(k), nv = np.get(k);
        if (nv instanceof EwtNode) {
          child((EwtNode) ov, (EwtNode) nv, append(path, k));
        } else if (nv instanceof List<?>) {
          List<?> ol = (List<?>) ov, nl = (List<?>) nv;
          if (allNodes(nl) && allNodes(ol)) {
            nodeList(cast(ol), cast(nl), path, k);
          } else if (!Objects.equals(ol, nl)) {
            changed.put(k, nv); // re-set the whole primitive (or mixed, same-shape) list
          }
        } else if (nv instanceof Map<?, ?> && ov instanceof Map<?, ?>) {
          if (!mapParam((Map<?, ?>) ov, (Map<?, ?>) nv, append(path, k))) changed.put(k, nv);
        } else if (!Objects.equals(ov, nv)) {
          changed.put(k, nv);
        }
      }
      if (!changed.isEmpty()) ops.add(new SetParamsOp(path, changed));
    }

    /**
     * A map-valued param (a MaterialColor's swatch, say): its node values are diffed in place
     * like child nodes, keyed by the map key, and its primitives as one setParams on the map.
     * Returns false when the map must be re-set whole: a key set or a value kind changed. A
     * node is never equal to another by {@code equals}, so without this every map holding
     * nodes looked changed on every capture.
     */
    boolean mapParam(Map<?, ?> om, Map<?, ?> nm, List<Object> path) {
      if (!om.keySet().equals(nm.keySet())) return false;
      Map<String, Object> changed = new LinkedHashMap<>();
      for (Map.Entry<?, ?> e : nm.entrySet()) {
        if (!(e.getKey() instanceof String)) return false;
        String key = (String) e.getKey();
        Object ov = om.get(key), nv = e.getValue();
        if (ov instanceof EwtNode && nv instanceof EwtNode) {
          child((EwtNode) ov, (EwtNode) nv, append(path, key));
        } else if (ov instanceof EwtNode || nv instanceof EwtNode || ov instanceof List<?> || nv instanceof List<?>
            || ov instanceof Map<?, ?> || nv instanceof Map<?, ?>) {
          return false;
        } else if (!Objects.equals(ov, nv)) {
          changed.put(key, nv);
        }
      }
      if (!changed.isEmpty()) ops.add(new SetParamsOp(path, changed));
      return true;
    }

    /** A nested node: patched in place when its shape held, replaced whole otherwise. */
    void child(EwtNode prev, EwtNode next, List<Object> path) {
      if (sameShape(prev, next)) walk(prev, next, path);
      else replaces.add(new ReplaceOp(path, next));
    }

    /** A list of nodes: element by element when the length held, aligned by signature when it
     *  changed. The paths of what is emitted for the matched elements index the new list. */
    void nodeList(List<EwtNode> ol, List<EwtNode> nl, List<Object> path, String key) {
      List<Object> listPath = append(path, key);
      if (ol.size() == nl.size()) {
        for (int i = 0; i < nl.size(); i++) child(ol.get(i), nl.get(i), append(listPath, i));
        return;
      }
      if (ol.size() > MAX_ALIGNED && nl.size() > MAX_ALIGNED) {
        splices.add(new SpliceOp(path, key, 0, ol.size(), nl.size() == 0 ? List.of() : new ArrayList<>(nl)));
        return;
      }
      // Longest common subsequence over node signatures, then one pass over the alignment:
      // a matched pair is diffed in place, each unmatched run becomes a splice.
      int n = ol.size(), m = nl.size();
      String[] os = new String[n], ns = new String[m];
      for (int i = 0; i < n; i++) os[i] = signature(ol.get(i));
      for (int j = 0; j < m; j++) ns[j] = signature(nl.get(j));
      int[][] lcs = new int[n + 1][m + 1];
      for (int i = n - 1; i >= 0; i--) {
        for (int j = m - 1; j >= 0; j--) {
          lcs[i][j] = os[i].equals(ns[j]) ? lcs[i + 1][j + 1] + 1 : Math.max(lcs[i + 1][j], lcs[i][j + 1]);
        }
      }
      int i = 0, j = 0;
      // The index into the list as the browser holds it after the splices so far: the matched
      // elements before it plus what was inserted.
      int cursor = 0;
      int pendingRemove = 0;
      List<EwtNode> pendingInsert = new ArrayList<>();
      List<EwtNode> matchedOld = new ArrayList<>();
      List<EwtNode> matchedNew = new ArrayList<>();
      List<Integer> matchedAt = new ArrayList<>();
      while (i < n || j < m) {
        if (i < n && j < m && os[i].equals(ns[j])) {
          if (pendingRemove > 0 || !pendingInsert.isEmpty()) {
            splices.add(new SpliceOp(path, key, cursor, pendingRemove, List.copyOf(pendingInsert)));
            cursor += pendingInsert.size();
            pendingRemove = 0;
            pendingInsert.clear();
          }
          matchedOld.add(ol.get(i));
          matchedNew.add(nl.get(j));
          matchedAt.add(cursor);
          cursor++;
          i++;
          j++;
        } else if (j < m && (i >= n || lcs[i][j + 1] >= lcs[i + 1][j])) {
          pendingInsert.add(nl.get(j));
          j++;
        } else {
          pendingRemove++;
          i++;
        }
      }
      if (pendingRemove > 0 || !pendingInsert.isEmpty()) {
        splices.add(new SpliceOp(path, key, cursor, pendingRemove, List.copyOf(pendingInsert)));
      }
      // The matched pairs are diffed after their splices are recorded, so their ops come later in
      // the patch and index the list as the splices left it.
      for (int k = 0; k < matchedOld.size(); k++) {
        child(matchedOld.get(k), matchedNew.get(k), append(listPath, matchedAt.get(k)));
      }
    }

    /**
     * What identifies a node across two captures of a list that changed length: its type, its
     * strings and booleans and doubles, and the same of the nodes under it — never an int,
     * since callback ids (ints in the same numbering as node ids) shift with every node built
     * before them and enum ordinals are rarely what tells two rows apart.
     */
    String signature(EwtNode node) {
      String s = signatures.get(node);
      if (s != null) return s;
      StringBuilder sb = new StringBuilder(node.type());
      for (Map.Entry<String, Object> e : node.params().entrySet()) {
        sb.append('|').append(e.getKey()).append('=');
        signatureValue(sb, e.getValue());
      }
      s = sb.toString();
      signatures.put(node, s);
      return s;
    }

    private void signatureValue(StringBuilder sb, Object v) {
      if (v instanceof EwtNode) sb.append('{').append(signature((EwtNode) v)).append('}');
      else if (v instanceof List<?>) {
        sb.append('[');
        for (Object e : (List<?>) v) { signatureValue(sb, e); sb.append(','); }
        sb.append(']');
      } else if (v instanceof String || v instanceof Boolean || v instanceof Double) sb.append(v);
      else if (v instanceof Map<?, ?>) {
        sb.append('{');
        for (Map.Entry<?, ?> e : ((Map<?, ?>) v).entrySet()) { sb.append(e.getKey()).append(':'); signatureValue(sb, e.getValue()); sb.append(','); }
        sb.append('}');
      }
      else if (v == null) sb.append("null");
      else sb.append('#'); // an int, or anything else that does not identify the node
    }
  }

  @SuppressWarnings("unchecked")
  private static List<EwtNode> cast(List<?> l) { return (List<EwtNode>) l; }

  private static List<Object> append(List<Object> path, Object step) {
    List<Object> out = new ArrayList<>(path.size() + 1);
    out.addAll(path);
    out.add(step);
    return List.copyOf(out);
  }
}
