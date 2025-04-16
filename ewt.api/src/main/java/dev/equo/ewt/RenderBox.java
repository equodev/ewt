package dev.equo.ewt;
import java.util.*;
public abstract class RenderBox extends NativeObj.Base implements RenderObject, RenderBoxI {
  protected RenderBox() {}
  RenderBox(int id) {
    this.id = id;
  }
  @Override
  public RenderBox build() {
    return this;
  }
}
