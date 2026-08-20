package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.StarBorderObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class StarBorder extends OutlinedBorder implements StarBorderI {
  private MemorySegment st;
  protected StarBorder() {}
  StarBorder(MemorySegment st) {
    this.id = StarBorderObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget StarBorder");
    System.out.println("New StarBorder id:"+id);
  }
  StarBorder(int id) { this.id = id; }
  @Builder.Factory
  static StarBorder starBorderStarBorder(Optional<BorderSideI> side, OptionalDouble points, OptionalDouble innerRadiusRatio, OptionalDouble pointRounding, OptionalDouble valleyRounding, OptionalDouble rotation, OptionalDouble squash) {
    var st = factories.starBorderStarBorder(side.map(BorderSideI::build),
      points,
      innerRadiusRatio,
      pointRounding,
      valleyRounding,
      rotation,
      squash);
    if (st == null) throw new RuntimeException("Failed to created widget StarBorder");
    return new StarBorder(st);
  }
  public static StarBorderStarBorderBuilder starBorder() {
    return StarBorderStarBorderBuilder.starBorderStarBorder();
  }
  @Builder.Factory
  static StarBorder starBorderPolygon(Optional<BorderSideI> side, OptionalDouble sides, OptionalDouble pointRounding, OptionalDouble rotation, OptionalDouble squash) {
    var st = factories.starBorderPolygon(side.map(BorderSideI::build),
      sides,
      pointRounding,
      rotation,
      squash);
    if (st == null) throw new RuntimeException("Failed to created widget StarBorder");
    return new StarBorder(st);
  }
  public static StarBorderPolygonBuilder polygon() {
    return StarBorderPolygonBuilder.starBorderPolygon();
  }
  public double points() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("starBorderPoints not supported on web");
    return StarBorderObjSt.points(st);
  }
  public double pointRounding() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("starBorderPointRounding not supported on web");
    return StarBorderObjSt.pointRounding(st);
  }
  public double valleyRounding() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("starBorderValleyRounding not supported on web");
    return StarBorderObjSt.valleyRounding(st);
  }
  public double squash() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("starBorderSquash not supported on web");
    return StarBorderObjSt.squash(st);
  }
  public double innerRadiusRatio() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("starBorderInnerRadiusRatio not supported on web");
    return StarBorderObjSt.innerRadiusRatio(st);
  }
  public double rotation() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("starBorderRotation not supported on web");
    return StarBorderObjSt.rotation(st);
  }
  @Override
  public StarBorder build() {
    return this;
  }
}
