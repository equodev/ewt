package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.InkWellObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class InkWell extends InkResponse implements InkWellI {
  private MemorySegment st;
  protected InkWell() {}
  InkWell(MemorySegment st) {
    this.id = InkWellObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget InkWell");
    System.out.println("New InkWell id:"+id);
  }
  InkWell(int id) { this.id = id; }
  @Builder.Factory
  static InkWell inkWellInkWell(Optional<WidgetI> child, Optional<Runnable> onTap, Optional<Runnable> onDoubleTap, Optional<Runnable> onLongPress, Optional<Runnable> onTapCancel, Optional<Runnable> onSecondaryTap, Optional<Runnable> onSecondaryTapCancel, Optional<Consumer<Boolean>> onHighlightChanged, Optional<Consumer<Boolean>> onHover, Optional<ColorI> focusColor, Optional<ColorI> hoverColor, Optional<ColorI> highlightColor, Optional<ColorI> overlayColor, Optional<ColorI> splashColor, OptionalDouble radius, Optional<BorderRadiusI> borderRadius, Optional<ShapeBorderI> customBorder, Optional<Boolean> enableFeedback, Optional<Boolean> excludeFromSemantics, Optional<Boolean> canRequestFocus, Optional<Consumer<Boolean>> onFocusChange, Optional<Boolean> autofocus, Optional<DurationI> hoverDuration) {
    var st = factories.inkWellInkWell(child.map(WidgetI::build),
      onTap,
      onDoubleTap,
      onLongPress,
      onTapCancel,
      onSecondaryTap,
      onSecondaryTapCancel,
      onHighlightChanged,
      onHover,
      focusColor.map(ColorI::build),
      hoverColor.map(ColorI::build),
      highlightColor.map(ColorI::build),
      overlayColor.map(ColorI::build),
      splashColor.map(ColorI::build),
      radius,
      borderRadius.map(BorderRadiusI::build),
      customBorder.map(ShapeBorderI::build),
      enableFeedback,
      excludeFromSemantics,
      canRequestFocus,
      onFocusChange,
      autofocus,
      hoverDuration.map(DurationI::build));
    if (st == null) throw new RuntimeException("Failed to created widget InkWell");
    return new InkWell(st);
  }
  public static InkWellInkWellBuilder inkWell() {
    return InkWellInkWellBuilder.inkWellInkWell();
  }
  @Override
  public InkWell build() {
    return this;
  }
}
