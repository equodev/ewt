package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.NavigationDrawerThemeObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class NavigationDrawerTheme extends InheritedTheme implements NavigationDrawerThemeI {
  private MemorySegment st;
  protected NavigationDrawerTheme() {}
  NavigationDrawerTheme(MemorySegment st) {
    this.id = NavigationDrawerThemeObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget NavigationDrawerTheme");
    System.out.println("New NavigationDrawerTheme id:"+id);
  }
  NavigationDrawerTheme(int id) { this.id = id; }
  @Override
  public NavigationDrawerTheme build() {
    return this;
  }
}
