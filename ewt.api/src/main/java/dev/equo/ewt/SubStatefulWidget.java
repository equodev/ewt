package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.SubStatefulWidgetObjSt;
public abstract class SubStatefulWidget extends StatefulWidget implements SubStatefulWidgetI {
  @Override
  public SubStatefulWidget build() {
    return this;
  }
  private final MemorySegment st;
  protected SubStatefulWidget() {
    st = factories.subStatefulWidgetSubStatefulWidget(this::createStateFn);
    if (st == null) throw new RuntimeException("Failed to created widget SubStatefulWidget");
    id = SubStatefulWidgetObjSt.id(st);
    System.out.println("New SubStatefulWidget id:"+id);
  }
  protected abstract <S extends StatefulWidget> State<S> createState();
  <S extends StatefulWidget> State<S> createStateFn() {
    return createState().build();
  }
}
