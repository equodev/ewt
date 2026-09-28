package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class TooltipTheme extends InheritedTheme implements TooltipThemeI {
  protected TooltipTheme() {}
  TooltipTheme(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget TooltipTheme");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static TooltipTheme tooltipThemeTooltipTheme(@Builder.Parameter TooltipThemeDataI data, @Builder.Parameter WidgetI child) {
    int id = factories.tooltipThemeTooltipTheme(data.build(),
      child.build());
    if (id <= 0) throw new RuntimeException("Failed to created widget TooltipTheme");
    return new TooltipTheme(id);
  }
  public static TooltipThemeTooltipThemeBuilder tooltipTheme(TooltipThemeDataI data, WidgetI child) {
    return TooltipThemeTooltipThemeBuilder.tooltipThemeTooltipTheme(data, child);
  }
  public static TooltipThemeData of(BuildContextI context) {
    int id = factories.tooltipThemeOf(context.build());
    if (id <= 0) throw new RuntimeException("Failed to created widget TooltipThemeData");
    return new TooltipThemeData(id);
  }
  public TooltipThemeData data() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("tooltipThemeData", getId());
      return new TooltipThemeData(__nid);
    }
    return factories.TooltipTheme_readBack_data(nativeStruct);
  }
  @Override
  public TooltipTheme build() {
    return this;
  }
}
