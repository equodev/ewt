package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.SubStateObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public abstract class SubState<T extends StatefulWidget> extends State<T> implements SubStateI, SubclassedInJava {
  private final MemorySegment st;
  protected SubState() {
    st = factories.subStateSubState(this::initStateFn,
      this::didUpdateWidgetFn,
      this::reassembleFn,
      this::deactivateFn,
      this::activateFn,
      this::disposeFn,
      this::buildFn,
      this::didChangeDependenciesFn);
    if (st == null) throw new RuntimeException("Failed to created widget SubState");
    id = SubStateObjSt.id(st);
    SubclassedInJava.addSubNatObj(this);
    System.out.println("New SubState id:"+id);
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
    MemorySegment funcPtr = SubStateObjSt.widget(st);
    return SubclassedInJava.getSubNatObj(SubStateObjSt.widget.invoke(funcPtr));
  }
  public BuildContext context() {
    MemorySegment funcPtr = SubStateObjSt.context(st);
    return new BuildContext() { public int getId() { return SubStateObjSt.context.invoke(funcPtr); } };
  }
  public boolean mounted() {
    MemorySegment funcPtr = SubStateObjSt.mounted(st);
    return intToBool(SubStateObjSt.mounted.invoke(funcPtr));
  }
  protected void setState(Runnable fn) {
    MemorySegment funcPtr = SubStateObjSt.setState(st);
    SubStateObjSt.setState.invoke(funcPtr, factories.ptrVoidCallbackFn(fn));
  }
  @Override
  public SubState build() {
    return this;
  }
}
