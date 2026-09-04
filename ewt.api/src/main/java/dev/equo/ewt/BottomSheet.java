package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.BottomSheetObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class BottomSheet extends StatefulWidget implements BottomSheetI {
  private MemorySegment st;
  protected BottomSheet() {}
  BottomSheet(MemorySegment st) {
    this.id = BottomSheetObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget BottomSheet");
    System.out.println("New BottomSheet id:"+id);
  }
  BottomSheet(int id) { this.id = id; }
  @Builder.Factory
  static BottomSheet bottomSheetBottomSheet(Optional<AnimationControllerI> animationController, Optional<Boolean> enableDrag, Optional<Boolean> showDragHandle, Optional<ColorI> dragHandleColor, Optional<Consumer<DragStartDetails>> onDragStart, Optional<BiConsumer<DragEndDetails, Boolean>> onDragEnd, Optional<ColorI> backgroundColor, Optional<ColorI> shadowColor, OptionalDouble elevation, Optional<ShapeBorderI> shape, Optional<Clip> clipBehavior, Optional<BoxConstraintsI> constraints, Runnable onClosing, Function<BuildContext, Widget> builder) {
    var st = factories.bottomSheetBottomSheet(animationController.map(AnimationControllerI::build),
      enableDrag,
      showDragHandle,
      dragHandleColor.map(ColorI::build),
      onDragStart,
      onDragEnd,
      backgroundColor.map(ColorI::build),
      shadowColor.map(ColorI::build),
      elevation,
      shape.map(ShapeBorderI::build),
      clipBehavior,
      constraints.map(BoxConstraintsI::build),
      onClosing,
      builder);
    if (st == null) throw new RuntimeException("Failed to created widget BottomSheet");
    return new BottomSheet(st);
  }
  public static BottomSheetBottomSheetBuilder bottomSheet() {
    return BottomSheetBottomSheetBuilder.bottomSheetBottomSheet();
  }
  public static AnimationController createAnimationController(TickerProviderI vsync) {
    int id = factories.bottomSheetCreateAnimationController(vsync.build());
    if (id <= 0) throw new RuntimeException("Failed to created widget AnimationController");
    System.out.println("New AnimationController id:"+id);
    return new AnimationController(id);
  }
  public AnimationController animationController() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("bottomSheetAnimationController", getId());
      return new AnimationController(__nid);
    }
    return new AnimationController(BottomSheetObjSt.animationController(st));
  }
  public boolean enableDrag() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("bottomSheetEnableDrag not supported on web");
    return intToBool(BottomSheetObjSt.enableDrag(st));
  }
  public boolean showDragHandle() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("bottomSheetShowDragHandle not supported on web");
    return intToBool(BottomSheetObjSt.showDragHandle(st));
  }
  public Color dragHandleColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("bottomSheetDragHandleColor", getId());
      return new Color(__nid);
    }
    return new Color(BottomSheetObjSt.dragHandleColor(st));
  }
  public Color backgroundColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("bottomSheetBackgroundColor", getId());
      return new Color(__nid);
    }
    return new Color(BottomSheetObjSt.backgroundColor(st));
  }
  public Color shadowColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("bottomSheetShadowColor", getId());
      return new Color(__nid);
    }
    return new Color(BottomSheetObjSt.shadowColor(st));
  }
  public double elevation() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("bottomSheetElevation not supported on web");
    return BottomSheetObjSt.elevation(st);
  }
  public ShapeBorder shape() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("bottomSheetShape not supported on web");
    return new ShapeBorder(BottomSheetObjSt.shape(st)) {};
  }
  public Clip clipBehavior() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("bottomSheetClipBehavior not supported on web");
    return Clip.values()[BottomSheetObjSt.clipBehavior(st)];
  }
  public BoxConstraints constraints() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("bottomSheetConstraints", getId());
      java.lang.foreign.MemorySegment __st = dev.equo.ewt.ffm.BoxConstraintsObjSt.allocate(__s.arena);
      dev.equo.ewt.ffm.BoxConstraintsObjSt.id(__st, __nid);
      return new BoxConstraints(__st);
    }
    return new BoxConstraints(BottomSheetObjSt.constraints(st));
  }
  @Override
  public BottomSheet build() {
    return this;
  }
}
