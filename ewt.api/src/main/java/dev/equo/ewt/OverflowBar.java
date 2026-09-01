package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.OverflowBarObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class OverflowBar extends MultiChildRenderObjectWidget implements OverflowBarI {
  private MemorySegment st;
  protected OverflowBar() {}
  OverflowBar(MemorySegment st) {
    this.id = OverflowBarObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget OverflowBar");
    System.out.println("New OverflowBar id:"+id);
  }
  OverflowBar(int id) { this.id = id; }
  @Builder.Factory
  static OverflowBar overflowBarOverflowBar(OptionalDouble spacing, Optional<MainAxisAlignment> alignment, OptionalDouble overflowSpacing, Optional<OverflowBarAlignment> overflowAlignment, Optional<VerticalDirection> overflowDirection, Optional<TextDirection> textDirection, Optional<List<WidgetI>> children) {
    var st = factories.overflowBarOverflowBar(spacing,
      alignment,
      overflowSpacing,
      overflowAlignment,
      overflowDirection,
      textDirection,
      children.map(i -> i.stream().map(WidgetI::build).toList()));
    if (st == null) throw new RuntimeException("Failed to created widget OverflowBar");
    return new OverflowBar(st);
  }
  public static OverflowBarOverflowBarBuilder overflowBar() {
    return OverflowBarOverflowBarBuilder.overflowBarOverflowBar();
  }
  public double spacing() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("overflowBarSpacing not supported on web");
    return OverflowBarObjSt.spacing(st);
  }
  public MainAxisAlignment alignment() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("overflowBarAlignment not supported on web");
    return MainAxisAlignment.values()[OverflowBarObjSt.alignment(st)];
  }
  public double overflowSpacing() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("overflowBarOverflowSpacing not supported on web");
    return OverflowBarObjSt.overflowSpacing(st);
  }
  public OverflowBarAlignment overflowAlignment() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("overflowBarOverflowAlignment not supported on web");
    return OverflowBarAlignment.values()[OverflowBarObjSt.overflowAlignment(st)];
  }
  public VerticalDirection overflowDirection() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("overflowBarOverflowDirection not supported on web");
    return VerticalDirection.values()[OverflowBarObjSt.overflowDirection(st)];
  }
  public TextDirection textDirection() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("overflowBarTextDirection not supported on web");
    return TextDirection.values()[OverflowBarObjSt.textDirection(st)];
  }
  @Override
  public OverflowBar build() {
    return this;
  }
}
