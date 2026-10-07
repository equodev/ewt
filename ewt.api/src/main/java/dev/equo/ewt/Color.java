package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class Color extends NativeObj.Base implements ColorI {
  protected Color() {}
  Color(int id) {
    this.id = id;
  }
  public static Color byId(int id) { return new Color(id); }
  static { NativeObj.register("Color", Color::byId); }
  @Builder.Factory
  static Color colorColor(@Builder.Parameter int value) {
    var id = factories.colorColor(value);
    if (id <= 0) throw new RuntimeException("Failed to created widget Color");
    return new Color(id);
  }
  public static ColorColorBuilder color(int value) {
    return ColorColorBuilder.colorColor(value);
  }
  @Builder.Factory
  static Color colorFrom(@Builder.Parameter double alpha, @Builder.Parameter double red, @Builder.Parameter double green, @Builder.Parameter double blue, Optional<ColorSpace> colorSpace) {
    var id = factories.colorFrom(alpha,
      red,
      green,
      blue,
      colorSpace);
    if (id <= 0) throw new RuntimeException("Failed to created widget Color");
    return new Color(id);
  }
  public static ColorFromBuilder from(double alpha, double red, double green, double blue) {
    return ColorFromBuilder.colorFrom(alpha, red, green, blue);
  }
  @Builder.Factory
  static Color colorFromARGB(@Builder.Parameter int a, @Builder.Parameter int r, @Builder.Parameter int g, @Builder.Parameter int b) {
    var id = factories.colorFromARGB(a,
      r,
      g,
      b);
    if (id <= 0) throw new RuntimeException("Failed to created widget Color");
    return new Color(id);
  }
  public static ColorFromARGBBuilder fromARGB(int a, int r, int g, int b) {
    return ColorFromARGBBuilder.colorFromARGB(a, r, g, b);
  }
  @Builder.Factory
  static Color colorFromRGBO(@Builder.Parameter int r, @Builder.Parameter int g, @Builder.Parameter int b, @Builder.Parameter double opacity) {
    var id = factories.colorFromRGBO(r,
      g,
      b,
      opacity);
    if (id <= 0) throw new RuntimeException("Failed to created widget Color");
    return new Color(id);
  }
  public static ColorFromRGBOBuilder fromRGBO(int r, int g, int b, double opacity) {
    return ColorFromRGBOBuilder.colorFromRGBO(r, g, b, opacity);
  }
  public static Color lerp(ColorI x, ColorI y, double t) {
    var id = factories.colorLerp(x.build(),
      y.build(),
      t);
    if (id <= 0) throw new RuntimeException("Failed to created widget Color?");
    return new Color(id);
  }
  public static Color alphaBlend(ColorI foreground, ColorI background) {
    var id = factories.colorAlphaBlend(foreground.build(),
      background.build());
    if (id <= 0) throw new RuntimeException("Failed to created widget Color");
    return new Color(id);
  }
  public static int getAlphaFromOpacity(double opacity) {
    var id = factories.colorGetAlphaFromOpacity(opacity);
    if (id <= 0) throw new RuntimeException("Failed to created widget int");
    return id;
  }
  @Override
  public Color build() {
    return this;
  }
}
