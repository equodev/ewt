package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.SubStatelessWidgetObjSt;
public abstract class SubStatelessWidget extends StatelessWidget {
  private final MemorySegment st;
  protected SubStatelessWidget() {
    st = factories.subStatelessWidgetSubStatelessWidget(this::build);
    if (st == null) throw new RuntimeException("Failed to created widget SubStatelessWidget");
    id = SubStatelessWidgetObjSt.id(st);
    System.out.println("New SubStatelessWidget id:"+id);
  }
  protected abstract Widget build(BuildContext context);
}
