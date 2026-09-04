package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.CarouselViewThemeDataObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class CarouselViewThemeData extends NativeObj.Base implements CarouselViewThemeDataI {
  private MemorySegment st;
  protected CarouselViewThemeData() {}
  CarouselViewThemeData(MemorySegment st) {
    this.id = CarouselViewThemeDataObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget CarouselViewThemeData");
    System.out.println("New CarouselViewThemeData id:"+id);
  }
  CarouselViewThemeData(int id) { this.id = id; }
  @Builder.Factory
  static CarouselViewThemeData carouselViewThemeDataCarouselViewThemeData(OptionalDouble elevation, Optional<ColorI> backgroundColor, Optional<ColorI> overlayColor, Optional<OutlinedBorderI> shape, Optional<EdgeInsetsI> padding) {
    var st = factories.carouselViewThemeDataCarouselViewThemeData(elevation,
      backgroundColor.map(ColorI::build),
      overlayColor.map(ColorI::build),
      shape.map(OutlinedBorderI::build),
      padding.map(EdgeInsetsI::build));
    if (st == null) throw new RuntimeException("Failed to created widget CarouselViewThemeData");
    return new CarouselViewThemeData(st);
  }
  public static CarouselViewThemeDataCarouselViewThemeDataBuilder carouselViewThemeData() {
    return CarouselViewThemeDataCarouselViewThemeDataBuilder.carouselViewThemeDataCarouselViewThemeData();
  }
  public static CarouselViewThemeData lerp(CarouselViewThemeDataI a, CarouselViewThemeDataI b, double t) {
    var st = factories.carouselViewThemeDataLerp(a.build(),
      b.build(),
      t);
    if (st == null) throw new RuntimeException("Failed to created widget CarouselViewThemeData");
    return new CarouselViewThemeData(st);
  }
  public EdgeInsets padding() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("carouselViewThemeDataPadding", getId());
      java.lang.foreign.MemorySegment __st = dev.equo.ewt.ffm.EdgeInsetsObjSt.allocate(__s.arena);
      dev.equo.ewt.ffm.EdgeInsetsObjSt.id(__st, __nid);
      return new EdgeInsets(__st);
    }
    return new EdgeInsets(CarouselViewThemeDataObjSt.padding(st));
  }
  public Color backgroundColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("carouselViewThemeDataBackgroundColor", getId());
      return new Color(__nid);
    }
    return new Color(CarouselViewThemeDataObjSt.backgroundColor(st));
  }
  public double elevation() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("carouselViewThemeDataElevation not supported on web");
    return CarouselViewThemeDataObjSt.elevation(st);
  }
  public OutlinedBorder shape() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("carouselViewThemeDataShape not supported on web");
    return new OutlinedBorder(CarouselViewThemeDataObjSt.shape(st)) {};
  }
  @Override
  public CarouselViewThemeData build() {
    return this;
  }
}
