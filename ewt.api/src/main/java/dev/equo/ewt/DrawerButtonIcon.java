package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
public class DrawerButtonIcon extends StatelessWidget implements DrawerButtonIconI {
  protected DrawerButtonIcon() {}
  DrawerButtonIcon(int id) {
    this.id = id;
    if (id <= 0) throw new RuntimeException("Failed to created widget DrawerButtonIcon");
    this.nativeStruct = factories.takeLastStruct();
  }
  @Builder.Factory
  static DrawerButtonIcon drawerButtonIconDrawerButtonIcon() {
    int id = factories.drawerButtonIconDrawerButtonIcon();
    if (id <= 0) throw new RuntimeException("Failed to created widget DrawerButtonIcon");
    return new DrawerButtonIcon(id);
  }
  public static DrawerButtonIconDrawerButtonIconBuilder drawerButtonIcon() {
    return DrawerButtonIconDrawerButtonIconBuilder.drawerButtonIconDrawerButtonIcon();
  }
  @Override
  public DrawerButtonIcon build() {
    return this;
  }
}
