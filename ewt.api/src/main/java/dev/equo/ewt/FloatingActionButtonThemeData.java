package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.FloatingActionButtonThemeDataObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class FloatingActionButtonThemeData extends NativeObj.Base implements FloatingActionButtonThemeDataI {
  private MemorySegment st;
  protected FloatingActionButtonThemeData() {}
  FloatingActionButtonThemeData(MemorySegment st) {
    this.id = FloatingActionButtonThemeDataObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget FloatingActionButtonThemeData");
    System.out.println("New FloatingActionButtonThemeData id:"+id);
  }
  FloatingActionButtonThemeData(int id) { this.id = id; }
  @Builder.Factory
  static FloatingActionButtonThemeData floatingActionButtonThemeDataFloatingActionButtonThemeData(Optional<ColorI> foregroundColor, Optional<ColorI> backgroundColor, Optional<ColorI> focusColor, Optional<ColorI> hoverColor, Optional<ColorI> splashColor, OptionalDouble elevation, OptionalDouble focusElevation, OptionalDouble hoverElevation, OptionalDouble disabledElevation, OptionalDouble highlightElevation, Optional<ShapeBorderI> shape, Optional<Boolean> enableFeedback, OptionalDouble iconSize, Optional<BoxConstraintsI> sizeConstraints, Optional<BoxConstraintsI> smallSizeConstraints, Optional<BoxConstraintsI> largeSizeConstraints, Optional<BoxConstraintsI> extendedSizeConstraints, OptionalDouble extendedIconLabelSpacing, Optional<EdgeInsetsGeometryI> extendedPadding, Optional<TextStyleI> extendedTextStyle) {
    var st = factories.floatingActionButtonThemeDataFloatingActionButtonThemeData(foregroundColor.map(ColorI::build),
      backgroundColor.map(ColorI::build),
      focusColor.map(ColorI::build),
      hoverColor.map(ColorI::build),
      splashColor.map(ColorI::build),
      elevation,
      focusElevation,
      hoverElevation,
      disabledElevation,
      highlightElevation,
      shape.map(ShapeBorderI::build),
      enableFeedback,
      iconSize,
      sizeConstraints.map(BoxConstraintsI::build),
      smallSizeConstraints.map(BoxConstraintsI::build),
      largeSizeConstraints.map(BoxConstraintsI::build),
      extendedSizeConstraints.map(BoxConstraintsI::build),
      extendedIconLabelSpacing,
      extendedPadding.map(EdgeInsetsGeometryI::build),
      extendedTextStyle.map(TextStyleI::build));
    if (st == null) throw new RuntimeException("Failed to created widget FloatingActionButtonThemeData");
    return new FloatingActionButtonThemeData(st);
  }
  public static FloatingActionButtonThemeDataFloatingActionButtonThemeDataBuilder floatingActionButtonThemeData() {
    return FloatingActionButtonThemeDataFloatingActionButtonThemeDataBuilder.floatingActionButtonThemeDataFloatingActionButtonThemeData();
  }
  public static FloatingActionButtonThemeData lerp(FloatingActionButtonThemeDataI a, FloatingActionButtonThemeDataI b, double t) {
    var st = factories.floatingActionButtonThemeDataLerp(a.build(),
      b.build(),
      t);
    if (st == null) throw new RuntimeException("Failed to created widget FloatingActionButtonThemeData");
    return new FloatingActionButtonThemeData(st);
  }
  public Color foregroundColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("floatingActionButtonThemeDataForegroundColor", getId());
      return new Color(__nid);
    }
    return new Color(FloatingActionButtonThemeDataObjSt.foregroundColor(st));
  }
  public Color backgroundColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("floatingActionButtonThemeDataBackgroundColor", getId());
      return new Color(__nid);
    }
    return new Color(FloatingActionButtonThemeDataObjSt.backgroundColor(st));
  }
  public Color focusColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("floatingActionButtonThemeDataFocusColor", getId());
      return new Color(__nid);
    }
    return new Color(FloatingActionButtonThemeDataObjSt.focusColor(st));
  }
  public Color hoverColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("floatingActionButtonThemeDataHoverColor", getId());
      return new Color(__nid);
    }
    return new Color(FloatingActionButtonThemeDataObjSt.hoverColor(st));
  }
  public Color splashColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("floatingActionButtonThemeDataSplashColor", getId());
      return new Color(__nid);
    }
    return new Color(FloatingActionButtonThemeDataObjSt.splashColor(st));
  }
  public double elevation() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("floatingActionButtonThemeDataElevation not supported on web");
    return FloatingActionButtonThemeDataObjSt.elevation(st);
  }
  public double focusElevation() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("floatingActionButtonThemeDataFocusElevation not supported on web");
    return FloatingActionButtonThemeDataObjSt.focusElevation(st);
  }
  public double hoverElevation() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("floatingActionButtonThemeDataHoverElevation not supported on web");
    return FloatingActionButtonThemeDataObjSt.hoverElevation(st);
  }
  public double disabledElevation() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("floatingActionButtonThemeDataDisabledElevation not supported on web");
    return FloatingActionButtonThemeDataObjSt.disabledElevation(st);
  }
  public double highlightElevation() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("floatingActionButtonThemeDataHighlightElevation not supported on web");
    return FloatingActionButtonThemeDataObjSt.highlightElevation(st);
  }
  public ShapeBorder shape() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("floatingActionButtonThemeDataShape not supported on web");
    return new ShapeBorder(FloatingActionButtonThemeDataObjSt.shape(st)) {};
  }
  public boolean enableFeedback() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("floatingActionButtonThemeDataEnableFeedback not supported on web");
    return intToBool(FloatingActionButtonThemeDataObjSt.enableFeedback(st));
  }
  public double iconSize() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("floatingActionButtonThemeDataIconSize not supported on web");
    return FloatingActionButtonThemeDataObjSt.iconSize(st);
  }
  public BoxConstraints sizeConstraints() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("floatingActionButtonThemeDataSizeConstraints", getId());
      java.lang.foreign.MemorySegment __st = dev.equo.ewt.ffm.BoxConstraintsObjSt.allocate(__s.arena);
      dev.equo.ewt.ffm.BoxConstraintsObjSt.id(__st, __nid);
      return new BoxConstraints(__st);
    }
    return new BoxConstraints(FloatingActionButtonThemeDataObjSt.sizeConstraints(st));
  }
  public BoxConstraints smallSizeConstraints() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("floatingActionButtonThemeDataSmallSizeConstraints", getId());
      java.lang.foreign.MemorySegment __st = dev.equo.ewt.ffm.BoxConstraintsObjSt.allocate(__s.arena);
      dev.equo.ewt.ffm.BoxConstraintsObjSt.id(__st, __nid);
      return new BoxConstraints(__st);
    }
    return new BoxConstraints(FloatingActionButtonThemeDataObjSt.smallSizeConstraints(st));
  }
  public BoxConstraints largeSizeConstraints() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("floatingActionButtonThemeDataLargeSizeConstraints", getId());
      java.lang.foreign.MemorySegment __st = dev.equo.ewt.ffm.BoxConstraintsObjSt.allocate(__s.arena);
      dev.equo.ewt.ffm.BoxConstraintsObjSt.id(__st, __nid);
      return new BoxConstraints(__st);
    }
    return new BoxConstraints(FloatingActionButtonThemeDataObjSt.largeSizeConstraints(st));
  }
  public BoxConstraints extendedSizeConstraints() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("floatingActionButtonThemeDataExtendedSizeConstraints", getId());
      java.lang.foreign.MemorySegment __st = dev.equo.ewt.ffm.BoxConstraintsObjSt.allocate(__s.arena);
      dev.equo.ewt.ffm.BoxConstraintsObjSt.id(__st, __nid);
      return new BoxConstraints(__st);
    }
    return new BoxConstraints(FloatingActionButtonThemeDataObjSt.extendedSizeConstraints(st));
  }
  public double extendedIconLabelSpacing() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("floatingActionButtonThemeDataExtendedIconLabelSpacing not supported on web");
    return FloatingActionButtonThemeDataObjSt.extendedIconLabelSpacing(st);
  }
  public EdgeInsetsGeometry extendedPadding() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("floatingActionButtonThemeDataExtendedPadding not supported on web");
    return new EdgeInsetsGeometry(FloatingActionButtonThemeDataObjSt.extendedPadding(st)) {};
  }
  public TextStyle extendedTextStyle() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("floatingActionButtonThemeDataExtendedTextStyle", getId());
      java.lang.foreign.MemorySegment __st = dev.equo.ewt.ffm.TextStyleObjSt.allocate(__s.arena);
      dev.equo.ewt.ffm.TextStyleObjSt.id(__st, __nid);
      return new TextStyle(__st);
    }
    return new TextStyle(FloatingActionButtonThemeDataObjSt.extendedTextStyle(st));
  }
  @Override
  public FloatingActionButtonThemeData build() {
    return this;
  }
}
