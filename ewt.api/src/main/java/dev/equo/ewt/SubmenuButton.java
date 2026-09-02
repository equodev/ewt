package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.SubmenuButtonObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class SubmenuButton extends StatefulWidget implements SubmenuButtonI {
  private MemorySegment st;
  protected SubmenuButton() {}
  SubmenuButton(MemorySegment st) {
    this.id = SubmenuButtonObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget SubmenuButton");
    System.out.println("New SubmenuButton id:"+id);
  }
  SubmenuButton(int id) { this.id = id; }
  @Builder.Factory
  static SubmenuButton submenuButtonSubmenuButton(Optional<Consumer<Boolean>> onHover, Optional<Consumer<Boolean>> onFocusChange, Optional<Runnable> onOpen, Optional<Runnable> onClose, Optional<OffsetI> alignmentOffset, Optional<Clip> clipBehavior, Optional<WidgetI> leadingIcon, Optional<WidgetI> trailingIcon, Optional<WidgetI> submenuIcon, Optional<Boolean> useRootOverlay, List<WidgetI> menuChildren, Optional<WidgetI> child) {
    var st = factories.submenuButtonSubmenuButton(onHover,
      onFocusChange,
      onOpen,
      onClose,
      alignmentOffset.map(OffsetI::build),
      clipBehavior,
      leadingIcon.map(WidgetI::build),
      trailingIcon.map(WidgetI::build),
      submenuIcon.map(WidgetI::build),
      useRootOverlay,
      menuChildren.stream().map(WidgetI::build).toList(),
      child.map(WidgetI::build));
    if (st == null) throw new RuntimeException("Failed to created widget SubmenuButton");
    return new SubmenuButton(st);
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
    return new Offset(SubmenuButtonObjSt.alignmentOffset(st));
  }
  public Clip clipBehavior() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("submenuButtonClipBehavior not supported on web");
    return Clip.values()[SubmenuButtonObjSt.clipBehavior(st)];
  }
  public Widget leadingIcon() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("submenuButtonLeadingIcon not supported on web");
    return new Widget(SubmenuButtonObjSt.leadingIcon(st)) {};
  }
  public Widget trailingIcon() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("submenuButtonTrailingIcon not supported on web");
    return new Widget(SubmenuButtonObjSt.trailingIcon(st)) {};
  }
  public boolean useRootOverlay() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("submenuButtonUseRootOverlay not supported on web");
    return intToBool(SubmenuButtonObjSt.useRootOverlay(st));
  }
  public Widget child() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("submenuButtonChild not supported on web");
    return new Widget(SubmenuButtonObjSt.child(st)) {};
  }
  @Override
  public SubmenuButton build() {
    return this;
  }
}
