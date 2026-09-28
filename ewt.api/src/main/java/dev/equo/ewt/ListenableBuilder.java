package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class ListenableBuilder extends AnimatedWidget implements ListenableBuilderI {
  protected ListenableBuilder() {}
  ListenableBuilder(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget ListenableBuilder");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static ListenableBuilder listenableBuilderListenableBuilder(@Builder.Parameter ListenableI listenable, @Builder.Parameter BiFunction<BuildContext, Widget, Widget> builder, Optional<WidgetI> child) {
    int id = factories.listenableBuilderListenableBuilder(listenable.build(),
      builder,
      child.map(WidgetI::build));
    if (id <= 0) throw new RuntimeException("Failed to created widget ListenableBuilder");
    return new ListenableBuilder(id);
  }
  public static ListenableBuilderListenableBuilderBuilder listenableBuilder(ListenableI listenable, BiFunction<BuildContext, Widget, Widget> builder) {
    return ListenableBuilderListenableBuilderBuilder.listenableBuilderListenableBuilder(listenable, builder);
  }
  public Widget child() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("listenableBuilderChild not supported on web");
    return factories.ListenableBuilder_readBack_child(nativeStruct);
  }
  @Override
  public ListenableBuilder build() {
    return this;
  }
}
