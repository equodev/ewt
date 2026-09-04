package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.DefaultTextHeightBehaviorObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class DefaultTextHeightBehavior extends InheritedTheme implements DefaultTextHeightBehaviorI {
  private MemorySegment st;
  protected DefaultTextHeightBehavior() {}
  DefaultTextHeightBehavior(MemorySegment st) {
    this.id = DefaultTextHeightBehaviorObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget DefaultTextHeightBehavior");
    System.out.println("New DefaultTextHeightBehavior id:"+id);
  }
  DefaultTextHeightBehavior(int id) { this.id = id; }
  @Override
  public DefaultTextHeightBehavior build() {
    return this;
  }
}
