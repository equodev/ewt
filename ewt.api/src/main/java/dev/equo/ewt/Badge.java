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
    return new Color(BadgeObjSt.backgroundColor(st));
  }
  public Color textColor() {
    return new Color(BadgeObjSt.textColor(st));
  }
  public double smallSize() {
    return BadgeObjSt.smallSize(st);
  }
  public double largeSize() {
    return BadgeObjSt.largeSize(st);
  }
  public TextStyle textStyle() {
    return new TextStyle(BadgeObjSt.textStyle(st));
  }
  public EdgeInsetsGeometry padding() {
    return new EdgeInsetsGeometry(BadgeObjSt.padding(st)) {};
  }
  public AlignmentGeometry alignment() {
    return new AlignmentGeometry(BadgeObjSt.alignment(st)) {};
  }
  public Offset offset() {
    return new Offset(BadgeObjSt.offset(st));
  }
  public Widget label() {
    return new Widget(BadgeObjSt.label(st)) {};
  }
  public boolean isLabelVisible() {
    return intToBool(BadgeObjSt.isLabelVisible(st));
  }
  public Widget child() {
    return new Widget(BadgeObjSt.child(st)) {};
  }
  @Override
  public Badge build() {
    return this;
  }
}
