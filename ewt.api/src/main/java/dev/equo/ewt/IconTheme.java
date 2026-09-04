package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.IconThemeObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class IconTheme extends InheritedTheme implements IconThemeI {
  private MemorySegment st;
  protected IconTheme() {}
  IconTheme(MemorySegment st) {
    this.id = IconThemeObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget IconTheme");
    System.out.println("New IconTheme id:"+id);
  }
  IconTheme(int id) { this.id = id; }
  @Builder.Factory
  static IconTheme iconThemeIconTheme(@Builder.Parameter IconThemeDataI data, @Builder.Parameter WidgetI child) {
    var st = factories.iconThemeIconTheme(data.build(),
      child.build());
    if (st == null) throw new RuntimeException("Failed to created widget IconTheme");
    return new IconTheme(st);
  }
  public static IconThemeIconThemeBuilder iconTheme(IconThemeDataI data, WidgetI child) {
    return IconThemeIconThemeBuilder.iconThemeIconTheme(data, child);
  }
  public static Widget merge(IconThemeDataI data, WidgetI child) {
    int id = factories.iconThemeMerge(data.build(),
      child.build());
    if (id <= 0) throw new RuntimeException("Failed to created widget Widget");
    System.out.println("New Widget id:"+id);
    return new Widget(id) {};
  }
  public static IconThemeData of(BuildContextI context) {
    var st = factories.iconThemeOf(context.build());
    if (st == null) throw new RuntimeException("Failed to created widget IconThemeData");
    return new IconThemeData(st);
  }
  public IconThemeData data() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("iconThemeData", getId());
      java.lang.foreign.MemorySegment __st = dev.equo.ewt.ffm.IconThemeDataObjSt.allocate(__s.arena);
      dev.equo.ewt.ffm.IconThemeDataObjSt.id(__st, __nid);
      return new IconThemeData(__st);
    }
    return new IconThemeData(IconThemeObjSt.data(st));
  }
  @Override
  public IconTheme build() {
    return this;
  }
}
