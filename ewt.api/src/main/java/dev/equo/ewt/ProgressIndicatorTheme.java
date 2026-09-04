package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.ProgressIndicatorThemeObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class ProgressIndicatorTheme extends InheritedTheme implements ProgressIndicatorThemeI {
  private MemorySegment st;
  protected ProgressIndicatorTheme() {}
  ProgressIndicatorTheme(MemorySegment st) {
    this.id = ProgressIndicatorThemeObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget ProgressIndicatorTheme");
    System.out.println("New ProgressIndicatorTheme id:"+id);
  }
  ProgressIndicatorTheme(int id) { this.id = id; }
  @Builder.Factory
  static ProgressIndicatorTheme progressIndicatorThemeProgressIndicatorTheme(@Builder.Parameter ProgressIndicatorThemeDataI data, @Builder.Parameter WidgetI child) {
    var st = factories.progressIndicatorThemeProgressIndicatorTheme(data.build(),
      child.build());
    if (st == null) throw new RuntimeException("Failed to created widget ProgressIndicatorTheme");
    return new ProgressIndicatorTheme(st);
  }
  public static ProgressIndicatorThemeProgressIndicatorThemeBuilder progressIndicatorTheme(ProgressIndicatorThemeDataI data, WidgetI child) {
    return ProgressIndicatorThemeProgressIndicatorThemeBuilder.progressIndicatorThemeProgressIndicatorTheme(data, child);
  }
  public static ProgressIndicatorThemeData of(BuildContextI context) {
    var st = factories.progressIndicatorThemeOf(context.build());
    if (st == null) throw new RuntimeException("Failed to created widget ProgressIndicatorThemeData");
    return new ProgressIndicatorThemeData(st);
  }
  public ProgressIndicatorThemeData data() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("progressIndicatorThemeData", getId());
      java.lang.foreign.MemorySegment __st = dev.equo.ewt.ffm.ProgressIndicatorThemeDataObjSt.allocate(__s.arena);
      dev.equo.ewt.ffm.ProgressIndicatorThemeDataObjSt.id(__st, __nid);
      return new ProgressIndicatorThemeData(__st);
    }
    return new ProgressIndicatorThemeData(ProgressIndicatorThemeObjSt.data(st));
  }
  @Override
  public ProgressIndicatorTheme build() {
    return this;
  }
}
