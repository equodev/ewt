package dev.equo.ewt;
public abstract class StatefulWidget extends Widget implements StatefulWidgetI {
  @Override
  public StatefulWidget build() {
    return this;
  }
  StatefulWidget() {}
  StatefulWidget(int id) {
    this.id = id;
  }
}
