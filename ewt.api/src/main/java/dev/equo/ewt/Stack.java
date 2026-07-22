package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.StackObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class Stack extends MultiChildRenderObjectWidget implements StackI {
  private MemorySegment st;
  protected Stack() {}
  Stack(MemorySegment st) {
    this.id = StackObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget Stack");
    System.out.println("New Stack id:"+id);
  }
  Stack(int id) { this.id = id; }
  @Builder.Factory
  static Stack stackStack(Optional<AlignmentGeometryI> alignment, Optional<TextDirection> textDirection, Optional<StackFit> fit, Optional<Clip> clipBehavior, Optional<List<WidgetI>> children) {
    var st = factories.stackStack(alignment.map(AlignmentGeometryI::build),
      textDirection,
      fit,
      clipBehavior,
      children.map(i -> i.stream().map(WidgetI::build).toList()));
    if (st == null) throw new RuntimeException("Failed to created widget Stack");
    return new Stack(st);
  }
  public static StackStackBuilder stack() {
    return StackStackBuilder.stackStack();
  }
  public AlignmentGeometry alignment() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("stackAlignment not supported on web");
    return new AlignmentGeometry(StackObjSt.alignment(st)) {};
  }
  public TextDirection textDirection() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("stackTextDirection not supported on web");
    return TextDirection.values()[StackObjSt.textDirection(st)];
  }
  public StackFit fit() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("stackFit not supported on web");
    return StackFit.values()[StackObjSt.fit(st)];
  }
  public Clip clipBehavior() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("stackClipBehavior not supported on web");
    return Clip.values()[StackObjSt.clipBehavior(st)];
  }
  @Override
  public Stack build() {
    return this;
  }
}
