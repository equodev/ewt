package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class DividerThemeData extends NativeObj.Base implements DividerThemeDataI {
  protected DividerThemeData() {}
  DividerThemeData(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget DividerThemeData");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static DividerThemeData dividerThemeDataDividerThemeData(Optional<ColorI> color, OptionalDouble space, OptionalDouble thickness, OptionalDouble indent, OptionalDouble endIndent, Optional<BorderRadiusGeometryI> radius) {
    int id = factories.dividerThemeDataDividerThemeData(color.map(ColorI::build),
      space,
      thickness,
      indent,
      endIndent,
      radius.map(BorderRadiusGeometryI::build));
    if (id <= 0) throw new RuntimeException("Failed to created widget DividerThemeData");
    return new DividerThemeData(id);
  }
  public static DividerThemeDataDividerThemeDataBuilder dividerThemeData() {
    return DividerThemeDataDividerThemeDataBuilder.dividerThemeDataDividerThemeData();
  }
  public static DividerThemeData lerp(DividerThemeDataI a, DividerThemeDataI b, double t) {
    int id = factories.dividerThemeDataLerp(a.build(),
      b.build(),
      t);
    if (id <= 0) throw new RuntimeException("Failed to created widget DividerThemeData");
    return new DividerThemeData(id);
  }
  public Color color() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("dividerThemeDataColor", getId());
      return new Color(__nid);
    }
    return factories.DividerThemeData_readBack_color(nativeStruct);
  }
  public double space() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("dividerThemeDataSpace not supported on web");
    return factories.DividerThemeData_readBack_space(nativeStruct);
  }
  public double thickness() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("dividerThemeDataThickness not supported on web");
    return factories.DividerThemeData_readBack_thickness(nativeStruct);
  }
  public double indent() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("dividerThemeDataIndent not supported on web");
    return factories.DividerThemeData_readBack_indent(nativeStruct);
  }
  public double endIndent() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("dividerThemeDataEndIndent not supported on web");
    return factories.DividerThemeData_readBack_endIndent(nativeStruct);
  }
  public BorderRadiusGeometry radius() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("dividerThemeDataRadius not supported on web");
    return factories.DividerThemeData_readBack_radius(nativeStruct);
  }
  @Override
  public DividerThemeData build() {
    return this;
  }
}
