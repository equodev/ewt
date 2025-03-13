package dev.equo.ewt;
import java.util.*;
import org.immutables.builder.Builder;
public class AppBar extends StatefulWidget implements PreferredSizeWidget {
  static final WidgetConstructors factories = WidgetConstructors.instance;
  AppBar() {}
  AppBar(int id) {
    this.id = id;
  }
  @Builder.Factory
  static AppBar appBarAppBar(Optional<Widget> leading, Optional<Boolean> automaticallyImplyLeading, Optional<Widget> title, Optional<List<Widget>> actions, Optional<Widget> flexibleSpace, Optional<PreferredSizeWidget> bottom, OptionalDouble elevation, OptionalDouble scrolledUnderElevation, Optional<Color> shadowColor, Optional<Color> surfaceTintColor, Optional<Color> backgroundColor, Optional<Color> foregroundColor, Optional<Boolean> primary, Optional<Boolean> centerTitle, Optional<Boolean> excludeHeaderSemantics, OptionalDouble titleSpacing, OptionalDouble toolbarOpacity, OptionalDouble bottomOpacity, OptionalDouble toolbarHeight, OptionalDouble leadingWidth, Optional<Boolean> forceMaterialTransparency, Optional<Clip> clipBehavior) {
    int id = factories.appBarAppBar(leading,
      automaticallyImplyLeading,
      title,
      actions,
      flexibleSpace,
      bottom,
      elevation,
      scrolledUnderElevation,
      shadowColor,
      surfaceTintColor,
      backgroundColor,
      foregroundColor,
      primary,
      centerTitle,
      excludeHeaderSemantics,
      titleSpacing,
      toolbarOpacity,
      bottomOpacity,
      toolbarHeight,
      leadingWidth,
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
