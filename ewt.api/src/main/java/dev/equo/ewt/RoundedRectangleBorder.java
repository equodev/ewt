package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.RoundedRectangleBorderObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class RoundedRectangleBorder extends OutlinedBorder implements RoundedRectangleBorderI {
  private MemorySegment st;
  protected RoundedRectangleBorder() {}
  RoundedRectangleBorder(MemorySegment st) {
    this.id = RoundedRectangleBorderObjSt.id(st);
    this.st = st;
    System.out.println("New RoundedRectangleBorder id:"+id);
  }
  @Builder.Factory
  static RoundedRectangleBorder roundedRectangleBorderRoundedRectangleBorder(Optional<BorderSideI> side, Optional<BorderRadiusGeometryI> borderRadius) {
    var st = factories.roundedRectangleBorderRoundedRectangleBorder(side.map(BorderSideI::build),
      borderRadius.map(BorderRadiusGeometryI::build));
    if (st == null) throw new RuntimeException("Failed to created widget RoundedRectangleBorder");
    return new RoundedRectangleBorder(st);
  }
  public static RoundedRectangleBorderRoundedRectangleBorderBuilder roundedRectangleBorder() {
    return RoundedRectangleBorderRoundedRectangleBorderBuilder.roundedRectangleBorderRoundedRectangleBorder();
  }
  public BorderRadiusGeometry borderRadius() {
    return new BorderRadiusGeometry(RoundedRectangleBorderObjSt.borderRadius(st)) {};
  }
  @Override
  public RoundedRectangleBorder build() {
    return this;
  }
}
