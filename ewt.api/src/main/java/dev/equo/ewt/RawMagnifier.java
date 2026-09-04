package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.RawMagnifierObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class RawMagnifier extends StatelessWidget implements RawMagnifierI {
  private MemorySegment st;
  protected RawMagnifier() {}
  RawMagnifier(MemorySegment st) {
    this.id = RawMagnifierObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget RawMagnifier");
    System.out.println("New RawMagnifier id:"+id);
  }
  RawMagnifier(int id) { this.id = id; }
  public Widget child() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("rawMagnifierChild not supported on web");
    return new Widget(RawMagnifierObjSt.child(st)) {};
  }
  public Clip clipBehavior() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("rawMagnifierClipBehavior not supported on web");
    return Clip.values()[RawMagnifierObjSt.clipBehavior(st)];
  }
  public Offset focalPointOffset() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("rawMagnifierFocalPointOffset", getId());
      return new Offset(__nid);
    }
    return new Offset(RawMagnifierObjSt.focalPointOffset(st));
  }
  public double magnificationScale() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("rawMagnifierMagnificationScale not supported on web");
    return RawMagnifierObjSt.magnificationScale(st);
  }
  @Override
  public RawMagnifier build() {
    return this;
  }
}
