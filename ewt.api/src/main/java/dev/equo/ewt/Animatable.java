package dev.equo.ewt;
import java.util.*;
public abstract class Animatable<T> extends NativeObj.Base implements AnimatableI {
  protected Animatable() {}
  Animatable(int id) {
    this.id = id;
  }
  @Override
  public Animatable build() {
    return this;
  }
}
