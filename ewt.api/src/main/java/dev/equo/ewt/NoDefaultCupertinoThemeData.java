package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class NoDefaultCupertinoThemeData extends NativeObj.Base implements NoDefaultCupertinoThemeDataI {
  protected NoDefaultCupertinoThemeData() {}
  NoDefaultCupertinoThemeData(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget NoDefaultCupertinoThemeData");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static NoDefaultCupertinoThemeData noDefaultCupertinoThemeDataNoDefaultCupertinoThemeData(Optional<Brightness> brightness, Optional<ColorI> primaryColor, Optional<ColorI> primaryContrastingColor, Optional<CupertinoTextThemeDataI> textTheme, Optional<ColorI> barBackgroundColor, Optional<ColorI> scaffoldBackgroundColor, Optional<ColorI> selectionHandleColor, Optional<Boolean> applyThemeToAll) {
    int id = factories.noDefaultCupertinoThemeDataNoDefaultCupertinoThemeData(brightness,
      primaryColor.map(ColorI::build),
      primaryContrastingColor.map(ColorI::build),
      textTheme.map(CupertinoTextThemeDataI::build),
      barBackgroundColor.map(ColorI::build),
      scaffoldBackgroundColor.map(ColorI::build),
      selectionHandleColor.map(ColorI::build),
      applyThemeToAll);
    if (id <= 0) throw new RuntimeException("Failed to created widget NoDefaultCupertinoThemeData");
    return new NoDefaultCupertinoThemeData(id);
  }
  public static NoDefaultCupertinoThemeDataNoDefaultCupertinoThemeDataBuilder noDefaultCupertinoThemeData() {
    return NoDefaultCupertinoThemeDataNoDefaultCupertinoThemeDataBuilder.noDefaultCupertinoThemeDataNoDefaultCupertinoThemeData();
  }
  public Brightness brightness() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("noDefaultCupertinoThemeDataBrightness not supported on web");
    return factories.NoDefaultCupertinoThemeData_readBack_brightness(nativeStruct);
  }
  public Color primaryColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("noDefaultCupertinoThemeDataPrimaryColor", getId());
      return new Color(__nid);
    }
    return factories.NoDefaultCupertinoThemeData_readBack_primaryColor(nativeStruct);
  }
  public Color primaryContrastingColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("noDefaultCupertinoThemeDataPrimaryContrastingColor", getId());
      return new Color(__nid);
    }
    return factories.NoDefaultCupertinoThemeData_readBack_primaryContrastingColor(nativeStruct);
  }
  public CupertinoTextThemeData textTheme() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("noDefaultCupertinoThemeDataTextTheme", getId());
      return new CupertinoTextThemeData(__nid);
    }
    return factories.NoDefaultCupertinoThemeData_readBack_textTheme(nativeStruct);
  }
  public Color barBackgroundColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("noDefaultCupertinoThemeDataBarBackgroundColor", getId());
      return new Color(__nid);
    }
    return factories.NoDefaultCupertinoThemeData_readBack_barBackgroundColor(nativeStruct);
  }
  public Color scaffoldBackgroundColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("noDefaultCupertinoThemeDataScaffoldBackgroundColor", getId());
      return new Color(__nid);
    }
    return factories.NoDefaultCupertinoThemeData_readBack_scaffoldBackgroundColor(nativeStruct);
  }
  public Color selectionHandleColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("noDefaultCupertinoThemeDataSelectionHandleColor", getId());
      return new Color(__nid);
    }
    return factories.NoDefaultCupertinoThemeData_readBack_selectionHandleColor(nativeStruct);
  }
  public boolean applyThemeToAll() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("noDefaultCupertinoThemeDataApplyThemeToAll not supported on web");
    return factories.NoDefaultCupertinoThemeData_readBack_applyThemeToAll(nativeStruct);
  }
  @Override
  public NoDefaultCupertinoThemeData build() {
    return this;
  }
}
