package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.ThemeObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class Theme extends StatelessWidget implements ThemeI {
  private MemorySegment st;
  protected Theme() {}
  Theme(MemorySegment st) {
    this.id = ThemeObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget Theme");
    System.out.println("New Theme id:"+id);
  }
  @Builder.Factory
  static Theme themeTheme(@Builder.Parameter ThemeDataI data, @Builder.Parameter WidgetI child) {
    var st = factories.themeTheme(data.build(),
      child.build());
    if (st == null) throw new RuntimeException("Failed to created widget Theme");
    return new Theme(st);
  }
  public static ThemeThemeBuilder theme(ThemeDataI data, WidgetI child) {
    return ThemeThemeBuilder.themeTheme(data, child);
  }
  public static ThemeData of(BuildContextI context) {
    var st = factories.themeOf(context.build());
    if (st == null) throw new RuntimeException("Failed to created widget ThemeData");
    return new ThemeData(st);
  }
  public static Brightness brightnessOf(BuildContextI context) {
    int id = factories.themeBrightnessOf(context.build());
    if (id <= 0) throw new RuntimeException("Failed to created widget Brightness");
    System.out.println("New Brightness id:"+id);
    return Brightness.values()[id];
  }
  public static Brightness maybeBrightnessOf(BuildContextI context) {
    int id = factories.themeMaybeBrightnessOf(context.build());
    if (id <= 0) throw new RuntimeException("Failed to created widget Brightness?");
    System.out.println("New Brightness? id:"+id);
    return Brightness.values()[id];
  }
  public ThemeData data() {
    return new ThemeData(ThemeObjSt.data(st));
  }
  public Widget child() {
    return new Widget(ThemeObjSt.child(st)) {};
  }
  @Override
  public Theme build() {
    return this;
  }
}
