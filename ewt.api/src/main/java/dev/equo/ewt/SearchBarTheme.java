package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.SearchBarThemeObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class SearchBarTheme extends InheritedWidget implements SearchBarThemeI {
  private MemorySegment st;
  protected SearchBarTheme() {}
  SearchBarTheme(MemorySegment st) {
    this.id = SearchBarThemeObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget SearchBarTheme");
    System.out.println("New SearchBarTheme id:"+id);
  }
  SearchBarTheme(int id) { this.id = id; }
  @Override
  public SearchBarTheme build() {
    return this;
  }
}
