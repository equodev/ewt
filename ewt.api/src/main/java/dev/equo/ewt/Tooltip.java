package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class Tooltip extends StatefulWidget implements TooltipI {
  protected Tooltip() {}
  Tooltip(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget Tooltip");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static Tooltip tooltipTooltip(Optional<String> message, Optional<InlineSpanI> richMessage, OptionalDouble height, Optional<BoxConstraintsI> constraints, Optional<EdgeInsetsGeometryI> padding, Optional<EdgeInsetsGeometryI> margin, OptionalDouble verticalOffset, Optional<Boolean> preferBelow, Optional<Boolean> excludeFromSemantics, Optional<DecorationI> decoration, Optional<TextStyleI> textStyle, Optional<TextAlign> textAlign, Optional<DurationI> waitDuration, Optional<DurationI> showDuration, Optional<DurationI> exitDuration, Optional<Boolean> enableTapToDismiss, Optional<TooltipTriggerMode> triggerMode, Optional<Boolean> enableFeedback, Optional<Runnable> onTriggered, Optional<Boolean> ignorePointer, Optional<WidgetI> child) {
    int id = factories.tooltipTooltip(message,
      richMessage.map(InlineSpanI::build),
      height,
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
      enableTapToDismiss,
      triggerMode,
      enableFeedback,
      onTriggered,
      ignorePointer,
      child.map(WidgetI::build));
    if (id <= 0) throw new RuntimeException("Failed to created widget Tooltip");
    return new Tooltip(id);
  }
  public static TooltipTooltipBuilder tooltip() {
    return TooltipTooltipBuilder.tooltipTooltip();
  }
  public static boolean dismissAllToolTips() {
    var id = factories.tooltipDismissAllToolTips();
    if (id <= 0) throw new RuntimeException("Failed to created widget bool");
    System.out.println("New bool id:"+id);
    return intToBool(id);
  }
  public String message() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("tooltipMessage not supported on web");
    return factories.Tooltip_readBack_message(nativeStruct);
  }
  public InlineSpan richMessage() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("tooltipRichMessage not supported on web");
    return factories.Tooltip_readBack_richMessage(nativeStruct);
  }
  public double height() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("tooltipHeight not supported on web");
    return factories.Tooltip_readBack_height(nativeStruct);
  }
  public BoxConstraints constraints() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("tooltipConstraints", getId());
      return new BoxConstraints(__nid);
    }
    return factories.Tooltip_readBack_constraints(nativeStruct);
  }
  public EdgeInsetsGeometry padding() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("tooltipPadding not supported on web");
    return factories.Tooltip_readBack_padding(nativeStruct);
  }
  public EdgeInsetsGeometry margin() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("tooltipMargin not supported on web");
    return factories.Tooltip_readBack_margin(nativeStruct);
  }
  public double verticalOffset() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("tooltipVerticalOffset not supported on web");
    return factories.Tooltip_readBack_verticalOffset(nativeStruct);
  }
  public boolean preferBelow() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("tooltipPreferBelow not supported on web");
    return factories.Tooltip_readBack_preferBelow(nativeStruct);
  }
  public boolean excludeFromSemantics() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("tooltipExcludeFromSemantics not supported on web");
    return factories.Tooltip_readBack_excludeFromSemantics(nativeStruct);
  }
  public Widget child() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("tooltipChild not supported on web");
    return factories.Tooltip_readBack_child(nativeStruct);
  }
  public Decoration decoration() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("tooltipDecoration not supported on web");
    return factories.Tooltip_readBack_decoration(nativeStruct);
  }
  public TextStyle textStyle() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("tooltipTextStyle", getId());
      return new TextStyle(__nid);
    }
    return factories.Tooltip_readBack_textStyle(nativeStruct);
  }
  public TextAlign textAlign() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("tooltipTextAlign not supported on web");
    return factories.Tooltip_readBack_textAlign(nativeStruct);
  }
  public Duration waitDuration() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("tooltipWaitDuration", getId());
      return new Duration(__nid);
    }
    return factories.Tooltip_readBack_waitDuration(nativeStruct);
  }
  public Duration showDuration() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("tooltipShowDuration", getId());
      return new Duration(__nid);
    }
    return factories.Tooltip_readBack_showDuration(nativeStruct);
  }
  public Duration exitDuration() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("tooltipExitDuration", getId());
      return new Duration(__nid);
    }
    return factories.Tooltip_readBack_exitDuration(nativeStruct);
  }
  public boolean enableTapToDismiss() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("tooltipEnableTapToDismiss not supported on web");
    return factories.Tooltip_readBack_enableTapToDismiss(nativeStruct);
  }
  public TooltipTriggerMode triggerMode() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("tooltipTriggerMode not supported on web");
    return factories.Tooltip_readBack_triggerMode(nativeStruct);
  }
  public boolean enableFeedback() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("tooltipEnableFeedback not supported on web");
    return factories.Tooltip_readBack_enableFeedback(nativeStruct);
  }
  public boolean ignorePointer() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("tooltipIgnorePointer not supported on web");
    return factories.Tooltip_readBack_ignorePointer(nativeStruct);
  }
  @Override
  public Tooltip build() {
    return this;
  }
}
