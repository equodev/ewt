package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.ProgressIndicatorThemeDataObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class ProgressIndicatorThemeData extends NativeObj.Base implements ProgressIndicatorThemeDataI {
  private MemorySegment st;
  protected ProgressIndicatorThemeData() {}
  ProgressIndicatorThemeData(MemorySegment st) {
    this.id = ProgressIndicatorThemeDataObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget ProgressIndicatorThemeData");
    System.out.println("New ProgressIndicatorThemeData id:"+id);
  }
  ProgressIndicatorThemeData(int id) { this.id = id; }
  @Builder.Factory
  static ProgressIndicatorThemeData progressIndicatorThemeDataProgressIndicatorThemeData(Optional<ColorI> color, Optional<ColorI> linearTrackColor, OptionalDouble linearMinHeight, Optional<ColorI> circularTrackColor, Optional<ColorI> refreshBackgroundColor, Optional<BorderRadiusGeometryI> borderRadius, Optional<ColorI> stopIndicatorColor, OptionalDouble stopIndicatorRadius, OptionalDouble strokeWidth, OptionalDouble strokeAlign, Optional<StrokeCap> strokeCap, Optional<BoxConstraintsI> constraints, OptionalDouble trackGap, Optional<EdgeInsetsGeometryI> circularTrackPadding, Optional<Boolean> year2023, Optional<AnimationControllerI> controller) {
    var st = factories.progressIndicatorThemeDataProgressIndicatorThemeData(color.map(ColorI::build),
      linearTrackColor.map(ColorI::build),
      linearMinHeight,
      circularTrackColor.map(ColorI::build),
      refreshBackgroundColor.map(ColorI::build),
      borderRadius.map(BorderRadiusGeometryI::build),
      stopIndicatorColor.map(ColorI::build),
      stopIndicatorRadius,
      strokeWidth,
      strokeAlign,
      strokeCap,
      constraints.map(BoxConstraintsI::build),
      trackGap,
      circularTrackPadding.map(EdgeInsetsGeometryI::build),
      year2023,
      controller.map(AnimationControllerI::build));
    if (st == null) throw new RuntimeException("Failed to created widget ProgressIndicatorThemeData");
    return new ProgressIndicatorThemeData(st);
  }
  public static ProgressIndicatorThemeDataProgressIndicatorThemeDataBuilder progressIndicatorThemeData() {
    return ProgressIndicatorThemeDataProgressIndicatorThemeDataBuilder.progressIndicatorThemeDataProgressIndicatorThemeData();
  }
  public static ProgressIndicatorThemeData lerp(ProgressIndicatorThemeDataI a, ProgressIndicatorThemeDataI b, double t) {
    var st = factories.progressIndicatorThemeDataLerp(a.build(),
      b.build(),
      t);
    if (st == null) throw new RuntimeException("Failed to created widget ProgressIndicatorThemeData");
    return new ProgressIndicatorThemeData(st);
  }
  public Color color() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("progressIndicatorThemeDataColor", getId());
      return new Color(__nid);
    }
    return new Color(ProgressIndicatorThemeDataObjSt.color(st));
  }
  public Color linearTrackColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("progressIndicatorThemeDataLinearTrackColor", getId());
      return new Color(__nid);
    }
    return new Color(ProgressIndicatorThemeDataObjSt.linearTrackColor(st));
  }
  public double linearMinHeight() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("progressIndicatorThemeDataLinearMinHeight not supported on web");
    return ProgressIndicatorThemeDataObjSt.linearMinHeight(st);
  }
  public Color circularTrackColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("progressIndicatorThemeDataCircularTrackColor", getId());
      return new Color(__nid);
    }
    return new Color(ProgressIndicatorThemeDataObjSt.circularTrackColor(st));
  }
  public Color refreshBackgroundColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("progressIndicatorThemeDataRefreshBackgroundColor", getId());
      return new Color(__nid);
    }
    return new Color(ProgressIndicatorThemeDataObjSt.refreshBackgroundColor(st));
  }
  public BorderRadiusGeometry borderRadius() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("progressIndicatorThemeDataBorderRadius not supported on web");
    return new BorderRadiusGeometry(ProgressIndicatorThemeDataObjSt.borderRadius(st)) {};
  }
  public Color stopIndicatorColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("progressIndicatorThemeDataStopIndicatorColor", getId());
      return new Color(__nid);
    }
    return new Color(ProgressIndicatorThemeDataObjSt.stopIndicatorColor(st));
  }
  public double stopIndicatorRadius() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("progressIndicatorThemeDataStopIndicatorRadius not supported on web");
    return ProgressIndicatorThemeDataObjSt.stopIndicatorRadius(st);
  }
  public double strokeWidth() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("progressIndicatorThemeDataStrokeWidth not supported on web");
    return ProgressIndicatorThemeDataObjSt.strokeWidth(st);
  }
  public double strokeAlign() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("progressIndicatorThemeDataStrokeAlign not supported on web");
    return ProgressIndicatorThemeDataObjSt.strokeAlign(st);
  }
  public StrokeCap strokeCap() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("progressIndicatorThemeDataStrokeCap not supported on web");
    return StrokeCap.values()[ProgressIndicatorThemeDataObjSt.strokeCap(st)];
  }
  public BoxConstraints constraints() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("progressIndicatorThemeDataConstraints", getId());
      java.lang.foreign.MemorySegment __st = dev.equo.ewt.ffm.BoxConstraintsObjSt.allocate(__s.arena);
      dev.equo.ewt.ffm.BoxConstraintsObjSt.id(__st, __nid);
      return new BoxConstraints(__st);
    }
    return new BoxConstraints(ProgressIndicatorThemeDataObjSt.constraints(st));
  }
  public double trackGap() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("progressIndicatorThemeDataTrackGap not supported on web");
    return ProgressIndicatorThemeDataObjSt.trackGap(st);
  }
  public EdgeInsetsGeometry circularTrackPadding() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("progressIndicatorThemeDataCircularTrackPadding not supported on web");
    return new EdgeInsetsGeometry(ProgressIndicatorThemeDataObjSt.circularTrackPadding(st)) {};
  }
  public boolean year2023() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("progressIndicatorThemeDataYear2023 not supported on web");
    return intToBool(ProgressIndicatorThemeDataObjSt.year2023(st));
  }
  public AnimationController controller() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("progressIndicatorThemeDataController", getId());
      return new AnimationController(__nid);
    }
    return new AnimationController(ProgressIndicatorThemeDataObjSt.controller(st));
  }
  @Override
  public ProgressIndicatorThemeData build() {
    return this;
  }
}
