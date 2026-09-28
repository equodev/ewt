package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class TabBarView extends StatefulWidget implements TabBarViewI {
  protected TabBarView() {}
  TabBarView(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget TabBarView");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static TabBarView tabBarViewTabBarView(@Builder.Parameter List<WidgetI> children, Optional<DragStartBehavior> dragStartBehavior, OptionalDouble viewportFraction, Optional<Clip> clipBehavior) {
    int id = factories.tabBarViewTabBarView(children.stream().map(WidgetI::build).collect(java.util.stream.Collectors.toList()),
      dragStartBehavior,
      viewportFraction,
      clipBehavior);
    if (id <= 0) throw new RuntimeException("Failed to created widget TabBarView");
    return new TabBarView(id);
  }
  public static TabBarViewTabBarViewBuilder tabBarView(List<WidgetI> children) {
    return TabBarViewTabBarViewBuilder.tabBarViewTabBarView(children);
  }
  public DragStartBehavior dragStartBehavior() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("tabBarViewDragStartBehavior not supported on web");
    return factories.TabBarView_readBack_dragStartBehavior(nativeStruct);
  }
  public double viewportFraction() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("tabBarViewViewportFraction not supported on web");
    return factories.TabBarView_readBack_viewportFraction(nativeStruct);
  }
  public Clip clipBehavior() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("tabBarViewClipBehavior not supported on web");
    return factories.TabBarView_readBack_clipBehavior(nativeStruct);
  }
  @Override
  public TabBarView build() {
    return this;
  }
}
