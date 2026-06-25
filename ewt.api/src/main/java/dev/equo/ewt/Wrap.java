package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.WrapObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class Wrap extends MultiChildRenderObjectWidget implements WrapI {
  private MemorySegment st;
  protected Wrap() {}
  Wrap(MemorySegment st) {
    this.id = WrapObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget Wrap");
    System.out.println("New Wrap id:"+id);
  }
  @Builder.Factory
  static Wrap wrapWrap(Optional<Axis> direction, Optional<WrapAlignment> alignment, OptionalDouble spacing, Optional<WrapAlignment> runAlignment, OptionalDouble runSpacing, Optional<WrapCrossAlignment> crossAxisAlignment, Optional<TextDirection> textDirection, Optional<VerticalDirection> verticalDirection, Optional<Clip> clipBehavior, Optional<List<WidgetI>> children) {
    var st = factories.wrapWrap(direction,
      alignment,
      spacing,
      runAlignment,
      runSpacing,
      crossAxisAlignment,
      textDirection,
      verticalDirection,
      clipBehavior,
      children.map(i -> i.stream().map(WidgetI::build).toList()));
    if (st == null) throw new RuntimeException("Failed to created widget Wrap");
    return new Wrap(st);
  }
  public static WrapWrapBuilder wrap() {
    return WrapWrapBuilder.wrapWrap();
  }
  public Axis direction() {
    return Axis.values()[WrapObjSt.direction(st)];
  }
  public WrapAlignment alignment() {
    return WrapAlignment.values()[WrapObjSt.alignment(st)];
  }
  public double spacing() {
    return WrapObjSt.spacing(st);
  }
  public WrapAlignment runAlignment() {
    return WrapAlignment.values()[WrapObjSt.runAlignment(st)];
  }
  public double runSpacing() {
    return WrapObjSt.runSpacing(st);
  }
  public WrapCrossAlignment crossAxisAlignment() {
    return WrapCrossAlignment.values()[WrapObjSt.crossAxisAlignment(st)];
  }
  public TextDirection textDirection() {
    return TextDirection.values()[WrapObjSt.textDirection(st)];
  }
  public VerticalDirection verticalDirection() {
    return VerticalDirection.values()[WrapObjSt.verticalDirection(st)];
  }
  public Clip clipBehavior() {
    return Clip.values()[WrapObjSt.clipBehavior(st)];
  }
  @Override
  public Wrap build() {
    return this;
  }
}
