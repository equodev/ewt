package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.BadgeObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class Badge extends StatelessWidget implements BadgeI {
  private MemorySegment st;
  protected Badge() {}
  Badge(MemorySegment st) {
    this.id = BadgeObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget Badge");
    System.out.println("New Badge id:"+id);
  }
  Badge(int id) { this.id = id; }
  @Builder.Factory
  static Badge badgeBadge(Optional<ColorI> backgroundColor, Optional<ColorI> textColor, OptionalDouble smallSize, OptionalDouble largeSize, Optional<TextStyleI> textStyle, Optional<EdgeInsetsGeometryI> padding, Optional<AlignmentGeometryI> alignment, Optional<OffsetI> offset, Optional<WidgetI> label, Optional<Boolean> isLabelVisible, Optional<WidgetI> child) {
    var st = factories.badgeBadge(backgroundColor.map(ColorI::build),
      textColor.map(ColorI::build),
      smallSize,
      largeSize,
      textStyle.map(TextStyleI::build),
      padding.map(EdgeInsetsGeometryI::build),
      alignment.map(AlignmentGeometryI::build),
      offset.map(OffsetI::build),
      label.map(WidgetI::build),
      isLabelVisible,
      child.map(WidgetI::build));
    if (st == null) throw new RuntimeException("Failed to created widget Badge");
    return new Badge(st);
  }
  public static BadgeBadgeBuilder badge() {
    return BadgeBadgeBuilder.badgeBadge();
  }
  @Builder.Factory
  static Badge badgeCount(Optional<ColorI> backgroundColor, Optional<ColorI> textColor, OptionalDouble smallSize, OptionalDouble largeSize, Optional<TextStyleI> textStyle, Optional<EdgeInsetsGeometryI> padding, Optional<AlignmentGeometryI> alignment, Optional<OffsetI> offset, int count, Optional<Boolean> isLabelVisible, Optional<WidgetI> child) {
    var st = factories.badgeCount(backgroundColor.map(ColorI::build),
      textColor.map(ColorI::build),
      smallSize,
      largeSize,
      textStyle.map(TextStyleI::build),
      padding.map(EdgeInsetsGeometryI::build),
      alignment.map(AlignmentGeometryI::build),
      offset.map(OffsetI::build),
      count,
      isLabelVisible,
      child.map(WidgetI::build));
    if (st == null) throw new RuntimeException("Failed to created widget Badge");
    return new Badge(st);
  }
  public static BadgeCountBuilder count() {
    return BadgeCountBuilder.badgeCount();
  }
  public Color backgroundColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("badgeBackgroundColor", getId());
      return new Color(__nid);
    }
    return new Color(BadgeObjSt.backgroundColor(st));
  }
  public Color textColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("badgeTextColor", getId());
      return new Color(__nid);
    }
    return new Color(BadgeObjSt.textColor(st));
  }
  public double smallSize() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("badgeSmallSize not supported on web");
    return BadgeObjSt.smallSize(st);
  }
  public double largeSize() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("badgeLargeSize not supported on web");
    return BadgeObjSt.largeSize(st);
  }
  public TextStyle textStyle() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("badgeTextStyle", getId());
      java.lang.foreign.MemorySegment __st = dev.equo.ewt.ffm.TextStyleObjSt.allocate(__s.arena);
      dev.equo.ewt.ffm.TextStyleObjSt.id(__st, __nid);
      return new TextStyle(__st);
    }
    return new TextStyle(BadgeObjSt.textStyle(st));
  }
  public EdgeInsetsGeometry padding() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("badgePadding not supported on web");
    return new EdgeInsetsGeometry(BadgeObjSt.padding(st)) {};
  }
  public AlignmentGeometry alignment() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("badgeAlignment not supported on web");
    return new AlignmentGeometry(BadgeObjSt.alignment(st)) {};
  }
  public Offset offset() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("badgeOffset", getId());
      return new Offset(__nid);
    }
    return new Offset(BadgeObjSt.offset(st));
  }
  public Widget label() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("badgeLabel not supported on web");
    return new Widget(BadgeObjSt.label(st)) {};
  }
  public boolean isLabelVisible() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("badgeIsLabelVisible not supported on web");
    return intToBool(BadgeObjSt.isLabelVisible(st));
  }
  public Widget child() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("badgeChild not supported on web");
    return new Widget(BadgeObjSt.child(st)) {};
  }
  @Override
  public Badge build() {
    return this;
  }
}
