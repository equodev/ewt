package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.CircleBorderObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class CircleBorder extends OutlinedBorder implements CircleBorderI {
  private MemorySegment st;
  protected CircleBorder() {}
  CircleBorder(MemorySegment st) {
    this.id = CircleBorderObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget CircleBorder");
    System.out.println("New CircleBorder id:"+id);
  }
  CircleBorder(int id) { this.id = id; }
  @Builder.Factory
  static CircleBorder circleBorderCircleBorder(Optional<BorderSideI> side, OptionalDouble eccentricity) {
    var st = factories.circleBorderCircleBorder(side.map(BorderSideI::build),
      eccentricity);
    if (st == null) throw new RuntimeException("Failed to created widget CircleBorder");
    return new CircleBorder(st);
  }
  public static CircleBorderCircleBorderBuilder circleBorder() {
    return CircleBorderCircleBorderBuilder.circleBorderCircleBorder();
  }
  public double eccentricity() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("circleBorderEccentricity not supported on web");
    return CircleBorderObjSt.eccentricity(st);
  }
  @Override
  public CircleBorder build() {
    return this;
  }
}
