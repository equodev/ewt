package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.TooltipThemeObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class TooltipTheme extends InheritedTheme implements TooltipThemeI {
  private MemorySegment st;
  protected TooltipTheme() {}
  TooltipTheme(MemorySegment st) {
    this.id = TooltipThemeObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget TooltipTheme");
    System.out.println("New TooltipTheme id:"+id);
  }
  TooltipTheme(int id) { this.id = id; }
  @Builder.Factory
  static TooltipTheme tooltipThemeTooltipTheme(@Builder.Parameter TooltipThemeDataI data, @Builder.Parameter WidgetI child) {
    var st = factories.tooltipThemeTooltipTheme(data.build(),
      child.build());
    if (st == null) throw new RuntimeException("Failed to created widget TooltipTheme");
    return new TooltipTheme(st);
  }
  public static TooltipThemeTooltipThemeBuilder tooltipTheme(TooltipThemeDataI data, WidgetI child) {
    return TooltipThemeTooltipThemeBuilder.tooltipThemeTooltipTheme(data, child);
  }
  public static TooltipThemeData of(BuildContextI context) {
    var st = factories.tooltipThemeOf(context.build());
    if (st == null) throw new RuntimeException("Failed to created widget TooltipThemeData");
    return new TooltipThemeData(st);
  }
  public TooltipThemeData data() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("tooltipThemeData", getId());
      java.lang.foreign.MemorySegment __st = dev.equo.ewt.ffm.TooltipThemeDataObjSt.allocate(__s.arena);
      dev.equo.ewt.ffm.TooltipThemeDataObjSt.id(__st, __nid);
      return new TooltipThemeData(__st);
    }
    return new TooltipThemeData(TooltipThemeObjSt.data(st));
  }
  @Override
  public TooltipTheme build() {
    return this;
  }
}
