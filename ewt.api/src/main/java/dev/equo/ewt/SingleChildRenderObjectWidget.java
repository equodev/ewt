package dev.equo.ewt;
import java.util.*;
public abstract class SingleChildRenderObjectWidget extends RenderObjectWidget implements SingleChildRenderObjectWidgetI {
  @Override
  public SingleChildRenderObjectWidget build() {
    return this;
  }
  protected SingleChildRenderObjectWidget() {}
  SingleChildRenderObjectWidget(int id) {
    this.id = id;
  }
}
