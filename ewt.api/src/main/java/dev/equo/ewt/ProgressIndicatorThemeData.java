package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class ProgressIndicatorThemeData extends NativeObj.Base implements ProgressIndicatorThemeDataI {
  protected ProgressIndicatorThemeData() {}
  ProgressIndicatorThemeData(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget ProgressIndicatorThemeData");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static ProgressIndicatorThemeData progressIndicatorThemeDataProgressIndicatorThemeData(Optional<ColorI> color, Optional<ColorI> linearTrackColor, OptionalDouble linearMinHeight, Optional<ColorI> circularTrackColor, Optional<ColorI> refreshBackgroundColor, Optional<BorderRadiusGeometryI> borderRadius, Optional<ColorI> stopIndicatorColor, OptionalDouble stopIndicatorRadius, OptionalDouble strokeWidth, OptionalDouble strokeAlign, Optional<StrokeCap> strokeCap, Optional<BoxConstraintsI> constraints, OptionalDouble trackGap, Optional<EdgeInsetsGeometryI> circularTrackPadding, Optional<Boolean> year2023, Optional<AnimationControllerI> controller) {
    int id = factories.progressIndicatorThemeDataProgressIndicatorThemeData(color.map(ColorI::build),
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
    if (id <= 0) throw new RuntimeException("Failed to created widget ProgressIndicatorThemeData");
    return new ProgressIndicatorThemeData(id);
  }
  public static ProgressIndicatorThemeDataProgressIndicatorThemeDataBuilder progressIndicatorThemeData() {
    return ProgressIndicatorThemeDataProgressIndicatorThemeDataBuilder.progressIndicatorThemeDataProgressIndicatorThemeData();
  }
  public static ProgressIndicatorThemeData lerp(ProgressIndicatorThemeDataI a, ProgressIndicatorThemeDataI b, double t) {
    int id = factories.progressIndicatorThemeDataLerp(a.build(),
      b.build(),
      t);
    if (id <= 0) throw new RuntimeException("Failed to created widget ProgressIndicatorThemeData");
    return new ProgressIndicatorThemeData(id);
  }
  public Color color() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("progressIndicatorThemeDataColor", getId());
      return new Color(__nid);
    }
    return factories.ProgressIndicatorThemeData_readBack_color(nativeStruct);
  }
  public Color linearTrackColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("progressIndicatorThemeDataLinearTrackColor", getId());
      return new Color(__nid);
    }
    return factories.ProgressIndicatorThemeData_readBack_linearTrackColor(nativeStruct);
  }
  public double linearMinHeight() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("progressIndicatorThemeDataLinearMinHeight not supported on web");
    return factories.ProgressIndicatorThemeData_readBack_linearMinHeight(nativeStruct);
  }
  public Color circularTrackColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("progressIndicatorThemeDataCircularTrackColor", getId());
      return new Color(__nid);
    }
    return factories.ProgressIndicatorThemeData_readBack_circularTrackColor(nativeStruct);
  }
  public Color refreshBackgroundColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("progressIndicatorThemeDataRefreshBackgroundColor", getId());
      return new Color(__nid);
    }
    return factories.ProgressIndicatorThemeData_readBack_refreshBackgroundColor(nativeStruct);
  }
  public BorderRadiusGeometry borderRadius() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("progressIndicatorThemeDataBorderRadius not supported on web");
    return factories.ProgressIndicatorThemeData_readBack_borderRadius(nativeStruct);
  }
  public Color stopIndicatorColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("progressIndicatorThemeDataStopIndicatorColor", getId());
      return new Color(__nid);
    }
    return factories.ProgressIndicatorThemeData_readBack_stopIndicatorColor(nativeStruct);
  }
  public double stopIndicatorRadius() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("progressIndicatorThemeDataStopIndicatorRadius not supported on web");
    return factories.ProgressIndicatorThemeData_readBack_stopIndicatorRadius(nativeStruct);
  }
  public double strokeWidth() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("progressIndicatorThemeDataStrokeWidth not supported on web");
    return factories.ProgressIndicatorThemeData_readBack_strokeWidth(nativeStruct);
  }
  public double strokeAlign() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("progressIndicatorThemeDataStrokeAlign not supported on web");
    return factories.ProgressIndicatorThemeData_readBack_strokeAlign(nativeStruct);
  }
  public StrokeCap strokeCap() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("progressIndicatorThemeDataStrokeCap not supported on web");
    return factories.ProgressIndicatorThemeData_readBack_strokeCap(nativeStruct);
  }
  public BoxConstraints constraints() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("progressIndicatorThemeDataConstraints", getId());
      return new BoxConstraints(__nid);
    }
    return factories.ProgressIndicatorThemeData_readBack_constraints(nativeStruct);
  }
  public double trackGap() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("progressIndicatorThemeDataTrackGap not supported on web");
    return factories.ProgressIndicatorThemeData_readBack_trackGap(nativeStruct);
  }
  public EdgeInsetsGeometry circularTrackPadding() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("progressIndicatorThemeDataCircularTrackPadding not supported on web");
    return factories.ProgressIndicatorThemeData_readBack_circularTrackPadding(nativeStruct);
  }
  public boolean year2023() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("progressIndicatorThemeDataYear2023 not supported on web");
    return factories.ProgressIndicatorThemeData_readBack_year2023(nativeStruct);
  }
  public AnimationController controller() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("progressIndicatorThemeDataController", getId());
      return new AnimationController(__nid);
    }
    return factories.ProgressIndicatorThemeData_readBack_controller(nativeStruct);
  }
  @Override
  public ProgressIndicatorThemeData build() {
    return this;
  }
}
