package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.IconThemeObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class IconTheme extends InheritedTheme implements IconThemeI {
  private MemorySegment st;
  protected IconTheme() {}
  IconTheme(MemorySegment st) {
    this.id = IconThemeObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget IconTheme");
    System.out.println("New IconTheme id:"+id);
  }
  IconTheme(int id) { this.id = id; }
  @Override
  public IconTheme build() {
    return this;
  }
}
