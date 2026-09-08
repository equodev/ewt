package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.DrawerButtonIconObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class DrawerButtonIcon extends StatelessWidget implements DrawerButtonIconI {
  private MemorySegment st;
  protected DrawerButtonIcon() {}
  DrawerButtonIcon(MemorySegment st) {
    this.id = DrawerButtonIconObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget DrawerButtonIcon");
    System.out.println("New DrawerButtonIcon id:"+id);
  }
  DrawerButtonIcon(int id) { this.id = id; }
  @Builder.Factory
  static DrawerButtonIcon drawerButtonIconDrawerButtonIcon() {
    var st = factories.drawerButtonIconDrawerButtonIcon();
    if (st == null) throw new RuntimeException("Failed to created widget DrawerButtonIcon");
    return new DrawerButtonIcon(st);
  }
  public static DrawerButtonIconDrawerButtonIconBuilder drawerButtonIcon() {
    return DrawerButtonIconDrawerButtonIconBuilder.drawerButtonIconDrawerButtonIcon();
  }
  @Override
  public DrawerButtonIcon build() {
    return this;
  }
}
