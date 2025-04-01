package dev.equo.ewt;
import java.util.*;
public abstract class StatelessWidget extends Widget implements StatelessWidgetI {
  @Override
  public StatelessWidget build() {
    return this;
  }
  protected StatelessWidget() {}
  StatelessWidget(int id) {
    this.id = id;
  }
}
