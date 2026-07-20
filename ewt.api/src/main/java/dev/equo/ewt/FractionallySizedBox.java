package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.FractionallySizedBoxObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class FractionallySizedBox extends SingleChildRenderObjectWidget implements FractionallySizedBoxI {
  private MemorySegment st;
  protected FractionallySizedBox() {}
  FractionallySizedBox(MemorySegment st) {
    this.id = FractionallySizedBoxObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget FractionallySizedBox");
    System.out.println("New FractionallySizedBox id:"+id);
  }
  @Builder.Factory
  static FractionallySizedBox fractionallySizedBoxFractionallySizedBox(Optional<AlignmentGeometryI> alignment, OptionalDouble widthFactor, OptionalDouble heightFactor, Optional<WidgetI> child) {
    var st = factories.fractionallySizedBoxFractionallySizedBox(alignment.map(AlignmentGeometryI::build),
      widthFactor,
      heightFactor,
      child.map(WidgetI::build));
    if (st == null) throw new RuntimeException("Failed to created widget FractionallySizedBox");
    return new FractionallySizedBox(st);
  }
  public static FractionallySizedBoxFractionallySizedBoxBuilder fractionallySizedBox() {
    return FractionallySizedBoxFractionallySizedBoxBuilder.fractionallySizedBoxFractionallySizedBox();
  }
  public double widthFactor() {
    return FractionallySizedBoxObjSt.widthFactor(st);
  }
  public double heightFactor() {
    return FractionallySizedBoxObjSt.heightFactor(st);
  }
  public AlignmentGeometry alignment() {
    return new AlignmentGeometry(FractionallySizedBoxObjSt.alignment(st)) {};
  }
  @Override
  public FractionallySizedBox build() {
    return this;
  }
}
