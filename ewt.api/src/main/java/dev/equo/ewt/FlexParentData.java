package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class FlexParentData extends ContainerBoxParentData<RenderBox> implements FlexParentDataI {
  protected FlexParentData() {}
  FlexParentData(int id) {
    this.id = id;
  }
  public static FlexParentData byId(int id) { return new FlexParentData(id); }
  @Builder.Factory
  static FlexParentData flexParentDataFlexParentData() {
    int id = factories.flexParentDataFlexParentData();
    if (id <= 0) throw new RuntimeException("Failed to created widget FlexParentData");
    System.out.println("New FlexParentData id:"+id);
    return new FlexParentData(id);
  }
  public static FlexParentDataFlexParentDataBuilder flexParentData() {
    return FlexParentDataFlexParentDataBuilder.flexParentDataFlexParentData();
  }
  @Override
  public FlexParentData build() {
    return this;
  }
}
