package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.SingleChildScrollViewObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class SingleChildScrollView extends StatelessWidget implements SingleChildScrollViewI {
  private MemorySegment st;
  protected SingleChildScrollView() {}
  SingleChildScrollView(MemorySegment st) {
    this.id = SingleChildScrollViewObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget SingleChildScrollView");
    System.out.println("New SingleChildScrollView id:"+id);
  }
  SingleChildScrollView(int id) { this.id = id; }
  @Builder.Factory
  static SingleChildScrollView singleChildScrollViewSingleChildScrollView(Optional<Axis> scrollDirection, Optional<Boolean> reverse, Optional<EdgeInsetsGeometryI> padding, Optional<Boolean> primary, Optional<WidgetI> child, Optional<DragStartBehavior> dragStartBehavior, Optional<Clip> clipBehavior, Optional<HitTestBehavior> hitTestBehavior, Optional<String> restorationId, Optional<ScrollViewKeyboardDismissBehavior> keyboardDismissBehavior) {
    var st = factories.singleChildScrollViewSingleChildScrollView(scrollDirection,
      reverse,
      padding.map(EdgeInsetsGeometryI::build),
      primary,
      child.map(WidgetI::build),
      dragStartBehavior,
      clipBehavior,
      hitTestBehavior,
      restorationId,
      keyboardDismissBehavior);
    if (st == null) throw new RuntimeException("Failed to created widget SingleChildScrollView");
    return new SingleChildScrollView(st);
  }
  public static SingleChildScrollViewSingleChildScrollViewBuilder singleChildScrollView() {
    return SingleChildScrollViewSingleChildScrollViewBuilder.singleChildScrollViewSingleChildScrollView();
  }
  public Axis scrollDirection() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("singleChildScrollViewScrollDirection not supported on web");
    return Axis.values()[SingleChildScrollViewObjSt.scrollDirection(st)];
  }
  public boolean reverse() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("singleChildScrollViewReverse not supported on web");
    return intToBool(SingleChildScrollViewObjSt.reverse(st));
  }
  public EdgeInsetsGeometry padding() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("singleChildScrollViewPadding not supported on web");
    return new EdgeInsetsGeometry(SingleChildScrollViewObjSt.padding(st)) {};
  }
  public boolean primary() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("singleChildScrollViewPrimary not supported on web");
    return intToBool(SingleChildScrollViewObjSt.primary(st));
  }
  public Widget child() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("singleChildScrollViewChild not supported on web");
    return new Widget(SingleChildScrollViewObjSt.child(st)) {};
  }
  public DragStartBehavior dragStartBehavior() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("singleChildScrollViewDragStartBehavior not supported on web");
    return DragStartBehavior.values()[SingleChildScrollViewObjSt.dragStartBehavior(st)];
  }
  public Clip clipBehavior() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("singleChildScrollViewClipBehavior not supported on web");
    return Clip.values()[SingleChildScrollViewObjSt.clipBehavior(st)];
  }
  public HitTestBehavior hitTestBehavior() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("singleChildScrollViewHitTestBehavior not supported on web");
    return HitTestBehavior.values()[SingleChildScrollViewObjSt.hitTestBehavior(st)];
  }
  public String restorationId() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("singleChildScrollViewRestorationId not supported on web");
    return SingleChildScrollViewObjSt.restorationId(st).getString(0);
  }
  public ScrollViewKeyboardDismissBehavior keyboardDismissBehavior() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("singleChildScrollViewKeyboardDismissBehavior not supported on web");
    return ScrollViewKeyboardDismissBehavior.values()[SingleChildScrollViewObjSt.keyboardDismissBehavior(st)];
  }
  @Override
  public SingleChildScrollView build() {
    return this;
  }
}
