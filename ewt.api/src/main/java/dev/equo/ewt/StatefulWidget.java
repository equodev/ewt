package dev.equo.ewt;
import java.util.*;
public abstract class StatefulWidget extends Widget implements StatefulWidgetI {
  @Override
  public StatefulWidget build() {
    return this;
  }
  protected StatefulWidget() {}
  StatefulWidget(int id) {
    this.id = id;
  }
}
