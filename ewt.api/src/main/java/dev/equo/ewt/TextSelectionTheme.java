package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.TextSelectionThemeObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class TextSelectionTheme extends InheritedTheme implements TextSelectionThemeI {
  private MemorySegment st;
  protected TextSelectionTheme() {}
  TextSelectionTheme(MemorySegment st) {
    this.id = TextSelectionThemeObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget TextSelectionTheme");
    System.out.println("New TextSelectionTheme id:"+id);
  }
  TextSelectionTheme(int id) { this.id = id; }
  @Override
  public TextSelectionTheme build() {
    return this;
  }
}
