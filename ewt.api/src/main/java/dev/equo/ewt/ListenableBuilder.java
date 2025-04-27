package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.ListenableBuilderObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class ListenableBuilder extends AnimatedWidget implements ListenableBuilderI {
  private MemorySegment st;
  protected ListenableBuilder() {}
  ListenableBuilder(MemorySegment st) {
    this.id = ListenableBuilderObjSt.id(st);
    this.st = st;
    System.out.println("New ListenableBuilder id:"+id);
  }
  @Builder.Factory
  static ListenableBuilder listenableBuilderListenableBuilder(@Builder.Parameter ListenableI listenable, @Builder.Parameter BiFunction<BuildContext, Widget, Widget> builder, Optional<WidgetI> child) {
    var st = factories.listenableBuilderListenableBuilder(listenable.build(),
      builder,
      child.map(WidgetI::build));
    if (st == null) throw new RuntimeException("Failed to created widget ListenableBuilder");
    return new ListenableBuilder(st);
  }
  public static ListenableBuilderListenableBuilderBuilder listenableBuilder(ListenableI listenable, BiFunction<BuildContext, Widget, Widget> builder) {
    return ListenableBuilderListenableBuilderBuilder.listenableBuilderListenableBuilder(listenable, builder);
  }
  public Widget child() {
    return new Widget(ListenableBuilderObjSt.child(st)) {};
  }
  @Override
  public ListenableBuilder build() {
    return this;
  }
}
