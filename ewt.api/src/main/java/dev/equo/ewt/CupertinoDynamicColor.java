package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.CupertinoDynamicColorObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class CupertinoDynamicColor extends NativeObj.Base implements CupertinoDynamicColorI {
  private MemorySegment st;
  protected CupertinoDynamicColor() {}
  CupertinoDynamicColor(MemorySegment st) {
    this.id = CupertinoDynamicColorObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget CupertinoDynamicColor");
    System.out.println("New CupertinoDynamicColor id:"+id);
  }
  CupertinoDynamicColor(int id) { this.id = id; }
  @Builder.Factory
  static CupertinoDynamicColor cupertinoDynamicColorCupertinoDynamicColor(Optional<String> debugLabel, ColorI color, ColorI darkColor, ColorI highContrastColor, ColorI darkHighContrastColor, ColorI elevatedColor, ColorI darkElevatedColor, ColorI highContrastElevatedColor, ColorI darkHighContrastElevatedColor) {
    var st = factories.cupertinoDynamicColorCupertinoDynamicColor(debugLabel,
      color.build(),
      darkColor.build(),
      highContrastColor.build(),
      darkHighContrastColor.build(),
      elevatedColor.build(),
      darkElevatedColor.build(),
      highContrastElevatedColor.build(),
      darkHighContrastElevatedColor.build());
    if (st == null) throw new RuntimeException("Failed to created widget CupertinoDynamicColor");
    return new CupertinoDynamicColor(st);
  }
  public static CupertinoDynamicColorCupertinoDynamicColorBuilder cupertinoDynamicColor() {
    return CupertinoDynamicColorCupertinoDynamicColorBuilder.cupertinoDynamicColorCupertinoDynamicColor();
  }
  @Builder.Factory
  static CupertinoDynamicColor cupertinoDynamicColorWithBrightnessAndContrast(Optional<String> debugLabel, ColorI color, ColorI darkColor, ColorI highContrastColor, ColorI darkHighContrastColor) {
    var st = factories.cupertinoDynamicColorWithBrightnessAndContrast(debugLabel,
      color.build(),
      darkColor.build(),
      highContrastColor.build(),
      darkHighContrastColor.build());
    if (st == null) throw new RuntimeException("Failed to created widget CupertinoDynamicColor");
    return new CupertinoDynamicColor(st);
  }
  public static CupertinoDynamicColorWithBrightnessAndContrastBuilder withBrightnessAndContrast() {
    return CupertinoDynamicColorWithBrightnessAndContrastBuilder.cupertinoDynamicColorWithBrightnessAndContrast();
  }
  @Builder.Factory
  static CupertinoDynamicColor cupertinoDynamicColorWithBrightness(Optional<String> debugLabel, ColorI color, ColorI darkColor) {
    var st = factories.cupertinoDynamicColorWithBrightness(debugLabel,
      color.build(),
      darkColor.build());
    if (st == null) throw new RuntimeException("Failed to created widget CupertinoDynamicColor");
    return new CupertinoDynamicColor(st);
  }
  public static CupertinoDynamicColorWithBrightnessBuilder withBrightness() {
    return CupertinoDynamicColorWithBrightnessBuilder.cupertinoDynamicColorWithBrightness();
  }
  public static Color resolve(ColorI resolvable, BuildContextI context) {
    int id = factories.cupertinoDynamicColorResolve(resolvable.build(),
      context.build());
    if (id <= 0) throw new RuntimeException("Failed to created widget Color");
    System.out.println("New Color id:"+id);
    return new Color(id);
  }
  public static Color maybeResolve(ColorI resolvable, BuildContextI context) {
    int id = factories.cupertinoDynamicColorMaybeResolve(resolvable.build(),
      context.build());
    if (id <= 0) throw new RuntimeException("Failed to created widget Color?");
    System.out.println("New Color? id:"+id);
    return new Color(id);
  }
  public Color color() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("cupertinoDynamicColorColor", getId());
      return new Color(__nid);
    }
    return new Color(CupertinoDynamicColorObjSt.color(st));
  }
  public Color darkColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("cupertinoDynamicColorDarkColor", getId());
      return new Color(__nid);
    }
    return new Color(CupertinoDynamicColorObjSt.darkColor(st));
  }
  public Color highContrastColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("cupertinoDynamicColorHighContrastColor", getId());
      return new Color(__nid);
    }
    return new Color(CupertinoDynamicColorObjSt.highContrastColor(st));
  }
  public Color darkHighContrastColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("cupertinoDynamicColorDarkHighContrastColor", getId());
      return new Color(__nid);
    }
    return new Color(CupertinoDynamicColorObjSt.darkHighContrastColor(st));
  }
  public Color elevatedColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("cupertinoDynamicColorElevatedColor", getId());
      return new Color(__nid);
    }
    return new Color(CupertinoDynamicColorObjSt.elevatedColor(st));
  }
  public Color darkElevatedColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("cupertinoDynamicColorDarkElevatedColor", getId());
      return new Color(__nid);
    }
    return new Color(CupertinoDynamicColorObjSt.darkElevatedColor(st));
  }
  public Color highContrastElevatedColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("cupertinoDynamicColorHighContrastElevatedColor", getId());
      return new Color(__nid);
    }
    return new Color(CupertinoDynamicColorObjSt.highContrastElevatedColor(st));
  }
  public Color darkHighContrastElevatedColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("cupertinoDynamicColorDarkHighContrastElevatedColor", getId());
      return new Color(__nid);
    }
    return new Color(CupertinoDynamicColorObjSt.darkHighContrastElevatedColor(st));
  }
  @Override
  public CupertinoDynamicColor build() {
    return this;
  }
}
