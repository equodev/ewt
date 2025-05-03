package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.FilledButtonObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class FilledButton extends ButtonStyleButton implements FilledButtonI {
  private MemorySegment st;
  protected FilledButton() {}
  FilledButton(MemorySegment st) {
    this.id = FilledButtonObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget FilledButton");
    System.out.println("New FilledButton id:"+id);
  }
  @Builder.Factory
  static FilledButton filledButtonFilledButton(@Builder.Parameter Runnable onPressed, Optional<Runnable> onLongPress, Optional<Consumer<Boolean>> onHover, Optional<Consumer<Boolean>> onFocusChange, Optional<Boolean> autofocus, Optional<Clip> clipBehavior, WidgetI child) {
    var st = factories.filledButtonFilledButton(onPressed,
      onLongPress,
      onHover,
      onFocusChange,
      autofocus,
      clipBehavior,
      child.build());
    if (st == null) throw new RuntimeException("Failed to created widget FilledButton");
    return new FilledButton(st);
  }
  public static FilledButtonFilledButtonBuilder filledButton(Runnable onPressed) {
    return FilledButtonFilledButtonBuilder.filledButtonFilledButton(onPressed);
  }
  @Builder.Factory
  static FilledButton filledButtonIcon(@Builder.Parameter Runnable onPressed, Optional<Runnable> onLongPress, Optional<Consumer<Boolean>> onHover, Optional<Consumer<Boolean>> onFocusChange, Optional<Boolean> autofocus, Optional<Clip> clipBehavior, Optional<WidgetI> icon, WidgetI label, Optional<IconAlignment> iconAlignment) {
    var st = factories.filledButtonIcon(onPressed,
      onLongPress,
      onHover,
      onFocusChange,
      autofocus,
      clipBehavior,
      icon.map(WidgetI::build),
      label.build(),
      iconAlignment);
    if (st == null) throw new RuntimeException("Failed to created widget FilledButton");
    return new FilledButton(st);
  }
  public static FilledButtonIconBuilder icon(Runnable onPressed) {
    return FilledButtonIconBuilder.filledButtonIcon(onPressed);
  }
  @Builder.Factory
  static FilledButton filledButtonTonal(@Builder.Parameter Runnable onPressed, Optional<Runnable> onLongPress, Optional<Consumer<Boolean>> onHover, Optional<Consumer<Boolean>> onFocusChange, Optional<Boolean> autofocus, Optional<Clip> clipBehavior, WidgetI child) {
    var st = factories.filledButtonTonal(onPressed,
      onLongPress,
      onHover,
      onFocusChange,
      autofocus,
      clipBehavior,
      child.build());
    if (st == null) throw new RuntimeException("Failed to created widget FilledButton");
    return new FilledButton(st);
  }
  public static FilledButtonTonalBuilder tonal(Runnable onPressed) {
    return FilledButtonTonalBuilder.filledButtonTonal(onPressed);
  }
  @Builder.Factory
  static FilledButton filledButtonTonalIcon(@Builder.Parameter Runnable onPressed, Optional<Runnable> onLongPress, Optional<Consumer<Boolean>> onHover, Optional<Consumer<Boolean>> onFocusChange, Optional<Boolean> autofocus, Optional<Clip> clipBehavior, Optional<WidgetI> icon, WidgetI label, Optional<IconAlignment> iconAlignment) {
    var st = factories.filledButtonTonalIcon(onPressed,
      onLongPress,
      onHover,
      onFocusChange,
      autofocus,
      clipBehavior,
      icon.map(WidgetI::build),
      label.build(),
      iconAlignment);
    if (st == null) throw new RuntimeException("Failed to created widget FilledButton");
    return new FilledButton(st);
  }
  public static FilledButtonTonalIconBuilder tonalIcon(Runnable onPressed) {
    return FilledButtonTonalIconBuilder.filledButtonTonalIcon(onPressed);
  }
  @Override
  public FilledButton build() {
    return this;
  }
}
