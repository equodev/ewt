package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.NavigationDrawerDestinationObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class NavigationDrawerDestination extends StatelessWidget implements NavigationDrawerDestinationI {
  private MemorySegment st;
  protected NavigationDrawerDestination() {}
  NavigationDrawerDestination(MemorySegment st) {
    this.id = NavigationDrawerDestinationObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget NavigationDrawerDestination");
    System.out.println("New NavigationDrawerDestination id:"+id);
  }
  NavigationDrawerDestination(int id) { this.id = id; }
  @Builder.Factory
  static NavigationDrawerDestination navigationDrawerDestinationNavigationDrawerDestination(Optional<ColorI> backgroundColor, WidgetI icon, Optional<WidgetI> selectedIcon, WidgetI label, Optional<Boolean> enabled) {
    var st = factories.navigationDrawerDestinationNavigationDrawerDestination(backgroundColor.map(ColorI::build),
      icon.build(),
      selectedIcon.map(WidgetI::build),
      label.build(),
      enabled);
    if (st == null) throw new RuntimeException("Failed to created widget NavigationDrawerDestination");
    return new NavigationDrawerDestination(st);
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
    return new Color(NavigationDrawerDestinationObjSt.backgroundColor(st));
  }
  public Widget icon() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("navigationDrawerDestinationIcon not supported on web");
    return new Widget(NavigationDrawerDestinationObjSt.icon(st)) {};
  }
  public Widget selectedIcon() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("navigationDrawerDestinationSelectedIcon not supported on web");
    return new Widget(NavigationDrawerDestinationObjSt.selectedIcon(st)) {};
  }
  public Widget label() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("navigationDrawerDestinationLabel not supported on web");
    return new Widget(NavigationDrawerDestinationObjSt.label(st)) {};
  }
  public boolean enabled() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("navigationDrawerDestinationEnabled not supported on web");
    return intToBool(NavigationDrawerDestinationObjSt.enabled(st));
  }
  @Override
  public NavigationDrawerDestination build() {
    return this;
  }
}
