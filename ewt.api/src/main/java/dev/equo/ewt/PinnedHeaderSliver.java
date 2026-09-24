package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.PinnedHeaderSliverObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class PinnedHeaderSliver extends StatelessWidget implements PinnedHeaderSliverI {
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
  public Widget child() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("pinnedHeaderSliverChild not supported on web");
    return new Widget(PinnedHeaderSliverObjSt.child(st)) {};
  }
  @Override
  public PinnedHeaderSliver build() {
    return this;
  }
}
