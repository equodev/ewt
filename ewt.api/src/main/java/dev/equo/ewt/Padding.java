package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.PaddingObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class Padding extends SingleChildRenderObjectWidget implements PaddingI {
  private MemorySegment st;
  protected Padding() {}
  Padding(MemorySegment st) {
    this.id = PaddingObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget Padding");
    System.out.println("New Padding id:"+id);
  }
  @Builder.Factory
  static Padding paddingPadding(@Builder.Parameter EdgeInsetsGeometryI padding, Optional<WidgetI> child) {
    var st = factories.paddingPadding(padding.build(),
      child.map(WidgetI::build));
    if (st == null) throw new RuntimeException("Failed to created widget Padding");
    return new Padding(st);
  }
  public static PaddingPaddingBuilder padding(EdgeInsetsGeometryI padding) {
    return PaddingPaddingBuilder.paddingPadding(padding);
  }
  public EdgeInsetsGeometry padding() {
    return new EdgeInsetsGeometry(PaddingObjSt.padding(st)) {};
  }
  @Override
  public Padding build() {
    return this;
  }
}
