package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.AspectRatioObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class AspectRatio extends SingleChildRenderObjectWidget implements AspectRatioI {
  private MemorySegment st;
  protected AspectRatio() {}
  AspectRatio(MemorySegment st) {
    this.id = AspectRatioObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget AspectRatio");
    System.out.println("New AspectRatio id:"+id);
  }
  @Builder.Factory
  static AspectRatio aspectRatioAspectRatio(@Builder.Parameter double aspectRatio, Optional<WidgetI> child) {
    var st = factories.aspectRatioAspectRatio(aspectRatio,
      child.map(WidgetI::build));
    if (st == null) throw new RuntimeException("Failed to created widget AspectRatio");
    return new AspectRatio(st);
  }
  public static AspectRatioAspectRatioBuilder aspectRatio(double aspectRatio) {
    return AspectRatioAspectRatioBuilder.aspectRatioAspectRatio(aspectRatio);
  }
  public double aspectRatio() {
    return AspectRatioObjSt.aspectRatio(st);
  }
  @Override
  public AspectRatio build() {
    return this;
  }
}
