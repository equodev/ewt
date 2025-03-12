package dev.equo.ewt;
import java.util.*;
import org.immutables.builder.Builder;
public class AppBar extends StatefulWidget implements PreferredSizeWidget {
  static final WidgetConstructors factories = WidgetConstructors.instance;
  AppBar() {}
  @Builder.Constructor
  AppBar(Optional<Widget> leading, Optional<Boolean> automaticallyImplyLeading, Optional<Widget> title, Optional<List<Widget>> actions, Optional<Widget> flexibleSpace, Optional<PreferredSizeWidget> bottom, OptionalDouble elevation, OptionalDouble scrolledUnderElevation, Optional<Boolean> primary, Optional<Boolean> centerTitle, Optional<Boolean> excludeHeaderSemantics, OptionalDouble titleSpacing, OptionalDouble toolbarOpacity, OptionalDouble bottomOpacity, OptionalDouble toolbarHeight, OptionalDouble leadingWidth, Optional<Boolean> forceMaterialTransparency, Optional<Clip> clipBehavior) {
    id = factories.appBarAppBar(leading, automaticallyImplyLeading, title, actions, flexibleSpace, bottom, elevation, scrolledUnderElevation, primary, centerTitle, excludeHeaderSemantics, titleSpacing, toolbarOpacity, bottomOpacity, toolbarHeight, leadingWidth, forceMaterialTransparency, clipBehavior);
    if (id == -1) throw new RuntimeException("Failed to created widget "+this);
    System.out.println("New "+this+" id:"+id);
  }
  public static AppBarBuilder appBar() {
    return AppBarBuilder.AppBar();
  }
}
