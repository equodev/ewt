package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import org.immutables.builder.Builder;
public class Theme extends StatelessWidget {
  Theme() {}
  Theme(int id) {
    this.id = id;
  }
  @Builder.Factory
  static Theme themeTheme(@Builder.Parameter ThemeData data, @Builder.Parameter Widget child) {
    int id = factories.themeTheme(data,
      child);
    if (id == -1) throw new RuntimeException("Failed to created widget Theme");
    System.out.println("New Theme id:"+id);
    return new Theme(id);
  }
  public static ThemeThemeBuilder theme(ThemeData data, Widget child) {
    return ThemeThemeBuilder.themeTheme(data, child);
  }
  public static ThemeData of(BuildContext context) {
    var st = factories.themeOf(context);
    if (st == null) throw new RuntimeException("Failed to created widget ThemeData");
    return new ThemeData(st);
  }
}
