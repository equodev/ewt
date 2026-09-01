package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.ListBodyObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class ListBody extends MultiChildRenderObjectWidget implements ListBodyI {
  private MemorySegment st;
  protected ListBody() {}
  ListBody(MemorySegment st) {
    this.id = ListBodyObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget ListBody");
    System.out.println("New ListBody id:"+id);
  }
  ListBody(int id) { this.id = id; }
  @Builder.Factory
  static ListBody listBodyListBody(Optional<Axis> mainAxis, Optional<Boolean> reverse, Optional<List<WidgetI>> children) {
    var st = factories.listBodyListBody(mainAxis,
      reverse,
      children.map(i -> i.stream().map(WidgetI::build).toList()));
    if (st == null) throw new RuntimeException("Failed to created widget ListBody");
    return new ListBody(st);
  }
  public static ListBodyListBodyBuilder listBody() {
    return ListBodyListBodyBuilder.listBodyListBody();
  }
  public Axis mainAxis() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("listBodyMainAxis not supported on web");
    return Axis.values()[ListBodyObjSt.mainAxis(st)];
  }
  public boolean reverse() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("listBodyReverse not supported on web");
    return intToBool(ListBodyObjSt.reverse(st));
  }
  @Override
  public ListBody build() {
    return this;
  }
}
