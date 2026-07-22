package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.DividerObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class Divider extends StatelessWidget implements DividerI {
  private MemorySegment st;
  protected Divider() {}
  Divider(MemorySegment st) {
    this.id = DividerObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget Divider");
    System.out.println("New Divider id:"+id);
  }
  @Builder.Factory
  static Divider dividerDivider(OptionalDouble height, OptionalDouble thickness, OptionalDouble indent, OptionalDouble endIndent, Optional<ColorI> color, Optional<BorderRadiusGeometryI> radius) {
    var st = factories.dividerDivider(height,
      thickness,
      indent,
      endIndent,
      color.map(ColorI::build),
      radius.map(BorderRadiusGeometryI::build));
    if (st == null) throw new RuntimeException("Failed to created widget Divider");
    return new Divider(st);
  }
  public static DividerDividerBuilder divider() {
    return DividerDividerBuilder.dividerDivider();
  }
  public static BorderSide createBorderSide(BuildContextI context) {
    var st = factories.dividerCreateBorderSide(context.build(),
      Optional.empty(),
      OptionalDouble.empty());
    if (st == null) throw new RuntimeException("Failed to created widget BorderSide");
    return new BorderSide(st);
  }
  public double height() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("dividerHeight not supported on web");
    return DividerObjSt.height(st);
  }
  public double thickness() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("dividerThickness not supported on web");
    return DividerObjSt.thickness(st);
  }
  public double indent() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("dividerIndent not supported on web");
    return DividerObjSt.indent(st);
  }
  public double endIndent() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("dividerEndIndent not supported on web");
    return DividerObjSt.endIndent(st);
  }
  public BorderRadiusGeometry radius() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("dividerRadius not supported on web");
    return new BorderRadiusGeometry(DividerObjSt.radius(st)) {};
  }
  public Color color() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("dividerColor", getId());
      return new Color(__nid);
    }
    return new Color(DividerObjSt.color(st));
  }
  @Override
  public Divider build() {
    return this;
  }
}
