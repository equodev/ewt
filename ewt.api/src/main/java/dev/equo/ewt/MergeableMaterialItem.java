package dev.equo.ewt;
import java.util.*;
public abstract class MergeableMaterialItem extends NativeObj.Base implements MergeableMaterialItemI {
  protected MergeableMaterialItem() {}
  MergeableMaterialItem(int id) {
    this.id = id;
  }
  @Override
  public MergeableMaterialItem build() {
    return this;
  }
}
