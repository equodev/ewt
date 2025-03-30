package dev.equo.ewt;
public abstract class StatelessWidget extends Widget implements StatelessWidgetI {
  @Override
  public StatelessWidget build() {
    return this;
  }
  StatelessWidget() {}
  StatelessWidget(int id) {
    this.id = id;
  }
}
