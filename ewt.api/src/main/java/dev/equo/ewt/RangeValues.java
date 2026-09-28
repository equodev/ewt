package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class RangeValues extends NativeObj.Base implements RangeValuesI {
  protected RangeValues() {}
  RangeValues(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget RangeValues");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static RangeValues rangeValuesRangeValues(@Builder.Parameter double start, @Builder.Parameter double end) {
    int id = factories.rangeValuesRangeValues(start,
      end);
    if (id <= 0) throw new RuntimeException("Failed to created widget RangeValues");
    return new RangeValues(id);
  }
  public static RangeValuesRangeValuesBuilder rangeValues(double start, double end) {
    return RangeValuesRangeValuesBuilder.rangeValuesRangeValues(start, end);
  }
  public double start() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("rangeValuesStart not supported on web");
    return factories.RangeValues_readBack_start(nativeStruct);
  }
  public double end() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("rangeValuesEnd not supported on web");
    return factories.RangeValues_readBack_end(nativeStruct);
  }
  @Override
  public RangeValues build() {
    return this;
  }
}
