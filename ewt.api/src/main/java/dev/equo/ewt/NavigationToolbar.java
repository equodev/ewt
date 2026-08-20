package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.NavigationToolbarObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class NavigationToolbar extends StatelessWidget implements NavigationToolbarI {
  private MemorySegment st;
  protected NavigationToolbar() {}
  NavigationToolbar(MemorySegment st) {
    this.id = NavigationToolbarObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget NavigationToolbar");
    System.out.println("New NavigationToolbar id:"+id);
  }
  NavigationToolbar(int id) { this.id = id; }
  @Builder.Factory
  static NavigationToolbar navigationToolbarNavigationToolbar(Optional<WidgetI> leading, Optional<WidgetI> middle, Optional<WidgetI> trailing, Optional<Boolean> centerMiddle, OptionalDouble middleSpacing) {
    var st = factories.navigationToolbarNavigationToolbar(leading.map(WidgetI::build),
      middle.map(WidgetI::build),
      trailing.map(WidgetI::build),
      centerMiddle,
      middleSpacing);
    if (st == null) throw new RuntimeException("Failed to created widget NavigationToolbar");
    return new NavigationToolbar(st);
  }
  public static NavigationToolbarNavigationToolbarBuilder navigationToolbar() {
    return NavigationToolbarNavigationToolbarBuilder.navigationToolbarNavigationToolbar();
  }
  public Widget leading() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("navigationToolbarLeading not supported on web");
    return new Widget(NavigationToolbarObjSt.leading(st)) {};
  }
  public Widget middle() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("navigationToolbarMiddle not supported on web");
    return new Widget(NavigationToolbarObjSt.middle(st)) {};
  }
  public Widget trailing() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("navigationToolbarTrailing not supported on web");
    return new Widget(NavigationToolbarObjSt.trailing(st)) {};
  }
  public boolean centerMiddle() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("navigationToolbarCenterMiddle not supported on web");
    return intToBool(NavigationToolbarObjSt.centerMiddle(st));
  }
  public double middleSpacing() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("navigationToolbarMiddleSpacing not supported on web");
    return NavigationToolbarObjSt.middleSpacing(st);
  }
  public static double kMiddleSpacing() {
    return 16.0;
  }
  @Override
  public NavigationToolbar build() {
    return this;
  }
}
