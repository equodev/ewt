package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.SnackBarThemeDataObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class SnackBarThemeData extends NativeObj.Base implements SnackBarThemeDataI {
  private MemorySegment st;
  protected SnackBarThemeData() {}
  SnackBarThemeData(MemorySegment st) {
    this.id = SnackBarThemeDataObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget SnackBarThemeData");
    System.out.println("New SnackBarThemeData id:"+id);
  }
  SnackBarThemeData(int id) { this.id = id; }
  @Builder.Factory
  static SnackBarThemeData snackBarThemeDataSnackBarThemeData(Optional<ColorI> backgroundColor, Optional<ColorI> actionTextColor, Optional<ColorI> disabledActionTextColor, Optional<TextStyleI> contentTextStyle, OptionalDouble elevation, Optional<ShapeBorderI> shape, Optional<SnackBarBehavior> behavior, OptionalDouble width, Optional<EdgeInsetsI> insetPadding, Optional<Boolean> showCloseIcon, Optional<ColorI> closeIconColor, OptionalDouble actionOverflowThreshold, Optional<ColorI> actionBackgroundColor, Optional<ColorI> disabledActionBackgroundColor, Optional<DismissDirection> dismissDirection) {
    var st = factories.snackBarThemeDataSnackBarThemeData(backgroundColor.map(ColorI::build),
      actionTextColor.map(ColorI::build),
      disabledActionTextColor.map(ColorI::build),
      contentTextStyle.map(TextStyleI::build),
      elevation,
      shape.map(ShapeBorderI::build),
      behavior,
      width,
      insetPadding.map(EdgeInsetsI::build),
      showCloseIcon,
      closeIconColor.map(ColorI::build),
      actionOverflowThreshold,
      actionBackgroundColor.map(ColorI::build),
      disabledActionBackgroundColor.map(ColorI::build),
      dismissDirection);
    if (st == null) throw new RuntimeException("Failed to created widget SnackBarThemeData");
    return new SnackBarThemeData(st);
  }
  public static SnackBarThemeDataSnackBarThemeDataBuilder snackBarThemeData() {
    return SnackBarThemeDataSnackBarThemeDataBuilder.snackBarThemeDataSnackBarThemeData();
  }
  public static SnackBarThemeData lerp(SnackBarThemeDataI a, SnackBarThemeDataI b, double t) {
    var st = factories.snackBarThemeDataLerp(a.build(),
      b.build(),
      t);
    if (st == null) throw new RuntimeException("Failed to created widget SnackBarThemeData");
    return new SnackBarThemeData(st);
  }
  public Color backgroundColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("snackBarThemeDataBackgroundColor", getId());
      return new Color(__nid);
    }
    return new Color(SnackBarThemeDataObjSt.backgroundColor(st));
  }
  public Color actionTextColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("snackBarThemeDataActionTextColor", getId());
      return new Color(__nid);
    }
    return new Color(SnackBarThemeDataObjSt.actionTextColor(st));
  }
  public Color disabledActionTextColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("snackBarThemeDataDisabledActionTextColor", getId());
      return new Color(__nid);
    }
    return new Color(SnackBarThemeDataObjSt.disabledActionTextColor(st));
  }
  public TextStyle contentTextStyle() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("snackBarThemeDataContentTextStyle", getId());
      java.lang.foreign.MemorySegment __st = dev.equo.ewt.ffm.TextStyleObjSt.allocate(__s.arena);
      dev.equo.ewt.ffm.TextStyleObjSt.id(__st, __nid);
      return new TextStyle(__st);
    }
    return new TextStyle(SnackBarThemeDataObjSt.contentTextStyle(st));
  }
  public double elevation() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("snackBarThemeDataElevation not supported on web");
    return SnackBarThemeDataObjSt.elevation(st);
  }
  public ShapeBorder shape() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("snackBarThemeDataShape not supported on web");
    return new ShapeBorder(SnackBarThemeDataObjSt.shape(st)) {};
  }
  public SnackBarBehavior behavior() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("snackBarThemeDataBehavior not supported on web");
    return SnackBarBehavior.values()[SnackBarThemeDataObjSt.behavior(st)];
  }
  public double width() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("snackBarThemeDataWidth not supported on web");
    return SnackBarThemeDataObjSt.width(st);
  }
  public EdgeInsets insetPadding() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("snackBarThemeDataInsetPadding", getId());
      java.lang.foreign.MemorySegment __st = dev.equo.ewt.ffm.EdgeInsetsObjSt.allocate(__s.arena);
      dev.equo.ewt.ffm.EdgeInsetsObjSt.id(__st, __nid);
      return new EdgeInsets(__st);
    }
    return new EdgeInsets(SnackBarThemeDataObjSt.insetPadding(st));
  }
  public boolean showCloseIcon() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("snackBarThemeDataShowCloseIcon not supported on web");
    return intToBool(SnackBarThemeDataObjSt.showCloseIcon(st));
  }
  public Color closeIconColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("snackBarThemeDataCloseIconColor", getId());
      return new Color(__nid);
    }
    return new Color(SnackBarThemeDataObjSt.closeIconColor(st));
  }
  public double actionOverflowThreshold() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("snackBarThemeDataActionOverflowThreshold not supported on web");
    return SnackBarThemeDataObjSt.actionOverflowThreshold(st);
  }
  public Color actionBackgroundColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("snackBarThemeDataActionBackgroundColor", getId());
      return new Color(__nid);
    }
    return new Color(SnackBarThemeDataObjSt.actionBackgroundColor(st));
  }
  public Color disabledActionBackgroundColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("snackBarThemeDataDisabledActionBackgroundColor", getId());
      return new Color(__nid);
    }
    return new Color(SnackBarThemeDataObjSt.disabledActionBackgroundColor(st));
  }
  public DismissDirection dismissDirection() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("snackBarThemeDataDismissDirection not supported on web");
    return DismissDirection.values()[SnackBarThemeDataObjSt.dismissDirection(st)];
  }
  @Override
  public SnackBarThemeData build() {
    return this;
  }
}
