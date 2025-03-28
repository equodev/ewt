package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.TextThemeObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class TextTheme extends NativeObj.Base {
  private MemorySegment st;
  TextTheme(MemorySegment st) {
    this.id = TextThemeObjSt.id(st);
    this.st = st;
    System.out.println("New TextTheme id:"+id);
  }
  @Builder.Factory
  static TextTheme textThemeTextTheme(Optional<TextStyle> displayLarge, Optional<TextStyle> displayMedium, Optional<TextStyle> displaySmall, Optional<TextStyle> headlineLarge, Optional<TextStyle> headlineMedium, Optional<TextStyle> headlineSmall, Optional<TextStyle> titleLarge, Optional<TextStyle> titleMedium, Optional<TextStyle> titleSmall, Optional<TextStyle> bodyLarge, Optional<TextStyle> bodyMedium, Optional<TextStyle> bodySmall, Optional<TextStyle> labelLarge, Optional<TextStyle> labelMedium, Optional<TextStyle> labelSmall) {
    var st = factories.textThemeTextTheme(displayLarge,
      displayMedium,
      displaySmall,
      headlineLarge,
      headlineMedium,
      headlineSmall,
      titleLarge,
      titleMedium,
      titleSmall,
      bodyLarge,
      bodyMedium,
      bodySmall,
      labelLarge,
      labelMedium,
      labelSmall);
    if (st == null) throw new RuntimeException("Failed to created widget TextTheme");
    return new TextTheme(st);
  }
  public static TextThemeTextThemeBuilder textTheme() {
    return TextThemeTextThemeBuilder.textThemeTextTheme();
  }
  public static TextTheme lerp(TextTheme a, TextTheme b, double t) {
    var st = factories.textThemeLerp(a,
      b,
      t);
    if (st == null) throw new RuntimeException("Failed to created widget TextTheme");
    return new TextTheme(st);
  }
  public static TextTheme of(BuildContext context) {
    var st = factories.textThemeOf(context);
    if (st == null) throw new RuntimeException("Failed to created widget TextTheme");
    return new TextTheme(st);
  }
  public static TextTheme primaryOf(BuildContext context) {
    var st = factories.textThemePrimaryOf(context);
    if (st == null) throw new RuntimeException("Failed to created widget TextTheme");
    return new TextTheme(st);
  }
  public TextStyle displayLarge() {
    return new TextStyle(TextThemeObjSt.displayLarge(st)) {};
  }
  public TextStyle displayMedium() {
    return new TextStyle(TextThemeObjSt.displayMedium(st)) {};
  }
  public TextStyle displaySmall() {
    return new TextStyle(TextThemeObjSt.displaySmall(st)) {};
  }
  public TextStyle headlineLarge() {
    return new TextStyle(TextThemeObjSt.headlineLarge(st)) {};
  }
  public TextStyle headlineMedium() {
    return new TextStyle(TextThemeObjSt.headlineMedium(st)) {};
  }
  public TextStyle headlineSmall() {
    return new TextStyle(TextThemeObjSt.headlineSmall(st)) {};
  }
  public TextStyle titleLarge() {
    return new TextStyle(TextThemeObjSt.titleLarge(st)) {};
  }
  public TextStyle titleMedium() {
    return new TextStyle(TextThemeObjSt.titleMedium(st)) {};
  }
  public TextStyle titleSmall() {
    return new TextStyle(TextThemeObjSt.titleSmall(st)) {};
  }
  public TextStyle bodyLarge() {
    return new TextStyle(TextThemeObjSt.bodyLarge(st)) {};
  }
  public TextStyle bodyMedium() {
    return new TextStyle(TextThemeObjSt.bodyMedium(st)) {};
  }
  public TextStyle bodySmall() {
    return new TextStyle(TextThemeObjSt.bodySmall(st)) {};
  }
  public TextStyle labelLarge() {
    return new TextStyle(TextThemeObjSt.labelLarge(st)) {};
  }
  public TextStyle labelMedium() {
    return new TextStyle(TextThemeObjSt.labelMedium(st)) {};
  }
  public TextStyle labelSmall() {
    return new TextStyle(TextThemeObjSt.labelSmall(st)) {};
  }
}
