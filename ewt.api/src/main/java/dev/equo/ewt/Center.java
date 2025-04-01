package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.CenterObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class Center extends Align implements CenterI {
  @Override
  public Center build() {
    return this;
  }
  private MemorySegment st;
  protected Center() {}
  Center(MemorySegment st) {
    this.id = CenterObjSt.id(st);
    this.st = st;
    System.out.println("New Center id:"+id);
  }
  @Builder.Factory
  static Center centerCenter(OptionalDouble widthFactor, OptionalDouble heightFactor, Optional<WidgetI> child) {
    var st = factories.centerCenter(widthFactor,
      heightFactor,
      child.map(WidgetI::build));
    if (st == null) throw new RuntimeException("Failed to created widget Center");
    return new Center(st);
  }
  public static CenterCenterBuilder center() {
    return CenterCenterBuilder.centerCenter();
  }
}
