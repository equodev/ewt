package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class FocusableActionDetector extends StatefulWidget implements FocusableActionDetectorI {
  protected FocusableActionDetector() {}
  FocusableActionDetector(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget FocusableActionDetector");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static FocusableActionDetector focusableActionDetectorFocusableActionDetector(Optional<Boolean> enabled, Optional<Boolean> autofocus, Optional<Boolean> descendantsAreFocusable, Optional<Boolean> descendantsAreTraversable, Optional<Consumer<Boolean>> onShowFocusHighlight, Optional<Consumer<Boolean>> onShowHoverHighlight, Optional<Consumer<Boolean>> onFocusChange, Optional<Boolean> includeFocusSemantics, WidgetI child) {
    int id = factories.focusableActionDetectorFocusableActionDetector(enabled,
      autofocus,
      descendantsAreFocusable,
      descendantsAreTraversable,
      onShowFocusHighlight,
      onShowHoverHighlight,
      onFocusChange,
      includeFocusSemantics,
      child.build());
    if (id <= 0) throw new RuntimeException("Failed to created widget FocusableActionDetector");
    return new FocusableActionDetector(id);
  }
  public static FocusableActionDetectorFocusableActionDetectorBuilder focusableActionDetector() {
    return FocusableActionDetectorFocusableActionDetectorBuilder.focusableActionDetectorFocusableActionDetector();
  }
  public boolean enabled() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("focusableActionDetectorEnabled not supported on web");
    return factories.FocusableActionDetector_readBack_enabled(nativeStruct);
  }
  public boolean autofocus() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("focusableActionDetectorAutofocus not supported on web");
    return factories.FocusableActionDetector_readBack_autofocus(nativeStruct);
  }
  public boolean descendantsAreFocusable() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("focusableActionDetectorDescendantsAreFocusable not supported on web");
    return factories.FocusableActionDetector_readBack_descendantsAreFocusable(nativeStruct);
  }
  public boolean descendantsAreTraversable() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("focusableActionDetectorDescendantsAreTraversable not supported on web");
    return factories.FocusableActionDetector_readBack_descendantsAreTraversable(nativeStruct);
  }
  public boolean includeFocusSemantics() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("focusableActionDetectorIncludeFocusSemantics not supported on web");
    return factories.FocusableActionDetector_readBack_includeFocusSemantics(nativeStruct);
  }
  public Widget child() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("focusableActionDetectorChild not supported on web");
    return factories.FocusableActionDetector_readBack_child(nativeStruct);
  }
  @Override
  public FocusableActionDetector build() {
    return this;
  }
}
