package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class BottomNavigationBarItem extends NativeObj.Base implements BottomNavigationBarItemI {
  protected BottomNavigationBarItem() {}
  BottomNavigationBarItem(int id) {
    this.id = id;
  }
  public static BottomNavigationBarItem byId(int id) { return new BottomNavigationBarItem(id); }
  @Builder.Factory
  static BottomNavigationBarItem bottomNavigationBarItemBottomNavigationBarItem(@Builder.Parameter WidgetI icon, Optional<String> label, Optional<WidgetI> activeIcon, Optional<ColorI> backgroundColor, Optional<String> tooltip) {
    int id = factories.bottomNavigationBarItemBottomNavigationBarItem(icon.build(),
      label,
      activeIcon.map(WidgetI::build),
      backgroundColor.map(ColorI::build),
      tooltip);
    if (id <= 0) throw new RuntimeException("Failed to created widget BottomNavigationBarItem");
    System.out.println("New BottomNavigationBarItem id:"+id);
    return new BottomNavigationBarItem(id);
  }
  public static BottomNavigationBarItemBottomNavigationBarItemBuilder bottomNavigationBarItem(WidgetI icon) {
    return BottomNavigationBarItemBottomNavigationBarItemBuilder.bottomNavigationBarItemBottomNavigationBarItem(icon);
  }
  @Override
  public BottomNavigationBarItem build() {
    return this;
  }
}
