package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.RotatedBoxObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class RotatedBox extends SingleChildRenderObjectWidget implements RotatedBoxI {
  private MemorySegment st;
  protected RotatedBox() {}
  RotatedBox(MemorySegment st) {
    this.id = RotatedBoxObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget RotatedBox");
    System.out.println("New RotatedBox id:"+id);
  }
  @Builder.Factory
  static RotatedBox rotatedBoxRotatedBox(@Builder.Parameter int quarterTurns, Optional<WidgetI> child) {
    var st = factories.rotatedBoxRotatedBox(quarterTurns,
      child.map(WidgetI::build));
    if (st == null) throw new RuntimeException("Failed to created widget RotatedBox");
    return new RotatedBox(st);
  }
  public static RotatedBoxRotatedBoxBuilder rotatedBox(int quarterTurns) {
    return RotatedBoxRotatedBoxBuilder.rotatedBoxRotatedBox(quarterTurns);
  }
  public int quarterTurns() {
    return RotatedBoxObjSt.quarterTurns(st);
  }
  @Override
  public RotatedBox build() {
    return this;
  }
}
