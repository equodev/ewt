package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.VisualDensityObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class VisualDensity extends NativeObj.Base implements VisualDensityI {
  private MemorySegment st;
  protected VisualDensity() {}
  VisualDensity(MemorySegment st) {
    this.id = VisualDensityObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget VisualDensity");
    System.out.println("New VisualDensity id:"+id);
  }
  @Builder.Factory
  static VisualDensity visualDensityVisualDensity(OptionalDouble horizontal, OptionalDouble vertical) {
    var st = factories.visualDensityVisualDensity(horizontal,
      vertical);
    if (st == null) throw new RuntimeException("Failed to created widget VisualDensity");
    return new VisualDensity(st);
  }
  public static VisualDensityVisualDensityBuilder visualDensity() {
    return VisualDensityVisualDensityBuilder.visualDensityVisualDensity();
  }
  public static VisualDensity defaultDensityForPlatform(TargetPlatform platform) {
    var st = factories.visualDensityDefaultDensityForPlatform(platform);
    if (st == null) throw new RuntimeException("Failed to created widget VisualDensity");
    return new VisualDensity(st);
  }
  public static VisualDensity lerp(VisualDensityI a, VisualDensityI b, double t) {
    var st = factories.visualDensityLerp(a.build(),
      b.build(),
      t);
    if (st == null) throw new RuntimeException("Failed to created widget VisualDensity");
    return new VisualDensity(st);
  }
  public double horizontal() {
    return VisualDensityObjSt.horizontal(st);
  }
  public double vertical() {
    return VisualDensityObjSt.vertical(st);
  }
  public Offset baseSizeAdjustment() {
    return new Offset(VisualDensityObjSt.baseSizeAdjustment(st));
  }
  public static double minimumDensity() {
    return -4.0;
  }
  public static double maximumDensity() {
    return 4.0;
  }
  public static VisualDensity standard() {
    return VisualDensity.visualDensity().build();
  }
  public static VisualDensity comfortable() {
    return VisualDensity.visualDensity().horizontal(-1.0).vertical(-1.0).build();
  }
  public static VisualDensity compact() {
    return VisualDensity.visualDensity().horizontal(-2.0).vertical(-2.0).build();
  }
  @Override
  public VisualDensity build() {
    return this;
  }
}
