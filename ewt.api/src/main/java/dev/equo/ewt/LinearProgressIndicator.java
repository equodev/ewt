package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class LinearProgressIndicator extends ProgressIndicator implements LinearProgressIndicatorI {
  protected LinearProgressIndicator() {}
  LinearProgressIndicator(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget LinearProgressIndicator");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static LinearProgressIndicator linearProgressIndicatorLinearProgressIndicator(OptionalDouble value, Optional<ColorI> backgroundColor, Optional<ColorI> color, Optional<AnimationI> valueColor, OptionalDouble minHeight, Optional<String> semanticsLabel, Optional<String> semanticsValue, Optional<BorderRadiusGeometryI> borderRadius, Optional<ColorI> stopIndicatorColor, OptionalDouble stopIndicatorRadius, OptionalDouble trackGap, Optional<Boolean> year2023, Optional<AnimationControllerI> controller) {
    int id = factories.linearProgressIndicatorLinearProgressIndicator(value,
      backgroundColor.map(ColorI::build),
      color.map(ColorI::build),
      valueColor.map(AnimationI::build),
      minHeight,
      semanticsLabel,
      semanticsValue,
      borderRadius.map(BorderRadiusGeometryI::build),
      stopIndicatorColor.map(ColorI::build),
      stopIndicatorRadius,
      trackGap,
      year2023,
      controller.map(AnimationControllerI::build));
    if (id <= 0) throw new RuntimeException("Failed to created widget LinearProgressIndicator");
    return new LinearProgressIndicator(id);
  }
  public static LinearProgressIndicatorLinearProgressIndicatorBuilder linearProgressIndicator() {
    return LinearProgressIndicatorLinearProgressIndicatorBuilder.linearProgressIndicatorLinearProgressIndicator();
  }
  public double minHeight() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("linearProgressIndicatorMinHeight not supported on web");
    return factories.LinearProgressIndicator_readBack_minHeight(nativeStruct);
  }
  public BorderRadiusGeometry borderRadius() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("linearProgressIndicatorBorderRadius not supported on web");
    return factories.LinearProgressIndicator_readBack_borderRadius(nativeStruct);
  }
  public Color stopIndicatorColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("linearProgressIndicatorStopIndicatorColor", getId());
      return new Color(__nid);
    }
    return factories.LinearProgressIndicator_readBack_stopIndicatorColor(nativeStruct);
  }
  public double stopIndicatorRadius() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("linearProgressIndicatorStopIndicatorRadius not supported on web");
    return factories.LinearProgressIndicator_readBack_stopIndicatorRadius(nativeStruct);
  }
  public double trackGap() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("linearProgressIndicatorTrackGap not supported on web");
    return factories.LinearProgressIndicator_readBack_trackGap(nativeStruct);
  }
  public boolean year2023() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("linearProgressIndicatorYear2023 not supported on web");
    return factories.LinearProgressIndicator_readBack_year2023(nativeStruct);
  }
  public AnimationController controller() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("linearProgressIndicatorController", getId());
      return new AnimationController(__nid);
    }
    return factories.LinearProgressIndicator_readBack_controller(nativeStruct);
  }
  public static Duration defaultAnimationDuration() {
    return Duration.duration().milliseconds(1800).build();
  }
  @Override
  public LinearProgressIndicator build() {
    return this;
  }
}
