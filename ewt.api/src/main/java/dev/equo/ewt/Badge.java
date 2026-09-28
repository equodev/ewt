package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class Badge extends StatelessWidget implements BadgeI {
  protected Badge() {}
  Badge(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget Badge");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static Badge badgeBadge(Optional<ColorI> backgroundColor, Optional<ColorI> textColor, OptionalDouble smallSize, OptionalDouble largeSize, Optional<TextStyleI> textStyle, Optional<EdgeInsetsGeometryI> padding, Optional<AlignmentGeometryI> alignment, Optional<OffsetI> offset, Optional<WidgetI> label, Optional<Boolean> isLabelVisible, Optional<WidgetI> child) {
    int id = factories.badgeBadge(backgroundColor.map(ColorI::build),
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
    if (id <= 0) throw new RuntimeException("Failed to created widget Badge");
    return new Badge(id);
  }
  public static BadgeBadgeBuilder badge() {
    return BadgeBadgeBuilder.badgeBadge();
  }
  @Builder.Factory
  static Badge badgeCount(Optional<ColorI> backgroundColor, Optional<ColorI> textColor, OptionalDouble smallSize, OptionalDouble largeSize, Optional<TextStyleI> textStyle, Optional<EdgeInsetsGeometryI> padding, Optional<AlignmentGeometryI> alignment, Optional<OffsetI> offset, int count, OptionalInt maxCount, Optional<Boolean> isLabelVisible, Optional<WidgetI> child) {
    int id = factories.badgeCount(backgroundColor.map(ColorI::build),
      textColor.map(ColorI::build),
      smallSize,
      largeSize,
      textStyle.map(TextStyleI::build),
      padding.map(EdgeInsetsGeometryI::build),
      alignment.map(AlignmentGeometryI::build),
      offset.map(OffsetI::build),
      count,
      maxCount,
      isLabelVisible,
      child.map(WidgetI::build));
    if (id <= 0) throw new RuntimeException("Failed to created widget Badge");
    return new Badge(id);
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
    return factories.Badge_readBack_backgroundColor(nativeStruct);
  }
  public Color textColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("badgeTextColor", getId());
      return new Color(__nid);
    }
    return factories.Badge_readBack_textColor(nativeStruct);
  }
  public double smallSize() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("badgeSmallSize not supported on web");
    return factories.Badge_readBack_smallSize(nativeStruct);
  }
  public double largeSize() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("badgeLargeSize not supported on web");
    return factories.Badge_readBack_largeSize(nativeStruct);
  }
  public TextStyle textStyle() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("badgeTextStyle", getId());
      return new TextStyle(__nid);
    }
    return factories.Badge_readBack_textStyle(nativeStruct);
  }
  public EdgeInsetsGeometry padding() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("badgePadding not supported on web");
    return factories.Badge_readBack_padding(nativeStruct);
  }
  public AlignmentGeometry alignment() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("badgeAlignment not supported on web");
    return factories.Badge_readBack_alignment(nativeStruct);
  }
  public Offset offset() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("badgeOffset", getId());
      return new Offset(__nid);
    }
    return factories.Badge_readBack_offset(nativeStruct);
  }
  public Widget label() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("badgeLabel not supported on web");
    return factories.Badge_readBack_label(nativeStruct);
  }
  public boolean isLabelVisible() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("badgeIsLabelVisible not supported on web");
    return factories.Badge_readBack_isLabelVisible(nativeStruct);
  }
  public Widget child() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("badgeChild not supported on web");
    return factories.Badge_readBack_child(nativeStruct);
  }
  @Override
  public Badge build() {
    return this;
  }
}
