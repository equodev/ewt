package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.ReorderableDragStartListenerObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class ReorderableDragStartListener extends StatelessWidget implements ReorderableDragStartListenerI {
  private MemorySegment st;
  protected ReorderableDragStartListener() {}
  ReorderableDragStartListener(MemorySegment st) {
    this.id = ReorderableDragStartListenerObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget ReorderableDragStartListener");
    System.out.println("New ReorderableDragStartListener id:"+id);
  }
  ReorderableDragStartListener(int id) { this.id = id; }
  @Builder.Factory
  static ReorderableDragStartListener reorderableDragStartListenerReorderableDragStartListener(@Builder.Parameter WidgetI child, @Builder.Parameter int index, Optional<Boolean> enabled) {
    var st = factories.reorderableDragStartListenerReorderableDragStartListener(child.build(),
      index,
      enabled);
    if (st == null) throw new RuntimeException("Failed to created widget ReorderableDragStartListener");
    return new ReorderableDragStartListener(st);
  }
  public static ReorderableDragStartListenerReorderableDragStartListenerBuilder reorderableDragStartListener(WidgetI child, int index) {
    return ReorderableDragStartListenerReorderableDragStartListenerBuilder.reorderableDragStartListenerReorderableDragStartListener(child, index);
  }
  public Widget child() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("reorderableDragStartListenerChild not supported on web");
    return new Widget(ReorderableDragStartListenerObjSt.child(st)) {};
  }
  public int index() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("reorderableDragStartListenerIndex not supported on web");
    return ReorderableDragStartListenerObjSt.index(st);
  }
  public boolean enabled() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("reorderableDragStartListenerEnabled not supported on web");
    return intToBool(ReorderableDragStartListenerObjSt.enabled(st));
  }
  @Override
  public ReorderableDragStartListener build() {
    return this;
  }
}
