package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.VerticalDividerObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class VerticalDivider extends StatelessWidget implements VerticalDividerI {
  private MemorySegment st;
  protected VerticalDivider() {}
  VerticalDivider(MemorySegment st) {
    this.id = VerticalDividerObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget VerticalDivider");
    System.out.println("New VerticalDivider id:"+id);
  }
  VerticalDivider(int id) { this.id = id; }
  @Builder.Factory
  static VerticalDivider verticalDividerVerticalDivider(OptionalDouble width, OptionalDouble thickness, OptionalDouble indent, OptionalDouble endIndent, Optional<ColorI> color, Optional<BorderRadiusGeometryI> radius) {
    var st = factories.verticalDividerVerticalDivider(width,
      thickness,
      indent,
      endIndent,
      color.map(ColorI::build),
      radius.map(BorderRadiusGeometryI::build));
    if (st == null) throw new RuntimeException("Failed to created widget VerticalDivider");
    return new VerticalDivider(st);
  }
  public static VerticalDividerVerticalDividerBuilder verticalDivider() {
    return VerticalDividerVerticalDividerBuilder.verticalDividerVerticalDivider();
  }
  public double width() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("verticalDividerWidth not supported on web");
    return VerticalDividerObjSt.width(st);
  }
  public double thickness() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("verticalDividerThickness not supported on web");
    return VerticalDividerObjSt.thickness(st);
  }
  public double indent() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("verticalDividerIndent not supported on web");
    return VerticalDividerObjSt.indent(st);
  }
  public double endIndent() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("verticalDividerEndIndent not supported on web");
    return VerticalDividerObjSt.endIndent(st);
  }
  public Color color() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("verticalDividerColor", getId());
      return new Color(__nid);
    }
    return new Color(VerticalDividerObjSt.color(st));
  }
  public BorderRadiusGeometry radius() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("verticalDividerRadius not supported on web");
    return new BorderRadiusGeometry(VerticalDividerObjSt.radius(st)) {};
  }
  @Override
  public VerticalDivider build() {
    return this;
  }
}
