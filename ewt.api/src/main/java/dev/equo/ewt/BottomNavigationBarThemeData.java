package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.BottomNavigationBarThemeDataObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class BottomNavigationBarThemeData extends NativeObj.Base implements BottomNavigationBarThemeDataI {
  private MemorySegment st;
  protected BottomNavigationBarThemeData() {}
  BottomNavigationBarThemeData(MemorySegment st) {
    this.id = BottomNavigationBarThemeDataObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget BottomNavigationBarThemeData");
    System.out.println("New BottomNavigationBarThemeData id:"+id);
  }
  BottomNavigationBarThemeData(int id) { this.id = id; }
  @Builder.Factory
  static BottomNavigationBarThemeData bottomNavigationBarThemeDataBottomNavigationBarThemeData(Optional<ColorI> backgroundColor, OptionalDouble elevation, Optional<IconThemeDataI> selectedIconTheme, Optional<IconThemeDataI> unselectedIconTheme, Optional<ColorI> selectedItemColor, Optional<ColorI> unselectedItemColor, Optional<TextStyleI> selectedLabelStyle, Optional<TextStyleI> unselectedLabelStyle, Optional<Boolean> showSelectedLabels, Optional<Boolean> showUnselectedLabels, Optional<BottomNavigationBarType> type, Optional<Boolean> enableFeedback, Optional<BottomNavigationBarLandscapeLayout> landscapeLayout) {
    var st = factories.bottomNavigationBarThemeDataBottomNavigationBarThemeData(backgroundColor.map(ColorI::build),
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
    if (st == null) throw new RuntimeException("Failed to created widget BottomNavigationBarThemeData");
    return new BottomNavigationBarThemeData(st);
  }
  public static BottomNavigationBarThemeDataBottomNavigationBarThemeDataBuilder bottomNavigationBarThemeData() {
    return BottomNavigationBarThemeDataBottomNavigationBarThemeDataBuilder.bottomNavigationBarThemeDataBottomNavigationBarThemeData();
  }
  public static BottomNavigationBarThemeData lerp(BottomNavigationBarThemeDataI a, BottomNavigationBarThemeDataI b, double t) {
    var st = factories.bottomNavigationBarThemeDataLerp(a.build(),
      b.build(),
      t);
    if (st == null) throw new RuntimeException("Failed to created widget BottomNavigationBarThemeData");
    return new BottomNavigationBarThemeData(st);
  }
  public Color backgroundColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("bottomNavigationBarThemeDataBackgroundColor", getId());
      return new Color(__nid);
    }
    return new Color(BottomNavigationBarThemeDataObjSt.backgroundColor(st));
  }
  public double elevation() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("bottomNavigationBarThemeDataElevation not supported on web");
    return BottomNavigationBarThemeDataObjSt.elevation(st);
  }
  public IconThemeData selectedIconTheme() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("bottomNavigationBarThemeDataSelectedIconTheme", getId());
      java.lang.foreign.MemorySegment __st = dev.equo.ewt.ffm.IconThemeDataObjSt.allocate(__s.arena);
      dev.equo.ewt.ffm.IconThemeDataObjSt.id(__st, __nid);
      return new IconThemeData(__st);
    }
    return new IconThemeData(BottomNavigationBarThemeDataObjSt.selectedIconTheme(st));
  }
  public IconThemeData unselectedIconTheme() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("bottomNavigationBarThemeDataUnselectedIconTheme", getId());
      java.lang.foreign.MemorySegment __st = dev.equo.ewt.ffm.IconThemeDataObjSt.allocate(__s.arena);
      dev.equo.ewt.ffm.IconThemeDataObjSt.id(__st, __nid);
      return new IconThemeData(__st);
    }
    return new IconThemeData(BottomNavigationBarThemeDataObjSt.unselectedIconTheme(st));
  }
  public Color selectedItemColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("bottomNavigationBarThemeDataSelectedItemColor", getId());
      return new Color(__nid);
    }
    return new Color(BottomNavigationBarThemeDataObjSt.selectedItemColor(st));
  }
  public Color unselectedItemColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("bottomNavigationBarThemeDataUnselectedItemColor", getId());
      return new Color(__nid);
    }
    return new Color(BottomNavigationBarThemeDataObjSt.unselectedItemColor(st));
  }
  public TextStyle selectedLabelStyle() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("bottomNavigationBarThemeDataSelectedLabelStyle", getId());
      java.lang.foreign.MemorySegment __st = dev.equo.ewt.ffm.TextStyleObjSt.allocate(__s.arena);
      dev.equo.ewt.ffm.TextStyleObjSt.id(__st, __nid);
      return new TextStyle(__st);
    }
    return new TextStyle(BottomNavigationBarThemeDataObjSt.selectedLabelStyle(st));
  }
  public TextStyle unselectedLabelStyle() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("bottomNavigationBarThemeDataUnselectedLabelStyle", getId());
      java.lang.foreign.MemorySegment __st = dev.equo.ewt.ffm.TextStyleObjSt.allocate(__s.arena);
      dev.equo.ewt.ffm.TextStyleObjSt.id(__st, __nid);
      return new TextStyle(__st);
    }
    return new TextStyle(BottomNavigationBarThemeDataObjSt.unselectedLabelStyle(st));
  }
  public boolean showSelectedLabels() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("bottomNavigationBarThemeDataShowSelectedLabels not supported on web");
    return intToBool(BottomNavigationBarThemeDataObjSt.showSelectedLabels(st));
  }
  public boolean showUnselectedLabels() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("bottomNavigationBarThemeDataShowUnselectedLabels not supported on web");
    return intToBool(BottomNavigationBarThemeDataObjSt.showUnselectedLabels(st));
  }
  public BottomNavigationBarType type() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("bottomNavigationBarThemeDataType not supported on web");
    return BottomNavigationBarType.values()[BottomNavigationBarThemeDataObjSt.type(st)];
  }
  public boolean enableFeedback() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("bottomNavigationBarThemeDataEnableFeedback not supported on web");
    return intToBool(BottomNavigationBarThemeDataObjSt.enableFeedback(st));
  }
  public BottomNavigationBarLandscapeLayout landscapeLayout() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("bottomNavigationBarThemeDataLandscapeLayout not supported on web");
    return BottomNavigationBarLandscapeLayout.values()[BottomNavigationBarThemeDataObjSt.landscapeLayout(st)];
  }
  @Override
  public BottomNavigationBarThemeData build() {
    return this;
  }
}
