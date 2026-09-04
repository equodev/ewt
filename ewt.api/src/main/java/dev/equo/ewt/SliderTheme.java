package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.SliderThemeObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class SliderTheme extends InheritedTheme implements SliderThemeI {
  private MemorySegment st;
  protected SliderTheme() {}
  SliderTheme(MemorySegment st) {
    this.id = SliderThemeObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget SliderTheme");
    System.out.println("New SliderTheme id:"+id);
  }
  SliderTheme(int id) { this.id = id; }
  @Override
  public SliderTheme build() {
    return this;
  }
}
