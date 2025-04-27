package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.NavigatorObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class Navigator extends StatefulWidget implements NavigatorI {
  private MemorySegment st;
  protected Navigator() {}
  Navigator(MemorySegment st) {
    this.id = NavigatorObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget Navigator");
    System.out.println("New Navigator id:"+id);
  }
  @Builder.Factory
  static Navigator navigatorNavigator(Optional<String> initialRoute, Optional<Boolean> reportsRouteUpdateToEngine, Optional<Clip> clipBehavior, Optional<Boolean> requestFocus, Optional<String> restorationScopeId, Optional<TraversalEdgeBehavior> routeTraversalEdgeBehavior) {
    var st = factories.navigatorNavigator(initialRoute,
      reportsRouteUpdateToEngine,
      clipBehavior,
      requestFocus,
      restorationScopeId,
      routeTraversalEdgeBehavior);
    if (st == null) throw new RuntimeException("Failed to created widget Navigator");
    return new Navigator(st);
  }
  public static NavigatorNavigatorBuilder navigator() {
    return NavigatorNavigatorBuilder.navigatorNavigator();
  }
  public static NavigatorState of(BuildContextI context) {
    int id = factories.navigatorOf(context.build(),
      Optional.empty());
    if (id <= 0) throw new RuntimeException("Failed to created widget NavigatorState");
    System.out.println("New NavigatorState id:"+id);
    return new NavigatorState(id);
  }
  public static NavigatorState maybeOf(BuildContextI context) {
    int id = factories.navigatorMaybeOf(context.build(),
      Optional.empty());
    if (id <= 0) throw new RuntimeException("Failed to created widget NavigatorState?");
    System.out.println("New NavigatorState? id:"+id);
    return new NavigatorState(id);
  }
  public String initialRoute() {
    return NavigatorObjSt.initialRoute(st).getString(0);
  }
  public String restorationScopeId() {
    return NavigatorObjSt.restorationScopeId(st).getString(0);
  }
  public TraversalEdgeBehavior routeTraversalEdgeBehavior() {
    return TraversalEdgeBehavior.values()[NavigatorObjSt.routeTraversalEdgeBehavior(st)];
  }
  public boolean reportsRouteUpdateToEngine() {
    return intToBool(NavigatorObjSt.reportsRouteUpdateToEngine(st));
  }
  public Clip clipBehavior() {
    return Clip.values()[NavigatorObjSt.clipBehavior(st)];
  }
  public boolean requestFocus() {
    return intToBool(NavigatorObjSt.requestFocus(st));
  }
  public static String defaultRouteName() {
    return "/";
  }
  @Override
  public Navigator build() {
    return this;
  }
}
