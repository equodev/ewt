package dev.equo.ewt;
import java.util.*;
public abstract class AnimatedWidget extends StatefulWidget implements AnimatedWidgetI {
  protected AnimatedWidget() {}
  AnimatedWidget(int id) {
    this.id = id;
  }
  @Override
  public AnimatedWidget build() {
    return this;
  }
}
