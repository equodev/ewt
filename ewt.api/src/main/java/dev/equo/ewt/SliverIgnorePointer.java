package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.SliverIgnorePointerObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class SliverIgnorePointer extends SingleChildRenderObjectWidget implements SliverIgnorePointerI {
  private MemorySegment st;
  protected SliverIgnorePointer() {}
  SliverIgnorePointer(MemorySegment st) {
    this.id = SliverIgnorePointerObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget SliverIgnorePointer");
    System.out.println("New SliverIgnorePointer id:"+id);
  }
  SliverIgnorePointer(int id) { this.id = id; }
  @Builder.Factory
  static SliverIgnorePointer sliverIgnorePointerSliverIgnorePointer(Optional<Boolean> ignoring, Optional<Boolean> ignoringSemantics, Optional<WidgetI> sliver) {
    var st = factories.sliverIgnorePointerSliverIgnorePointer(ignoring,
      ignoringSemantics,
      sliver.map(WidgetI::build));
    if (st == null) throw new RuntimeException("Failed to created widget SliverIgnorePointer");
    return new SliverIgnorePointer(st);
  }
  public static SliverIgnorePointerSliverIgnorePointerBuilder sliverIgnorePointer() {
    return SliverIgnorePointerSliverIgnorePointerBuilder.sliverIgnorePointerSliverIgnorePointer();
  }
  public boolean ignoring() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("sliverIgnorePointerIgnoring not supported on web");
    return intToBool(SliverIgnorePointerObjSt.ignoring(st));
  }
  public boolean ignoringSemantics() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("sliverIgnorePointerIgnoringSemantics not supported on web");
    return intToBool(SliverIgnorePointerObjSt.ignoringSemantics(st));
  }
  @Override
  public SliverIgnorePointer build() {
    return this;
  }
}
