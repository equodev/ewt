package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class TextButtonTheme extends InheritedTheme implements TextButtonThemeI {
  protected TextButtonTheme() {}
  TextButtonTheme(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget TextButtonTheme");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static TextButtonTheme textButtonThemeTextButtonTheme(@Builder.Parameter TextButtonThemeDataI data, @Builder.Parameter WidgetI child) {
    int id = factories.textButtonThemeTextButtonTheme(data.build(),
      child.build());
    if (id <= 0) throw new RuntimeException("Failed to created widget TextButtonTheme");
    return new TextButtonTheme(id);
  }
  public static TextButtonThemeTextButtonThemeBuilder textButtonTheme(TextButtonThemeDataI data, WidgetI child) {
    return TextButtonThemeTextButtonThemeBuilder.textButtonThemeTextButtonTheme(data, child);
  }
  public static TextButtonThemeData of(BuildContextI context) {
    int id = factories.textButtonThemeOf(context.build());
    if (id <= 0) throw new RuntimeException("Failed to created widget TextButtonThemeData");
    return new TextButtonThemeData(id);
  }
  public TextButtonThemeData data() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("textButtonThemeData", getId());
      return new TextButtonThemeData(__nid);
    }
    return factories.TextButtonTheme_readBack_data(nativeStruct);
  }
  @Override
  public TextButtonTheme build() {
    return this;
  }
}
