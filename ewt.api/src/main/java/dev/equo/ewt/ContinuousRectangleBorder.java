package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class ContinuousRectangleBorder extends OutlinedBorder implements ContinuousRectangleBorderI {
  protected ContinuousRectangleBorder() {}
  ContinuousRectangleBorder(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget ContinuousRectangleBorder");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static ContinuousRectangleBorder continuousRectangleBorderContinuousRectangleBorder(Optional<BorderSideI> side, Optional<BorderRadiusGeometryI> borderRadius) {
    int id = factories.continuousRectangleBorderContinuousRectangleBorder(side.map(BorderSideI::build),
      borderRadius.map(BorderRadiusGeometryI::build));
    if (id <= 0) throw new RuntimeException("Failed to created widget ContinuousRectangleBorder");
    return new ContinuousRectangleBorder(id);
  }
  public static ContinuousRectangleBorderContinuousRectangleBorderBuilder continuousRectangleBorder() {
    return ContinuousRectangleBorderContinuousRectangleBorderBuilder.continuousRectangleBorderContinuousRectangleBorder();
  }
  public BorderRadiusGeometry borderRadius() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("continuousRectangleBorderBorderRadius not supported on web");
    return factories.ContinuousRectangleBorder_readBack_borderRadius(nativeStruct);
  }
  @Override
  public ContinuousRectangleBorder build() {
    return this;
  }
}
