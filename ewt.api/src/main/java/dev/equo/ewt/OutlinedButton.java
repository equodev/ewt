package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.OutlinedButtonObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class OutlinedButton extends ButtonStyleButton implements OutlinedButtonI {
  private MemorySegment st;
  protected OutlinedButton() {}
  OutlinedButton(MemorySegment st) {
    this.id = OutlinedButtonObjSt.id(st);
    this.st = st;
    System.out.println("New OutlinedButton id:"+id);
  }
  @Builder.Factory
  static OutlinedButton outlinedButtonOutlinedButton(@Builder.Parameter Runnable onPressed, Optional<Runnable> onLongPress, Optional<Consumer<Boolean>> onHover, Optional<Consumer<Boolean>> onFocusChange, Optional<Boolean> autofocus, Optional<Clip> clipBehavior, WidgetI child) {
    var st = factories.outlinedButtonOutlinedButton(onPressed,
      onLongPress,
      onHover,
      onFocusChange,
      autofocus,
      clipBehavior,
      child.build());
    if (st == null) throw new RuntimeException("Failed to created widget OutlinedButton");
    return new OutlinedButton(st);
  }
  public static OutlinedButtonOutlinedButtonBuilder outlinedButton(Runnable onPressed) {
    return OutlinedButtonOutlinedButtonBuilder.outlinedButtonOutlinedButton(onPressed);
  }
  @Builder.Factory
  static OutlinedButton outlinedButtonIcon(@Builder.Parameter Runnable onPressed, Optional<Runnable> onLongPress, Optional<Consumer<Boolean>> onHover, Optional<Consumer<Boolean>> onFocusChange, Optional<Boolean> autofocus, Optional<Clip> clipBehavior, Optional<WidgetI> icon, WidgetI label, Optional<IconAlignment> iconAlignment) {
    var st = factories.outlinedButtonIcon(onPressed,
      onLongPress,
      onHover,
      onFocusChange,
      autofocus,
      clipBehavior,
      icon.map(WidgetI::build),
      label.build(),
      iconAlignment);
    if (st == null) throw new RuntimeException("Failed to created widget OutlinedButton");
    return new OutlinedButton(st);
  }
  public static OutlinedButtonIconBuilder icon(Runnable onPressed) {
    return OutlinedButtonIconBuilder.outlinedButtonIcon(onPressed);
  }
  @Override
  public OutlinedButton build() {
    return this;
  }
}
