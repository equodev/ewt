package dev.equo.ewt;
import java.util.*;
import org.immutables.builder.Builder;
public class Align extends SingleChildRenderObjectWidget {
  Align() {}
  Align(int id) {
    this.id = id;
  }
  @Builder.Factory
  static Align alignAlign(OptionalDouble widthFactor, OptionalDouble heightFactor, Optional<Widget> child) {
    int id = factories.alignAlign(widthFactor,
      heightFactor,
      child);
    if (id == -1) throw new RuntimeException("Failed to created widget Align");
    System.out.println("New Align id:"+id);
    return new Align(id);
  }
  public static AlignAlignBuilder align() {
    return AlignAlignBuilder.alignAlign();
  }
}
