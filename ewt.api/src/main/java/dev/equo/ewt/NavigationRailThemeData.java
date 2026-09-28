package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class NavigationRailThemeData extends NativeObj.Base implements NavigationRailThemeDataI {
  protected NavigationRailThemeData() {}
  NavigationRailThemeData(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget NavigationRailThemeData");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static NavigationRailThemeData navigationRailThemeDataNavigationRailThemeData(Optional<ColorI> backgroundColor, OptionalDouble elevation, Optional<TextStyleI> unselectedLabelTextStyle, Optional<TextStyleI> selectedLabelTextStyle, Optional<IconThemeDataI> unselectedIconTheme, Optional<IconThemeDataI> selectedIconTheme, OptionalDouble groupAlignment, Optional<NavigationRailLabelType> labelType, Optional<Boolean> useIndicator, Optional<ColorI> indicatorColor, Optional<ShapeBorderI> indicatorShape, OptionalDouble minWidth, OptionalDouble minExtendedWidth) {
    int id = factories.navigationRailThemeDataNavigationRailThemeData(backgroundColor.map(ColorI::build),
      elevation,
      unselectedLabelTextStyle.map(TextStyleI::build),
      selectedLabelTextStyle.map(TextStyleI::build),
      unselectedIconTheme.map(IconThemeDataI::build),
      selectedIconTheme.map(IconThemeDataI::build),
      groupAlignment,
      labelType,
      useIndicator,
      indicatorColor.map(ColorI::build),
      indicatorShape.map(ShapeBorderI::build),
      minWidth,
      minExtendedWidth);
    if (id <= 0) throw new RuntimeException("Failed to created widget NavigationRailThemeData");
    return new NavigationRailThemeData(id);
  }
  public static NavigationRailThemeDataNavigationRailThemeDataBuilder navigationRailThemeData() {
    return NavigationRailThemeDataNavigationRailThemeDataBuilder.navigationRailThemeDataNavigationRailThemeData();
  }
  public static NavigationRailThemeData lerp(NavigationRailThemeDataI a, NavigationRailThemeDataI b, double t) {
    int id = factories.navigationRailThemeDataLerp(a.build(),
      b.build(),
      t);
    if (id <= 0) throw new RuntimeException("Failed to created widget NavigationRailThemeData");
    return new NavigationRailThemeData(id);
  }
  public Color backgroundColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("navigationRailThemeDataBackgroundColor", getId());
      return new Color(__nid);
    }
    return factories.NavigationRailThemeData_readBack_backgroundColor(nativeStruct);
  }
  public double elevation() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("navigationRailThemeDataElevation not supported on web");
    return factories.NavigationRailThemeData_readBack_elevation(nativeStruct);
  }
  public TextStyle unselectedLabelTextStyle() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("navigationRailThemeDataUnselectedLabelTextStyle", getId());
      return new TextStyle(__nid);
    }
    return factories.NavigationRailThemeData_readBack_unselectedLabelTextStyle(nativeStruct);
  }
  public TextStyle selectedLabelTextStyle() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("navigationRailThemeDataSelectedLabelTextStyle", getId());
      return new TextStyle(__nid);
    }
    return factories.NavigationRailThemeData_readBack_selectedLabelTextStyle(nativeStruct);
  }
  public IconThemeData unselectedIconTheme() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("navigationRailThemeDataUnselectedIconTheme", getId());
      return new IconThemeData(__nid);
    }
    return factories.NavigationRailThemeData_readBack_unselectedIconTheme(nativeStruct);
  }
  public IconThemeData selectedIconTheme() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("navigationRailThemeDataSelectedIconTheme", getId());
      return new IconThemeData(__nid);
    }
    return factories.NavigationRailThemeData_readBack_selectedIconTheme(nativeStruct);
  }
  public double groupAlignment() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("navigationRailThemeDataGroupAlignment not supported on web");
    return factories.NavigationRailThemeData_readBack_groupAlignment(nativeStruct);
  }
  public NavigationRailLabelType labelType() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("navigationRailThemeDataLabelType not supported on web");
    return factories.NavigationRailThemeData_readBack_labelType(nativeStruct);
  }
  public boolean useIndicator() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("navigationRailThemeDataUseIndicator not supported on web");
    return factories.NavigationRailThemeData_readBack_useIndicator(nativeStruct);
  }
  public Color indicatorColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("navigationRailThemeDataIndicatorColor", getId());
      return new Color(__nid);
    }
    return factories.NavigationRailThemeData_readBack_indicatorColor(nativeStruct);
  }
  public ShapeBorder indicatorShape() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("navigationRailThemeDataIndicatorShape not supported on web");
    return factories.NavigationRailThemeData_readBack_indicatorShape(nativeStruct);
  }
  public double minWidth() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("navigationRailThemeDataMinWidth not supported on web");
    return factories.NavigationRailThemeData_readBack_minWidth(nativeStruct);
  }
  public double minExtendedWidth() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("navigationRailThemeDataMinExtendedWidth not supported on web");
    return factories.NavigationRailThemeData_readBack_minExtendedWidth(nativeStruct);
  }
  @Override
  public NavigationRailThemeData build() {
    return this;
  }
}
