package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class CarouselView extends StatefulWidget implements CarouselViewI {
  protected CarouselView() {}
  CarouselView(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget CarouselView");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static CarouselView carouselViewCarouselView(Optional<EdgeInsetsI> padding, Optional<ColorI> backgroundColor, OptionalDouble elevation, Optional<ShapeBorderI> shape, Optional<Clip> itemClipBehavior, Optional<ColorI> overlayColor, Optional<Boolean> itemSnapping, OptionalDouble shrinkExtent, Optional<Axis> scrollDirection, Optional<Boolean> reverse, Optional<Consumer<Integer>> onTap, Optional<Boolean> enableSplash, Optional<Boolean> infinite, double itemExtent, List<WidgetI> children, Optional<Consumer<Integer>> onIndexChanged) {
    int id = factories.carouselViewCarouselView(padding.map(EdgeInsetsI::build),
      backgroundColor.map(ColorI::build),
      elevation,
      shape.map(ShapeBorderI::build),
      itemClipBehavior,
      overlayColor.map(ColorI::build),
      itemSnapping,
      shrinkExtent,
      scrollDirection,
      reverse,
      onTap,
      enableSplash,
      infinite,
      itemExtent,
      children.stream().map(WidgetI::build).collect(java.util.stream.Collectors.toList()),
      onIndexChanged);
    if (id <= 0) throw new RuntimeException("Failed to created widget CarouselView");
    return new CarouselView(id);
  }
  public static CarouselViewCarouselViewBuilder carouselView() {
    return CarouselViewCarouselViewBuilder.carouselViewCarouselView();
  }
  @Builder.Factory
  static CarouselView carouselViewBuilder(Optional<EdgeInsetsI> padding, Optional<ColorI> backgroundColor, OptionalDouble elevation, Optional<ShapeBorderI> shape, Optional<Clip> itemClipBehavior, Optional<ColorI> overlayColor, Optional<Boolean> itemSnapping, OptionalDouble shrinkExtent, Optional<Axis> scrollDirection, Optional<Boolean> reverse, Optional<Consumer<Integer>> onTap, Optional<Boolean> enableSplash, double itemExtent, Optional<BiFunction<BuildContext, Integer, Widget>> itemBuilder, OptionalInt itemCount, Optional<Consumer<Integer>> onIndexChanged, Optional<Boolean> infinite) {
    int id = factories.carouselViewBuilder(padding.map(EdgeInsetsI::build),
      backgroundColor.map(ColorI::build),
      elevation,
      shape.map(ShapeBorderI::build),
      itemClipBehavior,
      overlayColor.map(ColorI::build),
      itemSnapping,
      shrinkExtent,
      scrollDirection,
      reverse,
      onTap,
      enableSplash,
      itemExtent,
      itemBuilder,
      itemCount,
      onIndexChanged,
      infinite);
    if (id <= 0) throw new RuntimeException("Failed to created widget CarouselView");
    return new CarouselView(id);
  }
  public static CarouselViewBuilderBuilder builder() {
    return CarouselViewBuilderBuilder.carouselViewBuilder();
  }
  public EdgeInsets padding() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("carouselViewPadding", getId());
      return new EdgeInsets(__nid);
    }
    return factories.CarouselView_readBack_padding(nativeStruct);
  }
  public Color backgroundColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("carouselViewBackgroundColor", getId());
      return new Color(__nid);
    }
    return factories.CarouselView_readBack_backgroundColor(nativeStruct);
  }
  public double elevation() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("carouselViewElevation not supported on web");
    return factories.CarouselView_readBack_elevation(nativeStruct);
  }
  public ShapeBorder shape() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("carouselViewShape not supported on web");
    return factories.CarouselView_readBack_shape(nativeStruct);
  }
  public Clip itemClipBehavior() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("carouselViewItemClipBehavior not supported on web");
    return factories.CarouselView_readBack_itemClipBehavior(nativeStruct);
  }
  public double shrinkExtent() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("carouselViewShrinkExtent not supported on web");
    return factories.CarouselView_readBack_shrinkExtent(nativeStruct);
  }
  public boolean itemSnapping() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("carouselViewItemSnapping not supported on web");
    return factories.CarouselView_readBack_itemSnapping(nativeStruct);
  }
  public Axis scrollDirection() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("carouselViewScrollDirection not supported on web");
    return factories.CarouselView_readBack_scrollDirection(nativeStruct);
  }
  public boolean reverse() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("carouselViewReverse not supported on web");
    return factories.CarouselView_readBack_reverse(nativeStruct);
  }
  public boolean consumeMaxWeight() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("carouselViewConsumeMaxWeight not supported on web");
    return factories.CarouselView_readBack_consumeMaxWeight(nativeStruct);
  }
  public boolean enableSplash() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("carouselViewEnableSplash not supported on web");
    return factories.CarouselView_readBack_enableSplash(nativeStruct);
  }
  public double itemExtent() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("carouselViewItemExtent not supported on web");
    return factories.CarouselView_readBack_itemExtent(nativeStruct);
  }
  public int itemCount() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("carouselViewItemCount not supported on web");
    return factories.CarouselView_readBack_itemCount(nativeStruct);
  }
  public boolean infinite() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("carouselViewInfinite not supported on web");
    return factories.CarouselView_readBack_infinite(nativeStruct);
  }
  @Override
  public CarouselView build() {
    return this;
  }
}
