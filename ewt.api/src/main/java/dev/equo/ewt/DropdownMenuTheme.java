package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.DropdownMenuThemeObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class DropdownMenuTheme extends InheritedTheme implements DropdownMenuThemeI {
  private MemorySegment st;
  protected DropdownMenuTheme() {}
  DropdownMenuTheme(MemorySegment st) {
    this.id = DropdownMenuThemeObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget DropdownMenuTheme");
    System.out.println("New DropdownMenuTheme id:"+id);
  }
  DropdownMenuTheme(int id) { this.id = id; }
  @Builder.Factory
  static DropdownMenuTheme dropdownMenuThemeDropdownMenuTheme(@Builder.Parameter DropdownMenuThemeDataI data, @Builder.Parameter WidgetI child) {
    var st = factories.dropdownMenuThemeDropdownMenuTheme(data.build(),
      child.build());
    if (st == null) throw new RuntimeException("Failed to created widget DropdownMenuTheme");
    return new DropdownMenuTheme(st);
  }
  public static DropdownMenuThemeDropdownMenuThemeBuilder dropdownMenuTheme(DropdownMenuThemeDataI data, WidgetI child) {
    return DropdownMenuThemeDropdownMenuThemeBuilder.dropdownMenuThemeDropdownMenuTheme(data, child);
  }
  public static DropdownMenuThemeData of(BuildContextI context) {
    var st = factories.dropdownMenuThemeOf(context.build());
    if (st == null) throw new RuntimeException("Failed to created widget DropdownMenuThemeData");
    return new DropdownMenuThemeData(st);
  }
  public static DropdownMenuThemeData maybeOf(BuildContextI context) {
    var st = factories.dropdownMenuThemeMaybeOf(context.build());
    if (st == null) throw new RuntimeException("Failed to created widget DropdownMenuThemeData");
    return new DropdownMenuThemeData(st);
  }
  public DropdownMenuThemeData data() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("dropdownMenuThemeData", getId());
      java.lang.foreign.MemorySegment __st = dev.equo.ewt.ffm.DropdownMenuThemeDataObjSt.allocate(__s.arena);
      dev.equo.ewt.ffm.DropdownMenuThemeDataObjSt.id(__st, __nid);
      return new DropdownMenuThemeData(__st);
    }
    return new DropdownMenuThemeData(DropdownMenuThemeObjSt.data(st));
  }
  @Override
  public DropdownMenuTheme build() {
    return this;
  }
}
