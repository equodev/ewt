package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class PhysicalModel extends SingleChildRenderObjectWidget implements PhysicalModelI {
  protected PhysicalModel() {}
  PhysicalModel(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget PhysicalModel");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static PhysicalModel physicalModelPhysicalModel(Optional<BoxShape> shape, Optional<Clip> clipBehavior, Optional<BorderRadiusI> borderRadius, OptionalDouble elevation, ColorI color, Optional<ColorI> shadowColor, Optional<WidgetI> child) {
    int id = factories.physicalModelPhysicalModel(shape,
      clipBehavior,
      borderRadius.map(BorderRadiusI::build),
      elevation,
      color.build(),
      shadowColor.map(ColorI::build),
      child.map(WidgetI::build));
    if (id <= 0) throw new RuntimeException("Failed to created widget PhysicalModel");
    return new PhysicalModel(id);
  }
  public static PhysicalModelPhysicalModelBuilder physicalModel() {
    return PhysicalModelPhysicalModelBuilder.physicalModelPhysicalModel();
  }
  public BoxShape shape() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("physicalModelShape not supported on web");
    return factories.PhysicalModel_readBack_shape(nativeStruct);
  }
  public Clip clipBehavior() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("physicalModelClipBehavior not supported on web");
    return factories.PhysicalModel_readBack_clipBehavior(nativeStruct);
  }
  public BorderRadius borderRadius() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("physicalModelBorderRadius", getId());
      return new BorderRadius(__nid);
    }
    return factories.PhysicalModel_readBack_borderRadius(nativeStruct);
  }
  public double elevation() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("physicalModelElevation not supported on web");
    return factories.PhysicalModel_readBack_elevation(nativeStruct);
  }
  public Color color() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("physicalModelColor", getId());
      return new Color(__nid);
    }
    return factories.PhysicalModel_readBack_color(nativeStruct);
  }
  public Color shadowColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("physicalModelShadowColor", getId());
      return new Color(__nid);
    }
    return factories.PhysicalModel_readBack_shadowColor(nativeStruct);
  }
  @Override
  public PhysicalModel build() {
    return this;
  }
}
