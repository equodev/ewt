package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class GridView extends BoxScrollView implements GridViewI {
  protected GridView() {}
  GridView(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget GridView");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static GridView gridViewCount(Optional<Axis> scrollDirection, Optional<Boolean> reverse, Optional<Boolean> primary, Optional<Boolean> shrinkWrap, Optional<EdgeInsetsGeometryI> padding, int crossAxisCount, OptionalDouble mainAxisSpacing, OptionalDouble crossAxisSpacing, OptionalDouble childAspectRatio, OptionalDouble mainAxisExtent, Optional<Boolean> addAutomaticKeepAlives, Optional<Boolean> addRepaintBoundaries, Optional<Boolean> addSemanticIndexes, OptionalDouble cacheExtent, Optional<List<WidgetI>> children, OptionalInt semanticChildCount, Optional<DragStartBehavior> dragStartBehavior, Optional<ScrollViewKeyboardDismissBehavior> keyboardDismissBehavior, Optional<String> restorationId, Optional<Clip> clipBehavior, Optional<HitTestBehavior> hitTestBehavior) {
    int id = factories.gridViewCount(scrollDirection,
      reverse,
      primary,
      shrinkWrap,
      padding.map(EdgeInsetsGeometryI::build),
      crossAxisCount,
      mainAxisSpacing,
      crossAxisSpacing,
      childAspectRatio,
      mainAxisExtent,
      addAutomaticKeepAlives,
      addRepaintBoundaries,
      addSemanticIndexes,
      cacheExtent,
      children.map(i -> i.stream().map(WidgetI::build).collect(java.util.stream.Collectors.toList())),
      semanticChildCount,
      dragStartBehavior,
      keyboardDismissBehavior,
      restorationId,
      clipBehavior,
      hitTestBehavior);
    if (id <= 0) throw new RuntimeException("Failed to created widget GridView");
    return new GridView(id);
  }
  public static GridViewCountBuilder count() {
    return GridViewCountBuilder.gridViewCount();
  }
  @Builder.Factory
  static GridView gridViewExtent(Optional<Axis> scrollDirection, Optional<Boolean> reverse, Optional<Boolean> primary, Optional<Boolean> shrinkWrap, Optional<EdgeInsetsGeometryI> padding, double maxCrossAxisExtent, OptionalDouble mainAxisSpacing, OptionalDouble crossAxisSpacing, OptionalDouble childAspectRatio, OptionalDouble mainAxisExtent, Optional<Boolean> addAutomaticKeepAlives, Optional<Boolean> addRepaintBoundaries, Optional<Boolean> addSemanticIndexes, OptionalDouble cacheExtent, Optional<List<WidgetI>> children, OptionalInt semanticChildCount, Optional<DragStartBehavior> dragStartBehavior, Optional<ScrollViewKeyboardDismissBehavior> keyboardDismissBehavior, Optional<String> restorationId, Optional<Clip> clipBehavior, Optional<HitTestBehavior> hitTestBehavior) {
    int id = factories.gridViewExtent(scrollDirection,
      reverse,
      primary,
      shrinkWrap,
      padding.map(EdgeInsetsGeometryI::build),
      maxCrossAxisExtent,
      mainAxisSpacing,
      crossAxisSpacing,
      childAspectRatio,
      mainAxisExtent,
      addAutomaticKeepAlives,
      addRepaintBoundaries,
      addSemanticIndexes,
      cacheExtent,
      children.map(i -> i.stream().map(WidgetI::build).collect(java.util.stream.Collectors.toList())),
      semanticChildCount,
      dragStartBehavior,
      keyboardDismissBehavior,
      restorationId,
      clipBehavior,
      hitTestBehavior);
    if (id <= 0) throw new RuntimeException("Failed to created widget GridView");
    return new GridView(id);
  }
  public static GridViewExtentBuilder extent() {
    return GridViewExtentBuilder.gridViewExtent();
  }
  @Override
  public GridView build() {
    return this;
  }
}
