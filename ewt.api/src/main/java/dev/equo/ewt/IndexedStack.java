package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class IndexedStack extends StatelessWidget implements IndexedStackI {
  protected IndexedStack() {}
  IndexedStack(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget IndexedStack");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static IndexedStack indexedStackIndexedStack(Optional<AlignmentGeometryI> alignment, Optional<TextDirection> textDirection, Optional<Clip> clipBehavior, Optional<StackFit> sizing, OptionalInt index, Optional<List<WidgetI>> children) {
    int id = factories.indexedStackIndexedStack(alignment.map(AlignmentGeometryI::build),
      textDirection,
      clipBehavior,
      sizing,
      index,
      children.map(i -> i.stream().map(WidgetI::build).collect(java.util.stream.Collectors.toList())));
    if (id <= 0) throw new RuntimeException("Failed to created widget IndexedStack");
    return new IndexedStack(id);
  }
  public static IndexedStackIndexedStackBuilder indexedStack() {
    return IndexedStackIndexedStackBuilder.indexedStackIndexedStack();
  }
  public AlignmentGeometry alignment() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("indexedStackAlignment not supported on web");
    return factories.IndexedStack_readBack_alignment(nativeStruct);
  }
  public TextDirection textDirection() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("indexedStackTextDirection not supported on web");
    return factories.IndexedStack_readBack_textDirection(nativeStruct);
  }
  public Clip clipBehavior() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("indexedStackClipBehavior not supported on web");
    return factories.IndexedStack_readBack_clipBehavior(nativeStruct);
  }
  public StackFit sizing() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("indexedStackSizing not supported on web");
    return factories.IndexedStack_readBack_sizing(nativeStruct);
  }
  public int index() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("indexedStackIndex not supported on web");
    return factories.IndexedStack_readBack_index(nativeStruct);
  }
  @Override
  public IndexedStack build() {
    return this;
  }
}
