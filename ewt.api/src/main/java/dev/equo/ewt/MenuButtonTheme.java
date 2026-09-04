package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.MenuButtonThemeObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class MenuButtonTheme extends InheritedTheme implements MenuButtonThemeI {
  private MemorySegment st;
  protected MenuButtonTheme() {}
  MenuButtonTheme(MemorySegment st) {
    this.id = MenuButtonThemeObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget MenuButtonTheme");
    System.out.println("New MenuButtonTheme id:"+id);
  }
  MenuButtonTheme(int id) { this.id = id; }
  @Override
  public MenuButtonTheme build() {
    return this;
  }
}
