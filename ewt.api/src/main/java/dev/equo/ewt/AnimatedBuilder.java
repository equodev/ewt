package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class AnimatedBuilder extends ListenableBuilder implements AnimatedBuilderI {
  protected AnimatedBuilder() {}
  AnimatedBuilder(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget AnimatedBuilder");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static AnimatedBuilder animatedBuilderAnimatedBuilder(@Builder.Parameter ListenableI animation, @Builder.Parameter BiFunction<BuildContext, Widget, Widget> builder, Optional<WidgetI> child) {
    int id = factories.animatedBuilderAnimatedBuilder(animation.build(),
      builder,
      child.map(WidgetI::build));
    if (id <= 0) throw new RuntimeException("Failed to created widget AnimatedBuilder");
    return new AnimatedBuilder(id);
  }
  public static AnimatedBuilderAnimatedBuilderBuilder animatedBuilder(ListenableI animation, BiFunction<BuildContext, Widget, Widget> builder) {
    return AnimatedBuilderAnimatedBuilderBuilder.animatedBuilderAnimatedBuilder(animation, builder);
  }
  public Listenable animation() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("animatedBuilderAnimation not supported on web");
    return factories.AnimatedBuilder_readBack_animation(nativeStruct);
  }
  @Override
  public AnimatedBuilder build() {
    return this;
  }
}
