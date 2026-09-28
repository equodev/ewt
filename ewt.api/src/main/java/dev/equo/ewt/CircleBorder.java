package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class CircleBorder extends OutlinedBorder implements CircleBorderI {
  protected CircleBorder() {}
  CircleBorder(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget CircleBorder");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static CircleBorder circleBorderCircleBorder(Optional<BorderSideI> side, OptionalDouble eccentricity) {
    int id = factories.circleBorderCircleBorder(side.map(BorderSideI::build),
      eccentricity);
    if (id <= 0) throw new RuntimeException("Failed to created widget CircleBorder");
    return new CircleBorder(id);
  }
  public static CircleBorderCircleBorderBuilder circleBorder() {
    return CircleBorderCircleBorderBuilder.circleBorderCircleBorder();
  }
  public double eccentricity() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("circleBorderEccentricity not supported on web");
    return factories.CircleBorder_readBack_eccentricity(nativeStruct);
  }
  @Override
  public CircleBorder build() {
    return this;
  }
}
