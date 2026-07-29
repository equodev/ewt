package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.IndexedStackObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class IndexedStack extends StatelessWidget implements IndexedStackI {
  private MemorySegment st;
  protected IndexedStack() {}
  IndexedStack(MemorySegment st) {
    this.id = IndexedStackObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget IndexedStack");
    System.out.println("New IndexedStack id:"+id);
  }
  IndexedStack(int id) { this.id = id; }
  @Builder.Factory
  static IndexedStack indexedStackIndexedStack(Optional<AlignmentGeometryI> alignment, Optional<TextDirection> textDirection, Optional<Clip> clipBehavior, Optional<StackFit> sizing, OptionalInt index, Optional<List<WidgetI>> children) {
    var st = factories.indexedStackIndexedStack(alignment.map(AlignmentGeometryI::build),
      textDirection,
      clipBehavior,
      sizing,
      index,
      children.map(i -> i.stream().map(WidgetI::build).toList()));
    if (st == null) throw new RuntimeException("Failed to created widget IndexedStack");
    return new IndexedStack(st);
  }
  public static IndexedStackIndexedStackBuilder indexedStack() {
    return IndexedStackIndexedStackBuilder.indexedStackIndexedStack();
  }
  public AlignmentGeometry alignment() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("indexedStackAlignment not supported on web");
    return new AlignmentGeometry(IndexedStackObjSt.alignment(st)) {};
  }
  public TextDirection textDirection() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("indexedStackTextDirection not supported on web");
    return TextDirection.values()[IndexedStackObjSt.textDirection(st)];
  }
  public Clip clipBehavior() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("indexedStackClipBehavior not supported on web");
    return Clip.values()[IndexedStackObjSt.clipBehavior(st)];
  }
  public StackFit sizing() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("indexedStackSizing not supported on web");
    return StackFit.values()[IndexedStackObjSt.sizing(st)];
  }
  public int index() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("indexedStackIndex not supported on web");
    return IndexedStackObjSt.index(st);
  }
  @Override
  public IndexedStack build() {
    return this;
  }
}
