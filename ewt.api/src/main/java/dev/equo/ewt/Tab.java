package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.TabObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class Tab extends StatelessWidget implements PreferredSizeWidget, TabI {
  private MemorySegment st;
  protected Tab() {}
  Tab(MemorySegment st) {
    this.id = TabObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget Tab");
    System.out.println("New Tab id:"+id);
  }
  Tab(int id) { this.id = id; }
  @Builder.Factory
  static Tab tabTab(Optional<String> text, Optional<WidgetI> icon, Optional<EdgeInsetsGeometryI> iconMargin, OptionalDouble height, Optional<WidgetI> child) {
    var st = factories.tabTab(text,
      icon.map(WidgetI::build),
      iconMargin.map(EdgeInsetsGeometryI::build),
      height,
      child.map(WidgetI::build));
    if (st == null) throw new RuntimeException("Failed to created widget Tab");
    return new Tab(st);
  }
  public static TabTabBuilder tab() {
    return TabTabBuilder.tabTab();
  }
  public String text() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("tabText not supported on web");
    return TabObjSt.text(st).getString(0);
  }
  public Widget child() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("tabChild not supported on web");
    return new Widget(TabObjSt.child(st)) {};
  }
  public Widget icon() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("tabIcon not supported on web");
    return new Widget(TabObjSt.icon(st)) {};
  }
  public EdgeInsetsGeometry iconMargin() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("tabIconMargin not supported on web");
    return new EdgeInsetsGeometry(TabObjSt.iconMargin(st)) {};
  }
  public double height() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("tabHeight not supported on web");
    return TabObjSt.height(st);
  }
  @Override
  public Tab build() {
    return this;
  }
}
