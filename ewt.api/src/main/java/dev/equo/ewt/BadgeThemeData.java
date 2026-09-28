package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class BadgeThemeData extends NativeObj.Base implements BadgeThemeDataI {
  protected BadgeThemeData() {}
  BadgeThemeData(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget BadgeThemeData");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static BadgeThemeData badgeThemeDataBadgeThemeData(Optional<ColorI> backgroundColor, Optional<ColorI> textColor, OptionalDouble smallSize, OptionalDouble largeSize, Optional<TextStyleI> textStyle, Optional<EdgeInsetsGeometryI> padding, Optional<AlignmentGeometryI> alignment, Optional<OffsetI> offset) {
    int id = factories.badgeThemeDataBadgeThemeData(backgroundColor.map(ColorI::build),
      textColor.map(ColorI::build),
      smallSize,
      largeSize,
      textStyle.map(TextStyleI::build),
      padding.map(EdgeInsetsGeometryI::build),
      alignment.map(AlignmentGeometryI::build),
      offset.map(OffsetI::build));
    if (id <= 0) throw new RuntimeException("Failed to created widget BadgeThemeData");
    return new BadgeThemeData(id);
  }
  public static BadgeThemeDataBadgeThemeDataBuilder badgeThemeData() {
    return BadgeThemeDataBadgeThemeDataBuilder.badgeThemeDataBadgeThemeData();
  }
  public static BadgeThemeData lerp(BadgeThemeDataI a, BadgeThemeDataI b, double t) {
    int id = factories.badgeThemeDataLerp(a.build(),
      b.build(),
      t);
    if (id <= 0) throw new RuntimeException("Failed to created widget BadgeThemeData");
    return new BadgeThemeData(id);
  }
  public Color backgroundColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("badgeThemeDataBackgroundColor", getId());
      return new Color(__nid);
    }
    return factories.BadgeThemeData_readBack_backgroundColor(nativeStruct);
  }
  public Color textColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("badgeThemeDataTextColor", getId());
      return new Color(__nid);
    }
    return factories.BadgeThemeData_readBack_textColor(nativeStruct);
  }
  public double smallSize() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("badgeThemeDataSmallSize not supported on web");
    return factories.BadgeThemeData_readBack_smallSize(nativeStruct);
  }
  public double largeSize() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("badgeThemeDataLargeSize not supported on web");
    return factories.BadgeThemeData_readBack_largeSize(nativeStruct);
  }
  public TextStyle textStyle() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("badgeThemeDataTextStyle", getId());
      return new TextStyle(__nid);
    }
    return factories.BadgeThemeData_readBack_textStyle(nativeStruct);
  }
  public EdgeInsetsGeometry padding() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("badgeThemeDataPadding not supported on web");
    return factories.BadgeThemeData_readBack_padding(nativeStruct);
  }
  public AlignmentGeometry alignment() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("badgeThemeDataAlignment not supported on web");
    return factories.BadgeThemeData_readBack_alignment(nativeStruct);
  }
  public Offset offset() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("badgeThemeDataOffset", getId());
      return new Offset(__nid);
    }
    return factories.BadgeThemeData_readBack_offset(nativeStruct);
  }
  @Override
  public BadgeThemeData build() {
    return this;
  }
}
