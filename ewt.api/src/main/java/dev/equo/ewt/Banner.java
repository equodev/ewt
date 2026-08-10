package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.BannerObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class Banner extends StatefulWidget implements BannerI {
  private MemorySegment st;
  protected Banner() {}
  Banner(MemorySegment st) {
    this.id = BannerObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget Banner");
    System.out.println("New Banner id:"+id);
  }
  Banner(int id) { this.id = id; }
  @Builder.Factory
  static Banner bannerBanner(Optional<WidgetI> child, String message, Optional<TextDirection> textDirection, BannerLocation location, Optional<TextDirection> layoutDirection, Optional<ColorI> color, Optional<BoxShadowI> shadow) {
    var st = factories.bannerBanner(child.map(WidgetI::build),
      message,
      textDirection,
      location,
      layoutDirection,
      color.map(ColorI::build),
      shadow.map(BoxShadowI::build));
    if (st == null) throw new RuntimeException("Failed to created widget Banner");
    return new Banner(st);
  }
  public static BannerBannerBuilder banner() {
    return BannerBannerBuilder.bannerBanner();
  }
  public Widget child() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("bannerChild not supported on web");
    return new Widget(BannerObjSt.child(st)) {};
  }
  public String message() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("bannerMessage not supported on web");
    return BannerObjSt.message(st).getString(0);
  }
  public TextDirection textDirection() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("bannerTextDirection not supported on web");
    return TextDirection.values()[BannerObjSt.textDirection(st)];
  }
  public BannerLocation location() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("bannerLocation not supported on web");
    return BannerLocation.values()[BannerObjSt.location(st)];
  }
  public TextDirection layoutDirection() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("bannerLayoutDirection not supported on web");
    return TextDirection.values()[BannerObjSt.layoutDirection(st)];
  }
  public Color color() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("bannerColor", getId());
      return new Color(__nid);
    }
    return new Color(BannerObjSt.color(st));
  }
  public TextStyle textStyle() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("bannerTextStyle", getId());
      java.lang.foreign.MemorySegment __st = dev.equo.ewt.ffm.TextStyleObjSt.allocate(__s.arena);
      dev.equo.ewt.ffm.TextStyleObjSt.id(__st, __nid);
      return new TextStyle(__st);
    }
    return new TextStyle(BannerObjSt.textStyle(st));
  }
  public BoxShadow shadow() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("bannerShadow", getId());
      java.lang.foreign.MemorySegment __st = dev.equo.ewt.ffm.BoxShadowObjSt.allocate(__s.arena);
      dev.equo.ewt.ffm.BoxShadowObjSt.id(__st, __nid);
      return new BoxShadow(__st);
    }
    return new BoxShadow(BannerObjSt.shadow(st));
  }
  @Override
  public Banner build() {
    return this;
  }
}
