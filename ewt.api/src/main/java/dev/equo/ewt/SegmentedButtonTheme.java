package dev.equo.ewt;
import java.util.*;
import java.util.function.*;
import dev.equo.ewt.util.*;
import org.immutables.builder.Builder;
import java.lang.foreign.MemorySegment;
import dev.equo.ewt.ffm.SegmentedButtonThemeObjSt;
import static dev.equo.ewt.WidgetConstructorsBase.*;
public class SegmentedButtonTheme extends InheritedTheme implements SegmentedButtonThemeI {
  private MemorySegment st;
  protected SegmentedButtonTheme() {}
  SegmentedButtonTheme(MemorySegment st) {
    this.id = SegmentedButtonThemeObjSt.id(st);
    this.st = st;
    if (id <= 0) throw new RuntimeException("Failed to created widget SegmentedButtonTheme");
    System.out.println("New SegmentedButtonTheme id:"+id);
  }
  SegmentedButtonTheme(int id) { this.id = id; }
  @Override
  public SegmentedButtonTheme build() {
    return this;
  }
}
