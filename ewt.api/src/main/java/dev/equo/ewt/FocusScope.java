package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class FocusScope extends Focus implements FocusScopeI {
  protected FocusScope() {}
  FocusScope(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget FocusScope");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static FocusScope focusScopeFocusScope(@Builder.Parameter WidgetI child, Optional<Boolean> autofocus, Optional<Consumer<Boolean>> onFocusChange, Optional<Boolean> canRequestFocus, Optional<Boolean> skipTraversal, Optional<String> debugLabel, Optional<Boolean> includeSemantics, Optional<Boolean> descendantsAreFocusable, Optional<Boolean> descendantsAreTraversable) {
    int id = factories.focusScopeFocusScope(child.build(),
      autofocus,
      onFocusChange,
      canRequestFocus,
      skipTraversal,
      debugLabel,
      includeSemantics,
      descendantsAreFocusable,
      descendantsAreTraversable);
    if (id <= 0) throw new RuntimeException("Failed to created widget FocusScope");
    return new FocusScope(id);
  }
  public static FocusScopeFocusScopeBuilder focusScope(WidgetI child) {
    return FocusScopeFocusScopeBuilder.focusScopeFocusScope(child);
  }
  @Override
  public FocusScope build() {
    return this;
  }
}
