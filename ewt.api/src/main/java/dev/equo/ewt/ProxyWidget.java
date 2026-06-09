package dev.equo.ewt;
import java.util.*;
public abstract class ProxyWidget extends Widget implements ProxyWidgetI {
  protected ProxyWidget() {}
  ProxyWidget(int id) {
    this.id = id;
  }
  @Override
  public ProxyWidget build() {
    return this;
  }
}
