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
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("flexDirection not supported on web");
    return Axis.values()[FlexObjSt.direction(st)];
  }
  public MainAxisAlignment mainAxisAlignment() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("flexMainAxisAlignment not supported on web");
    return MainAxisAlignment.values()[FlexObjSt.mainAxisAlignment(st)];
  }
  public MainAxisSize mainAxisSize() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("flexMainAxisSize not supported on web");
    return MainAxisSize.values()[FlexObjSt.mainAxisSize(st)];
  }
  public CrossAxisAlignment crossAxisAlignment() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("flexCrossAxisAlignment not supported on web");
    return CrossAxisAlignment.values()[FlexObjSt.crossAxisAlignment(st)];
  }
  public TextDirection textDirection() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("flexTextDirection not supported on web");
    return TextDirection.values()[FlexObjSt.textDirection(st)];
  }
  public VerticalDirection verticalDirection() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("flexVerticalDirection not supported on web");
    return VerticalDirection.values()[FlexObjSt.verticalDirection(st)];
  }
  public TextBaseline textBaseline() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("flexTextBaseline not supported on web");
    return TextBaseline.values()[FlexObjSt.textBaseline(st)];
  }
  public Clip clipBehavior() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("flexClipBehavior not supported on web");
    return Clip.values()[FlexObjSt.clipBehavior(st)];
  }
  public double spacing() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("flexSpacing not supported on web");
    return FlexObjSt.spacing(st);
  }
  @Override
  public Flex build() {
    return this;
  }
}
