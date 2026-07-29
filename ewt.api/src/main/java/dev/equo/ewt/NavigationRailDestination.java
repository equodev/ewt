package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class NavigationRailDestination extends NativeObj.Base implements NavigationRailDestinationI {
  protected NavigationRailDestination() {}
  NavigationRailDestination(int id) {
    this.id = id;
  }
  public static NavigationRailDestination byId(int id) { return new NavigationRailDestination(id); }
  @Builder.Factory
  static NavigationRailDestination navigationRailDestinationNavigationRailDestination(@Builder.Parameter WidgetI icon, Optional<WidgetI> selectedIcon, Optional<ColorI> indicatorColor, Optional<ShapeBorderI> indicatorShape, WidgetI label, Optional<EdgeInsetsGeometryI> padding, Optional<Boolean> disabled) {
    int id = factories.navigationRailDestinationNavigationRailDestination(icon.build(),
      selectedIcon.map(WidgetI::build),
      indicatorColor.map(ColorI::build),
      indicatorShape.map(ShapeBorderI::build),
      label.build(),
      padding.map(EdgeInsetsGeometryI::build),
      disabled);
    if (id <= 0) throw new RuntimeException("Failed to created widget NavigationRailDestination");
    System.out.println("New NavigationRailDestination id:"+id);
    return new NavigationRailDestination(id);
  }
  public static NavigationRailDestinationNavigationRailDestinationBuilder navigationRailDestination(WidgetI icon) {
    return NavigationRailDestinationNavigationRailDestinationBuilder.navigationRailDestinationNavigationRailDestination(icon);
  }
  @Override
  public NavigationRailDestination build() {
    return this;
  }
}
