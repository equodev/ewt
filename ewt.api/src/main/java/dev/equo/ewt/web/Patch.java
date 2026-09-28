package dev.equo.ewt.web;

import java.util.List;

/**
 * Diff result: {@code structural} true means "can't param-patch, resend a full snapshot"; otherwise
 * {@code ops} carries the setParams ops (possibly empty = nothing to send).
 *
 * <p>java-11 split: a plain class (not a record) so it compiles at {@code --release 11}.
 */
public final class Patch {
  private final boolean structural;
  private final List<SetParamsOp> ops;

  public Patch(boolean structural, List<SetParamsOp> ops) {
    this.structural = structural;
    this.ops = ops;
  }

  public boolean structural() { return structural; }
  public List<SetParamsOp> ops() { return ops; }

  public static Patch of(List<SetParamsOp> ops) { return new Patch(false, List.copyOf(ops)); }

  // Named structuralPatch() (not structural()) because structural() is the boolean accessor;
  // a same-name static factory would not compile.
  public static Patch structuralPatch() { return new Patch(true, java.util.List.of()); }
}
