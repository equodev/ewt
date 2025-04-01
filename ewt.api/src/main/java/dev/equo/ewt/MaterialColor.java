package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.MaterialColorObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class MaterialColor extends ColorSwatch<Integer> implements MaterialColorI {
  @Override
  public MaterialColor build() {
    return this;
  }
  private MemorySegment st;
  protected MaterialColor() {}
  MaterialColor(MemorySegment st) {
    this.id = MaterialColorObjSt.id(st);
    this.st = st;
    System.out.println("New MaterialColor id:"+id);
  }
  @Builder.Factory
  static MaterialColor materialColorMaterialColor(@Builder.Parameter int primary, @Builder.Parameter Map<Integer, Color> swatch) {
    var st = factories.materialColorMaterialColor(primary,
      swatch);
    if (st == null) throw new RuntimeException("Failed to created widget MaterialColor");
    return new MaterialColor(st);
  }
  public static MaterialColorMaterialColorBuilder materialColor(int primary, Map<Integer, Color> swatch) {
    return MaterialColorMaterialColorBuilder.materialColorMaterialColor(primary, swatch);
  }
  public Color shade50() {
    return new Color(MaterialColorObjSt.shade50(st)) {};
  }
  public Color shade100() {
    return new Color(MaterialColorObjSt.shade100(st)) {};
  }
  public Color shade200() {
    return new Color(MaterialColorObjSt.shade200(st)) {};
  }
  public Color shade300() {
    return new Color(MaterialColorObjSt.shade300(st)) {};
  }
  public Color shade400() {
    return new Color(MaterialColorObjSt.shade400(st)) {};
  }
  public Color shade500() {
    return new Color(MaterialColorObjSt.shade500(st)) {};
  }
  public Color shade600() {
    return new Color(MaterialColorObjSt.shade600(st)) {};
  }
  public Color shade700() {
    return new Color(MaterialColorObjSt.shade700(st)) {};
  }
  public Color shade800() {
    return new Color(MaterialColorObjSt.shade800(st)) {};
  }
  public Color shade900() {
    return new Color(MaterialColorObjSt.shade900(st)) {};
  }
}
