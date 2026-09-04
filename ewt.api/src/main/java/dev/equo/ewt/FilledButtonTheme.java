package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.FilledButtonThemeObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class FilledButtonTheme extends InheritedTheme implements FilledButtonThemeI {
  private MemorySegment st;
  protected FilledButtonTheme() {}
  FilledButtonTheme(MemorySegment st) {
    this.id = FilledButtonThemeObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget FilledButtonTheme");
    System.out.println("New FilledButtonTheme id:"+id);
  }
  FilledButtonTheme(int id) { this.id = id; }
  @Override
  public FilledButtonTheme build() {
    return this;
  }
}
