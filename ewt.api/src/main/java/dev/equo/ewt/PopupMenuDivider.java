package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class PopupMenuDivider extends PopupMenuEntry<Object> implements PopupMenuDividerI {
  protected PopupMenuDivider() {}
  PopupMenuDivider(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget PopupMenuDivider");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static PopupMenuDivider popupMenuDividerPopupMenuDivider(OptionalDouble height, OptionalDouble thickness, OptionalDouble indent, OptionalDouble endIndent, Optional<BorderRadiusGeometryI> radius, Optional<ColorI> color) {
    int id = factories.popupMenuDividerPopupMenuDivider(height,
      thickness,
      indent,
      endIndent,
      radius.map(BorderRadiusGeometryI::build),
      color.map(ColorI::build));
    if (id <= 0) throw new RuntimeException("Failed to created widget PopupMenuDivider");
    return new PopupMenuDivider(id);
  }
  public static PopupMenuDividerPopupMenuDividerBuilder popupMenuDivider() {
    return PopupMenuDividerPopupMenuDividerBuilder.popupMenuDividerPopupMenuDivider();
  }
  public double height() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("popupMenuDividerHeight not supported on web");
    return factories.PopupMenuDivider_readBack_height(nativeStruct);
  }
  public double thickness() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("popupMenuDividerThickness not supported on web");
    return factories.PopupMenuDivider_readBack_thickness(nativeStruct);
  }
  public double indent() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("popupMenuDividerIndent not supported on web");
    return factories.PopupMenuDivider_readBack_indent(nativeStruct);
  }
  public double endIndent() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("popupMenuDividerEndIndent not supported on web");
    return factories.PopupMenuDivider_readBack_endIndent(nativeStruct);
  }
  public BorderRadiusGeometry radius() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("popupMenuDividerRadius not supported on web");
    return factories.PopupMenuDivider_readBack_radius(nativeStruct);
  }
  public Color color() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("popupMenuDividerColor", getId());
      return new Color(__nid);
    }
    return factories.PopupMenuDivider_readBack_color(nativeStruct);
  }
  @Override
  public PopupMenuDivider build() {
    return this;
  }
}
