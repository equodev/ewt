package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class TextSelectionThemeData extends NativeObj.Base implements TextSelectionThemeDataI {
  protected TextSelectionThemeData() {}
  TextSelectionThemeData(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget TextSelectionThemeData");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static TextSelectionThemeData textSelectionThemeDataTextSelectionThemeData(Optional<ColorI> cursorColor, Optional<ColorI> selectionColor, Optional<ColorI> selectionHandleColor) {
    int id = factories.textSelectionThemeDataTextSelectionThemeData(cursorColor.map(ColorI::build),
      selectionColor.map(ColorI::build),
      selectionHandleColor.map(ColorI::build));
    if (id <= 0) throw new RuntimeException("Failed to created widget TextSelectionThemeData");
    return new TextSelectionThemeData(id);
  }
  public static TextSelectionThemeDataTextSelectionThemeDataBuilder textSelectionThemeData() {
    return TextSelectionThemeDataTextSelectionThemeDataBuilder.textSelectionThemeDataTextSelectionThemeData();
  }
  public static TextSelectionThemeData lerp(TextSelectionThemeDataI a, TextSelectionThemeDataI b, double t) {
    int id = factories.textSelectionThemeDataLerp(a.build(),
      b.build(),
      t);
    if (id <= 0) throw new RuntimeException("Failed to created widget TextSelectionThemeData");
    return new TextSelectionThemeData(id);
  }
  public Color cursorColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("textSelectionThemeDataCursorColor", getId());
      return new Color(__nid);
    }
    return factories.TextSelectionThemeData_readBack_cursorColor(nativeStruct);
  }
  public Color selectionColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("textSelectionThemeDataSelectionColor", getId());
      return new Color(__nid);
    }
    return factories.TextSelectionThemeData_readBack_selectionColor(nativeStruct);
  }
  public Color selectionHandleColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("textSelectionThemeDataSelectionHandleColor", getId());
      return new Color(__nid);
    }
    return factories.TextSelectionThemeData_readBack_selectionHandleColor(nativeStruct);
  }
  @Override
  public TextSelectionThemeData build() {
    return this;
  }
}
