package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class ConstrainedBox extends SingleChildRenderObjectWidget implements ConstrainedBoxI {
  protected ConstrainedBox() {}
  ConstrainedBox(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget ConstrainedBox");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static ConstrainedBox constrainedBoxConstrainedBox(@Builder.Parameter BoxConstraintsI constraints, Optional<WidgetI> child) {
    int id = factories.constrainedBoxConstrainedBox(constraints.build(),
      child.map(WidgetI::build));
    if (id <= 0) throw new RuntimeException("Failed to created widget ConstrainedBox");
    return new ConstrainedBox(id);
  }
  public static ConstrainedBoxConstrainedBoxBuilder constrainedBox(BoxConstraintsI constraints) {
    return ConstrainedBoxConstrainedBoxBuilder.constrainedBoxConstrainedBox(constraints);
  }
  public BoxConstraints constraints() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("constrainedBoxConstraints", getId());
      return new BoxConstraints(__nid);
    }
    return factories.ConstrainedBox_readBack_constraints(nativeStruct);
  }
  @Override
  public ConstrainedBox build() {
    return this;
  }
}
