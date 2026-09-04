package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.DataTableThemeObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class DataTableTheme extends InheritedWidget implements DataTableThemeI {
  private MemorySegment st;
  protected DataTableTheme() {}
  DataTableTheme(MemorySegment st) {
    this.id = DataTableThemeObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget DataTableTheme");
    System.out.println("New DataTableTheme id:"+id);
  }
  DataTableTheme(int id) { this.id = id; }
  @Override
  public DataTableTheme build() {
    return this;
  }
}
