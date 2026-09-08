package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.ShrinkWrappingViewportObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class ShrinkWrappingViewport extends MultiChildRenderObjectWidget implements ShrinkWrappingViewportI {
  private MemorySegment st;
  protected ShrinkWrappingViewport() {}
  ShrinkWrappingViewport(MemorySegment st) {
    this.id = ShrinkWrappingViewportObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget ShrinkWrappingViewport");
    System.out.println("New ShrinkWrappingViewport id:"+id);
  }
  ShrinkWrappingViewport(int id) { this.id = id; }
  public AxisDirection axisDirection() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("shrinkWrappingViewportAxisDirection not supported on web");
    return AxisDirection.values()[ShrinkWrappingViewportObjSt.axisDirection(st)];
  }
  public AxisDirection crossAxisDirection() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("shrinkWrappingViewportCrossAxisDirection not supported on web");
    return AxisDirection.values()[ShrinkWrappingViewportObjSt.crossAxisDirection(st)];
  }
  public SliverPaintOrder paintOrder() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("shrinkWrappingViewportPaintOrder not supported on web");
    return SliverPaintOrder.values()[ShrinkWrappingViewportObjSt.paintOrder(st)];
  }
  public Clip clipBehavior() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("shrinkWrappingViewportClipBehavior not supported on web");
    return Clip.values()[ShrinkWrappingViewportObjSt.clipBehavior(st)];
  }
  @Override
  public ShrinkWrappingViewport build() {
    return this;
  }
}
