package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.CheckboxThemeObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class CheckboxTheme extends InheritedWidget implements CheckboxThemeI {
  private MemorySegment st;
  protected CheckboxTheme() {}
  CheckboxTheme(MemorySegment st) {
    this.id = CheckboxThemeObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget CheckboxTheme");
    System.out.println("New CheckboxTheme id:"+id);
  }
  CheckboxTheme(int id) { this.id = id; }
  @Builder.Factory
  static CheckboxTheme checkboxThemeCheckboxTheme(@Builder.Parameter CheckboxThemeDataI data, @Builder.Parameter WidgetI child) {
    var st = factories.checkboxThemeCheckboxTheme(data.build(),
      child.build());
    if (st == null) throw new RuntimeException("Failed to created widget CheckboxTheme");
    return new CheckboxTheme(st);
  }
  public static CheckboxThemeCheckboxThemeBuilder checkboxTheme(CheckboxThemeDataI data, WidgetI child) {
    return CheckboxThemeCheckboxThemeBuilder.checkboxThemeCheckboxTheme(data, child);
  }
  public static CheckboxThemeData of(BuildContextI context) {
    var st = factories.checkboxThemeOf(context.build());
    if (st == null) throw new RuntimeException("Failed to created widget CheckboxThemeData");
    return new CheckboxThemeData(st);
  }
  public CheckboxThemeData data() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("checkboxThemeData", getId());
      java.lang.foreign.MemorySegment __st = dev.equo.ewt.ffm.CheckboxThemeDataObjSt.allocate(__s.arena);
      dev.equo.ewt.ffm.CheckboxThemeDataObjSt.id(__st, __nid);
      return new CheckboxThemeData(__st);
    }
    return new CheckboxThemeData(CheckboxThemeObjSt.data(st));
  }
  @Override
  public CheckboxTheme build() {
    return this;
  }
}
