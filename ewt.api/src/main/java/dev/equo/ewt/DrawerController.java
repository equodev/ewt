package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.DrawerControllerObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class DrawerController extends StatefulWidget implements DrawerControllerI {
  private MemorySegment st;
  protected DrawerController() {}
  DrawerController(MemorySegment st) {
    this.id = DrawerControllerObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget DrawerController");
    System.out.println("New DrawerController id:"+id);
  }
  DrawerController(int id) { this.id = id; }
  @Builder.Factory
  static DrawerController drawerControllerDrawerController(@Builder.Parameter WidgetI child, @Builder.Parameter DrawerAlignment alignment, Optional<Boolean> isDrawerOpen, Optional<Consumer<Boolean>> drawerCallback, Optional<DragStartBehavior> dragStartBehavior, Optional<ColorI> scrimColor, OptionalDouble edgeDragWidth, Optional<Boolean> enableOpenDragGesture, Optional<Boolean> drawerBarrierDismissible) {
    var st = factories.drawerControllerDrawerController(child.build(),
      alignment,
      isDrawerOpen,
      drawerCallback,
      dragStartBehavior,
      scrimColor.map(ColorI::build),
      edgeDragWidth,
      enableOpenDragGesture,
      drawerBarrierDismissible);
    if (st == null) throw new RuntimeException("Failed to created widget DrawerController");
    return new DrawerController(st);
  }
  public static DrawerControllerDrawerControllerBuilder drawerController(WidgetI child, DrawerAlignment alignment) {
    return DrawerControllerDrawerControllerBuilder.drawerControllerDrawerController(child, alignment);
  }
  public static DrawerController maybeOf(BuildContextI context) {
    var st = factories.drawerControllerMaybeOf(context.build());
    if (st == null) throw new RuntimeException("Failed to created widget DrawerController");
    return new DrawerController(st);
  }
  public static DrawerController of(BuildContextI context) {
    var st = factories.drawerControllerOf(context.build());
    if (st == null) throw new RuntimeException("Failed to created widget DrawerController");
    return new DrawerController(st);
  }
  public Widget child() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("drawerControllerChild not supported on web");
    return new Widget(DrawerControllerObjSt.child(st)) {};
  }
  public DrawerAlignment alignment() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("drawerControllerAlignment not supported on web");
    return DrawerAlignment.values()[DrawerControllerObjSt.alignment(st)];
  }
  public boolean drawerBarrierDismissible() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("drawerControllerDrawerBarrierDismissible not supported on web");
    return intToBool(DrawerControllerObjSt.drawerBarrierDismissible(st));
  }
  public DragStartBehavior dragStartBehavior() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("drawerControllerDragStartBehavior not supported on web");
    return DragStartBehavior.values()[DrawerControllerObjSt.dragStartBehavior(st)];
  }
  public Color scrimColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("drawerControllerScrimColor", getId());
      return new Color(__nid);
    }
    return new Color(DrawerControllerObjSt.scrimColor(st));
  }
  public boolean enableOpenDragGesture() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("drawerControllerEnableOpenDragGesture not supported on web");
    return intToBool(DrawerControllerObjSt.enableOpenDragGesture(st));
  }
  public double edgeDragWidth() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("drawerControllerEdgeDragWidth not supported on web");
    return DrawerControllerObjSt.edgeDragWidth(st);
  }
  public boolean isDrawerOpen() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("drawerControllerIsDrawerOpen not supported on web");
    return intToBool(DrawerControllerObjSt.isDrawerOpen(st));
  }
  @Override
  public DrawerController build() {
    return this;
  }
}
