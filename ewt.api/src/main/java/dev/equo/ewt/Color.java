package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import org.immutables.builder.Builder;
public class Color extends NativeObj.Base {
  Color() {}
  Color(int id) {
    this.id = id;
  }
  @Builder.Factory
  static Color colorColor(@Builder.Parameter int value) {
    int id = factories.colorColor(value);
    if (id == -1) throw new RuntimeException("Failed to created widget Color");
    System.out.println("New Color id:"+id);
    return new Color(id);
  }
  public static ColorColorBuilder color(int value) {
    return ColorColorBuilder.colorColor(value);
  }
  @Builder.Factory
  static Color colorFrom(@Builder.Parameter double alpha, @Builder.Parameter double red, @Builder.Parameter double green, @Builder.Parameter double blue, Optional<ColorSpace> colorSpace) {
    int id = factories.colorFrom(alpha,
      red,
      green,
      blue,
      colorSpace);
    if (id == -1) throw new RuntimeException("Failed to created widget Color");
    System.out.println("New Color id:"+id);
    return new Color(id);
  }
  public static ColorFromBuilder from(double alpha, double red, double green, double blue) {
    return ColorFromBuilder.colorFrom(alpha, red, green, blue);
  }
  @Builder.Factory
  static Color colorFromARGB(@Builder.Parameter int a, @Builder.Parameter int r, @Builder.Parameter int g, @Builder.Parameter int b) {
    int id = factories.colorFromARGB(a,
      r,
      g,
      b);
    if (id == -1) throw new RuntimeException("Failed to created widget Color");
    System.out.println("New Color id:"+id);
    return new Color(id);
  }
  public static ColorFromARGBBuilder fromARGB(int a, int r, int g, int b) {
    return ColorFromARGBBuilder.colorFromARGB(a, r, g, b);
  }
  @Builder.Factory
  static Color colorFromRGBO(@Builder.Parameter int r, @Builder.Parameter int g, @Builder.Parameter int b, @Builder.Parameter double opacity) {
    int id = factories.colorFromRGBO(r,
      g,
      b,
      opacity);
    if (id == -1) throw new RuntimeException("Failed to created widget Color");
    System.out.println("New Color id:"+id);
    return new Color(id);
  }
  public static ColorFromRGBOBuilder fromRGBO(int r, int g, int b, double opacity) {
    return ColorFromRGBOBuilder.colorFromRGBO(r, g, b, opacity);
  }
  public static Color lerp(Color x, Color y, double t) {
    int id = factories.colorLerp(x,
      y,
      t);
    if (id == -1) throw new RuntimeException("Failed to created widget Color?");
    System.out.println("New Color? id:"+id);
    return new Color(id);
  }
  public static Color alphaBlend(Color foreground, Color background) {
    int id = factories.colorAlphaBlend(foreground,
      background);
    if (id == -1) throw new RuntimeException("Failed to created widget Color");
    System.out.println("New Color id:"+id);
    return new Color(id);
  }
}
