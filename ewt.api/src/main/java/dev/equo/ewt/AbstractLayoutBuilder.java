package dev.equo.ewt;
import java.util.*;
public abstract class AbstractLayoutBuilder<LayoutInfoType> extends RenderObjectWidget implements AbstractLayoutBuilderI {
  protected AbstractLayoutBuilder() {}
  AbstractLayoutBuilder(int id) {
    this.id = id;
  }
  @Override
  public AbstractLayoutBuilder build() {
    return this;
  }
}
