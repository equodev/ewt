package dev.equo.ewt;
import java.util.*;
public abstract class EdgeInsetsGeometry extends NativeObj.Base implements EdgeInsetsGeometryI {
  protected EdgeInsetsGeometry() {}
  EdgeInsetsGeometry(int id) {
    this.id = id;
  }
  @Override
  public EdgeInsetsGeometry build() {
    return this;
  }
}
