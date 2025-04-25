package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.AnimatedBuilderObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class AnimatedBuilder extends ListenableBuilder implements AnimatedBuilderI {
  private MemorySegment st;
  protected AnimatedBuilder() {}
  AnimatedBuilder(MemorySegment st) {
    this.id = AnimatedBuilderObjSt.id(st);
    this.st = st;
    System.out.println("New AnimatedBuilder id:"+id);
  }
  @Builder.Factory
  static AnimatedBuilder animatedBuilderAnimatedBuilder(@Builder.Parameter ListenableI animation, @Builder.Parameter BiFunction<BuildContext, Widget, Widget> builder, Optional<WidgetI> child) {
    var st = factories.animatedBuilderAnimatedBuilder(animation.build(),
      builder,
      child.map(WidgetI::build));
    if (st == null) throw new RuntimeException("Failed to created widget AnimatedBuilder");
    return new AnimatedBuilder(st);
  }
  public static AnimatedBuilderAnimatedBuilderBuilder animatedBuilder(ListenableI animation, BiFunction<BuildContext, Widget, Widget> builder) {
    return AnimatedBuilderAnimatedBuilderBuilder.animatedBuilderAnimatedBuilder(animation, builder);
  }
  public Listenable animation() {
    return new Listenable() { public int getId() { return AnimatedBuilderObjSt.animation(st); } };
  }
  @Override
  public AnimatedBuilder build() {
    return this;
  }
}
