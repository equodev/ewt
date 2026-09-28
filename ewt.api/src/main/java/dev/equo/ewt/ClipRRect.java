package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class ClipRRect extends SingleChildRenderObjectWidget implements ClipRRectI {
  protected ClipRRect() {}
  ClipRRect(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget ClipRRect");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static ClipRRect clipRRectClipRRect(Optional<BorderRadiusGeometryI> borderRadius, Optional<Clip> clipBehavior, Optional<WidgetI> child) {
    int id = factories.clipRRectClipRRect(borderRadius.map(BorderRadiusGeometryI::build),
      clipBehavior,
      child.map(WidgetI::build));
    if (id <= 0) throw new RuntimeException("Failed to created widget ClipRRect");
    return new ClipRRect(id);
  }
  public static ClipRRectClipRRectBuilder clipRRect() {
    return ClipRRectClipRRectBuilder.clipRRectClipRRect();
  }
  public BorderRadiusGeometry borderRadius() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("clipRRectBorderRadius not supported on web");
    return factories.ClipRRect_readBack_borderRadius(nativeStruct);
  }
  public Clip clipBehavior() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("clipRRectClipBehavior not supported on web");
    return factories.ClipRRect_readBack_clipBehavior(nativeStruct);
  }
  @Override
  public ClipRRect build() {
    return this;
  }
}
