package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.DividerThemeDataObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class DividerThemeData extends NativeObj.Base implements DividerThemeDataI {
  private MemorySegment st;
  protected DividerThemeData() {}
  DividerThemeData(MemorySegment st) {
    this.id = DividerThemeDataObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget DividerThemeData");
    System.out.println("New DividerThemeData id:"+id);
  }
  DividerThemeData(int id) { this.id = id; }
  @Builder.Factory
  static DividerThemeData dividerThemeDataDividerThemeData(Optional<ColorI> color, OptionalDouble space, OptionalDouble thickness, OptionalDouble indent, OptionalDouble endIndent, Optional<BorderRadiusGeometryI> radius) {
    var st = factories.dividerThemeDataDividerThemeData(color.map(ColorI::build),
      space,
      thickness,
      indent,
      endIndent,
      radius.map(BorderRadiusGeometryI::build));
    if (st == null) throw new RuntimeException("Failed to created widget DividerThemeData");
    return new DividerThemeData(st);
  }
  public static DividerThemeDataDividerThemeDataBuilder dividerThemeData() {
    return DividerThemeDataDividerThemeDataBuilder.dividerThemeDataDividerThemeData();
  }
  public static DividerThemeData lerp(DividerThemeDataI a, DividerThemeDataI b, double t) {
    var st = factories.dividerThemeDataLerp(a.build(),
      b.build(),
      t);
    if (st == null) throw new RuntimeException("Failed to created widget DividerThemeData");
    return new DividerThemeData(st);
  }
  public Color color() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("dividerThemeDataColor", getId());
      return new Color(__nid);
    }
    return new Color(DividerThemeDataObjSt.color(st));
  }
  public double space() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("dividerThemeDataSpace not supported on web");
    return DividerThemeDataObjSt.space(st);
  }
  public double thickness() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("dividerThemeDataThickness not supported on web");
    return DividerThemeDataObjSt.thickness(st);
  }
  public double indent() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("dividerThemeDataIndent not supported on web");
    return DividerThemeDataObjSt.indent(st);
  }
  public double endIndent() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("dividerThemeDataEndIndent not supported on web");
    return DividerThemeDataObjSt.endIndent(st);
  }
  public BorderRadiusGeometry radius() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("dividerThemeDataRadius not supported on web");
    return new BorderRadiusGeometry(DividerThemeDataObjSt.radius(st)) {};
  }
  @Override
  public DividerThemeData build() {
    return this;
  }
}
