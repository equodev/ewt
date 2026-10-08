package dev.equo.ewt.web;

import java.util.List;

/**
 * Diff result: {@code structural} true means the root itself changed shape, so the region is
 * resent as a full snapshot; otherwise {@code splices} carries the list edits, {@code ops} the
 * setParams ops and {@code replaces} the subtree replacements (all possibly empty = nothing to
 * send). They apply in that order, and the paths of the ops and replaces index the lists as the
 * splices leave them.
 *
 * <p>java-11 split: a plain class (not a record) so it compiles at {@code --release 11}.
 */
public final class Patch {
  private final boolean structural;
  private final List<SetParamsOp> ops;
  private final List<ReplaceOp> replaces;
  private final List<SpliceOp> splices;

  public Patch(boolean structural, List<SetParamsOp> ops) {
    this(structural, ops, List.of(), List.of());
  }

  public Patch(boolean structural, List<SetParamsOp> ops, List<ReplaceOp> replaces, List<SpliceOp> splices) {
    this.structural = structural;
    this.ops = ops;
    this.replaces = replaces;
    this.splices = splices;
  }

  public boolean structural() { return structural; }
  public List<SetParamsOp> ops() { return ops; }
  public List<ReplaceOp> replaces() { return replaces; }
  public List<SpliceOp> splices() { return splices; }

  /** True when there is nothing to send: the trees matched exactly. */
  public boolean isEmpty() { return !structural && ops.isEmpty() && replaces.isEmpty() && splices.isEmpty(); }

  public static Patch of(List<SetParamsOp> ops) { return new Patch(false, List.copyOf(ops)); }

  public static Patch of(List<SetParamsOp> ops, List<ReplaceOp> replaces) {
    return new Patch(false, List.copyOf(ops), List.copyOf(replaces), List.of());
  }

  public static Patch of(List<SetParamsOp> ops, List<ReplaceOp> replaces, List<SpliceOp> splices) {
    return new Patch(false, List.copyOf(ops), List.copyOf(replaces), List.copyOf(splices));
  }

  // Named structuralPatch() (not structural()) because structural() is the boolean accessor;
  // a same-name static factory would not compile.
  public static Patch structuralPatch() { return new Patch(true, java.util.List.of()); }
}
