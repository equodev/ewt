package dev.equo.ewt;
import java.util.*;
public abstract class WidgetStateProperty<T> extends NativeObj.Base implements WidgetStatePropertyI {
  protected WidgetStateProperty() {}
  WidgetStateProperty(int id) {
    this.id = id;
  }
  @Override
  public WidgetStateProperty build() {
    return this;
  }
}
