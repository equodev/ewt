package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class CupertinoNavigationBar extends StatefulWidget implements ObstructingPreferredSizeWidget, CupertinoNavigationBarI {
  protected CupertinoNavigationBar() {}
  CupertinoNavigationBar(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget CupertinoNavigationBar");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static CupertinoNavigationBar cupertinoNavigationBarCupertinoNavigationBar(Optional<WidgetI> leading, Optional<Boolean> automaticallyImplyLeading, Optional<Boolean> automaticallyImplyMiddle, Optional<String> previousPageTitle, Optional<WidgetI> middle, Optional<WidgetI> trailing, Optional<BorderI> border, Optional<ColorI> backgroundColor, Optional<Boolean> automaticBackgroundVisibility, Optional<Boolean> enableBackgroundFilterBlur, Optional<Brightness> brightness, Optional<Boolean> transitionBetweenRoutes, Optional<PreferredSizeWidgetI> bottom) {
    int id = factories.cupertinoNavigationBarCupertinoNavigationBar(leading.map(WidgetI::build),
      automaticallyImplyLeading,
      automaticallyImplyMiddle,
      previousPageTitle,
      middle.map(WidgetI::build),
      trailing.map(WidgetI::build),
      border.map(BorderI::build),
      backgroundColor.map(ColorI::build),
      automaticBackgroundVisibility,
      enableBackgroundFilterBlur,
      brightness,
      transitionBetweenRoutes,
      bottom.map(PreferredSizeWidgetI::build));
    if (id <= 0) throw new RuntimeException("Failed to created widget CupertinoNavigationBar");
    return new CupertinoNavigationBar(id);
  }
  public static CupertinoNavigationBarCupertinoNavigationBarBuilder cupertinoNavigationBar() {
    return CupertinoNavigationBarCupertinoNavigationBarBuilder.cupertinoNavigationBarCupertinoNavigationBar();
  }
  @Builder.Factory
  static CupertinoNavigationBar cupertinoNavigationBarLarge(Optional<WidgetI> largeTitle, Optional<WidgetI> leading, Optional<Boolean> automaticallyImplyLeading, Optional<Boolean> automaticallyImplyTitle, Optional<String> previousPageTitle, Optional<WidgetI> trailing, Optional<BorderI> border, Optional<ColorI> backgroundColor, Optional<Boolean> automaticBackgroundVisibility, Optional<Boolean> enableBackgroundFilterBlur, Optional<Brightness> brightness, Optional<Boolean> transitionBetweenRoutes, Optional<PreferredSizeWidgetI> bottom) {
    int id = factories.cupertinoNavigationBarLarge(largeTitle.map(WidgetI::build),
      leading.map(WidgetI::build),
      automaticallyImplyLeading,
      automaticallyImplyTitle,
      previousPageTitle,
      trailing.map(WidgetI::build),
      border.map(BorderI::build),
      backgroundColor.map(ColorI::build),
      automaticBackgroundVisibility,
      enableBackgroundFilterBlur,
      brightness,
      transitionBetweenRoutes,
      bottom.map(PreferredSizeWidgetI::build));
    if (id <= 0) throw new RuntimeException("Failed to created widget CupertinoNavigationBar");
    return new CupertinoNavigationBar(id);
  }
  public static CupertinoNavigationBarLargeBuilder large() {
    return CupertinoNavigationBarLargeBuilder.cupertinoNavigationBarLarge();
  }
  public Widget largeTitle() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoNavigationBarLargeTitle not supported on web");
    return factories.CupertinoNavigationBar_readBack_largeTitle(nativeStruct);
  }
  public Widget leading() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoNavigationBarLeading not supported on web");
    return factories.CupertinoNavigationBar_readBack_leading(nativeStruct);
  }
  public boolean automaticallyImplyLeading() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoNavigationBarAutomaticallyImplyLeading not supported on web");
    return factories.CupertinoNavigationBar_readBack_automaticallyImplyLeading(nativeStruct);
  }
  public boolean automaticallyImplyMiddle() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoNavigationBarAutomaticallyImplyMiddle not supported on web");
    return factories.CupertinoNavigationBar_readBack_automaticallyImplyMiddle(nativeStruct);
  }
  public String previousPageTitle() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoNavigationBarPreviousPageTitle not supported on web");
    return factories.CupertinoNavigationBar_readBack_previousPageTitle(nativeStruct);
  }
  public Widget middle() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoNavigationBarMiddle not supported on web");
    return factories.CupertinoNavigationBar_readBack_middle(nativeStruct);
  }
  public Widget trailing() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoNavigationBarTrailing not supported on web");
    return factories.CupertinoNavigationBar_readBack_trailing(nativeStruct);
  }
  public Color backgroundColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("cupertinoNavigationBarBackgroundColor", getId());
      return new Color(__nid);
    }
    return factories.CupertinoNavigationBar_readBack_backgroundColor(nativeStruct);
  }
  public boolean automaticBackgroundVisibility() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoNavigationBarAutomaticBackgroundVisibility not supported on web");
    return factories.CupertinoNavigationBar_readBack_automaticBackgroundVisibility(nativeStruct);
  }
  public Brightness brightness() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoNavigationBarBrightness not supported on web");
    return factories.CupertinoNavigationBar_readBack_brightness(nativeStruct);
  }
  public Border border() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("cupertinoNavigationBarBorder", getId());
      return new Border(__nid);
    }
    return factories.CupertinoNavigationBar_readBack_border(nativeStruct);
  }
  public boolean transitionBetweenRoutes() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoNavigationBarTransitionBetweenRoutes not supported on web");
    return factories.CupertinoNavigationBar_readBack_transitionBetweenRoutes(nativeStruct);
  }
  public boolean enableBackgroundFilterBlur() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoNavigationBarEnableBackgroundFilterBlur not supported on web");
    return factories.CupertinoNavigationBar_readBack_enableBackgroundFilterBlur(nativeStruct);
  }
  public PreferredSizeWidget bottom() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoNavigationBarBottom not supported on web");
    return factories.CupertinoNavigationBar_readBack_bottom(nativeStruct);
  }
  @Override
  public CupertinoNavigationBar build() {
    return this;
  }
}
