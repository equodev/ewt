package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class StackParentData extends ContainerBoxParentData<RenderBox> implements StackParentDataI {
  protected StackParentData() {}
  StackParentData(int id) {
    this.id = id;
  }
  @Builder.Factory
  static StackParentData stackParentDataStackParentData() {
    int id = factories.stackParentDataStackParentData();
    if (id == -1) throw new RuntimeException("Failed to created widget StackParentData");
    System.out.println("New StackParentData id:"+id);
    return new StackParentData(id);
  }
  public static StackParentDataStackParentDataBuilder stackParentData() {
    return StackParentDataStackParentDataBuilder.stackParentDataStackParentData();
  }
  @Override
  public StackParentData build() {
    return this;
  }
}
