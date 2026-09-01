package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.DraggableScrollableActuatorObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class DraggableScrollableActuator extends StatefulWidget implements DraggableScrollableActuatorI {
  private MemorySegment st;
  protected DraggableScrollableActuator() {}
  DraggableScrollableActuator(MemorySegment st) {
    this.id = DraggableScrollableActuatorObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget DraggableScrollableActuator");
    System.out.println("New DraggableScrollableActuator id:"+id);
  }
  DraggableScrollableActuator(int id) { this.id = id; }
  @Builder.Factory
  static DraggableScrollableActuator draggableScrollableActuatorDraggableScrollableActuator(@Builder.Parameter WidgetI child) {
    var st = factories.draggableScrollableActuatorDraggableScrollableActuator(child.build());
    if (st == null) throw new RuntimeException("Failed to created widget DraggableScrollableActuator");
    return new DraggableScrollableActuator(st);
  }
  public static DraggableScrollableActuatorDraggableScrollableActuatorBuilder draggableScrollableActuator(WidgetI child) {
    return DraggableScrollableActuatorDraggableScrollableActuatorBuilder.draggableScrollableActuatorDraggableScrollableActuator(child);
  }
  public static boolean reset(BuildContextI context) {
    int id = factories.draggableScrollableActuatorReset(context.build());
    if (id <= 0) throw new RuntimeException("Failed to created widget bool");
    System.out.println("New bool id:"+id);
    return intToBool(id);
  }
  public Widget child() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("draggableScrollableActuatorChild not supported on web");
    return new Widget(DraggableScrollableActuatorObjSt.child(st)) {};
  }
  @Override
  public DraggableScrollableActuator build() {
    return this;
  }
}
