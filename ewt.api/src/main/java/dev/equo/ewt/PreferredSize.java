package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.PreferredSizeObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class PreferredSize extends StatelessWidget implements PreferredSizeWidget, PreferredSizeI {
  private MemorySegment st;
  protected PreferredSize() {}
  PreferredSize(MemorySegment st) {
    this.id = PreferredSizeObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget PreferredSize");
    System.out.println("New PreferredSize id:"+id);
  }
  PreferredSize(int id) { this.id = id; }
  public Widget child() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("preferredSizeChild not supported on web");
    return new Widget(PreferredSizeObjSt.child(st)) {};
  }
  @Override
  public PreferredSize build() {
    return this;
  }
}
