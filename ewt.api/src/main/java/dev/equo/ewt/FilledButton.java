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
  FilledButton(int id) { this.id = id; }
  @Builder.Factory
  static FilledButton filledButtonFilledButton(Optional<Runnable> onPressed, Optional<Runnable> onLongPress, Optional<Consumer<Boolean>> onHover, Optional<Consumer<Boolean>> onFocusChange, Optional<Boolean> autofocus, Optional<Clip> clipBehavior, Optional<WidgetI> child) {
    var st = factories.filledButtonFilledButton(onPressed,
      onLongPress,
      onHover,
      onFocusChange,
      autofocus,
      clipBehavior,
      child.map(WidgetI::build));
    if (st == null) throw new RuntimeException("Failed to created widget FilledButton");
    return new FilledButton(st);
  }
  public static FilledButtonFilledButtonBuilder filledButton() {
    return FilledButtonFilledButtonBuilder.filledButtonFilledButton();
  }
  @Builder.Factory
  static FilledButton filledButtonIcon(Optional<Runnable> onPressed, Optional<Runnable> onLongPress, Optional<Consumer<Boolean>> onHover, Optional<Consumer<Boolean>> onFocusChange, Optional<Boolean> autofocus, Optional<Clip> clipBehavior, Optional<WidgetI> icon, WidgetI label, Optional<IconAlignment> iconAlignment) {
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
  public static FilledButtonIconBuilder icon() {
    return FilledButtonIconBuilder.filledButtonIcon();
  }
  @Builder.Factory
  static FilledButton filledButtonTonal(Optional<Runnable> onPressed, Optional<Runnable> onLongPress, Optional<Consumer<Boolean>> onHover, Optional<Consumer<Boolean>> onFocusChange, Optional<Boolean> autofocus, Optional<Clip> clipBehavior, Optional<WidgetI> child) {
    var st = factories.filledButtonTonal(onPressed,
      onLongPress,
      onHover,
      onFocusChange,
      autofocus,
      clipBehavior,
      child.map(WidgetI::build));
    if (st == null) throw new RuntimeException("Failed to created widget FilledButton");
    return new FilledButton(st);
  }
  public static FilledButtonTonalBuilder tonal() {
    return FilledButtonTonalBuilder.filledButtonTonal();
  }
  @Builder.Factory
  static FilledButton filledButtonTonalIcon(Optional<Runnable> onPressed, Optional<Runnable> onLongPress, Optional<Consumer<Boolean>> onHover, Optional<Consumer<Boolean>> onFocusChange, Optional<Boolean> autofocus, Optional<Clip> clipBehavior, Optional<WidgetI> icon, WidgetI label, Optional<IconAlignment> iconAlignment) {
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
  public static FilledButtonTonalIconBuilder tonalIcon() {
    return FilledButtonTonalIconBuilder.filledButtonTonalIcon();
  }
  @Override
  public FilledButton build() {
    return this;
  }
}
