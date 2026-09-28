package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class PopupMenuTheme extends InheritedTheme implements PopupMenuThemeI {
  protected PopupMenuTheme() {}
  PopupMenuTheme(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget PopupMenuTheme");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static PopupMenuTheme popupMenuThemePopupMenuTheme(@Builder.Parameter PopupMenuThemeDataI data, @Builder.Parameter WidgetI child) {
    int id = factories.popupMenuThemePopupMenuTheme(data.build(),
      child.build());
    if (id <= 0) throw new RuntimeException("Failed to created widget PopupMenuTheme");
    return new PopupMenuTheme(id);
  }
  public static PopupMenuThemePopupMenuThemeBuilder popupMenuTheme(PopupMenuThemeDataI data, WidgetI child) {
    return PopupMenuThemePopupMenuThemeBuilder.popupMenuThemePopupMenuTheme(data, child);
  }
  public static PopupMenuThemeData of(BuildContextI context) {
    int id = factories.popupMenuThemeOf(context.build());
    if (id <= 0) throw new RuntimeException("Failed to created widget PopupMenuThemeData");
    return new PopupMenuThemeData(id);
  }
  public PopupMenuThemeData data() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("popupMenuThemeData", getId());
      return new PopupMenuThemeData(__nid);
    }
    return factories.PopupMenuTheme_readBack_data(nativeStruct);
  }
  @Override
  public PopupMenuTheme build() {
    return this;
  }
}
