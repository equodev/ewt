package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class BottomAppBar extends StatefulWidget implements BottomAppBarI {
  protected BottomAppBar() {}
  BottomAppBar(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget BottomAppBar");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static BottomAppBar bottomAppBarBottomAppBar(Optional<ColorI> color, OptionalDouble elevation, Optional<Clip> clipBehavior, OptionalDouble notchMargin, Optional<WidgetI> child, Optional<EdgeInsetsGeometryI> padding, Optional<ColorI> surfaceTintColor, Optional<ColorI> shadowColor, OptionalDouble height) {
    int id = factories.bottomAppBarBottomAppBar(color.map(ColorI::build),
      elevation,
      clipBehavior,
      notchMargin,
      child.map(WidgetI::build),
      padding.map(EdgeInsetsGeometryI::build),
      surfaceTintColor.map(ColorI::build),
      shadowColor.map(ColorI::build),
      height);
    if (id <= 0) throw new RuntimeException("Failed to created widget BottomAppBar");
    return new BottomAppBar(id);
  }
  public static BottomAppBarBottomAppBarBuilder bottomAppBar() {
    return BottomAppBarBottomAppBarBuilder.bottomAppBarBottomAppBar();
  }
  public Widget child() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("bottomAppBarChild not supported on web");
    return factories.BottomAppBar_readBack_child(nativeStruct);
  }
  public EdgeInsetsGeometry padding() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("bottomAppBarPadding not supported on web");
    return factories.BottomAppBar_readBack_padding(nativeStruct);
  }
  public Color color() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("bottomAppBarColor", getId());
      return new Color(__nid);
    }
    return factories.BottomAppBar_readBack_color(nativeStruct);
  }
  public double elevation() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("bottomAppBarElevation not supported on web");
    return factories.BottomAppBar_readBack_elevation(nativeStruct);
  }
  public Clip clipBehavior() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("bottomAppBarClipBehavior not supported on web");
    return factories.BottomAppBar_readBack_clipBehavior(nativeStruct);
  }
  public double notchMargin() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("bottomAppBarNotchMargin not supported on web");
    return factories.BottomAppBar_readBack_notchMargin(nativeStruct);
  }
  public Color surfaceTintColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("bottomAppBarSurfaceTintColor", getId());
      return new Color(__nid);
    }
    return factories.BottomAppBar_readBack_surfaceTintColor(nativeStruct);
  }
  public Color shadowColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("bottomAppBarShadowColor", getId());
      return new Color(__nid);
    }
    return factories.BottomAppBar_readBack_shadowColor(nativeStruct);
  }
  public double height() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("bottomAppBarHeight not supported on web");
    return factories.BottomAppBar_readBack_height(nativeStruct);
  }
  @Override
  public BottomAppBar build() {
    return this;
  }
}
