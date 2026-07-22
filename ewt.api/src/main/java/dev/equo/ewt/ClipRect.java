package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.ClipRectObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class ClipRect extends SingleChildRenderObjectWidget implements ClipRectI {
  private MemorySegment st;
  protected ClipRect() {}
  ClipRect(MemorySegment st) {
    this.id = ClipRectObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget ClipRect");
    System.out.println("New ClipRect id:"+id);
  }
  @Builder.Factory
  static ClipRect clipRectClipRect(Optional<Clip> clipBehavior, Optional<WidgetI> child) {
    var st = factories.clipRectClipRect(clipBehavior,
      child.map(WidgetI::build));
    if (st == null) throw new RuntimeException("Failed to created widget ClipRect");
    return new ClipRect(st);
  }
  public static ClipRectClipRectBuilder clipRect() {
    return ClipRectClipRectBuilder.clipRectClipRect();
  }
  public Clip clipBehavior() {
    return Clip.values()[ClipRectObjSt.clipBehavior(st)];
  }
  @Override
  public ClipRect build() {
    return this;
  }
}
