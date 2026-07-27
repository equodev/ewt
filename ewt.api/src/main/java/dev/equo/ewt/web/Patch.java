package dev.equo.ewt.web;

import java.util.List;

/** Diff result: {@code structural} true means "can't param-patch, resend a full snapshot";
 *  otherwise {@code ops} carries the setParams ops (possibly empty = nothing to send). */
public record Patch(boolean structural, List<SetParamsOp> ops) {
  public static Patch of(List<SetParamsOp> ops) { return new Patch(false, List.copyOf(ops)); }

  // Named structuralPatch() (not structural()) because the record already generates the
  // boolean structural() accessor; a same-name static factory would not compile.
  public static Patch structuralPatch() { return new Patch(true, java.util.List.of()); }
}
