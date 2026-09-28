package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class Material extends StatefulWidget implements MaterialI {
  protected Material() {}
  Material(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget Material");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static Material materialMaterial(Optional<MaterialType> type, OptionalDouble elevation, Optional<ColorI> color, Optional<ColorI> shadowColor, Optional<ColorI> surfaceTintColor, Optional<TextStyleI> textStyle, Optional<BorderRadiusGeometryI> borderRadius, Optional<ShapeBorderI> shape, Optional<Boolean> borderOnForeground, Optional<Clip> clipBehavior, Optional<DurationI> animationDuration, Optional<WidgetI> child, Optional<Boolean> animateColor) {
    int id = factories.materialMaterial(type,
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
    if (id <= 0) throw new RuntimeException("Failed to created widget Material");
    return new Material(id);
  }
  public static MaterialMaterialBuilder material() {
    return MaterialMaterialBuilder.materialMaterial();
  }
  public Widget child() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("materialChild not supported on web");
    return factories.Material_readBack_child(nativeStruct);
  }
  public MaterialType type() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("materialType not supported on web");
    return factories.Material_readBack_type(nativeStruct);
  }
  public boolean animateColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("materialAnimateColor not supported on web");
    return factories.Material_readBack_animateColor(nativeStruct);
  }
  public double elevation() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("materialElevation not supported on web");
    return factories.Material_readBack_elevation(nativeStruct);
  }
  public Color color() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("materialColor", getId());
      return new Color(__nid);
    }
    return factories.Material_readBack_color(nativeStruct);
  }
  public Color shadowColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("materialShadowColor", getId());
      return new Color(__nid);
    }
    return factories.Material_readBack_shadowColor(nativeStruct);
  }
  public Color surfaceTintColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("materialSurfaceTintColor", getId());
      return new Color(__nid);
    }
    return factories.Material_readBack_surfaceTintColor(nativeStruct);
  }
  public TextStyle textStyle() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("materialTextStyle", getId());
      return new TextStyle(__nid);
    }
    return factories.Material_readBack_textStyle(nativeStruct);
  }
  public ShapeBorder shape() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("materialShape not supported on web");
    return factories.Material_readBack_shape(nativeStruct);
  }
  public boolean borderOnForeground() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("materialBorderOnForeground not supported on web");
    return factories.Material_readBack_borderOnForeground(nativeStruct);
  }
  public Clip clipBehavior() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("materialClipBehavior not supported on web");
    return factories.Material_readBack_clipBehavior(nativeStruct);
  }
  public Duration animationDuration() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("materialAnimationDuration", getId());
      return new Duration(__nid);
    }
    return factories.Material_readBack_animationDuration(nativeStruct);
  }
  public BorderRadiusGeometry borderRadius() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("materialBorderRadius not supported on web");
    return factories.Material_readBack_borderRadius(nativeStruct);
  }
  public static double defaultSplashRadius() {
    return 35.0;
  }
  @Override
  public Material build() {
    return this;
  }
}
