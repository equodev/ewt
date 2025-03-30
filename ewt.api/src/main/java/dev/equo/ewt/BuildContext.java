package dev.equo.ewt;
public abstract class BuildContext extends NativeObj.Base implements BuildContextI {
  @Override
  public BuildContext build() {
    return this;
  }
  BuildContext() {}
  BuildContext(int id) {
    this.id = id;
  }
}
