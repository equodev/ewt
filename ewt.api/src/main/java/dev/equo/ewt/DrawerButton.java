package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class DrawerButton extends IconButton implements DrawerButtonI {
  protected DrawerButton() {}
  DrawerButton(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget DrawerButton");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static DrawerButton drawerButtonDrawerButton(Optional<ColorI> color, Optional<Runnable> onPressed) {
    int id = factories.drawerButtonDrawerButton(color.map(ColorI::build),
      onPressed);
    if (id <= 0) throw new RuntimeException("Failed to created widget DrawerButton");
    return new DrawerButton(id);
  }
  public static DrawerButtonDrawerButtonBuilder drawerButton() {
    return DrawerButtonDrawerButtonBuilder.drawerButtonDrawerButton();
  }
  @Override
  public DrawerButton build() {
    return this;
  }
}
