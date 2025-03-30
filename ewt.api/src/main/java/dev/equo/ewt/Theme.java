package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import org.immutables.builder.Builder;
public class Theme extends StatelessWidget implements ThemeI {
  @Override
  public Theme build() {
    return this;
  }
  Theme() {}
  Theme(int id) {
    this.id = id;
  }
  @Builder.Factory
  static Theme themeTheme(@Builder.Parameter ThemeDataI data, @Builder.Parameter WidgetI child) {
    int id = factories.themeTheme(data.build(),
      child.build());
    if (id == -1) throw new RuntimeException("Failed to created widget Theme");
    System.out.println("New Theme id:"+id);
    return new Theme(id);
  }
  public static ThemeThemeBuilder theme(ThemeDataI data, WidgetI child) {
    return ThemeThemeBuilder.themeTheme(data, child);
  }
  public static ThemeData of(BuildContextI context) {
    var st = factories.themeOf(context.build());
    if (st == null) throw new RuntimeException("Failed to created widget ThemeData");
    return new ThemeData(st);
  }
}
