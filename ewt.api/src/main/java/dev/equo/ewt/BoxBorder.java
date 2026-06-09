package dev.equo.ewt;
import java.util.*;
public abstract class BoxBorder extends ShapeBorder implements BoxBorderI {
  protected BoxBorder() {}
  BoxBorder(int id) {
    this.id = id;
  }
  @Override
  public BoxBorder build() {
    return this;
  }
}
