package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.CarouselViewObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class CarouselView extends StatefulWidget implements CarouselViewI {
  private MemorySegment st;
  protected CarouselView() {}
  CarouselView(MemorySegment st) {
    this.id = CarouselViewObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget CarouselView");
    System.out.println("New CarouselView id:"+id);
  }
  CarouselView(int id) { this.id = id; }
  @Builder.Factory
  static CarouselView carouselViewCarouselView(Optional<EdgeInsetsI> padding, Optional<ColorI> backgroundColor, OptionalDouble elevation, Optional<ShapeBorderI> shape, Optional<ColorI> overlayColor, Optional<Boolean> itemSnapping, OptionalDouble shrinkExtent, Optional<Axis> scrollDirection, Optional<Boolean> reverse, Optional<Consumer<Integer>> onTap, Optional<Boolean> enableSplash, double itemExtent, List<WidgetI> children) {
    var st = factories.carouselViewCarouselView(padding.map(EdgeInsetsI::build),
      backgroundColor.map(ColorI::build),
      elevation,
      shape.map(ShapeBorderI::build),
      overlayColor.map(ColorI::build),
      itemSnapping,
      shrinkExtent,
      scrollDirection,
      reverse,
      onTap,
      enableSplash,
      itemExtent,
      children.stream().map(WidgetI::build).toList());
    if (st == null) throw new RuntimeException("Failed to created widget CarouselView");
    return new CarouselView(st);
  }
  public static CarouselViewCarouselViewBuilder carouselView() {
    return CarouselViewCarouselViewBuilder.carouselViewCarouselView();
  }
  public EdgeInsets padding() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("carouselViewPadding", getId());
      java.lang.foreign.MemorySegment __st = dev.equo.ewt.ffm.EdgeInsetsObjSt.allocate(__s.arena);
      dev.equo.ewt.ffm.EdgeInsetsObjSt.id(__st, __nid);
      return new EdgeInsets(__st);
    }
    return new EdgeInsets(CarouselViewObjSt.padding(st));
  }
  public Color backgroundColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("carouselViewBackgroundColor", getId());
      return new Color(__nid);
    }
    return new Color(CarouselViewObjSt.backgroundColor(st));
  }
  public double elevation() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("carouselViewElevation not supported on web");
    return CarouselViewObjSt.elevation(st);
  }
  public ShapeBorder shape() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("carouselViewShape not supported on web");
    return new ShapeBorder(CarouselViewObjSt.shape(st)) {};
  }
  public double shrinkExtent() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("carouselViewShrinkExtent not supported on web");
    return CarouselViewObjSt.shrinkExtent(st);
  }
  public boolean itemSnapping() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("carouselViewItemSnapping not supported on web");
    return intToBool(CarouselViewObjSt.itemSnapping(st));
  }
  public Axis scrollDirection() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("carouselViewScrollDirection not supported on web");
    return Axis.values()[CarouselViewObjSt.scrollDirection(st)];
  }
  public boolean reverse() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("carouselViewReverse not supported on web");
    return intToBool(CarouselViewObjSt.reverse(st));
  }
  public boolean consumeMaxWeight() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("carouselViewConsumeMaxWeight not supported on web");
    return intToBool(CarouselViewObjSt.consumeMaxWeight(st));
  }
  public boolean enableSplash() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("carouselViewEnableSplash not supported on web");
    return intToBool(CarouselViewObjSt.enableSplash(st));
  }
  public double itemExtent() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("carouselViewItemExtent not supported on web");
    return CarouselViewObjSt.itemExtent(st);
  }
  @Override
  public CarouselView build() {
    return this;
  }
}
