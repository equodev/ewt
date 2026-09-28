package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class TextStyle extends NativeObj.Base implements TextStyleI {
  protected TextStyle() {}
  TextStyle(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget TextStyle");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static TextStyle textStyleTextStyle(Optional<Boolean> inherit, Optional<ColorI> color, Optional<ColorI> backgroundColor, OptionalDouble fontSize, Optional<FontWeightI> fontWeight, Optional<FontStyle> fontStyle, OptionalDouble letterSpacing, OptionalDouble wordSpacing, Optional<TextBaseline> textBaseline, OptionalDouble height, Optional<TextLeadingDistribution> leadingDistribution, Optional<List<ShadowI>> shadows, Optional<TextDecorationI> decoration, Optional<ColorI> decorationColor, Optional<TextDecorationStyle> decorationStyle, OptionalDouble decorationThickness, Optional<String> debugLabel, Optional<String> fontFamily, Optional<List<String>> fontFamilyFallback, Optional<String> _package, Optional<TextOverflow> overflow) {
    int id = factories.textStyleTextStyle(inherit,
      color.map(ColorI::build),
      backgroundColor.map(ColorI::build),
      fontSize,
      fontWeight.map(FontWeightI::build),
      fontStyle,
      letterSpacing,
      wordSpacing,
      textBaseline,
      height,
      leadingDistribution,
      shadows.map(i -> i.stream().map(ShadowI::build).collect(java.util.stream.Collectors.toList())),
      decoration.map(TextDecorationI::build),
      decorationColor.map(ColorI::build),
      decorationStyle,
      decorationThickness,
      debugLabel,
      fontFamily,
      fontFamilyFallback,
      _package,
      overflow);
    if (id <= 0) throw new RuntimeException("Failed to created widget TextStyle");
    return new TextStyle(id);
  }
  public static TextStyleTextStyleBuilder textStyle() {
    return TextStyleTextStyleBuilder.textStyleTextStyle();
  }
  public static TextStyle lerp(TextStyleI a, TextStyleI b, double t) {
    int id = factories.textStyleLerp(a.build(),
      b.build(),
      t);
    if (id <= 0) throw new RuntimeException("Failed to created widget TextStyle");
    return new TextStyle(id);
  }
  public boolean inherit() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("textStyleInherit not supported on web");
    return factories.TextStyle_readBack_inherit(nativeStruct);
  }
  public Color color() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("textStyleColor", getId());
      return new Color(__nid);
    }
    return factories.TextStyle_readBack_color(nativeStruct);
  }
  public Color backgroundColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("textStyleBackgroundColor", getId());
      return new Color(__nid);
    }
    return factories.TextStyle_readBack_backgroundColor(nativeStruct);
  }
  public String fontFamily() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("textStyleFontFamily not supported on web");
    return factories.TextStyle_readBack_fontFamily(nativeStruct);
  }
  public double fontSize() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("textStyleFontSize not supported on web");
    return factories.TextStyle_readBack_fontSize(nativeStruct);
  }
  public FontWeight fontWeight() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("textStyleFontWeight", getId());
      return new FontWeight(__nid);
    }
    return factories.TextStyle_readBack_fontWeight(nativeStruct);
  }
  public FontStyle fontStyle() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("textStyleFontStyle not supported on web");
    return factories.TextStyle_readBack_fontStyle(nativeStruct);
  }
  public double letterSpacing() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("textStyleLetterSpacing not supported on web");
    return factories.TextStyle_readBack_letterSpacing(nativeStruct);
  }
  public double wordSpacing() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("textStyleWordSpacing not supported on web");
    return factories.TextStyle_readBack_wordSpacing(nativeStruct);
  }
  public TextBaseline textBaseline() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("textStyleTextBaseline not supported on web");
    return factories.TextStyle_readBack_textBaseline(nativeStruct);
  }
  public double height() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("textStyleHeight not supported on web");
    return factories.TextStyle_readBack_height(nativeStruct);
  }
  public TextLeadingDistribution leadingDistribution() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("textStyleLeadingDistribution not supported on web");
    return factories.TextStyle_readBack_leadingDistribution(nativeStruct);
  }
  public TextDecoration decoration() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("textStyleDecoration", getId());
      return new TextDecoration(__nid);
    }
    return factories.TextStyle_readBack_decoration(nativeStruct);
  }
  public Color decorationColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("textStyleDecorationColor", getId());
      return new Color(__nid);
    }
    return factories.TextStyle_readBack_decorationColor(nativeStruct);
  }
  public TextDecorationStyle decorationStyle() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("textStyleDecorationStyle not supported on web");
    return factories.TextStyle_readBack_decorationStyle(nativeStruct);
  }
  public double decorationThickness() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("textStyleDecorationThickness not supported on web");
    return factories.TextStyle_readBack_decorationThickness(nativeStruct);
  }
  public String debugLabel() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("textStyleDebugLabel not supported on web");
    return factories.TextStyle_readBack_debugLabel(nativeStruct);
  }
  public TextOverflow overflow() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("textStyleOverflow not supported on web");
    return factories.TextStyle_readBack_overflow(nativeStruct);
  }
  @Override
  public TextStyle build() {
    return this;
  }
}
