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
    return TooltipObjSt.message(st).getString(0);
  }
  public InlineSpan richMessage() {
    return new InlineSpan(TooltipObjSt.richMessage(st)) {};
  }
  public double height() {
    return TooltipObjSt.height(st);
  }
  public BoxConstraints constraints() {
    return new BoxConstraints(TooltipObjSt.constraints(st));
  }
  public EdgeInsetsGeometry padding() {
    return new EdgeInsetsGeometry(TooltipObjSt.padding(st)) {};
  }
  public EdgeInsetsGeometry margin() {
    return new EdgeInsetsGeometry(TooltipObjSt.margin(st)) {};
  }
  public double verticalOffset() {
    return TooltipObjSt.verticalOffset(st);
  }
  public boolean preferBelow() {
    return intToBool(TooltipObjSt.preferBelow(st));
  }
  public boolean excludeFromSemantics() {
    return intToBool(TooltipObjSt.excludeFromSemantics(st));
  }
  public Widget child() {
    return new Widget(TooltipObjSt.child(st)) {};
  }
  public Decoration decoration() {
    return new Decoration(TooltipObjSt.decoration(st)) {};
  }
  public TextStyle textStyle() {
    return new TextStyle(TooltipObjSt.textStyle(st));
  }
  public TextAlign textAlign() {
    return TextAlign.values()[TooltipObjSt.textAlign(st)];
  }
  public Duration waitDuration() {
    return new Duration(TooltipObjSt.waitDuration(st));
  }
  public Duration showDuration() {
    return new Duration(TooltipObjSt.showDuration(st));
  }
  public Duration exitDuration() {
    return new Duration(TooltipObjSt.exitDuration(st));
  }
  public boolean enableTapToDismiss() {
    return intToBool(TooltipObjSt.enableTapToDismiss(st));
  }
  public TooltipTriggerMode triggerMode() {
    return TooltipTriggerMode.values()[TooltipObjSt.triggerMode(st)];
  }
  public boolean enableFeedback() {
    return intToBool(TooltipObjSt.enableFeedback(st));
  }
  public boolean ignorePointer() {
    return intToBool(TooltipObjSt.ignorePointer(st));
  }
  @Override
  public Tooltip build() {
    return this;
  }
}
