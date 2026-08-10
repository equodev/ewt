package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.IgnorePointerObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class IgnorePointer extends SingleChildRenderObjectWidget implements IgnorePointerI {
  private MemorySegment st;
  protected IgnorePointer() {}
  IgnorePointer(MemorySegment st) {
    this.id = IgnorePointerObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget IgnorePointer");
    System.out.println("New IgnorePointer id:"+id);
  }
  IgnorePointer(int id) { this.id = id; }
  @Builder.Factory
  static IgnorePointer ignorePointerIgnorePointer(Optional<Boolean> ignoring, Optional<Boolean> ignoringSemantics, Optional<WidgetI> child) {
    var st = factories.ignorePointerIgnorePointer(ignoring,
      ignoringSemantics,
      child.map(WidgetI::build));
    if (st == null) throw new RuntimeException("Failed to created widget IgnorePointer");
    return new IgnorePointer(st);
  }
  public static IgnorePointerIgnorePointerBuilder ignorePointer() {
    return IgnorePointerIgnorePointerBuilder.ignorePointerIgnorePointer();
  }
  public boolean ignoring() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("ignorePointerIgnoring not supported on web");
    return intToBool(IgnorePointerObjSt.ignoring(st));
  }
  public boolean ignoringSemantics() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("ignorePointerIgnoringSemantics not supported on web");
    return intToBool(IgnorePointerObjSt.ignoringSemantics(st));
  }
  @Override
  public IgnorePointer build() {
    return this;
  }
}
