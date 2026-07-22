package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.OverflowBoxObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class OverflowBox extends SingleChildRenderObjectWidget implements OverflowBoxI {
  private MemorySegment st;
  protected OverflowBox() {}
  OverflowBox(MemorySegment st) {
    this.id = OverflowBoxObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget OverflowBox");
    System.out.println("New OverflowBox id:"+id);
  }
  OverflowBox(int id) { this.id = id; }
  @Builder.Factory
  static OverflowBox overflowBoxOverflowBox(Optional<AlignmentGeometryI> alignment, OptionalDouble minWidth, OptionalDouble maxWidth, OptionalDouble minHeight, OptionalDouble maxHeight, Optional<OverflowBoxFit> fit, Optional<WidgetI> child) {
    var st = factories.overflowBoxOverflowBox(alignment.map(AlignmentGeometryI::build),
      minWidth,
      maxWidth,
      minHeight,
      maxHeight,
      fit,
      child.map(WidgetI::build));
    if (st == null) throw new RuntimeException("Failed to created widget OverflowBox");
    return new OverflowBox(st);
  }
  public static OverflowBoxOverflowBoxBuilder overflowBox() {
    return OverflowBoxOverflowBoxBuilder.overflowBoxOverflowBox();
  }
  public AlignmentGeometry alignment() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("overflowBoxAlignment not supported on web");
    return new AlignmentGeometry(OverflowBoxObjSt.alignment(st)) {};
  }
  public double minWidth() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("overflowBoxMinWidth not supported on web");
    return OverflowBoxObjSt.minWidth(st);
  }
  public double maxWidth() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("overflowBoxMaxWidth not supported on web");
    return OverflowBoxObjSt.maxWidth(st);
  }
  public double minHeight() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("overflowBoxMinHeight not supported on web");
    return OverflowBoxObjSt.minHeight(st);
  }
  public double maxHeight() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("overflowBoxMaxHeight not supported on web");
    return OverflowBoxObjSt.maxHeight(st);
  }
  public OverflowBoxFit fit() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("overflowBoxFit not supported on web");
    return OverflowBoxFit.values()[OverflowBoxObjSt.fit(st)];
  }
  @Override
  public OverflowBox build() {
    return this;
  }
}
