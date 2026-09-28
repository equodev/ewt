package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class Listener extends SingleChildRenderObjectWidget implements ListenerI {
  protected Listener() {}
  Listener(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget Listener");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static Listener listenerListener(Optional<Consumer<PointerDownEvent>> onPointerDown, Optional<Consumer<PointerUpEvent>> onPointerUp, Optional<Consumer<PointerHoverEvent>> onPointerHover, Optional<HitTestBehavior> behavior, Optional<WidgetI> child) {
    int id = factories.listenerListener(onPointerDown,
      onPointerUp,
      onPointerHover,
      behavior,
      child.map(WidgetI::build));
    if (id <= 0) throw new RuntimeException("Failed to created widget Listener");
    return new Listener(id);
  }
  public static ListenerListenerBuilder listener() {
    return ListenerListenerBuilder.listenerListener();
  }
  public HitTestBehavior behavior() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("listenerBehavior not supported on web");
    return factories.Listener_readBack_behavior(nativeStruct);
  }
  @Override
  public Listener build() {
    return this;
  }
}
