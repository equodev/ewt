package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class ClipOval extends SingleChildRenderObjectWidget implements ClipOvalI {
  protected ClipOval() {}
  ClipOval(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget ClipOval");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static ClipOval clipOvalClipOval(Optional<Clip> clipBehavior, Optional<WidgetI> child) {
    int id = factories.clipOvalClipOval(clipBehavior,
      child.map(WidgetI::build));
    if (id <= 0) throw new RuntimeException("Failed to created widget ClipOval");
    return new ClipOval(id);
  }
  public static ClipOvalClipOvalBuilder clipOval() {
    return ClipOvalClipOvalBuilder.clipOvalClipOval();
  }
  public Clip clipBehavior() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("clipOvalClipBehavior not supported on web");
    return factories.ClipOval_readBack_clipBehavior(nativeStruct);
  }
  @Override
  public ClipOval build() {
    return this;
  }
}
