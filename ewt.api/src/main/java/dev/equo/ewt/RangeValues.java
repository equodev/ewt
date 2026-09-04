package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.RangeValuesObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class RangeValues extends NativeObj.Base implements RangeValuesI {
  private MemorySegment st;
  protected RangeValues() {}
  RangeValues(MemorySegment st) {
    this.id = RangeValuesObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget RangeValues");
    System.out.println("New RangeValues id:"+id);
  }
  RangeValues(int id) { this.id = id; }
  @Builder.Factory
  static RangeValues rangeValuesRangeValues(@Builder.Parameter double start, @Builder.Parameter double end) {
    var st = factories.rangeValuesRangeValues(start,
      end);
    if (st == null) throw new RuntimeException("Failed to created widget RangeValues");
    return new RangeValues(st);
  }
  public static RangeValuesRangeValuesBuilder rangeValues(double start, double end) {
    return RangeValuesRangeValuesBuilder.rangeValuesRangeValues(start, end);
  }
  public double start() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("rangeValuesStart not supported on web");
    return RangeValuesObjSt.start(st);
  }
  public double end() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("rangeValuesEnd not supported on web");
    return RangeValuesObjSt.end(st);
  }
  @Override
  public RangeValues build() {
    return this;
  }
}
