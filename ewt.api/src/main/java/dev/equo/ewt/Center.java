package dev.equo.ewt;
import java.util.*;
import org.immutables.builder.Builder;
public class Center extends Widget {
  static final WidgetConstructors factories = WidgetConstructors.instance;
  @Builder.Constructor
  Center(OptionalDouble widthFactor, OptionalDouble heightFactor, Optional<Widget> child) {
    id = factories.centerOf(widthFactor, heightFactor, child);
    if (id == -1) throw new RuntimeException("Failed to created widget "+this);
    System.out.println("New "+this+" id:"+id);
  }
  public static CenterBuilder of() {
    return CenterBuilder.Center();
  }
}
