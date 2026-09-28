package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class DialogTheme extends InheritedTheme implements DialogThemeI {
  protected DialogTheme() {}
  DialogTheme(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget DialogTheme");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static DialogTheme dialogThemeDialogTheme(Optional<ColorI> backgroundColor, OptionalDouble elevation, Optional<ColorI> shadowColor, Optional<ColorI> surfaceTintColor, Optional<ShapeBorderI> shape, Optional<AlignmentGeometryI> alignment, Optional<ColorI> iconColor, Optional<TextStyleI> titleTextStyle, Optional<TextStyleI> contentTextStyle, Optional<EdgeInsetsGeometryI> actionsPadding, Optional<ColorI> barrierColor, Optional<EdgeInsetsI> insetPadding, Optional<Clip> clipBehavior, Optional<DialogThemeDataI> data, Optional<WidgetI> child) {
    int id = factories.dialogThemeDialogTheme(backgroundColor.map(ColorI::build),
      elevation,
      shadowColor.map(ColorI::build),
      surfaceTintColor.map(ColorI::build),
      shape.map(ShapeBorderI::build),
      alignment.map(AlignmentGeometryI::build),
      iconColor.map(ColorI::build),
      titleTextStyle.map(TextStyleI::build),
      contentTextStyle.map(TextStyleI::build),
      actionsPadding.map(EdgeInsetsGeometryI::build),
      barrierColor.map(ColorI::build),
      insetPadding.map(EdgeInsetsI::build),
      clipBehavior,
      data.map(DialogThemeDataI::build),
      child.map(WidgetI::build));
    if (id <= 0) throw new RuntimeException("Failed to created widget DialogTheme");
    return new DialogTheme(id);
  }
  public static DialogThemeDialogThemeBuilder dialogTheme() {
    return DialogThemeDialogThemeBuilder.dialogThemeDialogTheme();
  }
  public static DialogThemeData of(BuildContextI context) {
    int id = factories.dialogThemeOf(context.build());
    if (id <= 0) throw new RuntimeException("Failed to created widget DialogThemeData");
    return new DialogThemeData(id);
  }
  public static DialogTheme lerp(DialogThemeI a, DialogThemeI b, double t) {
    int id = factories.dialogThemeLerp(a.build(),
      b.build(),
      t);
    if (id <= 0) throw new RuntimeException("Failed to created widget DialogTheme");
    return new DialogTheme(id);
  }
  public Color backgroundColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("dialogThemeBackgroundColor", getId());
      return new Color(__nid);
    }
    return factories.DialogTheme_readBack_backgroundColor(nativeStruct);
  }
  public double elevation() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("dialogThemeElevation not supported on web");
    return factories.DialogTheme_readBack_elevation(nativeStruct);
  }
  public Color shadowColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("dialogThemeShadowColor", getId());
      return new Color(__nid);
    }
    return factories.DialogTheme_readBack_shadowColor(nativeStruct);
  }
  public Color surfaceTintColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("dialogThemeSurfaceTintColor", getId());
      return new Color(__nid);
    }
    return factories.DialogTheme_readBack_surfaceTintColor(nativeStruct);
  }
  public ShapeBorder shape() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("dialogThemeShape not supported on web");
    return factories.DialogTheme_readBack_shape(nativeStruct);
  }
  public AlignmentGeometry alignment() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("dialogThemeAlignment not supported on web");
    return factories.DialogTheme_readBack_alignment(nativeStruct);
  }
  public TextStyle titleTextStyle() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("dialogThemeTitleTextStyle", getId());
      return new TextStyle(__nid);
    }
    return factories.DialogTheme_readBack_titleTextStyle(nativeStruct);
  }
  public TextStyle contentTextStyle() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("dialogThemeContentTextStyle", getId());
      return new TextStyle(__nid);
    }
    return factories.DialogTheme_readBack_contentTextStyle(nativeStruct);
  }
  public EdgeInsetsGeometry actionsPadding() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("dialogThemeActionsPadding not supported on web");
    return factories.DialogTheme_readBack_actionsPadding(nativeStruct);
  }
  public Color iconColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("dialogThemeIconColor", getId());
      return new Color(__nid);
    }
    return factories.DialogTheme_readBack_iconColor(nativeStruct);
  }
  public Color barrierColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("dialogThemeBarrierColor", getId());
      return new Color(__nid);
    }
    return factories.DialogTheme_readBack_barrierColor(nativeStruct);
  }
  public EdgeInsets insetPadding() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("dialogThemeInsetPadding", getId());
      return new EdgeInsets(__nid);
    }
    return factories.DialogTheme_readBack_insetPadding(nativeStruct);
  }
  public Clip clipBehavior() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("dialogThemeClipBehavior not supported on web");
    return factories.DialogTheme_readBack_clipBehavior(nativeStruct);
  }
  public DialogThemeData data() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("dialogThemeData", getId());
      return new DialogThemeData(__nid);
    }
    return factories.DialogTheme_readBack_data(nativeStruct);
  }
  @Override
  public DialogTheme build() {
    return this;
  }
}
