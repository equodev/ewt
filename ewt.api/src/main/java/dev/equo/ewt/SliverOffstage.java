package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class SliverOffstage extends SingleChildRenderObjectWidget implements SliverOffstageI {
  protected SliverOffstage() {}
  SliverOffstage(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget SliverOffstage");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static SliverOffstage sliverOffstageSliverOffstage(Optional<Boolean> offstage, Optional<WidgetI> sliver) {
    int id = factories.sliverOffstageSliverOffstage(offstage,
      sliver.map(WidgetI::build));
    if (id <= 0) throw new RuntimeException("Failed to created widget SliverOffstage");
    return new SliverOffstage(id);
  }
  public static SliverOffstageSliverOffstageBuilder sliverOffstage() {
    return SliverOffstageSliverOffstageBuilder.sliverOffstageSliverOffstage();
  }
  public boolean offstage() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("sliverOffstageOffstage not supported on web");
    return factories.SliverOffstage_readBack_offstage(nativeStruct);
  }
  @Override
  public SliverOffstage build() {
    return this;
  }
}
