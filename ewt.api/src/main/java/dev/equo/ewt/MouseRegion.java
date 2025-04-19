package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.MouseRegionObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class MouseRegion extends SingleChildRenderObjectWidget implements MouseRegionI {
  private MemorySegment st;
  protected MouseRegion() {}
  MouseRegion(MemorySegment st) {
    this.id = MouseRegionObjSt.id(st);
    this.st = st;
    System.out.println("New MouseRegion id:"+id);
  }
  @Builder.Factory
  static MouseRegion mouseRegionMouseRegion(Optional<Boolean> opaque, Optional<HitTestBehavior> hitTestBehavior, Optional<WidgetI> child) {
    var st = factories.mouseRegionMouseRegion(opaque,
      hitTestBehavior,
      child.map(WidgetI::build));
    if (st == null) throw new RuntimeException("Failed to created widget MouseRegion");
    return new MouseRegion(st);
  }
  public static MouseRegionMouseRegionBuilder mouseRegion() {
    return MouseRegionMouseRegionBuilder.mouseRegionMouseRegion();
  }
  public boolean opaque() {
    return intToBool(MouseRegionObjSt.opaque(st));
  }
  public HitTestBehavior hitTestBehavior() {
    return HitTestBehavior.values()[MouseRegionObjSt.hitTestBehavior(st)];
  }
  @Override
  public MouseRegion build() {
    return this;
  }
}
