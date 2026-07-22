package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.AlertDialogObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class AlertDialog extends StatelessWidget implements AlertDialogI {
  private MemorySegment st;
  protected AlertDialog() {}
  AlertDialog(MemorySegment st) {
    this.id = AlertDialogObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget AlertDialog");
    System.out.println("New AlertDialog id:"+id);
  }
  @Builder.Factory
  static AlertDialog alertDialogAlertDialog(Optional<WidgetI> icon, Optional<EdgeInsetsGeometryI> iconPadding, Optional<ColorI> iconColor, Optional<WidgetI> title, Optional<EdgeInsetsGeometryI> titlePadding, Optional<TextStyleI> titleTextStyle, Optional<WidgetI> content, Optional<EdgeInsetsGeometryI> contentPadding, Optional<TextStyleI> contentTextStyle, Optional<List<WidgetI>> actions, Optional<EdgeInsetsGeometryI> actionsPadding, Optional<MainAxisAlignment> actionsAlignment, Optional<OverflowBarAlignment> actionsOverflowAlignment, Optional<VerticalDirection> actionsOverflowDirection, OptionalDouble actionsOverflowButtonSpacing, Optional<EdgeInsetsGeometryI> buttonPadding, Optional<ColorI> backgroundColor, OptionalDouble elevation, Optional<ColorI> shadowColor, Optional<ColorI> surfaceTintColor, Optional<String> semanticLabel, Optional<EdgeInsetsI> insetPadding, Optional<Clip> clipBehavior, Optional<ShapeBorderI> shape, Optional<AlignmentGeometryI> alignment, Optional<BoxConstraintsI> constraints, Optional<Boolean> scrollable) {
    var st = factories.alertDialogAlertDialog(icon.map(WidgetI::build),
      iconPadding.map(EdgeInsetsGeometryI::build),
      iconColor.map(ColorI::build),
      title.map(WidgetI::build),
      titlePadding.map(EdgeInsetsGeometryI::build),
      titleTextStyle.map(TextStyleI::build),
      content.map(WidgetI::build),
      contentPadding.map(EdgeInsetsGeometryI::build),
      contentTextStyle.map(TextStyleI::build),
      actions.map(i -> i.stream().map(WidgetI::build).toList()),
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
    if (st == null) throw new RuntimeException("Failed to created widget AlertDialog");
    return new AlertDialog(st);
  }
  public static AlertDialogAlertDialogBuilder alertDialog() {
    return AlertDialogAlertDialogBuilder.alertDialogAlertDialog();
  }
  @Builder.Factory
  static AlertDialog alertDialogAdaptive(Optional<WidgetI> icon, Optional<EdgeInsetsGeometryI> iconPadding, Optional<ColorI> iconColor, Optional<WidgetI> title, Optional<EdgeInsetsGeometryI> titlePadding, Optional<TextStyleI> titleTextStyle, Optional<WidgetI> content, Optional<EdgeInsetsGeometryI> contentPadding, Optional<TextStyleI> contentTextStyle, Optional<List<WidgetI>> actions, Optional<EdgeInsetsGeometryI> actionsPadding, Optional<MainAxisAlignment> actionsAlignment, Optional<OverflowBarAlignment> actionsOverflowAlignment, Optional<VerticalDirection> actionsOverflowDirection, OptionalDouble actionsOverflowButtonSpacing, Optional<EdgeInsetsGeometryI> buttonPadding, Optional<ColorI> backgroundColor, OptionalDouble elevation, Optional<ColorI> shadowColor, Optional<ColorI> surfaceTintColor, Optional<String> semanticLabel, Optional<EdgeInsetsI> insetPadding, Optional<Clip> clipBehavior, Optional<ShapeBorderI> shape, Optional<AlignmentGeometryI> alignment, Optional<BoxConstraintsI> constraints, Optional<Boolean> scrollable, Optional<DurationI> insetAnimationDuration, Optional<CurveI> insetAnimationCurve) {
    var st = factories.alertDialogAdaptive(icon.map(WidgetI::build),
      iconPadding.map(EdgeInsetsGeometryI::build),
      iconColor.map(ColorI::build),
      title.map(WidgetI::build),
      titlePadding.map(EdgeInsetsGeometryI::build),
      titleTextStyle.map(TextStyleI::build),
      content.map(WidgetI::build),
      contentPadding.map(EdgeInsetsGeometryI::build),
      contentTextStyle.map(TextStyleI::build),
      actions.map(i -> i.stream().map(WidgetI::build).toList()),
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
    if (st == null) throw new RuntimeException("Failed to created widget AlertDialog");
    return new AlertDialog(st);
  }
  public static AlertDialogAdaptiveBuilder adaptive() {
    return AlertDialogAdaptiveBuilder.alertDialogAdaptive();
  }
  public Widget icon() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("alertDialogIcon not supported on web");
    return new Widget(AlertDialogObjSt.icon(st)) {};
  }
  public Color iconColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("alertDialogIconColor", getId());
      return new Color(__nid);
    }
    return new Color(AlertDialogObjSt.iconColor(st));
  }
  public EdgeInsetsGeometry iconPadding() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("alertDialogIconPadding not supported on web");
    return new EdgeInsetsGeometry(AlertDialogObjSt.iconPadding(st)) {};
  }
  public Widget title() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("alertDialogTitle not supported on web");
    return new Widget(AlertDialogObjSt.title(st)) {};
  }
  public EdgeInsetsGeometry titlePadding() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("alertDialogTitlePadding not supported on web");
    return new EdgeInsetsGeometry(AlertDialogObjSt.titlePadding(st)) {};
  }
  public TextStyle titleTextStyle() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("alertDialogTitleTextStyle", getId());
      java.lang.foreign.MemorySegment __st = dev.equo.ewt.ffm.TextStyleObjSt.allocate(__s.arena);
      dev.equo.ewt.ffm.TextStyleObjSt.id(__st, __nid);
      return new TextStyle(__st);
    }
    return new TextStyle(AlertDialogObjSt.titleTextStyle(st));
  }
  public Widget content() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("alertDialogContent not supported on web");
    return new Widget(AlertDialogObjSt.content(st)) {};
  }
  public EdgeInsetsGeometry contentPadding() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("alertDialogContentPadding not supported on web");
    return new EdgeInsetsGeometry(AlertDialogObjSt.contentPadding(st)) {};
  }
  public TextStyle contentTextStyle() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("alertDialogContentTextStyle", getId());
      java.lang.foreign.MemorySegment __st = dev.equo.ewt.ffm.TextStyleObjSt.allocate(__s.arena);
      dev.equo.ewt.ffm.TextStyleObjSt.id(__st, __nid);
      return new TextStyle(__st);
    }
    return new TextStyle(AlertDialogObjSt.contentTextStyle(st));
  }
  public EdgeInsetsGeometry actionsPadding() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("alertDialogActionsPadding not supported on web");
    return new EdgeInsetsGeometry(AlertDialogObjSt.actionsPadding(st)) {};
  }
  public MainAxisAlignment actionsAlignment() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("alertDialogActionsAlignment not supported on web");
    return MainAxisAlignment.values()[AlertDialogObjSt.actionsAlignment(st)];
  }
  public OverflowBarAlignment actionsOverflowAlignment() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("alertDialogActionsOverflowAlignment not supported on web");
    return OverflowBarAlignment.values()[AlertDialogObjSt.actionsOverflowAlignment(st)];
  }
  public VerticalDirection actionsOverflowDirection() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("alertDialogActionsOverflowDirection not supported on web");
    return VerticalDirection.values()[AlertDialogObjSt.actionsOverflowDirection(st)];
  }
  public double actionsOverflowButtonSpacing() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("alertDialogActionsOverflowButtonSpacing not supported on web");
    return AlertDialogObjSt.actionsOverflowButtonSpacing(st);
  }
  public EdgeInsetsGeometry buttonPadding() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("alertDialogButtonPadding not supported on web");
    return new EdgeInsetsGeometry(AlertDialogObjSt.buttonPadding(st)) {};
  }
  public Color backgroundColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("alertDialogBackgroundColor", getId());
      return new Color(__nid);
    }
    return new Color(AlertDialogObjSt.backgroundColor(st));
  }
  public double elevation() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("alertDialogElevation not supported on web");
    return AlertDialogObjSt.elevation(st);
  }
  public Color shadowColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("alertDialogShadowColor", getId());
      return new Color(__nid);
    }
    return new Color(AlertDialogObjSt.shadowColor(st));
  }
  public Color surfaceTintColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("alertDialogSurfaceTintColor", getId());
      return new Color(__nid);
    }
    return new Color(AlertDialogObjSt.surfaceTintColor(st));
  }
  public String semanticLabel() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("alertDialogSemanticLabel not supported on web");
    return AlertDialogObjSt.semanticLabel(st).getString(0);
  }
  public EdgeInsets insetPadding() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("alertDialogInsetPadding", getId());
      java.lang.foreign.MemorySegment __st = dev.equo.ewt.ffm.EdgeInsetsObjSt.allocate(__s.arena);
      dev.equo.ewt.ffm.EdgeInsetsObjSt.id(__st, __nid);
      return new EdgeInsets(__st);
    }
    return new EdgeInsets(AlertDialogObjSt.insetPadding(st));
  }
  public Clip clipBehavior() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("alertDialogClipBehavior not supported on web");
    return Clip.values()[AlertDialogObjSt.clipBehavior(st)];
  }
  public ShapeBorder shape() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("alertDialogShape not supported on web");
    return new ShapeBorder(AlertDialogObjSt.shape(st)) {};
  }
  public AlignmentGeometry alignment() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("alertDialogAlignment not supported on web");
    return new AlignmentGeometry(AlertDialogObjSt.alignment(st)) {};
  }
  public BoxConstraints constraints() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("alertDialogConstraints", getId());
      java.lang.foreign.MemorySegment __st = dev.equo.ewt.ffm.BoxConstraintsObjSt.allocate(__s.arena);
      dev.equo.ewt.ffm.BoxConstraintsObjSt.id(__st, __nid);
      return new BoxConstraints(__st);
    }
    return new BoxConstraints(AlertDialogObjSt.constraints(st));
  }
  public boolean scrollable() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("alertDialogScrollable not supported on web");
    return intToBool(AlertDialogObjSt.scrollable(st));
  }
  @Override
  public AlertDialog build() {
    return this;
  }
}
