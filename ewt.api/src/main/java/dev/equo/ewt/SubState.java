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
    st = factories.subStateSubState(this::buildFn);
    if (st == null) throw new RuntimeException("Failed to created widget SubState");
    id = SubStateObjSt.id(st);
    SubclassedInJava.addSubNatObj(this);
    System.out.println("New SubState id:"+id);
  }
  protected abstract Widget build(BuildContext context);
  Widget buildFn(BuildContext context) {
    return build(context.build()).build();
  }
  public T widget() {
    MemorySegment funcPtr = SubStateObjSt.widget(st);
    return SubclassedInJava.getSubNatObj(SubStateObjSt.widget.invoke(funcPtr));
  }
  public BuildContext context() {
    MemorySegment funcPtr = SubStateObjSt.context(st);
    return new BuildContext(SubStateObjSt.context.invoke(funcPtr)) {};
  }
  public boolean mounted() {
    MemorySegment funcPtr = SubStateObjSt.mounted(st);
    return intToBool(SubStateObjSt.mounted.invoke(funcPtr));
  }
  protected void setState(Runnable fn) {
    MemorySegment funcPtr = SubStateObjSt.setState(st);
    SubStateObjSt.setState.invoke(funcPtr, factories.ptrFn(fn));
  }
  @Override
  public SubState build() {
    return this;
  }
}
