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
  GestureDetector(int id) { this.id = id; }
  @Builder.Factory
  static GestureDetector gestureDetectorGestureDetector(Optional<WidgetI> child, Optional<Consumer<TapDownDetails>> onTapDown, Optional<Consumer<TapUpDetails>> onTapUp, Optional<Runnable> onTap, Optional<Consumer<TapMoveDetails>> onTapMove, Optional<Runnable> onTapCancel, Optional<Runnable> onSecondaryTap, Optional<Consumer<TapDownDetails>> onSecondaryTapDown, Optional<Consumer<TapUpDetails>> onSecondaryTapUp, Optional<Runnable> onSecondaryTapCancel, Optional<Consumer<TapDownDetails>> onTertiaryTapDown, Optional<Consumer<TapUpDetails>> onTertiaryTapUp, Optional<Runnable> onTertiaryTapCancel, Optional<Consumer<TapDownDetails>> onDoubleTapDown, Optional<Runnable> onDoubleTap, Optional<Runnable> onDoubleTapCancel, Optional<Consumer<LongPressDownDetails>> onLongPressDown, Optional<Runnable> onLongPressCancel, Optional<Runnable> onLongPress, Optional<Consumer<LongPressStartDetails>> onLongPressStart, Optional<Consumer<LongPressMoveUpdateDetails>> onLongPressMoveUpdate, Optional<Runnable> onLongPressUp, Optional<Consumer<LongPressEndDetails>> onLongPressEnd, Optional<Consumer<LongPressDownDetails>> onSecondaryLongPressDown, Optional<Runnable> onSecondaryLongPressCancel, Optional<Runnable> onSecondaryLongPress, Optional<Consumer<LongPressStartDetails>> onSecondaryLongPressStart, Optional<Consumer<LongPressMoveUpdateDetails>> onSecondaryLongPressMoveUpdate, Optional<Runnable> onSecondaryLongPressUp, Optional<Consumer<LongPressEndDetails>> onSecondaryLongPressEnd, Optional<Consumer<LongPressDownDetails>> onTertiaryLongPressDown, Optional<Runnable> onTertiaryLongPressCancel, Optional<Runnable> onTertiaryLongPress, Optional<Consumer<LongPressStartDetails>> onTertiaryLongPressStart, Optional<Consumer<LongPressMoveUpdateDetails>> onTertiaryLongPressMoveUpdate, Optional<Runnable> onTertiaryLongPressUp, Optional<Consumer<LongPressEndDetails>> onTertiaryLongPressEnd, Optional<Consumer<DragDownDetails>> onVerticalDragDown, Optional<Consumer<DragStartDetails>> onVerticalDragStart, Optional<Consumer<DragUpdateDetails>> onVerticalDragUpdate, Optional<Consumer<DragEndDetails>> onVerticalDragEnd, Optional<Runnable> onVerticalDragCancel, Optional<Consumer<DragDownDetails>> onHorizontalDragDown, Optional<Consumer<DragStartDetails>> onHorizontalDragStart, Optional<Consumer<DragUpdateDetails>> onHorizontalDragUpdate, Optional<Consumer<DragEndDetails>> onHorizontalDragEnd, Optional<Runnable> onHorizontalDragCancel, Optional<Consumer<ForcePressDetails>> onForcePressStart, Optional<Consumer<ForcePressDetails>> onForcePressPeak, Optional<Consumer<ForcePressDetails>> onForcePressUpdate, Optional<Consumer<ForcePressDetails>> onForcePressEnd, Optional<Consumer<DragDownDetails>> onPanDown, Optional<Consumer<DragStartDetails>> onPanStart, Optional<Consumer<DragUpdateDetails>> onPanUpdate, Optional<Consumer<DragEndDetails>> onPanEnd, Optional<Runnable> onPanCancel, Optional<Consumer<ScaleStartDetails>> onScaleStart, Optional<Consumer<ScaleUpdateDetails>> onScaleUpdate, Optional<Consumer<ScaleEndDetails>> onScaleEnd, Optional<HitTestBehavior> behavior, Optional<Boolean> excludeFromSemantics, Optional<DragStartBehavior> dragStartBehavior, Optional<Boolean> trackpadScrollCausesScale, Optional<OffsetI> trackpadScrollToScaleFactor) {
    var st = factories.gestureDetectorGestureDetector(child.map(WidgetI::build),
      onTapDown,
      onTapUp,
      onTap,
      onTapMove,
      onTapCancel,
      onSecondaryTap,
      onSecondaryTapDown,
      onSecondaryTapUp,
      onSecondaryTapCancel,
      onTertiaryTapDown,
      onTertiaryTapUp,
      onTertiaryTapCancel,
      onDoubleTapDown,
      onDoubleTap,
      onDoubleTapCancel,
      onLongPressDown,
      onLongPressCancel,
      onLongPress,
      onLongPressStart,
      onLongPressMoveUpdate,
      onLongPressUp,
      onLongPressEnd,
      onSecondaryLongPressDown,
      onSecondaryLongPressCancel,
      onSecondaryLongPress,
      onSecondaryLongPressStart,
      onSecondaryLongPressMoveUpdate,
      onSecondaryLongPressUp,
      onSecondaryLongPressEnd,
      onTertiaryLongPressDown,
      onTertiaryLongPressCancel,
      onTertiaryLongPress,
      onTertiaryLongPressStart,
      onTertiaryLongPressMoveUpdate,
      onTertiaryLongPressUp,
      onTertiaryLongPressEnd,
      onVerticalDragDown,
      onVerticalDragStart,
      onVerticalDragUpdate,
      onVerticalDragEnd,
      onVerticalDragCancel,
      onHorizontalDragDown,
      onHorizontalDragStart,
      onHorizontalDragUpdate,
      onHorizontalDragEnd,
      onHorizontalDragCancel,
      onForcePressStart,
      onForcePressPeak,
      onForcePressUpdate,
      onForcePressEnd,
      onPanDown,
      onPanStart,
      onPanUpdate,
      onPanEnd,
      onPanCancel,
      onScaleStart,
      onScaleUpdate,
      onScaleEnd,
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
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("gestureDetectorChild not supported on web");
    return new Widget(GestureDetectorObjSt.child(st)) {};
  }
  public HitTestBehavior behavior() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("gestureDetectorBehavior not supported on web");
    return HitTestBehavior.values()[GestureDetectorObjSt.behavior(st)];
  }
  public boolean excludeFromSemantics() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("gestureDetectorExcludeFromSemantics not supported on web");
    return intToBool(GestureDetectorObjSt.excludeFromSemantics(st));
  }
  public DragStartBehavior dragStartBehavior() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("gestureDetectorDragStartBehavior not supported on web");
    return DragStartBehavior.values()[GestureDetectorObjSt.dragStartBehavior(st)];
  }
  public boolean trackpadScrollCausesScale() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("gestureDetectorTrackpadScrollCausesScale not supported on web");
    return intToBool(GestureDetectorObjSt.trackpadScrollCausesScale(st));
  }
  public Offset trackpadScrollToScaleFactor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("gestureDetectorTrackpadScrollToScaleFactor", getId());
      return new Offset(__nid);
    }
    return new Offset(GestureDetectorObjSt.trackpadScrollToScaleFactor(st));
  }
  @Override
  public GestureDetector build() {
    return this;
  }
}
