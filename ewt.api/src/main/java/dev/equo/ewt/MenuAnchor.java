package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class MenuAnchor extends StatefulWidget implements MenuAnchorI {
  protected MenuAnchor() {}
  MenuAnchor(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget MenuAnchor");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static MenuAnchor menuAnchorMenuAnchor(Optional<OffsetI> alignmentOffset, Optional<EdgeInsetsGeometryI> reservedPadding, Optional<Clip> clipBehavior, Optional<Boolean> anchorTapClosesMenu, Optional<Boolean> consumeOutsideTap, Optional<Runnable> onOpen, Optional<Runnable> onClose, Optional<Boolean> crossAxisUnconstrained, Optional<Boolean> useRootOverlay, Optional<Boolean> animated, Optional<Consumer<AnimationStatus>> onAnimationStatusChanged, List<WidgetI> menuChildren, Optional<WidgetI> child) {
    int id = factories.menuAnchorMenuAnchor(alignmentOffset.map(OffsetI::build),
      reservedPadding.map(EdgeInsetsGeometryI::build),
      clipBehavior,
      anchorTapClosesMenu,
      consumeOutsideTap,
      onOpen,
      onClose,
      crossAxisUnconstrained,
      useRootOverlay,
      animated,
      onAnimationStatusChanged,
      menuChildren.stream().map(WidgetI::build).collect(java.util.stream.Collectors.toList()),
      child.map(WidgetI::build));
    if (id <= 0) throw new RuntimeException("Failed to created widget MenuAnchor");
    return new MenuAnchor(id);
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
    return factories.MenuAnchor_readBack_alignmentOffset(nativeStruct);
  }
  public Clip clipBehavior() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("menuAnchorClipBehavior not supported on web");
    return factories.MenuAnchor_readBack_clipBehavior(nativeStruct);
  }
  public boolean anchorTapClosesMenu() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("menuAnchorAnchorTapClosesMenu not supported on web");
    return factories.MenuAnchor_readBack_anchorTapClosesMenu(nativeStruct);
  }
  public boolean consumeOutsideTap() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("menuAnchorConsumeOutsideTap not supported on web");
    return factories.MenuAnchor_readBack_consumeOutsideTap(nativeStruct);
  }
  public boolean crossAxisUnconstrained() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("menuAnchorCrossAxisUnconstrained not supported on web");
    return factories.MenuAnchor_readBack_crossAxisUnconstrained(nativeStruct);
  }
  public boolean useRootOverlay() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("menuAnchorUseRootOverlay not supported on web");
    return factories.MenuAnchor_readBack_useRootOverlay(nativeStruct);
  }
  public boolean animated() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("menuAnchorAnimated not supported on web");
    return factories.MenuAnchor_readBack_animated(nativeStruct);
  }
  public Widget child() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("menuAnchorChild not supported on web");
    return factories.MenuAnchor_readBack_child(nativeStruct);
  }
  public EdgeInsetsGeometry reservedPadding() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("menuAnchorReservedPadding not supported on web");
    return factories.MenuAnchor_readBack_reservedPadding(nativeStruct);
  }
  @Override
  public MenuAnchor build() {
    return this;
  }
}
