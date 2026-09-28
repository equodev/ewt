package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class MergeSemantics extends SingleChildRenderObjectWidget implements MergeSemanticsI {
  protected MergeSemantics() {}
  MergeSemantics(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget MergeSemantics");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static MergeSemantics mergeSemanticsMergeSemantics(Optional<WidgetI> child) {
    int id = factories.mergeSemanticsMergeSemantics(child.map(WidgetI::build));
    if (id <= 0) throw new RuntimeException("Failed to created widget MergeSemantics");
    return new MergeSemantics(id);
  }
  public static MergeSemanticsMergeSemanticsBuilder mergeSemantics() {
    return MergeSemanticsMergeSemanticsBuilder.mergeSemanticsMergeSemantics();
  }
  @Override
  public MergeSemantics build() {
    return this;
  }
}
