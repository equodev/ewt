package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.RawScrollbarObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class RawScrollbar extends StatefulWidget implements RawScrollbarI {
  private MemorySegment st;
  protected RawScrollbar() {}
  RawScrollbar(MemorySegment st) {
    this.id = RawScrollbarObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget RawScrollbar");
    System.out.println("New RawScrollbar id:"+id);
  }
  RawScrollbar(int id) { this.id = id; }
  @Builder.Factory
  static RawScrollbar rawScrollbarRawScrollbar(@Builder.Parameter WidgetI child, Optional<Boolean> thumbVisibility, Optional<OutlinedBorderI> shape, Optional<RadiusI> radius, OptionalDouble thickness, Optional<ColorI> thumbColor, OptionalDouble minThumbLength, OptionalDouble minOverscrollLength, Optional<Boolean> trackVisibility, Optional<RadiusI> trackRadius, Optional<ColorI> trackColor, Optional<ColorI> trackBorderColor, Optional<DurationI> fadeDuration, Optional<DurationI> timeToFade, Optional<DurationI> pressDuration, Optional<Boolean> interactive, Optional<ScrollbarOrientation> scrollbarOrientation, OptionalDouble mainAxisMargin, OptionalDouble crossAxisMargin, Optional<EdgeInsetsGeometryI> padding) {
    var st = factories.rawScrollbarRawScrollbar(child.build(),
      thumbVisibility,
      shape.map(OutlinedBorderI::build),
      radius.map(RadiusI::build),
      thickness,
      thumbColor.map(ColorI::build),
      minThumbLength,
      minOverscrollLength,
      trackVisibility,
      trackRadius.map(RadiusI::build),
      trackColor.map(ColorI::build),
      trackBorderColor.map(ColorI::build),
      fadeDuration.map(DurationI::build),
      timeToFade.map(DurationI::build),
      pressDuration.map(DurationI::build),
      interactive,
      scrollbarOrientation,
      mainAxisMargin,
      crossAxisMargin,
      padding.map(EdgeInsetsGeometryI::build));
    if (st == null) throw new RuntimeException("Failed to created widget RawScrollbar");
    return new RawScrollbar(st);
  }
  public static RawScrollbarRawScrollbarBuilder rawScrollbar(WidgetI child) {
    return RawScrollbarRawScrollbarBuilder.rawScrollbarRawScrollbar(child);
  }
  public Widget child() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("rawScrollbarChild not supported on web");
    return new Widget(RawScrollbarObjSt.child(st)) {};
  }
  public boolean thumbVisibility() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("rawScrollbarThumbVisibility not supported on web");
    return intToBool(RawScrollbarObjSt.thumbVisibility(st));
  }
  public OutlinedBorder shape() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("rawScrollbarShape not supported on web");
    return new OutlinedBorder(RawScrollbarObjSt.shape(st)) {};
  }
  public Radius radius() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("rawScrollbarRadius", getId());
      return new Radius(__nid);
    }
    return new Radius(RawScrollbarObjSt.radius(st));
  }
  public double thickness() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("rawScrollbarThickness not supported on web");
    return RawScrollbarObjSt.thickness(st);
  }
  public Color thumbColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("rawScrollbarThumbColor", getId());
      return new Color(__nid);
    }
    return new Color(RawScrollbarObjSt.thumbColor(st));
  }
  public double minThumbLength() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("rawScrollbarMinThumbLength not supported on web");
    return RawScrollbarObjSt.minThumbLength(st);
  }
  public double minOverscrollLength() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("rawScrollbarMinOverscrollLength not supported on web");
    return RawScrollbarObjSt.minOverscrollLength(st);
  }
  public boolean trackVisibility() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("rawScrollbarTrackVisibility not supported on web");
    return intToBool(RawScrollbarObjSt.trackVisibility(st));
  }
  public Radius trackRadius() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("rawScrollbarTrackRadius", getId());
      return new Radius(__nid);
    }
    return new Radius(RawScrollbarObjSt.trackRadius(st));
  }
  public Color trackColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("rawScrollbarTrackColor", getId());
      return new Color(__nid);
    }
    return new Color(RawScrollbarObjSt.trackColor(st));
  }
  public Color trackBorderColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("rawScrollbarTrackBorderColor", getId());
      return new Color(__nid);
    }
    return new Color(RawScrollbarObjSt.trackBorderColor(st));
  }
  public Duration fadeDuration() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("rawScrollbarFadeDuration", getId());
      return new Duration(__nid);
    }
    return new Duration(RawScrollbarObjSt.fadeDuration(st));
  }
  public Duration timeToFade() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("rawScrollbarTimeToFade", getId());
      return new Duration(__nid);
    }
    return new Duration(RawScrollbarObjSt.timeToFade(st));
  }
  public Duration pressDuration() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("rawScrollbarPressDuration", getId());
      return new Duration(__nid);
    }
    return new Duration(RawScrollbarObjSt.pressDuration(st));
  }
  public boolean interactive() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("rawScrollbarInteractive not supported on web");
    return intToBool(RawScrollbarObjSt.interactive(st));
  }
  public ScrollbarOrientation scrollbarOrientation() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("rawScrollbarScrollbarOrientation not supported on web");
    return ScrollbarOrientation.values()[RawScrollbarObjSt.scrollbarOrientation(st)];
  }
  public double mainAxisMargin() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("rawScrollbarMainAxisMargin not supported on web");
    return RawScrollbarObjSt.mainAxisMargin(st);
  }
  public double crossAxisMargin() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("rawScrollbarCrossAxisMargin not supported on web");
    return RawScrollbarObjSt.crossAxisMargin(st);
  }
  public EdgeInsetsGeometry padding() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("rawScrollbarPadding not supported on web");
    return new EdgeInsetsGeometry(RawScrollbarObjSt.padding(st)) {};
  }
  @Override
  public RawScrollbar build() {
    return this;
  }
}
