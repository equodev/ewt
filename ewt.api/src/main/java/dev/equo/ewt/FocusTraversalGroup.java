package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class FocusTraversalGroup extends StatefulWidget implements FocusTraversalGroupI {
  protected FocusTraversalGroup() {}
  FocusTraversalGroup(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget FocusTraversalGroup");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static FocusTraversalGroup focusTraversalGroupFocusTraversalGroup(Optional<Boolean> descendantsAreFocusable, Optional<Boolean> descendantsAreTraversable, WidgetI child) {
    int id = factories.focusTraversalGroupFocusTraversalGroup(descendantsAreFocusable,
      descendantsAreTraversable,
      child.build());
    if (id <= 0) throw new RuntimeException("Failed to created widget FocusTraversalGroup");
    return new FocusTraversalGroup(id);
  }
  public static FocusTraversalGroupFocusTraversalGroupBuilder focusTraversalGroup() {
    return FocusTraversalGroupFocusTraversalGroupBuilder.focusTraversalGroupFocusTraversalGroup();
  }
  public boolean descendantsAreFocusable() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("focusTraversalGroupDescendantsAreFocusable not supported on web");
    return factories.FocusTraversalGroup_readBack_descendantsAreFocusable(nativeStruct);
  }
  public boolean descendantsAreTraversable() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("focusTraversalGroupDescendantsAreTraversable not supported on web");
    return factories.FocusTraversalGroup_readBack_descendantsAreTraversable(nativeStruct);
  }
  public Widget child() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("focusTraversalGroupChild not supported on web");
    return factories.FocusTraversalGroup_readBack_child(nativeStruct);
  }
  @Override
  public FocusTraversalGroup build() {
    return this;
  }
}
