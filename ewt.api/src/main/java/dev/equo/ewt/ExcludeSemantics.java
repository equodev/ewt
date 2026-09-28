package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class ExcludeSemantics extends SingleChildRenderObjectWidget implements ExcludeSemanticsI {
  protected ExcludeSemantics() {}
  ExcludeSemantics(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget ExcludeSemantics");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static ExcludeSemantics excludeSemanticsExcludeSemantics(Optional<Boolean> excluding, Optional<WidgetI> child) {
    int id = factories.excludeSemanticsExcludeSemantics(excluding,
      child.map(WidgetI::build));
    if (id <= 0) throw new RuntimeException("Failed to created widget ExcludeSemantics");
    return new ExcludeSemantics(id);
  }
  public static ExcludeSemanticsExcludeSemanticsBuilder excludeSemantics() {
    return ExcludeSemanticsExcludeSemanticsBuilder.excludeSemanticsExcludeSemantics();
  }
  public boolean excluding() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("excludeSemanticsExcluding not supported on web");
    return factories.ExcludeSemantics_readBack_excluding(nativeStruct);
  }
  @Override
  public ExcludeSemantics build() {
    return this;
  }
}
