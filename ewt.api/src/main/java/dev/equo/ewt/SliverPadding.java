package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.SliverPaddingObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class SliverPadding extends SingleChildRenderObjectWidget implements SliverPaddingI {
  private MemorySegment st;
  protected SliverPadding() {}
  SliverPadding(MemorySegment st) {
    this.id = SliverPaddingObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget SliverPadding");
    System.out.println("New SliverPadding id:"+id);
  }
  SliverPadding(int id) { this.id = id; }
  @Builder.Factory
  static SliverPadding sliverPaddingSliverPadding(@Builder.Parameter EdgeInsetsGeometryI padding, Optional<WidgetI> sliver) {
    var st = factories.sliverPaddingSliverPadding(padding.build(),
      sliver.map(WidgetI::build));
    if (st == null) throw new RuntimeException("Failed to created widget SliverPadding");
    return new SliverPadding(st);
  }
  public static SliverPaddingSliverPaddingBuilder sliverPadding(EdgeInsetsGeometryI padding) {
    return SliverPaddingSliverPaddingBuilder.sliverPaddingSliverPadding(padding);
  }
  public EdgeInsetsGeometry padding() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("sliverPaddingPadding not supported on web");
    return new EdgeInsetsGeometry(SliverPaddingObjSt.padding(st)) {};
  }
  @Override
  public SliverPadding build() {
    return this;
  }
}
