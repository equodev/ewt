package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class ColorFiltered extends SingleChildRenderObjectWidget implements ColorFilteredI {
  protected ColorFiltered() {}
  ColorFiltered(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget ColorFiltered");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static ColorFiltered colorFilteredColorFiltered(@Builder.Parameter ColorFilterI colorFilter, Optional<WidgetI> child) {
    int id = factories.colorFilteredColorFiltered(colorFilter.build(),
      child.map(WidgetI::build));
    if (id <= 0) throw new RuntimeException("Failed to created widget ColorFiltered");
    return new ColorFiltered(id);
  }
  public static ColorFilteredColorFilteredBuilder colorFiltered(ColorFilterI colorFilter) {
    return ColorFilteredColorFilteredBuilder.colorFilteredColorFiltered(colorFilter);
  }
  public ColorFilter colorFilter() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("colorFilteredColorFilter", getId());
      return new ColorFilter(__nid);
    }
    return factories.ColorFiltered_readBack_colorFilter(nativeStruct);
  }
  @Override
  public ColorFiltered build() {
    return this;
  }
}
