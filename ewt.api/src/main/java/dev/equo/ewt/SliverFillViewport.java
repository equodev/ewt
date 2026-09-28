package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class SliverFillViewport extends StatelessWidget implements SliverFillViewportI {
  protected SliverFillViewport() {}
  SliverFillViewport(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget SliverFillViewport");
    this.nativeStruct = factories.takeLastStruct();
  }
  public double viewportFraction() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("sliverFillViewportViewportFraction not supported on web");
    return factories.SliverFillViewport_readBack_viewportFraction(nativeStruct);
  }
  public boolean padEnds() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("sliverFillViewportPadEnds not supported on web");
    return factories.SliverFillViewport_readBack_padEnds(nativeStruct);
  }
  public boolean allowImplicitScrolling() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("sliverFillViewportAllowImplicitScrolling not supported on web");
    return factories.SliverFillViewport_readBack_allowImplicitScrolling(nativeStruct);
  }
  @Override
  public SliverFillViewport build() {
    return this;
  }
}
