package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.TooltipThemeObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class TooltipTheme extends InheritedTheme implements TooltipThemeI {
  private MemorySegment st;
  protected TooltipTheme() {}
  TooltipTheme(MemorySegment st) {
    this.id = TooltipThemeObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget TooltipTheme");
    System.out.println("New TooltipTheme id:"+id);
  }
  TooltipTheme(int id) { this.id = id; }
  @Override
  public TooltipTheme build() {
    return this;
  }
}
