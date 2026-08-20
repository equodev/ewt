package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.CustomScrollViewObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class CustomScrollView extends ScrollView implements CustomScrollViewI {
  private MemorySegment st;
  protected CustomScrollView() {}
  CustomScrollView(MemorySegment st) {
    this.id = CustomScrollViewObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget CustomScrollView");
    System.out.println("New CustomScrollView id:"+id);
  }
  CustomScrollView(int id) { this.id = id; }
  @Builder.Factory
  static CustomScrollView customScrollViewCustomScrollView(Optional<Axis> scrollDirection, Optional<Boolean> reverse, Optional<Boolean> primary, Optional<Boolean> shrinkWrap, OptionalDouble anchor, OptionalDouble cacheExtent, Optional<SliverPaintOrder> paintOrder, Optional<List<WidgetI>> slivers, OptionalInt semanticChildCount, Optional<DragStartBehavior> dragStartBehavior, Optional<ScrollViewKeyboardDismissBehavior> keyboardDismissBehavior, Optional<String> restorationId, Optional<Clip> clipBehavior, Optional<HitTestBehavior> hitTestBehavior) {
    var st = factories.customScrollViewCustomScrollView(scrollDirection,
      reverse,
      primary,
      shrinkWrap,
      anchor,
      cacheExtent,
      paintOrder,
      slivers.map(i -> i.stream().map(WidgetI::build).toList()),
      semanticChildCount,
      dragStartBehavior,
      keyboardDismissBehavior,
      restorationId,
      clipBehavior,
      hitTestBehavior);
    if (st == null) throw new RuntimeException("Failed to created widget CustomScrollView");
    return new CustomScrollView(st);
  }
  public static CustomScrollViewCustomScrollViewBuilder customScrollView() {
    return CustomScrollViewCustomScrollViewBuilder.customScrollViewCustomScrollView();
  }
  @Override
  public CustomScrollView build() {
    return this;
  }
}
