package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.ThreePointCubicObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class ThreePointCubic extends Curve implements ThreePointCubicI {
  private MemorySegment st;
  protected ThreePointCubic() {}
  ThreePointCubic(MemorySegment st) {
    this.id = ThreePointCubicObjSt.id(st);
    this.st = st;
    System.out.println("New ThreePointCubic id:"+id);
  }
  @Builder.Factory
  static ThreePointCubic threePointCubicThreePointCubic(@Builder.Parameter OffsetI a1, @Builder.Parameter OffsetI b1, @Builder.Parameter OffsetI midpoint, @Builder.Parameter OffsetI a2, @Builder.Parameter OffsetI b2) {
    var st = factories.threePointCubicThreePointCubic(a1.build(),
      b1.build(),
      midpoint.build(),
      a2.build(),
      b2.build());
    if (st == null) throw new RuntimeException("Failed to created widget ThreePointCubic");
    return new ThreePointCubic(st);
  }
  public static ThreePointCubicThreePointCubicBuilder threePointCubic(OffsetI a1, OffsetI b1, OffsetI midpoint, OffsetI a2, OffsetI b2) {
    return ThreePointCubicThreePointCubicBuilder.threePointCubicThreePointCubic(a1, b1, midpoint, a2, b2);
  }
  public Offset a1() {
    return new Offset(ThreePointCubicObjSt.a1(st));
  }
  public Offset b1() {
    return new Offset(ThreePointCubicObjSt.b1(st));
  }
  public Offset midpoint() {
    return new Offset(ThreePointCubicObjSt.midpoint(st));
  }
  public Offset a2() {
    return new Offset(ThreePointCubicObjSt.a2(st));
  }
  public Offset b2() {
    return new Offset(ThreePointCubicObjSt.b2(st));
  }
  @Override
  public ThreePointCubic build() {
    return this;
  }
}
