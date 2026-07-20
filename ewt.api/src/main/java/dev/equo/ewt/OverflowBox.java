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
    return new AlignmentGeometry(OverflowBoxObjSt.alignment(st)) {};
  }
  public double minWidth() {
    return OverflowBoxObjSt.minWidth(st);
  }
  public double maxWidth() {
    return OverflowBoxObjSt.maxWidth(st);
  }
  public double minHeight() {
    return OverflowBoxObjSt.minHeight(st);
  }
  public double maxHeight() {
    return OverflowBoxObjSt.maxHeight(st);
  }
  public OverflowBoxFit fit() {
    return OverflowBoxFit.values()[OverflowBoxObjSt.fit(st)];
  }
  @Override
  public OverflowBox build() {
    return this;
  }
}
