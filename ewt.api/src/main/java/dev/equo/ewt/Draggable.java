package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.DraggableObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class Draggable<T> extends StatefulWidget implements DraggableI {
  private MemorySegment st;
  protected Draggable() {}
  Draggable(MemorySegment st) {
    this.id = DraggableObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget Draggable");
    System.out.println("New Draggable id:"+id);
  }
  Draggable(int id) { this.id = id; }
  @Builder.Factory
  static <T extends NativeObj> Draggable<T> draggableDraggable(@Builder.Parameter WidgetI child, @Builder.Parameter WidgetI feedback, Optional<NativeObj> data, Optional<Axis> axis, Optional<WidgetI> childWhenDragging, Optional<OffsetI> feedbackOffset, Optional<TriFunction<Draggable, BuildContext, Offset, Offset>> dragAnchorStrategy, Optional<Axis> affinity, OptionalInt maxSimultaneousDrags, Optional<Runnable> onDragStarted, Optional<Consumer<DragUpdateDetails>> onDragUpdate, Optional<BiConsumer<Velocity, Offset>> onDraggableCanceled, Optional<Runnable> onDragCompleted, Optional<Boolean> ignoringFeedbackSemantics, Optional<Boolean> ignoringFeedbackPointer, Optional<Boolean> rootOverlay, Optional<HitTestBehavior> hitTestBehavior, Optional<Function<Integer, Boolean>> allowedButtonsFilter) {
    var st = factories.draggableDraggable(child.build(),
      feedback.build(),
      data,
      axis,
      childWhenDragging.map(WidgetI::build),
      feedbackOffset.map(OffsetI::build),
      dragAnchorStrategy,
      affinity,
      maxSimultaneousDrags,
      onDragStarted,
      onDragUpdate,
      onDraggableCanceled,
      onDragCompleted,
      ignoringFeedbackSemantics,
      ignoringFeedbackPointer,
      rootOverlay,
      hitTestBehavior,
      allowedButtonsFilter);
    if (st == null) throw new RuntimeException("Failed to created widget Draggable");
    return new Draggable(st);
  }
  public static <T extends NativeObj> DraggableDraggableBuilder<T> draggable(WidgetI child, WidgetI feedback) {
    return DraggableDraggableBuilder.draggableDraggable(child, feedback);
  }
  public Axis axis() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("draggableAxis not supported on web");
    return Axis.values()[DraggableObjSt.axis(st)];
  }
  public Widget child() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("draggableChild not supported on web");
    return new Widget(DraggableObjSt.child(st)) {};
  }
  public Widget childWhenDragging() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("draggableChildWhenDragging not supported on web");
    return new Widget(DraggableObjSt.childWhenDragging(st)) {};
  }
  public Widget feedback() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("draggableFeedback not supported on web");
    return new Widget(DraggableObjSt.feedback(st)) {};
  }
  public Offset feedbackOffset() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("draggableFeedbackOffset", getId());
      return new Offset(__nid);
    }
    return new Offset(DraggableObjSt.feedbackOffset(st));
  }
  public boolean ignoringFeedbackSemantics() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("draggableIgnoringFeedbackSemantics not supported on web");
    return intToBool(DraggableObjSt.ignoringFeedbackSemantics(st));
  }
  public boolean ignoringFeedbackPointer() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("draggableIgnoringFeedbackPointer not supported on web");
    return intToBool(DraggableObjSt.ignoringFeedbackPointer(st));
  }
  public Axis affinity() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("draggableAffinity not supported on web");
    return Axis.values()[DraggableObjSt.affinity(st)];
  }
  public int maxSimultaneousDrags() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("draggableMaxSimultaneousDrags not supported on web");
    return DraggableObjSt.maxSimultaneousDrags(st);
  }
  public boolean rootOverlay() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("draggableRootOverlay not supported on web");
    return intToBool(DraggableObjSt.rootOverlay(st));
  }
  public HitTestBehavior hitTestBehavior() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("draggableHitTestBehavior not supported on web");
    return HitTestBehavior.values()[DraggableObjSt.hitTestBehavior(st)];
  }
  @Override
  public Draggable build() {
    return this;
  }
}
