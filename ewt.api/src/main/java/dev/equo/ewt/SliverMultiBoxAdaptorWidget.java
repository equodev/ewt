package dev.equo.ewt;
import java.util.*;
public abstract class SliverMultiBoxAdaptorWidget extends SliverWithKeepAliveWidget implements SliverMultiBoxAdaptorWidgetI {
  protected SliverMultiBoxAdaptorWidget() {}
  SliverMultiBoxAdaptorWidget(int id) {
    this.id = id;
  }
  @Override
  public SliverMultiBoxAdaptorWidget build() {
    return this;
  }
}
