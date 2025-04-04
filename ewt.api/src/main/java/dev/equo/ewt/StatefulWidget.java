package dev.equo.ewt;
import java.util.*;
public abstract class StatefulWidget extends Widget implements StatefulWidgetI {
  protected StatefulWidget() {}
  StatefulWidget(int id) {
    this.id = id;
  }
  @Override
  public StatefulWidget build() {
    return this;
  }
}
