package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class SliverFillRemaining extends StatelessWidget implements SliverFillRemainingI {
  protected SliverFillRemaining() {}
  SliverFillRemaining(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget SliverFillRemaining");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static SliverFillRemaining sliverFillRemainingSliverFillRemaining(Optional<WidgetI> child, Optional<Boolean> hasScrollBody, Optional<Boolean> fillOverscroll) {
    int id = factories.sliverFillRemainingSliverFillRemaining(child.map(WidgetI::build),
      hasScrollBody,
      fillOverscroll);
    if (id <= 0) throw new RuntimeException("Failed to created widget SliverFillRemaining");
    return new SliverFillRemaining(id);
  }
  public static SliverFillRemainingSliverFillRemainingBuilder sliverFillRemaining() {
    return SliverFillRemainingSliverFillRemainingBuilder.sliverFillRemainingSliverFillRemaining();
  }
  public Widget child() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("sliverFillRemainingChild not supported on web");
    return factories.SliverFillRemaining_readBack_child(nativeStruct);
  }
  public boolean hasScrollBody() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("sliverFillRemainingHasScrollBody not supported on web");
    return factories.SliverFillRemaining_readBack_hasScrollBody(nativeStruct);
  }
  public boolean fillOverscroll() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("sliverFillRemainingFillOverscroll not supported on web");
    return factories.SliverFillRemaining_readBack_fillOverscroll(nativeStruct);
  }
  @Override
  public SliverFillRemaining build() {
    return this;
  }
}
