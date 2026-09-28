package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class ShrinkWrappingViewport extends MultiChildRenderObjectWidget implements ShrinkWrappingViewportI {
  protected ShrinkWrappingViewport() {}
  ShrinkWrappingViewport(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget ShrinkWrappingViewport");
    this.nativeStruct = factories.takeLastStruct();
  }
  public AxisDirection axisDirection() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("shrinkWrappingViewportAxisDirection not supported on web");
    return factories.ShrinkWrappingViewport_readBack_axisDirection(nativeStruct);
  }
  public AxisDirection crossAxisDirection() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("shrinkWrappingViewportCrossAxisDirection not supported on web");
    return factories.ShrinkWrappingViewport_readBack_crossAxisDirection(nativeStruct);
  }
  public SliverPaintOrder paintOrder() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("shrinkWrappingViewportPaintOrder not supported on web");
    return factories.ShrinkWrappingViewport_readBack_paintOrder(nativeStruct);
  }
  public Clip clipBehavior() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("shrinkWrappingViewportClipBehavior not supported on web");
    return factories.ShrinkWrappingViewport_readBack_clipBehavior(nativeStruct);
  }
  public double cacheExtent() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("shrinkWrappingViewportCacheExtent not supported on web");
    return factories.ShrinkWrappingViewport_readBack_cacheExtent(nativeStruct);
  }
  public CacheExtentStyle cacheExtentStyle() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("shrinkWrappingViewportCacheExtentStyle not supported on web");
    return factories.ShrinkWrappingViewport_readBack_cacheExtentStyle(nativeStruct);
  }
  @Override
  public ShrinkWrappingViewport build() {
    return this;
  }
}
