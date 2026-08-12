package dev.equo.ewt;
import java.util.*;
public abstract class PointerEvent extends NativeObj.Base implements PointerEventI {
  protected PointerEvent() {}
  PointerEvent(int id) {
    this.id = id;
  }
  @Override
  public PointerEvent build() {
    return this;
  }
}
