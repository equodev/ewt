package dev.equo.ewt;
import java.util.*;
public abstract class EdgeInsetsGeometry extends NativeObj.Base implements EdgeInsetsGeometryI {
  protected EdgeInsetsGeometry() {}
  EdgeInsetsGeometry(int id) {
    this.id = id;
  }
  public static EdgeInsetsGeometry infinity() {
    int id = factories.edgeInsetsGeometryInfinity();
    if (id <= 0) throw new RuntimeException("Failed to create const infinity");
    System.out.println("Const infinity id:"+id);
    return new EdgeInsetsGeometry(id) {};
  }
  @Override
  public EdgeInsetsGeometry build() {
    return this;
  }
}
