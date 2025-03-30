package dev.equo.ewt;
public abstract class State<T extends StatefulWidget> extends NativeObj.Base implements StateI {
  @Override
  public State build() {
    return this;
  }
  State() {}
  State(int id) {
    this.id = id;
  }
}
