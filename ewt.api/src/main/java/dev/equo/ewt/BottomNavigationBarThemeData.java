package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class BottomNavigationBarThemeData extends NativeObj.Base implements BottomNavigationBarThemeDataI {
  protected BottomNavigationBarThemeData() {}
  BottomNavigationBarThemeData(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget BottomNavigationBarThemeData");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static BottomNavigationBarThemeData bottomNavigationBarThemeDataBottomNavigationBarThemeData(Optional<ColorI> backgroundColor, OptionalDouble elevation, Optional<IconThemeDataI> selectedIconTheme, Optional<IconThemeDataI> unselectedIconTheme, Optional<ColorI> selectedItemColor, Optional<ColorI> unselectedItemColor, Optional<TextStyleI> selectedLabelStyle, Optional<TextStyleI> unselectedLabelStyle, Optional<Boolean> showSelectedLabels, Optional<Boolean> showUnselectedLabels, Optional<BottomNavigationBarType> type, Optional<Boolean> enableFeedback, Optional<BottomNavigationBarLandscapeLayout> landscapeLayout) {
    int id = factories.bottomNavigationBarThemeDataBottomNavigationBarThemeData(backgroundColor.map(ColorI::build),
      elevation,
      selectedIconTheme.map(IconThemeDataI::build),
      unselectedIconTheme.map(IconThemeDataI::build),
      selectedItemColor.map(ColorI::build),
      unselectedItemColor.map(ColorI::build),
      selectedLabelStyle.map(TextStyleI::build),
      unselectedLabelStyle.map(TextStyleI::build),
      showSelectedLabels,
      showUnselectedLabels,
      type,
      enableFeedback,
      landscapeLayout);
    if (id <= 0) throw new RuntimeException("Failed to created widget BottomNavigationBarThemeData");
    return new BottomNavigationBarThemeData(id);
  }
  public static BottomNavigationBarThemeDataBottomNavigationBarThemeDataBuilder bottomNavigationBarThemeData() {
    return BottomNavigationBarThemeDataBottomNavigationBarThemeDataBuilder.bottomNavigationBarThemeDataBottomNavigationBarThemeData();
  }
  public static BottomNavigationBarThemeData lerp(BottomNavigationBarThemeDataI a, BottomNavigationBarThemeDataI b, double t) {
    int id = factories.bottomNavigationBarThemeDataLerp(a.build(),
      b.build(),
      t);
    if (id <= 0) throw new RuntimeException("Failed to created widget BottomNavigationBarThemeData");
    return new BottomNavigationBarThemeData(id);
  }
  public Color backgroundColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("bottomNavigationBarThemeDataBackgroundColor", getId());
      return new Color(__nid);
    }
    return factories.BottomNavigationBarThemeData_readBack_backgroundColor(nativeStruct);
  }
  public double elevation() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("bottomNavigationBarThemeDataElevation not supported on web");
    return factories.BottomNavigationBarThemeData_readBack_elevation(nativeStruct);
  }
  public IconThemeData selectedIconTheme() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("bottomNavigationBarThemeDataSelectedIconTheme", getId());
      return new IconThemeData(__nid);
    }
    return factories.BottomNavigationBarThemeData_readBack_selectedIconTheme(nativeStruct);
  }
  public IconThemeData unselectedIconTheme() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("bottomNavigationBarThemeDataUnselectedIconTheme", getId());
      return new IconThemeData(__nid);
    }
    return factories.BottomNavigationBarThemeData_readBack_unselectedIconTheme(nativeStruct);
  }
  public Color selectedItemColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("bottomNavigationBarThemeDataSelectedItemColor", getId());
      return new Color(__nid);
    }
    return factories.BottomNavigationBarThemeData_readBack_selectedItemColor(nativeStruct);
  }
  public Color unselectedItemColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("bottomNavigationBarThemeDataUnselectedItemColor", getId());
      return new Color(__nid);
    }
    return factories.BottomNavigationBarThemeData_readBack_unselectedItemColor(nativeStruct);
  }
  public TextStyle selectedLabelStyle() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("bottomNavigationBarThemeDataSelectedLabelStyle", getId());
      return new TextStyle(__nid);
    }
    return factories.BottomNavigationBarThemeData_readBack_selectedLabelStyle(nativeStruct);
  }
  public TextStyle unselectedLabelStyle() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("bottomNavigationBarThemeDataUnselectedLabelStyle", getId());
      return new TextStyle(__nid);
    }
    return factories.BottomNavigationBarThemeData_readBack_unselectedLabelStyle(nativeStruct);
  }
  public boolean showSelectedLabels() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("bottomNavigationBarThemeDataShowSelectedLabels not supported on web");
    return factories.BottomNavigationBarThemeData_readBack_showSelectedLabels(nativeStruct);
  }
  public boolean showUnselectedLabels() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("bottomNavigationBarThemeDataShowUnselectedLabels not supported on web");
    return factories.BottomNavigationBarThemeData_readBack_showUnselectedLabels(nativeStruct);
  }
  public BottomNavigationBarType type() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("bottomNavigationBarThemeDataType not supported on web");
    return factories.BottomNavigationBarThemeData_readBack_type(nativeStruct);
  }
  public boolean enableFeedback() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("bottomNavigationBarThemeDataEnableFeedback not supported on web");
    return factories.BottomNavigationBarThemeData_readBack_enableFeedback(nativeStruct);
  }
  public BottomNavigationBarLandscapeLayout landscapeLayout() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("bottomNavigationBarThemeDataLandscapeLayout not supported on web");
    return factories.BottomNavigationBarThemeData_readBack_landscapeLayout(nativeStruct);
  }
  @Override
  public BottomNavigationBarThemeData build() {
    return this;
  }
}
