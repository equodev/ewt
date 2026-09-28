package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class CupertinoIconThemeData extends IconThemeData implements CupertinoIconThemeDataI {
  protected CupertinoIconThemeData() {}
  CupertinoIconThemeData(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget CupertinoIconThemeData");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static CupertinoIconThemeData cupertinoIconThemeDataCupertinoIconThemeData(OptionalDouble size, OptionalDouble fill, OptionalDouble weight, OptionalDouble grade, OptionalDouble opticalSize, Optional<ColorI> color, OptionalDouble opacity, Optional<List<ShadowI>> shadows, Optional<Boolean> applyTextScaling) {
    int id = factories.cupertinoIconThemeDataCupertinoIconThemeData(size,
      fill,
      weight,
      grade,
      opticalSize,
      color.map(ColorI::build),
      opacity,
      shadows.map(i -> i.stream().map(ShadowI::build).collect(java.util.stream.Collectors.toList())),
      applyTextScaling);
    if (id <= 0) throw new RuntimeException("Failed to created widget CupertinoIconThemeData");
    return new CupertinoIconThemeData(id);
  }
  public static CupertinoIconThemeDataCupertinoIconThemeDataBuilder cupertinoIconThemeData() {
    return CupertinoIconThemeDataCupertinoIconThemeDataBuilder.cupertinoIconThemeDataCupertinoIconThemeData();
  }
  @Override
  public CupertinoIconThemeData build() {
    return this;
  }
}
