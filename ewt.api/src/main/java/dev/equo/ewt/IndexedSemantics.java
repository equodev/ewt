package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class IndexedSemantics extends SingleChildRenderObjectWidget implements IndexedSemanticsI {
  protected IndexedSemantics() {}
  IndexedSemantics(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget IndexedSemantics");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static IndexedSemantics indexedSemanticsIndexedSemantics(@Builder.Parameter int index, Optional<WidgetI> child) {
    int id = factories.indexedSemanticsIndexedSemantics(index,
      child.map(WidgetI::build));
    if (id <= 0) throw new RuntimeException("Failed to created widget IndexedSemantics");
    return new IndexedSemantics(id);
  }
  public static IndexedSemanticsIndexedSemanticsBuilder indexedSemantics(int index) {
    return IndexedSemanticsIndexedSemanticsBuilder.indexedSemanticsIndexedSemantics(index);
  }
  public int index() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("indexedSemanticsIndex not supported on web");
    return factories.IndexedSemantics_readBack_index(nativeStruct);
  }
  @Override
  public IndexedSemantics build() {
    return this;
  }
}
