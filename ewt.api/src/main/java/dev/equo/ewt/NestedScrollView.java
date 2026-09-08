package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.NestedScrollViewObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class NestedScrollView extends StatefulWidget implements NestedScrollViewI {
  private MemorySegment st;
  protected NestedScrollView() {}
  NestedScrollView(MemorySegment st) {
    this.id = NestedScrollViewObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget NestedScrollView");
    System.out.println("New NestedScrollView id:"+id);
  }
  NestedScrollView(int id) { this.id = id; }
  @Builder.Factory
  static NestedScrollView nestedScrollViewNestedScrollView(Optional<Axis> scrollDirection, Optional<Boolean> reverse, BiFunction<BuildContext, Boolean, List<Widget>> headerSliverBuilder, WidgetI body, Optional<DragStartBehavior> dragStartBehavior, Optional<Boolean> floatHeaderSlivers, Optional<Clip> clipBehavior, Optional<HitTestBehavior> hitTestBehavior, Optional<String> restorationId) {
    var st = factories.nestedScrollViewNestedScrollView(scrollDirection,
      reverse,
      headerSliverBuilder,
      body.build(),
      dragStartBehavior,
      floatHeaderSlivers,
      clipBehavior,
      hitTestBehavior,
      restorationId);
    if (st == null) throw new RuntimeException("Failed to created widget NestedScrollView");
    return new NestedScrollView(st);
  }
  public static NestedScrollViewNestedScrollViewBuilder nestedScrollView() {
    return NestedScrollViewNestedScrollViewBuilder.nestedScrollViewNestedScrollView();
  }
  public Axis scrollDirection() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("nestedScrollViewScrollDirection not supported on web");
    return Axis.values()[NestedScrollViewObjSt.scrollDirection(st)];
  }
  public boolean reverse() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("nestedScrollViewReverse not supported on web");
    return intToBool(NestedScrollViewObjSt.reverse(st));
  }
  public Widget body() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("nestedScrollViewBody not supported on web");
    return new Widget(NestedScrollViewObjSt.body(st)) {};
  }
  public DragStartBehavior dragStartBehavior() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("nestedScrollViewDragStartBehavior not supported on web");
    return DragStartBehavior.values()[NestedScrollViewObjSt.dragStartBehavior(st)];
  }
  public boolean floatHeaderSlivers() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("nestedScrollViewFloatHeaderSlivers not supported on web");
    return intToBool(NestedScrollViewObjSt.floatHeaderSlivers(st));
  }
  public Clip clipBehavior() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("nestedScrollViewClipBehavior not supported on web");
    return Clip.values()[NestedScrollViewObjSt.clipBehavior(st)];
  }
  public HitTestBehavior hitTestBehavior() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("nestedScrollViewHitTestBehavior not supported on web");
    return HitTestBehavior.values()[NestedScrollViewObjSt.hitTestBehavior(st)];
  }
  public String restorationId() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("nestedScrollViewRestorationId not supported on web");
    return NestedScrollViewObjSt.restorationId(st).getString(0);
  }
  @Override
  public NestedScrollView build() {
    return this;
  }
}
