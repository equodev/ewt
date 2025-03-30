package dev.equo.ewt;
public abstract class InlineSpan extends DiagnosticableTree implements InlineSpanI {
  @Override
  public InlineSpan build() {
    return this;
  }
  InlineSpan() {}
  InlineSpan(int id) {
    this.id = id;
  }
}
