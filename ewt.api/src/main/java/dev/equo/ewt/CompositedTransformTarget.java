package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.CompositedTransformTargetObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class CompositedTransformTarget extends SingleChildRenderObjectWidget implements CompositedTransformTargetI {
  private MemorySegment st;
  protected CompositedTransformTarget() {}
  CompositedTransformTarget(MemorySegment st) {
    this.id = CompositedTransformTargetObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget CompositedTransformTarget");
    System.out.println("New CompositedTransformTarget id:"+id);
  }
  CompositedTransformTarget(int id) { this.id = id; }
  @Override
  public CompositedTransformTarget build() {
    return this;
  }
}
