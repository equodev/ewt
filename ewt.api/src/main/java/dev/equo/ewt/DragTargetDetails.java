package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class DragTargetDetails<T> extends NativeObj.Base implements DragTargetDetailsI {
  protected DragTargetDetails() {}
  DragTargetDetails(int id) {
    this.id = id;
  }
  public static DragTargetDetails byId(int id) { return new DragTargetDetails(id); }
  @Builder.Factory
  static <T extends NativeObj> DragTargetDetails<T> dragTargetDetailsDragTargetDetails(@Builder.Parameter NativeObj data, @Builder.Parameter OffsetI offset) {
    int id = factories.dragTargetDetailsDragTargetDetails(data,
      offset.build());
    if (id <= 0) throw new RuntimeException("Failed to created widget DragTargetDetails<T>");
    System.out.println("New DragTargetDetails<T> id:"+id);
    return new DragTargetDetails(id);
  }
  public static <T extends NativeObj> DragTargetDetailsDragTargetDetailsBuilder<T> dragTargetDetails(NativeObj data, OffsetI offset) {
    return DragTargetDetailsDragTargetDetailsBuilder.dragTargetDetailsDragTargetDetails(data, offset);
  }
  @Override
  public DragTargetDetails build() {
    return this;
  }
}
