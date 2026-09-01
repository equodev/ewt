package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.SliverEnsureSemanticsObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class SliverEnsureSemantics extends SingleChildRenderObjectWidget implements SliverEnsureSemanticsI {
  private MemorySegment st;
  protected SliverEnsureSemantics() {}
  SliverEnsureSemantics(MemorySegment st) {
    this.id = SliverEnsureSemanticsObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget SliverEnsureSemantics");
    System.out.println("New SliverEnsureSemantics id:"+id);
  }
  SliverEnsureSemantics(int id) { this.id = id; }
  @Builder.Factory
  static SliverEnsureSemantics sliverEnsureSemanticsSliverEnsureSemantics(@Builder.Parameter WidgetI sliver) {
    var st = factories.sliverEnsureSemanticsSliverEnsureSemantics(sliver.build());
    if (st == null) throw new RuntimeException("Failed to created widget SliverEnsureSemantics");
    return new SliverEnsureSemantics(st);
  }
  public static SliverEnsureSemanticsSliverEnsureSemanticsBuilder sliverEnsureSemantics(WidgetI sliver) {
    return SliverEnsureSemanticsSliverEnsureSemanticsBuilder.sliverEnsureSemanticsSliverEnsureSemantics(sliver);
  }
  @Override
  public SliverEnsureSemantics build() {
    return this;
  }
}
