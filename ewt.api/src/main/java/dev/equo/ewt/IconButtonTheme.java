package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.IconButtonThemeObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class IconButtonTheme extends InheritedTheme implements IconButtonThemeI {
  private MemorySegment st;
  protected IconButtonTheme() {}
  IconButtonTheme(MemorySegment st) {
    this.id = IconButtonThemeObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget IconButtonTheme");
    System.out.println("New IconButtonTheme id:"+id);
  }
  IconButtonTheme(int id) { this.id = id; }
  @Override
  public IconButtonTheme build() {
    return this;
  }
}
