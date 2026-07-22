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
  Wrap(int id) { this.id = id; }
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
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("wrapDirection not supported on web");
    return Axis.values()[WrapObjSt.direction(st)];
  }
  public WrapAlignment alignment() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("wrapAlignment not supported on web");
    return WrapAlignment.values()[WrapObjSt.alignment(st)];
  }
  public double spacing() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("wrapSpacing not supported on web");
    return WrapObjSt.spacing(st);
  }
  public WrapAlignment runAlignment() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("wrapRunAlignment not supported on web");
    return WrapAlignment.values()[WrapObjSt.runAlignment(st)];
  }
  public double runSpacing() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("wrapRunSpacing not supported on web");
    return WrapObjSt.runSpacing(st);
  }
  public WrapCrossAlignment crossAxisAlignment() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("wrapCrossAxisAlignment not supported on web");
    return WrapCrossAlignment.values()[WrapObjSt.crossAxisAlignment(st)];
  }
  public TextDirection textDirection() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("wrapTextDirection not supported on web");
    return TextDirection.values()[WrapObjSt.textDirection(st)];
  }
  public VerticalDirection verticalDirection() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("wrapVerticalDirection not supported on web");
    return VerticalDirection.values()[WrapObjSt.verticalDirection(st)];
  }
  public Clip clipBehavior() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("wrapClipBehavior not supported on web");
    return Clip.values()[WrapObjSt.clipBehavior(st)];
  }
  @Override
  public Wrap build() {
    return this;
  }
}
