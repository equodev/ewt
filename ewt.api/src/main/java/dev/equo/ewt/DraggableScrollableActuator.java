package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class DraggableScrollableActuator extends StatefulWidget implements DraggableScrollableActuatorI {
  protected DraggableScrollableActuator() {}
  DraggableScrollableActuator(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget DraggableScrollableActuator");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static DraggableScrollableActuator draggableScrollableActuatorDraggableScrollableActuator(@Builder.Parameter WidgetI child) {
    int id = factories.draggableScrollableActuatorDraggableScrollableActuator(child.build());
    if (id <= 0) throw new RuntimeException("Failed to created widget DraggableScrollableActuator");
    return new DraggableScrollableActuator(id);
  }
  public static DraggableScrollableActuatorDraggableScrollableActuatorBuilder draggableScrollableActuator(WidgetI child) {
    return DraggableScrollableActuatorDraggableScrollableActuatorBuilder.draggableScrollableActuatorDraggableScrollableActuator(child);
  }
  public static boolean reset(BuildContextI context) {
    var id = factories.draggableScrollableActuatorReset(context.build());
    if (id <= 0) throw new RuntimeException("Failed to created widget bool");
    return intToBool(id);
  }
  public Widget child() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("draggableScrollableActuatorChild not supported on web");
    return factories.DraggableScrollableActuator_readBack_child(nativeStruct);
  }
  @Override
  public DraggableScrollableActuator build() {
    return this;
  }
}
