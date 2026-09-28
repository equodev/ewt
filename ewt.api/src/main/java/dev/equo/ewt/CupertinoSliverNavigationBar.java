package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class CupertinoSliverNavigationBar extends StatefulWidget implements CupertinoSliverNavigationBarI {
  protected CupertinoSliverNavigationBar() {}
  CupertinoSliverNavigationBar(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget CupertinoSliverNavigationBar");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static CupertinoSliverNavigationBar cupertinoSliverNavigationBarCupertinoSliverNavigationBar(Optional<WidgetI> largeTitle, Optional<WidgetI> leading, Optional<Boolean> automaticallyImplyLeading, Optional<Boolean> automaticallyImplyTitle, Optional<Boolean> alwaysShowMiddle, Optional<String> previousPageTitle, Optional<WidgetI> middle, Optional<WidgetI> trailing, Optional<BorderI> border, Optional<ColorI> backgroundColor, Optional<Boolean> automaticBackgroundVisibility, Optional<Boolean> enableBackgroundFilterBlur, Optional<Brightness> brightness, Optional<Boolean> transitionBetweenRoutes, Optional<Boolean> stretch, Optional<PreferredSizeWidgetI> bottom, Optional<NavigationBarBottomMode> bottomMode) {
    int id = factories.cupertinoSliverNavigationBarCupertinoSliverNavigationBar(largeTitle.map(WidgetI::build),
      leading.map(WidgetI::build),
      automaticallyImplyLeading,
      automaticallyImplyTitle,
      alwaysShowMiddle,
      previousPageTitle,
      middle.map(WidgetI::build),
      trailing.map(WidgetI::build),
      border.map(BorderI::build),
      backgroundColor.map(ColorI::build),
      automaticBackgroundVisibility,
      enableBackgroundFilterBlur,
      brightness,
      transitionBetweenRoutes,
      stretch,
      bottom.map(PreferredSizeWidgetI::build),
      bottomMode);
    if (id <= 0) throw new RuntimeException("Failed to created widget CupertinoSliverNavigationBar");
    return new CupertinoSliverNavigationBar(id);
  }
  public static CupertinoSliverNavigationBarCupertinoSliverNavigationBarBuilder cupertinoSliverNavigationBar() {
    return CupertinoSliverNavigationBarCupertinoSliverNavigationBarBuilder.cupertinoSliverNavigationBarCupertinoSliverNavigationBar();
  }
  @Builder.Factory
  static CupertinoSliverNavigationBar cupertinoSliverNavigationBarSearch(@Builder.Parameter WidgetI searchField, Optional<WidgetI> largeTitle, Optional<WidgetI> leading, Optional<Boolean> automaticallyImplyLeading, Optional<Boolean> automaticallyImplyTitle, Optional<Boolean> alwaysShowMiddle, Optional<String> previousPageTitle, Optional<WidgetI> middle, Optional<WidgetI> trailing, Optional<BorderI> border, Optional<ColorI> backgroundColor, Optional<Boolean> automaticBackgroundVisibility, Optional<Boolean> enableBackgroundFilterBlur, Optional<Brightness> brightness, Optional<Boolean> transitionBetweenRoutes, Optional<Boolean> stretch, Optional<NavigationBarBottomMode> bottomMode, Optional<Consumer<Boolean>> onSearchableBottomTap) {
    int id = factories.cupertinoSliverNavigationBarSearch(searchField.build(),
      largeTitle.map(WidgetI::build),
      leading.map(WidgetI::build),
      automaticallyImplyLeading,
      automaticallyImplyTitle,
      alwaysShowMiddle,
      previousPageTitle,
      middle.map(WidgetI::build),
      trailing.map(WidgetI::build),
      border.map(BorderI::build),
      backgroundColor.map(ColorI::build),
      automaticBackgroundVisibility,
      enableBackgroundFilterBlur,
      brightness,
      transitionBetweenRoutes,
      stretch,
      bottomMode,
      onSearchableBottomTap);
    if (id <= 0) throw new RuntimeException("Failed to created widget CupertinoSliverNavigationBar");
    return new CupertinoSliverNavigationBar(id);
  }
  public static CupertinoSliverNavigationBarSearchBuilder search(WidgetI searchField) {
    return CupertinoSliverNavigationBarSearchBuilder.cupertinoSliverNavigationBarSearch(searchField);
  }
  public Widget largeTitle() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoSliverNavigationBarLargeTitle not supported on web");
    return factories.CupertinoSliverNavigationBar_readBack_largeTitle(nativeStruct);
  }
  public Widget leading() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoSliverNavigationBarLeading not supported on web");
    return factories.CupertinoSliverNavigationBar_readBack_leading(nativeStruct);
  }
  public boolean automaticallyImplyLeading() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoSliverNavigationBarAutomaticallyImplyLeading not supported on web");
    return factories.CupertinoSliverNavigationBar_readBack_automaticallyImplyLeading(nativeStruct);
  }
  public boolean automaticallyImplyTitle() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoSliverNavigationBarAutomaticallyImplyTitle not supported on web");
    return factories.CupertinoSliverNavigationBar_readBack_automaticallyImplyTitle(nativeStruct);
  }
  public boolean alwaysShowMiddle() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoSliverNavigationBarAlwaysShowMiddle not supported on web");
    return factories.CupertinoSliverNavigationBar_readBack_alwaysShowMiddle(nativeStruct);
  }
  public String previousPageTitle() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoSliverNavigationBarPreviousPageTitle not supported on web");
    return factories.CupertinoSliverNavigationBar_readBack_previousPageTitle(nativeStruct);
  }
  public Widget middle() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoSliverNavigationBarMiddle not supported on web");
    return factories.CupertinoSliverNavigationBar_readBack_middle(nativeStruct);
  }
  public Widget trailing() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoSliverNavigationBarTrailing not supported on web");
    return factories.CupertinoSliverNavigationBar_readBack_trailing(nativeStruct);
  }
  public Color backgroundColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("cupertinoSliverNavigationBarBackgroundColor", getId());
      return new Color(__nid);
    }
    return factories.CupertinoSliverNavigationBar_readBack_backgroundColor(nativeStruct);
  }
  public boolean automaticBackgroundVisibility() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoSliverNavigationBarAutomaticBackgroundVisibility not supported on web");
    return factories.CupertinoSliverNavigationBar_readBack_automaticBackgroundVisibility(nativeStruct);
  }
  public boolean enableBackgroundFilterBlur() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoSliverNavigationBarEnableBackgroundFilterBlur not supported on web");
    return factories.CupertinoSliverNavigationBar_readBack_enableBackgroundFilterBlur(nativeStruct);
  }
  public Brightness brightness() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoSliverNavigationBarBrightness not supported on web");
    return factories.CupertinoSliverNavigationBar_readBack_brightness(nativeStruct);
  }
  public Border border() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("cupertinoSliverNavigationBarBorder", getId());
      return new Border(__nid);
    }
    return factories.CupertinoSliverNavigationBar_readBack_border(nativeStruct);
  }
  public boolean transitionBetweenRoutes() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoSliverNavigationBarTransitionBetweenRoutes not supported on web");
    return factories.CupertinoSliverNavigationBar_readBack_transitionBetweenRoutes(nativeStruct);
  }
  public PreferredSizeWidget bottom() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoSliverNavigationBarBottom not supported on web");
    return factories.CupertinoSliverNavigationBar_readBack_bottom(nativeStruct);
  }
  public NavigationBarBottomMode bottomMode() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoSliverNavigationBarBottomMode not supported on web");
    return factories.CupertinoSliverNavigationBar_readBack_bottomMode(nativeStruct);
  }
  public boolean stretch() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoSliverNavigationBarStretch not supported on web");
    return factories.CupertinoSliverNavigationBar_readBack_stretch(nativeStruct);
  }
  public Widget searchField() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoSliverNavigationBarSearchField not supported on web");
    return factories.CupertinoSliverNavigationBar_readBack_searchField(nativeStruct);
  }
  public boolean opaque() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoSliverNavigationBarOpaque not supported on web");
    return factories.CupertinoSliverNavigationBar_readBack_opaque(nativeStruct);
  }
  @Override
  public CupertinoSliverNavigationBar build() {
    return this;
  }
}
