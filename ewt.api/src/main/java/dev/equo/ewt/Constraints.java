package dev.equo.ewt;
import java.util.*;
public abstract class Constraints extends NativeObj.Base implements ConstraintsI {
  protected Constraints() {}
  Constraints(int id) {
    this.id = id;
  }
  @Override
  public Constraints build() {
    return this;
  }
}
