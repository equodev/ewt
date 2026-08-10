package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.AbsorbPointerObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class AbsorbPointer extends SingleChildRenderObjectWidget implements AbsorbPointerI {
  private MemorySegment st;
  protected AbsorbPointer() {}
  AbsorbPointer(MemorySegment st) {
    this.id = AbsorbPointerObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget AbsorbPointer");
    System.out.println("New AbsorbPointer id:"+id);
  }
  AbsorbPointer(int id) { this.id = id; }
  @Builder.Factory
  static AbsorbPointer absorbPointerAbsorbPointer(Optional<Boolean> absorbing, Optional<Boolean> ignoringSemantics, Optional<WidgetI> child) {
    var st = factories.absorbPointerAbsorbPointer(absorbing,
      ignoringSemantics,
      child.map(WidgetI::build));
    if (st == null) throw new RuntimeException("Failed to created widget AbsorbPointer");
    return new AbsorbPointer(st);
  }
  public static AbsorbPointerAbsorbPointerBuilder absorbPointer() {
    return AbsorbPointerAbsorbPointerBuilder.absorbPointerAbsorbPointer();
  }
  public boolean absorbing() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("absorbPointerAbsorbing not supported on web");
    return intToBool(AbsorbPointerObjSt.absorbing(st));
  }
  public boolean ignoringSemantics() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("absorbPointerIgnoringSemantics not supported on web");
    return intToBool(AbsorbPointerObjSt.ignoringSemantics(st));
  }
  @Override
  public AbsorbPointer build() {
    return this;
  }
}
