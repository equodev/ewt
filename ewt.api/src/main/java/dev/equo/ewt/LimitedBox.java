package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.LimitedBoxObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class LimitedBox extends SingleChildRenderObjectWidget implements LimitedBoxI {
  private MemorySegment st;
  protected LimitedBox() {}
  LimitedBox(MemorySegment st) {
    this.id = LimitedBoxObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget LimitedBox");
    System.out.println("New LimitedBox id:"+id);
  }
  LimitedBox(int id) { this.id = id; }
  @Builder.Factory
  static LimitedBox limitedBoxLimitedBox(OptionalDouble maxWidth, OptionalDouble maxHeight, Optional<WidgetI> child) {
    var st = factories.limitedBoxLimitedBox(maxWidth,
      maxHeight,
      child.map(WidgetI::build));
    if (st == null) throw new RuntimeException("Failed to created widget LimitedBox");
    return new LimitedBox(st);
  }
  public static LimitedBoxLimitedBoxBuilder limitedBox() {
    return LimitedBoxLimitedBoxBuilder.limitedBoxLimitedBox();
  }
  public double maxWidth() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("limitedBoxMaxWidth not supported on web");
    return LimitedBoxObjSt.maxWidth(st);
  }
  public double maxHeight() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("limitedBoxMaxHeight not supported on web");
    return LimitedBoxObjSt.maxHeight(st);
  }
  @Override
  public LimitedBox build() {
    return this;
  }
}
