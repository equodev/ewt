package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class CompositedTransformTarget extends SingleChildRenderObjectWidget implements CompositedTransformTargetI {
  protected CompositedTransformTarget() {}
  CompositedTransformTarget(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget CompositedTransformTarget");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Override
  public CompositedTransformTarget build() {
    return this;
  }
}
