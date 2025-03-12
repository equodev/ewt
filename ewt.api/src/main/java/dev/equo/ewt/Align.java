package dev.equo.ewt;
import java.util.*;
import org.immutables.builder.Builder;
public class Align extends SingleChildRenderObjectWidget {
  static final WidgetConstructors factories = WidgetConstructors.instance;
  Align() {}
  @Builder.Constructor
  Align(OptionalDouble widthFactor, OptionalDouble heightFactor, Optional<Widget> child) {
    id = factories.alignAlign(widthFactor, heightFactor, child);
    if (id == -1) throw new RuntimeException("Failed to created widget "+this);
    System.out.println("New "+this+" id:"+id);
  }
  public static AlignBuilder align() {
    return AlignBuilder.Align();
  }
}
