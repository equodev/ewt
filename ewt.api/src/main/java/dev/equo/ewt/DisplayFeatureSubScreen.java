package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class DisplayFeatureSubScreen extends StatelessWidget implements DisplayFeatureSubScreenI {
  protected DisplayFeatureSubScreen() {}
  DisplayFeatureSubScreen(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget DisplayFeatureSubScreen");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static DisplayFeatureSubScreen displayFeatureSubScreenDisplayFeatureSubScreen(Optional<OffsetI> anchorPoint, WidgetI child) {
    int id = factories.displayFeatureSubScreenDisplayFeatureSubScreen(anchorPoint.map(OffsetI::build),
      child.build());
    if (id <= 0) throw new RuntimeException("Failed to created widget DisplayFeatureSubScreen");
    return new DisplayFeatureSubScreen(id);
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
    return factories.DisplayFeatureSubScreen_readBack_anchorPoint(nativeStruct);
  }
  public Widget child() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("displayFeatureSubScreenChild not supported on web");
    return factories.DisplayFeatureSubScreen_readBack_child(nativeStruct);
  }
  @Override
  public DisplayFeatureSubScreen build() {
    return this;
  }
}
