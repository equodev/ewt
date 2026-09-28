package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class Positioned extends ParentDataWidget<StackParentData> implements PositionedI {
  protected Positioned() {}
  Positioned(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget Positioned");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static Positioned positionedPositioned(OptionalDouble left, OptionalDouble top, OptionalDouble right, OptionalDouble bottom, OptionalDouble width, OptionalDouble height, WidgetI child) {
    int id = factories.positionedPositioned(left,
      top,
      right,
      bottom,
      width,
      height,
      child.build());
    if (id <= 0) throw new RuntimeException("Failed to created widget Positioned");
    return new Positioned(id);
  }
  public static PositionedPositionedBuilder positioned() {
    return PositionedPositionedBuilder.positionedPositioned();
  }
  @Builder.Factory
  static Positioned positionedFill(OptionalDouble left, OptionalDouble top, OptionalDouble right, OptionalDouble bottom, WidgetI child) {
    int id = factories.positionedFill(left,
      top,
      right,
      bottom,
      child.build());
    if (id <= 0) throw new RuntimeException("Failed to created widget Positioned");
    return new Positioned(id);
  }
  public static PositionedFillBuilder fill() {
    return PositionedFillBuilder.positionedFill();
  }
  @Builder.Factory
  static Positioned positionedDirectional(@Builder.Parameter TextDirection textDirection, OptionalDouble start, OptionalDouble top, OptionalDouble end, OptionalDouble bottom, OptionalDouble width, OptionalDouble height, WidgetI child) {
    int id = factories.positionedDirectional(textDirection,
      start,
      top,
      end,
      bottom,
      width,
      height,
      child.build());
    if (id <= 0) throw new RuntimeException("Failed to created widget Positioned");
    return new Positioned(id);
  }
  public static PositionedDirectionalBuilder directional(TextDirection textDirection) {
    return PositionedDirectionalBuilder.positionedDirectional(textDirection);
  }
  public double left() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("positionedLeft not supported on web");
    return factories.Positioned_readBack_left(nativeStruct);
  }
  public double top() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("positionedTop not supported on web");
    return factories.Positioned_readBack_top(nativeStruct);
  }
  public double right() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("positionedRight not supported on web");
    return factories.Positioned_readBack_right(nativeStruct);
  }
  public double bottom() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("positionedBottom not supported on web");
    return factories.Positioned_readBack_bottom(nativeStruct);
  }
  public double width() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("positionedWidth not supported on web");
    return factories.Positioned_readBack_width(nativeStruct);
  }
  public double height() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("positionedHeight not supported on web");
    return factories.Positioned_readBack_height(nativeStruct);
  }
  @Override
  public Positioned build() {
    return this;
  }
}
