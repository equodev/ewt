package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class ElevatedButton extends ButtonStyleButton implements ElevatedButtonI {
  protected ElevatedButton() {}
  ElevatedButton(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget ElevatedButton");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static ElevatedButton elevatedButtonElevatedButton(Optional<Runnable> onPressed, Optional<Runnable> onLongPress, Optional<Consumer<Boolean>> onHover, Optional<Consumer<Boolean>> onFocusChange, Optional<Boolean> autofocus, Optional<Clip> clipBehavior, Optional<WidgetI> child) {
    int id = factories.elevatedButtonElevatedButton(onPressed,
      onLongPress,
      onHover,
      onFocusChange,
      autofocus,
      clipBehavior,
      child.map(WidgetI::build));
    if (id <= 0) throw new RuntimeException("Failed to created widget ElevatedButton");
    return new ElevatedButton(id);
  }
  public static ElevatedButtonElevatedButtonBuilder elevatedButton() {
    return ElevatedButtonElevatedButtonBuilder.elevatedButtonElevatedButton();
  }
  @Builder.Factory
  static ElevatedButton elevatedButtonIcon(Optional<Runnable> onPressed, Optional<Runnable> onLongPress, Optional<Consumer<Boolean>> onHover, Optional<Consumer<Boolean>> onFocusChange, Optional<Boolean> autofocus, Optional<Clip> clipBehavior, Optional<WidgetI> icon, WidgetI label, Optional<IconAlignment> iconAlignment) {
    int id = factories.elevatedButtonIcon(onPressed,
      onLongPress,
      onHover,
      onFocusChange,
      autofocus,
      clipBehavior,
      icon.map(WidgetI::build),
      label.build(),
      iconAlignment);
    if (id <= 0) throw new RuntimeException("Failed to created widget ElevatedButton");
    return new ElevatedButton(id);
  }
  public static ElevatedButtonIconBuilder icon() {
    return ElevatedButtonIconBuilder.elevatedButtonIcon();
  }
  @Override
  public ElevatedButton build() {
    return this;
  }
}
