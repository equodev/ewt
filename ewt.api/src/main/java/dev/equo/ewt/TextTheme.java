package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.TextThemeObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class TextTheme extends NativeObj.Base implements TextThemeI {
  private MemorySegment st;
  protected TextTheme() {}
  TextTheme(MemorySegment st) {
    this.id = TextThemeObjSt.id(st);
    this.st = st;
    System.out.println("New TextTheme id:"+id);
  }
  @Builder.Factory
  static TextTheme textThemeTextTheme(Optional<TextStyleI> displayLarge, Optional<TextStyleI> displayMedium, Optional<TextStyleI> displaySmall, Optional<TextStyleI> headlineLarge, Optional<TextStyleI> headlineMedium, Optional<TextStyleI> headlineSmall, Optional<TextStyleI> titleLarge, Optional<TextStyleI> titleMedium, Optional<TextStyleI> titleSmall, Optional<TextStyleI> bodyLarge, Optional<TextStyleI> bodyMedium, Optional<TextStyleI> bodySmall, Optional<TextStyleI> labelLarge, Optional<TextStyleI> labelMedium, Optional<TextStyleI> labelSmall) {
    var st = factories.textThemeTextTheme(displayLarge.map(TextStyleI::build),
      displayMedium.map(TextStyleI::build),
      displaySmall.map(TextStyleI::build),
      headlineLarge.map(TextStyleI::build),
      headlineMedium.map(TextStyleI::build),
      headlineSmall.map(TextStyleI::build),
      titleLarge.map(TextStyleI::build),
      titleMedium.map(TextStyleI::build),
      titleSmall.map(TextStyleI::build),
      bodyLarge.map(TextStyleI::build),
      bodyMedium.map(TextStyleI::build),
      bodySmall.map(TextStyleI::build),
      labelLarge.map(TextStyleI::build),
      labelMedium.map(TextStyleI::build),
      labelSmall.map(TextStyleI::build));
    if (st == null) throw new RuntimeException("Failed to created widget TextTheme");
    return new TextTheme(st);
  }
  public static TextThemeTextThemeBuilder textTheme() {
    return TextThemeTextThemeBuilder.textThemeTextTheme();
  }
  public static TextTheme lerp(TextThemeI a, TextThemeI b, double t) {
    var st = factories.textThemeLerp(a.build(),
      b.build(),
      t);
    if (st == null) throw new RuntimeException("Failed to created widget TextTheme");
    return new TextTheme(st);
  }
  public static TextTheme of(BuildContextI context) {
    var st = factories.textThemeOf(context.build());
    if (st == null) throw new RuntimeException("Failed to created widget TextTheme");
    return new TextTheme(st);
  }
  public static TextTheme primaryOf(BuildContextI context) {
    var st = factories.textThemePrimaryOf(context.build());
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
  @Override
  public TextTheme build() {
    return this;
  }
}
