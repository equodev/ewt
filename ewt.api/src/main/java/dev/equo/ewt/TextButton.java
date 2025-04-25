package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.TextButtonObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class TextButton extends ButtonStyleButton implements TextButtonI {
  private MemorySegment st;
  protected TextButton() {}
  TextButton(MemorySegment st) {
    this.id = TextButtonObjSt.id(st);
    this.st = st;
    System.out.println("New TextButton id:"+id);
  }
  @Builder.Factory
  static TextButton textButtonTextButton(@Builder.Parameter Runnable onPressed, Optional<Runnable> onLongPress, Optional<Consumer<Boolean>> onHover, Optional<Consumer<Boolean>> onFocusChange, Optional<Boolean> autofocus, Optional<Clip> clipBehavior, Optional<Boolean> isSemanticButton, WidgetI child) {
    var st = factories.textButtonTextButton(onPressed,
      onLongPress,
      onHover,
      onFocusChange,
      autofocus,
      clipBehavior,
      isSemanticButton,
      child.build());
    if (st == null) throw new RuntimeException("Failed to created widget TextButton");
    return new TextButton(st);
  }
  public static TextButtonTextButtonBuilder textButton(Runnable onPressed) {
    return TextButtonTextButtonBuilder.textButtonTextButton(onPressed);
  }
  @Builder.Factory
  static TextButton textButtonIcon(@Builder.Parameter Runnable onPressed, Optional<Runnable> onLongPress, Optional<Consumer<Boolean>> onHover, Optional<Consumer<Boolean>> onFocusChange, Optional<Boolean> autofocus, Optional<Clip> clipBehavior, Optional<WidgetI> icon, WidgetI label, Optional<IconAlignment> iconAlignment) {
    var st = factories.textButtonIcon(onPressed,
      onLongPress,
      onHover,
      onFocusChange,
      autofocus,
      clipBehavior,
      icon.map(WidgetI::build),
      label.build(),
      iconAlignment);
    if (st == null) throw new RuntimeException("Failed to created widget TextButton");
    return new TextButton(st);
  }
  public static TextButtonIconBuilder icon(Runnable onPressed) {
    return TextButtonIconBuilder.textButtonIcon(onPressed);
  }
  @Override
  public TextButton build() {
    return this;
  }
}
