package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.CardThemeObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class CardTheme extends InheritedWidget implements CardThemeI {
  private MemorySegment st;
  protected CardTheme() {}
  CardTheme(MemorySegment st) {
    this.id = CardThemeObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget CardTheme");
    System.out.println("New CardTheme id:"+id);
  }
  CardTheme(int id) { this.id = id; }
  @Builder.Factory
  static CardTheme cardThemeCardTheme(Optional<Clip> clipBehavior, Optional<ColorI> color, Optional<ColorI> surfaceTintColor, Optional<ColorI> shadowColor, OptionalDouble elevation, Optional<EdgeInsetsGeometryI> margin, Optional<ShapeBorderI> shape, Optional<CardThemeDataI> data, Optional<WidgetI> child) {
    var st = factories.cardThemeCardTheme(clipBehavior,
      color.map(ColorI::build),
      surfaceTintColor.map(ColorI::build),
      shadowColor.map(ColorI::build),
      elevation,
      margin.map(EdgeInsetsGeometryI::build),
      shape.map(ShapeBorderI::build),
      data.map(CardThemeDataI::build),
      child.map(WidgetI::build));
    if (st == null) throw new RuntimeException("Failed to created widget CardTheme");
    return new CardTheme(st);
  }
  public static CardThemeCardThemeBuilder cardTheme() {
    return CardThemeCardThemeBuilder.cardThemeCardTheme();
  }
  public static CardThemeData of(BuildContextI context) {
    var st = factories.cardThemeOf(context.build());
    if (st == null) throw new RuntimeException("Failed to created widget CardThemeData");
    return new CardThemeData(st);
  }
  public static CardTheme lerp(CardThemeI a, CardThemeI b, double t) {
    var st = factories.cardThemeLerp(a.build(),
      b.build(),
      t);
    if (st == null) throw new RuntimeException("Failed to created widget CardTheme");
    return new CardTheme(st);
  }
  public Clip clipBehavior() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cardThemeClipBehavior not supported on web");
    return Clip.values()[CardThemeObjSt.clipBehavior(st)];
  }
  public Color color() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("cardThemeColor", getId());
      return new Color(__nid);
    }
    return new Color(CardThemeObjSt.color(st));
  }
  public Color surfaceTintColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("cardThemeSurfaceTintColor", getId());
      return new Color(__nid);
    }
    return new Color(CardThemeObjSt.surfaceTintColor(st));
  }
  public Color shadowColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("cardThemeShadowColor", getId());
      return new Color(__nid);
    }
    return new Color(CardThemeObjSt.shadowColor(st));
  }
  public double elevation() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cardThemeElevation not supported on web");
    return CardThemeObjSt.elevation(st);
  }
  public EdgeInsetsGeometry margin() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cardThemeMargin not supported on web");
    return new EdgeInsetsGeometry(CardThemeObjSt.margin(st)) {};
  }
  public ShapeBorder shape() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cardThemeShape not supported on web");
    return new ShapeBorder(CardThemeObjSt.shape(st)) {};
  }
  public CardThemeData data() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("cardThemeData", getId());
      java.lang.foreign.MemorySegment __st = dev.equo.ewt.ffm.CardThemeDataObjSt.allocate(__s.arena);
      dev.equo.ewt.ffm.CardThemeDataObjSt.id(__st, __nid);
      return new CardThemeData(__st);
    }
    return new CardThemeData(CardThemeObjSt.data(st));
  }
  @Override
  public CardTheme build() {
    return this;
  }
}
