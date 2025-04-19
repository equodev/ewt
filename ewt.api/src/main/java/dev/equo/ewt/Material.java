package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.MaterialObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class Material extends StatefulWidget implements MaterialI {
  private MemorySegment st;
  protected Material() {}
  Material(MemorySegment st) {
    this.id = MaterialObjSt.id(st);
    this.st = st;
    System.out.println("New Material id:"+id);
  }
  @Builder.Factory
  static Material materialMaterial(Optional<MaterialType> type, OptionalDouble elevation, Optional<ColorI> color, Optional<ColorI> shadowColor, Optional<ColorI> surfaceTintColor, Optional<TextStyleI> textStyle, Optional<BorderRadiusGeometryI> borderRadius, Optional<ShapeBorderI> shape, Optional<Boolean> borderOnForeground, Optional<Clip> clipBehavior, Optional<DurationI> animationDuration, Optional<WidgetI> child) {
    var st = factories.materialMaterial(type,
      elevation,
      color.map(ColorI::build),
      shadowColor.map(ColorI::build),
      surfaceTintColor.map(ColorI::build),
      textStyle.map(TextStyleI::build),
      borderRadius.map(BorderRadiusGeometryI::build),
      shape.map(ShapeBorderI::build),
      borderOnForeground,
      clipBehavior,
      animationDuration.map(DurationI::build),
      child.map(WidgetI::build));
    if (st == null) throw new RuntimeException("Failed to created widget Material");
    return new Material(st);
  }
  public static MaterialMaterialBuilder material() {
    return MaterialMaterialBuilder.materialMaterial();
  }
  public Widget child() {
    return new Widget(MaterialObjSt.child(st)) {};
  }
  public MaterialType type() {
    return MaterialType.values()[MaterialObjSt.type(st)];
  }
  public double elevation() {
    return MaterialObjSt.elevation(st);
  }
  public Color color() {
    return new Color(MaterialObjSt.color(st));
  }
  public Color shadowColor() {
    return new Color(MaterialObjSt.shadowColor(st));
  }
  public Color surfaceTintColor() {
    return new Color(MaterialObjSt.surfaceTintColor(st));
  }
  public TextStyle textStyle() {
    return new TextStyle(MaterialObjSt.textStyle(st));
  }
  public ShapeBorder shape() {
    return new ShapeBorder(MaterialObjSt.shape(st)) {};
  }
  public boolean borderOnForeground() {
    return intToBool(MaterialObjSt.borderOnForeground(st));
  }
  public Clip clipBehavior() {
    return Clip.values()[MaterialObjSt.clipBehavior(st)];
  }
  public Duration animationDuration() {
    return new Duration(MaterialObjSt.animationDuration(st));
  }
  public BorderRadiusGeometry borderRadius() {
    return new BorderRadiusGeometry(MaterialObjSt.borderRadius(st)) {};
  }
  public static double defaultSplashRadius() {
    return 35.0;
  }
  @Override
  public Material build() {
    return this;
  }
}
