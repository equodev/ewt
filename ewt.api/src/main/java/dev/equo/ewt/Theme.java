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
  @Builder.Factory
  static Theme themeOf(@Builder.Parameter BuildContext context) {
    int id = factories.themeOf(context);
    if (id == -1) throw new RuntimeException("Failed to created widget Theme");
    System.out.println("New Theme id:"+id);
    return new Theme(id);
  }
  public static ThemeOfBuilder of(BuildContext context) {
    return ThemeOfBuilder.themeOf(context);
  }
}
