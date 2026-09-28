package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class AlertDialog extends StatelessWidget implements AlertDialogI {
  protected AlertDialog() {}
  AlertDialog(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget AlertDialog");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static AlertDialog alertDialogAlertDialog(Optional<WidgetI> icon, Optional<EdgeInsetsGeometryI> iconPadding, Optional<ColorI> iconColor, Optional<WidgetI> title, Optional<EdgeInsetsGeometryI> titlePadding, Optional<TextStyleI> titleTextStyle, Optional<WidgetI> content, Optional<EdgeInsetsGeometryI> contentPadding, Optional<TextStyleI> contentTextStyle, Optional<List<WidgetI>> actions, Optional<EdgeInsetsGeometryI> actionsPadding, Optional<MainAxisAlignment> actionsAlignment, Optional<OverflowBarAlignment> actionsOverflowAlignment, Optional<VerticalDirection> actionsOverflowDirection, OptionalDouble actionsOverflowButtonSpacing, Optional<EdgeInsetsGeometryI> buttonPadding, Optional<ColorI> backgroundColor, OptionalDouble elevation, Optional<ColorI> shadowColor, Optional<ColorI> surfaceTintColor, Optional<String> semanticLabel, Optional<EdgeInsetsI> insetPadding, Optional<Clip> clipBehavior, Optional<ShapeBorderI> shape, Optional<AlignmentGeometryI> alignment, Optional<BoxConstraintsI> constraints, Optional<Boolean> scrollable) {
    int id = factories.alertDialogAlertDialog(icon.map(WidgetI::build),
      iconPadding.map(EdgeInsetsGeometryI::build),
      iconColor.map(ColorI::build),
      title.map(WidgetI::build),
      titlePadding.map(EdgeInsetsGeometryI::build),
      titleTextStyle.map(TextStyleI::build),
      content.map(WidgetI::build),
      contentPadding.map(EdgeInsetsGeometryI::build),
      contentTextStyle.map(TextStyleI::build),
      actions.map(i -> i.stream().map(WidgetI::build).collect(java.util.stream.Collectors.toList())),
      actionsPadding.map(EdgeInsetsGeometryI::build),
      actionsAlignment,
      actionsOverflowAlignment,
      actionsOverflowDirection,
      actionsOverflowButtonSpacing,
      buttonPadding.map(EdgeInsetsGeometryI::build),
      backgroundColor.map(ColorI::build),
      elevation,
      shadowColor.map(ColorI::build),
      surfaceTintColor.map(ColorI::build),
      semanticLabel,
      insetPadding.map(EdgeInsetsI::build),
      clipBehavior,
      shape.map(ShapeBorderI::build),
      alignment.map(AlignmentGeometryI::build),
      constraints.map(BoxConstraintsI::build),
      scrollable);
    if (id <= 0) throw new RuntimeException("Failed to created widget AlertDialog");
    return new AlertDialog(id);
  }
  public static AlertDialogAlertDialogBuilder alertDialog() {
    return AlertDialogAlertDialogBuilder.alertDialogAlertDialog();
  }
  @Builder.Factory
  static AlertDialog alertDialogAdaptive(Optional<WidgetI> icon, Optional<EdgeInsetsGeometryI> iconPadding, Optional<ColorI> iconColor, Optional<WidgetI> title, Optional<EdgeInsetsGeometryI> titlePadding, Optional<TextStyleI> titleTextStyle, Optional<WidgetI> content, Optional<EdgeInsetsGeometryI> contentPadding, Optional<TextStyleI> contentTextStyle, Optional<List<WidgetI>> actions, Optional<EdgeInsetsGeometryI> actionsPadding, Optional<MainAxisAlignment> actionsAlignment, Optional<OverflowBarAlignment> actionsOverflowAlignment, Optional<VerticalDirection> actionsOverflowDirection, OptionalDouble actionsOverflowButtonSpacing, Optional<EdgeInsetsGeometryI> buttonPadding, Optional<ColorI> backgroundColor, OptionalDouble elevation, Optional<ColorI> shadowColor, Optional<ColorI> surfaceTintColor, Optional<String> semanticLabel, Optional<EdgeInsetsI> insetPadding, Optional<Clip> clipBehavior, Optional<ShapeBorderI> shape, Optional<AlignmentGeometryI> alignment, Optional<BoxConstraintsI> constraints, Optional<Boolean> scrollable, Optional<DurationI> insetAnimationDuration, Optional<CurveI> insetAnimationCurve) {
    int id = factories.alertDialogAdaptive(icon.map(WidgetI::build),
      iconPadding.map(EdgeInsetsGeometryI::build),
      iconColor.map(ColorI::build),
      title.map(WidgetI::build),
      titlePadding.map(EdgeInsetsGeometryI::build),
      titleTextStyle.map(TextStyleI::build),
      content.map(WidgetI::build),
      contentPadding.map(EdgeInsetsGeometryI::build),
      contentTextStyle.map(TextStyleI::build),
      actions.map(i -> i.stream().map(WidgetI::build).collect(java.util.stream.Collectors.toList())),
      actionsPadding.map(EdgeInsetsGeometryI::build),
      actionsAlignment,
      actionsOverflowAlignment,
      actionsOverflowDirection,
      actionsOverflowButtonSpacing,
      buttonPadding.map(EdgeInsetsGeometryI::build),
      backgroundColor.map(ColorI::build),
      elevation,
      shadowColor.map(ColorI::build),
      surfaceTintColor.map(ColorI::build),
      semanticLabel,
      insetPadding.map(EdgeInsetsI::build),
      clipBehavior,
      shape.map(ShapeBorderI::build),
      alignment.map(AlignmentGeometryI::build),
      constraints.map(BoxConstraintsI::build),
      scrollable,
      insetAnimationDuration.map(DurationI::build),
      insetAnimationCurve.map(CurveI::build));
    if (id <= 0) throw new RuntimeException("Failed to created widget AlertDialog");
    return new AlertDialog(id);
  }
  public static AlertDialogAdaptiveBuilder adaptive() {
    return AlertDialogAdaptiveBuilder.alertDialogAdaptive();
  }
  public Widget icon() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("alertDialogIcon not supported on web");
    return factories.AlertDialog_readBack_icon(nativeStruct);
  }
  public Color iconColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("alertDialogIconColor", getId());
      return new Color(__nid);
    }
    return factories.AlertDialog_readBack_iconColor(nativeStruct);
  }
  public EdgeInsetsGeometry iconPadding() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("alertDialogIconPadding not supported on web");
    return factories.AlertDialog_readBack_iconPadding(nativeStruct);
  }
  public Widget title() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("alertDialogTitle not supported on web");
    return factories.AlertDialog_readBack_title(nativeStruct);
  }
  public EdgeInsetsGeometry titlePadding() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("alertDialogTitlePadding not supported on web");
    return factories.AlertDialog_readBack_titlePadding(nativeStruct);
  }
  public TextStyle titleTextStyle() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("alertDialogTitleTextStyle", getId());
      return new TextStyle(__nid);
    }
    return factories.AlertDialog_readBack_titleTextStyle(nativeStruct);
  }
  public Widget content() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("alertDialogContent not supported on web");
    return factories.AlertDialog_readBack_content(nativeStruct);
  }
  public EdgeInsetsGeometry contentPadding() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("alertDialogContentPadding not supported on web");
    return factories.AlertDialog_readBack_contentPadding(nativeStruct);
  }
  public TextStyle contentTextStyle() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("alertDialogContentTextStyle", getId());
      return new TextStyle(__nid);
    }
    return factories.AlertDialog_readBack_contentTextStyle(nativeStruct);
  }
  public EdgeInsetsGeometry actionsPadding() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("alertDialogActionsPadding not supported on web");
    return factories.AlertDialog_readBack_actionsPadding(nativeStruct);
  }
  public MainAxisAlignment actionsAlignment() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("alertDialogActionsAlignment not supported on web");
    return factories.AlertDialog_readBack_actionsAlignment(nativeStruct);
  }
  public OverflowBarAlignment actionsOverflowAlignment() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("alertDialogActionsOverflowAlignment not supported on web");
    return factories.AlertDialog_readBack_actionsOverflowAlignment(nativeStruct);
  }
  public VerticalDirection actionsOverflowDirection() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("alertDialogActionsOverflowDirection not supported on web");
    return factories.AlertDialog_readBack_actionsOverflowDirection(nativeStruct);
  }
  public double actionsOverflowButtonSpacing() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("alertDialogActionsOverflowButtonSpacing not supported on web");
    return factories.AlertDialog_readBack_actionsOverflowButtonSpacing(nativeStruct);
  }
  public EdgeInsetsGeometry buttonPadding() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("alertDialogButtonPadding not supported on web");
    return factories.AlertDialog_readBack_buttonPadding(nativeStruct);
  }
  public Color backgroundColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("alertDialogBackgroundColor", getId());
      return new Color(__nid);
    }
    return factories.AlertDialog_readBack_backgroundColor(nativeStruct);
  }
  public double elevation() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("alertDialogElevation not supported on web");
    return factories.AlertDialog_readBack_elevation(nativeStruct);
  }
  public Color shadowColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("alertDialogShadowColor", getId());
      return new Color(__nid);
    }
    return factories.AlertDialog_readBack_shadowColor(nativeStruct);
  }
  public Color surfaceTintColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("alertDialogSurfaceTintColor", getId());
      return new Color(__nid);
    }
    return factories.AlertDialog_readBack_surfaceTintColor(nativeStruct);
  }
  public String semanticLabel() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("alertDialogSemanticLabel not supported on web");
    return factories.AlertDialog_readBack_semanticLabel(nativeStruct);
  }
  public EdgeInsets insetPadding() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("alertDialogInsetPadding", getId());
      return new EdgeInsets(__nid);
    }
    return factories.AlertDialog_readBack_insetPadding(nativeStruct);
  }
  public Clip clipBehavior() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("alertDialogClipBehavior not supported on web");
    return factories.AlertDialog_readBack_clipBehavior(nativeStruct);
  }
  public ShapeBorder shape() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("alertDialogShape not supported on web");
    return factories.AlertDialog_readBack_shape(nativeStruct);
  }
  public AlignmentGeometry alignment() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("alertDialogAlignment not supported on web");
    return factories.AlertDialog_readBack_alignment(nativeStruct);
  }
  public BoxConstraints constraints() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("alertDialogConstraints", getId());
      return new BoxConstraints(__nid);
    }
    return factories.AlertDialog_readBack_constraints(nativeStruct);
  }
  public boolean scrollable() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("alertDialogScrollable not supported on web");
    return factories.AlertDialog_readBack_scrollable(nativeStruct);
  }
  @Override
  public AlertDialog build() {
    return this;
  }
}
