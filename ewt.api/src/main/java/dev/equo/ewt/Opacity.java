package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.OpacityObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class Opacity extends SingleChildRenderObjectWidget implements OpacityI {
  private MemorySegment st;
  protected Opacity() {}
  Opacity(MemorySegment st) {
    this.id = OpacityObjSt.id(st);
    this.st = st;
    System.out.println("New Opacity id:"+id);
  }
  @Builder.Factory
  static Opacity opacityOpacity(@Builder.Parameter double opacity, Optional<Boolean> alwaysIncludeSemantics, Optional<WidgetI> child) {
    var st = factories.opacityOpacity(opacity,
      alwaysIncludeSemantics,
      child.map(WidgetI::build));
    if (st == null) throw new RuntimeException("Failed to created widget Opacity");
    return new Opacity(st);
  }
  public static OpacityOpacityBuilder opacity(double opacity) {
    return OpacityOpacityBuilder.opacityOpacity(opacity);
  }
  public double opacity() {
    return OpacityObjSt.opacity(st);
  }
  public boolean alwaysIncludeSemantics() {
    return intToBool(OpacityObjSt.alwaysIncludeSemantics(st));
  }
  @Override
  public Opacity build() {
    return this;
  }
}
