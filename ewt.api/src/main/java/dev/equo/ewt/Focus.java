package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.FocusObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class Focus extends StatefulWidget implements FocusI {
  private MemorySegment st;
  protected Focus() {}
  Focus(MemorySegment st) {
    this.id = FocusObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget Focus");
    System.out.println("New Focus id:"+id);
  }
  Focus(int id) { this.id = id; }
  @Builder.Factory
  static Focus focusFocus(@Builder.Parameter WidgetI child, Optional<Boolean> autofocus, Optional<Consumer<Boolean>> onFocusChange, Optional<Boolean> canRequestFocus, Optional<Boolean> skipTraversal, Optional<Boolean> descendantsAreFocusable, Optional<Boolean> descendantsAreTraversable, Optional<Boolean> includeSemantics, Optional<String> debugLabel) {
    var st = factories.focusFocus(child.build(),
      autofocus,
      onFocusChange,
      canRequestFocus,
      skipTraversal,
      descendantsAreFocusable,
      descendantsAreTraversable,
      includeSemantics,
      debugLabel);
    if (st == null) throw new RuntimeException("Failed to created widget Focus");
    return new Focus(st);
  }
  public static FocusFocusBuilder focus(WidgetI child) {
    return FocusFocusBuilder.focusFocus(child);
  }
  public static boolean isAt(BuildContextI context) {
    int id = factories.focusIsAt(context.build());
    if (id <= 0) throw new RuntimeException("Failed to created widget bool");
    System.out.println("New bool id:"+id);
    return intToBool(id);
  }
  public Widget child() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("focusChild not supported on web");
    return new Widget(FocusObjSt.child(st)) {};
  }
  public boolean autofocus() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("focusAutofocus not supported on web");
    return intToBool(FocusObjSt.autofocus(st));
  }
  public boolean includeSemantics() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("focusIncludeSemantics not supported on web");
    return intToBool(FocusObjSt.includeSemantics(st));
  }
  public boolean canRequestFocus() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("focusCanRequestFocus not supported on web");
    return intToBool(FocusObjSt.canRequestFocus(st));
  }
  public boolean skipTraversal() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("focusSkipTraversal not supported on web");
    return intToBool(FocusObjSt.skipTraversal(st));
  }
  public boolean descendantsAreFocusable() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("focusDescendantsAreFocusable not supported on web");
    return intToBool(FocusObjSt.descendantsAreFocusable(st));
  }
  public boolean descendantsAreTraversable() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("focusDescendantsAreTraversable not supported on web");
    return intToBool(FocusObjSt.descendantsAreTraversable(st));
  }
  public String debugLabel() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("focusDebugLabel not supported on web");
    return FocusObjSt.debugLabel(st).getString(0);
  }
  @Override
  public Focus build() {
    return this;
  }
}
