package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class Draggable<T> extends StatefulWidget implements DraggableI {
  protected Draggable() {}
  Draggable(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget Draggable");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static <T extends NativeObj> Draggable<T> draggableDraggable(@Builder.Parameter WidgetI child, @Builder.Parameter WidgetI feedback, Optional<NativeObj> data, Optional<Axis> axis, Optional<WidgetI> childWhenDragging, Optional<OffsetI> feedbackOffset, Optional<TriFunction<Draggable, BuildContext, Offset, Offset>> dragAnchorStrategy, Optional<Axis> affinity, OptionalInt maxSimultaneousDrags, Optional<Runnable> onDragStarted, Optional<Consumer<DragUpdateDetails>> onDragUpdate, Optional<BiConsumer<Velocity, Offset>> onDraggableCanceled, Optional<Consumer<DraggableDetails>> onDragEnd, Optional<Runnable> onDragCompleted, Optional<Boolean> ignoringFeedbackSemantics, Optional<Boolean> ignoringFeedbackPointer, Optional<Boolean> rootOverlay, Optional<HitTestBehavior> hitTestBehavior, Optional<Function<Integer, Boolean>> allowedButtonsFilter) {
    int id = factories.draggableDraggable(child.build(),
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
      onDragEnd,
      onDragCompleted,
      ignoringFeedbackSemantics,
      ignoringFeedbackPointer,
      rootOverlay,
      hitTestBehavior,
      allowedButtonsFilter);
    if (id <= 0) throw new RuntimeException("Failed to created widget Draggable");
    return new Draggable(id);
  }
  public static <T extends NativeObj> DraggableDraggableBuilder<T> draggable(WidgetI child, WidgetI feedback) {
    return DraggableDraggableBuilder.draggableDraggable(child, feedback);
  }
  public Axis axis() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("draggableAxis not supported on web");
    return factories.Draggable_readBack_axis(nativeStruct);
  }
  public Widget child() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("draggableChild not supported on web");
    return factories.Draggable_readBack_child(nativeStruct);
  }
  public Widget childWhenDragging() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("draggableChildWhenDragging not supported on web");
    return factories.Draggable_readBack_childWhenDragging(nativeStruct);
  }
  public Widget feedback() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("draggableFeedback not supported on web");
    return factories.Draggable_readBack_feedback(nativeStruct);
  }
  public Offset feedbackOffset() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("draggableFeedbackOffset", getId());
      return new Offset(__nid);
    }
    return factories.Draggable_readBack_feedbackOffset(nativeStruct);
  }
  public boolean ignoringFeedbackSemantics() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("draggableIgnoringFeedbackSemantics not supported on web");
    return factories.Draggable_readBack_ignoringFeedbackSemantics(nativeStruct);
  }
  public boolean ignoringFeedbackPointer() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("draggableIgnoringFeedbackPointer not supported on web");
    return factories.Draggable_readBack_ignoringFeedbackPointer(nativeStruct);
  }
  public Axis affinity() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("draggableAffinity not supported on web");
    return factories.Draggable_readBack_affinity(nativeStruct);
  }
  public int maxSimultaneousDrags() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("draggableMaxSimultaneousDrags not supported on web");
    return factories.Draggable_readBack_maxSimultaneousDrags(nativeStruct);
  }
  public boolean rootOverlay() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("draggableRootOverlay not supported on web");
    return factories.Draggable_readBack_rootOverlay(nativeStruct);
  }
  public HitTestBehavior hitTestBehavior() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("draggableHitTestBehavior not supported on web");
    return factories.Draggable_readBack_hitTestBehavior(nativeStruct);
  }
  @Override
  public Draggable build() {
    return this;
  }
}
