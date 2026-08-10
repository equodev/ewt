package dev.equo.ewt;
import java.util.*;
public abstract class InheritedWidget extends ProxyWidget implements InheritedWidgetI {
  protected InheritedWidget() {}
  InheritedWidget(int id) {
    this.id = id;
  }
  @Override
  public InheritedWidget build() {
    return this;
  }
}
