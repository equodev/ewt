package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class BoxParentData extends ParentData implements BoxParentDataI {
  protected BoxParentData() {}
  BoxParentData(int id) {
    this.id = id;
  }
  @Builder.Factory
  static BoxParentData boxParentDataBoxParentData() {
    int id = factories.boxParentDataBoxParentData();
    if (id == -1) throw new RuntimeException("Failed to created widget BoxParentData");
    System.out.println("New BoxParentData id:"+id);
    return new BoxParentData(id);
  }
  public static BoxParentDataBoxParentDataBuilder boxParentData() {
    return BoxParentDataBoxParentDataBuilder.boxParentDataBoxParentData();
  }
  @Override
  public BoxParentData build() {
    return this;
  }
}
