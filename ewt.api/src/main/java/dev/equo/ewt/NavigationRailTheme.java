package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.NavigationRailThemeObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class NavigationRailTheme extends InheritedTheme implements NavigationRailThemeI {
  private MemorySegment st;
  protected NavigationRailTheme() {}
  NavigationRailTheme(MemorySegment st) {
    this.id = NavigationRailThemeObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget NavigationRailTheme");
    System.out.println("New NavigationRailTheme id:"+id);
  }
  NavigationRailTheme(int id) { this.id = id; }
  @Override
  public NavigationRailTheme build() {
    return this;
  }
}
