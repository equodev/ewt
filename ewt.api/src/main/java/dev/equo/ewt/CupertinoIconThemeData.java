package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.CupertinoIconThemeDataObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class CupertinoIconThemeData extends IconThemeData implements CupertinoIconThemeDataI {
  private MemorySegment st;
  protected CupertinoIconThemeData() {}
  CupertinoIconThemeData(MemorySegment st) {
    this.id = CupertinoIconThemeDataObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget CupertinoIconThemeData");
    System.out.println("New CupertinoIconThemeData id:"+id);
  }
  CupertinoIconThemeData(int id) { this.id = id; }
  @Builder.Factory
  static CupertinoIconThemeData cupertinoIconThemeDataCupertinoIconThemeData(OptionalDouble size, OptionalDouble fill, OptionalDouble weight, OptionalDouble grade, OptionalDouble opticalSize, Optional<ColorI> color, OptionalDouble opacity, Optional<List<ShadowI>> shadows, Optional<Boolean> applyTextScaling) {
    var st = factories.cupertinoIconThemeDataCupertinoIconThemeData(size,
      fill,
      weight,
      grade,
      opticalSize,
      color.map(ColorI::build),
      opacity,
      shadows.map(i -> i.stream().map(ShadowI::build).toList()),
      applyTextScaling);
    if (st == null) throw new RuntimeException("Failed to created widget CupertinoIconThemeData");
    return new CupertinoIconThemeData(st);
  }
  public static CupertinoIconThemeDataCupertinoIconThemeDataBuilder cupertinoIconThemeData() {
    return CupertinoIconThemeDataCupertinoIconThemeDataBuilder.cupertinoIconThemeDataCupertinoIconThemeData();
  }
  @Override
  public CupertinoIconThemeData build() {
    return this;
  }
}
