package dev.equo.ewt;
import java.util.*;
public abstract class Curve extends ParametricCurve<Double> implements CurveI {
  protected Curve() {}
  Curve(int id) {
    this.id = id;
  }
  @Override
  public Curve build() {
    return this;
  }
}
