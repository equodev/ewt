package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class Banner extends StatefulWidget implements BannerI {
  protected Banner() {}
  Banner(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget Banner");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static Banner bannerBanner(Optional<WidgetI> child, String message, Optional<TextDirection> textDirection, BannerLocation location, Optional<TextDirection> layoutDirection, Optional<ColorI> color, Optional<BoxShadowI> shadow) {
    int id = factories.bannerBanner(child.map(WidgetI::build),
      message,
      textDirection,
      location,
      layoutDirection,
      color.map(ColorI::build),
      shadow.map(BoxShadowI::build));
    if (id <= 0) throw new RuntimeException("Failed to created widget Banner");
    return new Banner(id);
  }
  public static BannerBannerBuilder banner() {
    return BannerBannerBuilder.bannerBanner();
  }
  public Widget child() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("bannerChild not supported on web");
    return factories.Banner_readBack_child(nativeStruct);
  }
  public String message() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("bannerMessage not supported on web");
    return factories.Banner_readBack_message(nativeStruct);
  }
  public TextDirection textDirection() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("bannerTextDirection not supported on web");
    return factories.Banner_readBack_textDirection(nativeStruct);
  }
  public BannerLocation location() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("bannerLocation not supported on web");
    return factories.Banner_readBack_location(nativeStruct);
  }
  public TextDirection layoutDirection() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("bannerLayoutDirection not supported on web");
    return factories.Banner_readBack_layoutDirection(nativeStruct);
  }
  public Color color() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("bannerColor", getId());
      return new Color(__nid);
    }
    return factories.Banner_readBack_color(nativeStruct);
  }
  public TextStyle textStyle() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("bannerTextStyle", getId());
      return new TextStyle(__nid);
    }
    return factories.Banner_readBack_textStyle(nativeStruct);
  }
  public BoxShadow shadow() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("bannerShadow", getId());
      return new BoxShadow(__nid);
    }
    return factories.Banner_readBack_shadow(nativeStruct);
  }
  @Override
  public Banner build() {
    return this;
  }
}
