package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.StatefulBuilderObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class StatefulBuilder extends StatefulWidget implements StatefulBuilderI {
  private MemorySegment st;
  protected StatefulBuilder() {}
  StatefulBuilder(MemorySegment st) {
    this.id = StatefulBuilderObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget StatefulBuilder");
    System.out.println("New StatefulBuilder id:"+id);
  }
  StatefulBuilder(int id) { this.id = id; }
  @Builder.Factory
  static StatefulBuilder statefulBuilderStatefulBuilder(@Builder.Parameter BiFunction<BuildContext, Consumer<Runnable>, Widget> builder) {
    var st = factories.statefulBuilderStatefulBuilder(builder);
    if (st == null) throw new RuntimeException("Failed to created widget StatefulBuilder");
    return new StatefulBuilder(st);
  }
  public static StatefulBuilderStatefulBuilderBuilder statefulBuilder(BiFunction<BuildContext, Consumer<Runnable>, Widget> builder) {
    return StatefulBuilderStatefulBuilderBuilder.statefulBuilderStatefulBuilder(builder);
  }
  @Override
  public StatefulBuilder build() {
    return this;
  }
}
