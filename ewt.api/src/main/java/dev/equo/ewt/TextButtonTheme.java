package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.TextButtonThemeObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class TextButtonTheme extends InheritedTheme implements TextButtonThemeI {
  private MemorySegment st;
  protected TextButtonTheme() {}
  TextButtonTheme(MemorySegment st) {
    this.id = TextButtonThemeObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget TextButtonTheme");
    System.out.println("New TextButtonTheme id:"+id);
  }
  TextButtonTheme(int id) { this.id = id; }
  @Override
  public TextButtonTheme build() {
    return this;
  }
}
