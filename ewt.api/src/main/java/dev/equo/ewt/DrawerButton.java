package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.DrawerButtonObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class DrawerButton extends IconButton implements DrawerButtonI {
  private MemorySegment st;
  protected DrawerButton() {}
  DrawerButton(MemorySegment st) {
    this.id = DrawerButtonObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget DrawerButton");
    System.out.println("New DrawerButton id:"+id);
  }
  DrawerButton(int id) { this.id = id; }
  @Builder.Factory
  static DrawerButton drawerButtonDrawerButton(Optional<ColorI> color, Optional<Runnable> onPressed) {
    var st = factories.drawerButtonDrawerButton(color.map(ColorI::build),
      onPressed);
    if (st == null) throw new RuntimeException("Failed to created widget DrawerButton");
    return new DrawerButton(st);
  }
  public static DrawerButtonDrawerButtonBuilder drawerButton() {
    return DrawerButtonDrawerButtonBuilder.drawerButtonDrawerButton();
  }
  @Override
  public DrawerButton build() {
    return this;
  }
}
