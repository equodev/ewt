package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.BadgeThemeObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class BadgeTheme extends InheritedTheme implements BadgeThemeI {
  private MemorySegment st;
  protected BadgeTheme() {}
  BadgeTheme(MemorySegment st) {
    this.id = BadgeThemeObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget BadgeTheme");
    System.out.println("New BadgeTheme id:"+id);
  }
  BadgeTheme(int id) { this.id = id; }
  @Override
  public BadgeTheme build() {
    return this;
  }
}
