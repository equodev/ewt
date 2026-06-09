package dev.equo.ewt;
import java.util.*;
public abstract class ParametricCurve<T> extends NativeObj.Base implements ParametricCurveI {
  protected ParametricCurve() {}
  ParametricCurve(int id) {
    this.id = id;
  }
  @Override
  public ParametricCurve build() {
    return this;
  }
}
