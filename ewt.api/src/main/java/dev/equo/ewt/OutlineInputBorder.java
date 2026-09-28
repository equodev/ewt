package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class OutlineInputBorder extends InputBorder implements OutlineInputBorderI {
  protected OutlineInputBorder() {}
  OutlineInputBorder(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget OutlineInputBorder");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static OutlineInputBorder outlineInputBorderOutlineInputBorder(Optional<BorderSideI> borderSide, Optional<BorderRadiusI> borderRadius, OptionalDouble gapPadding) {
    int id = factories.outlineInputBorderOutlineInputBorder(borderSide.map(BorderSideI::build),
      borderRadius.map(BorderRadiusI::build),
      gapPadding);
    if (id <= 0) throw new RuntimeException("Failed to created widget OutlineInputBorder");
    return new OutlineInputBorder(id);
  }
  public static OutlineInputBorderOutlineInputBorderBuilder outlineInputBorder() {
    return OutlineInputBorderOutlineInputBorderBuilder.outlineInputBorderOutlineInputBorder();
  }
  public double gapPadding() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("outlineInputBorderGapPadding not supported on web");
    return factories.OutlineInputBorder_readBack_gapPadding(nativeStruct);
  }
  public BorderRadius borderRadius() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("outlineInputBorderBorderRadius", getId());
      return new BorderRadius(__nid);
    }
    return factories.OutlineInputBorder_readBack_borderRadius(nativeStruct);
  }
  @Override
  public OutlineInputBorder build() {
    return this;
  }
}
