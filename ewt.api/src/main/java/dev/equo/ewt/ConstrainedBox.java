package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.ConstrainedBoxObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class ConstrainedBox extends SingleChildRenderObjectWidget implements ConstrainedBoxI {
  private MemorySegment st;
  protected ConstrainedBox() {}
  ConstrainedBox(MemorySegment st) {
    this.id = ConstrainedBoxObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget ConstrainedBox");
    System.out.println("New ConstrainedBox id:"+id);
  }
  ConstrainedBox(int id) { this.id = id; }
  @Builder.Factory
  static ConstrainedBox constrainedBoxConstrainedBox(@Builder.Parameter BoxConstraintsI constraints, Optional<WidgetI> child) {
    var st = factories.constrainedBoxConstrainedBox(constraints.build(),
      child.map(WidgetI::build));
    if (st == null) throw new RuntimeException("Failed to created widget ConstrainedBox");
    return new ConstrainedBox(st);
  }
  public static ConstrainedBoxConstrainedBoxBuilder constrainedBox(BoxConstraintsI constraints) {
    return ConstrainedBoxConstrainedBoxBuilder.constrainedBoxConstrainedBox(constraints);
  }
  public BoxConstraints constraints() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("constrainedBoxConstraints", getId());
      java.lang.foreign.MemorySegment __st = dev.equo.ewt.ffm.BoxConstraintsObjSt.allocate(__s.arena);
      dev.equo.ewt.ffm.BoxConstraintsObjSt.id(__st, __nid);
      return new BoxConstraints(__st);
    }
    return new BoxConstraints(ConstrainedBoxObjSt.constraints(st));
  }
  @Override
  public ConstrainedBox build() {
    return this;
  }
}
