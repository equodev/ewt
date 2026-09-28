package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class TooltipThemeData extends NativeObj.Base implements TooltipThemeDataI {
  protected TooltipThemeData() {}
  TooltipThemeData(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget TooltipThemeData");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static TooltipThemeData tooltipThemeDataTooltipThemeData(OptionalDouble height, Optional<BoxConstraintsI> constraints, Optional<EdgeInsetsGeometryI> padding, Optional<EdgeInsetsGeometryI> margin, OptionalDouble verticalOffset, Optional<Boolean> preferBelow, Optional<Boolean> excludeFromSemantics, Optional<DecorationI> decoration, Optional<TextStyleI> textStyle, Optional<TextAlign> textAlign, Optional<DurationI> waitDuration, Optional<DurationI> showDuration, Optional<DurationI> exitDuration, Optional<TooltipTriggerMode> triggerMode, Optional<Boolean> enableFeedback) {
    int id = factories.tooltipThemeDataTooltipThemeData(height,
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
    if (id <= 0) throw new RuntimeException("Failed to created widget TooltipThemeData");
    return new TooltipThemeData(id);
  }
  public static TooltipThemeDataTooltipThemeDataBuilder tooltipThemeData() {
    return TooltipThemeDataTooltipThemeDataBuilder.tooltipThemeDataTooltipThemeData();
  }
  public static TooltipThemeData lerp(TooltipThemeDataI a, TooltipThemeDataI b, double t) {
    int id = factories.tooltipThemeDataLerp(a.build(),
      b.build(),
      t);
    if (id <= 0) throw new RuntimeException("Failed to created widget TooltipThemeData");
    return new TooltipThemeData(id);
  }
  public double height() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("tooltipThemeDataHeight not supported on web");
    return factories.TooltipThemeData_readBack_height(nativeStruct);
  }
  public BoxConstraints constraints() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("tooltipThemeDataConstraints", getId());
      return new BoxConstraints(__nid);
    }
    return factories.TooltipThemeData_readBack_constraints(nativeStruct);
  }
  public EdgeInsetsGeometry padding() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("tooltipThemeDataPadding not supported on web");
    return factories.TooltipThemeData_readBack_padding(nativeStruct);
  }
  public EdgeInsetsGeometry margin() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("tooltipThemeDataMargin not supported on web");
    return factories.TooltipThemeData_readBack_margin(nativeStruct);
  }
  public double verticalOffset() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("tooltipThemeDataVerticalOffset not supported on web");
    return factories.TooltipThemeData_readBack_verticalOffset(nativeStruct);
  }
  public boolean preferBelow() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("tooltipThemeDataPreferBelow not supported on web");
    return factories.TooltipThemeData_readBack_preferBelow(nativeStruct);
  }
  public boolean excludeFromSemantics() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("tooltipThemeDataExcludeFromSemantics not supported on web");
    return factories.TooltipThemeData_readBack_excludeFromSemantics(nativeStruct);
  }
  public Decoration decoration() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("tooltipThemeDataDecoration not supported on web");
    return factories.TooltipThemeData_readBack_decoration(nativeStruct);
  }
  public TextStyle textStyle() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("tooltipThemeDataTextStyle", getId());
      return new TextStyle(__nid);
    }
    return factories.TooltipThemeData_readBack_textStyle(nativeStruct);
  }
  public TextAlign textAlign() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("tooltipThemeDataTextAlign not supported on web");
    return factories.TooltipThemeData_readBack_textAlign(nativeStruct);
  }
  public Duration waitDuration() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("tooltipThemeDataWaitDuration", getId());
      return new Duration(__nid);
    }
    return factories.TooltipThemeData_readBack_waitDuration(nativeStruct);
  }
  public Duration showDuration() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("tooltipThemeDataShowDuration", getId());
      return new Duration(__nid);
    }
    return factories.TooltipThemeData_readBack_showDuration(nativeStruct);
  }
  public Duration exitDuration() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("tooltipThemeDataExitDuration", getId());
      return new Duration(__nid);
    }
    return factories.TooltipThemeData_readBack_exitDuration(nativeStruct);
  }
  public TooltipTriggerMode triggerMode() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("tooltipThemeDataTriggerMode not supported on web");
    return factories.TooltipThemeData_readBack_triggerMode(nativeStruct);
  }
  public boolean enableFeedback() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("tooltipThemeDataEnableFeedback not supported on web");
    return factories.TooltipThemeData_readBack_enableFeedback(nativeStruct);
  }
  @Override
  public TooltipThemeData build() {
    return this;
  }
}
