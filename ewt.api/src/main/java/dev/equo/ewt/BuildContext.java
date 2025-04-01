package dev.equo.ewt;
import java.util.*;
public abstract class BuildContext extends NativeObj.Base implements BuildContextI {
  @Override
  public BuildContext build() {
    return this;
  }
  protected BuildContext() {}
  BuildContext(int id) {
    this.id = id;
  }
}
