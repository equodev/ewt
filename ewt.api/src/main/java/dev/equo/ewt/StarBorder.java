package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class StarBorder extends OutlinedBorder implements StarBorderI {
  protected StarBorder() {}
  StarBorder(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget StarBorder");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static StarBorder starBorderStarBorder(Optional<BorderSideI> side, OptionalDouble points, OptionalDouble innerRadiusRatio, OptionalDouble pointRounding, OptionalDouble valleyRounding, OptionalDouble rotation, OptionalDouble squash) {
    int id = factories.starBorderStarBorder(side.map(BorderSideI::build),
      points,
      innerRadiusRatio,
      pointRounding,
      valleyRounding,
      rotation,
      squash);
    if (id <= 0) throw new RuntimeException("Failed to created widget StarBorder");
    return new StarBorder(id);
  }
  public static StarBorderStarBorderBuilder starBorder() {
    return StarBorderStarBorderBuilder.starBorderStarBorder();
  }
  @Builder.Factory
  static StarBorder starBorderPolygon(Optional<BorderSideI> side, OptionalDouble sides, OptionalDouble pointRounding, OptionalDouble rotation, OptionalDouble squash) {
    int id = factories.starBorderPolygon(side.map(BorderSideI::build),
      sides,
      pointRounding,
      rotation,
      squash);
    if (id <= 0) throw new RuntimeException("Failed to created widget StarBorder");
    return new StarBorder(id);
  }
  public static StarBorderPolygonBuilder polygon() {
    return StarBorderPolygonBuilder.starBorderPolygon();
  }
  public double points() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("starBorderPoints not supported on web");
    return factories.StarBorder_readBack_points(nativeStruct);
  }
  public double pointRounding() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("starBorderPointRounding not supported on web");
    return factories.StarBorder_readBack_pointRounding(nativeStruct);
  }
  public double valleyRounding() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("starBorderValleyRounding not supported on web");
    return factories.StarBorder_readBack_valleyRounding(nativeStruct);
  }
  public double squash() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("starBorderSquash not supported on web");
    return factories.StarBorder_readBack_squash(nativeStruct);
  }
  public double innerRadiusRatio() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("starBorderInnerRadiusRatio not supported on web");
    return factories.StarBorder_readBack_innerRadiusRatio(nativeStruct);
  }
  public double rotation() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("starBorderRotation not supported on web");
    return factories.StarBorder_readBack_rotation(nativeStruct);
  }
  @Override
  public StarBorder build() {
    return this;
  }
}
