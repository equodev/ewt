package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class SliverEnsureSemantics extends SingleChildRenderObjectWidget implements SliverEnsureSemanticsI {
  protected SliverEnsureSemantics() {}
  SliverEnsureSemantics(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget SliverEnsureSemantics");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static SliverEnsureSemantics sliverEnsureSemanticsSliverEnsureSemantics(@Builder.Parameter WidgetI sliver) {
    int id = factories.sliverEnsureSemanticsSliverEnsureSemantics(sliver.build());
    if (id <= 0) throw new RuntimeException("Failed to created widget SliverEnsureSemantics");
    return new SliverEnsureSemantics(id);
  }
  public static SliverEnsureSemanticsSliverEnsureSemanticsBuilder sliverEnsureSemantics(WidgetI sliver) {
    return SliverEnsureSemanticsSliverEnsureSemanticsBuilder.sliverEnsureSemanticsSliverEnsureSemantics(sliver);
  }
  @Override
  public SliverEnsureSemantics build() {
    return this;
  }
}
