package dev.equo.ewt;
import java.util.*;
public abstract class LeafRenderObjectWidget extends RenderObjectWidget implements LeafRenderObjectWidgetI {
  protected LeafRenderObjectWidget() {}
  LeafRenderObjectWidget(int id) {
    this.id = id;
  }
  @Override
  public LeafRenderObjectWidget build() {
    return this;
  }
}
