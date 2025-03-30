package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import org.immutables.builder.Builder;
public class Align extends SingleChildRenderObjectWidget implements AlignI {
  @Override
  public Align build() {
    return this;
  }
  Align() {}
  Align(int id) {
    this.id = id;
  }
  @Builder.Factory
  static Align alignAlign(OptionalDouble widthFactor, OptionalDouble heightFactor, Optional<WidgetI> child) {
    int id = factories.alignAlign(widthFactor,
      heightFactor,
      child.map(WidgetI::build));
    if (id == -1) throw new RuntimeException("Failed to created widget Align");
    System.out.println("New Align id:"+id);
    return new Align(id);
  }
  public static AlignAlignBuilder align() {
    return AlignAlignBuilder.alignAlign();
  }
}
