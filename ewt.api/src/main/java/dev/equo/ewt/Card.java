package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.CardObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class Card extends StatelessWidget implements CardI {
  private MemorySegment st;
  protected Card() {}
  Card(MemorySegment st) {
    this.id = CardObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget Card");
    System.out.println("New Card id:"+id);
  }
  Card(int id) { this.id = id; }
  @Builder.Factory
  static Card cardCard(Optional<ColorI> color, Optional<ColorI> shadowColor, Optional<ColorI> surfaceTintColor, OptionalDouble elevation, Optional<ShapeBorderI> shape, Optional<Boolean> borderOnForeground, Optional<EdgeInsetsGeometryI> margin, Optional<Clip> clipBehavior, Optional<WidgetI> child, Optional<Boolean> semanticContainer) {
    var st = factories.cardCard(color.map(ColorI::build),
      shadowColor.map(ColorI::build),
      surfaceTintColor.map(ColorI::build),
      elevation,
      shape.map(ShapeBorderI::build),
      borderOnForeground,
      margin.map(EdgeInsetsGeometryI::build),
      clipBehavior,
      child.map(WidgetI::build),
      semanticContainer);
    if (st == null) throw new RuntimeException("Failed to created widget Card");
    return new Card(st);
  }
  public static CardCardBuilder card() {
    return CardCardBuilder.cardCard();
  }
  @Builder.Factory
  static Card cardFilled(Optional<ColorI> color, Optional<ColorI> shadowColor, Optional<ColorI> surfaceTintColor, OptionalDouble elevation, Optional<ShapeBorderI> shape, Optional<Boolean> borderOnForeground, Optional<EdgeInsetsGeometryI> margin, Optional<Clip> clipBehavior, Optional<WidgetI> child, Optional<Boolean> semanticContainer) {
    var st = factories.cardFilled(color.map(ColorI::build),
      shadowColor.map(ColorI::build),
      surfaceTintColor.map(ColorI::build),
      elevation,
      shape.map(ShapeBorderI::build),
      borderOnForeground,
      margin.map(EdgeInsetsGeometryI::build),
      clipBehavior,
      child.map(WidgetI::build),
      semanticContainer);
    if (st == null) throw new RuntimeException("Failed to created widget Card");
    return new Card(st);
  }
  public static CardFilledBuilder filled() {
    return CardFilledBuilder.cardFilled();
  }
  @Builder.Factory
  static Card cardOutlined(Optional<ColorI> color, Optional<ColorI> shadowColor, Optional<ColorI> surfaceTintColor, OptionalDouble elevation, Optional<ShapeBorderI> shape, Optional<Boolean> borderOnForeground, Optional<EdgeInsetsGeometryI> margin, Optional<Clip> clipBehavior, Optional<WidgetI> child, Optional<Boolean> semanticContainer) {
    var st = factories.cardOutlined(color.map(ColorI::build),
      shadowColor.map(ColorI::build),
      surfaceTintColor.map(ColorI::build),
      elevation,
      shape.map(ShapeBorderI::build),
      borderOnForeground,
      margin.map(EdgeInsetsGeometryI::build),
      clipBehavior,
      child.map(WidgetI::build),
      semanticContainer);
    if (st == null) throw new RuntimeException("Failed to created widget Card");
    return new Card(st);
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
    return new Color(CardObjSt.color(st));
  }
  public Color shadowColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("cardShadowColor", getId());
      return new Color(__nid);
    }
    return new Color(CardObjSt.shadowColor(st));
  }
  public Color surfaceTintColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("cardSurfaceTintColor", getId());
      return new Color(__nid);
    }
    return new Color(CardObjSt.surfaceTintColor(st));
  }
  public double elevation() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cardElevation not supported on web");
    return CardObjSt.elevation(st);
  }
  public ShapeBorder shape() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cardShape not supported on web");
    return new ShapeBorder(CardObjSt.shape(st)) {};
  }
  public boolean borderOnForeground() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cardBorderOnForeground not supported on web");
    return intToBool(CardObjSt.borderOnForeground(st));
  }
  public Clip clipBehavior() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cardClipBehavior not supported on web");
    return Clip.values()[CardObjSt.clipBehavior(st)];
  }
  public EdgeInsetsGeometry margin() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cardMargin not supported on web");
    return new EdgeInsetsGeometry(CardObjSt.margin(st)) {};
  }
  public boolean semanticContainer() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cardSemanticContainer not supported on web");
    return intToBool(CardObjSt.semanticContainer(st));
  }
  public Widget child() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cardChild not supported on web");
    return new Widget(CardObjSt.child(st)) {};
  }
  @Override
  public Card build() {
    return this;
  }
}
