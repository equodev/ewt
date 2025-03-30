package dev.equo.ewt;
public abstract class Widget extends DiagnosticableTree implements WidgetI {
  @Override
  public Widget build() {
    return this;
  }
  Widget() {}
  Widget(int id) {
    this.id = id;
  }
}
