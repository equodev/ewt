package dev.equo.ewt;
import java.util.*;
public abstract class AlignmentGeometry extends NativeObj.Base implements AlignmentGeometryI {
  protected AlignmentGeometry() {}
  AlignmentGeometry(int id) {
    this.id = id;
  }
  public static AlignmentGeometry topLeft() {
    return Alignment.topLeft();
  }
  public static AlignmentGeometry topCenter() {
    return Alignment.topCenter();
  }
  public static AlignmentGeometry topRight() {
    return Alignment.topRight();
  }
  public static AlignmentGeometry topStart() {
    return AlignmentDirectional.topStart();
  }
  public static AlignmentGeometry topEnd() {
    return AlignmentDirectional.topEnd();
  }
  public static AlignmentGeometry centerLeft() {
    return Alignment.centerLeft();
  }
  public static AlignmentGeometry center() {
    return Alignment.center();
  }
  public static AlignmentGeometry centerRight() {
    return Alignment.centerRight();
  }
  public static AlignmentGeometry centerStart() {
    return AlignmentDirectional.centerStart();
  }
  public static AlignmentGeometry centerEnd() {
    return AlignmentDirectional.centerEnd();
  }
  public static AlignmentGeometry bottomLeft() {
    return Alignment.bottomLeft();
  }
  public static AlignmentGeometry bottomCenter() {
    return Alignment.bottomCenter();
  }
  public static AlignmentGeometry bottomRight() {
    return Alignment.bottomRight();
  }
  public static AlignmentGeometry bottomStart() {
    return AlignmentDirectional.bottomStart();
  }
  public static AlignmentGeometry bottomEnd() {
    return AlignmentDirectional.bottomEnd();
  }
  @Override
  public AlignmentGeometry build() {
    return this;
  }
}
