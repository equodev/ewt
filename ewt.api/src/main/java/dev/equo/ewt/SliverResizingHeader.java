package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.SliverResizingHeaderObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class SliverResizingHeader extends StatelessWidget implements SliverResizingHeaderI {
  private MemorySegment st;
  protected SliverResizingHeader() {}
  SliverResizingHeader(MemorySegment st) {
    this.id = SliverResizingHeaderObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget SliverResizingHeader");
    System.out.println("New SliverResizingHeader id:"+id);
  }
  SliverResizingHeader(int id) { this.id = id; }
  @Builder.Factory
  static SliverResizingHeader sliverResizingHeaderSliverResizingHeader(Optional<WidgetI> minExtentPrototype, Optional<WidgetI> maxExtentPrototype, Optional<WidgetI> child) {
    var st = factories.sliverResizingHeaderSliverResizingHeader(minExtentPrototype.map(WidgetI::build),
      maxExtentPrototype.map(WidgetI::build),
      child.map(WidgetI::build));
    if (st == null) throw new RuntimeException("Failed to created widget SliverResizingHeader");
    return new SliverResizingHeader(st);
  }
  public static SliverResizingHeaderSliverResizingHeaderBuilder sliverResizingHeader() {
    return SliverResizingHeaderSliverResizingHeaderBuilder.sliverResizingHeaderSliverResizingHeader();
  }
  public Widget minExtentPrototype() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("sliverResizingHeaderMinExtentPrototype not supported on web");
    return new Widget(SliverResizingHeaderObjSt.minExtentPrototype(st)) {};
  }
  public Widget maxExtentPrototype() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("sliverResizingHeaderMaxExtentPrototype not supported on web");
    return new Widget(SliverResizingHeaderObjSt.maxExtentPrototype(st)) {};
  }
  public Widget child() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("sliverResizingHeaderChild not supported on web");
    return new Widget(SliverResizingHeaderObjSt.child(st)) {};
  }
  @Override
  public SliverResizingHeader build() {
    return this;
  }
}
