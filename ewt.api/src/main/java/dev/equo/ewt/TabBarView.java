package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.TabBarViewObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class TabBarView extends StatefulWidget implements TabBarViewI {
  private MemorySegment st;
  protected TabBarView() {}
  TabBarView(MemorySegment st) {
    this.id = TabBarViewObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget TabBarView");
    System.out.println("New TabBarView id:"+id);
  }
  @Builder.Factory
  static TabBarView tabBarViewTabBarView(@Builder.Parameter List<WidgetI> children, Optional<DragStartBehavior> dragStartBehavior, OptionalDouble viewportFraction, Optional<Clip> clipBehavior) {
    var st = factories.tabBarViewTabBarView(children.stream().map(WidgetI::build).toList(),
      dragStartBehavior,
      viewportFraction,
      clipBehavior);
    if (st == null) throw new RuntimeException("Failed to created widget TabBarView");
    return new TabBarView(st);
  }
  public static TabBarViewTabBarViewBuilder tabBarView(List<WidgetI> children) {
    return TabBarViewTabBarViewBuilder.tabBarViewTabBarView(children);
  }
  public DragStartBehavior dragStartBehavior() {
    return DragStartBehavior.values()[TabBarViewObjSt.dragStartBehavior(st)];
  }
  public double viewportFraction() {
    return TabBarViewObjSt.viewportFraction(st);
  }
  public Clip clipBehavior() {
    return Clip.values()[TabBarViewObjSt.clipBehavior(st)];
  }
  @Override
  public TabBarView build() {
    return this;
  }
}
