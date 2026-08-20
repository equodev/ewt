package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.RootRestorationScopeObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class RootRestorationScope extends StatefulWidget implements RootRestorationScopeI {
  private MemorySegment st;
  protected RootRestorationScope() {}
  RootRestorationScope(MemorySegment st) {
    this.id = RootRestorationScopeObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget RootRestorationScope");
    System.out.println("New RootRestorationScope id:"+id);
  }
  RootRestorationScope(int id) { this.id = id; }
  @Builder.Factory
  static RootRestorationScope rootRestorationScopeRootRestorationScope(@Builder.Parameter String restorationId, @Builder.Parameter WidgetI child) {
    var st = factories.rootRestorationScopeRootRestorationScope(restorationId,
      child.build());
    if (st == null) throw new RuntimeException("Failed to created widget RootRestorationScope");
    return new RootRestorationScope(st);
  }
  public static RootRestorationScopeRootRestorationScopeBuilder rootRestorationScope(String restorationId, WidgetI child) {
    return RootRestorationScopeRootRestorationScopeBuilder.rootRestorationScopeRootRestorationScope(restorationId, child);
  }
  public Widget child() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("rootRestorationScopeChild not supported on web");
    return new Widget(RootRestorationScopeObjSt.child(st)) {};
  }
  public String restorationId() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("rootRestorationScopeRestorationId not supported on web");
    return RootRestorationScopeObjSt.restorationId(st).getString(0);
  }
  @Override
  public RootRestorationScope build() {
    return this;
  }
}
