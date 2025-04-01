package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.MaterialAccentColorObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class MaterialAccentColor extends ColorSwatch<Integer> implements MaterialAccentColorI {
  @Override
  public MaterialAccentColor build() {
    return this;
  }
  private MemorySegment st;
  protected MaterialAccentColor() {}
  MaterialAccentColor(MemorySegment st) {
    this.id = MaterialAccentColorObjSt.id(st);
    this.st = st;
    System.out.println("New MaterialAccentColor id:"+id);
  }
  @Builder.Factory
  static MaterialAccentColor materialAccentColorMaterialAccentColor(@Builder.Parameter int primary, @Builder.Parameter Map<Integer, Color> swatch) {
    var st = factories.materialAccentColorMaterialAccentColor(primary,
      swatch);
    if (st == null) throw new RuntimeException("Failed to created widget MaterialAccentColor");
    return new MaterialAccentColor(st);
  }
  public static MaterialAccentColorMaterialAccentColorBuilder materialAccentColor(int primary, Map<Integer, Color> swatch) {
    return MaterialAccentColorMaterialAccentColorBuilder.materialAccentColorMaterialAccentColor(primary, swatch);
  }
  public Color shade100() {
    return new Color(MaterialAccentColorObjSt.shade100(st)) {};
  }
  public Color shade200() {
    return new Color(MaterialAccentColorObjSt.shade200(st)) {};
  }
  public Color shade400() {
    return new Color(MaterialAccentColorObjSt.shade400(st)) {};
  }
  public Color shade700() {
    return new Color(MaterialAccentColorObjSt.shade700(st)) {};
  }
}
