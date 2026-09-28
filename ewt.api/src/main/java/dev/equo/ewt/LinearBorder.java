package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class LinearBorder extends OutlinedBorder implements LinearBorderI {
  protected LinearBorder() {}
  LinearBorder(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget LinearBorder");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static LinearBorder linearBorderLinearBorder(Optional<BorderSideI> side) {
    int id = factories.linearBorderLinearBorder(side.map(BorderSideI::build));
    if (id <= 0) throw new RuntimeException("Failed to created widget LinearBorder");
    return new LinearBorder(id);
  }
  public static LinearBorderLinearBorderBuilder linearBorder() {
    return LinearBorderLinearBorderBuilder.linearBorderLinearBorder();
  }
  @Builder.Factory
  static LinearBorder linearBorderStart(Optional<BorderSideI> side, OptionalDouble alignment, OptionalDouble size) {
    int id = factories.linearBorderStart(side.map(BorderSideI::build),
      alignment,
      size);
    if (id <= 0) throw new RuntimeException("Failed to created widget LinearBorder");
    return new LinearBorder(id);
  }
  public static LinearBorderStartBuilder start() {
    return LinearBorderStartBuilder.linearBorderStart();
  }
  @Builder.Factory
  static LinearBorder linearBorderEnd(Optional<BorderSideI> side, OptionalDouble alignment, OptionalDouble size) {
    int id = factories.linearBorderEnd(side.map(BorderSideI::build),
      alignment,
      size);
    if (id <= 0) throw new RuntimeException("Failed to created widget LinearBorder");
    return new LinearBorder(id);
  }
  public static LinearBorderEndBuilder end() {
    return LinearBorderEndBuilder.linearBorderEnd();
  }
  @Builder.Factory
  static LinearBorder linearBorderTop(Optional<BorderSideI> side, OptionalDouble alignment, OptionalDouble size) {
    int id = factories.linearBorderTop(side.map(BorderSideI::build),
      alignment,
      size);
    if (id <= 0) throw new RuntimeException("Failed to created widget LinearBorder");
    return new LinearBorder(id);
  }
  public static LinearBorderTopBuilder top() {
    return LinearBorderTopBuilder.linearBorderTop();
  }
  @Builder.Factory
  static LinearBorder linearBorderBottom(Optional<BorderSideI> side, OptionalDouble alignment, OptionalDouble size) {
    int id = factories.linearBorderBottom(side.map(BorderSideI::build),
      alignment,
      size);
    if (id <= 0) throw new RuntimeException("Failed to created widget LinearBorder");
    return new LinearBorder(id);
  }
  public static LinearBorderBottomBuilder bottom() {
    return LinearBorderBottomBuilder.linearBorderBottom();
  }
  public static LinearBorder none() {
    return LinearBorder.linearBorder().build();
  }
  @Override
  public LinearBorder build() {
    return this;
  }
}
