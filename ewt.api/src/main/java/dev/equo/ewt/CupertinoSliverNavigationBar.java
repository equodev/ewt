package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.CupertinoSliverNavigationBarObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class CupertinoSliverNavigationBar extends StatefulWidget implements CupertinoSliverNavigationBarI {
  private MemorySegment st;
  protected CupertinoSliverNavigationBar() {}
  CupertinoSliverNavigationBar(MemorySegment st) {
    this.id = CupertinoSliverNavigationBarObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget CupertinoSliverNavigationBar");
    System.out.println("New CupertinoSliverNavigationBar id:"+id);
  }
  CupertinoSliverNavigationBar(int id) { this.id = id; }
  @Builder.Factory
  static CupertinoSliverNavigationBar cupertinoSliverNavigationBarCupertinoSliverNavigationBar(Optional<WidgetI> largeTitle, Optional<WidgetI> leading, Optional<Boolean> automaticallyImplyLeading, Optional<Boolean> automaticallyImplyTitle, Optional<Boolean> alwaysShowMiddle, Optional<String> previousPageTitle, Optional<WidgetI> middle, Optional<WidgetI> trailing, Optional<BorderI> border, Optional<ColorI> backgroundColor, Optional<Boolean> automaticBackgroundVisibility, Optional<Boolean> enableBackgroundFilterBlur, Optional<Brightness> brightness, Optional<Boolean> transitionBetweenRoutes, Optional<Boolean> stretch, Optional<PreferredSizeWidgetI> bottom, Optional<NavigationBarBottomMode> bottomMode) {
    var st = factories.cupertinoSliverNavigationBarCupertinoSliverNavigationBar(largeTitle.map(WidgetI::build),
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
    if (st == null) throw new RuntimeException("Failed to created widget CupertinoSliverNavigationBar");
    return new CupertinoSliverNavigationBar(st);
  }
  public static CupertinoSliverNavigationBarCupertinoSliverNavigationBarBuilder cupertinoSliverNavigationBar() {
    return CupertinoSliverNavigationBarCupertinoSliverNavigationBarBuilder.cupertinoSliverNavigationBarCupertinoSliverNavigationBar();
  }
  @Builder.Factory
  static CupertinoSliverNavigationBar cupertinoSliverNavigationBarSearch(@Builder.Parameter WidgetI searchField, Optional<WidgetI> largeTitle, Optional<WidgetI> leading, Optional<Boolean> automaticallyImplyLeading, Optional<Boolean> automaticallyImplyTitle, Optional<Boolean> alwaysShowMiddle, Optional<String> previousPageTitle, Optional<WidgetI> middle, Optional<WidgetI> trailing, Optional<BorderI> border, Optional<ColorI> backgroundColor, Optional<Boolean> automaticBackgroundVisibility, Optional<Boolean> enableBackgroundFilterBlur, Optional<Brightness> brightness, Optional<Boolean> transitionBetweenRoutes, Optional<Boolean> stretch, Optional<NavigationBarBottomMode> bottomMode, Optional<Consumer<Boolean>> onSearchableBottomTap) {
    var st = factories.cupertinoSliverNavigationBarSearch(searchField.build(),
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
    if (st == null) throw new RuntimeException("Failed to created widget CupertinoSliverNavigationBar");
    return new CupertinoSliverNavigationBar(st);
  }
  public static CupertinoSliverNavigationBarSearchBuilder search(WidgetI searchField) {
    return CupertinoSliverNavigationBarSearchBuilder.cupertinoSliverNavigationBarSearch(searchField);
  }
  public Widget largeTitle() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoSliverNavigationBarLargeTitle not supported on web");
    return new Widget(CupertinoSliverNavigationBarObjSt.largeTitle(st)) {};
  }
  public Widget leading() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoSliverNavigationBarLeading not supported on web");
    return new Widget(CupertinoSliverNavigationBarObjSt.leading(st)) {};
  }
  public boolean automaticallyImplyLeading() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoSliverNavigationBarAutomaticallyImplyLeading not supported on web");
    return intToBool(CupertinoSliverNavigationBarObjSt.automaticallyImplyLeading(st));
  }
  public boolean automaticallyImplyTitle() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoSliverNavigationBarAutomaticallyImplyTitle not supported on web");
    return intToBool(CupertinoSliverNavigationBarObjSt.automaticallyImplyTitle(st));
  }
  public boolean alwaysShowMiddle() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoSliverNavigationBarAlwaysShowMiddle not supported on web");
    return intToBool(CupertinoSliverNavigationBarObjSt.alwaysShowMiddle(st));
  }
  public String previousPageTitle() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoSliverNavigationBarPreviousPageTitle not supported on web");
    return CupertinoSliverNavigationBarObjSt.previousPageTitle(st).getString(0);
  }
  public Widget middle() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoSliverNavigationBarMiddle not supported on web");
    return new Widget(CupertinoSliverNavigationBarObjSt.middle(st)) {};
  }
  public Widget trailing() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoSliverNavigationBarTrailing not supported on web");
    return new Widget(CupertinoSliverNavigationBarObjSt.trailing(st)) {};
  }
  public Color backgroundColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("cupertinoSliverNavigationBarBackgroundColor", getId());
      return new Color(__nid);
    }
    return new Color(CupertinoSliverNavigationBarObjSt.backgroundColor(st));
  }
  public boolean automaticBackgroundVisibility() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoSliverNavigationBarAutomaticBackgroundVisibility not supported on web");
    return intToBool(CupertinoSliverNavigationBarObjSt.automaticBackgroundVisibility(st));
  }
  public boolean enableBackgroundFilterBlur() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoSliverNavigationBarEnableBackgroundFilterBlur not supported on web");
    return intToBool(CupertinoSliverNavigationBarObjSt.enableBackgroundFilterBlur(st));
  }
  public Brightness brightness() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoSliverNavigationBarBrightness not supported on web");
    return Brightness.values()[CupertinoSliverNavigationBarObjSt.brightness(st)];
  }
  public Border border() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("cupertinoSliverNavigationBarBorder", getId());
      java.lang.foreign.MemorySegment __st = dev.equo.ewt.ffm.BorderObjSt.allocate(__s.arena);
      dev.equo.ewt.ffm.BorderObjSt.id(__st, __nid);
      return new Border(__st);
    }
    return new Border(CupertinoSliverNavigationBarObjSt.border(st));
  }
  public boolean transitionBetweenRoutes() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoSliverNavigationBarTransitionBetweenRoutes not supported on web");
    return intToBool(CupertinoSliverNavigationBarObjSt.transitionBetweenRoutes(st));
  }
  public PreferredSizeWidget bottom() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoSliverNavigationBarBottom not supported on web");
    return new PreferredSizeWidget() { public int getId() { return CupertinoSliverNavigationBarObjSt.bottom(st); } };
  }
  public NavigationBarBottomMode bottomMode() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoSliverNavigationBarBottomMode not supported on web");
    return NavigationBarBottomMode.values()[CupertinoSliverNavigationBarObjSt.bottomMode(st)];
  }
  public boolean stretch() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoSliverNavigationBarStretch not supported on web");
    return intToBool(CupertinoSliverNavigationBarObjSt.stretch(st));
  }
  public Widget searchField() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoSliverNavigationBarSearchField not supported on web");
    return new Widget(CupertinoSliverNavigationBarObjSt.searchField(st)) {};
  }
  public boolean opaque() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoSliverNavigationBarOpaque not supported on web");
    return intToBool(CupertinoSliverNavigationBarObjSt.opaque(st));
  }
  @Override
  public CupertinoSliverNavigationBar build() {
    return this;
  }
}
