package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class RoundedRectangleBorder extends OutlinedBorder implements RoundedRectangleBorderI {
  protected RoundedRectangleBorder() {}
  RoundedRectangleBorder(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget RoundedRectangleBorder");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static RoundedRectangleBorder roundedRectangleBorderRoundedRectangleBorder(Optional<BorderSideI> side, Optional<BorderRadiusGeometryI> borderRadius) {
    int id = factories.roundedRectangleBorderRoundedRectangleBorder(side.map(BorderSideI::build),
      borderRadius.map(BorderRadiusGeometryI::build));
    if (id <= 0) throw new RuntimeException("Failed to created widget RoundedRectangleBorder");
    return new RoundedRectangleBorder(id);
  }
  public static RoundedRectangleBorderRoundedRectangleBorderBuilder roundedRectangleBorder() {
    return RoundedRectangleBorderRoundedRectangleBorderBuilder.roundedRectangleBorderRoundedRectangleBorder();
  }
  public BorderRadiusGeometry borderRadius() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("roundedRectangleBorderBorderRadius not supported on web");
    return factories.RoundedRectangleBorder_readBack_borderRadius(nativeStruct);
  }
  @Override
  public RoundedRectangleBorder build() {
    return this;
  }
}
