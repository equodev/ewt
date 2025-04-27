package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class AnimationController extends NativeObj.Base implements Animation<Double>, AnimationControllerI {
  protected AnimationController() {}
  AnimationController(int id) {
    this.id = id;
  }
  @Builder.Factory
  static AnimationController animationControllerAnimationController(OptionalDouble value, Optional<DurationI> duration, Optional<DurationI> reverseDuration, Optional<String> debugLabel, OptionalDouble lowerBound, OptionalDouble upperBound, Optional<AnimationBehavior> animationBehavior, TickerProviderI vsync) {
    int id = factories.animationControllerAnimationController(value,
      duration.map(DurationI::build),
      reverseDuration.map(DurationI::build),
      debugLabel,
      lowerBound,
      upperBound,
      animationBehavior,
      vsync.build());
    if (id == -1) throw new RuntimeException("Failed to created widget AnimationController");
    System.out.println("New AnimationController id:"+id);
    return new AnimationController(id);
  }
  public static AnimationControllerAnimationControllerBuilder animationController() {
    return AnimationControllerAnimationControllerBuilder.animationControllerAnimationController();
  }
  @Builder.Factory
  static AnimationController animationControllerUnbounded(OptionalDouble value, Optional<DurationI> duration, Optional<DurationI> reverseDuration, Optional<String> debugLabel, TickerProviderI vsync, Optional<AnimationBehavior> animationBehavior) {
    int id = factories.animationControllerUnbounded(value,
      duration.map(DurationI::build),
      reverseDuration.map(DurationI::build),
      debugLabel,
      vsync.build(),
      animationBehavior);
    if (id == -1) throw new RuntimeException("Failed to created widget AnimationController");
    System.out.println("New AnimationController id:"+id);
    return new AnimationController(id);
  }
  public static AnimationControllerUnboundedBuilder unbounded() {
    return AnimationControllerUnboundedBuilder.animationControllerUnbounded();
  }
  @Override
  public AnimationController build() {
    return this;
  }
}
