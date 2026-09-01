package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.IndexedSemanticsObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class IndexedSemantics extends SingleChildRenderObjectWidget implements IndexedSemanticsI {
  private MemorySegment st;
  protected IndexedSemantics() {}
  IndexedSemantics(MemorySegment st) {
    this.id = IndexedSemanticsObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget IndexedSemantics");
    System.out.println("New IndexedSemantics id:"+id);
  }
  IndexedSemantics(int id) { this.id = id; }
  @Builder.Factory
  static IndexedSemantics indexedSemanticsIndexedSemantics(@Builder.Parameter int index, Optional<WidgetI> child) {
    var st = factories.indexedSemanticsIndexedSemantics(index,
      child.map(WidgetI::build));
    if (st == null) throw new RuntimeException("Failed to created widget IndexedSemantics");
    return new IndexedSemantics(st);
  }
  public static IndexedSemanticsIndexedSemanticsBuilder indexedSemantics(int index) {
    return IndexedSemanticsIndexedSemanticsBuilder.indexedSemanticsIndexedSemantics(index);
  }
  public int index() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("indexedSemanticsIndex not supported on web");
    return IndexedSemanticsObjSt.index(st);
  }
  @Override
  public IndexedSemantics build() {
    return this;
  }
}
