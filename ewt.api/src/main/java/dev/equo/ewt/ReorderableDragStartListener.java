package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class ReorderableDragStartListener extends StatelessWidget implements ReorderableDragStartListenerI {
  protected ReorderableDragStartListener() {}
  ReorderableDragStartListener(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget ReorderableDragStartListener");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static ReorderableDragStartListener reorderableDragStartListenerReorderableDragStartListener(@Builder.Parameter WidgetI child, @Builder.Parameter int index, Optional<Boolean> enabled) {
    int id = factories.reorderableDragStartListenerReorderableDragStartListener(child.build(),
      index,
      enabled);
    if (id <= 0) throw new RuntimeException("Failed to created widget ReorderableDragStartListener");
    return new ReorderableDragStartListener(id);
  }
  public static ReorderableDragStartListenerReorderableDragStartListenerBuilder reorderableDragStartListener(WidgetI child, int index) {
    return ReorderableDragStartListenerReorderableDragStartListenerBuilder.reorderableDragStartListenerReorderableDragStartListener(child, index);
  }
  public Widget child() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("reorderableDragStartListenerChild not supported on web");
    return factories.ReorderableDragStartListener_readBack_child(nativeStruct);
  }
  public int index() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("reorderableDragStartListenerIndex not supported on web");
    return factories.ReorderableDragStartListener_readBack_index(nativeStruct);
  }
  public boolean enabled() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("reorderableDragStartListenerEnabled not supported on web");
    return factories.ReorderableDragStartListener_readBack_enabled(nativeStruct);
  }
  @Override
  public ReorderableDragStartListener build() {
    return this;
  }
}
