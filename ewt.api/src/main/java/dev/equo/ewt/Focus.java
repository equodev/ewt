package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class Focus extends StatefulWidget implements FocusI {
  protected Focus() {}
  Focus(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget Focus");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static Focus focusFocus(@Builder.Parameter WidgetI child, Optional<Boolean> autofocus, Optional<Consumer<Boolean>> onFocusChange, Optional<Boolean> canRequestFocus, Optional<Boolean> skipTraversal, Optional<Boolean> descendantsAreFocusable, Optional<Boolean> descendantsAreTraversable, Optional<Boolean> includeSemantics, Optional<String> debugLabel) {
    int id = factories.focusFocus(child.build(),
      autofocus,
      onFocusChange,
      canRequestFocus,
      skipTraversal,
      descendantsAreFocusable,
      descendantsAreTraversable,
      includeSemantics,
      debugLabel);
    if (id <= 0) throw new RuntimeException("Failed to created widget Focus");
    return new Focus(id);
  }
  public static FocusFocusBuilder focus(WidgetI child) {
    return FocusFocusBuilder.focusFocus(child);
  }
  public static boolean isAt(BuildContextI context) {
    var id = factories.focusIsAt(context.build());
    if (id <= 0) throw new RuntimeException("Failed to created widget bool");
    return intToBool(id);
  }
  public Widget child() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("focusChild not supported on web");
    return factories.Focus_readBack_child(nativeStruct);
  }
  public boolean autofocus() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("focusAutofocus not supported on web");
    return factories.Focus_readBack_autofocus(nativeStruct);
  }
  public boolean includeSemantics() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("focusIncludeSemantics not supported on web");
    return factories.Focus_readBack_includeSemantics(nativeStruct);
  }
  public boolean canRequestFocus() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("focusCanRequestFocus not supported on web");
    return factories.Focus_readBack_canRequestFocus(nativeStruct);
  }
  public boolean skipTraversal() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("focusSkipTraversal not supported on web");
    return factories.Focus_readBack_skipTraversal(nativeStruct);
  }
  public boolean descendantsAreFocusable() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("focusDescendantsAreFocusable not supported on web");
    return factories.Focus_readBack_descendantsAreFocusable(nativeStruct);
  }
  public boolean descendantsAreTraversable() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("focusDescendantsAreTraversable not supported on web");
    return factories.Focus_readBack_descendantsAreTraversable(nativeStruct);
  }
  public String debugLabel() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("focusDebugLabel not supported on web");
    return factories.Focus_readBack_debugLabel(nativeStruct);
  }
  @Override
  public Focus build() {
    return this;
  }
}
