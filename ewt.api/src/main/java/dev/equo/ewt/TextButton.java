package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class TextButton extends ButtonStyleButton implements TextButtonI {
  protected TextButton() {}
  TextButton(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget TextButton");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static TextButton textButtonTextButton(Optional<Runnable> onPressed, Optional<Runnable> onLongPress, Optional<Consumer<Boolean>> onHover, Optional<Consumer<Boolean>> onFocusChange, Optional<Boolean> autofocus, Optional<Clip> clipBehavior, Optional<Boolean> isSemanticButton, WidgetI child) {
    int id = factories.textButtonTextButton(onPressed,
      onLongPress,
      onHover,
      onFocusChange,
      autofocus,
      clipBehavior,
      isSemanticButton,
      child.build());
    if (id <= 0) throw new RuntimeException("Failed to created widget TextButton");
    return new TextButton(id);
  }
  public static TextButtonTextButtonBuilder textButton() {
    return TextButtonTextButtonBuilder.textButtonTextButton();
  }
  @Builder.Factory
  static TextButton textButtonIcon(Optional<Runnable> onPressed, Optional<Runnable> onLongPress, Optional<Consumer<Boolean>> onHover, Optional<Consumer<Boolean>> onFocusChange, Optional<Boolean> autofocus, Optional<Clip> clipBehavior, Optional<WidgetI> icon, WidgetI label, Optional<IconAlignment> iconAlignment) {
    int id = factories.textButtonIcon(onPressed,
      onLongPress,
      onHover,
      onFocusChange,
      autofocus,
      clipBehavior,
      icon.map(WidgetI::build),
      label.build(),
      iconAlignment);
    if (id <= 0) throw new RuntimeException("Failed to created widget TextButton");
    return new TextButton(id);
  }
  public static TextButtonIconBuilder icon() {
    return TextButtonIconBuilder.textButtonIcon();
  }
  @Override
  public TextButton build() {
    return this;
  }
}
