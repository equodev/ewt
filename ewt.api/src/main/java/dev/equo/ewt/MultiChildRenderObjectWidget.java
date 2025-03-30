package dev.equo.ewt;
public abstract class MultiChildRenderObjectWidget extends RenderObjectWidget implements MultiChildRenderObjectWidgetI {
  @Override
  public MultiChildRenderObjectWidget build() {
    return this;
  }
  MultiChildRenderObjectWidget() {}
  MultiChildRenderObjectWidget(int id) {
    this.id = id;
  }
}
