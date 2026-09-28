package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class TextTheme extends NativeObj.Base implements TextThemeI {
  protected TextTheme() {}
  TextTheme(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget TextTheme");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static TextTheme textThemeTextTheme(Optional<TextStyleI> displayLarge, Optional<TextStyleI> displayMedium, Optional<TextStyleI> displaySmall, Optional<TextStyleI> headlineLarge, Optional<TextStyleI> headlineMedium, Optional<TextStyleI> headlineSmall, Optional<TextStyleI> titleLarge, Optional<TextStyleI> titleMedium, Optional<TextStyleI> titleSmall, Optional<TextStyleI> bodyLarge, Optional<TextStyleI> bodyMedium, Optional<TextStyleI> bodySmall, Optional<TextStyleI> labelLarge, Optional<TextStyleI> labelMedium, Optional<TextStyleI> labelSmall) {
    int id = factories.textThemeTextTheme(displayLarge.map(TextStyleI::build),
      displayMedium.map(TextStyleI::build),
      displaySmall.map(TextStyleI::build),
      headlineLarge.map(TextStyleI::build),
      headlineMedium.map(TextStyleI::build),
      headlineSmall.map(TextStyleI::build),
      titleLarge.map(TextStyleI::build),
      titleMedium.map(TextStyleI::build),
      titleSmall.map(TextStyleI::build),
      bodyLarge.map(TextStyleI::build),
      bodyMedium.map(TextStyleI::build),
      bodySmall.map(TextStyleI::build),
      labelLarge.map(TextStyleI::build),
      labelMedium.map(TextStyleI::build),
      labelSmall.map(TextStyleI::build));
    if (id <= 0) throw new RuntimeException("Failed to created widget TextTheme");
    return new TextTheme(id);
  }
  public static TextThemeTextThemeBuilder textTheme() {
    return TextThemeTextThemeBuilder.textThemeTextTheme();
  }
  public static TextTheme lerp(TextThemeI a, TextThemeI b, double t) {
    int id = factories.textThemeLerp(a.build(),
      b.build(),
      t);
    if (id <= 0) throw new RuntimeException("Failed to created widget TextTheme");
    return new TextTheme(id);
  }
  public static TextTheme of(BuildContextI context) {
    int id = factories.textThemeOf(context.build());
    if (id <= 0) throw new RuntimeException("Failed to created widget TextTheme");
    return new TextTheme(id);
  }
  public static TextTheme primaryOf(BuildContextI context) {
    int id = factories.textThemePrimaryOf(context.build());
    if (id <= 0) throw new RuntimeException("Failed to created widget TextTheme");
    return new TextTheme(id);
  }
  public TextStyle displayLarge() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("textThemeDisplayLarge", getId());
      return new TextStyle(__nid);
    }
    return factories.TextTheme_readBack_displayLarge(nativeStruct);
  }
  public TextStyle displayMedium() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("textThemeDisplayMedium", getId());
      return new TextStyle(__nid);
    }
    return factories.TextTheme_readBack_displayMedium(nativeStruct);
  }
  public TextStyle displaySmall() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("textThemeDisplaySmall", getId());
      return new TextStyle(__nid);
    }
    return factories.TextTheme_readBack_displaySmall(nativeStruct);
  }
  public TextStyle headlineLarge() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("textThemeHeadlineLarge", getId());
      return new TextStyle(__nid);
    }
    return factories.TextTheme_readBack_headlineLarge(nativeStruct);
  }
  public TextStyle headlineMedium() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("textThemeHeadlineMedium", getId());
      return new TextStyle(__nid);
    }
    return factories.TextTheme_readBack_headlineMedium(nativeStruct);
  }
  public TextStyle headlineSmall() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("textThemeHeadlineSmall", getId());
      return new TextStyle(__nid);
    }
    return factories.TextTheme_readBack_headlineSmall(nativeStruct);
  }
  public TextStyle titleLarge() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("textThemeTitleLarge", getId());
      return new TextStyle(__nid);
    }
    return factories.TextTheme_readBack_titleLarge(nativeStruct);
  }
  public TextStyle titleMedium() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("textThemeTitleMedium", getId());
      return new TextStyle(__nid);
    }
    return factories.TextTheme_readBack_titleMedium(nativeStruct);
  }
  public TextStyle titleSmall() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("textThemeTitleSmall", getId());
      return new TextStyle(__nid);
    }
    return factories.TextTheme_readBack_titleSmall(nativeStruct);
  }
  public TextStyle bodyLarge() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("textThemeBodyLarge", getId());
      return new TextStyle(__nid);
    }
    return factories.TextTheme_readBack_bodyLarge(nativeStruct);
  }
  public TextStyle bodyMedium() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("textThemeBodyMedium", getId());
      return new TextStyle(__nid);
    }
    return factories.TextTheme_readBack_bodyMedium(nativeStruct);
  }
  public TextStyle bodySmall() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("textThemeBodySmall", getId());
      return new TextStyle(__nid);
    }
    return factories.TextTheme_readBack_bodySmall(nativeStruct);
  }
  public TextStyle labelLarge() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("textThemeLabelLarge", getId());
      return new TextStyle(__nid);
    }
    return factories.TextTheme_readBack_labelLarge(nativeStruct);
  }
  public TextStyle labelMedium() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("textThemeLabelMedium", getId());
      return new TextStyle(__nid);
    }
    return factories.TextTheme_readBack_labelMedium(nativeStruct);
  }
  public TextStyle labelSmall() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("textThemeLabelSmall", getId());
      return new TextStyle(__nid);
    }
    return factories.TextTheme_readBack_labelSmall(nativeStruct);
  }
  @Override
  public TextTheme build() {
    return this;
  }
}
