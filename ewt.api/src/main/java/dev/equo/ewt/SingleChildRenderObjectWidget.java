package dev.equo.ewt;
import java.util.*;
public abstract class SingleChildRenderObjectWidget extends RenderObjectWidget implements SingleChildRenderObjectWidgetI {
  protected SingleChildRenderObjectWidget() {}
  SingleChildRenderObjectWidget(int id) {
    this.id = id;
  }
  @Override
  public SingleChildRenderObjectWidget build() {
    return this;
  }
}
