package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class Flex extends MultiChildRenderObjectWidget implements FlexI {
  protected Flex() {}
  Flex(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget Flex");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static Flex flexFlex(@Builder.Parameter Axis direction, Optional<MainAxisAlignment> mainAxisAlignment, Optional<MainAxisSize> mainAxisSize, Optional<CrossAxisAlignment> crossAxisAlignment, Optional<TextDirection> textDirection, Optional<VerticalDirection> verticalDirection, Optional<TextBaseline> textBaseline, Optional<Clip> clipBehavior, OptionalDouble spacing, Optional<List<WidgetI>> children) {
    int id = factories.flexFlex(direction,
      mainAxisAlignment,
      mainAxisSize,
      crossAxisAlignment,
      textDirection,
      verticalDirection,
      textBaseline,
      clipBehavior,
      spacing,
      children.map(i -> i.stream().map(WidgetI::build).collect(java.util.stream.Collectors.toList())));
    if (id <= 0) throw new RuntimeException("Failed to created widget Flex");
    return new Flex(id);
  }
  public static FlexFlexBuilder flex(Axis direction) {
    return FlexFlexBuilder.flexFlex(direction);
  }
  public Axis direction() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("flexDirection not supported on web");
    return factories.Flex_readBack_direction(nativeStruct);
  }
  public MainAxisAlignment mainAxisAlignment() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("flexMainAxisAlignment not supported on web");
    return factories.Flex_readBack_mainAxisAlignment(nativeStruct);
  }
  public MainAxisSize mainAxisSize() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("flexMainAxisSize not supported on web");
    return factories.Flex_readBack_mainAxisSize(nativeStruct);
  }
  public CrossAxisAlignment crossAxisAlignment() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("flexCrossAxisAlignment not supported on web");
    return factories.Flex_readBack_crossAxisAlignment(nativeStruct);
  }
  public TextDirection textDirection() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("flexTextDirection not supported on web");
    return factories.Flex_readBack_textDirection(nativeStruct);
  }
  public VerticalDirection verticalDirection() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("flexVerticalDirection not supported on web");
    return factories.Flex_readBack_verticalDirection(nativeStruct);
  }
  public TextBaseline textBaseline() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("flexTextBaseline not supported on web");
    return factories.Flex_readBack_textBaseline(nativeStruct);
  }
  public Clip clipBehavior() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("flexClipBehavior not supported on web");
    return factories.Flex_readBack_clipBehavior(nativeStruct);
  }
  public double spacing() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("flexSpacing not supported on web");
    return factories.Flex_readBack_spacing(nativeStruct);
  }
  @Override
  public Flex build() {
    return this;
  }
}
