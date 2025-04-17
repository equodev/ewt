package dev.equo.ewt;
import java.util.*;
public abstract class AlignmentGeometry extends NativeObj.Base implements AlignmentGeometryI {
  protected AlignmentGeometry() {}
  AlignmentGeometry(int id) {
    this.id = id;
  }
  @Override
  public AlignmentGeometry build() {
    return this;
  }
}
