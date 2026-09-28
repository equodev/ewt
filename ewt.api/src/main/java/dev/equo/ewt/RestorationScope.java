package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class RestorationScope extends StatefulWidget implements RestorationScopeI {
  protected RestorationScope() {}
  RestorationScope(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget RestorationScope");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static RestorationScope restorationScopeRestorationScope(Optional<String> restorationId, WidgetI child) {
    int id = factories.restorationScopeRestorationScope(restorationId,
      child.build());
    if (id <= 0) throw new RuntimeException("Failed to created widget RestorationScope");
    return new RestorationScope(id);
  }
  public static RestorationScopeRestorationScopeBuilder restorationScope() {
    return RestorationScopeRestorationScopeBuilder.restorationScopeRestorationScope();
  }
  public Widget child() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("restorationScopeChild not supported on web");
    return factories.RestorationScope_readBack_child(nativeStruct);
  }
  public String restorationId() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("restorationScopeRestorationId not supported on web");
    return factories.RestorationScope_readBack_restorationId(nativeStruct);
  }
  @Override
  public RestorationScope build() {
    return this;
  }
}
