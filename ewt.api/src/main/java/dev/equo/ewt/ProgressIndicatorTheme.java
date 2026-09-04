package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.ProgressIndicatorThemeObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class ProgressIndicatorTheme extends InheritedTheme implements ProgressIndicatorThemeI {
  private MemorySegment st;
  protected ProgressIndicatorTheme() {}
  ProgressIndicatorTheme(MemorySegment st) {
    this.id = ProgressIndicatorThemeObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget ProgressIndicatorTheme");
    System.out.println("New ProgressIndicatorTheme id:"+id);
  }
  ProgressIndicatorTheme(int id) { this.id = id; }
  @Override
  public ProgressIndicatorTheme build() {
    return this;
  }
}
