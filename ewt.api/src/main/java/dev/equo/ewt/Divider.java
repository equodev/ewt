package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class Divider extends StatelessWidget implements DividerI {
  protected Divider() {}
  Divider(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget Divider");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static Divider dividerDivider(OptionalDouble height, OptionalDouble thickness, OptionalDouble indent, OptionalDouble endIndent, Optional<ColorI> color, Optional<BorderRadiusGeometryI> radius) {
    int id = factories.dividerDivider(height,
      thickness,
      indent,
      endIndent,
      color.map(ColorI::build),
      radius.map(BorderRadiusGeometryI::build));
    if (id <= 0) throw new RuntimeException("Failed to created widget Divider");
    return new Divider(id);
  }
  public static DividerDividerBuilder divider() {
    return DividerDividerBuilder.dividerDivider();
  }
  public static BorderSide createBorderSide(BuildContextI context) {
    int id = factories.dividerCreateBorderSide(context.build(),
      Optional.empty(),
      OptionalDouble.empty());
    if (id <= 0) throw new RuntimeException("Failed to created widget BorderSide");
    return new BorderSide(id);
  }
  public double height() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("dividerHeight not supported on web");
    return factories.Divider_readBack_height(nativeStruct);
  }
  public double thickness() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("dividerThickness not supported on web");
    return factories.Divider_readBack_thickness(nativeStruct);
  }
  public double indent() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("dividerIndent not supported on web");
    return factories.Divider_readBack_indent(nativeStruct);
  }
  public double endIndent() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("dividerEndIndent not supported on web");
    return factories.Divider_readBack_endIndent(nativeStruct);
  }
  public BorderRadiusGeometry radius() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("dividerRadius not supported on web");
    return factories.Divider_readBack_radius(nativeStruct);
  }
  public Color color() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("dividerColor", getId());
      return new Color(__nid);
    }
    return factories.Divider_readBack_color(nativeStruct);
  }
  @Override
  public Divider build() {
    return this;
  }
}
