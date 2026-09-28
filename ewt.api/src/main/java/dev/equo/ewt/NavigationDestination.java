package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class NavigationDestination extends StatelessWidget implements NavigationDestinationI {
  protected NavigationDestination() {}
  NavigationDestination(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget NavigationDestination");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static NavigationDestination navigationDestinationNavigationDestination(@Builder.Parameter WidgetI icon, Optional<WidgetI> selectedIcon, String label, Optional<String> tooltip, Optional<Boolean> enabled) {
    int id = factories.navigationDestinationNavigationDestination(icon.build(),
      selectedIcon.map(WidgetI::build),
      label,
      tooltip,
      enabled);
    if (id <= 0) throw new RuntimeException("Failed to created widget NavigationDestination");
    return new NavigationDestination(id);
  }
  public static NavigationDestinationNavigationDestinationBuilder navigationDestination(WidgetI icon) {
    return NavigationDestinationNavigationDestinationBuilder.navigationDestinationNavigationDestination(icon);
  }
  public Widget icon() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("navigationDestinationIcon not supported on web");
    return factories.NavigationDestination_readBack_icon(nativeStruct);
  }
  public Widget selectedIcon() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("navigationDestinationSelectedIcon not supported on web");
    return factories.NavigationDestination_readBack_selectedIcon(nativeStruct);
  }
  public String label() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("navigationDestinationLabel not supported on web");
    return factories.NavigationDestination_readBack_label(nativeStruct);
  }
  public String tooltip() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("navigationDestinationTooltip not supported on web");
    return factories.NavigationDestination_readBack_tooltip(nativeStruct);
  }
  public boolean enabled() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("navigationDestinationEnabled not supported on web");
    return factories.NavigationDestination_readBack_enabled(nativeStruct);
  }
  @Override
  public NavigationDestination build() {
    return this;
  }
}
