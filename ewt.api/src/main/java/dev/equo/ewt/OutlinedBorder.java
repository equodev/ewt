package dev.equo.ewt;
import java.util.*;
public abstract class OutlinedBorder extends ShapeBorder implements OutlinedBorderI {
  protected OutlinedBorder() {}
  OutlinedBorder(int id) {
    this.id = id;
  }
  @Override
  public OutlinedBorder build() {
    return this;
  }
}
