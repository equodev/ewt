package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.TextStyleObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class TextStyle extends NativeObj.Base implements TextStyleI {
  private MemorySegment st;
  protected TextStyle() {}
  TextStyle(MemorySegment st) {
    this.id = TextStyleObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget TextStyle");
    System.out.println("New TextStyle id:"+id);
  }
  TextStyle(int id) { this.id = id; }
  @Builder.Factory
  static TextStyle textStyleTextStyle(Optional<Boolean> inherit, Optional<ColorI> color, Optional<ColorI> backgroundColor, OptionalDouble fontSize, Optional<FontWeightI> fontWeight, Optional<FontStyle> fontStyle, OptionalDouble letterSpacing, OptionalDouble wordSpacing, Optional<TextBaseline> textBaseline, OptionalDouble height, Optional<TextLeadingDistribution> leadingDistribution, Optional<List<ShadowI>> shadows, Optional<TextDecorationI> decoration, Optional<ColorI> decorationColor, Optional<TextDecorationStyle> decorationStyle, OptionalDouble decorationThickness, Optional<String> debugLabel, Optional<String> fontFamily, Optional<List<String>> fontFamilyFallback, Optional<String> _package, Optional<TextOverflow> overflow) {
    var st = factories.textStyleTextStyle(inherit,
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
      shadows.map(i -> i.stream().map(ShadowI::build).toList()),
      decoration.map(TextDecorationI::build),
      decorationColor.map(ColorI::build),
      decorationStyle,
      decorationThickness,
      debugLabel,
      fontFamily,
      fontFamilyFallback,
      _package,
      overflow);
    if (st == null) throw new RuntimeException("Failed to created widget TextStyle");
    return new TextStyle(st);
  }
  public static TextStyleTextStyleBuilder textStyle() {
    return TextStyleTextStyleBuilder.textStyleTextStyle();
  }
  public static TextStyle lerp(TextStyleI a, TextStyleI b, double t) {
    var st = factories.textStyleLerp(a.build(),
      b.build(),
      t);
    if (st == null) throw new RuntimeException("Failed to created widget TextStyle");
    return new TextStyle(st);
  }
  public boolean inherit() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("textStyleInherit not supported on web");
    return intToBool(TextStyleObjSt.inherit(st));
  }
  public Color color() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("textStyleColor", getId());
      return new Color(__nid);
    }
    return new Color(TextStyleObjSt.color(st));
  }
  public Color backgroundColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("textStyleBackgroundColor", getId());
      return new Color(__nid);
    }
    return new Color(TextStyleObjSt.backgroundColor(st));
  }
  public String fontFamily() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("textStyleFontFamily not supported on web");
    return TextStyleObjSt.fontFamily(st).getString(0);
  }
  public double fontSize() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("textStyleFontSize not supported on web");
    return TextStyleObjSt.fontSize(st);
  }
  public FontWeight fontWeight() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("textStyleFontWeight", getId());
      return new FontWeight(__nid);
    }
    return new FontWeight(TextStyleObjSt.fontWeight(st));
  }
  public FontStyle fontStyle() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("textStyleFontStyle not supported on web");
    return FontStyle.values()[TextStyleObjSt.fontStyle(st)];
  }
  public double letterSpacing() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("textStyleLetterSpacing not supported on web");
    return TextStyleObjSt.letterSpacing(st);
  }
  public double wordSpacing() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("textStyleWordSpacing not supported on web");
    return TextStyleObjSt.wordSpacing(st);
  }
  public TextBaseline textBaseline() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("textStyleTextBaseline not supported on web");
    return TextBaseline.values()[TextStyleObjSt.textBaseline(st)];
  }
  public double height() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("textStyleHeight not supported on web");
    return TextStyleObjSt.height(st);
  }
  public TextLeadingDistribution leadingDistribution() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("textStyleLeadingDistribution not supported on web");
    return TextLeadingDistribution.values()[TextStyleObjSt.leadingDistribution(st)];
  }
  public TextDecoration decoration() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("textStyleDecoration", getId());
      return new TextDecoration(__nid);
    }
    return new TextDecoration(TextStyleObjSt.decoration(st));
  }
  public Color decorationColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("textStyleDecorationColor", getId());
      return new Color(__nid);
    }
    return new Color(TextStyleObjSt.decorationColor(st));
  }
  public TextDecorationStyle decorationStyle() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("textStyleDecorationStyle not supported on web");
    return TextDecorationStyle.values()[TextStyleObjSt.decorationStyle(st)];
  }
  public double decorationThickness() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("textStyleDecorationThickness not supported on web");
    return TextStyleObjSt.decorationThickness(st);
  }
  public String debugLabel() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("textStyleDebugLabel not supported on web");
    return TextStyleObjSt.debugLabel(st).getString(0);
  }
  public TextOverflow overflow() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("textStyleOverflow not supported on web");
    return TextOverflow.values()[TextStyleObjSt.overflow(st)];
  }
  @Override
  public TextStyle build() {
    return this;
  }
}
