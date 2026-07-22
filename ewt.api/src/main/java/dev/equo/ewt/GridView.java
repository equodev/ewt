package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.GridViewObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class GridView extends BoxScrollView implements GridViewI {
  private MemorySegment st;
  protected GridView() {}
  GridView(MemorySegment st) {
    this.id = GridViewObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget GridView");
    System.out.println("New GridView id:"+id);
  }
  @Builder.Factory
  static GridView gridViewCount(Optional<Axis> scrollDirection, Optional<Boolean> reverse, Optional<Boolean> primary, Optional<Boolean> shrinkWrap, Optional<EdgeInsetsGeometryI> padding, int crossAxisCount, OptionalDouble mainAxisSpacing, OptionalDouble crossAxisSpacing, OptionalDouble childAspectRatio, Optional<Boolean> addAutomaticKeepAlives, Optional<Boolean> addRepaintBoundaries, Optional<Boolean> addSemanticIndexes, OptionalDouble cacheExtent, Optional<List<WidgetI>> children, OptionalInt semanticChildCount, Optional<DragStartBehavior> dragStartBehavior, Optional<ScrollViewKeyboardDismissBehavior> keyboardDismissBehavior, Optional<String> restorationId, Optional<Clip> clipBehavior, Optional<HitTestBehavior> hitTestBehavior) {
    var st = factories.gridViewCount(scrollDirection,
      reverse,
      primary,
      shrinkWrap,
      padding.map(EdgeInsetsGeometryI::build),
      crossAxisCount,
      mainAxisSpacing,
      crossAxisSpacing,
      childAspectRatio,
      addAutomaticKeepAlives,
      addRepaintBoundaries,
      addSemanticIndexes,
      cacheExtent,
      children.map(i -> i.stream().map(WidgetI::build).toList()),
      semanticChildCount,
      dragStartBehavior,
      keyboardDismissBehavior,
      restorationId,
      clipBehavior,
      hitTestBehavior);
    if (st == null) throw new RuntimeException("Failed to created widget GridView");
    return new GridView(st);
  }
  public static GridViewCountBuilder count() {
    return GridViewCountBuilder.gridViewCount();
  }
  @Builder.Factory
  static GridView gridViewExtent(Optional<Axis> scrollDirection, Optional<Boolean> reverse, Optional<Boolean> primary, Optional<Boolean> shrinkWrap, Optional<EdgeInsetsGeometryI> padding, double maxCrossAxisExtent, OptionalDouble mainAxisSpacing, OptionalDouble crossAxisSpacing, OptionalDouble childAspectRatio, Optional<Boolean> addAutomaticKeepAlives, Optional<Boolean> addRepaintBoundaries, Optional<Boolean> addSemanticIndexes, OptionalDouble cacheExtent, Optional<List<WidgetI>> children, OptionalInt semanticChildCount, Optional<DragStartBehavior> dragStartBehavior, Optional<ScrollViewKeyboardDismissBehavior> keyboardDismissBehavior, Optional<String> restorationId, Optional<Clip> clipBehavior, Optional<HitTestBehavior> hitTestBehavior) {
    var st = factories.gridViewExtent(scrollDirection,
      reverse,
      primary,
      shrinkWrap,
      padding.map(EdgeInsetsGeometryI::build),
      maxCrossAxisExtent,
      mainAxisSpacing,
      crossAxisSpacing,
      childAspectRatio,
      addAutomaticKeepAlives,
      addRepaintBoundaries,
      addSemanticIndexes,
      cacheExtent,
      children.map(i -> i.stream().map(WidgetI::build).toList()),
      semanticChildCount,
      dragStartBehavior,
      keyboardDismissBehavior,
      restorationId,
      clipBehavior,
      hitTestBehavior);
    if (st == null) throw new RuntimeException("Failed to created widget GridView");
    return new GridView(st);
  }
  public static GridViewExtentBuilder extent() {
    return GridViewExtentBuilder.gridViewExtent();
  }
  @Override
  public GridView build() {
    return this;
  }
}
