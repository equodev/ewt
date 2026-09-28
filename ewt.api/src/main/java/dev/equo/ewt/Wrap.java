package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class Wrap extends MultiChildRenderObjectWidget implements WrapI {
  protected Wrap() {}
  Wrap(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget Wrap");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static Wrap wrapWrap(Optional<Axis> direction, Optional<WrapAlignment> alignment, OptionalDouble spacing, Optional<WrapAlignment> runAlignment, OptionalDouble runSpacing, Optional<WrapCrossAlignment> crossAxisAlignment, Optional<TextDirection> textDirection, Optional<VerticalDirection> verticalDirection, Optional<Clip> clipBehavior, Optional<List<WidgetI>> children) {
    int id = factories.wrapWrap(direction,
      alignment,
      spacing,
      runAlignment,
      runSpacing,
      crossAxisAlignment,
      textDirection,
      verticalDirection,
      clipBehavior,
      children.map(i -> i.stream().map(WidgetI::build).collect(java.util.stream.Collectors.toList())));
    if (id <= 0) throw new RuntimeException("Failed to created widget Wrap");
    return new Wrap(id);
  }
  public static WrapWrapBuilder wrap() {
    return WrapWrapBuilder.wrapWrap();
  }
  public Axis direction() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("wrapDirection not supported on web");
    return factories.Wrap_readBack_direction(nativeStruct);
  }
  public WrapAlignment alignment() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("wrapAlignment not supported on web");
    return factories.Wrap_readBack_alignment(nativeStruct);
  }
  public double spacing() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("wrapSpacing not supported on web");
    return factories.Wrap_readBack_spacing(nativeStruct);
  }
  public WrapAlignment runAlignment() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("wrapRunAlignment not supported on web");
    return factories.Wrap_readBack_runAlignment(nativeStruct);
  }
  public double runSpacing() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("wrapRunSpacing not supported on web");
    return factories.Wrap_readBack_runSpacing(nativeStruct);
  }
  public WrapCrossAlignment crossAxisAlignment() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("wrapCrossAxisAlignment not supported on web");
    return factories.Wrap_readBack_crossAxisAlignment(nativeStruct);
  }
  public TextDirection textDirection() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("wrapTextDirection not supported on web");
    return factories.Wrap_readBack_textDirection(nativeStruct);
  }
  public VerticalDirection verticalDirection() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("wrapVerticalDirection not supported on web");
    return factories.Wrap_readBack_verticalDirection(nativeStruct);
  }
  public Clip clipBehavior() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("wrapClipBehavior not supported on web");
    return factories.Wrap_readBack_clipBehavior(nativeStruct);
  }
  @Override
  public Wrap build() {
    return this;
  }
}
