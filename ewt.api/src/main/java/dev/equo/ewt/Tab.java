package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class Tab extends StatelessWidget implements PreferredSizeWidget, TabI {
  protected Tab() {}
  Tab(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget Tab");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static Tab tabTab(Optional<String> text, Optional<WidgetI> icon, Optional<EdgeInsetsGeometryI> iconMargin, OptionalDouble height, Optional<WidgetI> child) {
    int id = factories.tabTab(text,
      icon.map(WidgetI::build),
      iconMargin.map(EdgeInsetsGeometryI::build),
      height,
      child.map(WidgetI::build));
    if (id <= 0) throw new RuntimeException("Failed to created widget Tab");
    return new Tab(id);
  }
  public static TabTabBuilder tab() {
    return TabTabBuilder.tabTab();
  }
  public String text() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("tabText not supported on web");
    return factories.Tab_readBack_text(nativeStruct);
  }
  public Widget child() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("tabChild not supported on web");
    return factories.Tab_readBack_child(nativeStruct);
  }
  public Widget icon() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("tabIcon not supported on web");
    return factories.Tab_readBack_icon(nativeStruct);
  }
  public EdgeInsetsGeometry iconMargin() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("tabIconMargin not supported on web");
    return factories.Tab_readBack_iconMargin(nativeStruct);
  }
  public double height() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("tabHeight not supported on web");
    return factories.Tab_readBack_height(nativeStruct);
  }
  @Override
  public Tab build() {
    return this;
  }
}
