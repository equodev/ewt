package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.OrientationBuilderObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class OrientationBuilder extends StatelessWidget implements OrientationBuilderI {
  private MemorySegment st;
  protected OrientationBuilder() {}
  OrientationBuilder(MemorySegment st) {
    this.id = OrientationBuilderObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget OrientationBuilder");
    System.out.println("New OrientationBuilder id:"+id);
  }
  OrientationBuilder(int id) { this.id = id; }
  @Builder.Factory
  static OrientationBuilder orientationBuilderOrientationBuilder(@Builder.Parameter BiFunction<BuildContext, Orientation, Widget> builder) {
    var st = factories.orientationBuilderOrientationBuilder(builder);
    if (st == null) throw new RuntimeException("Failed to created widget OrientationBuilder");
    return new OrientationBuilder(st);
  }
  public static OrientationBuilderOrientationBuilderBuilder orientationBuilder(BiFunction<BuildContext, Orientation, Widget> builder) {
    return OrientationBuilderOrientationBuilderBuilder.orientationBuilderOrientationBuilder(builder);
  }
  @Override
  public OrientationBuilder build() {
    return this;
  }
}
