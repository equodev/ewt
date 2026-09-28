package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class DrawerHeader extends StatelessWidget implements DrawerHeaderI {
  protected DrawerHeader() {}
  DrawerHeader(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget DrawerHeader");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static DrawerHeader drawerHeaderDrawerHeader(Optional<DecorationI> decoration, Optional<EdgeInsetsGeometryI> margin, Optional<EdgeInsetsGeometryI> padding, Optional<DurationI> duration, Optional<CurveI> curve, Optional<WidgetI> child) {
    int id = factories.drawerHeaderDrawerHeader(decoration.map(DecorationI::build),
      margin.map(EdgeInsetsGeometryI::build),
      padding.map(EdgeInsetsGeometryI::build),
      duration.map(DurationI::build),
      curve.map(CurveI::build),
      child.map(WidgetI::build));
    if (id <= 0) throw new RuntimeException("Failed to created widget DrawerHeader");
    return new DrawerHeader(id);
  }
  public static DrawerHeaderDrawerHeaderBuilder drawerHeader() {
    return DrawerHeaderDrawerHeaderBuilder.drawerHeaderDrawerHeader();
  }
  public Decoration decoration() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("drawerHeaderDecoration not supported on web");
    return factories.DrawerHeader_readBack_decoration(nativeStruct);
  }
  public EdgeInsetsGeometry padding() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("drawerHeaderPadding not supported on web");
    return factories.DrawerHeader_readBack_padding(nativeStruct);
  }
  public EdgeInsetsGeometry margin() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("drawerHeaderMargin not supported on web");
    return factories.DrawerHeader_readBack_margin(nativeStruct);
  }
  public Duration duration() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("drawerHeaderDuration", getId());
      return new Duration(__nid);
    }
    return factories.DrawerHeader_readBack_duration(nativeStruct);
  }
  public Curve curve() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("drawerHeaderCurve not supported on web");
    return factories.DrawerHeader_readBack_curve(nativeStruct);
  }
  public Widget child() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("drawerHeaderChild not supported on web");
    return factories.DrawerHeader_readBack_child(nativeStruct);
  }
  @Override
  public DrawerHeader build() {
    return this;
  }
}
