package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.MenuThemeObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class MenuTheme extends InheritedTheme implements MenuThemeI {
  private MemorySegment st;
  protected MenuTheme() {}
  MenuTheme(MemorySegment st) {
    this.id = MenuThemeObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget MenuTheme");
    System.out.println("New MenuTheme id:"+id);
  }
  MenuTheme(int id) { this.id = id; }
  @Override
  public MenuTheme build() {
    return this;
  }
}
