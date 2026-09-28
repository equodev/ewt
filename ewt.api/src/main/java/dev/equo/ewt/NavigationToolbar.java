package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class NavigationToolbar extends StatelessWidget implements NavigationToolbarI {
  protected NavigationToolbar() {}
  NavigationToolbar(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget NavigationToolbar");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static NavigationToolbar navigationToolbarNavigationToolbar(Optional<WidgetI> leading, Optional<WidgetI> middle, Optional<WidgetI> trailing, Optional<Boolean> centerMiddle, OptionalDouble middleSpacing) {
    int id = factories.navigationToolbarNavigationToolbar(leading.map(WidgetI::build),
      middle.map(WidgetI::build),
      trailing.map(WidgetI::build),
      centerMiddle,
      middleSpacing);
    if (id <= 0) throw new RuntimeException("Failed to created widget NavigationToolbar");
    return new NavigationToolbar(id);
  }
  public static NavigationToolbarNavigationToolbarBuilder navigationToolbar() {
    return NavigationToolbarNavigationToolbarBuilder.navigationToolbarNavigationToolbar();
  }
  public Widget leading() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("navigationToolbarLeading not supported on web");
    return factories.NavigationToolbar_readBack_leading(nativeStruct);
  }
  public Widget middle() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("navigationToolbarMiddle not supported on web");
    return factories.NavigationToolbar_readBack_middle(nativeStruct);
  }
  public Widget trailing() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("navigationToolbarTrailing not supported on web");
    return factories.NavigationToolbar_readBack_trailing(nativeStruct);
  }
  public boolean centerMiddle() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("navigationToolbarCenterMiddle not supported on web");
    return factories.NavigationToolbar_readBack_centerMiddle(nativeStruct);
  }
  public double middleSpacing() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("navigationToolbarMiddleSpacing not supported on web");
    return factories.NavigationToolbar_readBack_middleSpacing(nativeStruct);
  }
  public static double kMiddleSpacing() {
    return 16.0;
  }
  @Override
  public NavigationToolbar build() {
    return this;
  }
}
