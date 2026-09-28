package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class SnackBar extends StatefulWidget implements SnackBarI {
  protected SnackBar() {}
  SnackBar(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget SnackBar");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static SnackBar snackBarSnackBar(@Builder.Parameter WidgetI content, Optional<ColorI> backgroundColor, OptionalDouble elevation, Optional<EdgeInsetsGeometryI> margin, Optional<EdgeInsetsGeometryI> padding, OptionalDouble width, Optional<ShapeBorderI> shape, Optional<HitTestBehavior> hitTestBehavior, Optional<SnackBarBehavior> behavior, Optional<SnackBarActionI> action, OptionalDouble actionOverflowThreshold, Optional<Boolean> showCloseIcon, Optional<ColorI> closeIconColor, Optional<DurationI> duration, Optional<Boolean> persist, Optional<AnimationI> animation, Optional<Runnable> onVisible, Optional<DismissDirection> dismissDirection, Optional<Clip> clipBehavior) {
    int id = factories.snackBarSnackBar(content.build(),
      backgroundColor.map(ColorI::build),
      elevation,
      margin.map(EdgeInsetsGeometryI::build),
      padding.map(EdgeInsetsGeometryI::build),
      width,
      shape.map(ShapeBorderI::build),
      hitTestBehavior,
      behavior,
      action.map(SnackBarActionI::build),
      actionOverflowThreshold,
      showCloseIcon,
      closeIconColor.map(ColorI::build),
      duration.map(DurationI::build),
      persist,
      animation.map(AnimationI::build),
      onVisible,
      dismissDirection,
      clipBehavior);
    if (id <= 0) throw new RuntimeException("Failed to created widget SnackBar");
    return new SnackBar(id);
  }
  public static SnackBarSnackBarBuilder snackBar(WidgetI content) {
    return SnackBarSnackBarBuilder.snackBarSnackBar(content);
  }
  public static AnimationController createAnimationController(TickerProviderI vsync) {
    var id = factories.snackBarCreateAnimationController(vsync.build(),
      Optional.empty(),
      Optional.empty());
    if (id <= 0) throw new RuntimeException("Failed to created widget AnimationController");
    System.out.println("New AnimationController id:"+id);
    return new AnimationController(id);
  }
  public Widget content() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("snackBarContent not supported on web");
    return factories.SnackBar_readBack_content(nativeStruct);
  }
  public Color backgroundColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("snackBarBackgroundColor", getId());
      return new Color(__nid);
    }
    return factories.SnackBar_readBack_backgroundColor(nativeStruct);
  }
  public double elevation() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("snackBarElevation not supported on web");
    return factories.SnackBar_readBack_elevation(nativeStruct);
  }
  public EdgeInsetsGeometry margin() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("snackBarMargin not supported on web");
    return factories.SnackBar_readBack_margin(nativeStruct);
  }
  public EdgeInsetsGeometry padding() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("snackBarPadding not supported on web");
    return factories.SnackBar_readBack_padding(nativeStruct);
  }
  public double width() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("snackBarWidth not supported on web");
    return factories.SnackBar_readBack_width(nativeStruct);
  }
  public ShapeBorder shape() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("snackBarShape not supported on web");
    return factories.SnackBar_readBack_shape(nativeStruct);
  }
  public HitTestBehavior hitTestBehavior() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("snackBarHitTestBehavior not supported on web");
    return factories.SnackBar_readBack_hitTestBehavior(nativeStruct);
  }
  public SnackBarBehavior behavior() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("snackBarBehavior not supported on web");
    return factories.SnackBar_readBack_behavior(nativeStruct);
  }
  public SnackBarAction action() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("snackBarAction", getId());
      return new SnackBarAction(__nid);
    }
    return factories.SnackBar_readBack_action(nativeStruct);
  }
  public double actionOverflowThreshold() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("snackBarActionOverflowThreshold not supported on web");
    return factories.SnackBar_readBack_actionOverflowThreshold(nativeStruct);
  }
  public boolean showCloseIcon() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("snackBarShowCloseIcon not supported on web");
    return factories.SnackBar_readBack_showCloseIcon(nativeStruct);
  }
  public Color closeIconColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("snackBarCloseIconColor", getId());
      return new Color(__nid);
    }
    return factories.SnackBar_readBack_closeIconColor(nativeStruct);
  }
  public Duration duration() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("snackBarDuration", getId());
      return new Duration(__nid);
    }
    return factories.SnackBar_readBack_duration(nativeStruct);
  }
  public boolean persist() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("snackBarPersist not supported on web");
    return factories.SnackBar_readBack_persist(nativeStruct);
  }
  public Animation animation() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("snackBarAnimation not supported on web");
    return factories.SnackBar_readBack_animation(nativeStruct);
  }
  public DismissDirection dismissDirection() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("snackBarDismissDirection not supported on web");
    return factories.SnackBar_readBack_dismissDirection(nativeStruct);
  }
  public Clip clipBehavior() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("snackBarClipBehavior not supported on web");
    return factories.SnackBar_readBack_clipBehavior(nativeStruct);
  }
  @Override
  public SnackBar build() {
    return this;
  }
}
