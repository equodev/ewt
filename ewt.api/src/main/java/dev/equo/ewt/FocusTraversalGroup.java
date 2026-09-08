package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.FocusTraversalGroupObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class FocusTraversalGroup extends StatefulWidget implements FocusTraversalGroupI {
  private MemorySegment st;
  protected FocusTraversalGroup() {}
  FocusTraversalGroup(MemorySegment st) {
    this.id = FocusTraversalGroupObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget FocusTraversalGroup");
    System.out.println("New FocusTraversalGroup id:"+id);
  }
  FocusTraversalGroup(int id) { this.id = id; }
  @Builder.Factory
  static FocusTraversalGroup focusTraversalGroupFocusTraversalGroup(Optional<Boolean> descendantsAreFocusable, Optional<Boolean> descendantsAreTraversable, WidgetI child) {
    var st = factories.focusTraversalGroupFocusTraversalGroup(descendantsAreFocusable,
      descendantsAreTraversable,
      child.build());
    if (st == null) throw new RuntimeException("Failed to created widget FocusTraversalGroup");
    return new FocusTraversalGroup(st);
  }
  public static FocusTraversalGroupFocusTraversalGroupBuilder focusTraversalGroup() {
    return FocusTraversalGroupFocusTraversalGroupBuilder.focusTraversalGroupFocusTraversalGroup();
  }
  public boolean descendantsAreFocusable() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("focusTraversalGroupDescendantsAreFocusable not supported on web");
    return intToBool(FocusTraversalGroupObjSt.descendantsAreFocusable(st));
  }
  public boolean descendantsAreTraversable() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("focusTraversalGroupDescendantsAreTraversable not supported on web");
    return intToBool(FocusTraversalGroupObjSt.descendantsAreTraversable(st));
  }
  public Widget child() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("focusTraversalGroupChild not supported on web");
    return new Widget(FocusTraversalGroupObjSt.child(st)) {};
  }
  @Override
  public FocusTraversalGroup build() {
    return this;
  }
}
