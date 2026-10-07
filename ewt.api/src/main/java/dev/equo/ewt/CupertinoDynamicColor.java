package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class CupertinoDynamicColor extends NativeObj.Base implements CupertinoDynamicColorI {
  protected CupertinoDynamicColor() {}
  CupertinoDynamicColor(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget CupertinoDynamicColor");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static CupertinoDynamicColor cupertinoDynamicColorCupertinoDynamicColor(Optional<String> debugLabel, ColorI color, ColorI darkColor, ColorI highContrastColor, ColorI darkHighContrastColor, ColorI elevatedColor, ColorI darkElevatedColor, ColorI highContrastElevatedColor, ColorI darkHighContrastElevatedColor) {
    int id = factories.cupertinoDynamicColorCupertinoDynamicColor(debugLabel,
      color.build(),
      darkColor.build(),
      highContrastColor.build(),
      darkHighContrastColor.build(),
      elevatedColor.build(),
      darkElevatedColor.build(),
      highContrastElevatedColor.build(),
      darkHighContrastElevatedColor.build());
    if (id <= 0) throw new RuntimeException("Failed to created widget CupertinoDynamicColor");
    return new CupertinoDynamicColor(id);
  }
  public static CupertinoDynamicColorCupertinoDynamicColorBuilder cupertinoDynamicColor() {
    return CupertinoDynamicColorCupertinoDynamicColorBuilder.cupertinoDynamicColorCupertinoDynamicColor();
  }
  @Builder.Factory
  static CupertinoDynamicColor cupertinoDynamicColorWithBrightnessAndContrast(Optional<String> debugLabel, ColorI color, ColorI darkColor, ColorI highContrastColor, ColorI darkHighContrastColor) {
    int id = factories.cupertinoDynamicColorWithBrightnessAndContrast(debugLabel,
      color.build(),
      darkColor.build(),
      highContrastColor.build(),
      darkHighContrastColor.build());
    if (id <= 0) throw new RuntimeException("Failed to created widget CupertinoDynamicColor");
    return new CupertinoDynamicColor(id);
  }
  public static CupertinoDynamicColorWithBrightnessAndContrastBuilder withBrightnessAndContrast() {
    return CupertinoDynamicColorWithBrightnessAndContrastBuilder.cupertinoDynamicColorWithBrightnessAndContrast();
  }
  @Builder.Factory
  static CupertinoDynamicColor cupertinoDynamicColorWithBrightness(Optional<String> debugLabel, ColorI color, ColorI darkColor) {
    int id = factories.cupertinoDynamicColorWithBrightness(debugLabel,
      color.build(),
      darkColor.build());
    if (id <= 0) throw new RuntimeException("Failed to created widget CupertinoDynamicColor");
    return new CupertinoDynamicColor(id);
  }
  public static CupertinoDynamicColorWithBrightnessBuilder withBrightness() {
    return CupertinoDynamicColorWithBrightnessBuilder.cupertinoDynamicColorWithBrightness();
  }
  public static Color resolve(ColorI resolvable, BuildContextI context) {
    var id = factories.cupertinoDynamicColorResolve(resolvable.build(),
      context.build());
    if (id <= 0) throw new RuntimeException("Failed to created widget Color");
    return new Color(id);
  }
  public static Color maybeResolve(ColorI resolvable, BuildContextI context) {
    var id = factories.cupertinoDynamicColorMaybeResolve(resolvable.build(),
      context.build());
    if (id <= 0) throw new RuntimeException("Failed to created widget Color?");
    return new Color(id);
  }
  public Color color() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("cupertinoDynamicColorColor", getId());
      return new Color(__nid);
    }
    return factories.CupertinoDynamicColor_readBack_color(nativeStruct);
  }
  public Color darkColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("cupertinoDynamicColorDarkColor", getId());
      return new Color(__nid);
    }
    return factories.CupertinoDynamicColor_readBack_darkColor(nativeStruct);
  }
  public Color highContrastColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("cupertinoDynamicColorHighContrastColor", getId());
      return new Color(__nid);
    }
    return factories.CupertinoDynamicColor_readBack_highContrastColor(nativeStruct);
  }
  public Color darkHighContrastColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("cupertinoDynamicColorDarkHighContrastColor", getId());
      return new Color(__nid);
    }
    return factories.CupertinoDynamicColor_readBack_darkHighContrastColor(nativeStruct);
  }
  public Color elevatedColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("cupertinoDynamicColorElevatedColor", getId());
      return new Color(__nid);
    }
    return factories.CupertinoDynamicColor_readBack_elevatedColor(nativeStruct);
  }
  public Color darkElevatedColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("cupertinoDynamicColorDarkElevatedColor", getId());
      return new Color(__nid);
    }
    return factories.CupertinoDynamicColor_readBack_darkElevatedColor(nativeStruct);
  }
  public Color highContrastElevatedColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("cupertinoDynamicColorHighContrastElevatedColor", getId());
      return new Color(__nid);
    }
    return factories.CupertinoDynamicColor_readBack_highContrastElevatedColor(nativeStruct);
  }
  public Color darkHighContrastElevatedColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("cupertinoDynamicColorDarkHighContrastElevatedColor", getId());
      return new Color(__nid);
    }
    return factories.CupertinoDynamicColor_readBack_darkHighContrastElevatedColor(nativeStruct);
  }
  @Override
  public CupertinoDynamicColor build() {
    return this;
  }
}
