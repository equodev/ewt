package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.RadioThemeObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class RadioTheme extends InheritedWidget implements RadioThemeI {
  private MemorySegment st;
  protected RadioTheme() {}
  RadioTheme(MemorySegment st) {
    this.id = RadioThemeObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget RadioTheme");
    System.out.println("New RadioTheme id:"+id);
  }
  RadioTheme(int id) { this.id = id; }
  @Override
  public RadioTheme build() {
    return this;
  }
}
