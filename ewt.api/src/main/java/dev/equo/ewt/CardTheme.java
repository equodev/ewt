package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class CardTheme extends InheritedWidget implements CardThemeI {
  protected CardTheme() {}
  CardTheme(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget CardTheme");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static CardTheme cardThemeCardTheme(Optional<Clip> clipBehavior, Optional<ColorI> color, Optional<ColorI> surfaceTintColor, Optional<ColorI> shadowColor, OptionalDouble elevation, Optional<EdgeInsetsGeometryI> margin, Optional<ShapeBorderI> shape, Optional<CardThemeDataI> data, Optional<WidgetI> child) {
    int id = factories.cardThemeCardTheme(clipBehavior,
      color.map(ColorI::build),
      surfaceTintColor.map(ColorI::build),
      shadowColor.map(ColorI::build),
      elevation,
      margin.map(EdgeInsetsGeometryI::build),
      shape.map(ShapeBorderI::build),
      data.map(CardThemeDataI::build),
      child.map(WidgetI::build));
    if (id <= 0) throw new RuntimeException("Failed to created widget CardTheme");
    return new CardTheme(id);
  }
  public static CardThemeCardThemeBuilder cardTheme() {
    return CardThemeCardThemeBuilder.cardThemeCardTheme();
  }
  public static CardThemeData of(BuildContextI context) {
    int id = factories.cardThemeOf(context.build());
    if (id <= 0) throw new RuntimeException("Failed to created widget CardThemeData");
    return new CardThemeData(id);
  }
  public static CardTheme lerp(CardThemeI a, CardThemeI b, double t) {
    int id = factories.cardThemeLerp(a.build(),
      b.build(),
      t);
    if (id <= 0) throw new RuntimeException("Failed to created widget CardTheme");
    return new CardTheme(id);
  }
  public Clip clipBehavior() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cardThemeClipBehavior not supported on web");
    return factories.CardTheme_readBack_clipBehavior(nativeStruct);
  }
  public Color color() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("cardThemeColor", getId());
      return new Color(__nid);
    }
    return factories.CardTheme_readBack_color(nativeStruct);
  }
  public Color surfaceTintColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("cardThemeSurfaceTintColor", getId());
      return new Color(__nid);
    }
    return factories.CardTheme_readBack_surfaceTintColor(nativeStruct);
  }
  public Color shadowColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("cardThemeShadowColor", getId());
      return new Color(__nid);
    }
    return factories.CardTheme_readBack_shadowColor(nativeStruct);
  }
  public double elevation() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cardThemeElevation not supported on web");
    return factories.CardTheme_readBack_elevation(nativeStruct);
  }
  public EdgeInsetsGeometry margin() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cardThemeMargin not supported on web");
    return factories.CardTheme_readBack_margin(nativeStruct);
  }
  public ShapeBorder shape() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cardThemeShape not supported on web");
    return factories.CardTheme_readBack_shape(nativeStruct);
  }
  public CardThemeData data() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("cardThemeData", getId());
      return new CardThemeData(__nid);
    }
    return factories.CardTheme_readBack_data(nativeStruct);
  }
  @Override
  public CardTheme build() {
    return this;
  }
}
