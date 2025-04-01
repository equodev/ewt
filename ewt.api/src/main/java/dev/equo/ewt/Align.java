package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.AlignObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class Align extends SingleChildRenderObjectWidget implements AlignI {
  @Override
  public Align build() {
    return this;
  }
  private MemorySegment st;
  protected Align() {}
  Align(MemorySegment st) {
    this.id = AlignObjSt.id(st);
    this.st = st;
    System.out.println("New Align id:"+id);
  }
  @Builder.Factory
  static Align alignAlign(OptionalDouble widthFactor, OptionalDouble heightFactor, Optional<WidgetI> child) {
    var st = factories.alignAlign(widthFactor,
      heightFactor,
      child.map(WidgetI::build));
    if (st == null) throw new RuntimeException("Failed to created widget Align");
    return new Align(st);
  }
  public static AlignAlignBuilder align() {
    return AlignAlignBuilder.alignAlign();
  }
  public double widthFactor() {
    return AlignObjSt.widthFactor(st);
  }
  public double heightFactor() {
    return AlignObjSt.heightFactor(st);
  }
}
