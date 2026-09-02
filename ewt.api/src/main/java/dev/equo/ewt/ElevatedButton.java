package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.ElevatedButtonObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class ElevatedButton extends ButtonStyleButton implements ElevatedButtonI {
  private MemorySegment st;
  protected ElevatedButton() {}
  ElevatedButton(MemorySegment st) {
    this.id = ElevatedButtonObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget ElevatedButton");
    System.out.println("New ElevatedButton id:"+id);
  }
  ElevatedButton(int id) { this.id = id; }
  @Builder.Factory
  static ElevatedButton elevatedButtonElevatedButton(Optional<Runnable> onPressed, Optional<Runnable> onLongPress, Optional<Consumer<Boolean>> onHover, Optional<Consumer<Boolean>> onFocusChange, Optional<Boolean> autofocus, Optional<Clip> clipBehavior, Optional<WidgetI> child) {
    var st = factories.elevatedButtonElevatedButton(onPressed,
      onLongPress,
      onHover,
      onFocusChange,
      autofocus,
      clipBehavior,
      child.map(WidgetI::build));
    if (st == null) throw new RuntimeException("Failed to created widget ElevatedButton");
    return new ElevatedButton(st);
  }
  public static ElevatedButtonElevatedButtonBuilder elevatedButton() {
    return ElevatedButtonElevatedButtonBuilder.elevatedButtonElevatedButton();
  }
  @Builder.Factory
  static ElevatedButton elevatedButtonIcon(Optional<Runnable> onPressed, Optional<Runnable> onLongPress, Optional<Consumer<Boolean>> onHover, Optional<Consumer<Boolean>> onFocusChange, Optional<Boolean> autofocus, Optional<Clip> clipBehavior, Optional<WidgetI> icon, WidgetI label, Optional<IconAlignment> iconAlignment) {
    var st = factories.elevatedButtonIcon(onPressed,
      onLongPress,
      onHover,
      onFocusChange,
      autofocus,
      clipBehavior,
      icon.map(WidgetI::build),
      label.build(),
      iconAlignment);
    if (st == null) throw new RuntimeException("Failed to created widget ElevatedButton");
    return new ElevatedButton(st);
  }
  public static ElevatedButtonIconBuilder icon() {
    return ElevatedButtonIconBuilder.elevatedButtonIcon();
  }
  @Override
  public ElevatedButton build() {
    return this;
  }
}
