package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.ReorderableDelayedDragStartListenerObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class ReorderableDelayedDragStartListener extends ReorderableDragStartListener implements ReorderableDelayedDragStartListenerI {
  private MemorySegment st;
  protected ReorderableDelayedDragStartListener() {}
  ReorderableDelayedDragStartListener(MemorySegment st) {
    this.id = ReorderableDelayedDragStartListenerObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget ReorderableDelayedDragStartListener");
    System.out.println("New ReorderableDelayedDragStartListener id:"+id);
  }
  ReorderableDelayedDragStartListener(int id) { this.id = id; }
  @Builder.Factory
  static ReorderableDelayedDragStartListener reorderableDelayedDragStartListenerReorderableDelayedDragStartListener(@Builder.Parameter WidgetI child, @Builder.Parameter int index, Optional<Boolean> enabled) {
    var st = factories.reorderableDelayedDragStartListenerReorderableDelayedDragStartListener(child.build(),
      index,
      enabled);
    if (st == null) throw new RuntimeException("Failed to created widget ReorderableDelayedDragStartListener");
    return new ReorderableDelayedDragStartListener(st);
  }
  public static ReorderableDelayedDragStartListenerReorderableDelayedDragStartListenerBuilder reorderableDelayedDragStartListener(WidgetI child, int index) {
    return ReorderableDelayedDragStartListenerReorderableDelayedDragStartListenerBuilder.reorderableDelayedDragStartListenerReorderableDelayedDragStartListener(child, index);
  }
  @Override
  public ReorderableDelayedDragStartListener build() {
    return this;
  }
}
