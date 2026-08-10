package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.RepaintBoundaryObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class RepaintBoundary extends SingleChildRenderObjectWidget implements RepaintBoundaryI {
  private MemorySegment st;
  protected RepaintBoundary() {}
  RepaintBoundary(MemorySegment st) {
    this.id = RepaintBoundaryObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget RepaintBoundary");
    System.out.println("New RepaintBoundary id:"+id);
  }
  RepaintBoundary(int id) { this.id = id; }
  @Builder.Factory
  static RepaintBoundary repaintBoundaryRepaintBoundary(Optional<WidgetI> child) {
    var st = factories.repaintBoundaryRepaintBoundary(child.map(WidgetI::build));
    if (st == null) throw new RuntimeException("Failed to created widget RepaintBoundary");
    return new RepaintBoundary(st);
  }
  public static RepaintBoundaryRepaintBoundaryBuilder repaintBoundary() {
    return RepaintBoundaryRepaintBoundaryBuilder.repaintBoundaryRepaintBoundary();
  }
  @Builder.Factory
  static RepaintBoundary repaintBoundaryWrap(@Builder.Parameter WidgetI child, @Builder.Parameter int childIndex) {
    var st = factories.repaintBoundaryWrap(child.build(),
      childIndex);
    if (st == null) throw new RuntimeException("Failed to created widget RepaintBoundary");
    return new RepaintBoundary(st);
  }
  public static RepaintBoundaryWrapBuilder wrap(WidgetI child, int childIndex) {
    return RepaintBoundaryWrapBuilder.repaintBoundaryWrap(child, childIndex);
  }
  @Override
  public RepaintBoundary build() {
    return this;
  }
}
