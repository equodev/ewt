package dev.equo.ewt;
public abstract class DiagnosticableTree extends NativeObj.Base implements DiagnosticableTreeI {
  @Override
  public DiagnosticableTree build() {
    return this;
  }
  DiagnosticableTree() {}
  DiagnosticableTree(int id) {
    this.id = id;
  }
}
