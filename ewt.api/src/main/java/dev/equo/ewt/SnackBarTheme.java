package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.SnackBarThemeObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class SnackBarTheme extends InheritedTheme implements SnackBarThemeI {
  private MemorySegment st;
  protected SnackBarTheme() {}
  SnackBarTheme(MemorySegment st) {
    this.id = SnackBarThemeObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget SnackBarTheme");
    System.out.println("New SnackBarTheme id:"+id);
  }
  SnackBarTheme(int id) { this.id = id; }
  @Builder.Factory
  static SnackBarTheme snackBarThemeSnackBarTheme(@Builder.Parameter SnackBarThemeDataI data, @Builder.Parameter WidgetI child) {
    var st = factories.snackBarThemeSnackBarTheme(data.build(),
      child.build());
    if (st == null) throw new RuntimeException("Failed to created widget SnackBarTheme");
    return new SnackBarTheme(st);
  }
  public static SnackBarThemeSnackBarThemeBuilder snackBarTheme(SnackBarThemeDataI data, WidgetI child) {
    return SnackBarThemeSnackBarThemeBuilder.snackBarThemeSnackBarTheme(data, child);
  }
  public static SnackBarThemeData of(BuildContextI context) {
    var st = factories.snackBarThemeOf(context.build());
    if (st == null) throw new RuntimeException("Failed to created widget SnackBarThemeData");
    return new SnackBarThemeData(st);
  }
  public SnackBarThemeData data() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("snackBarThemeData", getId());
      java.lang.foreign.MemorySegment __st = dev.equo.ewt.ffm.SnackBarThemeDataObjSt.allocate(__s.arena);
      dev.equo.ewt.ffm.SnackBarThemeDataObjSt.id(__st, __nid);
      return new SnackBarThemeData(__st);
    }
    return new SnackBarThemeData(SnackBarThemeObjSt.data(st));
  }
  @Override
  public SnackBarTheme build() {
    return this;
  }
}
