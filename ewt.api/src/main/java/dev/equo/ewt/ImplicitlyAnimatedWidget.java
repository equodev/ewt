package dev.equo.ewt;
import java.util.*;
public abstract class ImplicitlyAnimatedWidget extends StatefulWidget implements ImplicitlyAnimatedWidgetI {
  protected ImplicitlyAnimatedWidget() {}
  ImplicitlyAnimatedWidget(int id) {
    this.id = id;
  }
  @Override
  public ImplicitlyAnimatedWidget build() {
    return this;
  }
}
