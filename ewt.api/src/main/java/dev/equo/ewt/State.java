package dev.equo.ewt;
import java.util.*;
public abstract class State<T extends StatefulWidget> extends NativeObj.Base implements StateI {
  @Override
  public State build() {
    return this;
  }
  protected State() {}
  State(int id) {
    this.id = id;
  }
}
