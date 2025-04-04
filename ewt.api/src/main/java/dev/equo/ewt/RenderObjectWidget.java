package dev.equo.ewt;
import java.util.*;
public abstract class RenderObjectWidget extends Widget implements RenderObjectWidgetI {
  protected RenderObjectWidget() {}
  RenderObjectWidget(int id) {
    this.id = id;
  }
  @Override
  public RenderObjectWidget build() {
    return this;
  }
}
