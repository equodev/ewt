package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class ClipRect extends SingleChildRenderObjectWidget implements ClipRectI {
  protected ClipRect() {}
  ClipRect(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget ClipRect");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static ClipRect clipRectClipRect(Optional<Clip> clipBehavior, Optional<WidgetI> child) {
    int id = factories.clipRectClipRect(clipBehavior,
      child.map(WidgetI::build));
    if (id <= 0) throw new RuntimeException("Failed to created widget ClipRect");
    return new ClipRect(id);
  }
  public static ClipRectClipRectBuilder clipRect() {
    return ClipRectClipRectBuilder.clipRectClipRect();
  }
  public Clip clipBehavior() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("clipRectClipBehavior not supported on web");
    return factories.ClipRect_readBack_clipBehavior(nativeStruct);
  }
  @Override
  public ClipRect build() {
    return this;
  }
}
