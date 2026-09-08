package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.CarouselViewThemeObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class CarouselViewTheme extends InheritedTheme implements CarouselViewThemeI {
  private MemorySegment st;
  protected CarouselViewTheme() {}
  CarouselViewTheme(MemorySegment st) {
    this.id = CarouselViewThemeObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget CarouselViewTheme");
    System.out.println("New CarouselViewTheme id:"+id);
  }
  CarouselViewTheme(int id) { this.id = id; }
  @Builder.Factory
  static CarouselViewTheme carouselViewThemeCarouselViewTheme(@Builder.Parameter CarouselViewThemeDataI data, @Builder.Parameter WidgetI child) {
    var st = factories.carouselViewThemeCarouselViewTheme(data.build(),
      child.build());
    if (st == null) throw new RuntimeException("Failed to created widget CarouselViewTheme");
    return new CarouselViewTheme(st);
  }
  public static CarouselViewThemeCarouselViewThemeBuilder carouselViewTheme(CarouselViewThemeDataI data, WidgetI child) {
    return CarouselViewThemeCarouselViewThemeBuilder.carouselViewThemeCarouselViewTheme(data, child);
  }
  public static CarouselViewThemeData of(BuildContextI context) {
    var st = factories.carouselViewThemeOf(context.build());
    if (st == null) throw new RuntimeException("Failed to created widget CarouselViewThemeData");
    return new CarouselViewThemeData(st);
  }
  public CarouselViewThemeData data() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("carouselViewThemeData", getId());
      java.lang.foreign.MemorySegment __st = dev.equo.ewt.ffm.CarouselViewThemeDataObjSt.allocate(__s.arena);
      dev.equo.ewt.ffm.CarouselViewThemeDataObjSt.id(__st, __nid);
      return new CarouselViewThemeData(__st);
    }
    return new CarouselViewThemeData(CarouselViewThemeObjSt.data(st));
  }
  @Override
  public CarouselViewTheme build() {
    return this;
  }
}
