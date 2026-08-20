package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.PositionedDirectionalObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class PositionedDirectional extends StatelessWidget implements PositionedDirectionalI {
  private MemorySegment st;
  protected PositionedDirectional() {}
  PositionedDirectional(MemorySegment st) {
    this.id = PositionedDirectionalObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget PositionedDirectional");
    System.out.println("New PositionedDirectional id:"+id);
  }
  PositionedDirectional(int id) { this.id = id; }
  @Builder.Factory
  static PositionedDirectional positionedDirectionalPositionedDirectional(OptionalDouble start, OptionalDouble top, OptionalDouble end, OptionalDouble bottom, OptionalDouble width, OptionalDouble height, WidgetI child) {
    var st = factories.positionedDirectionalPositionedDirectional(start,
      top,
      end,
      bottom,
      width,
      height,
      child.build());
    if (st == null) throw new RuntimeException("Failed to created widget PositionedDirectional");
    return new PositionedDirectional(st);
  }
  public static PositionedDirectionalPositionedDirectionalBuilder positionedDirectional() {
    return PositionedDirectionalPositionedDirectionalBuilder.positionedDirectionalPositionedDirectional();
  }
  public double start() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("positionedDirectionalStart not supported on web");
    return PositionedDirectionalObjSt.start(st);
  }
  public double top() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("positionedDirectionalTop not supported on web");
    return PositionedDirectionalObjSt.top(st);
  }
  public double end() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("positionedDirectionalEnd not supported on web");
    return PositionedDirectionalObjSt.end(st);
  }
  public double bottom() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("positionedDirectionalBottom not supported on web");
    return PositionedDirectionalObjSt.bottom(st);
  }
  public double width() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("positionedDirectionalWidth not supported on web");
    return PositionedDirectionalObjSt.width(st);
  }
  public double height() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("positionedDirectionalHeight not supported on web");
    return PositionedDirectionalObjSt.height(st);
  }
  public Widget child() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("positionedDirectionalChild not supported on web");
    return new Widget(PositionedDirectionalObjSt.child(st)) {};
  }
  @Override
  public PositionedDirectional build() {
    return this;
  }
}
