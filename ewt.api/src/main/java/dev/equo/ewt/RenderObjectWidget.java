package dev.equo.ewt;
public abstract class RenderObjectWidget extends Widget implements RenderObjectWidgetI {
  @Override
  public RenderObjectWidget build() {
    return this;
  }
  RenderObjectWidget() {}
  RenderObjectWidget(int id) {
    this.id = id;
  }
}
