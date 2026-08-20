package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.MaterialBannerObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class MaterialBanner extends StatefulWidget implements MaterialBannerI {
  private MemorySegment st;
  protected MaterialBanner() {}
  MaterialBanner(MemorySegment st) {
    this.id = MaterialBannerObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget MaterialBanner");
    System.out.println("New MaterialBanner id:"+id);
  }
  MaterialBanner(int id) { this.id = id; }
  @Builder.Factory
  static MaterialBanner materialBannerMaterialBanner(@Builder.Parameter WidgetI content, Optional<TextStyleI> contentTextStyle, List<WidgetI> actions, OptionalDouble elevation, Optional<WidgetI> leading, Optional<ColorI> backgroundColor, Optional<ColorI> surfaceTintColor, Optional<ColorI> shadowColor, Optional<ColorI> dividerColor, Optional<EdgeInsetsGeometryI> padding, Optional<EdgeInsetsGeometryI> margin, Optional<EdgeInsetsGeometryI> leadingPadding, Optional<Boolean> forceActionsBelow, Optional<OverflowBarAlignment> overflowAlignment, Optional<AnimationI> animation, Optional<Runnable> onVisible, OptionalDouble minActionBarHeight) {
    var st = factories.materialBannerMaterialBanner(content.build(),
      contentTextStyle.map(TextStyleI::build),
      actions.stream().map(WidgetI::build).toList(),
      elevation,
      leading.map(WidgetI::build),
      backgroundColor.map(ColorI::build),
      surfaceTintColor.map(ColorI::build),
      shadowColor.map(ColorI::build),
      dividerColor.map(ColorI::build),
      padding.map(EdgeInsetsGeometryI::build),
      margin.map(EdgeInsetsGeometryI::build),
      leadingPadding.map(EdgeInsetsGeometryI::build),
      forceActionsBelow,
      overflowAlignment,
      animation.map(AnimationI::build),
      onVisible,
      minActionBarHeight);
    if (st == null) throw new RuntimeException("Failed to created widget MaterialBanner");
    return new MaterialBanner(st);
  }
  public static MaterialBannerMaterialBannerBuilder materialBanner(WidgetI content) {
    return MaterialBannerMaterialBannerBuilder.materialBannerMaterialBanner(content);
  }
  public static AnimationController createAnimationController(TickerProviderI vsync) {
    int id = factories.materialBannerCreateAnimationController(vsync.build());
    if (id <= 0) throw new RuntimeException("Failed to created widget AnimationController");
    System.out.println("New AnimationController id:"+id);
    return new AnimationController(id);
  }
  public Widget content() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("materialBannerContent not supported on web");
    return new Widget(MaterialBannerObjSt.content(st)) {};
  }
  public TextStyle contentTextStyle() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("materialBannerContentTextStyle", getId());
      java.lang.foreign.MemorySegment __st = dev.equo.ewt.ffm.TextStyleObjSt.allocate(__s.arena);
      dev.equo.ewt.ffm.TextStyleObjSt.id(__st, __nid);
      return new TextStyle(__st);
    }
    return new TextStyle(MaterialBannerObjSt.contentTextStyle(st));
  }
  public double elevation() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("materialBannerElevation not supported on web");
    return MaterialBannerObjSt.elevation(st);
  }
  public Widget leading() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("materialBannerLeading not supported on web");
    return new Widget(MaterialBannerObjSt.leading(st)) {};
  }
  public double minActionBarHeight() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("materialBannerMinActionBarHeight not supported on web");
    return MaterialBannerObjSt.minActionBarHeight(st);
  }
  public Color backgroundColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("materialBannerBackgroundColor", getId());
      return new Color(__nid);
    }
    return new Color(MaterialBannerObjSt.backgroundColor(st));
  }
  public Color surfaceTintColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("materialBannerSurfaceTintColor", getId());
      return new Color(__nid);
    }
    return new Color(MaterialBannerObjSt.surfaceTintColor(st));
  }
  public Color shadowColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("materialBannerShadowColor", getId());
      return new Color(__nid);
    }
    return new Color(MaterialBannerObjSt.shadowColor(st));
  }
  public Color dividerColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("materialBannerDividerColor", getId());
      return new Color(__nid);
    }
    return new Color(MaterialBannerObjSt.dividerColor(st));
  }
  public EdgeInsetsGeometry padding() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("materialBannerPadding not supported on web");
    return new EdgeInsetsGeometry(MaterialBannerObjSt.padding(st)) {};
  }
  public EdgeInsetsGeometry margin() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("materialBannerMargin not supported on web");
    return new EdgeInsetsGeometry(MaterialBannerObjSt.margin(st)) {};
  }
  public EdgeInsetsGeometry leadingPadding() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("materialBannerLeadingPadding not supported on web");
    return new EdgeInsetsGeometry(MaterialBannerObjSt.leadingPadding(st)) {};
  }
  public boolean forceActionsBelow() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("materialBannerForceActionsBelow not supported on web");
    return intToBool(MaterialBannerObjSt.forceActionsBelow(st));
  }
  public OverflowBarAlignment overflowAlignment() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("materialBannerOverflowAlignment not supported on web");
    return OverflowBarAlignment.values()[MaterialBannerObjSt.overflowAlignment(st)];
  }
  public Animation animation() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("materialBannerAnimation not supported on web");
    return new Animation() { public int getId() { return MaterialBannerObjSt.animation(st); } };
  }
  @Override
  public MaterialBanner build() {
    return this;
  }
}
