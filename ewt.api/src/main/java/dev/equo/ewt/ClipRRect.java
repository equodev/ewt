package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.ClipRRectObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class ClipRRect extends SingleChildRenderObjectWidget implements ClipRRectI {
  private MemorySegment st;
  protected ClipRRect() {}
  ClipRRect(MemorySegment st) {
    this.id = ClipRRectObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget ClipRRect");
    System.out.println("New ClipRRect id:"+id);
  }
  @Builder.Factory
  static ClipRRect clipRRectClipRRect(Optional<BorderRadiusGeometryI> borderRadius, Optional<Clip> clipBehavior, Optional<WidgetI> child) {
    var st = factories.clipRRectClipRRect(borderRadius.map(BorderRadiusGeometryI::build),
      clipBehavior,
      child.map(WidgetI::build));
    if (st == null) throw new RuntimeException("Failed to created widget ClipRRect");
    return new ClipRRect(st);
  }
  public static ClipRRectClipRRectBuilder clipRRect() {
    return ClipRRectClipRRectBuilder.clipRRectClipRRect();
  }
  public BorderRadiusGeometry borderRadius() {
    return new BorderRadiusGeometry(ClipRRectObjSt.borderRadius(st)) {};
  }
  public Clip clipBehavior() {
    return Clip.values()[ClipRRectObjSt.clipBehavior(st)];
  }
  @Override
  public ClipRRect build() {
    return this;
  }
}
