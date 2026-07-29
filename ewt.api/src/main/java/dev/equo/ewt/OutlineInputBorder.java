package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.OutlineInputBorderObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class OutlineInputBorder extends InputBorder implements OutlineInputBorderI {
  private MemorySegment st;
  protected OutlineInputBorder() {}
  OutlineInputBorder(MemorySegment st) {
    this.id = OutlineInputBorderObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget OutlineInputBorder");
    System.out.println("New OutlineInputBorder id:"+id);
  }
  OutlineInputBorder(int id) { this.id = id; }
  @Builder.Factory
  static OutlineInputBorder outlineInputBorderOutlineInputBorder(Optional<BorderSideI> borderSide, Optional<BorderRadiusI> borderRadius, OptionalDouble gapPadding) {
    var st = factories.outlineInputBorderOutlineInputBorder(borderSide.map(BorderSideI::build),
      borderRadius.map(BorderRadiusI::build),
      gapPadding);
    if (st == null) throw new RuntimeException("Failed to created widget OutlineInputBorder");
    return new OutlineInputBorder(st);
  }
  public static OutlineInputBorderOutlineInputBorderBuilder outlineInputBorder() {
    return OutlineInputBorderOutlineInputBorderBuilder.outlineInputBorderOutlineInputBorder();
  }
  public double gapPadding() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("outlineInputBorderGapPadding not supported on web");
    return OutlineInputBorderObjSt.gapPadding(st);
  }
  public BorderRadius borderRadius() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("outlineInputBorderBorderRadius", getId());
      java.lang.foreign.MemorySegment __st = dev.equo.ewt.ffm.BorderRadiusObjSt.allocate(__s.arena);
      dev.equo.ewt.ffm.BorderRadiusObjSt.id(__st, __nid);
      return new BorderRadius(__st);
    }
    return new BorderRadius(OutlineInputBorderObjSt.borderRadius(st));
  }
  @Override
  public OutlineInputBorder build() {
    return this;
  }
}
