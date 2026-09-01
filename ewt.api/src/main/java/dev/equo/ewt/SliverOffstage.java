package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.SliverOffstageObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class SliverOffstage extends SingleChildRenderObjectWidget implements SliverOffstageI {
  private MemorySegment st;
  protected SliverOffstage() {}
  SliverOffstage(MemorySegment st) {
    this.id = SliverOffstageObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget SliverOffstage");
    System.out.println("New SliverOffstage id:"+id);
  }
  SliverOffstage(int id) { this.id = id; }
  @Builder.Factory
  static SliverOffstage sliverOffstageSliverOffstage(Optional<Boolean> offstage, Optional<WidgetI> sliver) {
    var st = factories.sliverOffstageSliverOffstage(offstage,
      sliver.map(WidgetI::build));
    if (st == null) throw new RuntimeException("Failed to created widget SliverOffstage");
    return new SliverOffstage(st);
  }
  public static SliverOffstageSliverOffstageBuilder sliverOffstage() {
    return SliverOffstageSliverOffstageBuilder.sliverOffstageSliverOffstage();
  }
  public boolean offstage() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("sliverOffstageOffstage not supported on web");
    return intToBool(SliverOffstageObjSt.offstage(st));
  }
  @Override
  public SliverOffstage build() {
    return this;
  }
}
