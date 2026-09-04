package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.SwitchThemeObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class SwitchTheme extends InheritedWidget implements SwitchThemeI {
  private MemorySegment st;
  protected SwitchTheme() {}
  SwitchTheme(MemorySegment st) {
    this.id = SwitchThemeObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget SwitchTheme");
    System.out.println("New SwitchTheme id:"+id);
  }
  SwitchTheme(int id) { this.id = id; }
  @Override
  public SwitchTheme build() {
    return this;
  }
}
