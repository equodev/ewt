package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.FilledButtonThemeObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class FilledButtonTheme extends InheritedTheme implements FilledButtonThemeI {
  private MemorySegment st;
  protected FilledButtonTheme() {}
  FilledButtonTheme(MemorySegment st) {
    this.id = FilledButtonThemeObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget FilledButtonTheme");
    System.out.println("New FilledButtonTheme id:"+id);
  }
  FilledButtonTheme(int id) { this.id = id; }
  @Builder.Factory
  static FilledButtonTheme filledButtonThemeFilledButtonTheme(@Builder.Parameter FilledButtonThemeDataI data, @Builder.Parameter WidgetI child) {
    var st = factories.filledButtonThemeFilledButtonTheme(data.build(),
      child.build());
    if (st == null) throw new RuntimeException("Failed to created widget FilledButtonTheme");
    return new FilledButtonTheme(st);
  }
  public static FilledButtonThemeFilledButtonThemeBuilder filledButtonTheme(FilledButtonThemeDataI data, WidgetI child) {
    return FilledButtonThemeFilledButtonThemeBuilder.filledButtonThemeFilledButtonTheme(data, child);
  }
  public static FilledButtonThemeData of(BuildContextI context) {
    var st = factories.filledButtonThemeOf(context.build());
    if (st == null) throw new RuntimeException("Failed to created widget FilledButtonThemeData");
    return new FilledButtonThemeData(st);
  }
  public FilledButtonThemeData data() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("filledButtonThemeData", getId());
      java.lang.foreign.MemorySegment __st = dev.equo.ewt.ffm.FilledButtonThemeDataObjSt.allocate(__s.arena);
      dev.equo.ewt.ffm.FilledButtonThemeDataObjSt.id(__st, __nid);
      return new FilledButtonThemeData(__st);
    }
    return new FilledButtonThemeData(FilledButtonThemeObjSt.data(st));
  }
  @Override
  public FilledButtonTheme build() {
    return this;
  }
}
