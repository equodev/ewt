package dev.equo.ewt;
import java.lang.foreign.MemorySegment;
import java.util.*;

import dev.equo.ewt.ffm.SetStatePtr;
import dev.equo.ewt.ffm.SubStateObjSt;
import org.immutables.builder.Builder;
public abstract class SubState<T extends StatefulWidget> extends State<T> {
  private final MemorySegment st;

  protected SubState() {
    st = factories.subStateSubState(this::build);
    id = SubStateObjSt.id(st);
    if (id == -1) throw new RuntimeException("Failed to created widget SubState");
    System.out.println("New SubState id:"+id);
  }
  protected abstract Widget build();

  protected void setState(Runnable run) {
    MemorySegment funcPtr = SubStateObjSt.setState(st);
    SetStatePtr.invoke(funcPtr, factories.ptrFn(run));
  }

}
