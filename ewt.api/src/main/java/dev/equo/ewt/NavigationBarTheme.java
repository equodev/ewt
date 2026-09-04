package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.NavigationBarThemeObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class NavigationBarTheme extends InheritedTheme implements NavigationBarThemeI {
  private MemorySegment st;
  protected NavigationBarTheme() {}
  NavigationBarTheme(MemorySegment st) {
    this.id = NavigationBarThemeObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget NavigationBarTheme");
    System.out.println("New NavigationBarTheme id:"+id);
  }
  NavigationBarTheme(int id) { this.id = id; }
  @Override
  public NavigationBarTheme build() {
    return this;
  }
}
