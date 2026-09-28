package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class ReorderableDelayedDragStartListener extends ReorderableDragStartListener implements ReorderableDelayedDragStartListenerI {
  protected ReorderableDelayedDragStartListener() {}
  ReorderableDelayedDragStartListener(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget ReorderableDelayedDragStartListener");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static ReorderableDelayedDragStartListener reorderableDelayedDragStartListenerReorderableDelayedDragStartListener(@Builder.Parameter WidgetI child, @Builder.Parameter int index, Optional<Boolean> enabled) {
    int id = factories.reorderableDelayedDragStartListenerReorderableDelayedDragStartListener(child.build(),
      index,
      enabled);
    if (id <= 0) throw new RuntimeException("Failed to created widget ReorderableDelayedDragStartListener");
    return new ReorderableDelayedDragStartListener(id);
  }
  public static ReorderableDelayedDragStartListenerReorderableDelayedDragStartListenerBuilder reorderableDelayedDragStartListener(WidgetI child, int index) {
    return ReorderableDelayedDragStartListenerReorderableDelayedDragStartListenerBuilder.reorderableDelayedDragStartListenerReorderableDelayedDragStartListener(child, index);
  }
  @Override
  public ReorderableDelayedDragStartListener build() {
    return this;
  }
}
