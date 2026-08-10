package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.PhysicalModelObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class PhysicalModel extends SingleChildRenderObjectWidget implements PhysicalModelI {
  private MemorySegment st;
  protected PhysicalModel() {}
  PhysicalModel(MemorySegment st) {
    this.id = PhysicalModelObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget PhysicalModel");
    System.out.println("New PhysicalModel id:"+id);
  }
  PhysicalModel(int id) { this.id = id; }
  @Builder.Factory
  static PhysicalModel physicalModelPhysicalModel(Optional<BoxShape> shape, Optional<Clip> clipBehavior, Optional<BorderRadiusI> borderRadius, OptionalDouble elevation, ColorI color, Optional<ColorI> shadowColor, Optional<WidgetI> child) {
    var st = factories.physicalModelPhysicalModel(shape,
      clipBehavior,
      borderRadius.map(BorderRadiusI::build),
      elevation,
      color.build(),
      shadowColor.map(ColorI::build),
      child.map(WidgetI::build));
    if (st == null) throw new RuntimeException("Failed to created widget PhysicalModel");
    return new PhysicalModel(st);
  }
  public static PhysicalModelPhysicalModelBuilder physicalModel() {
    return PhysicalModelPhysicalModelBuilder.physicalModelPhysicalModel();
  }
  public BoxShape shape() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("physicalModelShape not supported on web");
    return BoxShape.values()[PhysicalModelObjSt.shape(st)];
  }
  public Clip clipBehavior() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("physicalModelClipBehavior not supported on web");
    return Clip.values()[PhysicalModelObjSt.clipBehavior(st)];
  }
  public BorderRadius borderRadius() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("physicalModelBorderRadius", getId());
      java.lang.foreign.MemorySegment __st = dev.equo.ewt.ffm.BorderRadiusObjSt.allocate(__s.arena);
      dev.equo.ewt.ffm.BorderRadiusObjSt.id(__st, __nid);
      return new BorderRadius(__st);
    }
    return new BorderRadius(PhysicalModelObjSt.borderRadius(st));
  }
  public double elevation() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("physicalModelElevation not supported on web");
    return PhysicalModelObjSt.elevation(st);
  }
  public Color color() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("physicalModelColor", getId());
      return new Color(__nid);
    }
    return new Color(PhysicalModelObjSt.color(st));
  }
  public Color shadowColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("physicalModelShadowColor", getId());
      return new Color(__nid);
    }
    return new Color(PhysicalModelObjSt.shadowColor(st));
  }
  @Override
  public PhysicalModel build() {
    return this;
  }
}
