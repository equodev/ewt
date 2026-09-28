package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class DropdownButton<T> extends StatefulWidget implements DropdownButtonI {
  protected DropdownButton() {}
  DropdownButton(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget DropdownButton");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static <T extends NativeObj> DropdownButton<T> dropdownButtonDropdownButton(Optional<List<DropdownMenuItemI>> items, Optional<Function<BuildContext, List<Widget>>> selectedItemBuilder, Optional<NativeObj> value, Optional<WidgetI> hint, Optional<WidgetI> disabledHint, Optional<Consumer<NativeObj>> onChanged, Optional<Runnable> onTap, OptionalInt elevation, Optional<TextStyleI> style, Optional<WidgetI> underline, Optional<WidgetI> icon, Optional<ColorI> iconDisabledColor, Optional<ColorI> iconEnabledColor, OptionalDouble iconSize, Optional<Boolean> isDense, Optional<Boolean> isExpanded, OptionalDouble itemHeight, OptionalDouble menuWidth, Optional<ColorI> focusColor, Optional<Boolean> autofocus, Optional<ColorI> dropdownColor, OptionalDouble menuMaxHeight, Optional<Boolean> enableFeedback, Optional<AlignmentGeometryI> alignment, Optional<BorderRadiusI> borderRadius, Optional<EdgeInsetsGeometryI> padding, Optional<Boolean> barrierDismissible) {
    int id = factories.dropdownButtonDropdownButton(items.map(i -> i.stream().map(DropdownMenuItemI::build).collect(java.util.stream.Collectors.toList())),
      selectedItemBuilder,
      value,
      hint.map(WidgetI::build),
      disabledHint.map(WidgetI::build),
      onChanged,
      onTap,
      elevation,
      style.map(TextStyleI::build),
      underline.map(WidgetI::build),
      icon.map(WidgetI::build),
      iconDisabledColor.map(ColorI::build),
      iconEnabledColor.map(ColorI::build),
      iconSize,
      isDense,
      isExpanded,
      itemHeight,
      menuWidth,
      focusColor.map(ColorI::build),
      autofocus,
      dropdownColor.map(ColorI::build),
      menuMaxHeight,
      enableFeedback,
      alignment.map(AlignmentGeometryI::build),
      borderRadius.map(BorderRadiusI::build),
      padding.map(EdgeInsetsGeometryI::build),
      barrierDismissible);
    if (id <= 0) throw new RuntimeException("Failed to created widget DropdownButton");
    return new DropdownButton(id);
  }
  public static <T extends NativeObj> DropdownButtonDropdownButtonBuilder<T> dropdownButton() {
    return DropdownButtonDropdownButtonBuilder.dropdownButtonDropdownButton();
  }
  public Widget hint() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("dropdownButtonHint not supported on web");
    return factories.DropdownButton_readBack_hint(nativeStruct);
  }
  public Widget disabledHint() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("dropdownButtonDisabledHint not supported on web");
    return factories.DropdownButton_readBack_disabledHint(nativeStruct);
  }
  public int elevation() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("dropdownButtonElevation not supported on web");
    return factories.DropdownButton_readBack_elevation(nativeStruct);
  }
  public TextStyle style() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("dropdownButtonStyle", getId());
      return new TextStyle(__nid);
    }
    return factories.DropdownButton_readBack_style(nativeStruct);
  }
  public Widget underline() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("dropdownButtonUnderline not supported on web");
    return factories.DropdownButton_readBack_underline(nativeStruct);
  }
  public Widget icon() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("dropdownButtonIcon not supported on web");
    return factories.DropdownButton_readBack_icon(nativeStruct);
  }
  public Color iconDisabledColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("dropdownButtonIconDisabledColor", getId());
      return new Color(__nid);
    }
    return factories.DropdownButton_readBack_iconDisabledColor(nativeStruct);
  }
  public Color iconEnabledColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("dropdownButtonIconEnabledColor", getId());
      return new Color(__nid);
    }
    return factories.DropdownButton_readBack_iconEnabledColor(nativeStruct);
  }
  public double iconSize() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("dropdownButtonIconSize not supported on web");
    return factories.DropdownButton_readBack_iconSize(nativeStruct);
  }
  public boolean isDense() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("dropdownButtonIsDense not supported on web");
    return factories.DropdownButton_readBack_isDense(nativeStruct);
  }
  public boolean isExpanded() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("dropdownButtonIsExpanded not supported on web");
    return factories.DropdownButton_readBack_isExpanded(nativeStruct);
  }
  public double itemHeight() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("dropdownButtonItemHeight not supported on web");
    return factories.DropdownButton_readBack_itemHeight(nativeStruct);
  }
  public double menuWidth() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("dropdownButtonMenuWidth not supported on web");
    return factories.DropdownButton_readBack_menuWidth(nativeStruct);
  }
  public Color focusColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("dropdownButtonFocusColor", getId());
      return new Color(__nid);
    }
    return factories.DropdownButton_readBack_focusColor(nativeStruct);
  }
  public boolean autofocus() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("dropdownButtonAutofocus not supported on web");
    return factories.DropdownButton_readBack_autofocus(nativeStruct);
  }
  public Color dropdownColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("dropdownButtonDropdownColor", getId());
      return new Color(__nid);
    }
    return factories.DropdownButton_readBack_dropdownColor(nativeStruct);
  }
  public EdgeInsetsGeometry padding() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("dropdownButtonPadding not supported on web");
    return factories.DropdownButton_readBack_padding(nativeStruct);
  }
  public double menuMaxHeight() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("dropdownButtonMenuMaxHeight not supported on web");
    return factories.DropdownButton_readBack_menuMaxHeight(nativeStruct);
  }
  public boolean enableFeedback() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("dropdownButtonEnableFeedback not supported on web");
    return factories.DropdownButton_readBack_enableFeedback(nativeStruct);
  }
  public AlignmentGeometry alignment() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("dropdownButtonAlignment not supported on web");
    return factories.DropdownButton_readBack_alignment(nativeStruct);
  }
  public BorderRadius borderRadius() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("dropdownButtonBorderRadius", getId());
      return new BorderRadius(__nid);
    }
    return factories.DropdownButton_readBack_borderRadius(nativeStruct);
  }
  public boolean barrierDismissible() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("dropdownButtonBarrierDismissible not supported on web");
    return factories.DropdownButton_readBack_barrierDismissible(nativeStruct);
  }
  @Override
  public DropdownButton build() {
    return this;
  }
}
