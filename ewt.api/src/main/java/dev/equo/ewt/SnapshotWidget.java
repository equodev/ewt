package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.SnapshotWidgetObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class SnapshotWidget extends SingleChildRenderObjectWidget implements SnapshotWidgetI {
  private MemorySegment st;
  protected SnapshotWidget() {}
  SnapshotWidget(MemorySegment st) {
    this.id = SnapshotWidgetObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget SnapshotWidget");
    System.out.println("New SnapshotWidget id:"+id);
  }
  SnapshotWidget(int id) { this.id = id; }
  public SnapshotMode mode() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("snapshotWidgetMode not supported on web");
    return SnapshotMode.values()[SnapshotWidgetObjSt.mode(st)];
  }
  public boolean autoresize() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("snapshotWidgetAutoresize not supported on web");
    return intToBool(SnapshotWidgetObjSt.autoresize(st));
  }
  @Override
  public SnapshotWidget build() {
    return this;
  }
}
