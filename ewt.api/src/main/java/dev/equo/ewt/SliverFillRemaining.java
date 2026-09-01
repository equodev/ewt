package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.SliverFillRemainingObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class SliverFillRemaining extends StatelessWidget implements SliverFillRemainingI {
  private MemorySegment st;
  protected SliverFillRemaining() {}
  SliverFillRemaining(MemorySegment st) {
    this.id = SliverFillRemainingObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget SliverFillRemaining");
    System.out.println("New SliverFillRemaining id:"+id);
  }
  SliverFillRemaining(int id) { this.id = id; }
  @Builder.Factory
  static SliverFillRemaining sliverFillRemainingSliverFillRemaining(Optional<WidgetI> child, Optional<Boolean> hasScrollBody, Optional<Boolean> fillOverscroll) {
    var st = factories.sliverFillRemainingSliverFillRemaining(child.map(WidgetI::build),
      hasScrollBody,
      fillOverscroll);
    if (st == null) throw new RuntimeException("Failed to created widget SliverFillRemaining");
    return new SliverFillRemaining(st);
  }
  public static SliverFillRemainingSliverFillRemainingBuilder sliverFillRemaining() {
    return SliverFillRemainingSliverFillRemainingBuilder.sliverFillRemainingSliverFillRemaining();
  }
  public Widget child() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("sliverFillRemainingChild not supported on web");
    return new Widget(SliverFillRemainingObjSt.child(st)) {};
  }
  public boolean hasScrollBody() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("sliverFillRemainingHasScrollBody not supported on web");
    return intToBool(SliverFillRemainingObjSt.hasScrollBody(st));
  }
  public boolean fillOverscroll() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("sliverFillRemainingFillOverscroll not supported on web");
    return intToBool(SliverFillRemainingObjSt.fillOverscroll(st));
  }
  @Override
  public SliverFillRemaining build() {
    return this;
  }
}
