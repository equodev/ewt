package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class OrientationBuilder extends StatelessWidget implements OrientationBuilderI {
  protected OrientationBuilder() {}
  OrientationBuilder(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget OrientationBuilder");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static OrientationBuilder orientationBuilderOrientationBuilder(@Builder.Parameter BiFunction<BuildContext, Orientation, Widget> builder) {
    int id = factories.orientationBuilderOrientationBuilder(builder);
    if (id <= 0) throw new RuntimeException("Failed to created widget OrientationBuilder");
    return new OrientationBuilder(id);
  }
  public static OrientationBuilderOrientationBuilderBuilder orientationBuilder(BiFunction<BuildContext, Orientation, Widget> builder) {
    return OrientationBuilderOrientationBuilderBuilder.orientationBuilderOrientationBuilder(builder);
  }
  @Override
  public OrientationBuilder build() {
    return this;
  }
}
