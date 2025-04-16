package dev.equo.ewt;
import java.util.*;
public abstract class ContainerBoxParentData<ChildType extends RenderObject> extends BoxParentData implements ContainerBoxParentDataI {
  protected ContainerBoxParentData() {}
  ContainerBoxParentData(int id) {
    this.id = id;
  }
  @Override
  public ContainerBoxParentData build() {
    return this;
  }
}
