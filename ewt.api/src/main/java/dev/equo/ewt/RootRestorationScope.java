package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class RootRestorationScope extends StatefulWidget implements RootRestorationScopeI {
  protected RootRestorationScope() {}
  RootRestorationScope(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget RootRestorationScope");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static RootRestorationScope rootRestorationScopeRootRestorationScope(Optional<String> restorationId, WidgetI child) {
    int id = factories.rootRestorationScopeRootRestorationScope(restorationId,
      child.build());
    if (id <= 0) throw new RuntimeException("Failed to created widget RootRestorationScope");
    return new RootRestorationScope(id);
  }
  public static RootRestorationScopeRootRestorationScopeBuilder rootRestorationScope() {
    return RootRestorationScopeRootRestorationScopeBuilder.rootRestorationScopeRootRestorationScope();
  }
  public Widget child() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("rootRestorationScopeChild not supported on web");
    return factories.RootRestorationScope_readBack_child(nativeStruct);
  }
  public String restorationId() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("rootRestorationScopeRestorationId not supported on web");
    return factories.RootRestorationScope_readBack_restorationId(nativeStruct);
  }
  @Override
  public RootRestorationScope build() {
    return this;
  }
}
