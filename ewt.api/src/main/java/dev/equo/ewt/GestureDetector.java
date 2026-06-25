package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.GestureDetectorObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class GestureDetector extends StatelessWidget implements GestureDetectorI {
  private MemorySegment st;
  protected GestureDetector() {}
  GestureDetector(MemorySegment st) {
    this.id = GestureDetectorObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget GestureDetector");
    System.out.println("New GestureDetector id:"+id);
  }
  @Builder.Factory
  static GestureDetector gestureDetectorGestureDetector(Optional<WidgetI> child, Optional<Runnable> onTap, Optional<Runnable> onTapCancel, Optional<Runnable> onSecondaryTap, Optional<Runnable> onSecondaryTapCancel, Optional<Runnable> onTertiaryTapCancel, Optional<Runnable> onDoubleTap, Optional<Runnable> onDoubleTapCancel, Optional<Runnable> onLongPressCancel, Optional<Runnable> onLongPress, Optional<Runnable> onLongPressUp, Optional<Runnable> onSecondaryLongPressCancel, Optional<Runnable> onSecondaryLongPress, Optional<Runnable> onSecondaryLongPressUp, Optional<Runnable> onTertiaryLongPressCancel, Optional<Runnable> onTertiaryLongPress, Optional<Runnable> onTertiaryLongPressUp, Optional<Runnable> onVerticalDragCancel, Optional<Runnable> onHorizontalDragCancel, Optional<Runnable> onPanCancel, Optional<HitTestBehavior> behavior, Optional<Boolean> excludeFromSemantics, Optional<DragStartBehavior> dragStartBehavior, Optional<Boolean> trackpadScrollCausesScale, Optional<OffsetI> trackpadScrollToScaleFactor) {
    var st = factories.gestureDetectorGestureDetector(child.map(WidgetI::build),
      onTap,
      onTapCancel,
      onSecondaryTap,
      onSecondaryTapCancel,
      onTertiaryTapCancel,
      onDoubleTap,
      onDoubleTapCancel,
      onLongPressCancel,
      onLongPress,
      onLongPressUp,
      onSecondaryLongPressCancel,
      onSecondaryLongPress,
      onSecondaryLongPressUp,
      onTertiaryLongPressCancel,
      onTertiaryLongPress,
      onTertiaryLongPressUp,
      onVerticalDragCancel,
      onHorizontalDragCancel,
      onPanCancel,
      behavior,
      excludeFromSemantics,
      dragStartBehavior,
      trackpadScrollCausesScale,
      trackpadScrollToScaleFactor.map(OffsetI::build));
    if (st == null) throw new RuntimeException("Failed to created widget GestureDetector");
    return new GestureDetector(st);
  }
  public static GestureDetectorGestureDetectorBuilder gestureDetector() {
    return GestureDetectorGestureDetectorBuilder.gestureDetectorGestureDetector();
  }
  public Widget child() {
    return new Widget(GestureDetectorObjSt.child(st)) {};
  }
  public HitTestBehavior behavior() {
    return HitTestBehavior.values()[GestureDetectorObjSt.behavior(st)];
  }
  public boolean excludeFromSemantics() {
    return intToBool(GestureDetectorObjSt.excludeFromSemantics(st));
  }
  public DragStartBehavior dragStartBehavior() {
    return DragStartBehavior.values()[GestureDetectorObjSt.dragStartBehavior(st)];
  }
  public boolean trackpadScrollCausesScale() {
    return intToBool(GestureDetectorObjSt.trackpadScrollCausesScale(st));
  }
  public Offset trackpadScrollToScaleFactor() {
    return new Offset(GestureDetectorObjSt.trackpadScrollToScaleFactor(st));
  }
  @Override
  public GestureDetector build() {
    return this;
  }
}
