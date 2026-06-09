package dev.equo.ewt;
import java.util.*;
public abstract class ShapeBorder extends NativeObj.Base implements ShapeBorderI {
  protected ShapeBorder() {}
  ShapeBorder(int id) {
    this.id = id;
  }
  @Override
  public ShapeBorder build() {
    return this;
  }
}
