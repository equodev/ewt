package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.FocusableActionDetectorObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class FocusableActionDetector extends StatefulWidget implements FocusableActionDetectorI {
  private MemorySegment st;
  protected FocusableActionDetector() {}
  FocusableActionDetector(MemorySegment st) {
    this.id = FocusableActionDetectorObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget FocusableActionDetector");
    System.out.println("New FocusableActionDetector id:"+id);
  }
  FocusableActionDetector(int id) { this.id = id; }
  @Builder.Factory
  static FocusableActionDetector focusableActionDetectorFocusableActionDetector(Optional<Boolean> enabled, Optional<Boolean> autofocus, Optional<Boolean> descendantsAreFocusable, Optional<Boolean> descendantsAreTraversable, Optional<Consumer<Boolean>> onShowFocusHighlight, Optional<Consumer<Boolean>> onShowHoverHighlight, Optional<Consumer<Boolean>> onFocusChange, Optional<Boolean> includeFocusSemantics, WidgetI child) {
    var st = factories.focusableActionDetectorFocusableActionDetector(enabled,
      autofocus,
      descendantsAreFocusable,
      descendantsAreTraversable,
      onShowFocusHighlight,
      onShowHoverHighlight,
      onFocusChange,
      includeFocusSemantics,
      child.build());
    if (st == null) throw new RuntimeException("Failed to created widget FocusableActionDetector");
    return new FocusableActionDetector(st);
  }
  public static FocusableActionDetectorFocusableActionDetectorBuilder focusableActionDetector() {
    return FocusableActionDetectorFocusableActionDetectorBuilder.focusableActionDetectorFocusableActionDetector();
  }
  public boolean enabled() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("focusableActionDetectorEnabled not supported on web");
    return intToBool(FocusableActionDetectorObjSt.enabled(st));
  }
  public boolean autofocus() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("focusableActionDetectorAutofocus not supported on web");
    return intToBool(FocusableActionDetectorObjSt.autofocus(st));
  }
  public boolean descendantsAreFocusable() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("focusableActionDetectorDescendantsAreFocusable not supported on web");
    return intToBool(FocusableActionDetectorObjSt.descendantsAreFocusable(st));
  }
  public boolean descendantsAreTraversable() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("focusableActionDetectorDescendantsAreTraversable not supported on web");
    return intToBool(FocusableActionDetectorObjSt.descendantsAreTraversable(st));
  }
  public boolean includeFocusSemantics() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("focusableActionDetectorIncludeFocusSemantics not supported on web");
    return intToBool(FocusableActionDetectorObjSt.includeFocusSemantics(st));
  }
  public Widget child() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("focusableActionDetectorChild not supported on web");
    return new Widget(FocusableActionDetectorObjSt.child(st)) {};
  }
  @Override
  public FocusableActionDetector build() {
    return this;
  }
}
