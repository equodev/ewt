package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.ChipThemeObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class ChipTheme extends InheritedTheme implements ChipThemeI {
  private MemorySegment st;
  protected ChipTheme() {}
  ChipTheme(MemorySegment st) {
    this.id = ChipThemeObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget ChipTheme");
    System.out.println("New ChipTheme id:"+id);
  }
  ChipTheme(int id) { this.id = id; }
  @Override
  public ChipTheme build() {
    return this;
  }
}
