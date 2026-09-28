package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class Navigator extends StatefulWidget implements NavigatorI {
  protected Navigator() {}
  Navigator(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget Navigator");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static Navigator navigatorNavigator(Optional<String> initialRoute, Optional<Boolean> reportsRouteUpdateToEngine, Optional<Clip> clipBehavior, Optional<Boolean> requestFocus, Optional<String> restorationScopeId, Optional<TraversalEdgeBehavior> routeTraversalEdgeBehavior, Optional<TraversalEdgeBehavior> routeDirectionalTraversalEdgeBehavior) {
    int id = factories.navigatorNavigator(initialRoute,
      reportsRouteUpdateToEngine,
      clipBehavior,
      requestFocus,
      restorationScopeId,
      routeTraversalEdgeBehavior,
      routeDirectionalTraversalEdgeBehavior);
    if (id <= 0) throw new RuntimeException("Failed to created widget Navigator");
    return new Navigator(id);
  }
  public static NavigatorNavigatorBuilder navigator() {
    return NavigatorNavigatorBuilder.navigatorNavigator();
  }
  public static Future pushNamed(BuildContextI context, String routeName) {
    var id = factories.navigatorPushNamed(context.build(),
      routeName,
      Optional.empty());
    if (id <= 0) throw new RuntimeException("Failed to created widget Future<T?>");
    System.out.println("New Future<T?> id:"+id);
    return new Future() { public int getId() { return id; } };
  }
  public static String restorablePushNamed(BuildContextI context, String routeName) {
    var id = factories.navigatorRestorablePushNamed(context.build(),
      routeName,
      Optional.empty());
    System.out.println("New String id:"+id);
    return id;
  }
  public static Future pushReplacementNamed(BuildContextI context, String routeName) {
    var id = factories.navigatorPushReplacementNamed(context.build(),
      routeName,
      Optional.empty(),
      Optional.empty());
    if (id <= 0) throw new RuntimeException("Failed to created widget Future<T?>");
    System.out.println("New Future<T?> id:"+id);
    return new Future() { public int getId() { return id; } };
  }
  public static String restorablePushReplacementNamed(BuildContextI context, String routeName) {
    var id = factories.navigatorRestorablePushReplacementNamed(context.build(),
      routeName,
      Optional.empty(),
      Optional.empty());
    System.out.println("New String id:"+id);
    return id;
  }
  public static Future popAndPushNamed(BuildContextI context, String routeName) {
    var id = factories.navigatorPopAndPushNamed(context.build(),
      routeName,
      Optional.empty(),
      Optional.empty());
    if (id <= 0) throw new RuntimeException("Failed to created widget Future<T?>");
    System.out.println("New Future<T?> id:"+id);
    return new Future() { public int getId() { return id; } };
  }
  public static String restorablePopAndPushNamed(BuildContextI context, String routeName) {
    var id = factories.navigatorRestorablePopAndPushNamed(context.build(),
      routeName,
      Optional.empty(),
      Optional.empty());
    System.out.println("New String id:"+id);
    return id;
  }
  public static boolean canPop(BuildContextI context) {
    var id = factories.navigatorCanPop(context.build());
    if (id <= 0) throw new RuntimeException("Failed to created widget bool");
    System.out.println("New bool id:"+id);
    return intToBool(id);
  }
  public static Future<Boolean> maybePop(BuildContextI context) {
    var id = factories.navigatorMaybePop(context.build(),
      Optional.empty());
    if (id <= 0) throw new RuntimeException("Failed to created widget Future<bool>");
    System.out.println("New Future<bool> id:"+id);
    return new Future() { public int getId() { return id; } };
  }
  public static void pop(BuildContextI context) {
    factories.navigatorPop(context.build(),
      Optional.empty());
  }
  public static NavigatorState of(BuildContextI context) {
    var id = factories.navigatorOf(context.build(),
      Optional.empty());
    if (id <= 0) throw new RuntimeException("Failed to created widget NavigatorState");
    System.out.println("New NavigatorState id:"+id);
    return new NavigatorState(id);
  }
  public static NavigatorState maybeOf(BuildContextI context) {
    var id = factories.navigatorMaybeOf(context.build(),
      Optional.empty());
    if (id <= 0) throw new RuntimeException("Failed to created widget NavigatorState?");
    System.out.println("New NavigatorState? id:"+id);
    return new NavigatorState(id);
  }
  public String initialRoute() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("navigatorInitialRoute not supported on web");
    return factories.Navigator_readBack_initialRoute(nativeStruct);
  }
  public String restorationScopeId() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("navigatorRestorationScopeId not supported on web");
    return factories.Navigator_readBack_restorationScopeId(nativeStruct);
  }
  public TraversalEdgeBehavior routeTraversalEdgeBehavior() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("navigatorRouteTraversalEdgeBehavior not supported on web");
    return factories.Navigator_readBack_routeTraversalEdgeBehavior(nativeStruct);
  }
  public TraversalEdgeBehavior routeDirectionalTraversalEdgeBehavior() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("navigatorRouteDirectionalTraversalEdgeBehavior not supported on web");
    return factories.Navigator_readBack_routeDirectionalTraversalEdgeBehavior(nativeStruct);
  }
  public boolean reportsRouteUpdateToEngine() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("navigatorReportsRouteUpdateToEngine not supported on web");
    return factories.Navigator_readBack_reportsRouteUpdateToEngine(nativeStruct);
  }
  public Clip clipBehavior() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("navigatorClipBehavior not supported on web");
    return factories.Navigator_readBack_clipBehavior(nativeStruct);
  }
  public boolean requestFocus() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("navigatorRequestFocus not supported on web");
    return factories.Navigator_readBack_requestFocus(nativeStruct);
  }
  public static String defaultRouteName() {
    return "/";
  }
  @Override
  public Navigator build() {
    return this;
  }
}
