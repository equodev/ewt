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
    return Axis.values()[SingleChildScrollViewObjSt.scrollDirection(st)];
  }
  public boolean reverse() {
    return intToBool(SingleChildScrollViewObjSt.reverse(st));
  }
  public EdgeInsetsGeometry padding() {
    return new EdgeInsetsGeometry(SingleChildScrollViewObjSt.padding(st)) {};
  }
  public boolean primary() {
    return intToBool(SingleChildScrollViewObjSt.primary(st));
  }
  public Widget child() {
    return new Widget(SingleChildScrollViewObjSt.child(st)) {};
  }
  public DragStartBehavior dragStartBehavior() {
    return DragStartBehavior.values()[SingleChildScrollViewObjSt.dragStartBehavior(st)];
  }
  public Clip clipBehavior() {
    return Clip.values()[SingleChildScrollViewObjSt.clipBehavior(st)];
  }
  public HitTestBehavior hitTestBehavior() {
    return HitTestBehavior.values()[SingleChildScrollViewObjSt.hitTestBehavior(st)];
  }
  public String restorationId() {
    return SingleChildScrollViewObjSt.restorationId(st).getString(0);
  }
  public ScrollViewKeyboardDismissBehavior keyboardDismissBehavior() {
    return ScrollViewKeyboardDismissBehavior.values()[SingleChildScrollViewObjSt.keyboardDismissBehavior(st)];
  }
  @Override
  public SingleChildScrollView build() {
    return this;
  }
}
