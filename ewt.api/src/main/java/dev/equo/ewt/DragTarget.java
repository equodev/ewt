package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class DragTarget<T> extends StatefulWidget implements DragTargetI {
  protected DragTarget() {}
  DragTarget(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget DragTarget");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static <T extends NativeObj> DragTarget<T> dragTargetDragTarget(@Builder.Parameter TriFunction<BuildContext, List<NativeObj>, List<NativeObj>, Widget> builder, Optional<Function<NativeObj, Boolean>> onWillAccept, Optional<Function<DragTargetDetails, Boolean>> onWillAcceptWithDetails, Optional<Consumer<NativeObj>> onAccept, Optional<Consumer<DragTargetDetails>> onAcceptWithDetails, Optional<Consumer<NativeObj>> onLeave, Optional<Consumer<DragTargetDetails>> onMove, Optional<HitTestBehavior> hitTestBehavior) {
    int id = factories.dragTargetDragTarget(builder,
      onWillAccept,
      onWillAcceptWithDetails,
      onAccept,
      onAcceptWithDetails,
      onLeave,
      onMove,
      hitTestBehavior);
    if (id <= 0) throw new RuntimeException("Failed to created widget DragTarget");
    return new DragTarget(id);
  }
  public static <T extends NativeObj> DragTargetDragTargetBuilder<T> dragTarget(TriFunction<BuildContext, List<NativeObj>, List<NativeObj>, Widget> builder) {
    return DragTargetDragTargetBuilder.dragTargetDragTarget(builder);
  }
  public HitTestBehavior hitTestBehavior() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("dragTargetHitTestBehavior not supported on web");
    return factories.DragTarget_readBack_hitTestBehavior(nativeStruct);
  }
  @Override
  public DragTarget build() {
    return this;
  }
}
