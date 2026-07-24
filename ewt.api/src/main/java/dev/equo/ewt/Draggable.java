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
  static <T extends NativeObj> Draggable<T> draggableDraggable(@Builder.Parameter WidgetI child, @Builder.Parameter WidgetI feedback, Optional<T> data, Optional<Axis> axis, Optional<WidgetI> childWhenDragging, Optional<OffsetI> feedbackOffset, Optional<TriFunction<Draggable, BuildContext, Offset, Offset>> dragAnchorStrategy, Optional<Axis> affinity, OptionalInt maxSimultaneousDrags, Optional<Runnable> onDragStarted, Optional<Runnable> onDragCompleted, Optional<Boolean> ignoringFeedbackSemantics, Optional<Boolean> ignoringFeedbackPointer, Optional<Boolean> rootOverlay, Optional<HitTestBehavior> hitTestBehavior, Optional<Function<Integer, Boolean>> allowedButtonsFilter) {
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
  public T data() {
    return (T) (NativeObj) new NativeObj.Base() {{ this.id = DraggableObjSt.data(st); }};
  }
  public Axis axis() {
    return Axis.values()[DraggableObjSt.axis(st)];
  }
  public Widget child() {
    return new Widget(DraggableObjSt.child(st)) {};
  }
  public Widget childWhenDragging() {
    return new Widget(DraggableObjSt.childWhenDragging(st)) {};
  }
  public Widget feedback() {
    return new Widget(DraggableObjSt.feedback(st)) {};
  }
  public Offset feedbackOffset() {
    return new Offset(DraggableObjSt.feedbackOffset(st));
  }
  public boolean ignoringFeedbackSemantics() {
    return intToBool(DraggableObjSt.ignoringFeedbackSemantics(st));
  }
  public boolean ignoringFeedbackPointer() {
    return intToBool(DraggableObjSt.ignoringFeedbackPointer(st));
  }
  public Axis affinity() {
    return Axis.values()[DraggableObjSt.affinity(st)];
  }
  public int maxSimultaneousDrags() {
    return DraggableObjSt.maxSimultaneousDrags(st);
  }
  public boolean rootOverlay() {
    return intToBool(DraggableObjSt.rootOverlay(st));
  }
  public HitTestBehavior hitTestBehavior() {
    return HitTestBehavior.values()[DraggableObjSt.hitTestBehavior(st)];
  }
  @Override
  public Draggable build() {
    return this;
  }
}
