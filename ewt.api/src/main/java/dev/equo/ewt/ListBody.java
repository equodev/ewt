package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class ListBody extends MultiChildRenderObjectWidget implements ListBodyI {
  protected ListBody() {}
  ListBody(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget ListBody");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static ListBody listBodyListBody(Optional<Axis> mainAxis, Optional<Boolean> reverse, Optional<List<WidgetI>> children) {
    int id = factories.listBodyListBody(mainAxis,
      reverse,
      children.map(i -> i.stream().map(WidgetI::build).collect(java.util.stream.Collectors.toList())));
    if (id <= 0) throw new RuntimeException("Failed to created widget ListBody");
    return new ListBody(id);
  }
  public static ListBodyListBodyBuilder listBody() {
    return ListBodyListBodyBuilder.listBodyListBody();
  }
  public Axis mainAxis() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("listBodyMainAxis not supported on web");
    return factories.ListBody_readBack_mainAxis(nativeStruct);
  }
  public boolean reverse() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("listBodyReverse not supported on web");
    return factories.ListBody_readBack_reverse(nativeStruct);
  }
  @Override
  public ListBody build() {
    return this;
  }
}
