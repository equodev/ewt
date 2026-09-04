package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.ExpansionTileThemeObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class ExpansionTileTheme extends InheritedTheme implements ExpansionTileThemeI {
  private MemorySegment st;
  protected ExpansionTileTheme() {}
  ExpansionTileTheme(MemorySegment st) {
    this.id = ExpansionTileThemeObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget ExpansionTileTheme");
    System.out.println("New ExpansionTileTheme id:"+id);
  }
  ExpansionTileTheme(int id) { this.id = id; }
  @Override
  public ExpansionTileTheme build() {
    return this;
  }
}
