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
  /** Set in web mode by SubAnimatedState.animationController() so commands can route back. */
  private SubAnimatedState<?> webOwner;
  void setWebOwner(SubAnimatedState<?> owner) { this.webOwner = owner; }
  private void webCommand(String action) {
    if (webOwner != null) webOwner.sendAnimCommand(this.id, action);
    else System.out.println("EWT web: AnimationController " + id + " has no owner for action=" + action);
  }
  public static AnimationController byId(int id) { return new AnimationController(id); }
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
    if (id <= 0) throw new RuntimeException("Failed to created widget AnimationController");
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
    if (id <= 0) throw new RuntimeException("Failed to created widget AnimationController");
    System.out.println("New AnimationController id:"+id);
    return new AnimationController(id);
  }
  public static AnimationControllerUnboundedBuilder unbounded() {
    return AnimationControllerUnboundedBuilder.animationControllerUnbounded();
  }
  public void forward() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) { webCommand("forward"); return; }
    factories.animationControllerForward(this);
  }
  public void reverse() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) { webCommand("reverse"); return; }
    factories.animationControllerReverse(this);
  }
  public void stop() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) { webCommand("stop"); return; }
    factories.animationControllerStop(this);
  }
  public void repeat() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) { webCommand("repeat"); return; }
    factories.animationControllerRepeat(this);
  }
  public void repeat(boolean reverse) {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) { webCommand(reverse ? "repeat:reverse" : "repeat"); return; }
    factories.animationControllerRepeat(this);
  }
  public void reset() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) { webCommand("reset"); return; }
    factories.animationControllerReset(this);
  }
  public void setDuration(DurationI d) {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      // d.build() would call the native FFM factory (null in web mode); use a serializing
      // context to safely extract the millis without touching native memory.
      long ms = EwtWebCapture.buildDurationMillis(d);
      if (ms >= 0) webCommand("setDuration:" + ms);
      return;
    }
    factories.animationControllerSetDuration(this,
      d.build());
  }
  public void setReverseDuration(DurationI d) {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      long ms = EwtWebCapture.buildDurationMillis(d);
      if (ms >= 0) webCommand("setReverseDuration:" + ms);
      return;
    }
    factories.animationControllerSetReverseDuration(this,
      d.build());
  }
  @Override
  public AnimationController build() {
    return this;
  }
}
