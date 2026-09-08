package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.CardThemeDataObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class CardThemeData extends NativeObj.Base implements CardThemeDataI {
  private MemorySegment st;
  protected CardThemeData() {}
  CardThemeData(MemorySegment st) {
    this.id = CardThemeDataObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget CardThemeData");
    System.out.println("New CardThemeData id:"+id);
  }
  CardThemeData(int id) { this.id = id; }
  @Builder.Factory
  static CardThemeData cardThemeDataCardThemeData(Optional<Clip> clipBehavior, Optional<ColorI> color, Optional<ColorI> shadowColor, Optional<ColorI> surfaceTintColor, OptionalDouble elevation, Optional<EdgeInsetsGeometryI> margin, Optional<ShapeBorderI> shape) {
    var st = factories.cardThemeDataCardThemeData(clipBehavior,
      color.map(ColorI::build),
      shadowColor.map(ColorI::build),
      surfaceTintColor.map(ColorI::build),
      elevation,
      margin.map(EdgeInsetsGeometryI::build),
      shape.map(ShapeBorderI::build));
    if (st == null) throw new RuntimeException("Failed to created widget CardThemeData");
    return new CardThemeData(st);
  }
  public static CardThemeDataCardThemeDataBuilder cardThemeData() {
    return CardThemeDataCardThemeDataBuilder.cardThemeDataCardThemeData();
  }
  public static CardThemeData lerp(CardThemeDataI a, CardThemeDataI b, double t) {
    var st = factories.cardThemeDataLerp(a.build(),
      b.build(),
      t);
    if (st == null) throw new RuntimeException("Failed to created widget CardThemeData");
    return new CardThemeData(st);
  }
  public Clip clipBehavior() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cardThemeDataClipBehavior not supported on web");
    return Clip.values()[CardThemeDataObjSt.clipBehavior(st)];
  }
  public Color color() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("cardThemeDataColor", getId());
      return new Color(__nid);
    }
    return new Color(CardThemeDataObjSt.color(st));
  }
  public Color shadowColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("cardThemeDataShadowColor", getId());
      return new Color(__nid);
    }
    return new Color(CardThemeDataObjSt.shadowColor(st));
  }
  public Color surfaceTintColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("cardThemeDataSurfaceTintColor", getId());
      return new Color(__nid);
    }
    return new Color(CardThemeDataObjSt.surfaceTintColor(st));
  }
  public double elevation() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cardThemeDataElevation not supported on web");
    return CardThemeDataObjSt.elevation(st);
  }
  public EdgeInsetsGeometry margin() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cardThemeDataMargin not supported on web");
    return new EdgeInsetsGeometry(CardThemeDataObjSt.margin(st)) {};
  }
  public ShapeBorder shape() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cardThemeDataShape not supported on web");
    return new ShapeBorder(CardThemeDataObjSt.shape(st)) {};
  }
  @Override
  public CardThemeData build() {
    return this;
  }
}
