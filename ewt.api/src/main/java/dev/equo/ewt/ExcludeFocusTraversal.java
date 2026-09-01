package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.ExcludeFocusTraversalObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class ExcludeFocusTraversal extends StatelessWidget implements ExcludeFocusTraversalI {
  private MemorySegment st;
  protected ExcludeFocusTraversal() {}
  ExcludeFocusTraversal(MemorySegment st) {
    this.id = ExcludeFocusTraversalObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget ExcludeFocusTraversal");
    System.out.println("New ExcludeFocusTraversal id:"+id);
  }
  ExcludeFocusTraversal(int id) { this.id = id; }
  @Builder.Factory
  static ExcludeFocusTraversal excludeFocusTraversalExcludeFocusTraversal(Optional<Boolean> excluding, WidgetI child) {
    var st = factories.excludeFocusTraversalExcludeFocusTraversal(excluding,
      child.build());
    if (st == null) throw new RuntimeException("Failed to created widget ExcludeFocusTraversal");
    return new ExcludeFocusTraversal(st);
  }
  public static ExcludeFocusTraversalExcludeFocusTraversalBuilder excludeFocusTraversal() {
    return ExcludeFocusTraversalExcludeFocusTraversalBuilder.excludeFocusTraversalExcludeFocusTraversal();
  }
  public boolean excluding() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("excludeFocusTraversalExcluding not supported on web");
    return intToBool(ExcludeFocusTraversalObjSt.excluding(st));
  }
  public Widget child() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("excludeFocusTraversalChild not supported on web");
    return new Widget(ExcludeFocusTraversalObjSt.child(st)) {};
  }
  @Override
  public ExcludeFocusTraversal build() {
    return this;
  }
}
