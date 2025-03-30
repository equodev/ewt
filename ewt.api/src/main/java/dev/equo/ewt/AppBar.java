package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import org.immutables.builder.Builder;
public class AppBar extends StatefulWidget implements PreferredSizeWidget, AppBarI {
  @Override
  public AppBar build() {
    return this;
  }
  AppBar() {}
  AppBar(int id) {
    this.id = id;
  }
  @Builder.Factory
  static AppBar appBarAppBar(Optional<WidgetI> leading, Optional<Boolean> automaticallyImplyLeading, Optional<WidgetI> title, Optional<List<WidgetI>> actions, Optional<WidgetI> flexibleSpace, Optional<PreferredSizeWidgetI> bottom, OptionalDouble elevation, OptionalDouble scrolledUnderElevation, Optional<ColorI> shadowColor, Optional<ColorI> surfaceTintColor, Optional<ColorI> backgroundColor, Optional<ColorI> foregroundColor, Optional<Boolean> primary, Optional<Boolean> centerTitle, Optional<Boolean> excludeHeaderSemantics, OptionalDouble titleSpacing, OptionalDouble toolbarOpacity, OptionalDouble bottomOpacity, OptionalDouble toolbarHeight, OptionalDouble leadingWidth, Optional<TextStyleI> toolbarTextStyle, Optional<TextStyleI> titleTextStyle, Optional<Boolean> forceMaterialTransparency, Optional<Clip> clipBehavior) {
    int id = factories.appBarAppBar(leading.map(WidgetI::build),
      automaticallyImplyLeading,
      title.map(WidgetI::build),
      actions.map(i -> i.stream().map(WidgetI::build).toList()),
      flexibleSpace.map(WidgetI::build),
      bottom.map(PreferredSizeWidgetI::build),
      elevation,
      scrolledUnderElevation,
      shadowColor.map(ColorI::build),
      surfaceTintColor.map(ColorI::build),
      backgroundColor.map(ColorI::build),
      foregroundColor.map(ColorI::build),
      primary,
      centerTitle,
      excludeHeaderSemantics,
      titleSpacing,
      toolbarOpacity,
      bottomOpacity,
      toolbarHeight,
      leadingWidth,
      toolbarTextStyle.map(TextStyleI::build),
      titleTextStyle.map(TextStyleI::build),
      forceMaterialTransparency,
      clipBehavior);
    if (id == -1) throw new RuntimeException("Failed to created widget AppBar");
    System.out.println("New AppBar id:"+id);
    return new AppBar(id);
  }
  public static AppBarAppBarBuilder appBar() {
    return AppBarAppBarBuilder.appBarAppBar();
  }
}
