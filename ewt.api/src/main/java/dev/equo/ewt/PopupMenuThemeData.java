package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.PopupMenuThemeDataObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class PopupMenuThemeData extends NativeObj.Base implements PopupMenuThemeDataI {
  private MemorySegment st;
  protected PopupMenuThemeData() {}
  PopupMenuThemeData(MemorySegment st) {
    this.id = PopupMenuThemeDataObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget PopupMenuThemeData");
    System.out.println("New PopupMenuThemeData id:"+id);
  }
  PopupMenuThemeData(int id) { this.id = id; }
  @Builder.Factory
  static PopupMenuThemeData popupMenuThemeDataPopupMenuThemeData(Optional<ColorI> color, Optional<ShapeBorderI> shape, Optional<EdgeInsetsGeometryI> menuPadding, OptionalDouble elevation, Optional<ColorI> shadowColor, Optional<ColorI> surfaceTintColor, Optional<TextStyleI> textStyle, Optional<TextStyleI> labelTextStyle, Optional<Boolean> enableFeedback, Optional<PopupMenuPosition> position, Optional<ColorI> iconColor, OptionalDouble iconSize) {
    var st = factories.popupMenuThemeDataPopupMenuThemeData(color.map(ColorI::build),
      shape.map(ShapeBorderI::build),
      menuPadding.map(EdgeInsetsGeometryI::build),
      elevation,
      shadowColor.map(ColorI::build),
      surfaceTintColor.map(ColorI::build),
      textStyle.map(TextStyleI::build),
      labelTextStyle.map(TextStyleI::build),
      enableFeedback,
      position,
      iconColor.map(ColorI::build),
      iconSize);
    if (st == null) throw new RuntimeException("Failed to created widget PopupMenuThemeData");
    return new PopupMenuThemeData(st);
  }
  public static PopupMenuThemeDataPopupMenuThemeDataBuilder popupMenuThemeData() {
    return PopupMenuThemeDataPopupMenuThemeDataBuilder.popupMenuThemeDataPopupMenuThemeData();
  }
  public static PopupMenuThemeData lerp(PopupMenuThemeDataI a, PopupMenuThemeDataI b, double t) {
    var st = factories.popupMenuThemeDataLerp(a.build(),
      b.build(),
      t);
    if (st == null) throw new RuntimeException("Failed to created widget PopupMenuThemeData");
    return new PopupMenuThemeData(st);
  }
  public Color color() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("popupMenuThemeDataColor", getId());
      return new Color(__nid);
    }
    return new Color(PopupMenuThemeDataObjSt.color(st));
  }
  public ShapeBorder shape() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("popupMenuThemeDataShape not supported on web");
    return new ShapeBorder(PopupMenuThemeDataObjSt.shape(st)) {};
  }
  public EdgeInsetsGeometry menuPadding() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("popupMenuThemeDataMenuPadding not supported on web");
    return new EdgeInsetsGeometry(PopupMenuThemeDataObjSt.menuPadding(st)) {};
  }
  public double elevation() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("popupMenuThemeDataElevation not supported on web");
    return PopupMenuThemeDataObjSt.elevation(st);
  }
  public Color shadowColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("popupMenuThemeDataShadowColor", getId());
      return new Color(__nid);
    }
    return new Color(PopupMenuThemeDataObjSt.shadowColor(st));
  }
  public Color surfaceTintColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("popupMenuThemeDataSurfaceTintColor", getId());
      return new Color(__nid);
    }
    return new Color(PopupMenuThemeDataObjSt.surfaceTintColor(st));
  }
  public TextStyle textStyle() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("popupMenuThemeDataTextStyle", getId());
      java.lang.foreign.MemorySegment __st = dev.equo.ewt.ffm.TextStyleObjSt.allocate(__s.arena);
      dev.equo.ewt.ffm.TextStyleObjSt.id(__st, __nid);
      return new TextStyle(__st);
    }
    return new TextStyle(PopupMenuThemeDataObjSt.textStyle(st));
  }
  public boolean enableFeedback() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("popupMenuThemeDataEnableFeedback not supported on web");
    return intToBool(PopupMenuThemeDataObjSt.enableFeedback(st));
  }
  public PopupMenuPosition position() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("popupMenuThemeDataPosition not supported on web");
    return PopupMenuPosition.values()[PopupMenuThemeDataObjSt.position(st)];
  }
  public Color iconColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("popupMenuThemeDataIconColor", getId());
      return new Color(__nid);
    }
    return new Color(PopupMenuThemeDataObjSt.iconColor(st));
  }
  public double iconSize() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("popupMenuThemeDataIconSize not supported on web");
    return PopupMenuThemeDataObjSt.iconSize(st);
  }
  @Override
  public PopupMenuThemeData build() {
    return this;
  }
}
