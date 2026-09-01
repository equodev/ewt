package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.ListenerObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class Listener extends SingleChildRenderObjectWidget implements ListenerI {
  private MemorySegment st;
  protected Listener() {}
  Listener(MemorySegment st) {
    this.id = ListenerObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget Listener");
    System.out.println("New Listener id:"+id);
  }
  Listener(int id) { this.id = id; }
  @Builder.Factory
  static Listener listenerListener(Optional<Consumer<PointerDownEvent>> onPointerDown, Optional<Consumer<PointerUpEvent>> onPointerUp, Optional<Consumer<PointerHoverEvent>> onPointerHover, Optional<HitTestBehavior> behavior, Optional<WidgetI> child) {
    var st = factories.listenerListener(onPointerDown,
      onPointerUp,
      onPointerHover,
      behavior,
      child.map(WidgetI::build));
    if (st == null) throw new RuntimeException("Failed to created widget Listener");
    return new Listener(st);
  }
  public static ListenerListenerBuilder listener() {
    return ListenerListenerBuilder.listenerListener();
  }
  public HitTestBehavior behavior() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("listenerBehavior not supported on web");
    return HitTestBehavior.values()[ListenerObjSt.behavior(st)];
  }
  @Override
  public Listener build() {
    return this;
  }
}
