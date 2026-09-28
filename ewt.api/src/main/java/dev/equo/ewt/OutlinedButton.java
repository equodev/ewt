package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class OutlinedButton extends ButtonStyleButton implements OutlinedButtonI {
  protected OutlinedButton() {}
  OutlinedButton(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget OutlinedButton");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static OutlinedButton outlinedButtonOutlinedButton(Optional<Runnable> onPressed, Optional<Runnable> onLongPress, Optional<Consumer<Boolean>> onHover, Optional<Consumer<Boolean>> onFocusChange, Optional<Boolean> autofocus, Optional<Clip> clipBehavior, Optional<WidgetI> child) {
    int id = factories.outlinedButtonOutlinedButton(onPressed,
      onLongPress,
      onHover,
      onFocusChange,
      autofocus,
      clipBehavior,
      child.map(WidgetI::build));
    if (id <= 0) throw new RuntimeException("Failed to created widget OutlinedButton");
    return new OutlinedButton(id);
  }
  public static OutlinedButtonOutlinedButtonBuilder outlinedButton() {
    return OutlinedButtonOutlinedButtonBuilder.outlinedButtonOutlinedButton();
  }
  @Builder.Factory
  static OutlinedButton outlinedButtonIcon(Optional<Runnable> onPressed, Optional<Runnable> onLongPress, Optional<Consumer<Boolean>> onHover, Optional<Consumer<Boolean>> onFocusChange, Optional<Boolean> autofocus, Optional<Clip> clipBehavior, Optional<WidgetI> icon, WidgetI label, Optional<IconAlignment> iconAlignment) {
    int id = factories.outlinedButtonIcon(onPressed,
      onLongPress,
      onHover,
      onFocusChange,
      autofocus,
      clipBehavior,
      icon.map(WidgetI::build),
      label.build(),
      iconAlignment);
    if (id <= 0) throw new RuntimeException("Failed to created widget OutlinedButton");
    return new OutlinedButton(id);
  }
  public static OutlinedButtonIconBuilder icon() {
    return OutlinedButtonIconBuilder.outlinedButtonIcon();
  }
  @Override
  public OutlinedButton build() {
    return this;
  }
}
