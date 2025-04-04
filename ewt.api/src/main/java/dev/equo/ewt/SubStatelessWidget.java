package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.SubStatelessWidgetObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public abstract class SubStatelessWidget extends StatelessWidget implements SubStatelessWidgetI, SubclassedInJava {
  private final MemorySegment st;
  protected SubStatelessWidget() {
    st = factories.subStatelessWidgetSubStatelessWidget(this::buildFn);
    if (st == null) throw new RuntimeException("Failed to created widget SubStatelessWidget");
    id = SubStatelessWidgetObjSt.id(st);
    SubclassedInJava.addSubNatObj(this);
    System.out.println("New SubStatelessWidget id:"+id);
  }
  protected abstract Widget build(BuildContext context);
  Widget buildFn(BuildContext context) {
    return build(context.build()).build();
  }
  @Override
  public SubStatelessWidget build() {
    return this;
  }
}
