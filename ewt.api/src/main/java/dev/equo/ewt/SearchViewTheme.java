package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.SearchViewThemeObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class SearchViewTheme extends InheritedTheme implements SearchViewThemeI {
  private MemorySegment st;
  protected SearchViewTheme() {}
  SearchViewTheme(MemorySegment st) {
    this.id = SearchViewThemeObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget SearchViewTheme");
    System.out.println("New SearchViewTheme id:"+id);
  }
  SearchViewTheme(int id) { this.id = id; }
  @Override
  public SearchViewTheme build() {
    return this;
  }
}
