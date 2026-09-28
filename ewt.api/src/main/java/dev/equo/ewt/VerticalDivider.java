package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class VerticalDivider extends StatelessWidget implements VerticalDividerI {
  protected VerticalDivider() {}
  VerticalDivider(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget VerticalDivider");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static VerticalDivider verticalDividerVerticalDivider(OptionalDouble width, OptionalDouble thickness, OptionalDouble indent, OptionalDouble endIndent, Optional<ColorI> color, Optional<BorderRadiusGeometryI> radius) {
    int id = factories.verticalDividerVerticalDivider(width,
      thickness,
      indent,
      endIndent,
      color.map(ColorI::build),
      radius.map(BorderRadiusGeometryI::build));
    if (id <= 0) throw new RuntimeException("Failed to created widget VerticalDivider");
    return new VerticalDivider(id);
  }
  public static VerticalDividerVerticalDividerBuilder verticalDivider() {
    return VerticalDividerVerticalDividerBuilder.verticalDividerVerticalDivider();
  }
  public double width() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("verticalDividerWidth not supported on web");
    return factories.VerticalDivider_readBack_width(nativeStruct);
  }
  public double thickness() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("verticalDividerThickness not supported on web");
    return factories.VerticalDivider_readBack_thickness(nativeStruct);
  }
  public double indent() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("verticalDividerIndent not supported on web");
    return factories.VerticalDivider_readBack_indent(nativeStruct);
  }
  public double endIndent() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("verticalDividerEndIndent not supported on web");
    return factories.VerticalDivider_readBack_endIndent(nativeStruct);
  }
  public Color color() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("verticalDividerColor", getId());
      return new Color(__nid);
    }
    return factories.VerticalDivider_readBack_color(nativeStruct);
  }
  public BorderRadiusGeometry radius() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("verticalDividerRadius not supported on web");
    return factories.VerticalDivider_readBack_radius(nativeStruct);
  }
  @Override
  public VerticalDivider build() {
    return this;
  }
}
