package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class PinnedHeaderSliver extends StatelessWidget implements PinnedHeaderSliverI {
  protected PinnedHeaderSliver() {}
  PinnedHeaderSliver(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget PinnedHeaderSliver");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static PinnedHeaderSliver pinnedHeaderSliverPinnedHeaderSliver(Optional<WidgetI> child) {
    int id = factories.pinnedHeaderSliverPinnedHeaderSliver(child.map(WidgetI::build));
    if (id <= 0) throw new RuntimeException("Failed to created widget PinnedHeaderSliver");
    return new PinnedHeaderSliver(id);
  }
  public static PinnedHeaderSliverPinnedHeaderSliverBuilder pinnedHeaderSliver() {
    return PinnedHeaderSliverPinnedHeaderSliverBuilder.pinnedHeaderSliverPinnedHeaderSliver();
  }
  public Widget child() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("pinnedHeaderSliverChild not supported on web");
    return factories.PinnedHeaderSliver_readBack_child(nativeStruct);
  }
  @Override
  public PinnedHeaderSliver build() {
    return this;
  }
}
