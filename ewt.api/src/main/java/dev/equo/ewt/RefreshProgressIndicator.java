package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class RefreshProgressIndicator extends CircularProgressIndicator implements RefreshProgressIndicatorI {
  protected RefreshProgressIndicator() {}
  RefreshProgressIndicator(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget RefreshProgressIndicator");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static RefreshProgressIndicator refreshProgressIndicatorRefreshProgressIndicator(OptionalDouble value, Optional<ColorI> backgroundColor, Optional<ColorI> color, Optional<AnimationI> valueColor, OptionalDouble strokeWidth, OptionalDouble strokeAlign, Optional<String> semanticsLabel, Optional<String> semanticsValue, Optional<StrokeCap> strokeCap, OptionalDouble elevation, Optional<EdgeInsetsGeometryI> indicatorMargin, Optional<EdgeInsetsGeometryI> indicatorPadding) {
    int id = factories.refreshProgressIndicatorRefreshProgressIndicator(value,
      backgroundColor.map(ColorI::build),
      color.map(ColorI::build),
      valueColor.map(AnimationI::build),
      strokeWidth,
      strokeAlign,
      semanticsLabel,
      semanticsValue,
      strokeCap,
      elevation,
      indicatorMargin.map(EdgeInsetsGeometryI::build),
      indicatorPadding.map(EdgeInsetsGeometryI::build));
    if (id <= 0) throw new RuntimeException("Failed to created widget RefreshProgressIndicator");
    return new RefreshProgressIndicator(id);
  }
  public static RefreshProgressIndicatorRefreshProgressIndicatorBuilder refreshProgressIndicator() {
    return RefreshProgressIndicatorRefreshProgressIndicatorBuilder.refreshProgressIndicatorRefreshProgressIndicator();
  }
  public double elevation() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("refreshProgressIndicatorElevation not supported on web");
    return factories.RefreshProgressIndicator_readBack_elevation(nativeStruct);
  }
  public EdgeInsetsGeometry indicatorMargin() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("refreshProgressIndicatorIndicatorMargin not supported on web");
    return factories.RefreshProgressIndicator_readBack_indicatorMargin(nativeStruct);
  }
  public EdgeInsetsGeometry indicatorPadding() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("refreshProgressIndicatorIndicatorPadding not supported on web");
    return factories.RefreshProgressIndicator_readBack_indicatorPadding(nativeStruct);
  }
  public static double defaultStrokeWidth() {
    return 2.5;
  }
  @Override
  public RefreshProgressIndicator build() {
    return this;
  }
}
