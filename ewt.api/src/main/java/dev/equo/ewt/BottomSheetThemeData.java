package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.BottomSheetThemeDataObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class BottomSheetThemeData extends NativeObj.Base implements BottomSheetThemeDataI {
  private MemorySegment st;
  protected BottomSheetThemeData() {}
  BottomSheetThemeData(MemorySegment st) {
    this.id = BottomSheetThemeDataObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget BottomSheetThemeData");
    System.out.println("New BottomSheetThemeData id:"+id);
  }
  BottomSheetThemeData(int id) { this.id = id; }
  @Builder.Factory
  static BottomSheetThemeData bottomSheetThemeDataBottomSheetThemeData(Optional<ColorI> backgroundColor, Optional<ColorI> surfaceTintColor, OptionalDouble elevation, Optional<ColorI> modalBackgroundColor, Optional<ColorI> modalBarrierColor, Optional<ColorI> shadowColor, OptionalDouble modalElevation, Optional<ShapeBorderI> shape, Optional<Boolean> showDragHandle, Optional<ColorI> dragHandleColor, Optional<Clip> clipBehavior, Optional<BoxConstraintsI> constraints) {
    var st = factories.bottomSheetThemeDataBottomSheetThemeData(backgroundColor.map(ColorI::build),
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
    if (st == null) throw new RuntimeException("Failed to created widget BottomSheetThemeData");
    return new BottomSheetThemeData(st);
  }
  public static BottomSheetThemeDataBottomSheetThemeDataBuilder bottomSheetThemeData() {
    return BottomSheetThemeDataBottomSheetThemeDataBuilder.bottomSheetThemeDataBottomSheetThemeData();
  }
  public static BottomSheetThemeData lerp(BottomSheetThemeDataI a, BottomSheetThemeDataI b, double t) {
    var st = factories.bottomSheetThemeDataLerp(a.build(),
      b.build(),
      t);
    if (st == null) throw new RuntimeException("Failed to created widget BottomSheetThemeData");
    return new BottomSheetThemeData(st);
  }
  public Color backgroundColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("bottomSheetThemeDataBackgroundColor", getId());
      return new Color(__nid);
    }
    return new Color(BottomSheetThemeDataObjSt.backgroundColor(st));
  }
  public Color surfaceTintColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("bottomSheetThemeDataSurfaceTintColor", getId());
      return new Color(__nid);
    }
    return new Color(BottomSheetThemeDataObjSt.surfaceTintColor(st));
  }
  public double elevation() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("bottomSheetThemeDataElevation not supported on web");
    return BottomSheetThemeDataObjSt.elevation(st);
  }
  public Color modalBackgroundColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("bottomSheetThemeDataModalBackgroundColor", getId());
      return new Color(__nid);
    }
    return new Color(BottomSheetThemeDataObjSt.modalBackgroundColor(st));
  }
  public Color modalBarrierColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("bottomSheetThemeDataModalBarrierColor", getId());
      return new Color(__nid);
    }
    return new Color(BottomSheetThemeDataObjSt.modalBarrierColor(st));
  }
  public Color shadowColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("bottomSheetThemeDataShadowColor", getId());
      return new Color(__nid);
    }
    return new Color(BottomSheetThemeDataObjSt.shadowColor(st));
  }
  public double modalElevation() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("bottomSheetThemeDataModalElevation not supported on web");
    return BottomSheetThemeDataObjSt.modalElevation(st);
  }
  public ShapeBorder shape() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("bottomSheetThemeDataShape not supported on web");
    return new ShapeBorder(BottomSheetThemeDataObjSt.shape(st)) {};
  }
  public boolean showDragHandle() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("bottomSheetThemeDataShowDragHandle not supported on web");
    return intToBool(BottomSheetThemeDataObjSt.showDragHandle(st));
  }
  public Color dragHandleColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("bottomSheetThemeDataDragHandleColor", getId());
      return new Color(__nid);
    }
    return new Color(BottomSheetThemeDataObjSt.dragHandleColor(st));
  }
  public Clip clipBehavior() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("bottomSheetThemeDataClipBehavior not supported on web");
    return Clip.values()[BottomSheetThemeDataObjSt.clipBehavior(st)];
  }
  public BoxConstraints constraints() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("bottomSheetThemeDataConstraints", getId());
      java.lang.foreign.MemorySegment __st = dev.equo.ewt.ffm.BoxConstraintsObjSt.allocate(__s.arena);
      dev.equo.ewt.ffm.BoxConstraintsObjSt.id(__st, __nid);
      return new BoxConstraints(__st);
    }
    return new BoxConstraints(BottomSheetThemeDataObjSt.constraints(st));
  }
  @Override
  public BottomSheetThemeData build() {
    return this;
  }
}
