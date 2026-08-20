package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.MergeSemanticsObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class MergeSemantics extends SingleChildRenderObjectWidget implements MergeSemanticsI {
  private MemorySegment st;
  protected MergeSemantics() {}
  MergeSemantics(MemorySegment st) {
    this.id = MergeSemanticsObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget MergeSemantics");
    System.out.println("New MergeSemantics id:"+id);
  }
  MergeSemantics(int id) { this.id = id; }
  @Builder.Factory
  static MergeSemantics mergeSemanticsMergeSemantics(Optional<WidgetI> child) {
    var st = factories.mergeSemanticsMergeSemantics(child.map(WidgetI::build));
    if (st == null) throw new RuntimeException("Failed to created widget MergeSemantics");
    return new MergeSemantics(st);
  }
  public static MergeSemanticsMergeSemanticsBuilder mergeSemantics() {
    return MergeSemanticsMergeSemanticsBuilder.mergeSemanticsMergeSemantics();
  }
  @Override
  public MergeSemantics build() {
    return this;
  }
}
