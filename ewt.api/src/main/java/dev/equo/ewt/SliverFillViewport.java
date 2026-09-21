package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.SliverFillViewportObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class SliverFillViewport extends StatelessWidget implements SliverFillViewportI {
  private MemorySegment st;
  protected SliverFillViewport() {}
  SliverFillViewport(MemorySegment st) {
    this.id = SliverFillViewportObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget SliverFillViewport");
    System.out.println("New SliverFillViewport id:"+id);
  }
  SliverFillViewport(int id) { this.id = id; }
  public double viewportFraction() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("sliverFillViewportViewportFraction not supported on web");
    return SliverFillViewportObjSt.viewportFraction(st);
  }
  public boolean padEnds() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("sliverFillViewportPadEnds not supported on web");
    return intToBool(SliverFillViewportObjSt.padEnds(st));
  }
  public boolean allowImplicitScrolling() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("sliverFillViewportAllowImplicitScrolling not supported on web");
    return intToBool(SliverFillViewportObjSt.allowImplicitScrolling(st));
  }
  @Override
  public SliverFillViewport build() {
    return this;
  }
}
