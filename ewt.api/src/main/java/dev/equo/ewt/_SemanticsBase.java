package dev.equo.ewt;
import java.util.*;
public abstract class _SemanticsBase extends SingleChildRenderObjectWidget implements _SemanticsBaseI {
  protected _SemanticsBase() {}
  _SemanticsBase(int id) {
    this.id = id;
  }
  @Override
  public _SemanticsBase build() {
    return this;
  }
}
