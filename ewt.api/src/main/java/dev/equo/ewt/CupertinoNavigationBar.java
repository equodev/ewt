package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.CupertinoNavigationBarObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class CupertinoNavigationBar extends StatefulWidget implements ObstructingPreferredSizeWidget, CupertinoNavigationBarI {
  private MemorySegment st;
  protected CupertinoNavigationBar() {}
  CupertinoNavigationBar(MemorySegment st) {
    this.id = CupertinoNavigationBarObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget CupertinoNavigationBar");
    System.out.println("New CupertinoNavigationBar id:"+id);
  }
  CupertinoNavigationBar(int id) { this.id = id; }
  @Builder.Factory
  static CupertinoNavigationBar cupertinoNavigationBarCupertinoNavigationBar(Optional<WidgetI> leading, Optional<Boolean> automaticallyImplyLeading, Optional<Boolean> automaticallyImplyMiddle, Optional<String> previousPageTitle, Optional<WidgetI> middle, Optional<WidgetI> trailing, Optional<BorderI> border, Optional<ColorI> backgroundColor, Optional<Boolean> automaticBackgroundVisibility, Optional<Boolean> enableBackgroundFilterBlur, Optional<Brightness> brightness, Optional<Boolean> transitionBetweenRoutes, Optional<PreferredSizeWidgetI> bottom) {
    var st = factories.cupertinoNavigationBarCupertinoNavigationBar(leading.map(WidgetI::build),
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
    if (st == null) throw new RuntimeException("Failed to created widget CupertinoNavigationBar");
    return new CupertinoNavigationBar(st);
  }
  public static CupertinoNavigationBarCupertinoNavigationBarBuilder cupertinoNavigationBar() {
    return CupertinoNavigationBarCupertinoNavigationBarBuilder.cupertinoNavigationBarCupertinoNavigationBar();
  }
  @Builder.Factory
  static CupertinoNavigationBar cupertinoNavigationBarLarge(Optional<WidgetI> largeTitle, Optional<WidgetI> leading, Optional<Boolean> automaticallyImplyLeading, Optional<Boolean> automaticallyImplyTitle, Optional<String> previousPageTitle, Optional<WidgetI> trailing, Optional<BorderI> border, Optional<ColorI> backgroundColor, Optional<Boolean> automaticBackgroundVisibility, Optional<Boolean> enableBackgroundFilterBlur, Optional<Brightness> brightness, Optional<Boolean> transitionBetweenRoutes, Optional<PreferredSizeWidgetI> bottom) {
    var st = factories.cupertinoNavigationBarLarge(largeTitle.map(WidgetI::build),
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
    if (st == null) throw new RuntimeException("Failed to created widget CupertinoNavigationBar");
    return new CupertinoNavigationBar(st);
  }
  public static CupertinoNavigationBarLargeBuilder large() {
    return CupertinoNavigationBarLargeBuilder.cupertinoNavigationBarLarge();
  }
  public Widget largeTitle() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoNavigationBarLargeTitle not supported on web");
    return new Widget(CupertinoNavigationBarObjSt.largeTitle(st)) {};
  }
  public Widget leading() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoNavigationBarLeading not supported on web");
    return new Widget(CupertinoNavigationBarObjSt.leading(st)) {};
  }
  public boolean automaticallyImplyLeading() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoNavigationBarAutomaticallyImplyLeading not supported on web");
    return intToBool(CupertinoNavigationBarObjSt.automaticallyImplyLeading(st));
  }
  public boolean automaticallyImplyMiddle() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoNavigationBarAutomaticallyImplyMiddle not supported on web");
    return intToBool(CupertinoNavigationBarObjSt.automaticallyImplyMiddle(st));
  }
  public String previousPageTitle() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoNavigationBarPreviousPageTitle not supported on web");
    return CupertinoNavigationBarObjSt.previousPageTitle(st).getString(0);
  }
  public Widget middle() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoNavigationBarMiddle not supported on web");
    return new Widget(CupertinoNavigationBarObjSt.middle(st)) {};
  }
  public Widget trailing() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoNavigationBarTrailing not supported on web");
    return new Widget(CupertinoNavigationBarObjSt.trailing(st)) {};
  }
  public Color backgroundColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("cupertinoNavigationBarBackgroundColor", getId());
      return new Color(__nid);
    }
    return new Color(CupertinoNavigationBarObjSt.backgroundColor(st));
  }
  public boolean automaticBackgroundVisibility() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoNavigationBarAutomaticBackgroundVisibility not supported on web");
    return intToBool(CupertinoNavigationBarObjSt.automaticBackgroundVisibility(st));
  }
  public Brightness brightness() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoNavigationBarBrightness not supported on web");
    return Brightness.values()[CupertinoNavigationBarObjSt.brightness(st)];
  }
  public Border border() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("cupertinoNavigationBarBorder", getId());
      java.lang.foreign.MemorySegment __st = dev.equo.ewt.ffm.BorderObjSt.allocate(__s.arena);
      dev.equo.ewt.ffm.BorderObjSt.id(__st, __nid);
      return new Border(__st);
    }
    return new Border(CupertinoNavigationBarObjSt.border(st));
  }
  public boolean transitionBetweenRoutes() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoNavigationBarTransitionBetweenRoutes not supported on web");
    return intToBool(CupertinoNavigationBarObjSt.transitionBetweenRoutes(st));
  }
  public boolean enableBackgroundFilterBlur() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoNavigationBarEnableBackgroundFilterBlur not supported on web");
    return intToBool(CupertinoNavigationBarObjSt.enableBackgroundFilterBlur(st));
  }
  public PreferredSizeWidget bottom() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("cupertinoNavigationBarBottom not supported on web");
    return new PreferredSizeWidget() { public int getId() { return CupertinoNavigationBarObjSt.bottom(st); } };
  }
  @Override
  public CupertinoNavigationBar build() {
    return this;
  }
}
