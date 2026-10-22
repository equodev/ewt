package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import static dev.equo.ewt.NativeObj.Base.intToBool;
public abstract class SubAnimatedState<T extends StatefulWidget> extends State<T> implements SubAnimatedStateI, SubclassedInJava {
  protected SubAnimatedState() {
    id = factories.subAnimatedStateSubAnimatedState(this::initStateFn,
      this::didUpdateWidgetFn,
      this::reassembleFn,
      this::deactivateFn,
      this::activateFn,
      this::disposeFn,
      this::buildFn,
      this::didChangeDependenciesFn);
    if (id <= 0) throw new RuntimeException("Failed to created widget SubAnimatedState");
    SubclassedInJava.addSubNatObj(this);
  }
  public AnimationController animationController(DurationI duration) {
    var id = factories.subAnimatedStateAnimationController(this,
      duration.build());
    if (id <= 0) throw new RuntimeException("Failed to call animationController");
    AnimationController ctrl = new AnimationController(id);
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      ctrl.setWebOwner(this);
      if (webAnimCommandSink != null) EwtWebState.registerAnimSink(id, webAnimCommandSink);
    }
    controllers.add(ctrl);
    return ctrl;
  }
  protected void initState() {}
  void initStateFn() {
    initState();
  }
  protected void didUpdateWidget(T oldWidget) {}
  @SuppressWarnings("unchecked")
  void didUpdateWidgetFn(NativeObj oldWidget) {
    didUpdateWidget((T) oldWidget);
  }
  protected void reassemble() {}
  void reassembleFn() {
    reassemble();
  }
  protected void deactivate() {}
  void deactivateFn() {
    deactivate();
  }
  protected void activate() {}
  void activateFn() {
    activate();
  }
  protected void dispose() {}
  void disposeFn() {
    dispose();
  }
  protected abstract Widget build(BuildContext context);
  Widget buildFn(BuildContext context) {
    return build(context.build()).build();
  }
  protected void didChangeDependencies() {}
  void didChangeDependenciesFn() {
    didChangeDependencies();
  }
  public BuildContext context() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("subAnimatedStateContext not supported on web");
    return factories.SubAnimatedState_readBack_context(nativeStruct);
  }
  public boolean mounted() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("subAnimatedStateMounted not supported on web");
    return factories.SubAnimatedState_readBack_mounted(nativeStruct);
  }
  protected void setState(Runnable fn) {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      fn.run();
      EwtWebState.requestRebuild(this);
      return;
    }
    factories.subAnimatedStateSetState(getId(), fn);
  }
  @SuppressWarnings("unchecked")
  public T widget() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("subAnimatedStateWidget not supported on web");
    return (T) (NativeObj) new NativeObj.Base() {{ this.id = factories.subAnimatedStateWidget(getId()); }};
  }
  private SubStatefulWidget webWidget;
  void setWebWidget(SubStatefulWidget w) { this.webWidget = w; }
  private java.util.function.Consumer<String> webAnimCommandSink;
  public void setWebAnimCommandSink(java.util.function.Consumer<String> sink) {
    this.webAnimCommandSink = sink;
    if (sink != null) for (AnimationController c : controllers) EwtWebState.registerAnimSink(c.getId(), sink);
  }
  void sendAnimCommand(int ctrlId, String action) {
    if (webAnimCommandSink != null) webAnimCommandSink.accept("{\"ctrlId\":" + ctrlId + ",\"action\":\"" + action + "\"}");
    else System.out.println("EWT web: no anim sink on state for ctrl=" + ctrlId + " action=" + action);
  }
  /** Status-listener ids registered by this state (web mode), reclaimed by the region on
   *  teardown so a full setWidget re-publish does not leak a sink. */
  private final java.util.List<Integer> webStatusListenerIds = new java.util.ArrayList<>();
  void trackWebStatusListener(int listenerId) { webStatusListenerIds.add(listenerId); }
  /** Drops every status-listener sink this state registered. Called from the region on teardown. */
  void clearWebStatusListeners() {
    for (Integer id : webStatusListenerIds) EwtWebState.unregisterStatusListener(id);
    webStatusListenerIds.clear();
  }
  private final java.util.List<AnimationController> controllers = new java.util.ArrayList<>();
  /** Pre-registers stub AnimationController nodes in a fresh serializer to prevent id collisions
   *  during rebuildAnimated: each controller keeps its original id so the Dart side can match/reuse. */
  void preregisterControllers(SerializingWidgetConstructors ser) {
    for (AnimationController c : controllers) ser.preregisterAnimationController(c.getId());
  }
  @Override
  public SubAnimatedState build() {
    return this;
  }
}
