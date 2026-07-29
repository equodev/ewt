package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.DragTargetObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class DragTarget<T> extends StatefulWidget implements DragTargetI {
  private MemorySegment st;
  protected DragTarget() {}
  DragTarget(MemorySegment st) {
    this.id = DragTargetObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget DragTarget");
    System.out.println("New DragTarget id:"+id);
  }
  DragTarget(int id) { this.id = id; }
  @Builder.Factory
  static <T extends NativeObj> DragTarget<T> dragTargetDragTarget(@Builder.Parameter TriFunction<BuildContext, List<NativeObj>, List<NativeObj>, Widget> builder, Optional<Function<NativeObj, Boolean>> onWillAccept, Optional<Consumer<NativeObj>> onAccept, Optional<Consumer<NativeObj>> onLeave, Optional<HitTestBehavior> hitTestBehavior) {
    var st = factories.dragTargetDragTarget(builder,
      onWillAccept,
      onAccept,
      onLeave,
      hitTestBehavior);
    if (st == null) throw new RuntimeException("Failed to created widget DragTarget");
    return new DragTarget(st);
  }
  public static <T extends NativeObj> DragTargetDragTargetBuilder<T> dragTarget(TriFunction<BuildContext, List<NativeObj>, List<NativeObj>, Widget> builder) {
    return DragTargetDragTargetBuilder.dragTargetDragTarget(builder);
  }
  public HitTestBehavior hitTestBehavior() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("dragTargetHitTestBehavior not supported on web");
    return HitTestBehavior.values()[DragTargetObjSt.hitTestBehavior(st)];
  }
  @Override
  public DragTarget build() {
    return this;
  }
}
