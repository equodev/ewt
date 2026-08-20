package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.ContinuousRectangleBorderObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class ContinuousRectangleBorder extends OutlinedBorder implements ContinuousRectangleBorderI {
  private MemorySegment st;
  protected ContinuousRectangleBorder() {}
  ContinuousRectangleBorder(MemorySegment st) {
    this.id = ContinuousRectangleBorderObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget ContinuousRectangleBorder");
    System.out.println("New ContinuousRectangleBorder id:"+id);
  }
  ContinuousRectangleBorder(int id) { this.id = id; }
  @Builder.Factory
  static ContinuousRectangleBorder continuousRectangleBorderContinuousRectangleBorder(Optional<BorderSideI> side, Optional<BorderRadiusGeometryI> borderRadius) {
    var st = factories.continuousRectangleBorderContinuousRectangleBorder(side.map(BorderSideI::build),
      borderRadius.map(BorderRadiusGeometryI::build));
    if (st == null) throw new RuntimeException("Failed to created widget ContinuousRectangleBorder");
    return new ContinuousRectangleBorder(st);
  }
  public static ContinuousRectangleBorderContinuousRectangleBorderBuilder continuousRectangleBorder() {
    return ContinuousRectangleBorderContinuousRectangleBorderBuilder.continuousRectangleBorderContinuousRectangleBorder();
  }
  public BorderRadiusGeometry borderRadius() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("continuousRectangleBorderBorderRadius not supported on web");
    return new BorderRadiusGeometry(ContinuousRectangleBorderObjSt.borderRadius(st)) {};
  }
  @Override
  public ContinuousRectangleBorder build() {
    return this;
  }
}
