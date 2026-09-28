package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class MenuBar extends StatelessWidget implements MenuBarI {
  protected MenuBar() {}
  MenuBar(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget MenuBar");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static MenuBar menuBarMenuBar(Optional<Clip> clipBehavior, List<WidgetI> children) {
    int id = factories.menuBarMenuBar(clipBehavior,
      children.stream().map(WidgetI::build).collect(java.util.stream.Collectors.toList()));
    if (id <= 0) throw new RuntimeException("Failed to created widget MenuBar");
    return new MenuBar(id);
  }
  public static MenuBarMenuBarBuilder menuBar() {
    return MenuBarMenuBarBuilder.menuBarMenuBar();
  }
  public Clip clipBehavior() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("menuBarClipBehavior not supported on web");
    return factories.MenuBar_readBack_clipBehavior(nativeStruct);
  }
  @Override
  public MenuBar build() {
    return this;
  }
}
