package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import org.immutables.builder.Builder;
public class Center extends Align implements CenterI {
  @Override
  public Center build() {
    return this;
  }
  Center() {}
  Center(int id) {
    this.id = id;
  }
  @Builder.Factory
  static Center centerCenter(OptionalDouble widthFactor, OptionalDouble heightFactor, Optional<WidgetI> child) {
    int id = factories.centerCenter(widthFactor,
      heightFactor,
      child.map(WidgetI::build));
    if (id == -1) throw new RuntimeException("Failed to created widget Center");
    System.out.println("New Center id:"+id);
    return new Center(id);
  }
  public static CenterCenterBuilder center() {
    return CenterCenterBuilder.centerCenter();
  }
}
