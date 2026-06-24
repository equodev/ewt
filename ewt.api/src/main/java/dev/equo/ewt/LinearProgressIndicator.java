package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.LinearProgressIndicatorObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class LinearProgressIndicator extends ProgressIndicator implements LinearProgressIndicatorI {
  private MemorySegment st;
  protected LinearProgressIndicator() {}
  LinearProgressIndicator(MemorySegment st) {
    this.id = LinearProgressIndicatorObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget LinearProgressIndicator");
    System.out.println("New LinearProgressIndicator id:"+id);
  }
  @Builder.Factory
  static LinearProgressIndicator linearProgressIndicatorLinearProgressIndicator(OptionalDouble value, Optional<ColorI> backgroundColor, Optional<ColorI> color, Optional<AnimationI> valueColor, OptionalDouble minHeight, Optional<String> semanticsLabel, Optional<String> semanticsValue, Optional<BorderRadiusGeometryI> borderRadius, Optional<ColorI> stopIndicatorColor, OptionalDouble stopIndicatorRadius, OptionalDouble trackGap, Optional<Boolean> year2023, Optional<AnimationControllerI> controller) {
    var st = factories.linearProgressIndicatorLinearProgressIndicator(value,
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
    if (st == null) throw new RuntimeException("Failed to created widget LinearProgressIndicator");
    return new LinearProgressIndicator(st);
  }
  public static LinearProgressIndicatorLinearProgressIndicatorBuilder linearProgressIndicator() {
    return LinearProgressIndicatorLinearProgressIndicatorBuilder.linearProgressIndicatorLinearProgressIndicator();
  }
  public double minHeight() {
    return LinearProgressIndicatorObjSt.minHeight(st);
  }
  public BorderRadiusGeometry borderRadius() {
    return new BorderRadiusGeometry(LinearProgressIndicatorObjSt.borderRadius(st)) {};
  }
  public Color stopIndicatorColor() {
    return new Color(LinearProgressIndicatorObjSt.stopIndicatorColor(st));
  }
  public double stopIndicatorRadius() {
    return LinearProgressIndicatorObjSt.stopIndicatorRadius(st);
  }
  public double trackGap() {
    return LinearProgressIndicatorObjSt.trackGap(st);
  }
  public boolean year2023() {
    return intToBool(LinearProgressIndicatorObjSt.year2023(st));
  }
  public AnimationController controller() {
    return new AnimationController(LinearProgressIndicatorObjSt.controller(st));
  }
  public static Duration defaultAnimationDuration() {
    return Duration.duration().milliseconds(1800).build();
  }
  @Override
  public LinearProgressIndicator build() {
    return this;
  }
}
