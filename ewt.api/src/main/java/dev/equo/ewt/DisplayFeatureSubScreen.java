package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.DisplayFeatureSubScreenObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class DisplayFeatureSubScreen extends StatelessWidget implements DisplayFeatureSubScreenI {
  private MemorySegment st;
  protected DisplayFeatureSubScreen() {}
  DisplayFeatureSubScreen(MemorySegment st) {
    this.id = DisplayFeatureSubScreenObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget DisplayFeatureSubScreen");
    System.out.println("New DisplayFeatureSubScreen id:"+id);
  }
  DisplayFeatureSubScreen(int id) { this.id = id; }
  @Builder.Factory
  static DisplayFeatureSubScreen displayFeatureSubScreenDisplayFeatureSubScreen(Optional<OffsetI> anchorPoint, WidgetI child) {
    var st = factories.displayFeatureSubScreenDisplayFeatureSubScreen(anchorPoint.map(OffsetI::build),
      child.build());
    if (st == null) throw new RuntimeException("Failed to created widget DisplayFeatureSubScreen");
    return new DisplayFeatureSubScreen(st);
  }
  public static DisplayFeatureSubScreenDisplayFeatureSubScreenBuilder displayFeatureSubScreen() {
    return DisplayFeatureSubScreenDisplayFeatureSubScreenBuilder.displayFeatureSubScreenDisplayFeatureSubScreen();
  }
  public Offset anchorPoint() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("displayFeatureSubScreenAnchorPoint", getId());
      return new Offset(__nid);
    }
    return new Offset(DisplayFeatureSubScreenObjSt.anchorPoint(st));
  }
  public Widget child() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("displayFeatureSubScreenChild not supported on web");
    return new Widget(DisplayFeatureSubScreenObjSt.child(st)) {};
  }
  @Override
  public DisplayFeatureSubScreen build() {
    return this;
  }
}
