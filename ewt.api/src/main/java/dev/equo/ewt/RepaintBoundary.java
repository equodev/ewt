package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class RepaintBoundary extends SingleChildRenderObjectWidget implements RepaintBoundaryI {
  protected RepaintBoundary() {}
  RepaintBoundary(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget RepaintBoundary");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static RepaintBoundary repaintBoundaryRepaintBoundary(Optional<WidgetI> child) {
    int id = factories.repaintBoundaryRepaintBoundary(child.map(WidgetI::build));
    if (id <= 0) throw new RuntimeException("Failed to created widget RepaintBoundary");
    return new RepaintBoundary(id);
  }
  public static RepaintBoundaryRepaintBoundaryBuilder repaintBoundary() {
    return RepaintBoundaryRepaintBoundaryBuilder.repaintBoundaryRepaintBoundary();
  }
  @Builder.Factory
  static RepaintBoundary repaintBoundaryWrap(@Builder.Parameter WidgetI child, @Builder.Parameter int childIndex) {
    int id = factories.repaintBoundaryWrap(child.build(),
      childIndex);
    if (id <= 0) throw new RuntimeException("Failed to created widget RepaintBoundary");
    return new RepaintBoundary(id);
  }
  public static RepaintBoundaryWrapBuilder wrap(WidgetI child, int childIndex) {
    return RepaintBoundaryWrapBuilder.repaintBoundaryWrap(child, childIndex);
  }
  @Override
  public RepaintBoundary build() {
    return this;
  }
}
