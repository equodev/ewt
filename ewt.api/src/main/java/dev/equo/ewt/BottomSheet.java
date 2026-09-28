package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class BottomSheet extends StatefulWidget implements BottomSheetI {
  protected BottomSheet() {}
  BottomSheet(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget BottomSheet");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static BottomSheet bottomSheetBottomSheet(Optional<AnimationControllerI> animationController, Optional<Boolean> enableDrag, Optional<Boolean> showDragHandle, Optional<ColorI> dragHandleColor, Optional<Consumer<DragStartDetails>> onDragStart, Optional<BiConsumer<DragEndDetails, Boolean>> onDragEnd, Optional<ColorI> backgroundColor, Optional<ColorI> shadowColor, OptionalDouble elevation, Optional<ShapeBorderI> shape, Optional<Clip> clipBehavior, Optional<BoxConstraintsI> constraints, Runnable onClosing, Function<BuildContext, Widget> builder) {
    int id = factories.bottomSheetBottomSheet(animationController.map(AnimationControllerI::build),
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
    if (id <= 0) throw new RuntimeException("Failed to created widget BottomSheet");
    return new BottomSheet(id);
  }
  public static BottomSheetBottomSheetBuilder bottomSheet() {
    return BottomSheetBottomSheetBuilder.bottomSheetBottomSheet();
  }
  public static AnimationController createAnimationController(TickerProviderI vsync) {
    var id = factories.bottomSheetCreateAnimationController(vsync.build());
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
    return factories.BottomSheet_readBack_animationController(nativeStruct);
  }
  public boolean enableDrag() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("bottomSheetEnableDrag not supported on web");
    return factories.BottomSheet_readBack_enableDrag(nativeStruct);
  }
  public boolean showDragHandle() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("bottomSheetShowDragHandle not supported on web");
    return factories.BottomSheet_readBack_showDragHandle(nativeStruct);
  }
  public Color dragHandleColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("bottomSheetDragHandleColor", getId());
      return new Color(__nid);
    }
    return factories.BottomSheet_readBack_dragHandleColor(nativeStruct);
  }
  public Color backgroundColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("bottomSheetBackgroundColor", getId());
      return new Color(__nid);
    }
    return factories.BottomSheet_readBack_backgroundColor(nativeStruct);
  }
  public Color shadowColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("bottomSheetShadowColor", getId());
      return new Color(__nid);
    }
    return factories.BottomSheet_readBack_shadowColor(nativeStruct);
  }
  public double elevation() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("bottomSheetElevation not supported on web");
    return factories.BottomSheet_readBack_elevation(nativeStruct);
  }
  public ShapeBorder shape() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("bottomSheetShape not supported on web");
    return factories.BottomSheet_readBack_shape(nativeStruct);
  }
  public Clip clipBehavior() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("bottomSheetClipBehavior not supported on web");
    return factories.BottomSheet_readBack_clipBehavior(nativeStruct);
  }
  public BoxConstraints constraints() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("bottomSheetConstraints", getId());
      return new BoxConstraints(__nid);
    }
    return factories.BottomSheet_readBack_constraints(nativeStruct);
  }
  @Override
  public BottomSheet build() {
    return this;
  }
}
