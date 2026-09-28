package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class RawScrollbar extends StatefulWidget implements RawScrollbarI {
  protected RawScrollbar() {}
  RawScrollbar(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget RawScrollbar");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static RawScrollbar rawScrollbarRawScrollbar(@Builder.Parameter WidgetI child, Optional<Boolean> thumbVisibility, Optional<OutlinedBorderI> shape, Optional<RadiusI> radius, OptionalDouble thickness, Optional<ColorI> thumbColor, OptionalDouble minThumbLength, OptionalDouble minOverscrollLength, Optional<Boolean> trackVisibility, Optional<RadiusI> trackRadius, Optional<ColorI> trackColor, Optional<ColorI> trackBorderColor, Optional<DurationI> fadeDuration, Optional<DurationI> timeToFade, Optional<DurationI> pressDuration, Optional<Boolean> interactive, Optional<ScrollbarOrientation> scrollbarOrientation, OptionalDouble mainAxisMargin, OptionalDouble crossAxisMargin, Optional<EdgeInsetsGeometryI> padding) {
    int id = factories.rawScrollbarRawScrollbar(child.build(),
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
    if (id <= 0) throw new RuntimeException("Failed to created widget RawScrollbar");
    return new RawScrollbar(id);
  }
  public static RawScrollbarRawScrollbarBuilder rawScrollbar(WidgetI child) {
    return RawScrollbarRawScrollbarBuilder.rawScrollbarRawScrollbar(child);
  }
  public Widget child() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("rawScrollbarChild not supported on web");
    return factories.RawScrollbar_readBack_child(nativeStruct);
  }
  public boolean thumbVisibility() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("rawScrollbarThumbVisibility not supported on web");
    return factories.RawScrollbar_readBack_thumbVisibility(nativeStruct);
  }
  public OutlinedBorder shape() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("rawScrollbarShape not supported on web");
    return factories.RawScrollbar_readBack_shape(nativeStruct);
  }
  public Radius radius() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("rawScrollbarRadius", getId());
      return new Radius(__nid);
    }
    return factories.RawScrollbar_readBack_radius(nativeStruct);
  }
  public double thickness() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("rawScrollbarThickness not supported on web");
    return factories.RawScrollbar_readBack_thickness(nativeStruct);
  }
  public Color thumbColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("rawScrollbarThumbColor", getId());
      return new Color(__nid);
    }
    return factories.RawScrollbar_readBack_thumbColor(nativeStruct);
  }
  public double minThumbLength() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("rawScrollbarMinThumbLength not supported on web");
    return factories.RawScrollbar_readBack_minThumbLength(nativeStruct);
  }
  public double minOverscrollLength() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("rawScrollbarMinOverscrollLength not supported on web");
    return factories.RawScrollbar_readBack_minOverscrollLength(nativeStruct);
  }
  public boolean trackVisibility() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("rawScrollbarTrackVisibility not supported on web");
    return factories.RawScrollbar_readBack_trackVisibility(nativeStruct);
  }
  public Radius trackRadius() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("rawScrollbarTrackRadius", getId());
      return new Radius(__nid);
    }
    return factories.RawScrollbar_readBack_trackRadius(nativeStruct);
  }
  public Color trackColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("rawScrollbarTrackColor", getId());
      return new Color(__nid);
    }
    return factories.RawScrollbar_readBack_trackColor(nativeStruct);
  }
  public Color trackBorderColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("rawScrollbarTrackBorderColor", getId());
      return new Color(__nid);
    }
    return factories.RawScrollbar_readBack_trackBorderColor(nativeStruct);
  }
  public Duration fadeDuration() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("rawScrollbarFadeDuration", getId());
      return new Duration(__nid);
    }
    return factories.RawScrollbar_readBack_fadeDuration(nativeStruct);
  }
  public Duration timeToFade() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("rawScrollbarTimeToFade", getId());
      return new Duration(__nid);
    }
    return factories.RawScrollbar_readBack_timeToFade(nativeStruct);
  }
  public Duration pressDuration() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("rawScrollbarPressDuration", getId());
      return new Duration(__nid);
    }
    return factories.RawScrollbar_readBack_pressDuration(nativeStruct);
  }
  public boolean interactive() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("rawScrollbarInteractive not supported on web");
    return factories.RawScrollbar_readBack_interactive(nativeStruct);
  }
  public ScrollbarOrientation scrollbarOrientation() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("rawScrollbarScrollbarOrientation not supported on web");
    return factories.RawScrollbar_readBack_scrollbarOrientation(nativeStruct);
  }
  public double mainAxisMargin() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("rawScrollbarMainAxisMargin not supported on web");
    return factories.RawScrollbar_readBack_mainAxisMargin(nativeStruct);
  }
  public double crossAxisMargin() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("rawScrollbarCrossAxisMargin not supported on web");
    return factories.RawScrollbar_readBack_crossAxisMargin(nativeStruct);
  }
  public EdgeInsetsGeometry padding() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("rawScrollbarPadding not supported on web");
    return factories.RawScrollbar_readBack_padding(nativeStruct);
  }
  @Override
  public RawScrollbar build() {
    return this;
  }
}
