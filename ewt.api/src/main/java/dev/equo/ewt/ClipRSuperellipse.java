package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class ClipRSuperellipse extends SingleChildRenderObjectWidget implements ClipRSuperellipseI {
  protected ClipRSuperellipse() {}
  ClipRSuperellipse(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget ClipRSuperellipse");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static ClipRSuperellipse clipRSuperellipseClipRSuperellipse(Optional<BorderRadiusGeometryI> borderRadius, Optional<Clip> clipBehavior, Optional<WidgetI> child) {
    int id = factories.clipRSuperellipseClipRSuperellipse(borderRadius.map(BorderRadiusGeometryI::build),
      clipBehavior,
      child.map(WidgetI::build));
    if (id <= 0) throw new RuntimeException("Failed to created widget ClipRSuperellipse");
    return new ClipRSuperellipse(id);
  }
  public static ClipRSuperellipseClipRSuperellipseBuilder clipRSuperellipse() {
    return ClipRSuperellipseClipRSuperellipseBuilder.clipRSuperellipseClipRSuperellipse();
  }
  public BorderRadiusGeometry borderRadius() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("clipRSuperellipseBorderRadius not supported on web");
    return factories.ClipRSuperellipse_readBack_borderRadius(nativeStruct);
  }
  public Clip clipBehavior() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("clipRSuperellipseClipBehavior not supported on web");
    return factories.ClipRSuperellipse_readBack_clipBehavior(nativeStruct);
  }
  @Override
  public ClipRSuperellipse build() {
    return this;
  }
}
