package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.ExcludeSemanticsObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class ExcludeSemantics extends SingleChildRenderObjectWidget implements ExcludeSemanticsI {
  private MemorySegment st;
  protected ExcludeSemantics() {}
  ExcludeSemantics(MemorySegment st) {
    this.id = ExcludeSemanticsObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget ExcludeSemantics");
    System.out.println("New ExcludeSemantics id:"+id);
  }
  ExcludeSemantics(int id) { this.id = id; }
  @Builder.Factory
  static ExcludeSemantics excludeSemanticsExcludeSemantics(Optional<Boolean> excluding, Optional<WidgetI> child) {
    var st = factories.excludeSemanticsExcludeSemantics(excluding,
      child.map(WidgetI::build));
    if (st == null) throw new RuntimeException("Failed to created widget ExcludeSemantics");
    return new ExcludeSemantics(st);
  }
  public static ExcludeSemanticsExcludeSemanticsBuilder excludeSemantics() {
    return ExcludeSemanticsExcludeSemanticsBuilder.excludeSemanticsExcludeSemantics();
  }
  public boolean excluding() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("excludeSemanticsExcluding not supported on web");
    return intToBool(ExcludeSemanticsObjSt.excluding(st));
  }
  @Override
  public ExcludeSemantics build() {
    return this;
  }
}
