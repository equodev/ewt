package dev.equo.ewt;
import java.util.*;
public abstract class OffsetBase extends NativeObj.Base implements OffsetBaseI {
  protected OffsetBase() {}
  OffsetBase(int id) {
    this.id = id;
  }
  @Override
  public OffsetBase build() {
    return this;
  }
}
