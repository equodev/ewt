package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.OutlinedButtonThemeObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class OutlinedButtonTheme extends InheritedTheme implements OutlinedButtonThemeI {
  private MemorySegment st;
  protected OutlinedButtonTheme() {}
  OutlinedButtonTheme(MemorySegment st) {
    this.id = OutlinedButtonThemeObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget OutlinedButtonTheme");
    System.out.println("New OutlinedButtonTheme id:"+id);
  }
  OutlinedButtonTheme(int id) { this.id = id; }
  @Override
  public OutlinedButtonTheme build() {
    return this;
  }
}
