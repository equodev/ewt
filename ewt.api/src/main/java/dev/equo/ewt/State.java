package dev.equo.ewt;
public abstract class State<T extends StatefulWidget> extends NativeObj.Base {
  State() {}
  State(int id) {
    this.id = id;
  }
}
