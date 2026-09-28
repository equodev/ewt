package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class Card extends StatelessWidget implements CardI {
  protected Card() {}
  Card(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget Card");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static Card cardCard(Optional<ColorI> color, Optional<ColorI> shadowColor, Optional<ColorI> surfaceTintColor, OptionalDouble elevation, Optional<ShapeBorderI> shape, Optional<Boolean> borderOnForeground, Optional<EdgeInsetsGeometryI> margin, Optional<Clip> clipBehavior, Optional<WidgetI> child, Optional<Boolean> semanticContainer) {
    int id = factories.cardCard(color.map(ColorI::build),
      shadowColor.map(ColorI::build),
      surfaceTintColor.map(ColorI::build),
      elevation,
      shape.map(ShapeBorderI::build),
      borderOnForeground,
      margin.map(EdgeInsetsGeometryI::build),
      clipBehavior,
      child.map(WidgetI::build),
      semanticContainer);
    if (id <= 0) throw new RuntimeException("Failed to created widget Card");
    return new Card(id);
  }
  public static CardCardBuilder card() {
    return CardCardBuilder.cardCard();
  }
  @Builder.Factory
  static Card cardFilled(Optional<ColorI> color, Optional<ColorI> shadowColor, Optional<ColorI> surfaceTintColor, OptionalDouble elevation, Optional<ShapeBorderI> shape, Optional<Boolean> borderOnForeground, Optional<EdgeInsetsGeometryI> margin, Optional<Clip> clipBehavior, Optional<WidgetI> child, Optional<Boolean> semanticContainer) {
    int id = factories.cardFilled(color.map(ColorI::build),
      shadowColor.map(ColorI::build),
      surfaceTintColor.map(ColorI::build),
      elevation,
      shape.map(ShapeBorderI::build),
      borderOnForeground,
      margin.map(EdgeInsetsGeometryI::build),
      clipBehavior,
      child.map(WidgetI::build),
      semanticContainer);
    if (id <= 0) throw new RuntimeException("Failed to created widget Card");
    return new Card(id);
  }
  public static CardFilledBuilder filled() {
    return CardFilledBuilder.cardFilled();
  }
  @Builder.Factory
  static Card cardOutlined(Optional<ColorI> color, Optional<ColorI> shadowColor, Optional<ColorI> surfaceTintColor, OptionalDouble elevation, Optional<ShapeBorderI> shape, Optional<Boolean> borderOnForeground, Optional<EdgeInsetsGeometryI> margin, Optional<Clip> clipBehavior, Optional<WidgetI> child, Optional<Boolean> semanticContainer) {
    int id = factories.cardOutlined(color.map(ColorI::build),
      shadowColor.map(ColorI::build),
      surfaceTintColor.map(ColorI::build),
      elevation,
      shape.map(ShapeBorderI::build),
      borderOnForeground,
      margin.map(EdgeInsetsGeometryI::build),
      clipBehavior,
      child.map(WidgetI::build),
      semanticContainer);
    if (id <= 0) throw new RuntimeException("Failed to created widget Card");
    return new Card(id);
  }
  public static CardOutlinedBuilder outlined() {
    return CardOutlinedBuilder.cardOutlined();
  }
  public Color color() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("cardColor", getId());
      return new Color(__nid);
    }
    return factories.Card_readBack_color(nativeStruct);
  }
  public Color shadowColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("cardShadowColor", getId());
      return new Color(__nid);
    }
    return factories.Card_readBack_shadowColor(nativeStruct);
  }
  public Color surfaceTintColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("cardSurfaceTintColor", getId());
      return new Color(__nid);
    }
    return factories.Card_readBack_surfaceTintColor(nativeStruct);
  }
  public double elevation() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cardElevation not supported on web");
    return factories.Card_readBack_elevation(nativeStruct);
  }
  public ShapeBorder shape() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cardShape not supported on web");
    return factories.Card_readBack_shape(nativeStruct);
  }
  public boolean borderOnForeground() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cardBorderOnForeground not supported on web");
    return factories.Card_readBack_borderOnForeground(nativeStruct);
  }
  public Clip clipBehavior() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cardClipBehavior not supported on web");
    return factories.Card_readBack_clipBehavior(nativeStruct);
  }
  public EdgeInsetsGeometry margin() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cardMargin not supported on web");
    return factories.Card_readBack_margin(nativeStruct);
  }
  public boolean semanticContainer() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cardSemanticContainer not supported on web");
    return factories.Card_readBack_semanticContainer(nativeStruct);
  }
  public Widget child() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cardChild not supported on web");
    return factories.Card_readBack_child(nativeStruct);
  }
  @Override
  public Card build() {
    return this;
  }
}
