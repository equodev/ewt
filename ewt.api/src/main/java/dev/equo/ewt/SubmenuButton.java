package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class SubmenuButton extends StatefulWidget implements SubmenuButtonI {
  protected SubmenuButton() {}
  SubmenuButton(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget SubmenuButton");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static SubmenuButton submenuButtonSubmenuButton(Optional<Consumer<Boolean>> onHover, Optional<Consumer<Boolean>> onFocusChange, Optional<Runnable> onOpen, Optional<Runnable> onClose, Optional<OffsetI> alignmentOffset, Optional<Clip> clipBehavior, Optional<WidgetI> leadingIcon, Optional<WidgetI> trailingIcon, Optional<WidgetI> submenuIcon, Optional<Boolean> useRootOverlay, Optional<DurationI> hoverOpenDelay, Optional<Boolean> animated, Optional<Consumer<AnimationStatus>> onAnimationStatusChanged, List<WidgetI> menuChildren, Optional<WidgetI> child) {
    int id = factories.submenuButtonSubmenuButton(onHover,
      onFocusChange,
      onOpen,
      onClose,
      alignmentOffset.map(OffsetI::build),
      clipBehavior,
      leadingIcon.map(WidgetI::build),
      trailingIcon.map(WidgetI::build),
      submenuIcon.map(WidgetI::build),
      useRootOverlay,
      hoverOpenDelay.map(DurationI::build),
      animated,
      onAnimationStatusChanged,
      menuChildren.stream().map(WidgetI::build).collect(java.util.stream.Collectors.toList()),
      child.map(WidgetI::build));
    if (id <= 0) throw new RuntimeException("Failed to created widget SubmenuButton");
    return new SubmenuButton(id);
  }
  public static SubmenuButtonSubmenuButtonBuilder submenuButton() {
    return SubmenuButtonSubmenuButtonBuilder.submenuButtonSubmenuButton();
  }
  public Offset alignmentOffset() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("submenuButtonAlignmentOffset", getId());
      return new Offset(__nid);
    }
    return factories.SubmenuButton_readBack_alignmentOffset(nativeStruct);
  }
  public Clip clipBehavior() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("submenuButtonClipBehavior not supported on web");
    return factories.SubmenuButton_readBack_clipBehavior(nativeStruct);
  }
  public Widget leadingIcon() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("submenuButtonLeadingIcon not supported on web");
    return factories.SubmenuButton_readBack_leadingIcon(nativeStruct);
  }
  public Widget trailingIcon() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("submenuButtonTrailingIcon not supported on web");
    return factories.SubmenuButton_readBack_trailingIcon(nativeStruct);
  }
  public boolean useRootOverlay() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("submenuButtonUseRootOverlay not supported on web");
    return factories.SubmenuButton_readBack_useRootOverlay(nativeStruct);
  }
  public Duration hoverOpenDelay() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("submenuButtonHoverOpenDelay", getId());
      return new Duration(__nid);
    }
    return factories.SubmenuButton_readBack_hoverOpenDelay(nativeStruct);
  }
  public boolean animated() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("submenuButtonAnimated not supported on web");
    return factories.SubmenuButton_readBack_animated(nativeStruct);
  }
  public Widget child() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("submenuButtonChild not supported on web");
    return factories.SubmenuButton_readBack_child(nativeStruct);
  }
  @Override
  public SubmenuButton build() {
    return this;
  }
}
