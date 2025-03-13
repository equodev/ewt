package dev.equo.ewt;
import java.util.*;
import org.immutables.builder.Builder;
public class Center extends Align {
  static final WidgetConstructors factories = WidgetConstructors.instance;
  Center() {}
  Center(int id) {
    this.id = id;
  }
  @Builder.Factory
  static Center centerCenter(OptionalDouble widthFactor, OptionalDouble heightFactor, Optional<Widget> child) {
    int id = factories.centerCenter(widthFactor,
      heightFactor,
      child);
    if (id == -1) throw new RuntimeException("Failed to created widget Center");
    System.out.println("New Center id:"+id);
    return new Center(id);
  }
  public static CenterCenterBuilder center() {
    return CenterCenterBuilder.centerCenter();
  }
}
