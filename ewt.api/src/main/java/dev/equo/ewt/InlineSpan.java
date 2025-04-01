package dev.equo.ewt;
import java.util.*;
public abstract class InlineSpan extends DiagnosticableTree implements InlineSpanI {
  @Override
  public InlineSpan build() {
    return this;
  }
  protected InlineSpan() {}
  InlineSpan(int id) {
    this.id = id;
  }
}
