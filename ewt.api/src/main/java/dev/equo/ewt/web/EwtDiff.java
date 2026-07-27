package dev.equo.ewt.web;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/** Pure structural-positional diff of two captured EwtNode trees. Emits param-only setParams ops
 *  when the trees have identical shape; signals STRUCTURAL (caller resends a full snapshot) on any
 *  shape difference. No I/O, no Evolve — unit-testable standalone. */
public final class EwtDiff {

  private EwtDiff() {}

  public static Patch diff(EwtNode prev, EwtNode next) {
    List<SetParamsOp> ops = new ArrayList<>();
    return walk(prev, next, List.of(), ops) ? Patch.of(ops) : Patch.structuralPatch();
  }

  /** Returns false as soon as a structural difference is found. */
  private static boolean walk(EwtNode prev, EwtNode next, List<Object> path, List<SetParamsOp> ops) {
    if (!prev.type().equals(next.type())) return false;
    Map<String, Object> pp = prev.params(), np = next.params();
    if (!pp.keySet().equals(np.keySet())) return false;

    Map<String, Object> changed = new LinkedHashMap<>();
    for (String k : np.keySet()) {
      Object ov = pp.get(k), nv = np.get(k);
      if ((ov == null) != (nv == null)) return false; // null<->non-null param flip -> structural (full resend)
      if (ov instanceof EwtNode on && nv instanceof EwtNode nn) {
        if (!walk(on, nn, append(path, k), ops)) return false;
      } else if (ov instanceof List<?> ol && nv instanceof List<?> nl) {
        if (ol.size() != nl.size()) return false;
        boolean primitiveListChanged = false;
        for (int i = 0; i < nl.size(); i++) {
          Object oe = ol.get(i), ne = nl.get(i);
          if (oe instanceof EwtNode oen && ne instanceof EwtNode nen) {
            if (!walk(oen, nen, append(append(path, k), i), ops)) return false;
          } else if (oe instanceof EwtNode || ne instanceof EwtNode) {
            return false; // node<->primitive at same index -> structural
          } else if (!Objects.equals(oe, ne)) {
            primitiveListChanged = true;
          }
        }
        if (primitiveListChanged) changed.put(k, nv); // re-set the whole primitive list
      } else if (ov instanceof EwtNode || nv instanceof EwtNode
          || ov instanceof List || nv instanceof List) {
        return false; // shape mismatch (node/list <-> other) -> structural
      } else if (!Objects.equals(ov, nv)) {
        changed.put(k, nv);
      }
    }
    if (!changed.isEmpty()) ops.add(new SetParamsOp(path, changed));
    return true;
  }

  private static List<Object> append(List<Object> path, Object step) {
    List<Object> out = new ArrayList<>(path.size() + 1);
    out.addAll(path);
    out.add(step);
    return List.copyOf(out);
  }
}
