package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class Dialog extends StatelessWidget implements DialogI {
  protected Dialog() {}
  Dialog(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget Dialog");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static Dialog dialogDialog(Optional<ColorI> backgroundColor, OptionalDouble elevation, Optional<ColorI> shadowColor, Optional<ColorI> surfaceTintColor, Optional<DurationI> insetAnimationDuration, Optional<CurveI> insetAnimationCurve, Optional<EdgeInsetsI> insetPadding, Optional<Clip> clipBehavior, Optional<ShapeBorderI> shape, Optional<AlignmentGeometryI> alignment, Optional<WidgetI> child, Optional<SemanticsRole> semanticsRole, Optional<BoxConstraintsI> constraints) {
    int id = factories.dialogDialog(backgroundColor.map(ColorI::build),
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
    if (id <= 0) throw new RuntimeException("Failed to created widget Dialog");
    return new Dialog(id);
  }
  public static DialogDialogBuilder dialog() {
    return DialogDialogBuilder.dialogDialog();
  }
  @Builder.Factory
  static Dialog dialogFullscreen(Optional<ColorI> backgroundColor, Optional<DurationI> insetAnimationDuration, Optional<CurveI> insetAnimationCurve, Optional<WidgetI> child, Optional<SemanticsRole> semanticsRole) {
    int id = factories.dialogFullscreen(backgroundColor.map(ColorI::build),
      insetAnimationDuration.map(DurationI::build),
      insetAnimationCurve.map(CurveI::build),
      child.map(WidgetI::build),
      semanticsRole);
    if (id <= 0) throw new RuntimeException("Failed to created widget Dialog");
    return new Dialog(id);
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
    return factories.Dialog_readBack_backgroundColor(nativeStruct);
  }
  public double elevation() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("dialogElevation not supported on web");
    return factories.Dialog_readBack_elevation(nativeStruct);
  }
  public Color shadowColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("dialogShadowColor", getId());
      return new Color(__nid);
    }
    return factories.Dialog_readBack_shadowColor(nativeStruct);
  }
  public Color surfaceTintColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("dialogSurfaceTintColor", getId());
      return new Color(__nid);
    }
    return factories.Dialog_readBack_surfaceTintColor(nativeStruct);
  }
  public Duration insetAnimationDuration() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("dialogInsetAnimationDuration", getId());
      return new Duration(__nid);
    }
    return factories.Dialog_readBack_insetAnimationDuration(nativeStruct);
  }
  public Curve insetAnimationCurve() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("dialogInsetAnimationCurve not supported on web");
    return factories.Dialog_readBack_insetAnimationCurve(nativeStruct);
  }
  public EdgeInsets insetPadding() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("dialogInsetPadding", getId());
      return new EdgeInsets(__nid);
    }
    return factories.Dialog_readBack_insetPadding(nativeStruct);
  }
  public Clip clipBehavior() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("dialogClipBehavior not supported on web");
    return factories.Dialog_readBack_clipBehavior(nativeStruct);
  }
  public ShapeBorder shape() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("dialogShape not supported on web");
    return factories.Dialog_readBack_shape(nativeStruct);
  }
  public AlignmentGeometry alignment() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("dialogAlignment not supported on web");
    return factories.Dialog_readBack_alignment(nativeStruct);
  }
  public Widget child() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("dialogChild not supported on web");
    return factories.Dialog_readBack_child(nativeStruct);
  }
  public SemanticsRole semanticsRole() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("dialogSemanticsRole not supported on web");
    return factories.Dialog_readBack_semanticsRole(nativeStruct);
  }
  public BoxConstraints constraints() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("dialogConstraints", getId());
      return new BoxConstraints(__nid);
    }
    return factories.Dialog_readBack_constraints(nativeStruct);
  }
  @Override
  public Dialog build() {
    return this;
  }
}
