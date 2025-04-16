package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.BoxShadowObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class BoxShadow extends Shadow implements BoxShadowI {
  private MemorySegment st;
  protected BoxShadow() {}
  BoxShadow(MemorySegment st) {
    this.id = BoxShadowObjSt.id(st);
    this.st = st;
    System.out.println("New BoxShadow id:"+id);
  }
  @Builder.Factory
  static BoxShadow boxShadowBoxShadow(Optional<ColorI> color, Optional<OffsetI> offset, OptionalDouble blurRadius, OptionalDouble spreadRadius, Optional<BlurStyle> blurStyle) {
    var st = factories.boxShadowBoxShadow(color.map(ColorI::build),
      offset.map(OffsetI::build),
      blurRadius,
      spreadRadius,
      blurStyle);
    if (st == null) throw new RuntimeException("Failed to created widget BoxShadow");
    return new BoxShadow(st);
  }
  public static BoxShadowBoxShadowBuilder boxShadow() {
    return BoxShadowBoxShadowBuilder.boxShadowBoxShadow();
  }
  public static BoxShadow lerp(BoxShadowI a, BoxShadowI b, double t) {
    var st = factories.boxShadowLerp(a.build(),
      b.build(),
      t);
    if (st == null) throw new RuntimeException("Failed to created widget BoxShadow");
    return new BoxShadow(st);
  }
  public double spreadRadius() {
    return BoxShadowObjSt.spreadRadius(st);
  }
  public BlurStyle blurStyle() {
    return BlurStyle.values()[BoxShadowObjSt.blurStyle(st)];
  }
  @Override
  public BoxShadow build() {
    return this;
  }
}
