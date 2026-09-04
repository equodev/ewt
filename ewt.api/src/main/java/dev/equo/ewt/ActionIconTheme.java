package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.ActionIconThemeObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class ActionIconTheme extends InheritedTheme implements ActionIconThemeI {
  private MemorySegment st;
  protected ActionIconTheme() {}
  ActionIconTheme(MemorySegment st) {
    this.id = ActionIconThemeObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget ActionIconTheme");
    System.out.println("New ActionIconTheme id:"+id);
  }
  ActionIconTheme(int id) { this.id = id; }
  @Override
  public ActionIconTheme build() {
    return this;
  }
}
