package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.SliverConstrainedCrossAxisObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class SliverConstrainedCrossAxis extends StatelessWidget implements SliverConstrainedCrossAxisI {
  private MemorySegment st;
  protected SliverConstrainedCrossAxis() {}
  SliverConstrainedCrossAxis(MemorySegment st) {
    this.id = SliverConstrainedCrossAxisObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget SliverConstrainedCrossAxis");
    System.out.println("New SliverConstrainedCrossAxis id:"+id);
  }
  SliverConstrainedCrossAxis(int id) { this.id = id; }
  @Builder.Factory
  static SliverConstrainedCrossAxis sliverConstrainedCrossAxisSliverConstrainedCrossAxis(@Builder.Parameter double maxExtent, @Builder.Parameter WidgetI sliver) {
    var st = factories.sliverConstrainedCrossAxisSliverConstrainedCrossAxis(maxExtent,
      sliver.build());
    if (st == null) throw new RuntimeException("Failed to created widget SliverConstrainedCrossAxis");
    return new SliverConstrainedCrossAxis(st);
  }
  public static SliverConstrainedCrossAxisSliverConstrainedCrossAxisBuilder sliverConstrainedCrossAxis(double maxExtent, WidgetI sliver) {
    return SliverConstrainedCrossAxisSliverConstrainedCrossAxisBuilder.sliverConstrainedCrossAxisSliverConstrainedCrossAxis(maxExtent, sliver);
  }
  public double maxExtent() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("sliverConstrainedCrossAxisMaxExtent not supported on web");
    return SliverConstrainedCrossAxisObjSt.maxExtent(st);
  }
  public Widget sliver() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("sliverConstrainedCrossAxisSliver not supported on web");
    return new Widget(SliverConstrainedCrossAxisObjSt.sliver(st)) {};
  }
  @Override
  public SliverConstrainedCrossAxis build() {
    return this;
  }
}
