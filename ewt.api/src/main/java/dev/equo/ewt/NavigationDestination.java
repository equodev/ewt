package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.NavigationDestinationObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class NavigationDestination extends StatelessWidget implements NavigationDestinationI {
  private MemorySegment st;
  protected NavigationDestination() {}
  NavigationDestination(MemorySegment st) {
    this.id = NavigationDestinationObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget NavigationDestination");
    System.out.println("New NavigationDestination id:"+id);
  }
  NavigationDestination(int id) { this.id = id; }
  @Builder.Factory
  static NavigationDestination navigationDestinationNavigationDestination(@Builder.Parameter WidgetI icon, Optional<WidgetI> selectedIcon, String label, Optional<String> tooltip, Optional<Boolean> enabled) {
    var st = factories.navigationDestinationNavigationDestination(icon.build(),
      selectedIcon.map(WidgetI::build),
      label,
      tooltip,
      enabled);
    if (st == null) throw new RuntimeException("Failed to created widget NavigationDestination");
    return new NavigationDestination(st);
  }
  public static NavigationDestinationNavigationDestinationBuilder navigationDestination(WidgetI icon) {
    return NavigationDestinationNavigationDestinationBuilder.navigationDestinationNavigationDestination(icon);
  }
  public Widget icon() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("navigationDestinationIcon not supported on web");
    return new Widget(NavigationDestinationObjSt.icon(st)) {};
  }
  public Widget selectedIcon() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("navigationDestinationSelectedIcon not supported on web");
    return new Widget(NavigationDestinationObjSt.selectedIcon(st)) {};
  }
  public String label() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("navigationDestinationLabel not supported on web");
    return NavigationDestinationObjSt.label(st).getString(0);
  }
  public String tooltip() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("navigationDestinationTooltip not supported on web");
    return NavigationDestinationObjSt.tooltip(st).getString(0);
  }
  public boolean enabled() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("navigationDestinationEnabled not supported on web");
    return intToBool(NavigationDestinationObjSt.enabled(st));
  }
  @Override
  public NavigationDestination build() {
    return this;
  }
}
