package dev.equo.ewt;
import java.util.*;
public abstract class RenderObjectWidget extends Widget implements RenderObjectWidgetI {
  @Override
  public RenderObjectWidget build() {
    return this;
  }
  protected RenderObjectWidget() {}
  RenderObjectWidget(int id) {
    this.id = id;
  }
}
