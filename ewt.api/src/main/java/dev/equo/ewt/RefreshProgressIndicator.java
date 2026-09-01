package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.RefreshProgressIndicatorObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class RefreshProgressIndicator extends CircularProgressIndicator implements RefreshProgressIndicatorI {
  private MemorySegment st;
  protected RefreshProgressIndicator() {}
  RefreshProgressIndicator(MemorySegment st) {
    this.id = RefreshProgressIndicatorObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget RefreshProgressIndicator");
    System.out.println("New RefreshProgressIndicator id:"+id);
  }
  RefreshProgressIndicator(int id) { this.id = id; }
  @Builder.Factory
  static RefreshProgressIndicator refreshProgressIndicatorRefreshProgressIndicator(OptionalDouble value, Optional<ColorI> backgroundColor, Optional<ColorI> color, Optional<AnimationI> valueColor, OptionalDouble strokeWidth, OptionalDouble strokeAlign, Optional<String> semanticsLabel, Optional<String> semanticsValue, Optional<StrokeCap> strokeCap, OptionalDouble elevation, Optional<EdgeInsetsGeometryI> indicatorMargin, Optional<EdgeInsetsGeometryI> indicatorPadding) {
    var st = factories.refreshProgressIndicatorRefreshProgressIndicator(value,
      backgroundColor.map(ColorI::build),
      color.map(ColorI::build),
      valueColor.map(AnimationI::build),
      strokeWidth,
      strokeAlign,
      semanticsLabel,
      semanticsValue,
      strokeCap,
      elevation,
      indicatorMargin.map(EdgeInsetsGeometryI::build),
      indicatorPadding.map(EdgeInsetsGeometryI::build));
    if (st == null) throw new RuntimeException("Failed to created widget RefreshProgressIndicator");
    return new RefreshProgressIndicator(st);
  }
  public static RefreshProgressIndicatorRefreshProgressIndicatorBuilder refreshProgressIndicator() {
    return RefreshProgressIndicatorRefreshProgressIndicatorBuilder.refreshProgressIndicatorRefreshProgressIndicator();
  }
  public double elevation() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("refreshProgressIndicatorElevation not supported on web");
    return RefreshProgressIndicatorObjSt.elevation(st);
  }
  public EdgeInsetsGeometry indicatorMargin() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("refreshProgressIndicatorIndicatorMargin not supported on web");
    return new EdgeInsetsGeometry(RefreshProgressIndicatorObjSt.indicatorMargin(st)) {};
  }
  public EdgeInsetsGeometry indicatorPadding() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("refreshProgressIndicatorIndicatorPadding not supported on web");
    return new EdgeInsetsGeometry(RefreshProgressIndicatorObjSt.indicatorPadding(st)) {};
  }
  public static double defaultStrokeWidth() {
    return 2.5;
  }
  @Override
  public RefreshProgressIndicator build() {
    return this;
  }
}
