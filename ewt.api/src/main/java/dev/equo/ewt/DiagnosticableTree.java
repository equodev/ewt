package dev.equo.ewt;
import java.util.*;
public abstract class DiagnosticableTree extends NativeObj.Base implements DiagnosticableTreeI {
  protected DiagnosticableTree() {}
  DiagnosticableTree(int id) {
    this.id = id;
  }
  @Override
  public DiagnosticableTree build() {
    return this;
  }
}
