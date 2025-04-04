package dev.equo.ewt;
import java.util.*;
public abstract class InlineSpan extends DiagnosticableTree implements InlineSpanI {
  protected InlineSpan() {}
  InlineSpan(int id) {
    this.id = id;
  }
  @Override
  public InlineSpan build() {
    return this;
  }
}
