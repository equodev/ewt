package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.DropdownMenuThemeObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class DropdownMenuTheme extends InheritedTheme implements DropdownMenuThemeI {
  private MemorySegment st;
  protected DropdownMenuTheme() {}
  DropdownMenuTheme(MemorySegment st) {
    this.id = DropdownMenuThemeObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget DropdownMenuTheme");
    System.out.println("New DropdownMenuTheme id:"+id);
  }
  DropdownMenuTheme(int id) { this.id = id; }
  @Override
  public DropdownMenuTheme build() {
    return this;
  }
}
