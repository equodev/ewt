package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.PopupMenuThemeObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class PopupMenuTheme extends InheritedTheme implements PopupMenuThemeI {
  private MemorySegment st;
  protected PopupMenuTheme() {}
  PopupMenuTheme(MemorySegment st) {
    this.id = PopupMenuThemeObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget PopupMenuTheme");
    System.out.println("New PopupMenuTheme id:"+id);
  }
  PopupMenuTheme(int id) { this.id = id; }
  @Override
  public PopupMenuTheme build() {
    return this;
  }
}
