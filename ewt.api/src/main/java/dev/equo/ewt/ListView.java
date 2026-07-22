package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.ListViewObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class ListView extends BoxScrollView implements ListViewI {
  private MemorySegment st;
  protected ListView() {}
  ListView(MemorySegment st) {
    this.id = ListViewObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget ListView");
    System.out.println("New ListView id:"+id);
  }
  @Builder.Factory
  static ListView listViewListView(Optional<Axis> scrollDirection, Optional<Boolean> reverse, Optional<Boolean> primary, Optional<Boolean> shrinkWrap, Optional<EdgeInsetsGeometryI> padding, OptionalDouble itemExtent, Optional<WidgetI> prototypeItem, Optional<Boolean> addAutomaticKeepAlives, Optional<Boolean> addRepaintBoundaries, Optional<Boolean> addSemanticIndexes, OptionalDouble cacheExtent, Optional<List<WidgetI>> children, OptionalInt semanticChildCount, Optional<DragStartBehavior> dragStartBehavior, Optional<ScrollViewKeyboardDismissBehavior> keyboardDismissBehavior, Optional<String> restorationId, Optional<Clip> clipBehavior, Optional<HitTestBehavior> hitTestBehavior) {
    var st = factories.listViewListView(scrollDirection,
      reverse,
      primary,
      shrinkWrap,
      padding.map(EdgeInsetsGeometryI::build),
      itemExtent,
      prototypeItem.map(WidgetI::build),
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
    if (st == null) throw new RuntimeException("Failed to created widget ListView");
    return new ListView(st);
  }
  public static ListViewListViewBuilder listView() {
    return ListViewListViewBuilder.listViewListView();
  }
  @Builder.Factory
  static ListView listViewBuilder(Optional<Axis> scrollDirection, Optional<Boolean> reverse, Optional<Boolean> primary, Optional<Boolean> shrinkWrap, Optional<EdgeInsetsGeometryI> padding, OptionalDouble itemExtent, Optional<WidgetI> prototypeItem, BiFunction<BuildContext, Integer, Widget> itemBuilder, OptionalInt itemCount, Optional<Boolean> addAutomaticKeepAlives, Optional<Boolean> addRepaintBoundaries, Optional<Boolean> addSemanticIndexes, OptionalDouble cacheExtent, OptionalInt semanticChildCount, Optional<DragStartBehavior> dragStartBehavior, Optional<ScrollViewKeyboardDismissBehavior> keyboardDismissBehavior, Optional<String> restorationId, Optional<Clip> clipBehavior, Optional<HitTestBehavior> hitTestBehavior) {
    var st = factories.listViewBuilder(scrollDirection,
      reverse,
      primary,
      shrinkWrap,
      padding.map(EdgeInsetsGeometryI::build),
      itemExtent,
      prototypeItem.map(WidgetI::build),
      itemBuilder,
      itemCount,
      addAutomaticKeepAlives,
      addRepaintBoundaries,
      addSemanticIndexes,
      cacheExtent,
      semanticChildCount,
      dragStartBehavior,
      keyboardDismissBehavior,
      restorationId,
      clipBehavior,
      hitTestBehavior);
    if (st == null) throw new RuntimeException("Failed to created widget ListView");
    return new ListView(st);
  }
  public static ListViewBuilderBuilder builder() {
    return ListViewBuilderBuilder.listViewBuilder();
  }
  @Builder.Factory
  static ListView listViewSeparated(Optional<Axis> scrollDirection, Optional<Boolean> reverse, Optional<Boolean> primary, Optional<Boolean> shrinkWrap, Optional<EdgeInsetsGeometryI> padding, BiFunction<BuildContext, Integer, Widget> itemBuilder, BiFunction<BuildContext, Integer, Widget> separatorBuilder, int itemCount, Optional<Boolean> addAutomaticKeepAlives, Optional<Boolean> addRepaintBoundaries, Optional<Boolean> addSemanticIndexes, OptionalDouble cacheExtent, Optional<DragStartBehavior> dragStartBehavior, Optional<ScrollViewKeyboardDismissBehavior> keyboardDismissBehavior, Optional<String> restorationId, Optional<Clip> clipBehavior, Optional<HitTestBehavior> hitTestBehavior) {
    var st = factories.listViewSeparated(scrollDirection,
      reverse,
      primary,
      shrinkWrap,
      padding.map(EdgeInsetsGeometryI::build),
      itemBuilder,
      separatorBuilder,
      itemCount,
      addAutomaticKeepAlives,
      addRepaintBoundaries,
      addSemanticIndexes,
      cacheExtent,
      dragStartBehavior,
      keyboardDismissBehavior,
      restorationId,
      clipBehavior,
      hitTestBehavior);
    if (st == null) throw new RuntimeException("Failed to created widget ListView");
    return new ListView(st);
  }
  public static ListViewSeparatedBuilder separated() {
    return ListViewSeparatedBuilder.listViewSeparated();
  }
  public double itemExtent() {
    return ListViewObjSt.itemExtent(st);
  }
  public Widget prototypeItem() {
    return new Widget(ListViewObjSt.prototypeItem(st)) {};
  }
  @Override
  public ListView build() {
    return this;
  }
}
