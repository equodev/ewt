package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.TabBarThemeDataObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class TabBarThemeData extends NativeObj.Base implements TabBarThemeDataI {
  private MemorySegment st;
  protected TabBarThemeData() {}
  TabBarThemeData(MemorySegment st) {
    this.id = TabBarThemeDataObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget TabBarThemeData");
    System.out.println("New TabBarThemeData id:"+id);
  }
  TabBarThemeData(int id) { this.id = id; }
  @Builder.Factory
  static TabBarThemeData tabBarThemeDataTabBarThemeData(Optional<DecorationI> indicator, Optional<ColorI> indicatorColor, Optional<TabBarIndicatorSize> indicatorSize, Optional<ColorI> dividerColor, OptionalDouble dividerHeight, Optional<ColorI> labelColor, Optional<EdgeInsetsGeometryI> labelPadding, Optional<TextStyleI> labelStyle, Optional<ColorI> unselectedLabelColor, Optional<TextStyleI> unselectedLabelStyle, Optional<ColorI> overlayColor, Optional<TabAlignment> tabAlignment, Optional<TabIndicatorAnimation> indicatorAnimation, Optional<BorderRadiusI> splashBorderRadius) {
    var st = factories.tabBarThemeDataTabBarThemeData(indicator.map(DecorationI::build),
      indicatorColor.map(ColorI::build),
      indicatorSize,
      dividerColor.map(ColorI::build),
      dividerHeight,
      labelColor.map(ColorI::build),
      labelPadding.map(EdgeInsetsGeometryI::build),
      labelStyle.map(TextStyleI::build),
      unselectedLabelColor.map(ColorI::build),
      unselectedLabelStyle.map(TextStyleI::build),
      overlayColor.map(ColorI::build),
      tabAlignment,
      indicatorAnimation,
      splashBorderRadius.map(BorderRadiusI::build));
    if (st == null) throw new RuntimeException("Failed to created widget TabBarThemeData");
    return new TabBarThemeData(st);
  }
  public static TabBarThemeDataTabBarThemeDataBuilder tabBarThemeData() {
    return TabBarThemeDataTabBarThemeDataBuilder.tabBarThemeDataTabBarThemeData();
  }
  public static TabBarThemeData lerp(TabBarThemeDataI a, TabBarThemeDataI b, double t) {
    var st = factories.tabBarThemeDataLerp(a.build(),
      b.build(),
      t);
    if (st == null) throw new RuntimeException("Failed to created widget TabBarThemeData");
    return new TabBarThemeData(st);
  }
  public Decoration indicator() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("tabBarThemeDataIndicator not supported on web");
    return new Decoration(TabBarThemeDataObjSt.indicator(st)) {};
  }
  public Color indicatorColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("tabBarThemeDataIndicatorColor", getId());
      return new Color(__nid);
    }
    return new Color(TabBarThemeDataObjSt.indicatorColor(st));
  }
  public TabBarIndicatorSize indicatorSize() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("tabBarThemeDataIndicatorSize not supported on web");
    return TabBarIndicatorSize.values()[TabBarThemeDataObjSt.indicatorSize(st)];
  }
  public Color dividerColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("tabBarThemeDataDividerColor", getId());
      return new Color(__nid);
    }
    return new Color(TabBarThemeDataObjSt.dividerColor(st));
  }
  public double dividerHeight() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("tabBarThemeDataDividerHeight not supported on web");
    return TabBarThemeDataObjSt.dividerHeight(st);
  }
  public Color labelColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("tabBarThemeDataLabelColor", getId());
      return new Color(__nid);
    }
    return new Color(TabBarThemeDataObjSt.labelColor(st));
  }
  public EdgeInsetsGeometry labelPadding() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("tabBarThemeDataLabelPadding not supported on web");
    return new EdgeInsetsGeometry(TabBarThemeDataObjSt.labelPadding(st)) {};
  }
  public TextStyle labelStyle() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("tabBarThemeDataLabelStyle", getId());
      java.lang.foreign.MemorySegment __st = dev.equo.ewt.ffm.TextStyleObjSt.allocate(__s.arena);
      dev.equo.ewt.ffm.TextStyleObjSt.id(__st, __nid);
      return new TextStyle(__st);
    }
    return new TextStyle(TabBarThemeDataObjSt.labelStyle(st));
  }
  public Color unselectedLabelColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("tabBarThemeDataUnselectedLabelColor", getId());
      return new Color(__nid);
    }
    return new Color(TabBarThemeDataObjSt.unselectedLabelColor(st));
  }
  public TextStyle unselectedLabelStyle() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("tabBarThemeDataUnselectedLabelStyle", getId());
      java.lang.foreign.MemorySegment __st = dev.equo.ewt.ffm.TextStyleObjSt.allocate(__s.arena);
      dev.equo.ewt.ffm.TextStyleObjSt.id(__st, __nid);
      return new TextStyle(__st);
    }
    return new TextStyle(TabBarThemeDataObjSt.unselectedLabelStyle(st));
  }
  public TabAlignment tabAlignment() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("tabBarThemeDataTabAlignment not supported on web");
    return TabAlignment.values()[TabBarThemeDataObjSt.tabAlignment(st)];
  }
  public TabIndicatorAnimation indicatorAnimation() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("tabBarThemeDataIndicatorAnimation not supported on web");
    return TabIndicatorAnimation.values()[TabBarThemeDataObjSt.indicatorAnimation(st)];
  }
  public BorderRadius splashBorderRadius() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("tabBarThemeDataSplashBorderRadius", getId());
      java.lang.foreign.MemorySegment __st = dev.equo.ewt.ffm.BorderRadiusObjSt.allocate(__s.arena);
      dev.equo.ewt.ffm.BorderRadiusObjSt.id(__st, __nid);
      return new BorderRadius(__st);
    }
    return new BorderRadius(TabBarThemeDataObjSt.splashBorderRadius(st));
  }
  @Override
  public TabBarThemeData build() {
    return this;
  }
}
