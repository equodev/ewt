package dev.equo.ewt;
import java.util.*;
public abstract class ValueListenable<T> extends NativeObj.Base implements Listenable, ValueListenableI {
  protected ValueListenable() {}
  ValueListenable(int id) {
    this.id = id;
  }
  @Override
  public ValueListenable build() {
    return this;
  }
}
