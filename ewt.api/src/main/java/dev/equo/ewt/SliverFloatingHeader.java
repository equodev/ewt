package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class SliverFloatingHeader extends StatefulWidget implements SliverFloatingHeaderI {
  protected SliverFloatingHeader() {}
  SliverFloatingHeader(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget SliverFloatingHeader");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static SliverFloatingHeader sliverFloatingHeaderSliverFloatingHeader(Optional<FloatingHeaderSnapMode> snapMode, WidgetI child) {
    int id = factories.sliverFloatingHeaderSliverFloatingHeader(snapMode,
      child.build());
    if (id <= 0) throw new RuntimeException("Failed to created widget SliverFloatingHeader");
    return new SliverFloatingHeader(id);
  }
  public static SliverFloatingHeaderSliverFloatingHeaderBuilder sliverFloatingHeader() {
    return SliverFloatingHeaderSliverFloatingHeaderBuilder.sliverFloatingHeaderSliverFloatingHeader();
  }
  public FloatingHeaderSnapMode snapMode() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("sliverFloatingHeaderSnapMode not supported on web");
    return factories.SliverFloatingHeader_readBack_snapMode(nativeStruct);
  }
  public Widget child() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("sliverFloatingHeaderChild not supported on web");
    return factories.SliverFloatingHeader_readBack_child(nativeStruct);
  }
  @Override
  public SliverFloatingHeader build() {
    return this;
  }
}
