package dev.equo.ewt;
import java.util.*;
public abstract class Simulation extends NativeObj.Base implements SimulationI {
  protected Simulation() {}
  Simulation(int id) {
    this.id = id;
  }
  @Override
  public Simulation build() {
    return this;
  }
}
