package dev.equo.ewt;
public abstract class SingleChildRenderObjectWidget extends RenderObjectWidget implements SingleChildRenderObjectWidgetI {
  @Override
  public SingleChildRenderObjectWidget build() {
    return this;
  }
  SingleChildRenderObjectWidget() {}
  SingleChildRenderObjectWidget(int id) {
    this.id = id;
  }
}
