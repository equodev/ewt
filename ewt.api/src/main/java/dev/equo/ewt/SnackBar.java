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
  @Builder.Factory
  static SnackBar snackBarSnackBar(@Builder.Parameter WidgetI content, Optional<ColorI> backgroundColor, OptionalDouble elevation, Optional<EdgeInsetsGeometryI> margin, Optional<EdgeInsetsGeometryI> padding, OptionalDouble width, Optional<ShapeBorderI> shape, Optional<HitTestBehavior> hitTestBehavior, Optional<SnackBarBehavior> behavior, Optional<SnackBarActionI> action, OptionalDouble actionOverflowThreshold, Optional<Boolean> showCloseIcon, Optional<ColorI> closeIconColor, Optional<DurationI> duration, Optional<Boolean> persist, Optional<AnimationI> animation, Optional<Runnable> onVisible, Optional<DismissDirection> dismissDirection, Optional<Clip> clipBehavior) {
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
      persist,
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
    return new Widget(SnackBarObjSt.content(st)) {};
  }
  public Color backgroundColor() {
    return new Color(SnackBarObjSt.backgroundColor(st));
  }
  public double elevation() {
    return SnackBarObjSt.elevation(st);
  }
  public EdgeInsetsGeometry margin() {
    return new EdgeInsetsGeometry(SnackBarObjSt.margin(st)) {};
  }
  public EdgeInsetsGeometry padding() {
    return new EdgeInsetsGeometry(SnackBarObjSt.padding(st)) {};
  }
  public double width() {
    return SnackBarObjSt.width(st);
  }
  public ShapeBorder shape() {
    return new ShapeBorder(SnackBarObjSt.shape(st)) {};
  }
  public HitTestBehavior hitTestBehavior() {
    return HitTestBehavior.values()[SnackBarObjSt.hitTestBehavior(st)];
  }
  public SnackBarBehavior behavior() {
    return SnackBarBehavior.values()[SnackBarObjSt.behavior(st)];
  }
  public SnackBarAction action() {
    return new SnackBarAction(SnackBarObjSt.action(st));
  }
  public double actionOverflowThreshold() {
    return SnackBarObjSt.actionOverflowThreshold(st);
  }
  public boolean showCloseIcon() {
    return intToBool(SnackBarObjSt.showCloseIcon(st));
  }
  public Color closeIconColor() {
    return new Color(SnackBarObjSt.closeIconColor(st));
  }
  public Duration duration() {
    return new Duration(SnackBarObjSt.duration(st));
  }
  public boolean persist() {
    return intToBool(SnackBarObjSt.persist(st));
  }
  public Animation animation() {
    return new Animation() { public int getId() { return SnackBarObjSt.animation(st); } };
  }
  public DismissDirection dismissDirection() {
    return DismissDirection.values()[SnackBarObjSt.dismissDirection(st)];
  }
  public Clip clipBehavior() {
    return Clip.values()[SnackBarObjSt.clipBehavior(st)];
  }
  @Override
  public SnackBar build() {
    return this;
  }
}
