package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.ExpansionTileThemeObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class ExpansionTileTheme extends InheritedTheme implements ExpansionTileThemeI {
  private MemorySegment st;
  protected ExpansionTileTheme() {}
  ExpansionTileTheme(MemorySegment st) {
    this.id = ExpansionTileThemeObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget ExpansionTileTheme");
    System.out.println("New ExpansionTileTheme id:"+id);
  }
  ExpansionTileTheme(int id) { this.id = id; }
  @Builder.Factory
  static ExpansionTileTheme expansionTileThemeExpansionTileTheme(@Builder.Parameter ExpansionTileThemeDataI data, @Builder.Parameter WidgetI child) {
    var st = factories.expansionTileThemeExpansionTileTheme(data.build(),
      child.build());
    if (st == null) throw new RuntimeException("Failed to created widget ExpansionTileTheme");
    return new ExpansionTileTheme(st);
  }
  public static ExpansionTileThemeExpansionTileThemeBuilder expansionTileTheme(ExpansionTileThemeDataI data, WidgetI child) {
    return ExpansionTileThemeExpansionTileThemeBuilder.expansionTileThemeExpansionTileTheme(data, child);
  }
  public static ExpansionTileThemeData of(BuildContextI context) {
    var st = factories.expansionTileThemeOf(context.build());
    if (st == null) throw new RuntimeException("Failed to created widget ExpansionTileThemeData");
    return new ExpansionTileThemeData(st);
  }
  public ExpansionTileThemeData data() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("expansionTileThemeData", getId());
      java.lang.foreign.MemorySegment __st = dev.equo.ewt.ffm.ExpansionTileThemeDataObjSt.allocate(__s.arena);
      dev.equo.ewt.ffm.ExpansionTileThemeDataObjSt.id(__st, __nid);
      return new ExpansionTileThemeData(__st);
    }
    return new ExpansionTileThemeData(ExpansionTileThemeObjSt.data(st));
  }
  @Override
  public ExpansionTileTheme build() {
    return this;
  }
}
