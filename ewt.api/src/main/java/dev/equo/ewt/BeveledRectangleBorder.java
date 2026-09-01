package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.BeveledRectangleBorderObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class BeveledRectangleBorder extends OutlinedBorder implements BeveledRectangleBorderI {
  private MemorySegment st;
  protected BeveledRectangleBorder() {}
  BeveledRectangleBorder(MemorySegment st) {
    this.id = BeveledRectangleBorderObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget BeveledRectangleBorder");
    System.out.println("New BeveledRectangleBorder id:"+id);
  }
  BeveledRectangleBorder(int id) { this.id = id; }
  @Builder.Factory
  static BeveledRectangleBorder beveledRectangleBorderBeveledRectangleBorder(Optional<BorderSideI> side, Optional<BorderRadiusGeometryI> borderRadius) {
    var st = factories.beveledRectangleBorderBeveledRectangleBorder(side.map(BorderSideI::build),
      borderRadius.map(BorderRadiusGeometryI::build));
    if (st == null) throw new RuntimeException("Failed to created widget BeveledRectangleBorder");
    return new BeveledRectangleBorder(st);
  }
  public static BeveledRectangleBorderBeveledRectangleBorderBuilder beveledRectangleBorder() {
    return BeveledRectangleBorderBeveledRectangleBorderBuilder.beveledRectangleBorderBeveledRectangleBorder();
  }
  public BorderRadiusGeometry borderRadius() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("beveledRectangleBorderBorderRadius not supported on web");
    return new BorderRadiusGeometry(BeveledRectangleBorderObjSt.borderRadius(st)) {};
  }
  @Override
  public BeveledRectangleBorder build() {
    return this;
  }
}
