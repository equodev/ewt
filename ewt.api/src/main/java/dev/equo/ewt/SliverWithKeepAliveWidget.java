package dev.equo.ewt;
import java.util.*;
public abstract class SliverWithKeepAliveWidget extends RenderObjectWidget implements SliverWithKeepAliveWidgetI {
  protected SliverWithKeepAliveWidget() {}
  SliverWithKeepAliveWidget(int id) {
    this.id = id;
  }
  @Override
  public SliverWithKeepAliveWidget build() {
    return this;
  }
}
