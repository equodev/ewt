package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class AnimationController extends NativeObj.Base implements Animation<Double>, AnimationControllerI {
  protected AnimationController() {}
  AnimationController(int id) {
    this.id = id;
  }
  public static AnimationController byId(int id) { return new AnimationController(id); }
  static { NativeObj.register("AnimationController", AnimationController::byId); }
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
  public Future<NativeObj> forward() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      return webAsyncCommand("forward", java.util.Collections.emptyList());
    }
    int id = factories.animationControllerForward(this);
    if (id <= 0) throw new RuntimeException("Failed to call forward");
    return new Future() { public int getId() { return id; } };
  }
  public Future<NativeObj> reverse() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      return webAsyncCommand("reverse", java.util.Collections.emptyList());
    }
    int id = factories.animationControllerReverse(this);
    if (id <= 0) throw new RuntimeException("Failed to call reverse");
    return new Future() { public int getId() { return id; } };
  }
  public Future<NativeObj> repeat() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      return webAsyncCommand("repeat", java.util.Collections.emptyList());
    }
    int id = factories.animationControllerRepeat(this);
    if (id <= 0) throw new RuntimeException("Failed to call repeat");
    return new Future() { public int getId() { return id; } };
  }
  public Future<NativeObj> toggle() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      return webAsyncCommand("toggle", java.util.Collections.emptyList());
    }
    int id = factories.animationControllerToggle(this);
    if (id <= 0) throw new RuntimeException("Failed to call toggle");
    return new Future() { public int getId() { return id; } };
  }
  public Future<NativeObj> fling(double velocity) {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      return webAsyncCommand("fling", java.util.Arrays.<Object>asList(velocity));
    }
    int id = factories.animationControllerFling(this,
      velocity);
    if (id <= 0) throw new RuntimeException("Failed to call fling");
    return new Future() { public int getId() { return id; } };
  }
  public Future<NativeObj> animateTo(double target, DurationI duration) {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      return webAsyncCommand("animateTo", java.util.Arrays.<Object>asList(target, EwtWebCapture.buildDurationMillis(duration.build())));
    }
    int id = factories.animationControllerAnimateTo(this,
      target,
      duration.build());
    if (id <= 0) throw new RuntimeException("Failed to call animateTo");
    return new Future() { public int getId() { return id; } };
  }
  public Future<NativeObj> animateBack(double target, DurationI duration) {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      return webAsyncCommand("animateBack", java.util.Arrays.<Object>asList(target, EwtWebCapture.buildDurationMillis(duration.build())));
    }
    int id = factories.animationControllerAnimateBack(this,
      target,
      duration.build());
    if (id <= 0) throw new RuntimeException("Failed to call animateBack");
    return new Future() { public int getId() { return id; } };
  }
  public void stop() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) { webCommand("stop"); return; }
    factories.animationControllerStop(this);
  }
  public void reset() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) { webCommand("reset"); return; }
    factories.animationControllerReset(this);
  }
  public void setValue(double v) {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) { webCommand("setValue"); return; }
    factories.animationControllerSetValue(this,
      v);
  }
  public void setDuration(DurationI d) {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
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
  /** Set in web mode by SubAnimatedState.animationController() so commands can route back. */
  private SubAnimatedState<?> webOwner;
  void setWebOwner(SubAnimatedState<?> owner) { this.webOwner = owner; }
  private void webCommand(String action) {
    if (webOwner != null) webOwner.sendAnimCommand(this.id, action);
    else System.out.println("EWT web: AnimationController " + id + " has no owner for action=" + action);
  }
  /** Async web command: allocates a callback id, registers a CompletableFuture, and ships the
   *  primitive args. Returns an EWT Future whose .then(consumer) fires once the web side echoes
   *  the callback id back — bridging java.util.concurrent.CompletableFuture (broker-side) to the
   *  Future<NativeObj> surface the generator emits (Flutter-side). */
  private Future<NativeObj> webAsyncCommand(String action, java.util.List<Object> args) {
    final java.util.concurrent.CompletableFuture<Object> cf;
    if (webOwner == null) {
      cf = new java.util.concurrent.CompletableFuture<>();
      cf.completeExceptionally(new IllegalStateException("AnimationController " + id + " has no web owner for async action=" + action));
    } else {
      int cbId = dev.equo.ewt.EwtWebState.nextAsyncCallbackId();
      cf = dev.equo.ewt.EwtWebState.registerAsyncCallback(cbId, this.id);
      dev.equo.ewt.EwtWebState.sendAsyncAnimCommand(this.id, action, cbId, args);
    }
    return new Future<NativeObj>() {
      @Override public int getId() { return -1; }
      @Override public Future build() { return this; }
      @Override public void then(java.util.function.Consumer<NativeObj> onValue) {
        cf.whenComplete((v, t) -> {
          if (t == null) onValue.accept(null);
          else System.out.println("EWT web: AnimationController " + id + " async " + action + " failed: " + t);
        });
      }
    };
  }
  public void repeat(boolean reverse) {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) { webCommand(reverse ? "repeat:reverse" : "repeat"); return; }
    if (reverse) throw new UnsupportedOperationException(
        "repeat(reverse=true) is not yet supported on the native path; call repeat() instead");
    factories.animationControllerRepeat(this);
  }
  @Override
  public AnimationController build() {
    return this;
  }
}
