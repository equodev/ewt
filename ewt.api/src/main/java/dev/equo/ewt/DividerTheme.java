package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.DividerThemeObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class DividerTheme extends InheritedTheme implements DividerThemeI {
  private MemorySegment st;
  protected DividerTheme() {}
  DividerTheme(MemorySegment st) {
    this.id = DividerThemeObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget DividerTheme");
    System.out.println("New DividerTheme id:"+id);
  }
  DividerTheme(int id) { this.id = id; }
  @Override
  public DividerTheme build() {
    return this;
  }
}
