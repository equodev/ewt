package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.SelectionListenerObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class SelectionListener extends StatefulWidget implements SelectionListenerI {
  private MemorySegment st;
  protected SelectionListener() {}
  SelectionListener(MemorySegment st) {
    this.id = SelectionListenerObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget SelectionListener");
    System.out.println("New SelectionListener id:"+id);
  }
  SelectionListener(int id) { this.id = id; }
  public Widget child() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("selectionListenerChild not supported on web");
    return new Widget(SelectionListenerObjSt.child(st)) {};
  }
  @Override
  public SelectionListener build() {
    return this;
  }
}
