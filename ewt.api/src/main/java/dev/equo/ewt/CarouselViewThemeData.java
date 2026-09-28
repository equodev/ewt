package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class CarouselViewThemeData extends NativeObj.Base implements CarouselViewThemeDataI {
  protected CarouselViewThemeData() {}
  CarouselViewThemeData(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget CarouselViewThemeData");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static CarouselViewThemeData carouselViewThemeDataCarouselViewThemeData(OptionalDouble elevation, Optional<ColorI> backgroundColor, Optional<ColorI> overlayColor, Optional<OutlinedBorderI> shape, Optional<EdgeInsetsI> padding, Optional<Clip> itemClipBehavior) {
    int id = factories.carouselViewThemeDataCarouselViewThemeData(elevation,
      backgroundColor.map(ColorI::build),
      overlayColor.map(ColorI::build),
      shape.map(OutlinedBorderI::build),
      padding.map(EdgeInsetsI::build),
      itemClipBehavior);
    if (id <= 0) throw new RuntimeException("Failed to created widget CarouselViewThemeData");
    return new CarouselViewThemeData(id);
  }
  public static CarouselViewThemeDataCarouselViewThemeDataBuilder carouselViewThemeData() {
    return CarouselViewThemeDataCarouselViewThemeDataBuilder.carouselViewThemeDataCarouselViewThemeData();
  }
  public static CarouselViewThemeData lerp(CarouselViewThemeDataI a, CarouselViewThemeDataI b, double t) {
    int id = factories.carouselViewThemeDataLerp(a.build(),
      b.build(),
      t);
    if (id <= 0) throw new RuntimeException("Failed to created widget CarouselViewThemeData");
    return new CarouselViewThemeData(id);
  }
  public EdgeInsets padding() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("carouselViewThemeDataPadding", getId());
      return new EdgeInsets(__nid);
    }
    return factories.CarouselViewThemeData_readBack_padding(nativeStruct);
  }
  public Color backgroundColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("carouselViewThemeDataBackgroundColor", getId());
      return new Color(__nid);
    }
    return factories.CarouselViewThemeData_readBack_backgroundColor(nativeStruct);
  }
  public double elevation() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("carouselViewThemeDataElevation not supported on web");
    return factories.CarouselViewThemeData_readBack_elevation(nativeStruct);
  }
  public OutlinedBorder shape() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("carouselViewThemeDataShape not supported on web");
    return factories.CarouselViewThemeData_readBack_shape(nativeStruct);
  }
  public Clip itemClipBehavior() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("carouselViewThemeDataItemClipBehavior not supported on web");
    return factories.CarouselViewThemeData_readBack_itemClipBehavior(nativeStruct);
  }
  @Override
  public CarouselViewThemeData build() {
    return this;
  }
}
