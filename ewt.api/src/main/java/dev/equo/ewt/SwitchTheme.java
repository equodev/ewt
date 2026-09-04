package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.SwitchThemeObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class SwitchTheme extends InheritedWidget implements SwitchThemeI {
  private MemorySegment st;
  protected SwitchTheme() {}
  SwitchTheme(MemorySegment st) {
    this.id = SwitchThemeObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget SwitchTheme");
    System.out.println("New SwitchTheme id:"+id);
  }
  SwitchTheme(int id) { this.id = id; }
  @Builder.Factory
  static SwitchTheme switchThemeSwitchTheme(@Builder.Parameter SwitchThemeDataI data, @Builder.Parameter WidgetI child) {
    var st = factories.switchThemeSwitchTheme(data.build(),
      child.build());
    if (st == null) throw new RuntimeException("Failed to created widget SwitchTheme");
    return new SwitchTheme(st);
  }
  public static SwitchThemeSwitchThemeBuilder switchTheme(SwitchThemeDataI data, WidgetI child) {
    return SwitchThemeSwitchThemeBuilder.switchThemeSwitchTheme(data, child);
  }
  public static SwitchThemeData of(BuildContextI context) {
    var st = factories.switchThemeOf(context.build());
    if (st == null) throw new RuntimeException("Failed to created widget SwitchThemeData");
    return new SwitchThemeData(st);
  }
  public SwitchThemeData data() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("switchThemeData", getId());
      java.lang.foreign.MemorySegment __st = dev.equo.ewt.ffm.SwitchThemeDataObjSt.allocate(__s.arena);
      dev.equo.ewt.ffm.SwitchThemeDataObjSt.id(__st, __nid);
      return new SwitchThemeData(__st);
    }
    return new SwitchThemeData(SwitchThemeObjSt.data(st));
  }
  @Override
  public SwitchTheme build() {
    return this;
  }
}
