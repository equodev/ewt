package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.FlexObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class Flex extends MultiChildRenderObjectWidget implements FlexI {
  private MemorySegment st;
  protected Flex() {}
  Flex(MemorySegment st) {
    this.id = FlexObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget Flex");
    System.out.println("New Flex id:"+id);
  }
  @Builder.Factory
  static Flex flexFlex(@Builder.Parameter Axis direction, Optional<MainAxisAlignment> mainAxisAlignment, Optional<MainAxisSize> mainAxisSize, Optional<CrossAxisAlignment> crossAxisAlignment, Optional<TextDirection> textDirection, Optional<VerticalDirection> verticalDirection, Optional<TextBaseline> textBaseline, Optional<Clip> clipBehavior, OptionalDouble spacing, Optional<List<WidgetI>> children) {
    var st = factories.flexFlex(direction,
      mainAxisAlignment,
      mainAxisSize,
      crossAxisAlignment,
      textDirection,
      verticalDirection,
      textBaseline,
      clipBehavior,
      spacing,
      children.map(i -> i.stream().map(WidgetI::build).toList()));
    if (st == null) throw new RuntimeException("Failed to created widget Flex");
    return new Flex(st);
  }
  public static FlexFlexBuilder flex(Axis direction) {
    return FlexFlexBuilder.flexFlex(direction);
  }
  public Axis direction() {
    return Axis.values()[FlexObjSt.direction(st)];
  }
  public MainAxisAlignment mainAxisAlignment() {
    return MainAxisAlignment.values()[FlexObjSt.mainAxisAlignment(st)];
  }
  public MainAxisSize mainAxisSize() {
    return MainAxisSize.values()[FlexObjSt.mainAxisSize(st)];
  }
  public CrossAxisAlignment crossAxisAlignment() {
    return CrossAxisAlignment.values()[FlexObjSt.crossAxisAlignment(st)];
  }
  public TextDirection textDirection() {
    return TextDirection.values()[FlexObjSt.textDirection(st)];
  }
  public VerticalDirection verticalDirection() {
    return VerticalDirection.values()[FlexObjSt.verticalDirection(st)];
  }
  public TextBaseline textBaseline() {
    return TextBaseline.values()[FlexObjSt.textBaseline(st)];
  }
  public Clip clipBehavior() {
    return Clip.values()[FlexObjSt.clipBehavior(st)];
  }
  public double spacing() {
    return FlexObjSt.spacing(st);
  }
  @Override
  public Flex build() {
    return this;
  }
}
