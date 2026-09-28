package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class ListView extends BoxScrollView implements ListViewI {
  protected ListView() {}
  ListView(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget ListView");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static ListView listViewListView(Optional<Axis> scrollDirection, Optional<Boolean> reverse, Optional<Boolean> primary, Optional<Boolean> shrinkWrap, Optional<EdgeInsetsGeometryI> padding, OptionalDouble itemExtent, Optional<WidgetI> prototypeItem, Optional<Boolean> addAutomaticKeepAlives, Optional<Boolean> addRepaintBoundaries, Optional<Boolean> addSemanticIndexes, OptionalDouble cacheExtent, Optional<List<WidgetI>> children, OptionalInt semanticChildCount, Optional<DragStartBehavior> dragStartBehavior, Optional<ScrollViewKeyboardDismissBehavior> keyboardDismissBehavior, Optional<String> restorationId, Optional<Clip> clipBehavior, Optional<HitTestBehavior> hitTestBehavior) {
    int id = factories.listViewListView(scrollDirection,
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
      children.map(i -> i.stream().map(WidgetI::build).collect(java.util.stream.Collectors.toList())),
      semanticChildCount,
      dragStartBehavior,
      keyboardDismissBehavior,
      restorationId,
      clipBehavior,
      hitTestBehavior);
    if (id <= 0) throw new RuntimeException("Failed to created widget ListView");
    return new ListView(id);
  }
  public static ListViewListViewBuilder listView() {
    return ListViewListViewBuilder.listViewListView();
  }
  @Builder.Factory
  static ListView listViewBuilder(Optional<Axis> scrollDirection, Optional<Boolean> reverse, Optional<Boolean> primary, Optional<Boolean> shrinkWrap, Optional<EdgeInsetsGeometryI> padding, OptionalDouble itemExtent, Optional<WidgetI> prototypeItem, BiFunction<BuildContext, Integer, Widget> itemBuilder, OptionalInt itemCount, Optional<Boolean> addAutomaticKeepAlives, Optional<Boolean> addRepaintBoundaries, Optional<Boolean> addSemanticIndexes, OptionalDouble cacheExtent, OptionalInt semanticChildCount, Optional<DragStartBehavior> dragStartBehavior, Optional<ScrollViewKeyboardDismissBehavior> keyboardDismissBehavior, Optional<String> restorationId, Optional<Clip> clipBehavior, Optional<HitTestBehavior> hitTestBehavior) {
    int id = factories.listViewBuilder(scrollDirection,
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
    if (id <= 0) throw new RuntimeException("Failed to created widget ListView");
    return new ListView(id);
  }
  public static ListViewBuilderBuilder builder() {
    return ListViewBuilderBuilder.listViewBuilder();
  }
  @Builder.Factory
  static ListView listViewSeparated(Optional<Axis> scrollDirection, Optional<Boolean> reverse, Optional<Boolean> primary, Optional<Boolean> shrinkWrap, Optional<EdgeInsetsGeometryI> padding, BiFunction<BuildContext, Integer, Widget> itemBuilder, BiFunction<BuildContext, Integer, Widget> separatorBuilder, int itemCount, Optional<Boolean> addAutomaticKeepAlives, Optional<Boolean> addRepaintBoundaries, Optional<Boolean> addSemanticIndexes, OptionalDouble cacheExtent, Optional<DragStartBehavior> dragStartBehavior, Optional<ScrollViewKeyboardDismissBehavior> keyboardDismissBehavior, Optional<String> restorationId, Optional<Clip> clipBehavior, Optional<HitTestBehavior> hitTestBehavior) {
    int id = factories.listViewSeparated(scrollDirection,
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
    if (id <= 0) throw new RuntimeException("Failed to created widget ListView");
    return new ListView(id);
  }
  public static ListViewSeparatedBuilder separated() {
    return ListViewSeparatedBuilder.listViewSeparated();
  }
  public double itemExtent() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("listViewItemExtent not supported on web");
    return factories.ListView_readBack_itemExtent(nativeStruct);
  }
  public Widget prototypeItem() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("listViewPrototypeItem not supported on web");
    return factories.ListView_readBack_prototypeItem(nativeStruct);
  }
  @Override
  public ListView build() {
    return this;
  }
}
