package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class InkWell extends InkResponse implements InkWellI {
  protected InkWell() {}
  InkWell(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget InkWell");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static InkWell inkWellInkWell(Optional<WidgetI> child, Optional<Runnable> onTap, Optional<Runnable> onDoubleTap, Optional<Runnable> onLongPress, Optional<Runnable> onLongPressUp, Optional<Consumer<TapDownDetails>> onTapDown, Optional<Consumer<TapUpDetails>> onTapUp, Optional<Runnable> onTapCancel, Optional<Runnable> onSecondaryTap, Optional<Consumer<TapUpDetails>> onSecondaryTapUp, Optional<Consumer<TapDownDetails>> onSecondaryTapDown, Optional<Runnable> onSecondaryTapCancel, Optional<Consumer<Boolean>> onHighlightChanged, Optional<Consumer<Boolean>> onHover, Optional<ColorI> focusColor, Optional<ColorI> hoverColor, Optional<ColorI> highlightColor, Optional<ColorI> overlayColor, Optional<ColorI> splashColor, OptionalDouble radius, Optional<BorderRadiusI> borderRadius, Optional<ShapeBorderI> customBorder, Optional<Boolean> enableFeedback, Optional<Boolean> excludeFromSemantics, Optional<Boolean> canRequestFocus, Optional<Consumer<Boolean>> onFocusChange, Optional<Boolean> autofocus, Optional<DurationI> hoverDuration) {
    int id = factories.inkWellInkWell(child.map(WidgetI::build),
      onTap,
      onDoubleTap,
      onLongPress,
      onLongPressUp,
      onTapDown,
      onTapUp,
      onTapCancel,
      onSecondaryTap,
      onSecondaryTapUp,
      onSecondaryTapDown,
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
    if (id <= 0) throw new RuntimeException("Failed to created widget InkWell");
    return new InkWell(id);
  }
  public static InkWellInkWellBuilder inkWell() {
    return InkWellInkWellBuilder.inkWellInkWell();
  }
  @Override
  public InkWell build() {
    return this;
  }
}
