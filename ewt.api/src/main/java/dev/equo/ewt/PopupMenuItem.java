package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class PopupMenuItem<T> extends PopupMenuEntry<T> implements PopupMenuItemI {
  protected PopupMenuItem() {}
  PopupMenuItem(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget PopupMenuItem");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static <T extends NativeObj> PopupMenuItem<T> popupMenuItemPopupMenuItem(Optional<NativeObj> value, Optional<Runnable> onTap, Optional<Boolean> enabled, OptionalDouble height, Optional<EdgeInsetsI> padding, Optional<TextStyleI> textStyle, Optional<TextStyleI> labelTextStyle, Optional<WidgetI> child) {
    int id = factories.popupMenuItemPopupMenuItem(value,
      onTap,
      enabled,
      height,
      padding.map(EdgeInsetsI::build),
      textStyle.map(TextStyleI::build),
      labelTextStyle.map(TextStyleI::build),
      child.map(WidgetI::build));
    if (id <= 0) throw new RuntimeException("Failed to created widget PopupMenuItem");
    return new PopupMenuItem(id);
  }
  public static <T extends NativeObj> PopupMenuItemPopupMenuItemBuilder<T> popupMenuItem() {
    return PopupMenuItemPopupMenuItemBuilder.popupMenuItemPopupMenuItem();
  }
  public boolean enabled() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("popupMenuItemEnabled not supported on web");
    return factories.PopupMenuItem_readBack_enabled(nativeStruct);
  }
  public double height() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("popupMenuItemHeight not supported on web");
    return factories.PopupMenuItem_readBack_height(nativeStruct);
  }
  public EdgeInsets padding() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("popupMenuItemPadding", getId());
      return new EdgeInsets(__nid);
    }
    return factories.PopupMenuItem_readBack_padding(nativeStruct);
  }
  public TextStyle textStyle() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("popupMenuItemTextStyle", getId());
      return new TextStyle(__nid);
    }
    return factories.PopupMenuItem_readBack_textStyle(nativeStruct);
  }
  public Widget child() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("popupMenuItemChild not supported on web");
    return factories.PopupMenuItem_readBack_child(nativeStruct);
  }
  @Override
  public PopupMenuItem build() {
    return this;
  }
}
