package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
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
    if (id <= 0) throw new RuntimeException("Failed to created widget BoxDecoration");
    System.out.println("New BoxDecoration id:"+id);
  }
  @Builder.Factory
  static BoxDecoration boxDecorationBoxDecoration(Optional<ColorI> color, Optional<BoxBorderI> border, Optional<BorderRadiusGeometryI> borderRadius, Optional<List<BoxShadowI>> boxShadow, Optional<BlendMode> backgroundBlendMode, Optional<BoxShape> shape) {
    var st = factories.boxDecorationBoxDecoration(color.map(ColorI::build),
      border.map(BoxBorderI::build),
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
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("boxDecorationColor", getId());
      return new Color(__nid);
    }
    return new Color(BoxDecorationObjSt.color(st));
  }
  public BoxBorder border() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("boxDecorationBorder not supported on web");
    return new BoxBorder(BoxDecorationObjSt.border(st)) {};
  }
  public BorderRadiusGeometry borderRadius() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("boxDecorationBorderRadius not supported on web");
    return new BorderRadiusGeometry(BoxDecorationObjSt.borderRadius(st)) {};
  }
  public BlendMode backgroundBlendMode() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("boxDecorationBackgroundBlendMode not supported on web");
    return BlendMode.values()[BoxDecorationObjSt.backgroundBlendMode(st)];
  }
  public BoxShape shape() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("boxDecorationShape not supported on web");
    return BoxShape.values()[BoxDecorationObjSt.shape(st)];
  }
  @Override
  public BoxDecoration build() {
    return this;
  }
}
