package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.MenuBarObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class MenuBar extends StatelessWidget implements MenuBarI {
  private MemorySegment st;
  protected MenuBar() {}
  MenuBar(MemorySegment st) {
    this.id = MenuBarObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget MenuBar");
    System.out.println("New MenuBar id:"+id);
  }
  MenuBar(int id) { this.id = id; }
  @Builder.Factory
  static MenuBar menuBarMenuBar(Optional<Clip> clipBehavior, List<WidgetI> children) {
    var st = factories.menuBarMenuBar(clipBehavior,
      children.stream().map(WidgetI::build).toList());
    if (st == null) throw new RuntimeException("Failed to created widget MenuBar");
    return new MenuBar(st);
  }
  public static MenuBarMenuBarBuilder menuBar() {
    return MenuBarMenuBarBuilder.menuBarMenuBar();
  }
  public Clip clipBehavior() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("menuBarClipBehavior not supported on web");
    return Clip.values()[MenuBarObjSt.clipBehavior(st)];
  }
  @Override
  public MenuBar build() {
    return this;
  }
}
