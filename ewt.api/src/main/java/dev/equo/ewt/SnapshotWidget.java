package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class SnapshotWidget extends SingleChildRenderObjectWidget implements SnapshotWidgetI {
  protected SnapshotWidget() {}
  SnapshotWidget(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget SnapshotWidget");
    this.nativeStruct = factories.takeLastStruct();
  }
  public SnapshotMode mode() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("snapshotWidgetMode not supported on web");
    return factories.SnapshotWidget_readBack_mode(nativeStruct);
  }
  public boolean autoresize() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("snapshotWidgetAutoresize not supported on web");
    return factories.SnapshotWidget_readBack_autoresize(nativeStruct);
  }
  @Override
  public SnapshotWidget build() {
    return this;
  }
}
