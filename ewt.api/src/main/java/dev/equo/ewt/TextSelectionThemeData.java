package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.TextSelectionThemeDataObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class TextSelectionThemeData extends NativeObj.Base implements TextSelectionThemeDataI {
  private MemorySegment st;
  protected TextSelectionThemeData() {}
  TextSelectionThemeData(MemorySegment st) {
    this.id = TextSelectionThemeDataObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget TextSelectionThemeData");
    System.out.println("New TextSelectionThemeData id:"+id);
  }
  TextSelectionThemeData(int id) { this.id = id; }
  @Builder.Factory
  static TextSelectionThemeData textSelectionThemeDataTextSelectionThemeData(Optional<ColorI> cursorColor, Optional<ColorI> selectionColor, Optional<ColorI> selectionHandleColor) {
    var st = factories.textSelectionThemeDataTextSelectionThemeData(cursorColor.map(ColorI::build),
      selectionColor.map(ColorI::build),
      selectionHandleColor.map(ColorI::build));
    if (st == null) throw new RuntimeException("Failed to created widget TextSelectionThemeData");
    return new TextSelectionThemeData(st);
  }
  public static TextSelectionThemeDataTextSelectionThemeDataBuilder textSelectionThemeData() {
    return TextSelectionThemeDataTextSelectionThemeDataBuilder.textSelectionThemeDataTextSelectionThemeData();
  }
  public static TextSelectionThemeData lerp(TextSelectionThemeDataI a, TextSelectionThemeDataI b, double t) {
    var st = factories.textSelectionThemeDataLerp(a.build(),
      b.build(),
      t);
    if (st == null) throw new RuntimeException("Failed to created widget TextSelectionThemeData");
    return new TextSelectionThemeData(st);
  }
  public Color cursorColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("textSelectionThemeDataCursorColor", getId());
      return new Color(__nid);
    }
    return new Color(TextSelectionThemeDataObjSt.cursorColor(st));
  }
  public Color selectionColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("textSelectionThemeDataSelectionColor", getId());
      return new Color(__nid);
    }
    return new Color(TextSelectionThemeDataObjSt.selectionColor(st));
  }
  public Color selectionHandleColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("textSelectionThemeDataSelectionHandleColor", getId());
      return new Color(__nid);
    }
    return new Color(TextSelectionThemeDataObjSt.selectionHandleColor(st));
  }
  @Override
  public TextSelectionThemeData build() {
    return this;
  }
}
