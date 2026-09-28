package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class Center extends Align implements CenterI {
  protected Center() {}
  Center(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget Center");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static Center centerCenter(OptionalDouble widthFactor, OptionalDouble heightFactor, Optional<WidgetI> child) {
    int id = factories.centerCenter(widthFactor,
      heightFactor,
      child.map(WidgetI::build));
    if (id <= 0) throw new RuntimeException("Failed to created widget Center");
    return new Center(id);
  }
  public static CenterCenterBuilder center() {
    return CenterCenterBuilder.centerCenter();
  }
  @Override
  public Center build() {
    return this;
  }
}
