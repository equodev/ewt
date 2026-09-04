package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.DrawerThemeObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class DrawerTheme extends InheritedTheme implements DrawerThemeI {
  private MemorySegment st;
  protected DrawerTheme() {}
  DrawerTheme(MemorySegment st) {
    this.id = DrawerThemeObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget DrawerTheme");
    System.out.println("New DrawerTheme id:"+id);
  }
  DrawerTheme(int id) { this.id = id; }
  @Builder.Factory
  static DrawerTheme drawerThemeDrawerTheme(@Builder.Parameter DrawerThemeDataI data, @Builder.Parameter WidgetI child) {
    var st = factories.drawerThemeDrawerTheme(data.build(),
      child.build());
    if (st == null) throw new RuntimeException("Failed to created widget DrawerTheme");
    return new DrawerTheme(st);
  }
  public static DrawerThemeDrawerThemeBuilder drawerTheme(DrawerThemeDataI data, WidgetI child) {
    return DrawerThemeDrawerThemeBuilder.drawerThemeDrawerTheme(data, child);
  }
  public static DrawerThemeData of(BuildContextI context) {
    var st = factories.drawerThemeOf(context.build());
    if (st == null) throw new RuntimeException("Failed to created widget DrawerThemeData");
    return new DrawerThemeData(st);
  }
  public DrawerThemeData data() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("drawerThemeData", getId());
      java.lang.foreign.MemorySegment __st = dev.equo.ewt.ffm.DrawerThemeDataObjSt.allocate(__s.arena);
      dev.equo.ewt.ffm.DrawerThemeDataObjSt.id(__st, __nid);
      return new DrawerThemeData(__st);
    }
    return new DrawerThemeData(DrawerThemeObjSt.data(st));
  }
  @Override
  public DrawerTheme build() {
    return this;
  }
}
