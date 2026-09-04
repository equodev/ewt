package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.DrawerThemeObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class DrawerTheme extends InheritedTheme implements DrawerThemeI {
  private MemorySegment st;
  protected DrawerTheme() {}
  DrawerTheme(MemorySegment st) {
    this.id = DrawerThemeObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget DrawerTheme");
    System.out.println("New DrawerTheme id:"+id);
  }
  DrawerTheme(int id) { this.id = id; }
  @Override
  public DrawerTheme build() {
    return this;
  }
}
