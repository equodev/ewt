package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class MaterialColor extends ColorSwatch<Integer> implements MaterialColorI {
  protected MaterialColor() {}
  MaterialColor(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget MaterialColor");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static MaterialColor materialColorMaterialColor(@Builder.Parameter int primary, @Builder.Parameter Map<Integer, Color> swatch) {
    int id = factories.materialColorMaterialColor(primary,
      swatch);
    if (id <= 0) throw new RuntimeException("Failed to created widget MaterialColor");
    return new MaterialColor(id);
  }
  public static MaterialColorMaterialColorBuilder materialColor(int primary, Map<Integer, Color> swatch) {
    return MaterialColorMaterialColorBuilder.materialColorMaterialColor(primary, swatch);
  }
  public Color shade50() {
    return factories.MaterialColor_readBack_shade50(nativeStruct);
  }
  public Color shade100() {
    return factories.MaterialColor_readBack_shade100(nativeStruct);
  }
  public Color shade200() {
    return factories.MaterialColor_readBack_shade200(nativeStruct);
  }
  public Color shade300() {
    return factories.MaterialColor_readBack_shade300(nativeStruct);
  }
  public Color shade400() {
    return factories.MaterialColor_readBack_shade400(nativeStruct);
  }
  public Color shade500() {
    return factories.MaterialColor_readBack_shade500(nativeStruct);
  }
  public Color shade600() {
    return factories.MaterialColor_readBack_shade600(nativeStruct);
  }
  public Color shade700() {
    return factories.MaterialColor_readBack_shade700(nativeStruct);
  }
  public Color shade800() {
    return factories.MaterialColor_readBack_shade800(nativeStruct);
  }
  public Color shade900() {
    return factories.MaterialColor_readBack_shade900(nativeStruct);
  }
  @Override
  public MaterialColor build() {
    return this;
  }
}
