package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.CircularProgressIndicatorObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class CircularProgressIndicator extends ProgressIndicator implements CircularProgressIndicatorI {
  private MemorySegment st;
  protected CircularProgressIndicator() {}
  CircularProgressIndicator(MemorySegment st) {
    this.id = CircularProgressIndicatorObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget CircularProgressIndicator");
    System.out.println("New CircularProgressIndicator id:"+id);
  }
  @Builder.Factory
  static CircularProgressIndicator circularProgressIndicatorCircularProgressIndicator(OptionalDouble value, Optional<ColorI> backgroundColor, Optional<ColorI> color, Optional<AnimationI> valueColor, OptionalDouble strokeWidth, OptionalDouble strokeAlign, Optional<String> semanticsLabel, Optional<String> semanticsValue, Optional<StrokeCap> strokeCap, Optional<BoxConstraintsI> constraints, OptionalDouble trackGap, Optional<Boolean> year2023, Optional<EdgeInsetsGeometryI> padding, Optional<AnimationControllerI> controller) {
    var st = factories.circularProgressIndicatorCircularProgressIndicator(value,
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
    if (st == null) throw new RuntimeException("Failed to created widget CircularProgressIndicator");
    return new CircularProgressIndicator(st);
  }
  public static CircularProgressIndicatorCircularProgressIndicatorBuilder circularProgressIndicator() {
    return CircularProgressIndicatorCircularProgressIndicatorBuilder.circularProgressIndicatorCircularProgressIndicator();
  }
  @Builder.Factory
  static CircularProgressIndicator circularProgressIndicatorAdaptive(OptionalDouble value, Optional<ColorI> backgroundColor, Optional<AnimationI> valueColor, OptionalDouble strokeWidth, Optional<String> semanticsLabel, Optional<String> semanticsValue, Optional<StrokeCap> strokeCap, OptionalDouble strokeAlign, Optional<BoxConstraintsI> constraints, OptionalDouble trackGap, Optional<Boolean> year2023, Optional<EdgeInsetsGeometryI> padding, Optional<AnimationControllerI> controller) {
    var st = factories.circularProgressIndicatorAdaptive(value,
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
    if (st == null) throw new RuntimeException("Failed to created widget CircularProgressIndicator");
    return new CircularProgressIndicator(st);
  }
  public static CircularProgressIndicatorAdaptiveBuilder adaptive() {
    return CircularProgressIndicatorAdaptiveBuilder.circularProgressIndicatorAdaptive();
  }
  public double strokeWidth() {
    return CircularProgressIndicatorObjSt.strokeWidth(st);
  }
  public double strokeAlign() {
    return CircularProgressIndicatorObjSt.strokeAlign(st);
  }
  public StrokeCap strokeCap() {
    return StrokeCap.values()[CircularProgressIndicatorObjSt.strokeCap(st)];
  }
  public BoxConstraints constraints() {
    return new BoxConstraints(CircularProgressIndicatorObjSt.constraints(st));
  }
  public double trackGap() {
    return CircularProgressIndicatorObjSt.trackGap(st);
  }
  public boolean year2023() {
    return intToBool(CircularProgressIndicatorObjSt.year2023(st));
  }
  public EdgeInsetsGeometry padding() {
    return new EdgeInsetsGeometry(CircularProgressIndicatorObjSt.padding(st)) {};
  }
  public AnimationController controller() {
    return new AnimationController(CircularProgressIndicatorObjSt.controller(st));
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
    return Duration.duration().milliseconds(1333 * 2222).build();
  }
  @Override
  public CircularProgressIndicator build() {
    return this;
  }
}
