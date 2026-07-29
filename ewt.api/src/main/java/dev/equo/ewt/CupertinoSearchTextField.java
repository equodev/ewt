package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.CupertinoSearchTextFieldObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class CupertinoSearchTextField extends StatefulWidget implements CupertinoSearchTextFieldI {
  private MemorySegment st;
  protected CupertinoSearchTextField() {}
  CupertinoSearchTextField(MemorySegment st) {
    this.id = CupertinoSearchTextFieldObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget CupertinoSearchTextField");
    System.out.println("New CupertinoSearchTextField id:"+id);
  }
  CupertinoSearchTextField(int id) { this.id = id; }
  @Builder.Factory
  static CupertinoSearchTextField cupertinoSearchTextFieldCupertinoSearchTextField(Optional<Consumer<String>> onChanged, Optional<Consumer<String>> onSubmitted, Optional<TextStyleI> style, Optional<String> placeholder, Optional<TextStyleI> placeholderStyle, Optional<BoxDecorationI> decoration, Optional<ColorI> backgroundColor, Optional<BorderRadiusI> borderRadius, Optional<EdgeInsetsGeometryI> padding, Optional<ColorI> itemColor, OptionalDouble itemSize, Optional<EdgeInsetsGeometryI> prefixInsets, Optional<WidgetI> prefixIcon, Optional<EdgeInsetsGeometryI> suffixInsets, Optional<IconI> suffixIcon, Optional<OverlayVisibilityMode> suffixMode, Optional<Runnable> onSuffixTap, Optional<String> restorationId, Optional<SmartQuotesType> smartQuotesType, Optional<SmartDashesType> smartDashesType, Optional<Boolean> enableIMEPersonalizedLearning, Optional<Boolean> autofocus, Optional<Runnable> onTap, Optional<Boolean> autocorrect, Optional<Boolean> enabled, OptionalDouble cursorWidth, OptionalDouble cursorHeight, Optional<RadiusI> cursorRadius, Optional<Boolean> cursorOpacityAnimates, Optional<ColorI> cursorColor) {
    var st = factories.cupertinoSearchTextFieldCupertinoSearchTextField(onChanged,
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
    if (st == null) throw new RuntimeException("Failed to created widget CupertinoSearchTextField");
    return new CupertinoSearchTextField(st);
  }
  public static CupertinoSearchTextFieldCupertinoSearchTextFieldBuilder cupertinoSearchTextField() {
    return CupertinoSearchTextFieldCupertinoSearchTextFieldBuilder.cupertinoSearchTextFieldCupertinoSearchTextField();
  }
  public TextStyle style() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("cupertinoSearchTextFieldStyle", getId());
      java.lang.foreign.MemorySegment __st = dev.equo.ewt.ffm.TextStyleObjSt.allocate(__s.arena);
      dev.equo.ewt.ffm.TextStyleObjSt.id(__st, __nid);
      return new TextStyle(__st);
    }
    return new TextStyle(CupertinoSearchTextFieldObjSt.style(st));
  }
  public String placeholder() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoSearchTextFieldPlaceholder not supported on web");
    return CupertinoSearchTextFieldObjSt.placeholder(st).getString(0);
  }
  public TextStyle placeholderStyle() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("cupertinoSearchTextFieldPlaceholderStyle", getId());
      java.lang.foreign.MemorySegment __st = dev.equo.ewt.ffm.TextStyleObjSt.allocate(__s.arena);
      dev.equo.ewt.ffm.TextStyleObjSt.id(__st, __nid);
      return new TextStyle(__st);
    }
    return new TextStyle(CupertinoSearchTextFieldObjSt.placeholderStyle(st));
  }
  public BoxDecoration decoration() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("cupertinoSearchTextFieldDecoration", getId());
      java.lang.foreign.MemorySegment __st = dev.equo.ewt.ffm.BoxDecorationObjSt.allocate(__s.arena);
      dev.equo.ewt.ffm.BoxDecorationObjSt.id(__st, __nid);
      return new BoxDecoration(__st);
    }
    return new BoxDecoration(CupertinoSearchTextFieldObjSt.decoration(st));
  }
  public Color backgroundColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("cupertinoSearchTextFieldBackgroundColor", getId());
      return new Color(__nid);
    }
    return new Color(CupertinoSearchTextFieldObjSt.backgroundColor(st));
  }
  public BorderRadius borderRadius() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("cupertinoSearchTextFieldBorderRadius", getId());
      java.lang.foreign.MemorySegment __st = dev.equo.ewt.ffm.BorderRadiusObjSt.allocate(__s.arena);
      dev.equo.ewt.ffm.BorderRadiusObjSt.id(__st, __nid);
      return new BorderRadius(__st);
    }
    return new BorderRadius(CupertinoSearchTextFieldObjSt.borderRadius(st));
  }
  public EdgeInsetsGeometry padding() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoSearchTextFieldPadding not supported on web");
    return new EdgeInsetsGeometry(CupertinoSearchTextFieldObjSt.padding(st)) {};
  }
  public Color itemColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("cupertinoSearchTextFieldItemColor", getId());
      return new Color(__nid);
    }
    return new Color(CupertinoSearchTextFieldObjSt.itemColor(st));
  }
  public double itemSize() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoSearchTextFieldItemSize not supported on web");
    return CupertinoSearchTextFieldObjSt.itemSize(st);
  }
  public EdgeInsetsGeometry prefixInsets() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoSearchTextFieldPrefixInsets not supported on web");
    return new EdgeInsetsGeometry(CupertinoSearchTextFieldObjSt.prefixInsets(st)) {};
  }
  public Widget prefixIcon() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoSearchTextFieldPrefixIcon not supported on web");
    return new Widget(CupertinoSearchTextFieldObjSt.prefixIcon(st)) {};
  }
  public EdgeInsetsGeometry suffixInsets() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoSearchTextFieldSuffixInsets not supported on web");
    return new EdgeInsetsGeometry(CupertinoSearchTextFieldObjSt.suffixInsets(st)) {};
  }
  public Icon suffixIcon() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("cupertinoSearchTextFieldSuffixIcon", getId());
      java.lang.foreign.MemorySegment __st = dev.equo.ewt.ffm.IconObjSt.allocate(__s.arena);
      dev.equo.ewt.ffm.IconObjSt.id(__st, __nid);
      return new Icon(__st);
    }
    return new Icon(CupertinoSearchTextFieldObjSt.suffixIcon(st));
  }
  public OverlayVisibilityMode suffixMode() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoSearchTextFieldSuffixMode not supported on web");
    return OverlayVisibilityMode.values()[CupertinoSearchTextFieldObjSt.suffixMode(st)];
  }
  public String restorationId() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoSearchTextFieldRestorationId not supported on web");
    return CupertinoSearchTextFieldObjSt.restorationId(st).getString(0);
  }
  public boolean autofocus() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoSearchTextFieldAutofocus not supported on web");
    return intToBool(CupertinoSearchTextFieldObjSt.autofocus(st));
  }
  public boolean autocorrect() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoSearchTextFieldAutocorrect not supported on web");
    return intToBool(CupertinoSearchTextFieldObjSt.autocorrect(st));
  }
  public SmartQuotesType smartQuotesType() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoSearchTextFieldSmartQuotesType not supported on web");
    return SmartQuotesType.values()[CupertinoSearchTextFieldObjSt.smartQuotesType(st)];
  }
  public SmartDashesType smartDashesType() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoSearchTextFieldSmartDashesType not supported on web");
    return SmartDashesType.values()[CupertinoSearchTextFieldObjSt.smartDashesType(st)];
  }
  public boolean enableIMEPersonalizedLearning() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoSearchTextFieldEnableIMEPersonalizedLearning not supported on web");
    return intToBool(CupertinoSearchTextFieldObjSt.enableIMEPersonalizedLearning(st));
  }
  public boolean enabled() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoSearchTextFieldEnabled not supported on web");
    return intToBool(CupertinoSearchTextFieldObjSt.enabled(st));
  }
  public double cursorWidth() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoSearchTextFieldCursorWidth not supported on web");
    return CupertinoSearchTextFieldObjSt.cursorWidth(st);
  }
  public double cursorHeight() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoSearchTextFieldCursorHeight not supported on web");
    return CupertinoSearchTextFieldObjSt.cursorHeight(st);
  }
  public Radius cursorRadius() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("cupertinoSearchTextFieldCursorRadius", getId());
      return new Radius(__nid);
    }
    return new Radius(CupertinoSearchTextFieldObjSt.cursorRadius(st));
  }
  public boolean cursorOpacityAnimates() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoSearchTextFieldCursorOpacityAnimates not supported on web");
    return intToBool(CupertinoSearchTextFieldObjSt.cursorOpacityAnimates(st));
  }
  public Color cursorColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("cupertinoSearchTextFieldCursorColor", getId());
      return new Color(__nid);
    }
    return new Color(CupertinoSearchTextFieldObjSt.cursorColor(st));
  }
  @Override
  public CupertinoSearchTextField build() {
    return this;
  }
}
