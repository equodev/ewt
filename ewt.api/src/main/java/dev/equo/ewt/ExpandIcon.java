package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.ExpandIconObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class ExpandIcon extends StatefulWidget implements ExpandIconI {
  private MemorySegment st;
  protected ExpandIcon() {}
  ExpandIcon(MemorySegment st) {
    this.id = ExpandIconObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget ExpandIcon");
    System.out.println("New ExpandIcon id:"+id);
  }
  ExpandIcon(int id) { this.id = id; }
  @Builder.Factory
  static ExpandIcon expandIconExpandIcon(Optional<Boolean> isExpanded, OptionalDouble size, Consumer<Boolean> onPressed, Optional<EdgeInsetsGeometryI> padding, Optional<ColorI> color, Optional<ColorI> disabledColor, Optional<ColorI> expandedColor, Optional<ColorI> splashColor, Optional<ColorI> highlightColor) {
    var st = factories.expandIconExpandIcon(isExpanded,
      size,
      onPressed,
      padding.map(EdgeInsetsGeometryI::build),
      color.map(ColorI::build),
      disabledColor.map(ColorI::build),
      expandedColor.map(ColorI::build),
      splashColor.map(ColorI::build),
      highlightColor.map(ColorI::build));
    if (st == null) throw new RuntimeException("Failed to created widget ExpandIcon");
    return new ExpandIcon(st);
  }
  public static ExpandIconExpandIconBuilder expandIcon() {
    return ExpandIconExpandIconBuilder.expandIconExpandIcon();
  }
  public boolean isExpanded() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("expandIconIsExpanded not supported on web");
    return intToBool(ExpandIconObjSt.isExpanded(st));
  }
  public double size() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("expandIconSize not supported on web");
    return ExpandIconObjSt.size(st);
  }
  public EdgeInsetsGeometry padding() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("expandIconPadding not supported on web");
    return new EdgeInsetsGeometry(ExpandIconObjSt.padding(st)) {};
  }
  public Color color() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("expandIconColor", getId());
      return new Color(__nid);
    }
    return new Color(ExpandIconObjSt.color(st));
  }
  public Color disabledColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("expandIconDisabledColor", getId());
      return new Color(__nid);
    }
    return new Color(ExpandIconObjSt.disabledColor(st));
  }
  public Color expandedColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("expandIconExpandedColor", getId());
      return new Color(__nid);
    }
    return new Color(ExpandIconObjSt.expandedColor(st));
  }
  public Color splashColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("expandIconSplashColor", getId());
      return new Color(__nid);
    }
    return new Color(ExpandIconObjSt.splashColor(st));
  }
  public Color highlightColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("expandIconHighlightColor", getId());
      return new Color(__nid);
    }
    return new Color(ExpandIconObjSt.highlightColor(st));
  }
  @Override
  public ExpandIcon build() {
    return this;
  }
}
