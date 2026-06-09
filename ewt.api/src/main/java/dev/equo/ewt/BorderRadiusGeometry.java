package dev.equo.ewt;
import java.util.*;
public abstract class BorderRadiusGeometry extends NativeObj.Base implements BorderRadiusGeometryI {
  protected BorderRadiusGeometry() {}
  BorderRadiusGeometry(int id) {
    this.id = id;
  }
  @Override
  public BorderRadiusGeometry build() {
    return this;
  }
}
