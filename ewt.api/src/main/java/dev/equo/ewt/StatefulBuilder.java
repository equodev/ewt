package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class StatefulBuilder extends StatefulWidget implements StatefulBuilderI {
  protected StatefulBuilder() {}
  StatefulBuilder(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget StatefulBuilder");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static StatefulBuilder statefulBuilderStatefulBuilder(@Builder.Parameter BiFunction<BuildContext, Consumer<Runnable>, Widget> builder) {
    int id = factories.statefulBuilderStatefulBuilder(builder);
    if (id <= 0) throw new RuntimeException("Failed to created widget StatefulBuilder");
    return new StatefulBuilder(id);
  }
  public static StatefulBuilderStatefulBuilderBuilder statefulBuilder(BiFunction<BuildContext, Consumer<Runnable>, Widget> builder) {
    return StatefulBuilderStatefulBuilderBuilder.statefulBuilderStatefulBuilder(builder);
  }
  @Override
  public StatefulBuilder build() {
    return this;
  }
}
