package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.SubStateObjSt;
public abstract class SubState<T extends StatefulWidget> extends State<T> implements SubStateI {
  @Override
  public SubState build() {
    return this;
  }
  private final MemorySegment st;
  protected SubState() {
    st = factories.subStateSubState(this::buildFn);
    if (st == null) throw new RuntimeException("Failed to created widget SubState");
    id = SubStateObjSt.id(st);
    System.out.println("New SubState id:"+id);
  }
  protected abstract WidgetI build(BuildContext context);
  Widget buildFn(BuildContext context) {
    return build(context.build()).build();
  }
  protected void setState(Runnable fn) {
    MemorySegment funcPtr = SubStateObjSt.setState(st);
    SubStateObjSt.setState.invoke(funcPtr, factories.ptrFn(fn));
  }
}
