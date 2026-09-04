package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.CheckboxThemeObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class CheckboxTheme extends InheritedWidget implements CheckboxThemeI {
  private MemorySegment st;
  protected CheckboxTheme() {}
  CheckboxTheme(MemorySegment st) {
    this.id = CheckboxThemeObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget CheckboxTheme");
    System.out.println("New CheckboxTheme id:"+id);
  }
  CheckboxTheme(int id) { this.id = id; }
  @Override
  public CheckboxTheme build() {
    return this;
  }
}
