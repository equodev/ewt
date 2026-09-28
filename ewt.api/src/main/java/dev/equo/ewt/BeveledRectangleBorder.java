package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class BeveledRectangleBorder extends OutlinedBorder implements BeveledRectangleBorderI {
  protected BeveledRectangleBorder() {}
  BeveledRectangleBorder(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget BeveledRectangleBorder");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static BeveledRectangleBorder beveledRectangleBorderBeveledRectangleBorder(Optional<BorderSideI> side, Optional<BorderRadiusGeometryI> borderRadius) {
    int id = factories.beveledRectangleBorderBeveledRectangleBorder(side.map(BorderSideI::build),
      borderRadius.map(BorderRadiusGeometryI::build));
    if (id <= 0) throw new RuntimeException("Failed to created widget BeveledRectangleBorder");
    return new BeveledRectangleBorder(id);
  }
  public static BeveledRectangleBorderBeveledRectangleBorderBuilder beveledRectangleBorder() {
    return BeveledRectangleBorderBeveledRectangleBorderBuilder.beveledRectangleBorderBeveledRectangleBorder();
  }
  public BorderRadiusGeometry borderRadius() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("beveledRectangleBorderBorderRadius not supported on web");
    return factories.BeveledRectangleBorder_readBack_borderRadius(nativeStruct);
  }
  @Override
  public BeveledRectangleBorder build() {
    return this;
  }
}
