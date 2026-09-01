package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.RestorationScopeObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class RestorationScope extends StatefulWidget implements RestorationScopeI {
  private MemorySegment st;
  protected RestorationScope() {}
  RestorationScope(MemorySegment st) {
    this.id = RestorationScopeObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget RestorationScope");
    System.out.println("New RestorationScope id:"+id);
  }
  RestorationScope(int id) { this.id = id; }
  @Builder.Factory
  static RestorationScope restorationScopeRestorationScope(@Builder.Parameter String restorationId, @Builder.Parameter WidgetI child) {
    var st = factories.restorationScopeRestorationScope(restorationId,
      child.build());
    if (st == null) throw new RuntimeException("Failed to created widget RestorationScope");
    return new RestorationScope(st);
  }
  public static RestorationScopeRestorationScopeBuilder restorationScope(String restorationId, WidgetI child) {
    return RestorationScopeRestorationScopeBuilder.restorationScopeRestorationScope(restorationId, child);
  }
  public Widget child() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("restorationScopeChild not supported on web");
    return new Widget(RestorationScopeObjSt.child(st)) {};
  }
  public String restorationId() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("restorationScopeRestorationId not supported on web");
    return RestorationScopeObjSt.restorationId(st).getString(0);
  }
  @Override
  public RestorationScope build() {
    return this;
  }
}
