package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.BottomNavigationBarThemeObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class BottomNavigationBarTheme extends InheritedWidget implements BottomNavigationBarThemeI {
  private MemorySegment st;
  protected BottomNavigationBarTheme() {}
  BottomNavigationBarTheme(MemorySegment st) {
    this.id = BottomNavigationBarThemeObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget BottomNavigationBarTheme");
    System.out.println("New BottomNavigationBarTheme id:"+id);
  }
  BottomNavigationBarTheme(int id) { this.id = id; }
  @Override
  public BottomNavigationBarTheme build() {
    return this;
  }
}
