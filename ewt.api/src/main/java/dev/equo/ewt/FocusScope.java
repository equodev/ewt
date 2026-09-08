package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.FocusScopeObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class FocusScope extends Focus implements FocusScopeI {
  private MemorySegment st;
  protected FocusScope() {}
  FocusScope(MemorySegment st) {
    this.id = FocusScopeObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget FocusScope");
    System.out.println("New FocusScope id:"+id);
  }
  FocusScope(int id) { this.id = id; }
  @Builder.Factory
  static FocusScope focusScopeFocusScope(@Builder.Parameter WidgetI child, Optional<Boolean> autofocus, Optional<Consumer<Boolean>> onFocusChange, Optional<Boolean> canRequestFocus, Optional<Boolean> skipTraversal, Optional<String> debugLabel, Optional<Boolean> includeSemantics, Optional<Boolean> descendantsAreFocusable, Optional<Boolean> descendantsAreTraversable) {
    var st = factories.focusScopeFocusScope(child.build(),
      autofocus,
      onFocusChange,
      canRequestFocus,
      skipTraversal,
      debugLabel,
      includeSemantics,
      descendantsAreFocusable,
      descendantsAreTraversable);
    if (st == null) throw new RuntimeException("Failed to created widget FocusScope");
    return new FocusScope(st);
  }
  public static FocusScopeFocusScopeBuilder focusScope(WidgetI child) {
    return FocusScopeFocusScopeBuilder.focusScopeFocusScope(child);
  }
  @Override
  public FocusScope build() {
    return this;
  }
}
