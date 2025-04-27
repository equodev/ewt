package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class ParentData extends NativeObj.Base implements ParentDataI {
  protected ParentData() {}
  ParentData(int id) {
    this.id = id;
  }
  @Builder.Factory
  static ParentData parentDataParentData() {
    int id = factories.parentDataParentData();
    if (id <= 0) throw new RuntimeException("Failed to created widget ParentData");
    System.out.println("New ParentData id:"+id);
    return new ParentData(id);
  }
  public static ParentDataParentDataBuilder parentData() {
    return ParentDataParentDataBuilder.parentDataParentData();
  }
  @Override
  public ParentData build() {
    return this;
  }
}
