package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.ToggleButtonsThemeObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class ToggleButtonsTheme extends InheritedTheme implements ToggleButtonsThemeI {
  private MemorySegment st;
  protected ToggleButtonsTheme() {}
  ToggleButtonsTheme(MemorySegment st) {
    this.id = ToggleButtonsThemeObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget ToggleButtonsTheme");
    System.out.println("New ToggleButtonsTheme id:"+id);
  }
  ToggleButtonsTheme(int id) { this.id = id; }
  @Override
  public ToggleButtonsTheme build() {
    return this;
  }
}
