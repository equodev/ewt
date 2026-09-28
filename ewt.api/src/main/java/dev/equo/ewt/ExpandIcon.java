package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class ExpandIcon extends StatefulWidget implements ExpandIconI {
  protected ExpandIcon() {}
  ExpandIcon(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget ExpandIcon");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static ExpandIcon expandIconExpandIcon(Optional<Boolean> isExpanded, OptionalDouble size, Optional<Consumer<Boolean>> onPressed, Optional<EdgeInsetsGeometryI> padding, Optional<ColorI> color, Optional<ColorI> disabledColor, Optional<ColorI> expandedColor, Optional<ColorI> splashColor, Optional<ColorI> highlightColor) {
    int id = factories.expandIconExpandIcon(isExpanded,
      size,
      onPressed,
      padding.map(EdgeInsetsGeometryI::build),
      color.map(ColorI::build),
      disabledColor.map(ColorI::build),
      expandedColor.map(ColorI::build),
      splashColor.map(ColorI::build),
      highlightColor.map(ColorI::build));
    if (id <= 0) throw new RuntimeException("Failed to created widget ExpandIcon");
    return new ExpandIcon(id);
  }
  public static ExpandIconExpandIconBuilder expandIcon() {
    return ExpandIconExpandIconBuilder.expandIconExpandIcon();
  }
  public boolean isExpanded() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("expandIconIsExpanded not supported on web");
    return factories.ExpandIcon_readBack_isExpanded(nativeStruct);
  }
  public double size() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("expandIconSize not supported on web");
    return factories.ExpandIcon_readBack_size(nativeStruct);
  }
  public EdgeInsetsGeometry padding() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("expandIconPadding not supported on web");
    return factories.ExpandIcon_readBack_padding(nativeStruct);
  }
  public Color color() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("expandIconColor", getId());
      return new Color(__nid);
    }
    return factories.ExpandIcon_readBack_color(nativeStruct);
  }
  public Color disabledColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("expandIconDisabledColor", getId());
      return new Color(__nid);
    }
    return factories.ExpandIcon_readBack_disabledColor(nativeStruct);
  }
  public Color expandedColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("expandIconExpandedColor", getId());
      return new Color(__nid);
    }
    return factories.ExpandIcon_readBack_expandedColor(nativeStruct);
  }
  public Color splashColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("expandIconSplashColor", getId());
      return new Color(__nid);
    }
    return factories.ExpandIcon_readBack_splashColor(nativeStruct);
  }
  public Color highlightColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("expandIconHighlightColor", getId());
      return new Color(__nid);
    }
    return factories.ExpandIcon_readBack_highlightColor(nativeStruct);
  }
  @Override
  public ExpandIcon build() {
    return this;
  }
}
