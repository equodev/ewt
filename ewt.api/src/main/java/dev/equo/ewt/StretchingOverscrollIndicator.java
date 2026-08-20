package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.StretchingOverscrollIndicatorObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class StretchingOverscrollIndicator extends StatefulWidget implements StretchingOverscrollIndicatorI {
  private MemorySegment st;
  protected StretchingOverscrollIndicator() {}
  StretchingOverscrollIndicator(MemorySegment st) {
    this.id = StretchingOverscrollIndicatorObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget StretchingOverscrollIndicator");
    System.out.println("New StretchingOverscrollIndicator id:"+id);
  }
  StretchingOverscrollIndicator(int id) { this.id = id; }
  @Builder.Factory
  static StretchingOverscrollIndicator stretchingOverscrollIndicatorStretchingOverscrollIndicator(@Builder.Parameter AxisDirection axisDirection, Optional<Clip> clipBehavior, Optional<WidgetI> child) {
    var st = factories.stretchingOverscrollIndicatorStretchingOverscrollIndicator(axisDirection,
      clipBehavior,
      child.map(WidgetI::build));
    if (st == null) throw new RuntimeException("Failed to created widget StretchingOverscrollIndicator");
    return new StretchingOverscrollIndicator(st);
  }
  public static StretchingOverscrollIndicatorStretchingOverscrollIndicatorBuilder stretchingOverscrollIndicator(AxisDirection axisDirection) {
    return StretchingOverscrollIndicatorStretchingOverscrollIndicatorBuilder.stretchingOverscrollIndicatorStretchingOverscrollIndicator(axisDirection);
  }
  public AxisDirection axisDirection() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("stretchingOverscrollIndicatorAxisDirection not supported on web");
    return AxisDirection.values()[StretchingOverscrollIndicatorObjSt.axisDirection(st)];
  }
  public Clip clipBehavior() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("stretchingOverscrollIndicatorClipBehavior not supported on web");
    return Clip.values()[StretchingOverscrollIndicatorObjSt.clipBehavior(st)];
  }
  public Widget child() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("stretchingOverscrollIndicatorChild not supported on web");
    return new Widget(StretchingOverscrollIndicatorObjSt.child(st)) {};
  }
  public Axis axis() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("stretchingOverscrollIndicatorAxis not supported on web");
    return Axis.values()[StretchingOverscrollIndicatorObjSt.axis(st)];
  }
  @Override
  public StretchingOverscrollIndicator build() {
    return this;
  }
}
