package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.SelectionAreaObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class SelectionArea extends StatefulWidget implements SelectionAreaI {
  private MemorySegment st;
  protected SelectionArea() {}
  SelectionArea(MemorySegment st) {
    this.id = SelectionAreaObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget SelectionArea");
    System.out.println("New SelectionArea id:"+id);
  }
  SelectionArea(int id) { this.id = id; }
  @Builder.Factory
  static SelectionArea selectionAreaSelectionArea(@Builder.Parameter WidgetI child) {
    var st = factories.selectionAreaSelectionArea(child.build());
    if (st == null) throw new RuntimeException("Failed to created widget SelectionArea");
    return new SelectionArea(st);
  }
  public static SelectionAreaSelectionAreaBuilder selectionArea(WidgetI child) {
    return SelectionAreaSelectionAreaBuilder.selectionAreaSelectionArea(child);
  }
  public Widget child() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("selectionAreaChild not supported on web");
    return new Widget(SelectionAreaObjSt.child(st)) {};
  }
  @Override
  public SelectionArea build() {
    return this;
  }
}
