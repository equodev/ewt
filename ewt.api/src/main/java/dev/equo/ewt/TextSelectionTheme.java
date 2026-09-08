package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.TextSelectionThemeObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class TextSelectionTheme extends InheritedTheme implements TextSelectionThemeI {
  private MemorySegment st;
  protected TextSelectionTheme() {}
  TextSelectionTheme(MemorySegment st) {
    this.id = TextSelectionThemeObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget TextSelectionTheme");
    System.out.println("New TextSelectionTheme id:"+id);
  }
  TextSelectionTheme(int id) { this.id = id; }
  @Builder.Factory
  static TextSelectionTheme textSelectionThemeTextSelectionTheme(@Builder.Parameter TextSelectionThemeDataI data, @Builder.Parameter WidgetI child) {
    var st = factories.textSelectionThemeTextSelectionTheme(data.build(),
      child.build());
    if (st == null) throw new RuntimeException("Failed to created widget TextSelectionTheme");
    return new TextSelectionTheme(st);
  }
  public static TextSelectionThemeTextSelectionThemeBuilder textSelectionTheme(TextSelectionThemeDataI data, WidgetI child) {
    return TextSelectionThemeTextSelectionThemeBuilder.textSelectionThemeTextSelectionTheme(data, child);
  }
  public static TextSelectionThemeData of(BuildContextI context) {
    var st = factories.textSelectionThemeOf(context.build());
    if (st == null) throw new RuntimeException("Failed to created widget TextSelectionThemeData");
    return new TextSelectionThemeData(st);
  }
  public TextSelectionThemeData data() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("textSelectionThemeData", getId());
      java.lang.foreign.MemorySegment __st = dev.equo.ewt.ffm.TextSelectionThemeDataObjSt.allocate(__s.arena);
      dev.equo.ewt.ffm.TextSelectionThemeDataObjSt.id(__st, __nid);
      return new TextSelectionThemeData(__st);
    }
    return new TextSelectionThemeData(TextSelectionThemeObjSt.data(st));
  }
  @Override
  public TextSelectionTheme build() {
    return this;
  }
}
