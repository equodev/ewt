package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class DrawerController extends StatefulWidget implements DrawerControllerI {
  protected DrawerController() {}
  DrawerController(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget DrawerController");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static DrawerController drawerControllerDrawerController(@Builder.Parameter WidgetI child, @Builder.Parameter DrawerAlignment alignment, Optional<Boolean> isDrawerOpen, Optional<Consumer<Boolean>> drawerCallback, Optional<DragStartBehavior> dragStartBehavior, Optional<ColorI> scrimColor, OptionalDouble edgeDragWidth, Optional<Boolean> enableOpenDragGesture, Optional<Boolean> drawerBarrierDismissible) {
    int id = factories.drawerControllerDrawerController(child.build(),
      alignment,
      isDrawerOpen,
      drawerCallback,
      dragStartBehavior,
      scrimColor.map(ColorI::build),
      edgeDragWidth,
      enableOpenDragGesture,
      drawerBarrierDismissible);
    if (id <= 0) throw new RuntimeException("Failed to created widget DrawerController");
    return new DrawerController(id);
  }
  public static DrawerControllerDrawerControllerBuilder drawerController(WidgetI child, DrawerAlignment alignment) {
    return DrawerControllerDrawerControllerBuilder.drawerControllerDrawerController(child, alignment);
  }
  public static DrawerController maybeOf(BuildContextI context) {
    int id = factories.drawerControllerMaybeOf(context.build());
    if (id <= 0) throw new RuntimeException("Failed to created widget DrawerController");
    return new DrawerController(id);
  }
  public static DrawerController of(BuildContextI context) {
    int id = factories.drawerControllerOf(context.build());
    if (id <= 0) throw new RuntimeException("Failed to created widget DrawerController");
    return new DrawerController(id);
  }
  public Widget child() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("drawerControllerChild not supported on web");
    return factories.DrawerController_readBack_child(nativeStruct);
  }
  public DrawerAlignment alignment() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("drawerControllerAlignment not supported on web");
    return factories.DrawerController_readBack_alignment(nativeStruct);
  }
  public boolean drawerBarrierDismissible() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("drawerControllerDrawerBarrierDismissible not supported on web");
    return factories.DrawerController_readBack_drawerBarrierDismissible(nativeStruct);
  }
  public DragStartBehavior dragStartBehavior() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("drawerControllerDragStartBehavior not supported on web");
    return factories.DrawerController_readBack_dragStartBehavior(nativeStruct);
  }
  public Color scrimColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("drawerControllerScrimColor", getId());
      return new Color(__nid);
    }
    return factories.DrawerController_readBack_scrimColor(nativeStruct);
  }
  public boolean enableOpenDragGesture() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("drawerControllerEnableOpenDragGesture not supported on web");
    return factories.DrawerController_readBack_enableOpenDragGesture(nativeStruct);
  }
  public double edgeDragWidth() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("drawerControllerEdgeDragWidth not supported on web");
    return factories.DrawerController_readBack_edgeDragWidth(nativeStruct);
  }
  public boolean isDrawerOpen() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("drawerControllerIsDrawerOpen not supported on web");
    return factories.DrawerController_readBack_isDrawerOpen(nativeStruct);
  }
  @Override
  public DrawerController build() {
    return this;
  }
}
