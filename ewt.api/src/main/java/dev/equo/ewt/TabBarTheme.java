package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.TabBarThemeObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class TabBarTheme extends InheritedTheme implements TabBarThemeI {
  private MemorySegment st;
  protected TabBarTheme() {}
  TabBarTheme(MemorySegment st) {
    this.id = TabBarThemeObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget TabBarTheme");
    System.out.println("New TabBarTheme id:"+id);
  }
  TabBarTheme(int id) { this.id = id; }
  @Builder.Factory
  static TabBarTheme tabBarThemeTabBarTheme(Optional<DecorationI> indicator, Optional<ColorI> indicatorColor, Optional<TabBarIndicatorSize> indicatorSize, Optional<ColorI> dividerColor, OptionalDouble dividerHeight, Optional<ColorI> labelColor, Optional<EdgeInsetsGeometryI> labelPadding, Optional<TextStyleI> labelStyle, Optional<ColorI> unselectedLabelColor, Optional<TextStyleI> unselectedLabelStyle, Optional<ColorI> overlayColor, Optional<TabAlignment> tabAlignment, Optional<TabIndicatorAnimation> indicatorAnimation, Optional<TabBarThemeDataI> data, Optional<WidgetI> child) {
    var st = factories.tabBarThemeTabBarTheme(indicator.map(DecorationI::build),
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
      data.map(TabBarThemeDataI::build),
      child.map(WidgetI::build));
    if (st == null) throw new RuntimeException("Failed to created widget TabBarTheme");
    return new TabBarTheme(st);
  }
  public static TabBarThemeTabBarThemeBuilder tabBarTheme() {
    return TabBarThemeTabBarThemeBuilder.tabBarThemeTabBarTheme();
  }
  public static TabBarThemeData of(BuildContextI context) {
    var st = factories.tabBarThemeOf(context.build());
    if (st == null) throw new RuntimeException("Failed to created widget TabBarThemeData");
    return new TabBarThemeData(st);
  }
  public static TabBarTheme lerp(TabBarThemeI a, TabBarThemeI b, double t) {
    var st = factories.tabBarThemeLerp(a.build(),
      b.build(),
      t);
    if (st == null) throw new RuntimeException("Failed to created widget TabBarTheme");
    return new TabBarTheme(st);
  }
  public Decoration indicator() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("tabBarThemeIndicator not supported on web");
    return new Decoration(TabBarThemeObjSt.indicator(st)) {};
  }
  public Color indicatorColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("tabBarThemeIndicatorColor", getId());
      return new Color(__nid);
    }
    return new Color(TabBarThemeObjSt.indicatorColor(st));
  }
  public TabBarIndicatorSize indicatorSize() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("tabBarThemeIndicatorSize not supported on web");
    return TabBarIndicatorSize.values()[TabBarThemeObjSt.indicatorSize(st)];
  }
  public Color dividerColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("tabBarThemeDividerColor", getId());
      return new Color(__nid);
    }
    return new Color(TabBarThemeObjSt.dividerColor(st));
  }
  public double dividerHeight() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("tabBarThemeDividerHeight not supported on web");
    return TabBarThemeObjSt.dividerHeight(st);
  }
  public Color labelColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("tabBarThemeLabelColor", getId());
      return new Color(__nid);
    }
    return new Color(TabBarThemeObjSt.labelColor(st));
  }
  public EdgeInsetsGeometry labelPadding() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("tabBarThemeLabelPadding not supported on web");
    return new EdgeInsetsGeometry(TabBarThemeObjSt.labelPadding(st)) {};
  }
  public TextStyle labelStyle() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("tabBarThemeLabelStyle", getId());
      java.lang.foreign.MemorySegment __st = dev.equo.ewt.ffm.TextStyleObjSt.allocate(__s.arena);
      dev.equo.ewt.ffm.TextStyleObjSt.id(__st, __nid);
      return new TextStyle(__st);
    }
    return new TextStyle(TabBarThemeObjSt.labelStyle(st));
  }
  public Color unselectedLabelColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("tabBarThemeUnselectedLabelColor", getId());
      return new Color(__nid);
    }
    return new Color(TabBarThemeObjSt.unselectedLabelColor(st));
  }
  public TextStyle unselectedLabelStyle() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("tabBarThemeUnselectedLabelStyle", getId());
      java.lang.foreign.MemorySegment __st = dev.equo.ewt.ffm.TextStyleObjSt.allocate(__s.arena);
      dev.equo.ewt.ffm.TextStyleObjSt.id(__st, __nid);
      return new TextStyle(__st);
    }
    return new TextStyle(TabBarThemeObjSt.unselectedLabelStyle(st));
  }
  public TabAlignment tabAlignment() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("tabBarThemeTabAlignment not supported on web");
    return TabAlignment.values()[TabBarThemeObjSt.tabAlignment(st)];
  }
  public TabIndicatorAnimation indicatorAnimation() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("tabBarThemeIndicatorAnimation not supported on web");
    return TabIndicatorAnimation.values()[TabBarThemeObjSt.indicatorAnimation(st)];
  }
  public TabBarThemeData data() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("tabBarThemeData", getId());
      java.lang.foreign.MemorySegment __st = dev.equo.ewt.ffm.TabBarThemeDataObjSt.allocate(__s.arena);
      dev.equo.ewt.ffm.TabBarThemeDataObjSt.id(__st, __nid);
      return new TabBarThemeData(__st);
    }
    return new TabBarThemeData(TabBarThemeObjSt.data(st));
  }
  @Override
  public TabBarTheme build() {
    return this;
  }
}
