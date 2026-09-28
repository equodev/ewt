package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class BottomSheetThemeData extends NativeObj.Base implements BottomSheetThemeDataI {
  protected BottomSheetThemeData() {}
  BottomSheetThemeData(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget BottomSheetThemeData");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static BottomSheetThemeData bottomSheetThemeDataBottomSheetThemeData(Optional<ColorI> backgroundColor, Optional<ColorI> surfaceTintColor, OptionalDouble elevation, Optional<ColorI> modalBackgroundColor, Optional<ColorI> modalBarrierColor, Optional<ColorI> shadowColor, OptionalDouble modalElevation, Optional<ShapeBorderI> shape, Optional<Boolean> showDragHandle, Optional<ColorI> dragHandleColor, Optional<Clip> clipBehavior, Optional<BoxConstraintsI> constraints) {
    int id = factories.bottomSheetThemeDataBottomSheetThemeData(backgroundColor.map(ColorI::build),
      surfaceTintColor.map(ColorI::build),
      elevation,
      modalBackgroundColor.map(ColorI::build),
      modalBarrierColor.map(ColorI::build),
      shadowColor.map(ColorI::build),
      modalElevation,
      shape.map(ShapeBorderI::build),
      showDragHandle,
      dragHandleColor.map(ColorI::build),
      clipBehavior,
      constraints.map(BoxConstraintsI::build));
    if (id <= 0) throw new RuntimeException("Failed to created widget BottomSheetThemeData");
    return new BottomSheetThemeData(id);
  }
  public static BottomSheetThemeDataBottomSheetThemeDataBuilder bottomSheetThemeData() {
    return BottomSheetThemeDataBottomSheetThemeDataBuilder.bottomSheetThemeDataBottomSheetThemeData();
  }
  public static BottomSheetThemeData lerp(BottomSheetThemeDataI a, BottomSheetThemeDataI b, double t) {
    int id = factories.bottomSheetThemeDataLerp(a.build(),
      b.build(),
      t);
    if (id <= 0) throw new RuntimeException("Failed to created widget BottomSheetThemeData");
    return new BottomSheetThemeData(id);
  }
  public Color backgroundColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("bottomSheetThemeDataBackgroundColor", getId());
      return new Color(__nid);
    }
    return factories.BottomSheetThemeData_readBack_backgroundColor(nativeStruct);
  }
  public Color surfaceTintColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("bottomSheetThemeDataSurfaceTintColor", getId());
      return new Color(__nid);
    }
    return factories.BottomSheetThemeData_readBack_surfaceTintColor(nativeStruct);
  }
  public double elevation() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("bottomSheetThemeDataElevation not supported on web");
    return factories.BottomSheetThemeData_readBack_elevation(nativeStruct);
  }
  public Color modalBackgroundColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("bottomSheetThemeDataModalBackgroundColor", getId());
      return new Color(__nid);
    }
    return factories.BottomSheetThemeData_readBack_modalBackgroundColor(nativeStruct);
  }
  public Color modalBarrierColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("bottomSheetThemeDataModalBarrierColor", getId());
      return new Color(__nid);
    }
    return factories.BottomSheetThemeData_readBack_modalBarrierColor(nativeStruct);
  }
  public Color shadowColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("bottomSheetThemeDataShadowColor", getId());
      return new Color(__nid);
    }
    return factories.BottomSheetThemeData_readBack_shadowColor(nativeStruct);
  }
  public double modalElevation() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("bottomSheetThemeDataModalElevation not supported on web");
    return factories.BottomSheetThemeData_readBack_modalElevation(nativeStruct);
  }
  public ShapeBorder shape() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("bottomSheetThemeDataShape not supported on web");
    return factories.BottomSheetThemeData_readBack_shape(nativeStruct);
  }
  public boolean showDragHandle() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("bottomSheetThemeDataShowDragHandle not supported on web");
    return factories.BottomSheetThemeData_readBack_showDragHandle(nativeStruct);
  }
  public Color dragHandleColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("bottomSheetThemeDataDragHandleColor", getId());
      return new Color(__nid);
    }
    return factories.BottomSheetThemeData_readBack_dragHandleColor(nativeStruct);
  }
  public Clip clipBehavior() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("bottomSheetThemeDataClipBehavior not supported on web");
    return factories.BottomSheetThemeData_readBack_clipBehavior(nativeStruct);
  }
  public BoxConstraints constraints() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("bottomSheetThemeDataConstraints", getId());
      return new BoxConstraints(__nid);
    }
    return factories.BottomSheetThemeData_readBack_constraints(nativeStruct);
  }
  @Override
  public BottomSheetThemeData build() {
    return this;
  }
}
