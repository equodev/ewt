package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.AnimatedWrapperObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class AnimatedWrapper extends StatefulWidget implements AnimatedWrapperI {
  private MemorySegment st;
  protected AnimatedWrapper() {}
  AnimatedWrapper(MemorySegment st) {
    this.id = AnimatedWrapperObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget AnimatedWrapper");
    System.out.println("New AnimatedWrapper id:"+id);
  }
  @Builder.Factory
  static AnimatedWrapper animatedWrapperAnimatedWrapper(@Builder.Parameter Consumer<Integer> initAnimationFn, @Builder.Parameter Supplier<Widget> buildAnimatedFn) {
    var st = factories.animatedWrapperAnimatedWrapper(initAnimationFn,
      buildAnimatedFn);
    if (st == null) throw new RuntimeException("Failed to created widget AnimatedWrapper");
    return new AnimatedWrapper(st);
  }
  public static AnimatedWrapperAnimatedWrapperBuilder animatedWrapper(Consumer<Integer> initAnimationFn, Supplier<Widget> buildAnimatedFn) {
    return AnimatedWrapperAnimatedWrapperBuilder.animatedWrapperAnimatedWrapper(initAnimationFn, buildAnimatedFn);
  }
  public static void forward(AnimationControllerI ctrl) {
    factories.animatedWrapperForward(ctrl.build());
  }
  public static void reverse(AnimationControllerI ctrl) {
    factories.animatedWrapperReverse(ctrl.build());
  }
  public static void stop(AnimationControllerI ctrl) {
    factories.animatedWrapperStop(ctrl.build());
  }
  public static void repeat(AnimationControllerI ctrl) {
    factories.animatedWrapperRepeat(ctrl.build());
  }
  public static void reset(AnimationControllerI ctrl) {
    factories.animatedWrapperReset(ctrl.build());
  }
  public static void setDuration(AnimationControllerI ctrl, DurationI d) {
    factories.animatedWrapperSetDuration(ctrl.build(),
      d.build());
  }
  public static void setReverseDuration(AnimationControllerI ctrl, DurationI d) {
    factories.animatedWrapperSetReverseDuration(ctrl.build(),
      d.build());
  }
  @Override
  public AnimatedWrapper build() {
    return this;
  }
}
