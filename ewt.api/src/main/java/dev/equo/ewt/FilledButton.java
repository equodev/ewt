package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class FilledButton extends ButtonStyleButton implements FilledButtonI {
  protected FilledButton() {}
  FilledButton(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget FilledButton");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static FilledButton filledButtonFilledButton(Optional<Runnable> onPressed, Optional<Runnable> onLongPress, Optional<Consumer<Boolean>> onHover, Optional<Consumer<Boolean>> onFocusChange, Optional<Boolean> autofocus, Optional<Clip> clipBehavior, Optional<WidgetI> child) {
    int id = factories.filledButtonFilledButton(onPressed,
      onLongPress,
      onHover,
      onFocusChange,
      autofocus,
      clipBehavior,
      child.map(WidgetI::build));
    if (id <= 0) throw new RuntimeException("Failed to created widget FilledButton");
    return new FilledButton(id);
  }
  public static FilledButtonFilledButtonBuilder filledButton() {
    return FilledButtonFilledButtonBuilder.filledButtonFilledButton();
  }
  @Builder.Factory
  static FilledButton filledButtonIcon(Optional<Runnable> onPressed, Optional<Runnable> onLongPress, Optional<Consumer<Boolean>> onHover, Optional<Consumer<Boolean>> onFocusChange, Optional<Boolean> autofocus, Optional<Clip> clipBehavior, Optional<WidgetI> icon, WidgetI label, Optional<IconAlignment> iconAlignment) {
    int id = factories.filledButtonIcon(onPressed,
      onLongPress,
      onHover,
      onFocusChange,
      autofocus,
      clipBehavior,
      icon.map(WidgetI::build),
      label.build(),
      iconAlignment);
    if (id <= 0) throw new RuntimeException("Failed to created widget FilledButton");
    return new FilledButton(id);
  }
  public static FilledButtonIconBuilder icon() {
    return FilledButtonIconBuilder.filledButtonIcon();
  }
  @Builder.Factory
  static FilledButton filledButtonTonal(Optional<Runnable> onPressed, Optional<Runnable> onLongPress, Optional<Consumer<Boolean>> onHover, Optional<Consumer<Boolean>> onFocusChange, Optional<Boolean> autofocus, Optional<Clip> clipBehavior, Optional<WidgetI> child) {
    int id = factories.filledButtonTonal(onPressed,
      onLongPress,
      onHover,
      onFocusChange,
      autofocus,
      clipBehavior,
      child.map(WidgetI::build));
    if (id <= 0) throw new RuntimeException("Failed to created widget FilledButton");
    return new FilledButton(id);
  }
  public static FilledButtonTonalBuilder tonal() {
    return FilledButtonTonalBuilder.filledButtonTonal();
  }
  @Builder.Factory
  static FilledButton filledButtonTonalIcon(Optional<Runnable> onPressed, Optional<Runnable> onLongPress, Optional<Consumer<Boolean>> onHover, Optional<Consumer<Boolean>> onFocusChange, Optional<Boolean> autofocus, Optional<Clip> clipBehavior, Optional<WidgetI> icon, WidgetI label, Optional<IconAlignment> iconAlignment) {
    int id = factories.filledButtonTonalIcon(onPressed,
      onLongPress,
      onHover,
      onFocusChange,
      autofocus,
      clipBehavior,
      icon.map(WidgetI::build),
      label.build(),
      iconAlignment);
    if (id <= 0) throw new RuntimeException("Failed to created widget FilledButton");
    return new FilledButton(id);
  }
  public static FilledButtonTonalIconBuilder tonalIcon() {
    return FilledButtonTonalIconBuilder.filledButtonTonalIcon();
  }
  @Override
  public FilledButton build() {
    return this;
  }
}
