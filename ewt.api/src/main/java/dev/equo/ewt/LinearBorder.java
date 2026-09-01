package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.LinearBorderObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class LinearBorder extends OutlinedBorder implements LinearBorderI {
  private MemorySegment st;
  protected LinearBorder() {}
  LinearBorder(MemorySegment st) {
    this.id = LinearBorderObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget LinearBorder");
    System.out.println("New LinearBorder id:"+id);
  }
  LinearBorder(int id) { this.id = id; }
  @Builder.Factory
  static LinearBorder linearBorderLinearBorder(Optional<BorderSideI> side) {
    var st = factories.linearBorderLinearBorder(side.map(BorderSideI::build));
    if (st == null) throw new RuntimeException("Failed to created widget LinearBorder");
    return new LinearBorder(st);
  }
  public static LinearBorderLinearBorderBuilder linearBorder() {
    return LinearBorderLinearBorderBuilder.linearBorderLinearBorder();
  }
  @Builder.Factory
  static LinearBorder linearBorderStart(Optional<BorderSideI> side, OptionalDouble alignment, OptionalDouble size) {
    var st = factories.linearBorderStart(side.map(BorderSideI::build),
      alignment,
      size);
    if (st == null) throw new RuntimeException("Failed to created widget LinearBorder");
    return new LinearBorder(st);
  }
  public static LinearBorderStartBuilder start() {
    return LinearBorderStartBuilder.linearBorderStart();
  }
  @Builder.Factory
  static LinearBorder linearBorderEnd(Optional<BorderSideI> side, OptionalDouble alignment, OptionalDouble size) {
    var st = factories.linearBorderEnd(side.map(BorderSideI::build),
      alignment,
      size);
    if (st == null) throw new RuntimeException("Failed to created widget LinearBorder");
    return new LinearBorder(st);
  }
  public static LinearBorderEndBuilder end() {
    return LinearBorderEndBuilder.linearBorderEnd();
  }
  @Builder.Factory
  static LinearBorder linearBorderTop(Optional<BorderSideI> side, OptionalDouble alignment, OptionalDouble size) {
    var st = factories.linearBorderTop(side.map(BorderSideI::build),
      alignment,
      size);
    if (st == null) throw new RuntimeException("Failed to created widget LinearBorder");
    return new LinearBorder(st);
  }
  public static LinearBorderTopBuilder top() {
    return LinearBorderTopBuilder.linearBorderTop();
  }
  @Builder.Factory
  static LinearBorder linearBorderBottom(Optional<BorderSideI> side, OptionalDouble alignment, OptionalDouble size) {
    var st = factories.linearBorderBottom(side.map(BorderSideI::build),
      alignment,
      size);
    if (st == null) throw new RuntimeException("Failed to created widget LinearBorder");
    return new LinearBorder(st);
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
