package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
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
    System.out.println("New TextStyle id:"+id);
  }
  @Builder.Factory
  static TextStyle textStyleTextStyle(Optional<Boolean> inherit, Optional<ColorI> color, Optional<ColorI> backgroundColor, OptionalDouble fontSize, Optional<FontStyle> fontStyle, OptionalDouble letterSpacing, OptionalDouble wordSpacing, Optional<TextBaseline> textBaseline, OptionalDouble height, Optional<TextLeadingDistribution> leadingDistribution, Optional<ColorI> decorationColor, Optional<TextDecorationStyle> decorationStyle, OptionalDouble decorationThickness, Optional<String> debugLabel, Optional<String> fontFamily, Optional<List<String>> fontFamilyFallback, Optional<String> _package, Optional<TextOverflow> overflow) {
    var st = factories.textStyleTextStyle(inherit,
      color.map(ColorI::build),
      backgroundColor.map(ColorI::build),
      fontSize,
      fontStyle,
      letterSpacing,
      wordSpacing,
      textBaseline,
      height,
      leadingDistribution,
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
    return intToBool(TextStyleObjSt.inherit(st));
  }
  public Color color() {
    return new Color(TextStyleObjSt.color(st)) {};
  }
  public Color backgroundColor() {
    return new Color(TextStyleObjSt.backgroundColor(st)) {};
  }
  public double fontSize() {
    return TextStyleObjSt.fontSize(st);
  }
  public FontStyle fontStyle() {
    return FontStyle.values()[TextStyleObjSt.fontStyle(st)];
  }
  public double letterSpacing() {
    return TextStyleObjSt.letterSpacing(st);
  }
  public double wordSpacing() {
    return TextStyleObjSt.wordSpacing(st);
  }
  public TextBaseline textBaseline() {
    return TextBaseline.values()[TextStyleObjSt.textBaseline(st)];
  }
  public double height() {
    return TextStyleObjSt.height(st);
  }
  public TextLeadingDistribution leadingDistribution() {
    return TextLeadingDistribution.values()[TextStyleObjSt.leadingDistribution(st)];
  }
  public Color decorationColor() {
    return new Color(TextStyleObjSt.decorationColor(st)) {};
  }
  public TextDecorationStyle decorationStyle() {
    return TextDecorationStyle.values()[TextStyleObjSt.decorationStyle(st)];
  }
  public double decorationThickness() {
    return TextStyleObjSt.decorationThickness(st);
  }
  public TextOverflow overflow() {
    return TextOverflow.values()[TextStyleObjSt.overflow(st)];
  }
  @Override
  public TextStyle build() {
    return this;
  }
}
