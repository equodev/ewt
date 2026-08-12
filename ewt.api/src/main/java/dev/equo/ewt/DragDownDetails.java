package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class DragDownDetails extends NativeObj.Base implements DragDownDetailsI {
  protected DragDownDetails() {}
  DragDownDetails(int id) {
    this.id = id;
  }
  public static DragDownDetails byId(int id) { return new DragDownDetails(id); }
  @Builder.Factory
  static DragDownDetails dragDownDetailsDragDownDetails(Optional<OffsetI> globalPosition, Optional<OffsetI> localPosition) {
    int id = factories.dragDownDetailsDragDownDetails(globalPosition.map(OffsetI::build),
      localPosition.map(OffsetI::build));
    if (id <= 0) throw new RuntimeException("Failed to created widget DragDownDetails");
    System.out.println("New DragDownDetails id:"+id);
    return new DragDownDetails(id);
  }
  public static DragDownDetailsDragDownDetailsBuilder dragDownDetails() {
    return DragDownDetailsDragDownDetailsBuilder.dragDownDetailsDragDownDetails();
  }
  @Override
  public DragDownDetails build() {
    return this;
  }
}
