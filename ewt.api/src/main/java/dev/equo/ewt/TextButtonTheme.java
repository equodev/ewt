package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.TextButtonThemeObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class TextButtonTheme extends InheritedTheme implements TextButtonThemeI {
  private MemorySegment st;
  protected TextButtonTheme() {}
  TextButtonTheme(MemorySegment st) {
    this.id = TextButtonThemeObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget TextButtonTheme");
    System.out.println("New TextButtonTheme id:"+id);
  }
  TextButtonTheme(int id) { this.id = id; }
  @Builder.Factory
  static TextButtonTheme textButtonThemeTextButtonTheme(@Builder.Parameter TextButtonThemeDataI data, @Builder.Parameter WidgetI child) {
    var st = factories.textButtonThemeTextButtonTheme(data.build(),
      child.build());
    if (st == null) throw new RuntimeException("Failed to created widget TextButtonTheme");
    return new TextButtonTheme(st);
  }
  public static TextButtonThemeTextButtonThemeBuilder textButtonTheme(TextButtonThemeDataI data, WidgetI child) {
    return TextButtonThemeTextButtonThemeBuilder.textButtonThemeTextButtonTheme(data, child);
  }
  public static TextButtonThemeData of(BuildContextI context) {
    var st = factories.textButtonThemeOf(context.build());
    if (st == null) throw new RuntimeException("Failed to created widget TextButtonThemeData");
    return new TextButtonThemeData(st);
  }
  public TextButtonThemeData data() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("textButtonThemeData", getId());
      java.lang.foreign.MemorySegment __st = dev.equo.ewt.ffm.TextButtonThemeDataObjSt.allocate(__s.arena);
      dev.equo.ewt.ffm.TextButtonThemeDataObjSt.id(__st, __nid);
      return new TextButtonThemeData(__st);
    }
    return new TextButtonThemeData(TextButtonThemeObjSt.data(st));
  }
  @Override
  public TextButtonTheme build() {
    return this;
  }
}
