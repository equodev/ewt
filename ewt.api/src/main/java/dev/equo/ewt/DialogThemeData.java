package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.DialogThemeDataObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class DialogThemeData extends NativeObj.Base implements DialogThemeDataI {
  private MemorySegment st;
  protected DialogThemeData() {}
  DialogThemeData(MemorySegment st) {
    this.id = DialogThemeDataObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget DialogThemeData");
    System.out.println("New DialogThemeData id:"+id);
  }
  DialogThemeData(int id) { this.id = id; }
  @Builder.Factory
  static DialogThemeData dialogThemeDataDialogThemeData(Optional<ColorI> backgroundColor, OptionalDouble elevation, Optional<ColorI> shadowColor, Optional<ColorI> surfaceTintColor, Optional<ShapeBorderI> shape, Optional<AlignmentGeometryI> alignment, Optional<ColorI> iconColor, Optional<TextStyleI> titleTextStyle, Optional<TextStyleI> contentTextStyle, Optional<EdgeInsetsGeometryI> actionsPadding, Optional<ColorI> barrierColor, Optional<EdgeInsetsI> insetPadding, Optional<Clip> clipBehavior, Optional<BoxConstraintsI> constraints) {
    var st = factories.dialogThemeDataDialogThemeData(backgroundColor.map(ColorI::build),
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
    if (st == null) throw new RuntimeException("Failed to created widget DialogThemeData");
    return new DialogThemeData(st);
  }
  public static DialogThemeDataDialogThemeDataBuilder dialogThemeData() {
    return DialogThemeDataDialogThemeDataBuilder.dialogThemeDataDialogThemeData();
  }
  public static DialogThemeData lerp(DialogThemeDataI a, DialogThemeDataI b, double t) {
    var st = factories.dialogThemeDataLerp(a.build(),
      b.build(),
      t);
    if (st == null) throw new RuntimeException("Failed to created widget DialogThemeData");
    return new DialogThemeData(st);
  }
  public Color backgroundColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("dialogThemeDataBackgroundColor", getId());
      return new Color(__nid);
    }
    return new Color(DialogThemeDataObjSt.backgroundColor(st));
  }
  public double elevation() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("dialogThemeDataElevation not supported on web");
    return DialogThemeDataObjSt.elevation(st);
  }
  public Color shadowColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("dialogThemeDataShadowColor", getId());
      return new Color(__nid);
    }
    return new Color(DialogThemeDataObjSt.shadowColor(st));
  }
  public Color surfaceTintColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("dialogThemeDataSurfaceTintColor", getId());
      return new Color(__nid);
    }
    return new Color(DialogThemeDataObjSt.surfaceTintColor(st));
  }
  public ShapeBorder shape() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("dialogThemeDataShape not supported on web");
    return new ShapeBorder(DialogThemeDataObjSt.shape(st)) {};
  }
  public AlignmentGeometry alignment() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("dialogThemeDataAlignment not supported on web");
    return new AlignmentGeometry(DialogThemeDataObjSt.alignment(st)) {};
  }
  public TextStyle titleTextStyle() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("dialogThemeDataTitleTextStyle", getId());
      java.lang.foreign.MemorySegment __st = dev.equo.ewt.ffm.TextStyleObjSt.allocate(__s.arena);
      dev.equo.ewt.ffm.TextStyleObjSt.id(__st, __nid);
      return new TextStyle(__st);
    }
    return new TextStyle(DialogThemeDataObjSt.titleTextStyle(st));
  }
  public TextStyle contentTextStyle() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("dialogThemeDataContentTextStyle", getId());
      java.lang.foreign.MemorySegment __st = dev.equo.ewt.ffm.TextStyleObjSt.allocate(__s.arena);
      dev.equo.ewt.ffm.TextStyleObjSt.id(__st, __nid);
      return new TextStyle(__st);
    }
    return new TextStyle(DialogThemeDataObjSt.contentTextStyle(st));
  }
  public EdgeInsetsGeometry actionsPadding() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("dialogThemeDataActionsPadding not supported on web");
    return new EdgeInsetsGeometry(DialogThemeDataObjSt.actionsPadding(st)) {};
  }
  public Color iconColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("dialogThemeDataIconColor", getId());
      return new Color(__nid);
    }
    return new Color(DialogThemeDataObjSt.iconColor(st));
  }
  public Color barrierColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("dialogThemeDataBarrierColor", getId());
      return new Color(__nid);
    }
    return new Color(DialogThemeDataObjSt.barrierColor(st));
  }
  public EdgeInsets insetPadding() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("dialogThemeDataInsetPadding", getId());
      java.lang.foreign.MemorySegment __st = dev.equo.ewt.ffm.EdgeInsetsObjSt.allocate(__s.arena);
      dev.equo.ewt.ffm.EdgeInsetsObjSt.id(__st, __nid);
      return new EdgeInsets(__st);
    }
    return new EdgeInsets(DialogThemeDataObjSt.insetPadding(st));
  }
  public Clip clipBehavior() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("dialogThemeDataClipBehavior not supported on web");
    return Clip.values()[DialogThemeDataObjSt.clipBehavior(st)];
  }
  public BoxConstraints constraints() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("dialogThemeDataConstraints", getId());
      java.lang.foreign.MemorySegment __st = dev.equo.ewt.ffm.BoxConstraintsObjSt.allocate(__s.arena);
      dev.equo.ewt.ffm.BoxConstraintsObjSt.id(__st, __nid);
      return new BoxConstraints(__st);
    }
    return new BoxConstraints(DialogThemeDataObjSt.constraints(st));
  }
  @Override
  public DialogThemeData build() {
    return this;
  }
}
