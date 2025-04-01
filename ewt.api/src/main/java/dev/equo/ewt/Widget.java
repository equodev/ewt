package dev.equo.ewt;
import java.util.*;
public abstract class Widget extends DiagnosticableTree implements WidgetI {
  @Override
  public Widget build() {
    return this;
  }
  protected Widget() {}
  Widget(int id) {
    this.id = id;
  }
}
