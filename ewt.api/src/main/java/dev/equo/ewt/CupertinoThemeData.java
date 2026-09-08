package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.CupertinoThemeDataObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class CupertinoThemeData extends NoDefaultCupertinoThemeData implements CupertinoThemeDataI {
  private MemorySegment st;
  protected CupertinoThemeData() {}
  CupertinoThemeData(MemorySegment st) {
    this.id = CupertinoThemeDataObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget CupertinoThemeData");
    System.out.println("New CupertinoThemeData id:"+id);
  }
  CupertinoThemeData(int id) { this.id = id; }
  @Builder.Factory
  static CupertinoThemeData cupertinoThemeDataCupertinoThemeData(Optional<Brightness> brightness, Optional<ColorI> primaryColor, Optional<ColorI> primaryContrastingColor, Optional<CupertinoTextThemeDataI> textTheme, Optional<ColorI> barBackgroundColor, Optional<ColorI> scaffoldBackgroundColor, Optional<ColorI> selectionHandleColor, Optional<Boolean> applyThemeToAll) {
    var st = factories.cupertinoThemeDataCupertinoThemeData(brightness,
      primaryColor.map(ColorI::build),
      primaryContrastingColor.map(ColorI::build),
      textTheme.map(CupertinoTextThemeDataI::build),
      barBackgroundColor.map(ColorI::build),
      scaffoldBackgroundColor.map(ColorI::build),
      selectionHandleColor.map(ColorI::build),
      applyThemeToAll);
    if (st == null) throw new RuntimeException("Failed to created widget CupertinoThemeData");
    return new CupertinoThemeData(st);
  }
  public static CupertinoThemeDataCupertinoThemeDataBuilder cupertinoThemeData() {
    return CupertinoThemeDataCupertinoThemeDataBuilder.cupertinoThemeDataCupertinoThemeData();
  }
  @Builder.Factory
  static CupertinoThemeData cupertinoThemeDataRaw(@Builder.Parameter Brightness brightness, @Builder.Parameter ColorI primaryColor, @Builder.Parameter ColorI primaryContrastingColor, @Builder.Parameter CupertinoTextThemeDataI textTheme, @Builder.Parameter ColorI barBackgroundColor, @Builder.Parameter ColorI scaffoldBackgroundColor, @Builder.Parameter ColorI selectionHandleColor, @Builder.Parameter boolean applyThemeToAll) {
    var st = factories.cupertinoThemeDataRaw(brightness,
      primaryColor.build(),
      primaryContrastingColor.build(),
      textTheme.build(),
      barBackgroundColor.build(),
      scaffoldBackgroundColor.build(),
      selectionHandleColor.build(),
      applyThemeToAll);
    if (st == null) throw new RuntimeException("Failed to created widget CupertinoThemeData");
    return new CupertinoThemeData(st);
  }
  public static CupertinoThemeDataRawBuilder raw(Brightness brightness, ColorI primaryColor, ColorI primaryContrastingColor, CupertinoTextThemeDataI textTheme, ColorI barBackgroundColor, ColorI scaffoldBackgroundColor, ColorI selectionHandleColor, boolean applyThemeToAll) {
    return CupertinoThemeDataRawBuilder.cupertinoThemeDataRaw(brightness, primaryColor, primaryContrastingColor, textTheme, barBackgroundColor, scaffoldBackgroundColor, selectionHandleColor, applyThemeToAll);
  }
  @Override
  public CupertinoThemeData build() {
    return this;
  }
}
