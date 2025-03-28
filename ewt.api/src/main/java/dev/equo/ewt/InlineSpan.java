package dev.equo.ewt;
public abstract class InlineSpan extends DiagnosticableTree {
  InlineSpan() {}
  InlineSpan(int id) {
    this.id = id;
  }
}
