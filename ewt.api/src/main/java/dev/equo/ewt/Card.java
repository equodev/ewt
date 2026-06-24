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
    return new Color(CardObjSt.color(st));
  }
  public Color shadowColor() {
    return new Color(CardObjSt.shadowColor(st));
  }
  public Color surfaceTintColor() {
    return new Color(CardObjSt.surfaceTintColor(st));
  }
  public double elevation() {
    return CardObjSt.elevation(st);
  }
  public ShapeBorder shape() {
    return new ShapeBorder(CardObjSt.shape(st)) {};
  }
  public boolean borderOnForeground() {
    return intToBool(CardObjSt.borderOnForeground(st));
  }
  public Clip clipBehavior() {
    return Clip.values()[CardObjSt.clipBehavior(st)];
  }
  public EdgeInsetsGeometry margin() {
    return new EdgeInsetsGeometry(CardObjSt.margin(st)) {};
  }
  public boolean semanticContainer() {
    return intToBool(CardObjSt.semanticContainer(st));
  }
  public Widget child() {
    return new Widget(CardObjSt.child(st)) {};
  }
  @Override
  public Card build() {
    return this;
  }
}
