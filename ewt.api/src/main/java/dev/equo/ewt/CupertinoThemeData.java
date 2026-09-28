package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class CupertinoThemeData extends NoDefaultCupertinoThemeData implements CupertinoThemeDataI {
  protected CupertinoThemeData() {}
  CupertinoThemeData(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget CupertinoThemeData");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static CupertinoThemeData cupertinoThemeDataCupertinoThemeData(Optional<Brightness> brightness, Optional<ColorI> primaryColor, Optional<ColorI> primaryContrastingColor, Optional<CupertinoTextThemeDataI> textTheme, Optional<ColorI> barBackgroundColor, Optional<ColorI> scaffoldBackgroundColor, Optional<ColorI> selectionHandleColor, Optional<Boolean> applyThemeToAll) {
    int id = factories.cupertinoThemeDataCupertinoThemeData(brightness,
      primaryColor.map(ColorI::build),
      primaryContrastingColor.map(ColorI::build),
      textTheme.map(CupertinoTextThemeDataI::build),
      barBackgroundColor.map(ColorI::build),
      scaffoldBackgroundColor.map(ColorI::build),
      selectionHandleColor.map(ColorI::build),
      applyThemeToAll);
    if (id <= 0) throw new RuntimeException("Failed to created widget CupertinoThemeData");
    return new CupertinoThemeData(id);
  }
  public static CupertinoThemeDataCupertinoThemeDataBuilder cupertinoThemeData() {
    return CupertinoThemeDataCupertinoThemeDataBuilder.cupertinoThemeDataCupertinoThemeData();
  }
  @Builder.Factory
  static CupertinoThemeData cupertinoThemeDataRaw(@Builder.Parameter Brightness brightness, @Builder.Parameter ColorI primaryColor, @Builder.Parameter ColorI primaryContrastingColor, @Builder.Parameter CupertinoTextThemeDataI textTheme, @Builder.Parameter ColorI barBackgroundColor, @Builder.Parameter ColorI scaffoldBackgroundColor, @Builder.Parameter ColorI selectionHandleColor, @Builder.Parameter boolean applyThemeToAll) {
    int id = factories.cupertinoThemeDataRaw(brightness,
      primaryColor.build(),
      primaryContrastingColor.build(),
      textTheme.build(),
      barBackgroundColor.build(),
      scaffoldBackgroundColor.build(),
      selectionHandleColor.build(),
      applyThemeToAll);
    if (id <= 0) throw new RuntimeException("Failed to created widget CupertinoThemeData");
    return new CupertinoThemeData(id);
  }
  public static CupertinoThemeDataRawBuilder raw(Brightness brightness, ColorI primaryColor, ColorI primaryContrastingColor, CupertinoTextThemeDataI textTheme, ColorI barBackgroundColor, ColorI scaffoldBackgroundColor, ColorI selectionHandleColor, boolean applyThemeToAll) {
    return CupertinoThemeDataRawBuilder.cupertinoThemeDataRaw(brightness, primaryColor, primaryContrastingColor, textTheme, barBackgroundColor, scaffoldBackgroundColor, selectionHandleColor, applyThemeToAll);
  }
  @Override
  public CupertinoThemeData build() {
    return this;
  }
}
