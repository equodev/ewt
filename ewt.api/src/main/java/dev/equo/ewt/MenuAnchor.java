package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.MenuAnchorObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class MenuAnchor extends StatefulWidget implements MenuAnchorI {
  private MemorySegment st;
  protected MenuAnchor() {}
  MenuAnchor(MemorySegment st) {
    this.id = MenuAnchorObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget MenuAnchor");
    System.out.println("New MenuAnchor id:"+id);
  }
  MenuAnchor(int id) { this.id = id; }
  @Builder.Factory
  static MenuAnchor menuAnchorMenuAnchor(Optional<OffsetI> alignmentOffset, Optional<Clip> clipBehavior, Optional<Boolean> anchorTapClosesMenu, Optional<Boolean> consumeOutsideTap, Optional<Runnable> onOpen, Optional<Runnable> onClose, Optional<Boolean> crossAxisUnconstrained, Optional<Boolean> useRootOverlay, List<WidgetI> menuChildren, Optional<WidgetI> child) {
    var st = factories.menuAnchorMenuAnchor(alignmentOffset.map(OffsetI::build),
      clipBehavior,
      anchorTapClosesMenu,
      consumeOutsideTap,
      onOpen,
      onClose,
      crossAxisUnconstrained,
      useRootOverlay,
      menuChildren.stream().map(WidgetI::build).toList(),
      child.map(WidgetI::build));
    if (st == null) throw new RuntimeException("Failed to created widget MenuAnchor");
    return new MenuAnchor(st);
  }
  public static MenuAnchorMenuAnchorBuilder menuAnchor() {
    return MenuAnchorMenuAnchorBuilder.menuAnchorMenuAnchor();
  }
  public Offset alignmentOffset() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("menuAnchorAlignmentOffset", getId());
      return new Offset(__nid);
    }
    return new Offset(MenuAnchorObjSt.alignmentOffset(st));
  }
  public Clip clipBehavior() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("menuAnchorClipBehavior not supported on web");
    return Clip.values()[MenuAnchorObjSt.clipBehavior(st)];
  }
  public boolean anchorTapClosesMenu() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("menuAnchorAnchorTapClosesMenu not supported on web");
    return intToBool(MenuAnchorObjSt.anchorTapClosesMenu(st));
  }
  public boolean consumeOutsideTap() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("menuAnchorConsumeOutsideTap not supported on web");
    return intToBool(MenuAnchorObjSt.consumeOutsideTap(st));
  }
  public boolean crossAxisUnconstrained() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("menuAnchorCrossAxisUnconstrained not supported on web");
    return intToBool(MenuAnchorObjSt.crossAxisUnconstrained(st));
  }
  public boolean useRootOverlay() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("menuAnchorUseRootOverlay not supported on web");
    return intToBool(MenuAnchorObjSt.useRootOverlay(st));
  }
  public Widget child() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("menuAnchorChild not supported on web");
    return new Widget(MenuAnchorObjSt.child(st)) {};
  }
  @Override
  public MenuAnchor build() {
    return this;
  }
}
