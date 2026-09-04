package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.ElevatedButtonThemeObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class ElevatedButtonTheme extends InheritedTheme implements ElevatedButtonThemeI {
  private MemorySegment st;
  protected ElevatedButtonTheme() {}
  ElevatedButtonTheme(MemorySegment st) {
    this.id = ElevatedButtonThemeObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget ElevatedButtonTheme");
    System.out.println("New ElevatedButtonTheme id:"+id);
  }
  ElevatedButtonTheme(int id) { this.id = id; }
  @Override
  public ElevatedButtonTheme build() {
    return this;
  }
}
