package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class Stack extends MultiChildRenderObjectWidget implements StackI {
  protected Stack() {}
  Stack(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget Stack");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static Stack stackStack(Optional<AlignmentGeometryI> alignment, Optional<TextDirection> textDirection, Optional<StackFit> fit, Optional<Clip> clipBehavior, Optional<List<WidgetI>> children) {
    int id = factories.stackStack(alignment.map(AlignmentGeometryI::build),
      textDirection,
      fit,
      clipBehavior,
      children.map(i -> i.stream().map(WidgetI::build).collect(java.util.stream.Collectors.toList())));
    if (id <= 0) throw new RuntimeException("Failed to created widget Stack");
    return new Stack(id);
  }
  public static StackStackBuilder stack() {
    return StackStackBuilder.stackStack();
  }
  public AlignmentGeometry alignment() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("stackAlignment not supported on web");
    return factories.Stack_readBack_alignment(nativeStruct);
  }
  public TextDirection textDirection() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("stackTextDirection not supported on web");
    return factories.Stack_readBack_textDirection(nativeStruct);
  }
  public StackFit fit() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("stackFit not supported on web");
    return factories.Stack_readBack_fit(nativeStruct);
  }
  public Clip clipBehavior() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("stackClipBehavior not supported on web");
    return factories.Stack_readBack_clipBehavior(nativeStruct);
  }
  @Override
  public Stack build() {
    return this;
  }
}
