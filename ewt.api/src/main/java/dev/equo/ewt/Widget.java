package dev.equo.ewt;
import java.util.*;
public abstract class Widget extends DiagnosticableTree implements WidgetI {
  protected Widget() {}
  Widget(int id) {
    this.id = id;
  }
  @Override
  public Widget build() {
    return this;
  }
}
