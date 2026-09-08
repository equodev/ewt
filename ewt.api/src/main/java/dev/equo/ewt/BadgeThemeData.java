package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.BadgeThemeDataObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class BadgeThemeData extends NativeObj.Base implements BadgeThemeDataI {
  private MemorySegment st;
  protected BadgeThemeData() {}
  BadgeThemeData(MemorySegment st) {
    this.id = BadgeThemeDataObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget BadgeThemeData");
    System.out.println("New BadgeThemeData id:"+id);
  }
  BadgeThemeData(int id) { this.id = id; }
  @Builder.Factory
  static BadgeThemeData badgeThemeDataBadgeThemeData(Optional<ColorI> backgroundColor, Optional<ColorI> textColor, OptionalDouble smallSize, OptionalDouble largeSize, Optional<TextStyleI> textStyle, Optional<EdgeInsetsGeometryI> padding, Optional<AlignmentGeometryI> alignment, Optional<OffsetI> offset) {
    var st = factories.badgeThemeDataBadgeThemeData(backgroundColor.map(ColorI::build),
      textColor.map(ColorI::build),
      smallSize,
      largeSize,
      textStyle.map(TextStyleI::build),
      padding.map(EdgeInsetsGeometryI::build),
      alignment.map(AlignmentGeometryI::build),
      offset.map(OffsetI::build));
    if (st == null) throw new RuntimeException("Failed to created widget BadgeThemeData");
    return new BadgeThemeData(st);
  }
  public static BadgeThemeDataBadgeThemeDataBuilder badgeThemeData() {
    return BadgeThemeDataBadgeThemeDataBuilder.badgeThemeDataBadgeThemeData();
  }
  public static BadgeThemeData lerp(BadgeThemeDataI a, BadgeThemeDataI b, double t) {
    var st = factories.badgeThemeDataLerp(a.build(),
      b.build(),
      t);
    if (st == null) throw new RuntimeException("Failed to created widget BadgeThemeData");
    return new BadgeThemeData(st);
  }
  public Color backgroundColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("badgeThemeDataBackgroundColor", getId());
      return new Color(__nid);
    }
    return new Color(BadgeThemeDataObjSt.backgroundColor(st));
  }
  public Color textColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("badgeThemeDataTextColor", getId());
      return new Color(__nid);
    }
    return new Color(BadgeThemeDataObjSt.textColor(st));
  }
  public double smallSize() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("badgeThemeDataSmallSize not supported on web");
    return BadgeThemeDataObjSt.smallSize(st);
  }
  public double largeSize() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("badgeThemeDataLargeSize not supported on web");
    return BadgeThemeDataObjSt.largeSize(st);
  }
  public TextStyle textStyle() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("badgeThemeDataTextStyle", getId());
      java.lang.foreign.MemorySegment __st = dev.equo.ewt.ffm.TextStyleObjSt.allocate(__s.arena);
      dev.equo.ewt.ffm.TextStyleObjSt.id(__st, __nid);
      return new TextStyle(__st);
    }
    return new TextStyle(BadgeThemeDataObjSt.textStyle(st));
  }
  public EdgeInsetsGeometry padding() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("badgeThemeDataPadding not supported on web");
    return new EdgeInsetsGeometry(BadgeThemeDataObjSt.padding(st)) {};
  }
  public AlignmentGeometry alignment() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("badgeThemeDataAlignment not supported on web");
    return new AlignmentGeometry(BadgeThemeDataObjSt.alignment(st)) {};
  }
  public Offset offset() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("badgeThemeDataOffset", getId());
      return new Offset(__nid);
    }
    return new Offset(BadgeThemeDataObjSt.offset(st));
  }
  @Override
  public BadgeThemeData build() {
    return this;
  }
}
