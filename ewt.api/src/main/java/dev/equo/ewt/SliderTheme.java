package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class SliderTheme extends InheritedTheme implements SliderThemeI {
  protected SliderTheme() {}
  SliderTheme(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget SliderTheme");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static SliderTheme sliderThemeSliderTheme(@Builder.Parameter SliderThemeDataI data, @Builder.Parameter WidgetI child) {
    int id = factories.sliderThemeSliderTheme(data.build(),
      child.build());
    if (id <= 0) throw new RuntimeException("Failed to created widget SliderTheme");
    return new SliderTheme(id);
  }
  public static SliderThemeSliderThemeBuilder sliderTheme(SliderThemeDataI data, WidgetI child) {
    return SliderThemeSliderThemeBuilder.sliderThemeSliderTheme(data, child);
  }
  public static SliderThemeData of(BuildContextI context) {
    int id = factories.sliderThemeOf(context.build());
    if (id <= 0) throw new RuntimeException("Failed to created widget SliderThemeData");
    return new SliderThemeData(id);
  }
  public SliderThemeData data() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("sliderThemeData", getId());
      return new SliderThemeData(__nid);
    }
    return factories.SliderTheme_readBack_data(nativeStruct);
  }
  @Override
  public SliderTheme build() {
    return this;
  }
}
