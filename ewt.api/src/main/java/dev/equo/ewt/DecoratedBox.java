package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.DecoratedBoxObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class DecoratedBox extends SingleChildRenderObjectWidget implements DecoratedBoxI {
  private MemorySegment st;
  protected DecoratedBox() {}
  DecoratedBox(MemorySegment st) {
    this.id = DecoratedBoxObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget DecoratedBox");
    System.out.println("New DecoratedBox id:"+id);
  }
  @Builder.Factory
  static DecoratedBox decoratedBoxDecoratedBox(@Builder.Parameter DecorationI decoration, Optional<DecorationPosition> position, Optional<WidgetI> child) {
    var st = factories.decoratedBoxDecoratedBox(decoration.build(),
      position,
      child.map(WidgetI::build));
    if (st == null) throw new RuntimeException("Failed to created widget DecoratedBox");
    return new DecoratedBox(st);
  }
  public static DecoratedBoxDecoratedBoxBuilder decoratedBox(DecorationI decoration) {
    return DecoratedBoxDecoratedBoxBuilder.decoratedBoxDecoratedBox(decoration);
  }
  public Decoration decoration() {
    return new Decoration(DecoratedBoxObjSt.decoration(st)) {};
  }
  public DecorationPosition position() {
    return DecorationPosition.values()[DecoratedBoxObjSt.position(st)];
  }
  @Override
  public DecoratedBox build() {
    return this;
  }
}
