package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.DecoratedSliverObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class DecoratedSliver extends SingleChildRenderObjectWidget implements DecoratedSliverI {
  private MemorySegment st;
  protected DecoratedSliver() {}
  DecoratedSliver(MemorySegment st) {
    this.id = DecoratedSliverObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget DecoratedSliver");
    System.out.println("New DecoratedSliver id:"+id);
  }
  DecoratedSliver(int id) { this.id = id; }
  @Builder.Factory
  static DecoratedSliver decoratedSliverDecoratedSliver(@Builder.Parameter DecorationI decoration, Optional<DecorationPosition> position, Optional<WidgetI> sliver) {
    var st = factories.decoratedSliverDecoratedSliver(decoration.build(),
      position,
      sliver.map(WidgetI::build));
    if (st == null) throw new RuntimeException("Failed to created widget DecoratedSliver");
    return new DecoratedSliver(st);
  }
  public static DecoratedSliverDecoratedSliverBuilder decoratedSliver(DecorationI decoration) {
    return DecoratedSliverDecoratedSliverBuilder.decoratedSliverDecoratedSliver(decoration);
  }
  public Decoration decoration() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("decoratedSliverDecoration not supported on web");
    return new Decoration(DecoratedSliverObjSt.decoration(st)) {};
  }
  public DecorationPosition position() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("decoratedSliverPosition not supported on web");
    return DecorationPosition.values()[DecoratedSliverObjSt.position(st)];
  }
  @Override
  public DecoratedSliver build() {
    return this;
  }
}
