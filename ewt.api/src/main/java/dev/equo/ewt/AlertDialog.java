package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
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
    System.out.println("New AlertDialog id:"+id);
  }
  @Builder.Factory
  static AlertDialog alertDialogAlertDialog(Optional<WidgetI> icon, Optional<EdgeInsetsGeometryI> iconPadding, Optional<ColorI> iconColor, Optional<WidgetI> title, Optional<EdgeInsetsGeometryI> titlePadding, Optional<TextStyleI> titleTextStyle, Optional<WidgetI> content, Optional<EdgeInsetsGeometryI> contentPadding, Optional<TextStyleI> contentTextStyle, Optional<List<WidgetI>> actions, Optional<EdgeInsetsGeometryI> actionsPadding, Optional<MainAxisAlignment> actionsAlignment, Optional<OverflowBarAlignment> actionsOverflowAlignment, Optional<VerticalDirection> actionsOverflowDirection, OptionalDouble actionsOverflowButtonSpacing, Optional<EdgeInsetsGeometryI> buttonPadding, Optional<ColorI> backgroundColor, OptionalDouble elevation, Optional<ColorI> shadowColor, Optional<ColorI> surfaceTintColor, Optional<String> semanticLabel, Optional<EdgeInsetsI> insetPadding, Optional<Clip> clipBehavior, Optional<ShapeBorderI> shape, Optional<AlignmentGeometryI> alignment, Optional<Boolean> scrollable) {
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
      scrollable);
    if (st == null) throw new RuntimeException("Failed to created widget AlertDialog");
    return new AlertDialog(st);
  }
  public static AlertDialogAlertDialogBuilder alertDialog() {
    return AlertDialogAlertDialogBuilder.alertDialogAlertDialog();
  }
  @Builder.Factory
  static AlertDialog alertDialogAdaptive(Optional<WidgetI> icon, Optional<EdgeInsetsGeometryI> iconPadding, Optional<ColorI> iconColor, Optional<WidgetI> title, Optional<EdgeInsetsGeometryI> titlePadding, Optional<TextStyleI> titleTextStyle, Optional<WidgetI> content, Optional<EdgeInsetsGeometryI> contentPadding, Optional<TextStyleI> contentTextStyle, Optional<List<WidgetI>> actions, Optional<EdgeInsetsGeometryI> actionsPadding, Optional<MainAxisAlignment> actionsAlignment, Optional<OverflowBarAlignment> actionsOverflowAlignment, Optional<VerticalDirection> actionsOverflowDirection, OptionalDouble actionsOverflowButtonSpacing, Optional<EdgeInsetsGeometryI> buttonPadding, Optional<ColorI> backgroundColor, OptionalDouble elevation, Optional<ColorI> shadowColor, Optional<ColorI> surfaceTintColor, Optional<String> semanticLabel, Optional<EdgeInsetsI> insetPadding, Optional<Clip> clipBehavior, Optional<ShapeBorderI> shape, Optional<AlignmentGeometryI> alignment, Optional<Boolean> scrollable, Optional<DurationI> insetAnimationDuration, Optional<CurveI> insetAnimationCurve) {
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
    return new Widget(AlertDialogObjSt.icon(st)) {};
  }
  public Color iconColor() {
    return new Color(AlertDialogObjSt.iconColor(st));
  }
  public EdgeInsetsGeometry iconPadding() {
    return new EdgeInsetsGeometry(AlertDialogObjSt.iconPadding(st)) {};
  }
  public Widget title() {
    return new Widget(AlertDialogObjSt.title(st)) {};
  }
  public EdgeInsetsGeometry titlePadding() {
    return new EdgeInsetsGeometry(AlertDialogObjSt.titlePadding(st)) {};
  }
  public TextStyle titleTextStyle() {
    return new TextStyle(AlertDialogObjSt.titleTextStyle(st));
  }
  public Widget content() {
    return new Widget(AlertDialogObjSt.content(st)) {};
  }
  public EdgeInsetsGeometry contentPadding() {
    return new EdgeInsetsGeometry(AlertDialogObjSt.contentPadding(st)) {};
  }
  public TextStyle contentTextStyle() {
    return new TextStyle(AlertDialogObjSt.contentTextStyle(st));
  }
  public EdgeInsetsGeometry actionsPadding() {
    return new EdgeInsetsGeometry(AlertDialogObjSt.actionsPadding(st)) {};
  }
  public MainAxisAlignment actionsAlignment() {
    return MainAxisAlignment.values()[AlertDialogObjSt.actionsAlignment(st)];
  }
  public OverflowBarAlignment actionsOverflowAlignment() {
    return OverflowBarAlignment.values()[AlertDialogObjSt.actionsOverflowAlignment(st)];
  }
  public VerticalDirection actionsOverflowDirection() {
    return VerticalDirection.values()[AlertDialogObjSt.actionsOverflowDirection(st)];
  }
  public double actionsOverflowButtonSpacing() {
    return AlertDialogObjSt.actionsOverflowButtonSpacing(st);
  }
  public EdgeInsetsGeometry buttonPadding() {
    return new EdgeInsetsGeometry(AlertDialogObjSt.buttonPadding(st)) {};
  }
  public Color backgroundColor() {
    return new Color(AlertDialogObjSt.backgroundColor(st));
  }
  public double elevation() {
    return AlertDialogObjSt.elevation(st);
  }
  public Color shadowColor() {
    return new Color(AlertDialogObjSt.shadowColor(st));
  }
  public Color surfaceTintColor() {
    return new Color(AlertDialogObjSt.surfaceTintColor(st));
  }
  public String semanticLabel() {
    return AlertDialogObjSt.semanticLabel(st).getString(0);
  }
  public EdgeInsets insetPadding() {
    return new EdgeInsets(AlertDialogObjSt.insetPadding(st));
  }
  public Clip clipBehavior() {
    return Clip.values()[AlertDialogObjSt.clipBehavior(st)];
  }
  public ShapeBorder shape() {
    return new ShapeBorder(AlertDialogObjSt.shape(st)) {};
  }
  public AlignmentGeometry alignment() {
    return new AlignmentGeometry(AlertDialogObjSt.alignment(st)) {};
  }
  public boolean scrollable() {
    return intToBool(AlertDialogObjSt.scrollable(st));
  }
  @Override
  public AlertDialog build() {
    return this;
  }
}
