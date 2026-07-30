package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.SubAnimatedStateObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public abstract class SubAnimatedState<T extends StatefulWidget> extends State<T> implements SubAnimatedStateI, SubclassedInJava {
  private final MemorySegment st;
  protected SubAnimatedState() {
    st = factories.subAnimatedStateSubAnimatedState(this::initStateFn,
      this::didUpdateWidgetFn,
      this::reassembleFn,
      this::deactivateFn,
      this::activateFn,
      this::disposeFn,
      this::buildFn,
      this::didChangeDependenciesFn);
    if (st == null) throw new RuntimeException("Failed to created widget SubAnimatedState");
    id = SubAnimatedStateObjSt.id(st);
    SubclassedInJava.addSubNatObj(this);
    System.out.println("New SubAnimatedState id:"+id);
  }
  public AnimationController animationController(DurationI duration) {
    int id = factories.subAnimatedStateAnimationController(this,
      duration.build());
    if (id <= 0) throw new RuntimeException("Failed to call animationController");
    return new AnimationController(id);
  }
  protected void initState() {}
  void initStateFn() {
    initState();
  }
  protected void didUpdateWidget(T oldWidget) {}
  void didUpdateWidgetFn(T oldWidget) {
    didUpdateWidget(oldWidget);
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
  public T widget() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("subAnimatedStateWidget not supported on web");
    MemorySegment funcPtr = SubAnimatedStateObjSt.widget(st);
    return (T) (NativeObj) new NativeObj.Base() {{ this.id = SubAnimatedStateObjSt.widget.invoke(funcPtr); }};
  }
  public BuildContext context() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("subAnimatedStateContext not supported on web");
    MemorySegment funcPtr = SubAnimatedStateObjSt.context(st);
    return new BuildContext() { public int getId() { return SubAnimatedStateObjSt.context.invoke(funcPtr); } };
  }
  public boolean mounted() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("subAnimatedStateMounted not supported on web");
    MemorySegment funcPtr = SubAnimatedStateObjSt.mounted(st);
    return intToBool(SubAnimatedStateObjSt.mounted.invoke(funcPtr));
  }
  protected void setState(Runnable fn) {
    MemorySegment funcPtr = SubAnimatedStateObjSt.setState(st);
    SubAnimatedStateObjSt.setState.invoke(funcPtr, factories.ptrVoidCallbackFn(fn));
  }
  private SubStatefulWidget webWidget;
  public void setWebWidget(SubStatefulWidget w) { this.webWidget = w; }
  private java.util.function.Consumer<String> webAnimCommandSink;
  public void setWebAnimCommandSink(java.util.function.Consumer<String> sink) { this.webAnimCommandSink = sink; }
  @Override
  public SubAnimatedState build() {
    return this;
  }
}
