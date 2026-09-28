package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class TapRegionSurface extends SingleChildRenderObjectWidget implements TapRegionSurfaceI {
  protected TapRegionSurface() {}
  TapRegionSurface(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget TapRegionSurface");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static TapRegionSurface tapRegionSurfaceTapRegionSurface(@Builder.Parameter WidgetI child) {
    int id = factories.tapRegionSurfaceTapRegionSurface(child.build());
    if (id <= 0) throw new RuntimeException("Failed to created widget TapRegionSurface");
    return new TapRegionSurface(id);
  }
  public static TapRegionSurfaceTapRegionSurfaceBuilder tapRegionSurface(WidgetI child) {
    return TapRegionSurfaceTapRegionSurfaceBuilder.tapRegionSurfaceTapRegionSurface(child);
  }
  @Override
  public TapRegionSurface build() {
    return this;
  }
}
