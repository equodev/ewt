package dev.equo.ewt;
import java.util.*;
public abstract class ConstrainedLayoutBuilder<ConstraintType extends Constraints> extends AbstractLayoutBuilder<ConstraintType> implements ConstrainedLayoutBuilderI {
  protected ConstrainedLayoutBuilder() {}
  ConstrainedLayoutBuilder(int id) {
    this.id = id;
  }
  @Override
  public ConstrainedLayoutBuilder build() {
    return this;
  }
}
