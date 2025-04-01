package dev.equo.ewt;
import java.util.*;
public abstract class MultiChildRenderObjectWidget extends RenderObjectWidget implements MultiChildRenderObjectWidgetI {
  @Override
  public MultiChildRenderObjectWidget build() {
    return this;
  }
  protected MultiChildRenderObjectWidget() {}
  MultiChildRenderObjectWidget(int id) {
    this.id = id;
  }
}
