package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class TextSelectionTheme extends InheritedTheme implements TextSelectionThemeI {
  protected TextSelectionTheme() {}
  TextSelectionTheme(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget TextSelectionTheme");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static TextSelectionTheme textSelectionThemeTextSelectionTheme(@Builder.Parameter TextSelectionThemeDataI data, @Builder.Parameter WidgetI child) {
    int id = factories.textSelectionThemeTextSelectionTheme(data.build(),
      child.build());
    if (id <= 0) throw new RuntimeException("Failed to created widget TextSelectionTheme");
    return new TextSelectionTheme(id);
  }
  public static TextSelectionThemeTextSelectionThemeBuilder textSelectionTheme(TextSelectionThemeDataI data, WidgetI child) {
    return TextSelectionThemeTextSelectionThemeBuilder.textSelectionThemeTextSelectionTheme(data, child);
  }
  public static TextSelectionThemeData of(BuildContextI context) {
    int id = factories.textSelectionThemeOf(context.build());
    if (id <= 0) throw new RuntimeException("Failed to created widget TextSelectionThemeData");
    return new TextSelectionThemeData(id);
  }
  public TextSelectionThemeData data() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("textSelectionThemeData", getId());
      return new TextSelectionThemeData(__nid);
    }
    return factories.TextSelectionTheme_readBack_data(nativeStruct);
  }
  @Override
  public TextSelectionTheme build() {
    return this;
  }
}
