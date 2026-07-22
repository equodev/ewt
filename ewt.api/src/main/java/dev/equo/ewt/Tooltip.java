package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.TooltipObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class Tooltip extends StatefulWidget implements TooltipI {
  private MemorySegment st;
  protected Tooltip() {}
  Tooltip(MemorySegment st) {
    this.id = TooltipObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget Tooltip");
    System.out.println("New Tooltip id:"+id);
  }
  Tooltip(int id) { this.id = id; }
  @Builder.Factory
  static Tooltip tooltipTooltip(Optional<String> message, Optional<InlineSpanI> richMessage, OptionalDouble height, Optional<BoxConstraintsI> constraints, Optional<EdgeInsetsGeometryI> padding, Optional<EdgeInsetsGeometryI> margin, OptionalDouble verticalOffset, Optional<Boolean> preferBelow, Optional<Boolean> excludeFromSemantics, Optional<DecorationI> decoration, Optional<TextStyleI> textStyle, Optional<TextAlign> textAlign, Optional<DurationI> waitDuration, Optional<DurationI> showDuration, Optional<DurationI> exitDuration, Optional<Boolean> enableTapToDismiss, Optional<TooltipTriggerMode> triggerMode, Optional<Boolean> enableFeedback, Optional<Runnable> onTriggered, Optional<Boolean> ignorePointer, Optional<WidgetI> child) {
    var st = factories.tooltipTooltip(message,
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
    if (st == null) throw new RuntimeException("Failed to created widget Tooltip");
    return new Tooltip(st);
  }
  public static TooltipTooltipBuilder tooltip() {
    return TooltipTooltipBuilder.tooltipTooltip();
  }
  public static boolean dismissAllToolTips() {
    int id = factories.tooltipDismissAllToolTips();
    if (id <= 0) throw new RuntimeException("Failed to created widget bool");
    System.out.println("New bool id:"+id);
    return intToBool(id);
  }
  public String message() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("tooltipMessage not supported on web");
    return TooltipObjSt.message(st).getString(0);
  }
  public InlineSpan richMessage() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("tooltipRichMessage not supported on web");
    return new InlineSpan(TooltipObjSt.richMessage(st)) {};
  }
  public double height() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("tooltipHeight not supported on web");
    return TooltipObjSt.height(st);
  }
  public BoxConstraints constraints() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("tooltipConstraints", getId());
      java.lang.foreign.MemorySegment __st = dev.equo.ewt.ffm.BoxConstraintsObjSt.allocate(__s.arena);
      dev.equo.ewt.ffm.BoxConstraintsObjSt.id(__st, __nid);
      return new BoxConstraints(__st);
    }
    return new BoxConstraints(TooltipObjSt.constraints(st));
  }
  public EdgeInsetsGeometry padding() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("tooltipPadding not supported on web");
    return new EdgeInsetsGeometry(TooltipObjSt.padding(st)) {};
  }
  public EdgeInsetsGeometry margin() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("tooltipMargin not supported on web");
    return new EdgeInsetsGeometry(TooltipObjSt.margin(st)) {};
  }
  public double verticalOffset() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("tooltipVerticalOffset not supported on web");
    return TooltipObjSt.verticalOffset(st);
  }
  public boolean preferBelow() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("tooltipPreferBelow not supported on web");
    return intToBool(TooltipObjSt.preferBelow(st));
  }
  public boolean excludeFromSemantics() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("tooltipExcludeFromSemantics not supported on web");
    return intToBool(TooltipObjSt.excludeFromSemantics(st));
  }
  public Widget child() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("tooltipChild not supported on web");
    return new Widget(TooltipObjSt.child(st)) {};
  }
  public Decoration decoration() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("tooltipDecoration not supported on web");
    return new Decoration(TooltipObjSt.decoration(st)) {};
  }
  public TextStyle textStyle() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("tooltipTextStyle", getId());
      java.lang.foreign.MemorySegment __st = dev.equo.ewt.ffm.TextStyleObjSt.allocate(__s.arena);
      dev.equo.ewt.ffm.TextStyleObjSt.id(__st, __nid);
      return new TextStyle(__st);
    }
    return new TextStyle(TooltipObjSt.textStyle(st));
  }
  public TextAlign textAlign() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("tooltipTextAlign not supported on web");
    return TextAlign.values()[TooltipObjSt.textAlign(st)];
  }
  public Duration waitDuration() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("tooltipWaitDuration", getId());
      return new Duration(__nid);
    }
    return new Duration(TooltipObjSt.waitDuration(st));
  }
  public Duration showDuration() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("tooltipShowDuration", getId());
      return new Duration(__nid);
    }
    return new Duration(TooltipObjSt.showDuration(st));
  }
  public Duration exitDuration() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) {
      SerializingWidgetConstructors __s = (SerializingWidgetConstructors) factories;
      int __nid = __s.recordAccessor("tooltipExitDuration", getId());
      return new Duration(__nid);
    }
    return new Duration(TooltipObjSt.exitDuration(st));
  }
  public boolean enableTapToDismiss() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("tooltipEnableTapToDismiss not supported on web");
    return intToBool(TooltipObjSt.enableTapToDismiss(st));
  }
  public TooltipTriggerMode triggerMode() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("tooltipTriggerMode not supported on web");
    return TooltipTriggerMode.values()[TooltipObjSt.triggerMode(st)];
  }
  public boolean enableFeedback() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("tooltipEnableFeedback not supported on web");
    return intToBool(TooltipObjSt.enableFeedback(st));
  }
  public boolean ignorePointer() {
    if (dev.equo.ewt.web.EwtWebTransport.isWebMode()) throw new UnsupportedOperationException("tooltipIgnorePointer not supported on web");
    return intToBool(TooltipObjSt.ignorePointer(st));
  }
  @Override
  public Tooltip build() {
    return this;
  }
}
