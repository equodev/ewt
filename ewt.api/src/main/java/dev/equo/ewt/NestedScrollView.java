package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class NestedScrollView extends StatefulWidget implements NestedScrollViewI {
  protected NestedScrollView() {}
  NestedScrollView(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget NestedScrollView");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static NestedScrollView nestedScrollViewNestedScrollView(Optional<Axis> scrollDirection, Optional<Boolean> reverse, BiFunction<BuildContext, Boolean, List<Widget>> headerSliverBuilder, WidgetI body, Optional<DragStartBehavior> dragStartBehavior, Optional<Boolean> floatHeaderSlivers, Optional<Clip> clipBehavior, Optional<HitTestBehavior> hitTestBehavior, Optional<String> restorationId) {
    int id = factories.nestedScrollViewNestedScrollView(scrollDirection,
      reverse,
      headerSliverBuilder,
      body.build(),
      dragStartBehavior,
      floatHeaderSlivers,
      clipBehavior,
      hitTestBehavior,
      restorationId);
    if (id <= 0) throw new RuntimeException("Failed to created widget NestedScrollView");
    return new NestedScrollView(id);
  }
  public static NestedScrollViewNestedScrollViewBuilder nestedScrollView() {
    return NestedScrollViewNestedScrollViewBuilder.nestedScrollViewNestedScrollView();
  }
  public Axis scrollDirection() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("nestedScrollViewScrollDirection not supported on web");
    return factories.NestedScrollView_readBack_scrollDirection(nativeStruct);
  }
  public boolean reverse() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("nestedScrollViewReverse not supported on web");
    return factories.NestedScrollView_readBack_reverse(nativeStruct);
  }
  public Widget body() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("nestedScrollViewBody not supported on web");
    return factories.NestedScrollView_readBack_body(nativeStruct);
  }
  public DragStartBehavior dragStartBehavior() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("nestedScrollViewDragStartBehavior not supported on web");
    return factories.NestedScrollView_readBack_dragStartBehavior(nativeStruct);
  }
  public boolean floatHeaderSlivers() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("nestedScrollViewFloatHeaderSlivers not supported on web");
    return factories.NestedScrollView_readBack_floatHeaderSlivers(nativeStruct);
  }
  public Clip clipBehavior() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("nestedScrollViewClipBehavior not supported on web");
    return factories.NestedScrollView_readBack_clipBehavior(nativeStruct);
  }
  public HitTestBehavior hitTestBehavior() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("nestedScrollViewHitTestBehavior not supported on web");
    return factories.NestedScrollView_readBack_hitTestBehavior(nativeStruct);
  }
  public String restorationId() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("nestedScrollViewRestorationId not supported on web");
    return factories.NestedScrollView_readBack_restorationId(nativeStruct);
  }
  @Override
  public NestedScrollView build() {
    return this;
  }
}
