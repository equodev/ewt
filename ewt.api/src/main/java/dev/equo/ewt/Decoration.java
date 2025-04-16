package dev.equo.ewt;
import java.util.*;
public abstract class Decoration extends NativeObj.Base implements DecorationI {
  protected Decoration() {}
  Decoration(int id) {
    this.id = id;
  }
  @Override
  public Decoration build() {
    return this;
  }
}
