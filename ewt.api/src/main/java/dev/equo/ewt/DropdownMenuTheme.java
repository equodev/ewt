package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class DropdownMenuTheme extends InheritedTheme implements DropdownMenuThemeI {
  protected DropdownMenuTheme() {}
  DropdownMenuTheme(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget DropdownMenuTheme");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static DropdownMenuTheme dropdownMenuThemeDropdownMenuTheme(@Builder.Parameter DropdownMenuThemeDataI data, @Builder.Parameter WidgetI child) {
    int id = factories.dropdownMenuThemeDropdownMenuTheme(data.build(),
      child.build());
    if (id <= 0) throw new RuntimeException("Failed to created widget DropdownMenuTheme");
    return new DropdownMenuTheme(id);
  }
  public static DropdownMenuThemeDropdownMenuThemeBuilder dropdownMenuTheme(DropdownMenuThemeDataI data, WidgetI child) {
    return DropdownMenuThemeDropdownMenuThemeBuilder.dropdownMenuThemeDropdownMenuTheme(data, child);
  }
  public static DropdownMenuThemeData of(BuildContextI context) {
    int id = factories.dropdownMenuThemeOf(context.build());
    if (id <= 0) throw new RuntimeException("Failed to created widget DropdownMenuThemeData");
    return new DropdownMenuThemeData(id);
  }
  public static DropdownMenuThemeData maybeOf(BuildContextI context) {
    int id = factories.dropdownMenuThemeMaybeOf(context.build());
    if (id <= 0) throw new RuntimeException("Failed to created widget DropdownMenuThemeData");
    return new DropdownMenuThemeData(id);
  }
  public DropdownMenuThemeData data() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("dropdownMenuThemeData", getId());
      return new DropdownMenuThemeData(__nid);
    }
    return factories.DropdownMenuTheme_readBack_data(nativeStruct);
  }
  @Override
  public DropdownMenuTheme build() {
    return this;
  }
}
