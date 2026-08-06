package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.PopupMenuDividerObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class PopupMenuDivider extends PopupMenuEntry<Object> implements PopupMenuDividerI {
  private MemorySegment st;
  protected PopupMenuDivider() {}
  PopupMenuDivider(MemorySegment st) {
    this.id = PopupMenuDividerObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget PopupMenuDivider");
    System.out.println("New PopupMenuDivider id:"+id);
  }
  PopupMenuDivider(int id) { this.id = id; }
  @Builder.Factory
  static PopupMenuDivider popupMenuDividerPopupMenuDivider(OptionalDouble height, OptionalDouble thickness, OptionalDouble indent, OptionalDouble endIndent, Optional<BorderRadiusGeometryI> radius, Optional<ColorI> color) {
    var st = factories.popupMenuDividerPopupMenuDivider(height,
      thickness,
      indent,
      endIndent,
      radius.map(BorderRadiusGeometryI::build),
      color.map(ColorI::build));
    if (st == null) throw new RuntimeException("Failed to created widget PopupMenuDivider");
    return new PopupMenuDivider(st);
  }
  public static PopupMenuDividerPopupMenuDividerBuilder popupMenuDivider() {
    return PopupMenuDividerPopupMenuDividerBuilder.popupMenuDividerPopupMenuDivider();
  }
  public double height() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("popupMenuDividerHeight not supported on web");
    return PopupMenuDividerObjSt.height(st);
  }
  public double thickness() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("popupMenuDividerThickness not supported on web");
    return PopupMenuDividerObjSt.thickness(st);
  }
  public double indent() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("popupMenuDividerIndent not supported on web");
    return PopupMenuDividerObjSt.indent(st);
  }
  public double endIndent() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("popupMenuDividerEndIndent not supported on web");
    return PopupMenuDividerObjSt.endIndent(st);
  }
  public BorderRadiusGeometry radius() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("popupMenuDividerRadius not supported on web");
    return new BorderRadiusGeometry(PopupMenuDividerObjSt.radius(st)) {};
  }
  public Color color() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("popupMenuDividerColor", getId());
      return new Color(__nid);
    }
    return new Color(PopupMenuDividerObjSt.color(st));
  }
  @Override
  public PopupMenuDivider build() {
    return this;
  }
}
