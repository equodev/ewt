package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class ExcludeFocusTraversal extends StatelessWidget implements ExcludeFocusTraversalI {
  protected ExcludeFocusTraversal() {}
  ExcludeFocusTraversal(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget ExcludeFocusTraversal");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static ExcludeFocusTraversal excludeFocusTraversalExcludeFocusTraversal(Optional<Boolean> excluding, WidgetI child) {
    int id = factories.excludeFocusTraversalExcludeFocusTraversal(excluding,
      child.build());
    if (id <= 0) throw new RuntimeException("Failed to created widget ExcludeFocusTraversal");
    return new ExcludeFocusTraversal(id);
  }
  public static ExcludeFocusTraversalExcludeFocusTraversalBuilder excludeFocusTraversal() {
    return ExcludeFocusTraversalExcludeFocusTraversalBuilder.excludeFocusTraversalExcludeFocusTraversal();
  }
  public boolean excluding() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("excludeFocusTraversalExcluding not supported on web");
    return factories.ExcludeFocusTraversal_readBack_excluding(nativeStruct);
  }
  public Widget child() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("excludeFocusTraversalChild not supported on web");
    return factories.ExcludeFocusTraversal_readBack_child(nativeStruct);
  }
  @Override
  public ExcludeFocusTraversal build() {
    return this;
  }
}
