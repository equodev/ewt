package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public abstract class SubState<T extends StatefulWidget> extends State<T> implements SubStateI, SubclassedInJava {
  protected SubState() {
    id = factories.subStateSubState(this::initStateFn,
      this::didUpdateWidgetFn,
      this::reassembleFn,
      this::deactivateFn,
      this::activateFn,
      this::disposeFn,
      this::buildFn,
      this::didChangeDependenciesFn);
    if (id <= 0) throw new RuntimeException("Failed to created widget SubState");
    SubclassedInJava.addSubNatObj(this);
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
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("subStateContext not supported on web");
    return factories.SubState_readBack_context(nativeStruct);
  }
  public boolean mounted() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("subStateMounted not supported on web");
    return factories.SubState_readBack_mounted(nativeStruct);
  }
  protected void setState(Runnable fn) {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      fn.run();
      EwtWebState.requestRebuild(this);
      return;
    }
    factories.subStateSetState(getId(), fn);
  }
  @SuppressWarnings("unchecked")
  public T widget() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode() && webWidget != null) {
      return (T) webWidget;
    }
    return SubclassedInJava.getSubNatObj(factories.subStateWidget(getId()));
  }
  private SubStatefulWidget webWidget; // set by EwtWebCapture during web-mode flatten
  void setWebWidget(SubStatefulWidget w) { this.webWidget = w; }
  @Override
  public SubState build() {
    return this;
  }
}
