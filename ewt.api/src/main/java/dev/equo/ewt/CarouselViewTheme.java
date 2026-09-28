package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class CarouselViewTheme extends InheritedTheme implements CarouselViewThemeI {
  protected CarouselViewTheme() {}
  CarouselViewTheme(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget CarouselViewTheme");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static CarouselViewTheme carouselViewThemeCarouselViewTheme(@Builder.Parameter CarouselViewThemeDataI data, @Builder.Parameter WidgetI child) {
    int id = factories.carouselViewThemeCarouselViewTheme(data.build(),
      child.build());
    if (id <= 0) throw new RuntimeException("Failed to created widget CarouselViewTheme");
    return new CarouselViewTheme(id);
  }
  public static CarouselViewThemeCarouselViewThemeBuilder carouselViewTheme(CarouselViewThemeDataI data, WidgetI child) {
    return CarouselViewThemeCarouselViewThemeBuilder.carouselViewThemeCarouselViewTheme(data, child);
  }
  public static CarouselViewThemeData of(BuildContextI context) {
    int id = factories.carouselViewThemeOf(context.build());
    if (id <= 0) throw new RuntimeException("Failed to created widget CarouselViewThemeData");
    return new CarouselViewThemeData(id);
  }
  public CarouselViewThemeData data() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("carouselViewThemeData", getId());
      return new CarouselViewThemeData(__nid);
    }
    return factories.CarouselViewTheme_readBack_data(nativeStruct);
  }
  @Override
  public CarouselViewTheme build() {
    return this;
  }
}
