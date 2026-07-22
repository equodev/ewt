package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.MatrixTransitionObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class MatrixTransition extends AnimatedWidget implements MatrixTransitionI {
  private MemorySegment st;
  protected MatrixTransition() {}
  MatrixTransition(MemorySegment st) {
    this.id = MatrixTransitionObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget MatrixTransition");
    System.out.println("New MatrixTransition id:"+id);
  }
  MatrixTransition(int id) { this.id = id; }
  public Alignment alignment() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("matrixTransitionAlignment", getId());
      java.lang.foreign.MemorySegment __st = dev.equo.ewt.ffm.AlignmentObjSt.allocate(__s.arena);
      dev.equo.ewt.ffm.AlignmentObjSt.id(__st, __nid);
      return new Alignment(__st);
    }
    return new Alignment(MatrixTransitionObjSt.alignment(st));
  }
  public FilterQuality filterQuality() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("matrixTransitionFilterQuality not supported on web");
    return FilterQuality.values()[MatrixTransitionObjSt.filterQuality(st)];
  }
  public Widget child() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("matrixTransitionChild not supported on web");
    return new Widget(MatrixTransitionObjSt.child(st)) {};
  }
  public Animation animation() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("matrixTransitionAnimation not supported on web");
    return new Animation() { public int getId() { return MatrixTransitionObjSt.animation(st); } };
  }
  @Override
  public MatrixTransition build() {
    return this;
  }
}
