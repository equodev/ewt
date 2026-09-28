package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class CircularProgressIndicator extends ProgressIndicator implements CircularProgressIndicatorI {
  protected CircularProgressIndicator() {}
  CircularProgressIndicator(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget CircularProgressIndicator");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static CircularProgressIndicator circularProgressIndicatorCircularProgressIndicator(OptionalDouble value, Optional<ColorI> backgroundColor, Optional<ColorI> color, Optional<AnimationI> valueColor, OptionalDouble strokeWidth, OptionalDouble strokeAlign, Optional<String> semanticsLabel, Optional<String> semanticsValue, Optional<StrokeCap> strokeCap, Optional<BoxConstraintsI> constraints, OptionalDouble trackGap, Optional<Boolean> year2023, Optional<EdgeInsetsGeometryI> padding, Optional<AnimationControllerI> controller) {
    int id = factories.circularProgressIndicatorCircularProgressIndicator(value,
      backgroundColor.map(ColorI::build),
      color.map(ColorI::build),
      valueColor.map(AnimationI::build),
      strokeWidth,
      strokeAlign,
      semanticsLabel,
      semanticsValue,
      strokeCap,
      constraints.map(BoxConstraintsI::build),
      trackGap,
      year2023,
      padding.map(EdgeInsetsGeometryI::build),
      controller.map(AnimationControllerI::build));
    if (id <= 0) throw new RuntimeException("Failed to created widget CircularProgressIndicator");
    return new CircularProgressIndicator(id);
  }
  public static CircularProgressIndicatorCircularProgressIndicatorBuilder circularProgressIndicator() {
    return CircularProgressIndicatorCircularProgressIndicatorBuilder.circularProgressIndicatorCircularProgressIndicator();
  }
  @Builder.Factory
  static CircularProgressIndicator circularProgressIndicatorAdaptive(OptionalDouble value, Optional<ColorI> backgroundColor, Optional<AnimationI> valueColor, OptionalDouble strokeWidth, Optional<String> semanticsLabel, Optional<String> semanticsValue, Optional<StrokeCap> strokeCap, OptionalDouble strokeAlign, Optional<BoxConstraintsI> constraints, OptionalDouble trackGap, Optional<Boolean> year2023, Optional<EdgeInsetsGeometryI> padding, Optional<AnimationControllerI> controller) {
    int id = factories.circularProgressIndicatorAdaptive(value,
      backgroundColor.map(ColorI::build),
      valueColor.map(AnimationI::build),
      strokeWidth,
      semanticsLabel,
      semanticsValue,
      strokeCap,
      strokeAlign,
      constraints.map(BoxConstraintsI::build),
      trackGap,
      year2023,
      padding.map(EdgeInsetsGeometryI::build),
      controller.map(AnimationControllerI::build));
    if (id <= 0) throw new RuntimeException("Failed to created widget CircularProgressIndicator");
    return new CircularProgressIndicator(id);
  }
  public static CircularProgressIndicatorAdaptiveBuilder adaptive() {
    return CircularProgressIndicatorAdaptiveBuilder.circularProgressIndicatorAdaptive();
  }
  public double strokeWidth() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("circularProgressIndicatorStrokeWidth not supported on web");
    return factories.CircularProgressIndicator_readBack_strokeWidth(nativeStruct);
  }
  public double strokeAlign() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("circularProgressIndicatorStrokeAlign not supported on web");
    return factories.CircularProgressIndicator_readBack_strokeAlign(nativeStruct);
  }
  public StrokeCap strokeCap() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("circularProgressIndicatorStrokeCap not supported on web");
    return factories.CircularProgressIndicator_readBack_strokeCap(nativeStruct);
  }
  public BoxConstraints constraints() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("circularProgressIndicatorConstraints", getId());
      return new BoxConstraints(__nid);
    }
    return factories.CircularProgressIndicator_readBack_constraints(nativeStruct);
  }
  public double trackGap() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("circularProgressIndicatorTrackGap not supported on web");
    return factories.CircularProgressIndicator_readBack_trackGap(nativeStruct);
  }
  public boolean year2023() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("circularProgressIndicatorYear2023 not supported on web");
    return factories.CircularProgressIndicator_readBack_year2023(nativeStruct);
  }
  public EdgeInsetsGeometry padding() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("circularProgressIndicatorPadding not supported on web");
    return factories.CircularProgressIndicator_readBack_padding(nativeStruct);
  }
  public AnimationController controller() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("circularProgressIndicatorController", getId());
      return new AnimationController(__nid);
    }
    return factories.CircularProgressIndicator_readBack_controller(nativeStruct);
  }
  public static double strokeAlignInside() {
    return -1.0;
  }
  public static double strokeAlignCenter() {
    return 0.0;
  }
  public static double strokeAlignOutside() {
    return 1.0;
  }
  public static Duration defaultAnimationDuration() {
    return Duration.duration().milliseconds(2961926).build();
  }
  @Override
  public CircularProgressIndicator build() {
    return this;
  }
}
