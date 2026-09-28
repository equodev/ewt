package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class NavigationDrawerDestination extends StatelessWidget implements NavigationDrawerDestinationI {
  protected NavigationDrawerDestination() {}
  NavigationDrawerDestination(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget NavigationDrawerDestination");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static NavigationDrawerDestination navigationDrawerDestinationNavigationDrawerDestination(Optional<ColorI> backgroundColor, WidgetI icon, Optional<WidgetI> selectedIcon, WidgetI label, Optional<Boolean> enabled) {
    int id = factories.navigationDrawerDestinationNavigationDrawerDestination(backgroundColor.map(ColorI::build),
      icon.build(),
      selectedIcon.map(WidgetI::build),
      label.build(),
      enabled);
    if (id <= 0) throw new RuntimeException("Failed to created widget NavigationDrawerDestination");
    return new NavigationDrawerDestination(id);
  }
  public static NavigationDrawerDestinationNavigationDrawerDestinationBuilder navigationDrawerDestination() {
    return NavigationDrawerDestinationNavigationDrawerDestinationBuilder.navigationDrawerDestinationNavigationDrawerDestination();
  }
  public Color backgroundColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("navigationDrawerDestinationBackgroundColor", getId());
      return new Color(__nid);
    }
    return factories.NavigationDrawerDestination_readBack_backgroundColor(nativeStruct);
  }
  public Widget icon() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("navigationDrawerDestinationIcon not supported on web");
    return factories.NavigationDrawerDestination_readBack_icon(nativeStruct);
  }
  public Widget selectedIcon() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("navigationDrawerDestinationSelectedIcon not supported on web");
    return factories.NavigationDrawerDestination_readBack_selectedIcon(nativeStruct);
  }
  public Widget label() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("navigationDrawerDestinationLabel not supported on web");
    return factories.NavigationDrawerDestination_readBack_label(nativeStruct);
  }
  public boolean enabled() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("navigationDrawerDestinationEnabled not supported on web");
    return factories.NavigationDrawerDestination_readBack_enabled(nativeStruct);
  }
  @Override
  public NavigationDrawerDestination build() {
    return this;
  }
}
