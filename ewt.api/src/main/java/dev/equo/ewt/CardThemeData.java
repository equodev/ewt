package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class CardThemeData extends NativeObj.Base implements CardThemeDataI {
  protected CardThemeData() {}
  CardThemeData(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget CardThemeData");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static CardThemeData cardThemeDataCardThemeData(Optional<Clip> clipBehavior, Optional<ColorI> color, Optional<ColorI> shadowColor, Optional<ColorI> surfaceTintColor, OptionalDouble elevation, Optional<EdgeInsetsGeometryI> margin, Optional<ShapeBorderI> shape) {
    int id = factories.cardThemeDataCardThemeData(clipBehavior,
      color.map(ColorI::build),
      shadowColor.map(ColorI::build),
      surfaceTintColor.map(ColorI::build),
      elevation,
      margin.map(EdgeInsetsGeometryI::build),
      shape.map(ShapeBorderI::build));
    if (id <= 0) throw new RuntimeException("Failed to created widget CardThemeData");
    return new CardThemeData(id);
  }
  public static CardThemeDataCardThemeDataBuilder cardThemeData() {
    return CardThemeDataCardThemeDataBuilder.cardThemeDataCardThemeData();
  }
  public static CardThemeData lerp(CardThemeDataI a, CardThemeDataI b, double t) {
    int id = factories.cardThemeDataLerp(a.build(),
      b.build(),
      t);
    if (id <= 0) throw new RuntimeException("Failed to created widget CardThemeData");
    return new CardThemeData(id);
  }
  public Clip clipBehavior() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cardThemeDataClipBehavior not supported on web");
    return factories.CardThemeData_readBack_clipBehavior(nativeStruct);
  }
  public Color color() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("cardThemeDataColor", getId());
      return new Color(__nid);
    }
    return factories.CardThemeData_readBack_color(nativeStruct);
  }
  public Color shadowColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("cardThemeDataShadowColor", getId());
      return new Color(__nid);
    }
    return factories.CardThemeData_readBack_shadowColor(nativeStruct);
  }
  public Color surfaceTintColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("cardThemeDataSurfaceTintColor", getId());
      return new Color(__nid);
    }
    return factories.CardThemeData_readBack_surfaceTintColor(nativeStruct);
  }
  public double elevation() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cardThemeDataElevation not supported on web");
    return factories.CardThemeData_readBack_elevation(nativeStruct);
  }
  public EdgeInsetsGeometry margin() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cardThemeDataMargin not supported on web");
    return factories.CardThemeData_readBack_margin(nativeStruct);
  }
  public ShapeBorder shape() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cardThemeDataShape not supported on web");
    return factories.CardThemeData_readBack_shape(nativeStruct);
  }
  @Override
  public CardThemeData build() {
    return this;
  }
}
