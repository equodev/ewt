package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.SnackBarObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class SnackBar extends StatefulWidget implements SnackBarI {
  private MemorySegment st;
  protected SnackBar() {}
  SnackBar(MemorySegment st) {
    this.id = SnackBarObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget SnackBar");
    System.out.println("New SnackBar id:"+id);
  }
  SnackBar(int id) { this.id = id; }
  @Builder.Factory
  static SnackBar snackBarSnackBar(@Builder.Parameter WidgetI content, Optional<ColorI> backgroundColor, OptionalDouble elevation, Optional<EdgeInsetsGeometryI> margin, Optional<EdgeInsetsGeometryI> padding, OptionalDouble width, Optional<ShapeBorderI> shape, Optional<HitTestBehavior> hitTestBehavior, Optional<SnackBarBehavior> behavior, Optional<SnackBarActionI> action, OptionalDouble actionOverflowThreshold, Optional<Boolean> showCloseIcon, Optional<ColorI> closeIconColor, Optional<DurationI> duration, Optional<AnimationI> animation, Optional<Runnable> onVisible, Optional<DismissDirection> dismissDirection, Optional<Clip> clipBehavior) {
    var st = factories.snackBarSnackBar(content.build(),
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
      animation.map(AnimationI::build),
      onVisible,
      dismissDirection,
      clipBehavior);
    if (st == null) throw new RuntimeException("Failed to created widget SnackBar");
    return new SnackBar(st);
  }
  public static SnackBarSnackBarBuilder snackBar(WidgetI content) {
    return SnackBarSnackBarBuilder.snackBarSnackBar(content);
  }
  public static AnimationController createAnimationController(TickerProviderI vsync) {
    int id = factories.snackBarCreateAnimationController(vsync.build(),
      Optional.empty(),
      Optional.empty());
    if (id <= 0) throw new RuntimeException("Failed to created widget AnimationController");
    System.out.println("New AnimationController id:"+id);
    return new AnimationController(id);
  }
  public Widget content() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("snackBarContent not supported on web");
    return new Widget(SnackBarObjSt.content(st)) {};
  }
  public Color backgroundColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("snackBarBackgroundColor", getId());
      return new Color(__nid);
    }
    return new Color(SnackBarObjSt.backgroundColor(st));
  }
  public double elevation() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("snackBarElevation not supported on web");
    return SnackBarObjSt.elevation(st);
  }
  public EdgeInsetsGeometry margin() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("snackBarMargin not supported on web");
    return new EdgeInsetsGeometry(SnackBarObjSt.margin(st)) {};
  }
  public EdgeInsetsGeometry padding() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("snackBarPadding not supported on web");
    return new EdgeInsetsGeometry(SnackBarObjSt.padding(st)) {};
  }
  public double width() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("snackBarWidth not supported on web");
    return SnackBarObjSt.width(st);
  }
  public ShapeBorder shape() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("snackBarShape not supported on web");
    return new ShapeBorder(SnackBarObjSt.shape(st)) {};
  }
  public HitTestBehavior hitTestBehavior() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("snackBarHitTestBehavior not supported on web");
    return HitTestBehavior.values()[SnackBarObjSt.hitTestBehavior(st)];
  }
  public SnackBarBehavior behavior() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("snackBarBehavior not supported on web");
    return SnackBarBehavior.values()[SnackBarObjSt.behavior(st)];
  }
  public SnackBarAction action() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("snackBarAction", getId());
      java.lang.foreign.MemorySegment __st = dev.equo.ewt.ffm.SnackBarActionObjSt.allocate(__s.arena);
      dev.equo.ewt.ffm.SnackBarActionObjSt.id(__st, __nid);
      return new SnackBarAction(__st);
    }
    return new SnackBarAction(SnackBarObjSt.action(st));
  }
  public double actionOverflowThreshold() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("snackBarActionOverflowThreshold not supported on web");
    return SnackBarObjSt.actionOverflowThreshold(st);
  }
  public boolean showCloseIcon() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("snackBarShowCloseIcon not supported on web");
    return intToBool(SnackBarObjSt.showCloseIcon(st));
  }
  public Color closeIconColor() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("snackBarCloseIconColor", getId());
      return new Color(__nid);
    }
    return new Color(SnackBarObjSt.closeIconColor(st));
  }
  public Duration duration() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("snackBarDuration", getId());
      return new Duration(__nid);
    }
    return new Duration(SnackBarObjSt.duration(st));
  }
  public Animation animation() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("snackBarAnimation not supported on web");
    return new Animation() { public int getId() { return SnackBarObjSt.animation(st); } };
  }
  public DismissDirection dismissDirection() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("snackBarDismissDirection not supported on web");
    return DismissDirection.values()[SnackBarObjSt.dismissDirection(st)];
  }
  public Clip clipBehavior() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("snackBarClipBehavior not supported on web");
    return Clip.values()[SnackBarObjSt.clipBehavior(st)];
  }
  @Override
  public SnackBar build() {
    return this;
  }
}
