package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.NoDefaultCupertinoThemeDataObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class NoDefaultCupertinoThemeData extends NativeObj.Base implements NoDefaultCupertinoThemeDataI {
  private MemorySegment st;
  protected NoDefaultCupertinoThemeData() {}
  NoDefaultCupertinoThemeData(MemorySegment st) {
    this.id = NoDefaultCupertinoThemeDataObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget NoDefaultCupertinoThemeData");
    System.out.println("New NoDefaultCupertinoThemeData id:"+id);
  }
  NoDefaultCupertinoThemeData(int id) { this.id = id; }
  @Builder.Factory
  static NoDefaultCupertinoThemeData noDefaultCupertinoThemeDataNoDefaultCupertinoThemeData(Optional<Brightness> brightness, Optional<ColorI> primaryColor, Optional<ColorI> primaryContrastingColor, Optional<CupertinoTextThemeDataI> textTheme, Optional<ColorI> barBackgroundColor, Optional<ColorI> scaffoldBackgroundColor, Optional<ColorI> selectionHandleColor, Optional<Boolean> applyThemeToAll) {
    var st = factories.noDefaultCupertinoThemeDataNoDefaultCupertinoThemeData(brightness,
      primaryColor.map(ColorI::build),
      primaryContrastingColor.map(ColorI::build),
      textTheme.map(CupertinoTextThemeDataI::build),
      barBackgroundColor.map(ColorI::build),
      scaffoldBackgroundColor.map(ColorI::build),
      selectionHandleColor.map(ColorI::build),
      applyThemeToAll);
    if (st == null) throw new RuntimeException("Failed to created widget NoDefaultCupertinoThemeData");
    return new NoDefaultCupertinoThemeData(st);
  }
  public static NoDefaultCupertinoThemeDataNoDefaultCupertinoThemeDataBuilder noDefaultCupertinoThemeData() {
    return NoDefaultCupertinoThemeDataNoDefaultCupertinoThemeDataBuilder.noDefaultCupertinoThemeDataNoDefaultCupertinoThemeData();
  }
  public Brightness brightness() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("noDefaultCupertinoThemeDataBrightness not supported on web");
    return Brightness.values()[NoDefaultCupertinoThemeDataObjSt.brightness(st)];
  }
  public Color primaryColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("noDefaultCupertinoThemeDataPrimaryColor", getId());
      return new Color(__nid);
    }
    return new Color(NoDefaultCupertinoThemeDataObjSt.primaryColor(st));
  }
  public Color primaryContrastingColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("noDefaultCupertinoThemeDataPrimaryContrastingColor", getId());
      return new Color(__nid);
    }
    return new Color(NoDefaultCupertinoThemeDataObjSt.primaryContrastingColor(st));
  }
  public CupertinoTextThemeData textTheme() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("noDefaultCupertinoThemeDataTextTheme", getId());
      java.lang.foreign.MemorySegment __st = dev.equo.ewt.ffm.CupertinoTextThemeDataObjSt.allocate(__s.arena);
      dev.equo.ewt.ffm.CupertinoTextThemeDataObjSt.id(__st, __nid);
      return new CupertinoTextThemeData(__st);
    }
    return new CupertinoTextThemeData(NoDefaultCupertinoThemeDataObjSt.textTheme(st));
  }
  public Color barBackgroundColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("noDefaultCupertinoThemeDataBarBackgroundColor", getId());
      return new Color(__nid);
    }
    return new Color(NoDefaultCupertinoThemeDataObjSt.barBackgroundColor(st));
  }
  public Color scaffoldBackgroundColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("noDefaultCupertinoThemeDataScaffoldBackgroundColor", getId());
      return new Color(__nid);
    }
    return new Color(NoDefaultCupertinoThemeDataObjSt.scaffoldBackgroundColor(st));
  }
  public Color selectionHandleColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("noDefaultCupertinoThemeDataSelectionHandleColor", getId());
      return new Color(__nid);
    }
    return new Color(NoDefaultCupertinoThemeDataObjSt.selectionHandleColor(st));
  }
  public boolean applyThemeToAll() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("noDefaultCupertinoThemeDataApplyThemeToAll not supported on web");
    return intToBool(NoDefaultCupertinoThemeDataObjSt.applyThemeToAll(st));
  }
  @Override
  public NoDefaultCupertinoThemeData build() {
    return this;
  }
}
