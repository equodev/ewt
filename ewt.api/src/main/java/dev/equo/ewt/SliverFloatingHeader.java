package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.SliverFloatingHeaderObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class SliverFloatingHeader extends StatefulWidget implements SliverFloatingHeaderI {
  private MemorySegment st;
  protected SliverFloatingHeader() {}
  SliverFloatingHeader(MemorySegment st) {
    this.id = SliverFloatingHeaderObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget SliverFloatingHeader");
    System.out.println("New SliverFloatingHeader id:"+id);
  }
  SliverFloatingHeader(int id) { this.id = id; }
  @Builder.Factory
  static SliverFloatingHeader sliverFloatingHeaderSliverFloatingHeader(Optional<FloatingHeaderSnapMode> snapMode, WidgetI child) {
    var st = factories.sliverFloatingHeaderSliverFloatingHeader(snapMode,
      child.build());
    if (st == null) throw new RuntimeException("Failed to created widget SliverFloatingHeader");
    return new SliverFloatingHeader(st);
  }
  public static SliverFloatingHeaderSliverFloatingHeaderBuilder sliverFloatingHeader() {
    return SliverFloatingHeaderSliverFloatingHeaderBuilder.sliverFloatingHeaderSliverFloatingHeader();
  }
  public FloatingHeaderSnapMode snapMode() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("sliverFloatingHeaderSnapMode not supported on web");
    return FloatingHeaderSnapMode.values()[SliverFloatingHeaderObjSt.snapMode(st)];
  }
  public Widget child() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("sliverFloatingHeaderChild not supported on web");
    return new Widget(SliverFloatingHeaderObjSt.child(st)) {};
  }
  @Override
  public SliverFloatingHeader build() {
    return this;
  }
}
