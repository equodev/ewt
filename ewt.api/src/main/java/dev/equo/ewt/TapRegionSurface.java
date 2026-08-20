package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.TapRegionSurfaceObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class TapRegionSurface extends SingleChildRenderObjectWidget implements TapRegionSurfaceI {
  private MemorySegment st;
  protected TapRegionSurface() {}
  TapRegionSurface(MemorySegment st) {
    this.id = TapRegionSurfaceObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget TapRegionSurface");
    System.out.println("New TapRegionSurface id:"+id);
  }
  TapRegionSurface(int id) { this.id = id; }
  @Builder.Factory
  static TapRegionSurface tapRegionSurfaceTapRegionSurface(@Builder.Parameter WidgetI child) {
    var st = factories.tapRegionSurfaceTapRegionSurface(child.build());
    if (st == null) throw new RuntimeException("Failed to created widget TapRegionSurface");
    return new TapRegionSurface(st);
  }
  public static TapRegionSurfaceTapRegionSurfaceBuilder tapRegionSurface(WidgetI child) {
    return TapRegionSurfaceTapRegionSurfaceBuilder.tapRegionSurfaceTapRegionSurface(child);
  }
  @Override
  public TapRegionSurface build() {
    return this;
  }
}
