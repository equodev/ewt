package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class OverflowBar extends MultiChildRenderObjectWidget implements OverflowBarI {
  protected OverflowBar() {}
  OverflowBar(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget OverflowBar");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static OverflowBar overflowBarOverflowBar(OptionalDouble spacing, Optional<MainAxisAlignment> alignment, OptionalDouble overflowSpacing, Optional<OverflowBarAlignment> overflowAlignment, Optional<VerticalDirection> overflowDirection, Optional<TextDirection> textDirection, Optional<List<WidgetI>> children) {
    int id = factories.overflowBarOverflowBar(spacing,
      alignment,
      overflowSpacing,
      overflowAlignment,
      overflowDirection,
      textDirection,
      children.map(i -> i.stream().map(WidgetI::build).collect(java.util.stream.Collectors.toList())));
    if (id <= 0) throw new RuntimeException("Failed to created widget OverflowBar");
    return new OverflowBar(id);
  }
  public static OverflowBarOverflowBarBuilder overflowBar() {
    return OverflowBarOverflowBarBuilder.overflowBarOverflowBar();
  }
  public double spacing() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("overflowBarSpacing not supported on web");
    return factories.OverflowBar_readBack_spacing(nativeStruct);
  }
  public MainAxisAlignment alignment() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("overflowBarAlignment not supported on web");
    return factories.OverflowBar_readBack_alignment(nativeStruct);
  }
  public double overflowSpacing() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("overflowBarOverflowSpacing not supported on web");
    return factories.OverflowBar_readBack_overflowSpacing(nativeStruct);
  }
  public OverflowBarAlignment overflowAlignment() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("overflowBarOverflowAlignment not supported on web");
    return factories.OverflowBar_readBack_overflowAlignment(nativeStruct);
  }
  public VerticalDirection overflowDirection() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("overflowBarOverflowDirection not supported on web");
    return factories.OverflowBar_readBack_overflowDirection(nativeStruct);
  }
  public TextDirection textDirection() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("overflowBarTextDirection not supported on web");
    return factories.OverflowBar_readBack_textDirection(nativeStruct);
  }
  @Override
  public OverflowBar build() {
    return this;
  }
}
