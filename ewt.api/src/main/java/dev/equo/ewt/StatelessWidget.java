package dev.equo.ewt;
import java.util.*;
public abstract class StatelessWidget extends Widget implements StatelessWidgetI {
  protected StatelessWidget() {}
  StatelessWidget(int id) {
    this.id = id;
  }
  @Override
  public StatelessWidget build() {
    return this;
  }
}
