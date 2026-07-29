package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
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
    if (id <= 0) throw new RuntimeException("Failed to created widget Material");
    System.out.println("New Material id:"+id);
  }
  Material(int id) { this.id = id; }
  @Builder.Factory
  static Material materialMaterial(Optional<MaterialType> type, OptionalDouble elevation, Optional<ColorI> color, Optional<ColorI> shadowColor, Optional<ColorI> surfaceTintColor, Optional<TextStyleI> textStyle, Optional<BorderRadiusGeometryI> borderRadius, Optional<ShapeBorderI> shape, Optional<Boolean> borderOnForeground, Optional<Clip> clipBehavior, Optional<DurationI> animationDuration, Optional<WidgetI> child, Optional<Boolean> animateColor) {
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
      child.map(WidgetI::build),
      animateColor);
    if (st == null) throw new RuntimeException("Failed to created widget Material");
    return new Material(st);
  }
  public static MaterialMaterialBuilder material() {
    return MaterialMaterialBuilder.materialMaterial();
  }
  public Widget child() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("materialChild not supported on web");
    return new Widget(MaterialObjSt.child(st)) {};
  }
  public MaterialType type() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("materialType not supported on web");
    return MaterialType.values()[MaterialObjSt.type(st)];
  }
  public boolean animateColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("materialAnimateColor not supported on web");
    return intToBool(MaterialObjSt.animateColor(st));
  }
  public double elevation() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("materialElevation not supported on web");
    return MaterialObjSt.elevation(st);
  }
  public Color color() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("materialColor", getId());
      return new Color(__nid);
    }
    return new Color(MaterialObjSt.color(st));
  }
  public Color shadowColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("materialShadowColor", getId());
      return new Color(__nid);
    }
    return new Color(MaterialObjSt.shadowColor(st));
  }
  public Color surfaceTintColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("materialSurfaceTintColor", getId());
      return new Color(__nid);
    }
    return new Color(MaterialObjSt.surfaceTintColor(st));
  }
  public TextStyle textStyle() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("materialTextStyle", getId());
      java.lang.foreign.MemorySegment __st = dev.equo.ewt.ffm.TextStyleObjSt.allocate(__s.arena);
      dev.equo.ewt.ffm.TextStyleObjSt.id(__st, __nid);
      return new TextStyle(__st);
    }
    return new TextStyle(MaterialObjSt.textStyle(st));
  }
  public ShapeBorder shape() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("materialShape not supported on web");
    return new ShapeBorder(MaterialObjSt.shape(st)) {};
  }
  public boolean borderOnForeground() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("materialBorderOnForeground not supported on web");
    return intToBool(MaterialObjSt.borderOnForeground(st));
  }
  public Clip clipBehavior() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("materialClipBehavior not supported on web");
    return Clip.values()[MaterialObjSt.clipBehavior(st)];
  }
  public Duration animationDuration() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("materialAnimationDuration", getId());
      return new Duration(__nid);
    }
    return new Duration(MaterialObjSt.animationDuration(st));
  }
  public BorderRadiusGeometry borderRadius() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("materialBorderRadius not supported on web");
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
