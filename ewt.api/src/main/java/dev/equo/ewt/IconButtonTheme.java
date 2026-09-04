package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.IconButtonThemeObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class IconButtonTheme extends InheritedTheme implements IconButtonThemeI {
  private MemorySegment st;
  protected IconButtonTheme() {}
  IconButtonTheme(MemorySegment st) {
    this.id = IconButtonThemeObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget IconButtonTheme");
    System.out.println("New IconButtonTheme id:"+id);
  }
  IconButtonTheme(int id) { this.id = id; }
  @Builder.Factory
  static IconButtonTheme iconButtonThemeIconButtonTheme(@Builder.Parameter IconButtonThemeDataI data, @Builder.Parameter WidgetI child) {
    var st = factories.iconButtonThemeIconButtonTheme(data.build(),
      child.build());
    if (st == null) throw new RuntimeException("Failed to created widget IconButtonTheme");
    return new IconButtonTheme(st);
  }
  public static IconButtonThemeIconButtonThemeBuilder iconButtonTheme(IconButtonThemeDataI data, WidgetI child) {
    return IconButtonThemeIconButtonThemeBuilder.iconButtonThemeIconButtonTheme(data, child);
  }
  public static IconButtonThemeData of(BuildContextI context) {
    var st = factories.iconButtonThemeOf(context.build());
    if (st == null) throw new RuntimeException("Failed to created widget IconButtonThemeData");
    return new IconButtonThemeData(st);
  }
  public IconButtonThemeData data() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("iconButtonThemeData", getId());
      java.lang.foreign.MemorySegment __st = dev.equo.ewt.ffm.IconButtonThemeDataObjSt.allocate(__s.arena);
      dev.equo.ewt.ffm.IconButtonThemeDataObjSt.id(__st, __nid);
      return new IconButtonThemeData(__st);
    }
    return new IconButtonThemeData(IconButtonThemeObjSt.data(st));
  }
  @Override
  public IconButtonTheme build() {
    return this;
  }
}
