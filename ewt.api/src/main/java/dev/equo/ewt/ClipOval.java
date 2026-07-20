package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.ClipOvalObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class ClipOval extends SingleChildRenderObjectWidget implements ClipOvalI {
  private MemorySegment st;
  protected ClipOval() {}
  ClipOval(MemorySegment st) {
    this.id = ClipOvalObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget ClipOval");
    System.out.println("New ClipOval id:"+id);
  }
  @Builder.Factory
  static ClipOval clipOvalClipOval(Optional<Clip> clipBehavior, Optional<WidgetI> child) {
    var st = factories.clipOvalClipOval(clipBehavior,
      child.map(WidgetI::build));
    if (st == null) throw new RuntimeException("Failed to created widget ClipOval");
    return new ClipOval(st);
  }
  public static ClipOvalClipOvalBuilder clipOval() {
    return ClipOvalClipOvalBuilder.clipOvalClipOval();
  }
  public Clip clipBehavior() {
    return Clip.values()[ClipOvalObjSt.clipBehavior(st)];
  }
  @Override
  public ClipOval build() {
    return this;
  }
}
