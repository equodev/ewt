package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class DefaultTextHeightBehavior extends InheritedTheme implements DefaultTextHeightBehaviorI {
  protected DefaultTextHeightBehavior() {}
  DefaultTextHeightBehavior(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget DefaultTextHeightBehavior");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Override
  public DefaultTextHeightBehavior build() {
    return this;
  }
}
