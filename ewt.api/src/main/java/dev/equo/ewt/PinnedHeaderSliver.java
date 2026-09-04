package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.PinnedHeaderSliverObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class PinnedHeaderSliver extends SingleChildRenderObjectWidget implements PinnedHeaderSliverI {
  private MemorySegment st;
  protected PinnedHeaderSliver() {}
  PinnedHeaderSliver(MemorySegment st) {
    this.id = PinnedHeaderSliverObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget PinnedHeaderSliver");
    System.out.println("New PinnedHeaderSliver id:"+id);
  }
  PinnedHeaderSliver(int id) { this.id = id; }
  @Builder.Factory
  static PinnedHeaderSliver pinnedHeaderSliverPinnedHeaderSliver(Optional<WidgetI> child) {
    var st = factories.pinnedHeaderSliverPinnedHeaderSliver(child.map(WidgetI::build));
    if (st == null) throw new RuntimeException("Failed to created widget PinnedHeaderSliver");
    return new PinnedHeaderSliver(st);
  }
  public static PinnedHeaderSliverPinnedHeaderSliverBuilder pinnedHeaderSliver() {
    return PinnedHeaderSliverPinnedHeaderSliverBuilder.pinnedHeaderSliverPinnedHeaderSliver();
  }
  @Override
  public PinnedHeaderSliver build() {
    return this;
  }
}
