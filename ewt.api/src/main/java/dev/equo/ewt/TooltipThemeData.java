package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.TooltipThemeDataObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class TooltipThemeData extends NativeObj.Base implements TooltipThemeDataI {
  private MemorySegment st;
  protected TooltipThemeData() {}
  TooltipThemeData(MemorySegment st) {
    this.id = TooltipThemeDataObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget TooltipThemeData");
    System.out.println("New TooltipThemeData id:"+id);
  }
  TooltipThemeData(int id) { this.id = id; }
  @Builder.Factory
  static TooltipThemeData tooltipThemeDataTooltipThemeData(OptionalDouble height, Optional<BoxConstraintsI> constraints, Optional<EdgeInsetsGeometryI> padding, Optional<EdgeInsetsGeometryI> margin, OptionalDouble verticalOffset, Optional<Boolean> preferBelow, Optional<Boolean> excludeFromSemantics, Optional<DecorationI> decoration, Optional<TextStyleI> textStyle, Optional<TextAlign> textAlign, Optional<DurationI> waitDuration, Optional<DurationI> showDuration, Optional<DurationI> exitDuration, Optional<TooltipTriggerMode> triggerMode, Optional<Boolean> enableFeedback) {
    var st = factories.tooltipThemeDataTooltipThemeData(height,
      constraints.map(BoxConstraintsI::build),
      padding.map(EdgeInsetsGeometryI::build),
      margin.map(EdgeInsetsGeometryI::build),
      verticalOffset,
      preferBelow,
      excludeFromSemantics,
      decoration.map(DecorationI::build),
      textStyle.map(TextStyleI::build),
      textAlign,
      waitDuration.map(DurationI::build),
      showDuration.map(DurationI::build),
      exitDuration.map(DurationI::build),
      triggerMode,
      enableFeedback);
    if (st == null) throw new RuntimeException("Failed to created widget TooltipThemeData");
    return new TooltipThemeData(st);
  }
  public static TooltipThemeDataTooltipThemeDataBuilder tooltipThemeData() {
    return TooltipThemeDataTooltipThemeDataBuilder.tooltipThemeDataTooltipThemeData();
  }
  public static TooltipThemeData lerp(TooltipThemeDataI a, TooltipThemeDataI b, double t) {
    var st = factories.tooltipThemeDataLerp(a.build(),
      b.build(),
      t);
    if (st == null) throw new RuntimeException("Failed to created widget TooltipThemeData");
    return new TooltipThemeData(st);
  }
  public double height() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("tooltipThemeDataHeight not supported on web");
    return TooltipThemeDataObjSt.height(st);
  }
  public BoxConstraints constraints() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("tooltipThemeDataConstraints", getId());
      java.lang.foreign.MemorySegment __st = dev.equo.ewt.ffm.BoxConstraintsObjSt.allocate(__s.arena);
      dev.equo.ewt.ffm.BoxConstraintsObjSt.id(__st, __nid);
      return new BoxConstraints(__st);
    }
    return new BoxConstraints(TooltipThemeDataObjSt.constraints(st));
  }
  public EdgeInsetsGeometry padding() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("tooltipThemeDataPadding not supported on web");
    return new EdgeInsetsGeometry(TooltipThemeDataObjSt.padding(st)) {};
  }
  public EdgeInsetsGeometry margin() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("tooltipThemeDataMargin not supported on web");
    return new EdgeInsetsGeometry(TooltipThemeDataObjSt.margin(st)) {};
  }
  public double verticalOffset() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("tooltipThemeDataVerticalOffset not supported on web");
    return TooltipThemeDataObjSt.verticalOffset(st);
  }
  public boolean preferBelow() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("tooltipThemeDataPreferBelow not supported on web");
    return intToBool(TooltipThemeDataObjSt.preferBelow(st));
  }
  public boolean excludeFromSemantics() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("tooltipThemeDataExcludeFromSemantics not supported on web");
    return intToBool(TooltipThemeDataObjSt.excludeFromSemantics(st));
  }
  public Decoration decoration() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("tooltipThemeDataDecoration not supported on web");
    return new Decoration(TooltipThemeDataObjSt.decoration(st)) {};
  }
  public TextStyle textStyle() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("tooltipThemeDataTextStyle", getId());
      java.lang.foreign.MemorySegment __st = dev.equo.ewt.ffm.TextStyleObjSt.allocate(__s.arena);
      dev.equo.ewt.ffm.TextStyleObjSt.id(__st, __nid);
      return new TextStyle(__st);
    }
    return new TextStyle(TooltipThemeDataObjSt.textStyle(st));
  }
  public TextAlign textAlign() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("tooltipThemeDataTextAlign not supported on web");
    return TextAlign.values()[TooltipThemeDataObjSt.textAlign(st)];
  }
  public Duration waitDuration() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("tooltipThemeDataWaitDuration", getId());
      return new Duration(__nid);
    }
    return new Duration(TooltipThemeDataObjSt.waitDuration(st));
  }
  public Duration showDuration() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("tooltipThemeDataShowDuration", getId());
      return new Duration(__nid);
    }
    return new Duration(TooltipThemeDataObjSt.showDuration(st));
  }
  public Duration exitDuration() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("tooltipThemeDataExitDuration", getId());
      return new Duration(__nid);
    }
    return new Duration(TooltipThemeDataObjSt.exitDuration(st));
  }
  public TooltipTriggerMode triggerMode() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("tooltipThemeDataTriggerMode not supported on web");
    return TooltipTriggerMode.values()[TooltipThemeDataObjSt.triggerMode(st)];
  }
  public boolean enableFeedback() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("tooltipThemeDataEnableFeedback not supported on web");
    return intToBool(TooltipThemeDataObjSt.enableFeedback(st));
  }
  @Override
  public TooltipThemeData build() {
    return this;
  }
}
