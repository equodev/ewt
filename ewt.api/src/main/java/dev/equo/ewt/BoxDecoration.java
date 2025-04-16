package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.BoxDecorationObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class BoxDecoration extends Decoration implements BoxDecorationI {
  private MemorySegment st;
  protected BoxDecoration() {}
  BoxDecoration(MemorySegment st) {
    this.id = BoxDecorationObjSt.id(st);
    this.st = st;
    System.out.println("New BoxDecoration id:"+id);
  }
  @Builder.Factory
  static BoxDecoration boxDecorationBoxDecoration(Optional<ColorI> color, Optional<BorderRadiusGeometryI> borderRadius, Optional<List<BoxShadowI>> boxShadow, Optional<BlendMode> backgroundBlendMode, Optional<BoxShape> shape) {
    var st = factories.boxDecorationBoxDecoration(color.map(ColorI::build),
      borderRadius.map(BorderRadiusGeometryI::build),
      boxShadow.map(i -> i.stream().map(BoxShadowI::build).toList()),
      backgroundBlendMode,
      shape);
    if (st == null) throw new RuntimeException("Failed to created widget BoxDecoration");
    return new BoxDecoration(st);
  }
  public static BoxDecorationBoxDecorationBuilder boxDecoration() {
    return BoxDecorationBoxDecorationBuilder.boxDecorationBoxDecoration();
  }
  public static BoxDecoration lerp(BoxDecorationI a, BoxDecorationI b, double t) {
    var st = factories.boxDecorationLerp(a.build(),
      b.build(),
      t);
    if (st == null) throw new RuntimeException("Failed to created widget BoxDecoration");
    return new BoxDecoration(st);
  }
  public Color color() {
    return new Color(BoxDecorationObjSt.color(st));
  }
  public BorderRadiusGeometry borderRadius() {
    return new BorderRadiusGeometry(BoxDecorationObjSt.borderRadius(st)) {};
  }
  public BlendMode backgroundBlendMode() {
    return BlendMode.values()[BoxDecorationObjSt.backgroundBlendMode(st)];
  }
  public BoxShape shape() {
    return BoxShape.values()[BoxDecorationObjSt.shape(st)];
  }
  @Override
  public BoxDecoration build() {
    return this;
  }
}
