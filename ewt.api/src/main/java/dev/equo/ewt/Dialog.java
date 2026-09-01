package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.DialogObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class Dialog extends StatelessWidget implements DialogI {
  private MemorySegment st;
  protected Dialog() {}
  Dialog(MemorySegment st) {
    this.id = DialogObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget Dialog");
    System.out.println("New Dialog id:"+id);
  }
  Dialog(int id) { this.id = id; }
  @Builder.Factory
  static Dialog dialogDialog(Optional<ColorI> backgroundColor, OptionalDouble elevation, Optional<ColorI> shadowColor, Optional<ColorI> surfaceTintColor, Optional<DurationI> insetAnimationDuration, Optional<CurveI> insetAnimationCurve, Optional<EdgeInsetsI> insetPadding, Optional<Clip> clipBehavior, Optional<ShapeBorderI> shape, Optional<AlignmentGeometryI> alignment, Optional<WidgetI> child, Optional<SemanticsRole> semanticsRole, Optional<BoxConstraintsI> constraints) {
    var st = factories.dialogDialog(backgroundColor.map(ColorI::build),
      elevation,
      shadowColor.map(ColorI::build),
      surfaceTintColor.map(ColorI::build),
      insetAnimationDuration.map(DurationI::build),
      insetAnimationCurve.map(CurveI::build),
      insetPadding.map(EdgeInsetsI::build),
      clipBehavior,
      shape.map(ShapeBorderI::build),
      alignment.map(AlignmentGeometryI::build),
      child.map(WidgetI::build),
      semanticsRole,
      constraints.map(BoxConstraintsI::build));
    if (st == null) throw new RuntimeException("Failed to created widget Dialog");
    return new Dialog(st);
  }
  public static DialogDialogBuilder dialog() {
    return DialogDialogBuilder.dialogDialog();
  }
  @Builder.Factory
  static Dialog dialogFullscreen(Optional<ColorI> backgroundColor, Optional<DurationI> insetAnimationDuration, Optional<CurveI> insetAnimationCurve, Optional<WidgetI> child, Optional<SemanticsRole> semanticsRole) {
    var st = factories.dialogFullscreen(backgroundColor.map(ColorI::build),
      insetAnimationDuration.map(DurationI::build),
      insetAnimationCurve.map(CurveI::build),
      child.map(WidgetI::build),
      semanticsRole);
    if (st == null) throw new RuntimeException("Failed to created widget Dialog");
    return new Dialog(st);
  }
  public static DialogFullscreenBuilder fullscreen() {
    return DialogFullscreenBuilder.dialogFullscreen();
  }
  public Color backgroundColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("dialogBackgroundColor", getId());
      return new Color(__nid);
    }
    return new Color(DialogObjSt.backgroundColor(st));
  }
  public double elevation() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("dialogElevation not supported on web");
    return DialogObjSt.elevation(st);
  }
  public Color shadowColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("dialogShadowColor", getId());
      return new Color(__nid);
    }
    return new Color(DialogObjSt.shadowColor(st));
  }
  public Color surfaceTintColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("dialogSurfaceTintColor", getId());
      return new Color(__nid);
    }
    return new Color(DialogObjSt.surfaceTintColor(st));
  }
  public Duration insetAnimationDuration() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("dialogInsetAnimationDuration", getId());
      return new Duration(__nid);
    }
    return new Duration(DialogObjSt.insetAnimationDuration(st));
  }
  public Curve insetAnimationCurve() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("dialogInsetAnimationCurve not supported on web");
    return new Curve(DialogObjSt.insetAnimationCurve(st)) {};
  }
  public EdgeInsets insetPadding() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("dialogInsetPadding", getId());
      java.lang.foreign.MemorySegment __st = dev.equo.ewt.ffm.EdgeInsetsObjSt.allocate(__s.arena);
      dev.equo.ewt.ffm.EdgeInsetsObjSt.id(__st, __nid);
      return new EdgeInsets(__st);
    }
    return new EdgeInsets(DialogObjSt.insetPadding(st));
  }
  public Clip clipBehavior() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("dialogClipBehavior not supported on web");
    return Clip.values()[DialogObjSt.clipBehavior(st)];
  }
  public ShapeBorder shape() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("dialogShape not supported on web");
    return new ShapeBorder(DialogObjSt.shape(st)) {};
  }
  public AlignmentGeometry alignment() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("dialogAlignment not supported on web");
    return new AlignmentGeometry(DialogObjSt.alignment(st)) {};
  }
  public Widget child() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("dialogChild not supported on web");
    return new Widget(DialogObjSt.child(st)) {};
  }
  public SemanticsRole semanticsRole() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("dialogSemanticsRole not supported on web");
    return SemanticsRole.values()[DialogObjSt.semanticsRole(st)];
  }
  public BoxConstraints constraints() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("dialogConstraints", getId());
      java.lang.foreign.MemorySegment __st = dev.equo.ewt.ffm.BoxConstraintsObjSt.allocate(__s.arena);
      dev.equo.ewt.ffm.BoxConstraintsObjSt.id(__st, __nid);
      return new BoxConstraints(__st);
    }
    return new BoxConstraints(DialogObjSt.constraints(st));
  }
  @Override
  public Dialog build() {
    return this;
  }
}
