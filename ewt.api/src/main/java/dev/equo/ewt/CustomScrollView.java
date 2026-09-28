package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class CustomScrollView extends ScrollView implements CustomScrollViewI {
  protected CustomScrollView() {}
  CustomScrollView(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget CustomScrollView");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static CustomScrollView customScrollViewCustomScrollView(Optional<Axis> scrollDirection, Optional<Boolean> reverse, Optional<Boolean> primary, Optional<Boolean> shrinkWrap, OptionalDouble anchor, OptionalDouble cacheExtent, Optional<SliverPaintOrder> paintOrder, Optional<List<WidgetI>> slivers, OptionalInt semanticChildCount, Optional<DragStartBehavior> dragStartBehavior, Optional<ScrollViewKeyboardDismissBehavior> keyboardDismissBehavior, Optional<String> restorationId, Optional<Clip> clipBehavior, Optional<HitTestBehavior> hitTestBehavior) {
    int id = factories.customScrollViewCustomScrollView(scrollDirection,
      reverse,
      primary,
      shrinkWrap,
      anchor,
      cacheExtent,
      paintOrder,
      slivers.map(i -> i.stream().map(WidgetI::build).collect(java.util.stream.Collectors.toList())),
      semanticChildCount,
      dragStartBehavior,
      keyboardDismissBehavior,
      restorationId,
      clipBehavior,
      hitTestBehavior);
    if (id <= 0) throw new RuntimeException("Failed to created widget CustomScrollView");
    return new CustomScrollView(id);
  }
  public static CustomScrollViewCustomScrollViewBuilder customScrollView() {
    return CustomScrollViewCustomScrollViewBuilder.customScrollViewCustomScrollView();
  }
  @Override
  public CustomScrollView build() {
    return this;
  }
}
