package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.MenuBarThemeObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class MenuBarTheme extends InheritedTheme implements MenuBarThemeI {
  private MemorySegment st;
  protected MenuBarTheme() {}
  MenuBarTheme(MemorySegment st) {
    this.id = MenuBarThemeObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget MenuBarTheme");
    System.out.println("New MenuBarTheme id:"+id);
  }
  MenuBarTheme(int id) { this.id = id; }
  @Override
  public MenuBarTheme build() {
    return this;
  }
}
