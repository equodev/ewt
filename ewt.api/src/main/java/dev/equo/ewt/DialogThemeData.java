package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class DialogThemeData extends NativeObj.Base implements DialogThemeDataI {
  protected DialogThemeData() {}
  DialogThemeData(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget DialogThemeData");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static DialogThemeData dialogThemeDataDialogThemeData(Optional<ColorI> backgroundColor, OptionalDouble elevation, Optional<ColorI> shadowColor, Optional<ColorI> surfaceTintColor, Optional<ShapeBorderI> shape, Optional<AlignmentGeometryI> alignment, Optional<ColorI> iconColor, Optional<TextStyleI> titleTextStyle, Optional<TextStyleI> contentTextStyle, Optional<EdgeInsetsGeometryI> actionsPadding, Optional<ColorI> barrierColor, Optional<EdgeInsetsI> insetPadding, Optional<Clip> clipBehavior, Optional<BoxConstraintsI> constraints) {
    int id = factories.dialogThemeDataDialogThemeData(backgroundColor.map(ColorI::build),
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
      constraints.map(BoxConstraintsI::build));
    if (id <= 0) throw new RuntimeException("Failed to created widget DialogThemeData");
    return new DialogThemeData(id);
  }
  public static DialogThemeDataDialogThemeDataBuilder dialogThemeData() {
    return DialogThemeDataDialogThemeDataBuilder.dialogThemeDataDialogThemeData();
  }
  public static DialogThemeData lerp(DialogThemeDataI a, DialogThemeDataI b, double t) {
    int id = factories.dialogThemeDataLerp(a.build(),
      b.build(),
      t);
    if (id <= 0) throw new RuntimeException("Failed to created widget DialogThemeData");
    return new DialogThemeData(id);
  }
  public Color backgroundColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("dialogThemeDataBackgroundColor", getId());
      return new Color(__nid);
    }
    return factories.DialogThemeData_readBack_backgroundColor(nativeStruct);
  }
  public double elevation() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("dialogThemeDataElevation not supported on web");
    return factories.DialogThemeData_readBack_elevation(nativeStruct);
  }
  public Color shadowColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("dialogThemeDataShadowColor", getId());
      return new Color(__nid);
    }
    return factories.DialogThemeData_readBack_shadowColor(nativeStruct);
  }
  public Color surfaceTintColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("dialogThemeDataSurfaceTintColor", getId());
      return new Color(__nid);
    }
    return factories.DialogThemeData_readBack_surfaceTintColor(nativeStruct);
  }
  public ShapeBorder shape() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("dialogThemeDataShape not supported on web");
    return factories.DialogThemeData_readBack_shape(nativeStruct);
  }
  public AlignmentGeometry alignment() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("dialogThemeDataAlignment not supported on web");
    return factories.DialogThemeData_readBack_alignment(nativeStruct);
  }
  public TextStyle titleTextStyle() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("dialogThemeDataTitleTextStyle", getId());
      return new TextStyle(__nid);
    }
    return factories.DialogThemeData_readBack_titleTextStyle(nativeStruct);
  }
  public TextStyle contentTextStyle() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("dialogThemeDataContentTextStyle", getId());
      return new TextStyle(__nid);
    }
    return factories.DialogThemeData_readBack_contentTextStyle(nativeStruct);
  }
  public EdgeInsetsGeometry actionsPadding() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("dialogThemeDataActionsPadding not supported on web");
    return factories.DialogThemeData_readBack_actionsPadding(nativeStruct);
  }
  public Color iconColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("dialogThemeDataIconColor", getId());
      return new Color(__nid);
    }
    return factories.DialogThemeData_readBack_iconColor(nativeStruct);
  }
  public Color barrierColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("dialogThemeDataBarrierColor", getId());
      return new Color(__nid);
    }
    return factories.DialogThemeData_readBack_barrierColor(nativeStruct);
  }
  public EdgeInsets insetPadding() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("dialogThemeDataInsetPadding", getId());
      return new EdgeInsets(__nid);
    }
    return factories.DialogThemeData_readBack_insetPadding(nativeStruct);
  }
  public Clip clipBehavior() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("dialogThemeDataClipBehavior not supported on web");
    return factories.DialogThemeData_readBack_clipBehavior(nativeStruct);
  }
  public BoxConstraints constraints() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("dialogThemeDataConstraints", getId());
      return new BoxConstraints(__nid);
    }
    return factories.DialogThemeData_readBack_constraints(nativeStruct);
  }
  @Override
  public DialogThemeData build() {
    return this;
  }
}
