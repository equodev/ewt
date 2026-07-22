package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.PageViewObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class PageView extends StatefulWidget implements PageViewI {
  private MemorySegment st;
  protected PageView() {}
  PageView(MemorySegment st) {
    this.id = PageViewObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget PageView");
    System.out.println("New PageView id:"+id);
  }
  PageView(int id) { this.id = id; }
  @Builder.Factory
  static PageView pageViewPageView(Optional<Axis> scrollDirection, Optional<Boolean> reverse, Optional<Boolean> pageSnapping, Optional<Consumer<Integer>> onPageChanged, Optional<List<WidgetI>> children, Optional<DragStartBehavior> dragStartBehavior, Optional<Boolean> allowImplicitScrolling, Optional<String> restorationId, Optional<Clip> clipBehavior, Optional<HitTestBehavior> hitTestBehavior, Optional<Boolean> padEnds) {
    var st = factories.pageViewPageView(scrollDirection,
      reverse,
      pageSnapping,
      onPageChanged,
      children.map(i -> i.stream().map(WidgetI::build).toList()),
      dragStartBehavior,
      allowImplicitScrolling,
      restorationId,
      clipBehavior,
      hitTestBehavior,
      padEnds);
    if (st == null) throw new RuntimeException("Failed to created widget PageView");
    return new PageView(st);
  }
  public static PageViewPageViewBuilder pageView() {
    return PageViewPageViewBuilder.pageViewPageView();
  }
  @Builder.Factory
  static PageView pageViewBuilder(Optional<Axis> scrollDirection, Optional<Boolean> reverse, Optional<Boolean> pageSnapping, Optional<Consumer<Integer>> onPageChanged, BiFunction<BuildContext, Integer, Widget> itemBuilder, OptionalInt itemCount, Optional<DragStartBehavior> dragStartBehavior, Optional<Boolean> allowImplicitScrolling, Optional<String> restorationId, Optional<Clip> clipBehavior, Optional<HitTestBehavior> hitTestBehavior, Optional<Boolean> padEnds) {
    var st = factories.pageViewBuilder(scrollDirection,
      reverse,
      pageSnapping,
      onPageChanged,
      itemBuilder,
      itemCount,
      dragStartBehavior,
      allowImplicitScrolling,
      restorationId,
      clipBehavior,
      hitTestBehavior,
      padEnds);
    if (st == null) throw new RuntimeException("Failed to created widget PageView");
    return new PageView(st);
  }
  public static PageViewBuilderBuilder builder() {
    return PageViewBuilderBuilder.pageViewBuilder();
  }
  public boolean allowImplicitScrolling() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("pageViewAllowImplicitScrolling not supported on web");
    return intToBool(PageViewObjSt.allowImplicitScrolling(st));
  }
  public String restorationId() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("pageViewRestorationId not supported on web");
    return PageViewObjSt.restorationId(st).getString(0);
  }
  public Axis scrollDirection() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("pageViewScrollDirection not supported on web");
    return Axis.values()[PageViewObjSt.scrollDirection(st)];
  }
  public boolean reverse() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("pageViewReverse not supported on web");
    return intToBool(PageViewObjSt.reverse(st));
  }
  public boolean pageSnapping() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("pageViewPageSnapping not supported on web");
    return intToBool(PageViewObjSt.pageSnapping(st));
  }
  public DragStartBehavior dragStartBehavior() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("pageViewDragStartBehavior not supported on web");
    return DragStartBehavior.values()[PageViewObjSt.dragStartBehavior(st)];
  }
  public Clip clipBehavior() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("pageViewClipBehavior not supported on web");
    return Clip.values()[PageViewObjSt.clipBehavior(st)];
  }
  public HitTestBehavior hitTestBehavior() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("pageViewHitTestBehavior not supported on web");
    return HitTestBehavior.values()[PageViewObjSt.hitTestBehavior(st)];
  }
  public boolean padEnds() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("pageViewPadEnds not supported on web");
    return intToBool(PageViewObjSt.padEnds(st));
  }
  @Override
  public PageView build() {
    return this;
  }
}
