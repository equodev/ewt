package dev.equo.ewt;
import java.util.*;
public abstract class ParentDataWidget<T extends ParentData> extends ProxyWidget implements ParentDataWidgetI {
  protected ParentDataWidget() {}
  ParentDataWidget(int id) {
    this.id = id;
  }
  @Override
  public ParentDataWidget build() {
    return this;
  }
}
