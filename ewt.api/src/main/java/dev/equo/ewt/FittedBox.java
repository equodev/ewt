package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.FittedBoxObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class FittedBox extends SingleChildRenderObjectWidget implements FittedBoxI {
  private MemorySegment st;
  protected FittedBox() {}
  FittedBox(MemorySegment st) {
    this.id = FittedBoxObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget FittedBox");
    System.out.println("New FittedBox id:"+id);
  }
  @Builder.Factory
  static FittedBox fittedBoxFittedBox(Optional<BoxFit> fit, Optional<AlignmentGeometryI> alignment, Optional<Clip> clipBehavior, Optional<WidgetI> child) {
    var st = factories.fittedBoxFittedBox(fit,
      alignment.map(AlignmentGeometryI::build),
      clipBehavior,
      child.map(WidgetI::build));
    if (st == null) throw new RuntimeException("Failed to created widget FittedBox");
    return new FittedBox(st);
  }
  public static FittedBoxFittedBoxBuilder fittedBox() {
    return FittedBoxFittedBoxBuilder.fittedBoxFittedBox();
  }
  public BoxFit fit() {
    return BoxFit.values()[FittedBoxObjSt.fit(st)];
  }
  public AlignmentGeometry alignment() {
    return new AlignmentGeometry(FittedBoxObjSt.alignment(st)) {};
  }
  public Clip clipBehavior() {
    return Clip.values()[FittedBoxObjSt.clipBehavior(st)];
  }
  @Override
  public FittedBox build() {
    return this;
  }
}
