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
    return intToBool(PageViewObjSt.allowImplicitScrolling(st));
  }
  public String restorationId() {
    return PageViewObjSt.restorationId(st).getString(0);
  }
  public Axis scrollDirection() {
    return Axis.values()[PageViewObjSt.scrollDirection(st)];
  }
  public boolean reverse() {
    return intToBool(PageViewObjSt.reverse(st));
  }
  public boolean pageSnapping() {
    return intToBool(PageViewObjSt.pageSnapping(st));
  }
  public DragStartBehavior dragStartBehavior() {
    return DragStartBehavior.values()[PageViewObjSt.dragStartBehavior(st)];
  }
  public Clip clipBehavior() {
    return Clip.values()[PageViewObjSt.clipBehavior(st)];
  }
  public HitTestBehavior hitTestBehavior() {
    return HitTestBehavior.values()[PageViewObjSt.hitTestBehavior(st)];
  }
  public boolean padEnds() {
    return intToBool(PageViewObjSt.padEnds(st));
  }
  @Override
  public PageView build() {
    return this;
  }
}
