package dev.equo.ewt;
import java.util.*;
public abstract class State<T extends StatefulWidget> extends NativeObj.Base implements StateI {
  protected State() {}
  State(int id) {
    this.id = id;
  }
  @Override
  public State build() {
    return this;
  }
}
