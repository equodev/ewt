package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.ToggleButtonsThemeObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class ToggleButtonsTheme extends InheritedTheme implements ToggleButtonsThemeI {
  private MemorySegment st;
  protected ToggleButtonsTheme() {}
  ToggleButtonsTheme(MemorySegment st) {
    this.id = ToggleButtonsThemeObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget ToggleButtonsTheme");
    System.out.println("New ToggleButtonsTheme id:"+id);
  }
  ToggleButtonsTheme(int id) { this.id = id; }
  @Builder.Factory
  static ToggleButtonsTheme toggleButtonsThemeToggleButtonsTheme(@Builder.Parameter ToggleButtonsThemeDataI data, @Builder.Parameter WidgetI child) {
    var st = factories.toggleButtonsThemeToggleButtonsTheme(data.build(),
      child.build());
    if (st == null) throw new RuntimeException("Failed to created widget ToggleButtonsTheme");
    return new ToggleButtonsTheme(st);
  }
  public static ToggleButtonsThemeToggleButtonsThemeBuilder toggleButtonsTheme(ToggleButtonsThemeDataI data, WidgetI child) {
    return ToggleButtonsThemeToggleButtonsThemeBuilder.toggleButtonsThemeToggleButtonsTheme(data, child);
  }
  public static ToggleButtonsThemeData of(BuildContextI context) {
    var st = factories.toggleButtonsThemeOf(context.build());
    if (st == null) throw new RuntimeException("Failed to created widget ToggleButtonsThemeData");
    return new ToggleButtonsThemeData(st);
  }
  public ToggleButtonsThemeData data() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("toggleButtonsThemeData", getId());
      java.lang.foreign.MemorySegment __st = dev.equo.ewt.ffm.ToggleButtonsThemeDataObjSt.allocate(__s.arena);
      dev.equo.ewt.ffm.ToggleButtonsThemeDataObjSt.id(__st, __nid);
      return new ToggleButtonsThemeData(__st);
    }
    return new ToggleButtonsThemeData(ToggleButtonsThemeObjSt.data(st));
  }
  @Override
  public ToggleButtonsTheme build() {
    return this;
  }
}
