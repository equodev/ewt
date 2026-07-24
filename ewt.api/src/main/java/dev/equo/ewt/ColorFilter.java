package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class ColorFilter extends NativeObj.Base implements ColorFilterI {
  protected ColorFilter() {}
  ColorFilter(int id) {
    this.id = id;
  }
  public static ColorFilter byId(int id) { return new ColorFilter(id); }
  @Builder.Factory
  static ColorFilter colorFilterMode(@Builder.Parameter ColorI color, @Builder.Parameter BlendMode blendMode) {
    int id = factories.colorFilterMode(color.build(),
      blendMode);
    if (id <= 0) throw new RuntimeException("Failed to created widget ColorFilter");
    System.out.println("New ColorFilter id:"+id);
    return new ColorFilter(id);
  }
  public static ColorFilterModeBuilder mode(ColorI color, BlendMode blendMode) {
    return ColorFilterModeBuilder.colorFilterMode(color, blendMode);
  }
  @Builder.Factory
  static ColorFilter colorFilterLinearToSrgbGamma() {
    int id = factories.colorFilterLinearToSrgbGamma();
    if (id <= 0) throw new RuntimeException("Failed to created widget ColorFilter");
    System.out.println("New ColorFilter id:"+id);
    return new ColorFilter(id);
  }
  public static ColorFilterLinearToSrgbGammaBuilder linearToSrgbGamma() {
    return ColorFilterLinearToSrgbGammaBuilder.colorFilterLinearToSrgbGamma();
  }
  @Builder.Factory
  static ColorFilter colorFilterSrgbToLinearGamma() {
    int id = factories.colorFilterSrgbToLinearGamma();
    if (id <= 0) throw new RuntimeException("Failed to created widget ColorFilter");
    System.out.println("New ColorFilter id:"+id);
    return new ColorFilter(id);
  }
  public static ColorFilterSrgbToLinearGammaBuilder srgbToLinearGamma() {
    return ColorFilterSrgbToLinearGammaBuilder.colorFilterSrgbToLinearGamma();
  }
  private static int _kTypeMode() {
    return 1;
  }
  private static int _kTypeMatrix() {
    return 2;
  }
  private static int _kTypeLinearToSrgbGamma() {
    return 3;
  }
  private static int _kTypeSrgbToLinearGamma() {
    return 4;
  }
  @Override
  public ColorFilter build() {
    return this;
  }
}
