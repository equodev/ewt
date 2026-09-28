package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class CupertinoSearchTextField extends StatefulWidget implements CupertinoSearchTextFieldI {
  protected CupertinoSearchTextField() {}
  CupertinoSearchTextField(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget CupertinoSearchTextField");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static CupertinoSearchTextField cupertinoSearchTextFieldCupertinoSearchTextField(Optional<Consumer<String>> onChanged, Optional<Consumer<String>> onSubmitted, Optional<TextStyleI> style, Optional<String> placeholder, Optional<TextStyleI> placeholderStyle, Optional<BoxDecorationI> decoration, Optional<ColorI> backgroundColor, Optional<BorderRadiusI> borderRadius, Optional<EdgeInsetsGeometryI> padding, Optional<ColorI> itemColor, OptionalDouble itemSize, Optional<EdgeInsetsGeometryI> prefixInsets, Optional<WidgetI> prefixIcon, Optional<EdgeInsetsGeometryI> suffixInsets, Optional<IconI> suffixIcon, Optional<OverlayVisibilityMode> suffixMode, Optional<Runnable> onSuffixTap, Optional<String> restorationId, Optional<SmartQuotesType> smartQuotesType, Optional<SmartDashesType> smartDashesType, Optional<Boolean> enableIMEPersonalizedLearning, Optional<Boolean> autofocus, Optional<Runnable> onTap, Optional<Boolean> autocorrect, Optional<Boolean> enabled, OptionalDouble cursorWidth, OptionalDouble cursorHeight, Optional<RadiusI> cursorRadius, Optional<Boolean> cursorOpacityAnimates, Optional<ColorI> cursorColor) {
    int id = factories.cupertinoSearchTextFieldCupertinoSearchTextField(onChanged,
      onSubmitted,
      style.map(TextStyleI::build),
      placeholder,
      placeholderStyle.map(TextStyleI::build),
      decoration.map(BoxDecorationI::build),
      backgroundColor.map(ColorI::build),
      borderRadius.map(BorderRadiusI::build),
      padding.map(EdgeInsetsGeometryI::build),
      itemColor.map(ColorI::build),
      itemSize,
      prefixInsets.map(EdgeInsetsGeometryI::build),
      prefixIcon.map(WidgetI::build),
      suffixInsets.map(EdgeInsetsGeometryI::build),
      suffixIcon.map(IconI::build),
      suffixMode,
      onSuffixTap,
      restorationId,
      smartQuotesType,
      smartDashesType,
      enableIMEPersonalizedLearning,
      autofocus,
      onTap,
      autocorrect,
      enabled,
      cursorWidth,
      cursorHeight,
      cursorRadius.map(RadiusI::build),
      cursorOpacityAnimates,
      cursorColor.map(ColorI::build));
    if (id <= 0) throw new RuntimeException("Failed to created widget CupertinoSearchTextField");
    return new CupertinoSearchTextField(id);
  }
  public static CupertinoSearchTextFieldCupertinoSearchTextFieldBuilder cupertinoSearchTextField() {
    return CupertinoSearchTextFieldCupertinoSearchTextFieldBuilder.cupertinoSearchTextFieldCupertinoSearchTextField();
  }
  public TextStyle style() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("cupertinoSearchTextFieldStyle", getId());
      return new TextStyle(__nid);
    }
    return factories.CupertinoSearchTextField_readBack_style(nativeStruct);
  }
  public String placeholder() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoSearchTextFieldPlaceholder not supported on web");
    return factories.CupertinoSearchTextField_readBack_placeholder(nativeStruct);
  }
  public TextStyle placeholderStyle() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("cupertinoSearchTextFieldPlaceholderStyle", getId());
      return new TextStyle(__nid);
    }
    return factories.CupertinoSearchTextField_readBack_placeholderStyle(nativeStruct);
  }
  public BoxDecoration decoration() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("cupertinoSearchTextFieldDecoration", getId());
      return new BoxDecoration(__nid);
    }
    return factories.CupertinoSearchTextField_readBack_decoration(nativeStruct);
  }
  public Color backgroundColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("cupertinoSearchTextFieldBackgroundColor", getId());
      return new Color(__nid);
    }
    return factories.CupertinoSearchTextField_readBack_backgroundColor(nativeStruct);
  }
  public BorderRadius borderRadius() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("cupertinoSearchTextFieldBorderRadius", getId());
      return new BorderRadius(__nid);
    }
    return factories.CupertinoSearchTextField_readBack_borderRadius(nativeStruct);
  }
  public EdgeInsetsGeometry padding() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoSearchTextFieldPadding not supported on web");
    return factories.CupertinoSearchTextField_readBack_padding(nativeStruct);
  }
  public Color itemColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("cupertinoSearchTextFieldItemColor", getId());
      return new Color(__nid);
    }
    return factories.CupertinoSearchTextField_readBack_itemColor(nativeStruct);
  }
  public double itemSize() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoSearchTextFieldItemSize not supported on web");
    return factories.CupertinoSearchTextField_readBack_itemSize(nativeStruct);
  }
  public EdgeInsetsGeometry prefixInsets() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoSearchTextFieldPrefixInsets not supported on web");
    return factories.CupertinoSearchTextField_readBack_prefixInsets(nativeStruct);
  }
  public Widget prefixIcon() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoSearchTextFieldPrefixIcon not supported on web");
    return factories.CupertinoSearchTextField_readBack_prefixIcon(nativeStruct);
  }
  public EdgeInsetsGeometry suffixInsets() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoSearchTextFieldSuffixInsets not supported on web");
    return factories.CupertinoSearchTextField_readBack_suffixInsets(nativeStruct);
  }
  public Icon suffixIcon() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("cupertinoSearchTextFieldSuffixIcon", getId());
      return new Icon(__nid);
    }
    return factories.CupertinoSearchTextField_readBack_suffixIcon(nativeStruct);
  }
  public OverlayVisibilityMode suffixMode() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoSearchTextFieldSuffixMode not supported on web");
    return factories.CupertinoSearchTextField_readBack_suffixMode(nativeStruct);
  }
  public String restorationId() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoSearchTextFieldRestorationId not supported on web");
    return factories.CupertinoSearchTextField_readBack_restorationId(nativeStruct);
  }
  public boolean autofocus() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoSearchTextFieldAutofocus not supported on web");
    return factories.CupertinoSearchTextField_readBack_autofocus(nativeStruct);
  }
  public boolean autocorrect() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoSearchTextFieldAutocorrect not supported on web");
    return factories.CupertinoSearchTextField_readBack_autocorrect(nativeStruct);
  }
  public SmartQuotesType smartQuotesType() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoSearchTextFieldSmartQuotesType not supported on web");
    return factories.CupertinoSearchTextField_readBack_smartQuotesType(nativeStruct);
  }
  public SmartDashesType smartDashesType() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoSearchTextFieldSmartDashesType not supported on web");
    return factories.CupertinoSearchTextField_readBack_smartDashesType(nativeStruct);
  }
  public boolean enableIMEPersonalizedLearning() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoSearchTextFieldEnableIMEPersonalizedLearning not supported on web");
    return factories.CupertinoSearchTextField_readBack_enableIMEPersonalizedLearning(nativeStruct);
  }
  public boolean enabled() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoSearchTextFieldEnabled not supported on web");
    return factories.CupertinoSearchTextField_readBack_enabled(nativeStruct);
  }
  public double cursorWidth() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoSearchTextFieldCursorWidth not supported on web");
    return factories.CupertinoSearchTextField_readBack_cursorWidth(nativeStruct);
  }
  public double cursorHeight() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoSearchTextFieldCursorHeight not supported on web");
    return factories.CupertinoSearchTextField_readBack_cursorHeight(nativeStruct);
  }
  public Radius cursorRadius() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("cupertinoSearchTextFieldCursorRadius", getId());
      return new Radius(__nid);
    }
    return factories.CupertinoSearchTextField_readBack_cursorRadius(nativeStruct);
  }
  public boolean cursorOpacityAnimates() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoSearchTextFieldCursorOpacityAnimates not supported on web");
    return factories.CupertinoSearchTextField_readBack_cursorOpacityAnimates(nativeStruct);
  }
  public Color cursorColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("cupertinoSearchTextFieldCursorColor", getId());
      return new Color(__nid);
    }
    return factories.CupertinoSearchTextField_readBack_cursorColor(nativeStruct);
  }
  @Override
  public CupertinoSearchTextField build() {
    return this;
  }
}
